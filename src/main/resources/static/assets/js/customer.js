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

       values = {}

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
          method: "POST",
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
