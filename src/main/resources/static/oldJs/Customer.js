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

function send()
{
   const http = new XMLHttpRequest();

   http.open("POST", '/api/customer');
   http.setRequestHeader("Content-Type", "application/json");

   nameField = document.getElementById("nameField");
   cpfField = document.getElementById("cpfField");
   addressField = document.getElementById("addressField");
   cellField = document.getElementById("cellField");
   emailField = document.getElementById("emailField");
   cityField = document.getElementById("cityField");
   balanceField = document.getElementById("balanceField");
   checkboxField = document.getElementById("checkboxField");

   values = {}

   values.name = nameField.value;
   values.cpf = cpfField.value;
   values.address = addressField.value;
   values.phoneNumber1 = cellField.value;
   values.city = cityField.value;
   values.enable = checkboxField.checked;
   values.balanceLimit = balanceField.value;
   values.email = emailField.value;

   http.onreadystatechange = function () {
      if ( this.readyState == 4 ) {
         if ( this.status == 200 ) {
            clearFields();
         }

         else if (this.status == 500) {
            alert(JSON.parse(this.responseText).message);
         }
      }
   }

   http.send( JSON.stringify( values ) );
}

    clearFields = function () {
       nameField = document.getElementById("nameField");
       cpfField = document.getElementById("cpfField");
       addressField = document.getElementById("addressField");
       cellField = document.getElementById("cellField");
       emailField = document.getElementById("emailField");
       cityField = document.getElementById("cityField");
       balanceField = document.getElementById("balanceField");
       checkboxField = document.getElementById("checkboxField");

       nameField.value = null;
       cpfField.value = null;
       addressField.value = null;
       cellField.value = null;
       emailField.value = null;
       cityField.value = null;
       balanceField.value = null;
       checkboxField.value = null;

       _selectedRow = null;
    }