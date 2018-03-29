var idSaida;

$(document).ready(function(){

  
	$("#btn_enviar_saida").on("click", function(event){
		cadastrarSaida(event);
	});

	$("#btn_Alterar").on("click", function(event){

    	editarSaida(event);
  	});
    
  listarSaida();    
});



function cadastrarSaida(event) {

    var descricao = $("#descSaida").val();
    var valor = parseInt($("#valorSaida").val());
    var dataSaida = $("#selectListDataSaida").val();

    if (descricao  && valor  && dataSaida ) {


    	$.post('inserirSaida', {
        	descricao : descricao,
        	valor : valor,
        	data :  dataSaida,

        }).then(datas => {
          // $('#mensagens-sucesso').modal();
        	console.log(datas);
          	listarSaida();
          	listarRelatorio();
          	limpaFormSaida();
        
        }).catch(erro => {
          	if (erro.status == 400) {
            // $('#import-erro-existe').modal();
          	}
           	event.preventDefault();
          	console.log(erro);
        });

    }else {
      	event.preventDefault();
      	alert("Preencha todos os campos");
    }
    	event.preventDefault();
  }

function listarSaida() {
    $('#tableSaida td').remove();
  	 	$.post('listaTodasSaidas', {
    }).then(datas => {
      	var trHTML = '';

        datas.forEach(function(value, index) {

           trHTML += '<tr><td>' + value.data.descricao + '</td><td>' + value.valor + '</td><td>' + value.descricao + '</td><td><button data-toggle="modal" data-target="#editarSaida"  onclick="umaSaida('+value.id+');"  type="button" title="Editar"  class="btn btn-default"><span class="glyphicon glyphicon-pencil" aria-hidden="true" style="font-size: 13px;"> </span></button></td></tr>';
       });

       $('#tableSaida').append(trHTML);

       console.log(datas);
    });
}

function umaSaida (id) {
  	$('#tableSaidaEditar td').remove();  
    	idSaida = id;
    	$.post('pegaUmaSaidas', {
    		id: idSaida,

	    }).then(data => {
    		$("#dataSaidaEdit option").remove();   
      		var trHTML = '';
      

           trHTML += '<tr><td>' + data.data.descricao + '</td><td>' + data.valor + '</td><td>' + data.descricao + '</td></tr>';

        	$('#tableSaidaEditar').append(trHTML);

      		document.getElementById('descSaidaEdit').value=(data.descricao);
      		document.getElementById('valorSaidaEdit').value=(data.valor);

		    $.each(arrayData, function (i, data) {
        	$("#dataSaidaEdit").append($('<option>', {
                //neste caso o value do option vai ser a pripriedade Id (é case sensitive, então cuide da nomenclatura)
                value: data.id,
                //no text estou usando a propriedade Categoria dos objetos dentro do array categoria (case sensitive também)
                text: data.descricao
	        }))
     	})
   
    });
}

function limpaFormSaida() {
    document.getElementById("formSaida").reset();
}

function editarSaida(event) {

    var descricao = $("#descSaidaEdit").val();
    var valor = parseInt($("#valorSaidaEdit").val());
    var dataSaida = $("#dataSaidaEdit").val();

    if (descricao  && valor  && dataSaida ) {


    	$.post('inserirSaida', {
        	descricao : descricao,
        	valor : valor,
        	data :  dataSaida,
        	id : idSaida,

        }).then(datas => {
          // $('#mensagens-sucesso').modal();
        	console.log(datas);
          	listarSaida();
          	listarRelatorio();
          	
          	$('#editarSaida').modal('hide');
        }).catch(erro => {
        	if (erro.status == 400) {
            // $('#import-erro-existe').modal();
	        }
    	        event.preventDefault();
        		console.log(erro);
       });

    }else {
        event.preventDefault();
        alert("Preencha todos os campos");
    }
    	event.preventDefault();
}  