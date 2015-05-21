/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function assignSMToRelease() {
    // get the form values
    var productbacklog = $('#productBacklog').val();
    //var releasebacklog = $('#releaseBacklog').val();

    //alert(productbacklog + releasebacklog);
    $.ajax({
        type: "POST",
        url: "/mumscrum/ajaxhandler/selectRB",
        data: {pbId: productbacklog},
        success: function (response) {
            // we have the response
            
            //var obj = JSON.parse(response);
            alert(response);
        },
        error: function (e) {
            alert('Error: ' + e);
        }
    });
}