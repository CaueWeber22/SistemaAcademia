$(document).ready(function () {

    //Função para enviar valor nulo ao backend e retornar todos funcionários
    //Ao clicar botão "Limpar"
    $("#botao-limpar").click(function () {
        $.ajax({
            url: '/Funcionarios',
            method: 'POST',
            success: function (data) {
                //Requisição com valor nulo
            },
            error: function (textStatus, errorThrown) {
                console.error('Erro na solicitação: ' + textStatus, errorThrown);
            }
        })
    })

    //Selecionar tipo de pesquisa de funcionário(ID ou nome)
    $("input[name='pesquisaTipo']").change(function () {
        var pesquisaTipo = $(this).val();

        if (pesquisaTipo === "Nome") {
            $('#divPesquisaNome').removeClass("esconder");
            $('#divPesquisaId').addClass("esconder");
            $('#divBtnLimpar').addClass("esconder");
        } else if (pesquisaTipo === "ID") {
            $('#divPesquisaId').removeClass("esconder");
            $('#divPesquisaNome').addClass("esconder");
            $('#divBtnLimpar').addClass("esconder");
        }
    });

})

