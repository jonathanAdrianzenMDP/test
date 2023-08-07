/// <summary>
/// Script de Controladora de la Vista 
/// </summary>
/// <remarks>
/// </remarks>
try {
    ns('SIGPI.P02Perfil.Index.Controller');
    SIGPI.P02Perfil.Index.Controller = function () {
        var base = this;
        base.Ini = function () {
            'use strict';
            base.Event.loadFileUpload();
            base.Control.btnAdjuntar().on('click', base.Event.clickAdjuntar);
            base.Control.btnEnviar().on('click', base.Event.clickbtnEnviar);
            base.Control.btnAprobar().on('click', base.Event.clickbtnAprobar);
            base.Control.btnGuardarObservacion().on('click', base.Event.clickbtnGuardarObservacion);
            base.Control.txtfile().on('change', function () {
                base.Event.changeFileGuardar();
            });
            base.Control.btnAdjuntos().on('click', base.Event.clickAdjuntos);

            base.Control.tablaDocsAdjuntos().on('click', '.fa-trash-alt', function () {
                base.Event.clickEditarEstadoFileUpload($(this));
            });

        };


        base.Control = {
            hdnIdProyectoPIP: function () {
                return $('#hdnIdProyectoPIP');
            },
            btnAdjuntar: function () {
                return $('#btnAdjuntar');
            },
            txtIntegrante: function () {
                return $('#txtIntegrante');
            },
            txtNrooficio: function () {
                return $('#txtNrooficio');
            },
            txtidproyepip: function () {
                return $('#txtidproyepip');
            },
            txtnomforeva: function () {
                return $('#txtnomforeva');
            },
            txtcodforeva: function () {
                return $('#txtcodforeva');
            },
            txtCodigoInterno: function () {
                return $('#txtCodigoInterno');
            },
            txtNomdoc: function () {
                return $('#txtNomdoc');
            },
            txtfile: function () {
                return $('#txtfile');
            },
            hdnFileName: function () {
                return $('#hdnFileName');
            },
            txtNamefile: function () {
                return $('#txtNamefile');
            },
            hdnFileURL: function () {
                return $('#hdnFileURL');
            },
            modalAdjuntos: function () {
                return $('#mdlAdjuntos');
            },
            tablaDocsAdjuntos: function () {
                return $('#tblDocsAdjuntos');
            },
            btnAdjuntos: function () {
                return $('#btnAdjuntos');
            },
            btnEnviar: function () {
                return $('[name=btnEnviar]');
            },
            btnAprobar: function () {
                return $('[name=btnAprobar]');
            },
            txtObservacion: function () {
                return $('#txtObservacion');
            },
            btnGuardarObservacion: function () {
                return $('#btnGuardarObservacion');
            }
        };

        base.Parametros = {
            Mensajes: {
                TituloMensajeConfirmacion: Web.SIGPI.MensajeSistema.TituloMensajeConfirmacion,
                Confirmacion: Web.SIGPI.MensajeSistema.Confirmacion
            },
            codigoP02Perfil: 0,
            codigo: 0,
            codigoNuevoPIP: base.Control.hdnIdProyectoPIP().val()
        };


        base.Event = {
            loadFileUpload: function () {
                var item = {
                    idbrecindi: 0,
                    procactual: Web.SIGPI.Parametro.Perfil,
                    idproioarr: 0,
                    idproyepip: base.Parametros.codigoNuevoPIP
                };
                base.Ajax.ajaxListFileUpload(item);
            },
            clickAdjuntar: function () {
                if (base.Function.validarCamposFileUpload()) {
                    BootstrapDialog.confirm(base.Parametros.Mensajes.TituloMensajeConfirmacion, base.Parametros.Mensajes.Confirmacion, function (result) {
                        if (result) {
                            var obj = {
                                urldoc: base.Control.hdnFileURL().val(),
                                descdoc: base.Control.txtNamefile().val(),
                                nomdoc: base.Control.hdnFileName().val(),
                                procactual: Web.SIGPI.Parametro.Perfil,
                                idproyepip: base.Parametros.codigoNuevoPIP,
                                idproioarr: 0
                            };
                            base.Ajax.ajaxSendFileUpload(obj);
                        }
                    }
                    );
                }
            },
            changeFileGuardar: function () {

                var data = new FormData();
                $.each(base.Control.txtfile()[0].files, function (i, file) {
                    data.append('file-' + i, file);
                });
                base.Ajax.ajaxChangeFileGuardar(data);
            },
            clickEditarEstadoFileUpload: function (id) {
                BootstrapDialog.confirm(Web.SIGPI.MensajeSistema.TituloMensajeConfirmacion, Web.SIGPI.MensajeSistema.MensajeConfirmacionCambiarEstado, function (result) {
                    if (result) {
                        base.Ajax.ajaxDeleteFileUpload($(id).data('id'));
                    }
                });
            },
            clickbtnEnviar: function () {
                if (base.Function.validarNombreCodigo()) {
                    BootstrapDialog.confirm(Web.SIGPI.MensajeSistema.TituloMensajeConfirmacion, 'Está seguro de enviar a REVISION al EMGRA?', function (result) {
                        if (result) {
                            var item = base.Function.getDatosNombreCodigo();
                            base.Ajax.ajaxEnviarPerfil(item);
                        }
                    });
                }
            },
            clickbtnAprobar: function () {
                BootstrapDialog.confirm(Web.SIGPI.MensajeSistema.TituloMensajeConfirmacion, 'Está seguro de APROBAR el Perfil?', function (result) {
                    if (result) {
                        var item = {
                            idproyepip: base.Parametros.codigoNuevoPIP
                        };
                        base.Ajax.ajaxAprobarPIP(item);
                    }
                });
            },
            clickbtnGuardarObservacion: function () {
                BootstrapDialog.confirm(Web.SIGPI.MensajeSistema.TituloMensajeConfirmacion, Web.SIGPI.MensajeSistema.Confirmacion, function (result) {
                    if (result) {
                        var obj = {
                            descobserv: base.Control.txtObservacion().val(),
                            idproyepip: base.Parametros.codigoNuevoPIP
                        };
                        console.log(obj);
                        base.Ajax.ajaxGuardarObservacion(obj);

                    }
                });
            }
        };

        base.Ajax = {
            ajaxListFileUpload: function (item) {
                $.ajax({
                    url: Web.SIGPI.URL.listFileUpload,
                    "type": 'POST',
                    contentType: "application/json",
                    "dataType": 'json',
                    "data": JSON.stringify(item),
                    success: function (response) {
                        var data = {
                            data: response.data
                        };
                        base.Function.cargarTablaAdjuntos(data);
                    }
                });
            },
            ajaxSendFileUpload: function (obj) {
                $.ajax({
                    url: Web.SIGPI.URL.saveFileUpload,
                    "type": 'POST',
                    contentType: "application/json",
                    "dataType": 'json',
                    "data": JSON.stringify(obj),
                    success: function (data) {
                        console.log(data);
                        alerta(data.type, data.message);
                        if (data.success == true) {
                            base.Function.limpiarCamposFileUpload();
                            base.Event.loadFileUpload();
                        }

                    }
                });
            },
            ajaxChangeFileGuardar: function (data) {
                $.ajax({
                    url: Web.SIGPI.URL.changeFileUpload,
                    data: data,
                    cache: false,
                    contentType: false,
                    processData: false,
                    type: 'POST',
                    success: function (response) {
                        console.log(response);
                        if (response.success == true) {
                            response = response.data;
                            base.Control.hdnFileName().val(response.nomdoc);
                            base.Control.hdnFileURL().val(response.urldoc);
                        } else {
                            alerta(response.type, response.message);
                        }
                    }
                });
            },
            changeFileGuardar: function () {

                var data = new FormData();
                $.each(base.Control.txtfile()[0].files, function (i, file) {
                    data.append('file-' + i, file);
                });
                base.Ajax.ajaxChangeFileUpload(data);
            },
            ajaxDeleteFileUpload: function (id) {
                $.ajax({
                    "url": Web.SIGPI.URL.deleteFileUpload,
                    "type": 'GET',
                    "data": {"id": id},
                    success: function (data) {
                        console.log(data);
                        alerta(data.type, data.message);
                        base.Event.loadFileUpload();
                    }
                });
            },
            ajaxEnviarPerfil: function (data) {
                $.ajax({
                    "url": 'enviarP02Perfil',
                    "type": 'POST',
                    contentType: "application/json",
                    "dataType": 'json',
                    "data": JSON.stringify(data),
                    success: function (response) {
                        console.log(response);
                        alerta(response.type, response.message);
                        window.location = './seguimientoPIP?id=' + response.data.idProyepip;
                    }
                });
            },
            ajaxAprobarPIP: function (data) {
                $.ajax({
                    "url": 'aprobarP02Perfil',
                    "type": 'POST',
                    contentType: "application/json",
                    "dataType": 'json',
                    "data": JSON.stringify(data),
                    success: function (response) {
                        console.log(response);
                        alerta(response.type, response.message);
                        window.location = './seguimientoPIP?id=' + response.data.idproyepip;
                    }
                });
            },
            ajaxGuardarObservacion: function (obj) {

                $.ajax({
                    "url": 'ObservacionP02Perfil',
                    "type": 'POST',
                    contentType: "application/json",
                    "dataType": 'json',
                    "data": JSON.stringify(obj),
                    success: function (data) {
                        console.log(data);
                        alerta(data.type, data.message);

                        base.Function.limpiarCampoObservacion();
                        window.location = './seguimientoPIP?id=' + data.data.idproyepip;
                        ;
                    }
                });
            }
        };


        base.Function = {
            limpiarCamposFileUpload: function () {
                base.Control.txtfile().val('');
                base.Control.hdnFileURL().val('');
                base.Control.txtNamefile().val('');
                base.Control.hdnFileName().val('');
            },
            limpiarCampoObservacion: function () {
                base.Control.txtObservacion().val('');
            },
            validarCamposFileUpload: function () {
                var cadena = '';
                if (base.Control.hdnFileURL().val() == '') {
                    cadena += '<br>Debe seleccionar un archivo.';
                }
                if (base.Control.txtNamefile().val() == '') {
                    cadena += '<br>Debe ingresar la descripción del archivo.';
                }

                if (cadena.length > 0) {
                    alerta('warning', cadena);
                    return false;
                }
                return true;
            },
            validarNombreCodigo: function () {
                var cadena = '';
                if (base.Control.txtnomforeva().val() == '') {
                    cadena += '<br>Debe Ingresar Nombre';
                }
                if (base.Control.txtcodforeva().val() == '') {
                    cadena += '<br>Debe ingresar Codigo';
                }
                if (cadena.length > 0) {
                    alerta('warning', cadena);
                    return false;
                }
                return true;
            },
            getDatosNombreCodigo: function () {
                var item = {
                    idProyepip: base.Control.txtidproyepip().val(),
                    nomforeva: base.Control.txtnomforeva().val(),
                    codforeva: base.Control.txtcodforeva().val()
                };
                return item;
            },
            cargarTablaAdjuntos: function (data) {

                base.Control.tablaDocsAdjuntos().DataTable({
                    paging: false,
                    "cache": false,
                    searching: false,
                    "lengthMenu": [5, 50],
                    destroy: true,
                    ordering: false,
                    "ajax": function (request, callback, settings) {
                        callback(data);
                    },
                    "columns": [
                        {"data": "iddocument", "title": "Codigo Documento"},
                        {"data": "descdoc", "title": "Descripción Documento"},
                        {"data": "feccreacio", "title": "Fecha Creación"},
                        {
                            "data": "iddocument", "title": "Acción", "sType": "html", "mRender": function (data, type, full)
                            {
                                return '<a data-toggle="tooltip" data-placement="top" title="Descargar Archivo" href="' + Web.SIGPI.URL.DownloadFile + full.nomdoc + '" target="_blank"><span class="fas fa-download"></span></a>'
                                        + '<span data-toggle="tooltip" data-placement="top" title="Eliminar archivo" class="fas fa-trash-alt" data-id="' + full.iddocument + '"></span></div>'
                            }
                        }
                    ],
                    'fnDrawCallback': function () {
                        //validarPermiso();
                        $('table .fa-trash-alt').remove();//boton eliminar 
                        $('thead tr th.sorting_asc').removeClass('sorting_asc');
                        $('table').removeClass('dataTable');
                        $('table .fas').closest('td').addClass('accion');
                        $('[data-toggle="tooltip"]').tooltip();
                    }
                });
            }


        };



    };
} catch (ex) {
    alert(ex.message);
}

