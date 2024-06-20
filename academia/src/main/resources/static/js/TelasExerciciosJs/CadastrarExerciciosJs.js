$(document).ready(function () {
    //Aplicar select2 para pesquisa
    $('#grupo-muscular').select2()

    //VALIDAR DADOS E ABRIR MODAL
    $('#abrir-modal').click(function (event) {
        var grupoMuscular = $('#grupo-muscular').val();
        var nome = $('#nome').val();
        
        if (grupoMuscular === "") {
            alert("Selecione um grupo muscular");
            event.preventDefault();
        } else if(nome === ""){
            alert("Digite o nome do exercício");
            event.preventDefault();
        } else {
            $('#confirm-modal').modal("show");
        }
    })
});
