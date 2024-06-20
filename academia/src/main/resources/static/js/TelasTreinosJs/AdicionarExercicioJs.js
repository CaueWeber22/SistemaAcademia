$(document).ready(function(){
    $('#exercicio-id').select2();
    
    $('#btn-adicionar').click(function(event){
        var idExercicio = $('#exercicio-id').val();
        var divisao =  $('#divisao').val();
        var repeticoes =  $('#repeticoes').val();
        var series =  $('series-id').val();
        var idTreino = $('id_treino').val();
        
        if(idExercicio === ""){
        event.preventDefault();
        alert("Selecione um exercício");
        } else if(divisao === "" || repeticoes === "" || series === ""){
        event.preventDefault();
        alert("Preencha todas as informações");
        } else if(idTreino === ""){
        event.preventDefault();
        alert("Treino não localizado. Recarregue a página");
        }
        
    })
     
})
