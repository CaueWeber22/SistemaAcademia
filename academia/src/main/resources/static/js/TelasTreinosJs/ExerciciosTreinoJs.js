$(document).ready(function(){
    //Aplicar select2 para pesquisa
    $('#treino-pesquisar').select2();
    
    $('#btn-pesquisar').click(function(event){
        treino = $('#treino-pesquisar').val();
        
        if(treino === ""){
            alert("Selecione um treino");
            event.preventDefault();
        }
    })
})