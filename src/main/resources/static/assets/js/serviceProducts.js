_selectedRow = null;

search = function () {
    filterName = document.getElementById("filterName")
    filterCategory = document.getElementById("filterCategory")

    const Http = new XMLHttpRequest();
    Http.open("GET", '/api/products/getAll?name=' + filterName.value +
        '&categoryId=' + filterCategory.value );

    Http.send();

    Http.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var product = JSON.parse(Http.responseText);

            var table = document.getElementById('products').getElementsByTagName('tbody')[0];

            table.innerHTML = "";

            for (i = 0; i < product.length; i++) {
                var row = table.insertRow(i);

                row.innerHTML = "<td>" + product[i].id + "</td>" +
                    "<td>" + product[i].name + "</td>" +
                    "<td>" + product[i].categoryId + "</td>" +
                    "<td>" + product[i].sellPrice + "</td>" +
                    "<td>" + product[i].qtyStock + "</td>"

                row.value = product[i];

                row.onclick = function () {

                    if ( _selectedRow != null )
                    {
                        _selectedRow.classList.remove("selected");
                    }

                    document.getElementById('pName').value  = this.value.name;
                    document.getElementById('pCategory').value = this.value.categoryId;
                    document.getElementById('pValue').value  = this.value.sellPrice;
                    document.getElementById('productId').value  = this.value.id;

                    this.classList.add( "selected" );

                    _selectedRow = this;
                }
            }
        }
    }
}

async function addProduct()
{
    if ( canAdd() )
    {
        var pId = document.getElementById("pId").value;

        var soId = document.getElementById('soId').value;
        var productId =  document.getElementById('productId').value;
        var qtde = document.getElementById('qtde').value;
        var price = document.getElementById('pValue').value;
        var total = qtde * price;

        values = {}

        if ( pId.length > 0 )
        {
            values.id = pId;
        }
        values.serviceOrderId = soId;
        values.productId = productId;
        values.qtyUsed = qtde;
        values.unitPrice = price;
        values.totalPrice = total;

        fetch('http://localhost:8080/api/products', {
            method: pId <= 0 ? 'POST' : 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify( values )
        })
        .then( function ( response)
        {
            if ( response.status == 201 || response.status == 200 )
            {
                document.getElementById('pName').value  = null;
                document.getElementById('pCategory').value = null;
                document.getElementById('pValue').value  = null;
                document.getElementById('qtde').value = null;

                document.getElementById("pId").value = null;

                refreshSoProducts();
            }

            else
            {
                response.text().then( function (text){ alert( text ) } );
            }
        } )
    }
}

function canAdd()
{
    var valid = true;

    var qtde = document.getElementById('qtde').value;
    var productId = document.getElementById('productId').value;

    if ( qtde.length == 0 || qtde == 0 )
    {
        alert( "Quantidade Inválida!" )
        valid = false;
    }

    else if ( productId.length == 0 )
    {
        alert( "Selecione um produto" )
        valid = false;
    }

    return valid;
}

function refreshSoProducts()
{
    id = document.getElementById("soId").value;

    const Http = new XMLHttpRequest();
    Http.open("GET", '/api/products/getAllOsProducts?osId=' + id );

    Http.send();

    Http.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var product = JSON.parse( Http.responseText );

            var table = document.getElementById('osProducts').getElementsByTagName('tbody')[0];

            table.innerHTML = "";

            for ( i = 0; i < product.length; i++ ) {
                var row = table.insertRow(i);

                row.innerHTML = "<td>" + product[i][0].id + "</td>" +
                "<td>" + product[i][1].name + "</td>" +
                "<td>" + product[i][1].categoryId + "</td>" +
                "<td>" + product[i][1].sellPrice + "</td>" +
                "<td>" + product[i][0].qtyUsed + "</td>" +
                "<td>" + product[i][0].totalPrice + "</td>"

                row.value = product[i];

                row.onclick = function () {
                    pId = document.getElementById("pId");

                    if ( pId != null )
                    {
                        productId = document.getElementById('productId');
                        pName = document.getElementById("pName");
                        pCategory = document.getElementById("pCategory");
                        pValue = document.getElementById("pValue");
                        qtde = document.getElementById("qtde");

                        pId.value = this.value[0].id;
                        productId.value = this.value[1].id;
                        pName.value = this.value[1].name;
                        pCategory.value = this.value[1].categoryId;
                        pValue.value = this.value[1].sellPrice;
                        qtde.value = this.value[0].qtyUsed;
                    }

                    if ( _selectedRow != null )
                    {
                        _selectedRow.classList.remove("selected");
                    }

                    row.addEventListener("dblclick", (e) => {
                        remove()
                    });

                    this.classList.add( "selected" );

                    _selectedRow = this;
                }
            }
        }
    }
}


window.addEventListener("load", (event) => {
    refreshSoProducts();
});

function remove()
{
    const Http = new XMLHttpRequest();
    Http.open("DELETE", '/api/products?productId=' + _selectedRow.value[0].id );

    Http.send();

    Http.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200)
        {
            refreshSoProducts();
            window.refresh()
        }
    }
}
