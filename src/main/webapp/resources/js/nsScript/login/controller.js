/// <summary>
/// Script de Controladora de la Vista 
/// </summary>
/// <remarks>
/// </remarks>
try {
    ns('SIGPI.Login.Index.Controller');
    SIGPI.Login.Index.Controller = function () {
        var base = this;
        base.Ini = function () {
            'use strict';
             base.Control.frmLogin().on('submit', function(e){
                 if(base.Control.username().val().trim().length == 0){
                   alerta('warning','Ingresar usuario.');
                   base.Control.username().focus();
                   return false;
                 }
                 else if(base.Control.password().val().trim().length == 0){
                    alerta('warning','Ingresar contraseña.');
                    base.Control.password().focus();
                    return false;
                 }
                 else{
                    $('.modal-preload').removeClass('d-none');
                    return true;
                 }
                 
             });
        };

        base.Parametros = {
            
        };

        base.Control = {
            username: function () {
                return $('[name=username]');
            },
            password: function () {
                return $('[name=password]');
            },
            frmLogin: function () {
                return $('#frmLogin');
            }
        };

        base.Event = {
            submit: function(){
                 
                
            }
        	            
        };
        base.Ajax = {
            
        };
        base.Function = {
           
        };
           
    };
} catch (ex) {
    alert(ex.message);
}


