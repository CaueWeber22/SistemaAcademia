$(document).ready(function () {
    
    //Função para enviar valor nulo ao backend e retornar todos usuários
    //Ao clicar botão "Limpar"
    $("#botao-limpar").click(function(){
        $.ajax({
           url: '/Usuarios',
           method: 'POST',
           success: function(data){
               //Requisição com valor nulo
           },
           error: function(textStatus, errorThrown) {
               console.error('Erro na solicitação: ' + textStatus, errorThrown);
           }
        })        
    })
})

