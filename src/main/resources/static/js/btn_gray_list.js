const bDisplay = true;

function doDisplay() {
    const con = document.querySelectorAll(".layer_area");
    if(con.style.display == "none") {
        con.style.display == "block";
    } else {
        con.style.display == "none";
    }
}

// jQuery('#toggle').click(function() {
//     if($("#lyDelivery").css("display") == "none"){
//         jQuery("#lyDelivery").css("display", "block");
//     } else {
//         jQuery("#lyDelivery").css("display", "none");
//     }
// });

// const layerBtn = document.querySelector("layer_area");

// layerBtn = () => {
//     layerBtn.style.dispaly = block;
// }