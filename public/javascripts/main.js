$(function () {

    $("#estilo").change(function () {

        estilo = $("#estilo").val();

        $.ajax({
            url: "../Logins/listaClasses",
            data: "estilo=" + estilo,
            dataType: "json",
            success: function (estilos) {
                $("#classe").html("");
                for (var i = 0; i < estilos.length; i++) {
                    opt = "<option value=" + estilos[i].id + " > " + estilos[i].nome + " </ option > ";
                    $("#classe").append(opt);
                }
            }
        })



    })


});