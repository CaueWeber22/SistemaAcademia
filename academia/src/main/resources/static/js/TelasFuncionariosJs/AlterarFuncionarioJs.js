$(document).ready(function () {
    //Mostrar div do tipo da alteração
    var tipoAlteracao = $('#ShowTipoAlteracao').val();

    if (tipoAlteracao === 'opAtivar') {
        $('#div-ativar').removeClass('esconder');
        $('#div-desativar').addClass('esconder');
        $('#div-func-null').addClass('esconder');
        $('#div-select-func').addClass('esconder');

    } else if (tipoAlteracao === 'opDesativar') {
        $('#div-desativar').removeClass('esconder');
        $('#div-ativar').addClass('esconder');
        $('#div-func-null').addClass('esconder');
        $('#div-select-func').addClass('esconder');
    } else if (tipoAlteracao === 'naoEncontrado') {
        $('#div-func-null').removeClass('esconder')
        $('#div-ativar').addClass('esconder')
        $('#div-desativar').addClass('esconder')
        $('#div-select-func').addClass('esconder');
    }

    //Verificar se id digitado é maior que 0 e se alguma opção está selecionada
    $('#btn-pesqusiar').click(function (event) {
        var id = $('#input-id-funcionario').val()
        var opcaoSelecionada = $("input[name='opcoes']:checked").val();
        if (id < 1) {
            event.preventDefault();
            alert("Digite um ID maior que 0");
        } else if (opcaoSelecionada === undefined) {
            event.preventDefault();
            alert("Escolha uma opção de alteração");
        }
    })

    //ABRIR MODAL PARA DESATIVAR FUNCIONÁRIO
    $('#btn-modal-desativar').click(function (event) {
        //Verificar se a data é válida
        var date = $('#data-demissao').val();
        var dateParts = date.split('-'); // Separar o ano, mês e dia
        var ano = parseInt(dateParts[0], 10);
       
        // Verificar se o ano é válido 
        if (ano < 1000 || ano > 2100) {
            event.preventDefault();
            alert("Digite uma data váldia");
        } else {
            $('#desativar-modal').modal('show');
        }
    })

    //ABRIR MODAL PARA ATIVAR FUNCIONÁRIO
    $('#btn-modal-ativar').click(function () {
        $('#ativar-modal').modal('show');
    })

})

