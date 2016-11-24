var cosas = function(fila)
{
    var str="";

    //str+="<div align=\"center\" onClick=\"borrar("+JSON.stringify(fila)+")\">";
    //str+="algo:"+JSON.stringify(fila);
    //str+="</div>";

    return str;
};

var obtenerTabla = function ()
{
    var dtsi = function (datos)
    {

    };
    var dtno = function ()
    {
        alert("no se pudo recuperar datos");
    };


    $("#tata").DataTable(
        {
            ajax:
            {
                url : "GetSemestres",
                type : "GET",
                contentType: "application/json",
                dataSrc: function (js)
                {
                    return $.parseJSON(js.msg);
                }
            },
            columns:
                [
                { data : "idsemestre" },
                { data : "nomSemestre" },
                { data : cosas }
                ]
        });

};

var main = function ()
{
    "use strict";

    var $uno = $( "#uno" );

    var $label = $( "<label>" );
    $label.attr( "for" , "semestre" );
    $label.text( "Introducir semestre" );

    var $in = $( "<input>" );
    $in.attr( "type" , "text" );
    $in.attr( "id" , "semestre" );

    $uno.append( $label );
    $uno.append( $in );

    var $bot = $( "<button>" );
    $bot.attr( "id" , "bot" );
    $bot.val( "Insertar semestre" );
    $bot.text( "Ins. semestre" );

    var hecho = function ( datos )
    {
        $("#tata").dataTable().api().ajax.reload();
    };
    var nohecho = function ()
    {
        alert( "no se pudo" );
    };

    $bot.on( "click" , function ( attr )
    {
        var ese = $in.val();

/*
        $.post( "/NewSemestre" , { s: ese } , function ()
        {
            alert( "listo" );
        } );
*/
        $.ajax(
            {
                type: "POST" ,
                url: "/prueba1/NewSemestre" ,
                data: { s: ese } ,
                dataType: "json"
            } ).done( hecho ).fail( nohecho );
    } );

    obtenerTabla();

    $uno.append( $bot );
};

$( document ).ready( main );

