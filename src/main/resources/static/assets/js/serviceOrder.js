_selectedRow = null;

async  function send()
{
   if ( simpleValidation() )
   {
       fieldId = document.getElementById("soId");
        fieldTitle = document.getElementById("fieldTitle");
        fieldDesc = document.getElementById("fieldDesc");
        fieldEndDate = document.getElementById("fieldEndDate");
        fieldCustomer = document.getElementById("fieldCustomer");
        soValue = document.getElementById("soValue");
        fieldStartDate = document.getElementById("fieldStartDate");
        fieldpayment = document.getElementById("fieldpayment");

        disable = document.getElementById("disable");

        values = {}

        if (  fieldId.value.length > 0 )
        {
            values.id = fieldId.value
        }
        values.title = fieldTitle.value;
        values.description = fieldDesc.value;
        values.serviceEndDate = fieldEndDate.value;
        values.userId = fieldCustomer.value;
        values.soValue = soValue.value;
        values.paymentId = fieldpayment.value;
        values.state = disable.value.length > 0 ? true : false;

        const Http = new XMLHttpRequest();
        Http.open(fieldId.value > 0 ?  "PUT" : "POST", 'http://localhost:8080/api/os');

        Http.setRequestHeader("Content-Type", "application/json");

        Http.onreadystatechange = function () {
            if ( this.readyState == 4 ) {
                if ( this.status == 200 || this.status == 201 )
                {
                    let teste = JSON.parse(Http.responseText);
                    fieldId.value = teste.id;
                    fieldTitle.value = teste.title;
                    fieldDesc.value = teste.description;
                    fieldStartDate.value = teste.serviceDate;
                    fieldEndDate.value = teste.serviceEndDate;
                    fieldCustomer.value = teste.userId;
                    fieldpayment.value = teste.paymentId;
                    soValue.value = teste.soValue;

                    alert('Ordem salva com sucesso!')
                }

                else if (this.status == 500) {
                    alert(JSON.parse(this.responseText).message);
                }
            }
        }

        Http.send( JSON.stringify(values) );
   }
}

search = function () {
    filterTitle = document.getElementById("filterTitle")
    filterStartDate = document.getElementById("filterStartDate")
    filterEndDate = document.getElementById("filterEndDate")
    filterCustomer = document.getElementById("filterCustomer")
    filterClosed = document.getElementById("filterClosed")

    const Http = new XMLHttpRequest();
    Http.open("GET", '/api/os/getAll?filterTitle=' + filterTitle.value +
        '&startDate=' + filterStartDate.value +
        '&endDate=' + filterEndDate.value +
        '&customer=' + filterCustomer.value +
        '&closed=' + filterClosed.checked );

    Http.send();

    Http.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var os = JSON.parse(Http.responseText);

            var table = document.getElementById('dataTable').getElementsByTagName('tbody')[0];

            table.innerHTML = "";

            for (i = 0; i < os.length; i++) {
                var row = table.insertRow(i);

                row.innerHTML = "<td>" + os[i].id + "</td>" +
                    "<td>" + os[i].title + "</td>" +
                    "<td>" + os[i].serviceDate + "</td>" +
                    "<td>" + os[i].serviceEndDate + "</td>" +
                    "<td>" + os[i].userId + "</td>" +
                    "<td>" + os[i].paymentId + "</td>" +
                    "<td>" + os[i].soValue + "</td>" +
                    "<td>" + ( (os[i].state) ? "Sim" : "Não" ) + "</td>";


                row.value = os[i];

                row.onclick = function () {

                    if ( _selectedRow != null )
                    {
                        _selectedRow.classList.remove("selected");
                    }

                    this.classList.add( "selected" );

                    _selectedRow = this;
                }
            }
        }
    }
}

function getUser()
{
    fieldId = document.getElementById("fieldCustomer");

    const Http = new XMLHttpRequest();
    Http.open("GET", '/api/customer/' + fieldId.value );

    Http.send();

    Http.onreadystatechange = function ()
    {
        if ( this.readyState == 4 && this.status == 200 )
        {
            fieldName = document.getElementById("fieldCustomerName");
            var customer = JSON.parse(Http.responseText);
            fieldName.value =  customer.name;
        }

        else if ( this.readyState == 4 && this.status == 404 )
        {
            alert( 'Usuário não encontrado!' )
        }
    }
}

