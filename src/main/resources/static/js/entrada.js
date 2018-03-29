var idEntrada;
$(document).ready(function(){

  $("#btn_enviar").on("click", function(event){
    cadastrarEntrada(event);
  });

  $("#btn_AlterarEntrada").on("click", function(event){

    	editarEntrada(event);
  	});

  listarEntrada();

});

function listarEntrada() {
    $('#tableEntrada td').remove();
    $.post('listaTodasEntradas', {
    }).then(datas => {
	    var trHTML = '';

       datas.forEach(function(value, index) {

           trHTML += '<tr><td>' + value.data.descricao + '</td><td>' + value.valor + '</td><td>' + value.descricao + '</td><td><button data-toggle="modal" data-target="#editarEntrada" onclick="umaEntrada('+value.id+');" type="button" title="Editar"  class="btn btn-default"><span class="glyphicon glyphicon-pencil" aria-hidden="true" style="font-size: 13px;"> </span></button></td></tr>';
       });

       $('#tableEntrada').append(trHTML);

      console.log(datas);
    });
}

function cadastrarEntrada(event) {

    var descricao = $("#desc").val();
    var valor = parseInt($("#valor").val());
    var dataDaEntrada = $("#selectListDataEntrada").val();

    if (descricao  && valor  && dataDaEntrada ) {


    	$.post('inserirEntrada', {
        	descricao : descricao,
        	valor : valor,
        	data :  dataDaEntrada,

        }).then(datas => {
          // $('#mensagens-sucesso').modal();
        	console.log(datas);
          	listarEntrada();
          	listarRelatorio();
          	limpaFormEntrada();
         
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

function limpaFormEntrada() {
    document.getElementById("formEntrada").reset();
}

function umaEntrada (id) {
  	$('#tableEntradaEditar td').remove();  
    	idEntrada = id;
    	$.post('pegaUmaEntrada', {
    		id: idEntrada,

	    }).then(data => {
    		$("#dataEntradaEdit option").remove();   
      		var trHTML = '';
      

           trHTML += '<tr><td>' + data.data.descricao + '</td><td>' + data.valor + '</td><td>' + data.descricao + '</td></tr>';

        	$('#tableEntradaEditar').append(trHTML);

      		document.getElementById('descEntradaEdit').value=(data.descricao);
      		document.getElementById('valorEntradaEdit').value=(data.valor);

		    $.each(arrayData, function (i, data) {
        	$("#dataEntradaEdit").append($('<option>', {
                //neste caso o value do option vai ser a pripriedade Id (é case sensitive, então cuide da nomenclatura)
                value: data.id,
                //no text estou usando a propriedade Categoria dos objetos dentro do array categoria (case sensitive também)
                text: data.descricao
	        }))
     	})
   
    });
}

function editarEntrada(event) {

    var descricao = $("#descEntradaEdit").val();
    var valor = parseInt($("#valorEntradaEdit").val());
    var dataEntrada = $("#dataEntradaEdit").val();

    if (descricao  && valor  && dataEntrada ) {


    	$.post('inserirEntrada', {
        	descricao : descricao,
        	valor : valor,
        	data :  dataEntrada,
        	id : idEntrada,

        }).then(datas => {
          // $('#mensagens-sucesso').modal();
        	console.log(datas);
          	listarEntrada();
          	listarRelatorio();
          	
          	$('#editarEntrada').modal('hide');
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
