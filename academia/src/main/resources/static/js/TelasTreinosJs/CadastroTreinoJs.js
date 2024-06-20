$(document).ready(function(){
   
    //VALIDAÇÃO DE DADOS E ABRIR MODAL
    $("#abrirModal").click(function(event){       
        var nome = $('#nome').val();            
        var nmrDivisoes = $('#nmrDivisoes').val();
        var txtDescricao = $('#txtDescricao').val();
        var txtDescricaoDias = $('#txtDescricaoDias').val();
        

        if (nome === "" || txtDescricaoDias===""|| nmrDivisoes === "" || txtDescricao === "") {
            alert("Preencha todos os campos");
            event.preventDefault();    
        } else if (nmrDivisoes<1) {
            alert("A quantidade de divisões deve ser maior que 0");
            event.preventDefault();   
        }
        else{
            $('#confirmModal').modal("show");
        }
    })
    
       
       
    
})