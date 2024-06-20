$(document).ready(function(){
    $('#btnPesquisar').click(function(){
        var id = $("id-usuario").val();
        var idNumero = parseInt(id, 10);
        
        if (idNumero <= 0){
            alert("Insira um ID maior que 0");
            event.preventDefault()
        }
    })
    
})

