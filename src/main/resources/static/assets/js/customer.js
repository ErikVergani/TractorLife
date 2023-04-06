_selectedRow = null;
function cpfMask( cpf ){
   
   var v = cpf.value;
   
   if ( isNaN( v[v.length-1] ) ) 
   { // impede entrar outro caractere que não seja número
      cpf.value = v.substring( 0, v.length-1 );
      return;
   }
   
   cpf.setAttribute( "maxlength", "14" ); 
   if ( v.length == 3 || v.length == 7 ) cpf.value += ".";
   if ( v.length == 11 ) cpf.value += "-";
}

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
              if ( response.status == ( 201 ||  200 ) )
              {
                  alert("Usuário salvo com sucesso!")
              }
           } )
            .catch( error =>  alert( error ) );

       document.getElementById("form").reset();
    }

    refresh = function () {
      idFilter = document.getElementById("filterId")
      nameFilter = document.getElementById("filterName")
      cityFilter = document.getElementById("filterCity")
      enableFilter = document.getElementById("filterEnable")

       const Http = new XMLHttpRequest();
       Http.open("GET", '/api/customer/getAll?id=' + idFilter.value +
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

                   if (_selectedRow != null) {
                      _selectedRow.setAttribute("class", null);
                   }

                   this.setAttribute("class", "selected");

                   _selectedRow = this;
                }
             }
          }
       }
    }