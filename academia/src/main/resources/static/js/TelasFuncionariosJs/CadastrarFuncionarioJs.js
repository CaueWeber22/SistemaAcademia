$(document).ready(function(){
   
    //VALIDAÇÃO DE DADOS E ABRIR MODAL
    $("#abrirModal").click(function(event){       
        var cargoId = $('#cargo-id').val();            
        var cpf = $('#cpf').val();
        var nome = $('#nome').val();
        //Valdiar ano da data de nascimento
        var dataNasc = $('#data-nasc').val();
        var datePartsNasc = dataNasc.split('-'); // Separar o ano, mês e dia
        var anoNasc = parseInt(datePartsNasc[0], 10);
        //Valdiar ano da data de admissão
        var dataAdmissao = $('#data-admissao').val();
        var datePartsAdmissao = dataAdmissao.split('-'); // Separar o ano, mês e dia
        var anoAdmissao = parseInt(datePartsAdmissao[0], 10);

        if (dataNasc === "" || dataAdmissao===""|| cpf === "" || nome === "") {
            alert("Preencha todos os campos");
            event.preventDefault();
        } else if (cargoId === "") { 
            alert("Selecione um cargo");
            event.preventDefault();
        } else  if (anoNasc < 1900 || anoNasc > 2024) {
            event.preventDefault();
            alert("Digite uma data de nascimento váldia");
        } else  if (anoAdmissao < 1900 || anoAdmissao > 2024) {
            event.preventDefault();
            alert("Digite uma data de admissão váldia");
        } else{
            $('#confirmModal').modal("show");
        }
    })
    
       
       
    
})