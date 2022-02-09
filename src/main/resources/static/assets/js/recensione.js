
function stelline(star) {

    //var span = "<span class='fa fa-star checked'></span>";
    /*var tag = document.createElement("span");
    tag.className = "fa fa-star checked";*/
    /*var takeFather = document.getElementById("headRecensione");
    for(let i=0; i<star; ++i)
        takeFather.appendChild("<span class='fa fa-star checked'></span>");*/
    console.log(star);
    const d = document.getElementById("stelleSpan");
    /*for(let i=0; i<star; ++i) {
        console.log("quante stelle?" + i);
        var span = document.createElement("span");
        span.setAttribute("class", "fa fa-star checked");
    }*/

    function getSpan() {
        var span = document.createElement("span");
        span.setAttribute("class", "fa fa-star checked");
        return null;
    }

    for(let i=0; i<star; ++i) {
        document.getElementById("headRecensione").appendChild(getSpan());
    }
}

//window.onload = stelline;


$(document).ready(function () {
    stelline;
});
