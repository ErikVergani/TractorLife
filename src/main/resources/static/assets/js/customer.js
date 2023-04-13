_selectedRow = null;
async  function send()
    {
        fieldName = document.getElementById("fieldName");
        fieldCpf = document.getElementById("fieldCpf");
        fieldAddress = document.getElementById("fieldAddress");
        fieldPhone = document.getElementById("fieldPhone");
        fieldCity = document.getElementById("fieldCity");
        fieldEmail = document.getElementById("fieldEmail");
        fieldCredit = document.getElementById("fieldCredit");
        checkboxField = document.getElementById("checkboxEnable");

        idField =  document.getElementById("fieldId");

        values = {}

        if (  idField.value.length > 0 )
        {
            values.id = idField.value
        }
        values.name = fieldName.value;
        values.cpf = fieldCpf.value;
        values.address = fieldAddress.value;
        values.phoneNumber1 = fieldPhone.value;
        values.city = fieldCity.value;
        values.email = fieldEmail.value;
        values.balanceLimit = fieldCredit.value;
        values.enable = checkboxField.checked;
        values.role =  "CUSTOMER";

        fetch('http://localhost:8080/api/customer', {
            method:  (  idField.value.length > 0 ) ? "PUT" : "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify( values )
        })
            .then( function ( response){
                if ( response.status == 201 || response.status == 200 )
                {
                    alert( "Cliente salvo com sucesso!" )
                    document.getElementById("form").reset();
                    refresh();
                }

                else
                {
                   response.text().then( function (text){ alert( text ) } );
                }
            } )
            .catch( error =>  alert( error ) );

    }

    refresh = function () {
      cpfFilter = document.getElementById("filterCpf")
      nameFilter = document.getElementById("filterName")
      cityFilter = document.getElementById("filterCity")
      enableFilter = document.getElementById("filterEnable")

       const Http = new XMLHttpRequest();
       Http.open("GET", '/api/customer/getAll?cpf=' + cpfFilter.value +
           '&name=' + nameFilter.value +
           '&city=' + cityFilter.value +
           '&enable=' + enableFilter.checked );

       Http.send();

       Http.onreadystatechange = function () {
          if (this.readyState == 4 && this.status == 200) {
             var customers = JSON.parse(Http.responseText);

            var table = document.getElementById('dataTable').getElementsByTagName('tbody')[0];

             table.innerHTML = "";

             for (i = 0; i < customers.length; i++) {
                var row = table.insertRow(i);

                row.innerHTML = "<td>" + customers[i].id + "</td>" +
                    "<td>" + customers[i].name + "</td>" +
                    "<td>" + customers[i].cpf + "</td>" +
                    "<td>" + customers[i].address + "</td>" +
                    "<td>" + customers[i].phoneNumber1 + "</td>" +
                    "<td>" + customers[i].city + "</td>" +
                    "<td>" + customers[i].balanceLimit + "</td>" +
                    "<td>" + ( (customers[i].enable) ? "Sim" : "Não" ) + "</td>";


                row.value = customers[i];

                row.onclick = function () {
                    fieldId = document.getElementById("fieldId");
                   fieldName = document.getElementById("fieldName");
                   fieldCpf = document.getElementById("fieldCpf");
                   fieldAddress = document.getElementById("fieldAddress");
                   fieldPhone = document.getElementById("fieldPhone");
                   fieldCity = document.getElementById("fieldCity");
                   fieldEmail = document.getElementById("fieldEmail");
                   fieldCredit = document.getElementById("fieldCredit");
                   checkboxField = document.getElementById("checkboxEnable");

                   fieldId.value = this.value.id;
                   fieldName.value = this.value.name;
                   fieldCpf.value = this.value.cpf;
                   fieldAddress.value = this.value.address;
                   fieldPhone.value = this.value.phoneNumber1;
                   fieldCity.value = this.value.city;
                   fieldEmail.value = this.value.email;
                   fieldCredit.value = this.value.balanceLimit;
                   checkboxField.checked = this.value.enable;

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

    function report()
    {
        cpfFilter = document.getElementById("filterCpf")
        nameFilter = document.getElementById("filterName")
        cityFilter = document.getElementById("filterCity")
        enableFilter = document.getElementById("filterEnable")


        window.open( '/api/customer/report?cpf=' + cpfFilter.value +
                                                    '&name=' + nameFilter.value +
                                                    '&city=' + cityFilter.value +
                                                    '&enable=' + enableFilter.checked );

    }


function cpfMask( input )
{
    let inputLength = input.value.length
    let v = input.value;

    if ( inputLength == 3 || inputLength == 7 )
    {
        input.value += '.'
    }
    else if ( inputLength == 11 )
    {
        input.value += '-'
    }

    return input;
}

function mascaraTelefone( event ) {
    let tecla = event.key;
    let telefone = event.target.value.replace( /\D+/g, "" );

    if (/^[0-9]$/i.test( tecla ) ) {
        telefone = telefone + tecla;
        let tamanho = telefone.length;

        if ( tamanho >= 12 ) {
            return false;
        }

        if ( tamanho > 10 )
        {
            telefone = telefone.replace( /^(\d\d)(\d{5})(\d{4}).*/, "($1) $2-$3" );
        }

        else if ( tamanho > 5 )
        {
            telefone = telefone.replace( /^(\d\d)(\d{4})(\d{0,4}).*/, "($1) $2-$3" );
        }

        else if ( tamanho > 2 )
        {
            telefone = telefone.replace( /^(\d\d)(\d{0,5})/, "($1) $2" );
        }

        else
        {
            telefone = telefone.replace(/^(\d*)/, "($1");
        }

        event.target.value = telefone;
    }

    if ( !["Backspace", "Delete", "Tab"].includes( tecla ) ) {
        return false;
    }
}

function onlyNum( input )
{
    let tecla = event.key;
    let credit = event.target.value.replace( /\D+/g, "" );

    if (/^[0-9]$/i.test( tecla ) ) {
        credit += tecla;
        let tamanho = credit.length;

        if ( tamanho >= 6 ) {
            return false;
        }

        event.target.value = telefone;
    }

    if ( !["Backspace", "Delete", "Tab"].includes( tecla ) ) {
        return false;
    }
}
