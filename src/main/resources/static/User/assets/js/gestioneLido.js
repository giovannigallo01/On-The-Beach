var btnInsertLido = document.querySelector("#btnInsertLido");
btnInsertLido.addEventListener("click", function () {

    $.ajax({
        type: "POST",
        url: "/InsertLido",
        //contentType: "application/json",
        //data: JSON.stringify(lido),
        success: function (risposta) {
            console.log(risposta);
            if(risposta === "Inserimento Completato")
                alert("Modifica dati, avvenuta con successo!");
        },
        error: function (xhr) {
            console.log(xhr);
            //alert(xhr.responseText);
        }
    });
});
