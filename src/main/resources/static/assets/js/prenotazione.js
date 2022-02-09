


/*
window.addEventListener("load", function () {
    aggiungiEventi();

    function prenota(nomeLido) {
        console.log(numOmbrelloni);

        $.ajax({
            type: "POST",
            url: "/prenota",
            contentType: "application/json",
            data: {"nomeLido" : nomeLido},
            success: function (risposta) {
                console.log(risposta);
                if(risposta === "prenotazioneCreata")
                    console.log("prenotazione creata");
            },
            error: function (xhr) {
                console.log(xhr);
            }
        });
    }
});*/

var ombrelloni = [];


function Prenotazione(prezzoTotale, descrizione, dataPrenotazione, dataInizio, dataFine, usrCliente, nomeLido) {
    this.prezzoTotale = prezzoTotale;
    this.descrizione = descrizione;
    this.dataPrenotazione = dataPrenotazione;
    this.dataInizio = dataInizio;
    this.dataFine = dataFine;
    this.usrCliente = usrCliente;
    this.nomeLido = nomeLido;
}

function prenota(nomeLido) {
    var selectCheckedBoxes = document.querySelectorAll("input:checked");

    //if(selectCheckedBoxes.lenght < 0) {
    console.log('dentroprenota');
        selectCheckedBoxes.forEach(function (checkBox, indice) {
            console.log(checkBox);
            console.log(checkBox.getAttribute("id"));

            ombrelloni.push(checkBox.getAttribute("id"));
            //ombrelloni[indice] = checkBox.getAttribute("id");

        });


    jQuery.ajaxSettings.traditional=true;

    var dF = document.getElementById("dataFine").value;
    var dI = document.getElementById("dataInizio").value;

    var d = document.querySelector("#dataInizio");
    console.log(dI);
    console.log(dF);


    var d = document.querySelector("#dataInizio")


    $.ajax({
        type: "POST",
        url: "/prenota",
        data: {"nomeLido" : nomeLido, "dataInizio" : dI, "dataFine" : dF, ombrelloni : ombrelloni},
        success: function (risposta) {
            console.log(risposta);
            if(risposta === "prenotazioneCreata")
                console.log("prenotazione creata");
        },
        error: function (xhr) {
            console.log(xhr);
        }
    });
}

function annulla() {
    $.ajax({
        type: "POST",
        url: "/annullaPrenotazione",
        success: function (risposta) {
            if(risposta === "prenotazioneAnnullata") {
                alert("Prenotazione annullata");
                window.location.href = "index";
            }
        },
        error: function (xhr) {
            console.log(xhr);
        }
    });
}


function pagamentoInLoco() {
    alert("Pagamento che avverà nel loco.");
    window.location.href="index";
}


$('btnPagamentoInSede').click(function () {

    $.ajax({
        type: "POST",
        url: "/pagamentoInSede",
        success: function (risposta) {
            console.log(risposta);
            if(risposta === "emailInviata")
                alert("Pagamento in sede approvato!");
        },
        error: function (xhr) {
            console.log(xhr);
        }
    });
});
