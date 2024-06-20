$(document).ready(function () {
    /*Abrir modal se showModal=true*/
    var showModal = $("#showModalInput").val();
    if (showModal === 'true') {
        $('#confirmModal').modal('show');
    }
    
    /*Verificar se id digitado é maior que 0*/
    $('#btnModal').click(function (event) {
        var id = $('#id-usuario').val()
        if (id < 1) {
            event.preventDefault();
            alert("Digite um ID maior que 0")
        }
    })

});