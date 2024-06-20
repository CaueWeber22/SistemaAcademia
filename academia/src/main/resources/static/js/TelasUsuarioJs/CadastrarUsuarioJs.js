$(document).ready(function(){
    //ADICIONAR SELECT2 PARA TORNAR POSSÍVEL PESQUISAS NO SELECT
    $("#plano-id").select2();
    $("#treino-id").select2();
    
    //VALIDAÇÃO DE DADOS E ABRIR MODAL
    $("#abrirModal").click(function(event){       
        var planoId = $('#plano-id').val();      
        var cpf = $('#cpf').val();
        var nome = $('#nome').val();
        //Separar ano da data de nascimento
        var dataNasc = $('#data-nasc').val();
        var datePartsNasc = dataNasc.split('-'); // Separar o ano, mês e dia
        var anoNasc = parseInt(datePartsNasc[0], 10);

        if (dataNasc === "" || cpf === "" || nome === "") {
            alert("Preencha todos os campos");
            event.preventDefault();
        } else if (planoId === "0") { 
            alert("Selecione um plano");
            event.preventDefault();
        } else if (anoNasc < 1900 || anoNasc > 2024) {
            event.preventDefault();
            alert("Digite uma data de nascimento váldia");
        }  else {
            $('#confirmModal').modal("show");
        }
    })
})