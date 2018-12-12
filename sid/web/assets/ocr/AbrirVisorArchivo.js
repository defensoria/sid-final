urlServicioBase="http://172.30.1.82:8080/Validador/";
urlServicioRestBase = urlServicioBase + 'ValidarDocumento_Rest/';

var abrirVisorArchivo = function (requesAbrirVisorArchivo) {
    var operacionServicio = "obtenerArchivo";
    var CadenaRequesAbrirVisorArchivos = JSON.stringify(requesAbrirVisorArchivo);
    var urlServicioRest = urlServicioRestBase + operacionServicio;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", urlServicioRest, false);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(CadenaRequesAbrirVisorArchivos);

    var responseobtenerArchivo = JSON.parse(xhttp.responseText);

    if (responseobtenerArchivo.estadoResultante !== 1) {
        alert(responseobtenerArchivo.mensajeResultado);
    } else {
        var urlVisorBase = urlServicioBase + "Visor.jsp";
        var urlVisor = urlVisorBase + '?idAplicacion=' + requesAbrirVisorArchivo.idAplicacion + "&idArchivo=" + requesAbrirVisorArchivo.idArchivo;
        var params = 'width=' + screen.width;
        params += ', height=' + screen.height;
        params += ', top=0, left=0';
        params += ', fullscreen=yes';
        //visorArchivo = window.open(urlVisor, "VISOR DEL ARCHIVO FIRMADO DIGITALMENTE", 'height=650,width=1000');
        visorArchivo = window.open(urlVisor, "VISOR DEL ARCHIVO FIRMADO DIGITALMENTE", params);//'channelmode=1,scrollbars=1,status=0,titlebar=0,toolbar=0,resizable=1');
        if (window.focus) {
            visorArchivo.focus();
        }
    }
    return responseobtenerArchivo;
};

var abrirVisorArchivoExterno = function (requesAbrirVisorArchivoExterno) {
    var urlVisorBase = urlServicioBase + "VisorExterno.jsp";
    var urlVisor = urlVisorBase + '?idAplicacion=' + requesAbrirVisorArchivoExterno.idAplicacion;
    var params = 'width=' + screen.width;
    params += ', height=' + screen.height;
    params += ', top=0, left=0';
    params += ', fullscreen=yes';
    visorArchivoExterno = window.open(urlVisor, "VALIDACIÓN DE DOCUMENTOS", params);
    if (window.focus) {
        visorArchivoExterno.focus();
    }
};