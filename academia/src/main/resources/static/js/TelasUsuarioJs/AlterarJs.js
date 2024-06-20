$(document).ready(function(){
    //ADICIONAR SELECT2 PARA TORNAR POSSÍVEL PESQUISAS NO SELECT
    $("#plano-id").select2();
    $("#treino-id").select2();
    
    //Validação e função para abrir modal
    $("#abrirModal").click(function(event){       
        var planoId = $('#plano-id').val();         

        if (planoId === "0") { 
            alert("Selecione um plano");
            event.preventDefault();
        } else {
            $('#confirmModal').modal("show");
        }
    })
    
    //Mensagem de sucesso
    $("#btnAlterar").click(function(){
        alert("Dados alterados com sucesso");
    })
})