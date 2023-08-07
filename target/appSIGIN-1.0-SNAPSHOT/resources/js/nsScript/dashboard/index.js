/// <summary>
/// Script de Vista 
/// </summary>
/// <remarks>
/// </remarks>
try {
    ns('SIGPI.dashboard.Index');
    $(document).ready(function () {
        'use strict';
        SIGPI.dashboard.Index.Page = new SIGPI.dashboard.Index.Controller();
        SIGPI.dashboard.Index.Page.Ini();
        
    });
} catch (ex) {
    alert(ex.message);
}

