$(document).ready(function(){

  $("#btn_enviar").on("click", function(event){
    cadastrarEntrada(event);
  });

  $("#btn_enviar_saida").on("click", function(event){
    cadastrarSaida(event);
  });

  listarEntrada();
  listarSaida();
  listarDatas();
  listarRelatorio();
});

  function listarDatas() {
    $.post('listaTodasDatas', {
    }).then(datas => {
      $.each(datas, function (i, data) {
          //Faz o append (adiciona) cada um dos itens do array como options do select de id combo1
          $("#dataEntrada").append($('<option>', {
              //neste caso o value do option vai ser a pripriedade Id (é case sensitive, então cuide da nomenclatura)
              value: data.id,
              //no text estou usando a propriedade Categoria dos objetos dentro do array categoria (case sensitive também)
              text: data.descricao
          }));

          $("#data").append($('<option>', {
              //neste caso o value do option vai ser a pripriedade Id (é case sensitive, então cuide da nomenclatura)
              value: data.id,
              //no text estou usando a propriedade Categoria dos objetos dentro do array categoria (case sensitive também)
              text: data.descricao
          }))
      })
    });
  }

   function listarRelatorio() {
    $('#tableRelatorio td').remove();
    $.post('listaTodosRelatorio', {
    }).then(datas => {
      var trHTML = '';

       datas.forEach(function(value, index) {

           trHTML += '<tr><td>' + value.data.descricao + '</td><td>' + value.somaEntra + '</td><td>' + value.somaSaida + '</td><td>' + value.balancoMensal + '</td></tr>';
       });

       $('#tableRelatorio').append(trHTML);

      console.log(datas);
    });
  }

  function listarEntrada() {
    $('#tableEntrada td').remove();
    $.post('listaTodasEntradas', {
    }).then(datas => {
      var trHTML = '';

       datas.forEach(function(value, index) {

           trHTML += '<tr><td>' + value.data.descricao + '</td><td>' + value.valor + '</td><td>' + value.descricao + '</td><td><button data-toggle="modal" data-target="#editarProduto" type="button" title="Editar"  class="btn btn-default"><span class="glyphicon glyphicon-pencil" aria-hidden="true" style="font-size: 13px;"> </span></button></td></tr>';
       });

       $('#tableEntrada').append(trHTML);

      console.log(datas);
    });
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


  function cadastrarEntrada(event) {

    var descricao = $("#desc").val();
    var valor = parseInt($("#valor").val());
    var dataDaEntrada = $("#dataEntrada").val();

    if (descricao  && valor  && dataDaEntrada ) {


      $.post('inserirEntrada', {
        descricao : descricao,
        valor : valor,
        data :  dataDaEntrada,

        }).then(datas => {
          // $('#mensagens-sucesso').modal();
          console.log(datas);
          listarEntrada();
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

  function cadastrarSaida(event) {

    var descricao = $("#descSaida").val();
    var valor = parseInt($("#valorSaida").val());
    var dataSaida = $("#data").val();

    if (descricao  && valor  && dataSaida ) {


      $.post('inserirSaida', {
        descricao : descricao,
        valor : valor,
        data :  dataSaida,

        }).then(datas => {
          // $('#mensagens-sucesso').modal();
          console.log(datas);
          listarSaida();
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

  function limpaFormSaida() {
    document.getElementById("formSaida").reset();
  }

  function limpaFormEntrada() {
    document.getElementById("formEntrada").reset();
  }

  function umaSaida (id) {
  $('#tableSaidaEditar td').remove();  
    var idSaida = id;
    $.post('pegaUmaSaidas', {
    id: idSaida,

    }).then(data => {
      var trHTML = '';
      arrayClie = [];

           trHTML += '<tr><td>' + data.data.descricao + '</td><td>' + data.valor + '</td><td>' + data.descricao + '</td></tr>';

       $('#tableSaidaEditar').append(trHTML);

      document.getElementById('descSaidaEdit').value=(data.descricao);
      document.getElementById('valorSaidaEdit').value=(data.valor);
      document.getElementById('dataSaidaEdit').value=(data.data.id);


   
    });
  }