function closeSo()
{
    fieldId = document.getElementById("soId");

    if ( fieldId.value.length > 0 && simpleValidation() )
    {
        fieldTitle = document.getElementById("fieldTitle");
        fieldDesc = document.getElementById("fieldDesc");
        fieldEndDate = document.getElementById("fieldEndDate");
        fieldpayment = document.getElementById("fieldpayment");
        disable = document.getElementById("disable");
        customerId = document.getElementById("fieldCustomer");

        disable.value = true;
        fieldTitle.disabled = true;
        fieldDesc.disabled = true;
        fieldEndDate.disabled = true;
        fieldpayment.disabled = true;
        customerId.disabled = true;

        send();
    }
}

function editOs()
{
    location.href='/addso/' + _selectedRow.value.id;
}

function addProducts()
{
    fieldEndDate = document.getElementById("fieldEndDate");

    if ( fieldEndDate.value.length > 0 )
    {
        alert('Ordem encerrada!');
    }

    else
    {
        location.href='/addProduct/' + document.getElementById("soId").value;
    }
}

window.addEventListener("load", (event) => {
   refresh();
});

function refresh()
{
    fieldId = document.getElementById("soId");

    const Http = new XMLHttpRequest();
    Http.open("GET", '/api/os/getSoById?orderId=' + fieldId.value );

    Http.send();

    Http.onreadystatechange = function ()
    {
        if ( this.readyState == 4 && this.status == 200 )
        {
            fieldTitle = document.getElementById("fieldTitle");
            fieldDesc = document.getElementById("fieldDesc");
            fieldEndDate = document.getElementById("fieldEndDate");
            fieldCustomer = document.getElementById("fieldCustomer");
            soValue = document.getElementById("soValue");
            fieldStartDate = document.getElementById("fieldStartDate");
            fieldpayment = document.getElementById("fieldpayment");

            var os = JSON.parse(Http.responseText);

            fieldTitle.value =  os.title;
            fieldDesc.value = os.description;
            fieldEndDate.value = os.serviceEndDate;
            fieldCustomer.value = os.userId;
            soValue.value = os.soValue;
            fieldStartDate.value = os.serviceDate;
            fieldpayment.value = os.paymentId;

            getUser();

            if ( os.serviceEndDate != null )
            {
                fieldTitle.disabled = true;
                fieldDesc.disabled = true;
                fieldEndDate.disabled = true;
                fieldpayment.disabled = true;
                fieldCustomer.disabled = true;
                customerId.disabled = true;
            }
        }

        else if ( this.readyState == 4 && this.status == 404 )
        {
            alert( this.responseText )
        }
    }
}

function simpleValidation()
{
    let valid = true;

    let fieldEndDate = document.getElementById("fieldEndDate");

    let fieldTitle = document.getElementById("fieldTitle").value;
    let fieldDesc = document.getElementById("fieldDesc").value;
    let  fieldCustomer = document.getElementById("fieldCustomer").value;
    let  fieldpayment = document.getElementById("fieldpayment").value;

    if ( fieldTitle.length == 0  || fieldTitle.length < 15 )
    {
        alert( 'Titulo invalido' )
        valid = false
    }

    else if ( fieldDesc.length == 0 || fieldDesc.length < 10 )
    {
        alert( 'Descrição invalida' );
        valid = false
    }

    else if (  fieldCustomer.length == 0 )
    {
        alert( 'Cliente inválido' );
        valid = false
    }

    else if (  fieldpayment.length == 0 || fieldpayment >= 3 )
    {
        alert( 'Pagamento inválido');

        valid = false
    }

    else if ( fieldEndDate.value.length > 0 )
    {
        alert('Ordem já está encerrada!');
        valid = false
    }

    return valid
}

function report()
{
    filterTitle = document.getElementById("filterTitle")
    filterStartDate = document.getElementById("filterStartDate")
    filterEndDate = document.getElementById("filterEndDate")
    filterCustomer = document.getElementById("filterCustomer")
    filterClosed = document.getElementById("filterClosed")

    window.open( '/api/os/report?filterTitle=' + filterTitle.value +
        '&startDate=' + filterStartDate.value +
        '&endDate=' + filterEndDate.value +
        '&customer=' + filterCustomer.value +
        '&closed=' + filterClosed.checked );
}
