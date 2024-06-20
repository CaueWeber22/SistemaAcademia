$(document).ready(function(){
    $('#exercicio-id').select2();
    
    $('#btn-remover').click(function(event){
        idExercicio = $('#exercicio-id').val();
        idTreino = $('#id_treino').val();
        
        if(idExercicio === ""){
            event.preventDefault();
            alert("Escolha um exercício");
        } else if (idTreino === "" || idTreino === null){
            event.preventDefault();
            alert("Erro com o treino. Tente novamente");
        } else{
            $('#confirmModal').modal('show');
        }
    })
})


