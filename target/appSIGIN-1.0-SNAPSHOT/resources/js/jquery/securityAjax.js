//Spring-Secutiry: token, header
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
//muestra un loading por 1,5 segundo al cargar la pagina
        
try {
    $.xAjaxPool = [];
    $.ajaxSetup({    
        beforeSend: function (xhr, jqXAjax) {
            //Spring-Secutiry: xhr
            xhr.setRequestHeader(header, token);
            $.xAjaxPool.push(jqXAjax);
            $('.modal-preload').removeClass('d-none');
        },
        complete: function (jqXAjax) {
            var index = $.xAjaxPool.indexOf(jqXAjax);
            if (index > -1) {
                $.xAjaxPool.splice(index, 1);
            }
            $('.modal-preload').addClass('d-none');
            if ($.xAjaxPool.length == 0) {
                $('.modal-preload').addClass('d-none');

                //elimina el drop
                /*var controls = $("input[type=text], input[type=password], textarea");
                controls.bind("drop", function () {
                    return false;
                });
                controls = undefined;*/
                //fin del drop
            }

        },
        error: function (jqXAjax) {
            var index = $.xAjaxPool.indexOf(jqXAjax);
            if (index > -1) {
                $.xAjaxPool.splice(index, 1);
            }
           $('.modal-preload').addClass('d-none');
        }
    });
} catch (e) {
}