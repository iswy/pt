
var obtenerTabla = function ()
{

    var table = $( "#tata" ).DataTable(
        {

            columnDefs: [ {
                    targets: -1 ,
                    data: null ,
                    defaultContent: "<button class='uno'>Borrar</button> <button class='dos'>NoBorrar</button>"
                } ] ,
            ajax:
                {
                    url: "GetSemestres" ,
                    type: "GET" ,
                    contentType: "application/json" ,
                    dataSrc: function ( js )
                    {
                        return $.parseJSON( js.msg );
                    }
                } ,
            columns:
                [
                    { data: "idsemestre" } ,
                    { data: "nomSemestre" } ,
                    { data : "<button>Borrar</button>"}
                ]
        } );

    $( '#tata tbody' ).on( 'click' , 'button.uno' , function ()
    {

        var data = table.row( $(this).parents('tr') ).data();
        alert("Borrar "+JSON.stringify(data));
    } );
    $( '#tata tbody' ).on( 'click' , 'button.dos' , function ()
    {

        var data = table.row( $(this).parents('tr') ).data();
        alert("No borrar "+JSON.stringify(data));
    } );


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
        $.glowl("hecho");
        $( "#tata" ).dataTable().api().ajax.reload();
    };
    var nohecho = function ()
    {
        alert( "no se pudo" );
    };

    $bot.on( "click" , function ( attr )
    {
        var ese = $in.val();

        $.ajax(
            {
                type: "POST" ,
                url: "/prueba1/NewSemestre" ,
                data: JSON.stringify( { s: ese } ) ,
                dataType: "json"
            } ).done( hecho ).fail( nohecho );
    } );

    obtenerTabla();

    $uno.append( $bot );
};

$( document ).ready( main );