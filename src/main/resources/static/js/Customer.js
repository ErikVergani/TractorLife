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
