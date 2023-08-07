/// <summary>
/// Script de Vista 
/// </summary>
/// <remarks>
/// </remarks>
try {
    ns('SIGPI.Login.Index');
    $(document).ready(function () {
        'use strict';
        SIGPI.Login.Index.Page = new SIGPI.Login.Index.Controller();
        SIGPI.Login.Index.Page.Ini();
        
    });
} catch (ex) {
    alert(ex.message);
}

