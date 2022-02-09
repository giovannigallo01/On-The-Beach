var btnUpdateInfoUtente = document.querySelector("#btnUpdateInfoUtente");
btnUpdateInfoUtente.addEventListener("click", function () {

    $.ajax({
        type: "POST",
        url: "/updateInfoUtente",
        //contentType: "application/json",
        //data: JSON.stringify(utente),
        success: function (risposta) {
            console.log(risposta);
            if(risposta === "Update Completato")
                alert("Modifica dati, avvenuta con successo!");
        },
        error: function (xhr) {
            console.log(xhr);
            //alert(xhr.responseText);
        }
    });
});


var btnUpdateInfoLido = document.querySelector("#btnUpdateInfoLido");
btnUpdateInfoLido.addEventListener("click", function () {

    $.ajax({
        type: "POST",
        url: "/updateInfoLido",
        success: function (risposta) {
            console.log(risposta);
            if(risposta === "Update Completato");
                alert("Modifica dati, avvenuta con successo");
        },
        error: function (xhr) {
            console.log(xhr);
        }
    });
})


function promuovi(username) {
    console.log(username);
    $.ajax({
            type: "POST",
            url: "/promozione",
            data: {"username": username},
            success: function (risposta) {
                console.log(risposta);
                if (risposta === "utentePromosso")
                    alert("Utente promosso!");
            },
            error: function (xhr) {
                console.log(xhr);
                //alert(xhr.responseText);
            }
        }
    )}

function rimuovi(username) {
    console.log(username);
    $.ajax({
            type: "POST",
            url: "/rimozione",
            data: {"username": username},
            success: function (risposta) {
                console.log(risposta);
                if (risposta === "utenteRimosso")
                    alert("Utente rimosso!");
            },
            error: function (xhr) {
                console.log(xhr);
                //alert(xhr.responseText);
            }
        }
    )}

function aggiornaRecensione(idPrenotazione, idRecensione) {
    var testo = document.getElementById("textRecensioni");
    var t = testo.value;

    jQuery.ajaxSettings.traditional=true;
    $.ajax({
        type: "POST",
        url: "/updateRecensione",
        data: {"idRecensione" : idRecensione, "idPrenotazione" : idPrenotazione,"testo" : t},
        success: function (risposta) {
            if(risposta === "updateCompletato")
                alert("Recensione aggiornata");
        },
        error: function (xhr) {
            console.log(xhr);
        }
    });
}


/*var btnUpdateRecensione = document.querySelector("#btnUpdateRecensione");
btnUpdateRecensione.addEventListener("click", function (idRecensione, testo) {
    $.ajax({
        type: "POST", url: "/updateRecensione",
data: {"idRecensione": idRecensione, "testo": testo},
 success: function (risposta) {
     console.log(risposta);
     if (risposta === "Update Completato") {
         alert("Modifica dati, avvenuta con successo!");
     }
 },
    error: function (xhr) {
        console.log(xhr);
        //alert(xhr.responseText);
    }
});
})*/


