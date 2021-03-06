function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();
    $("#name").text(profile.getName());
    $("#email").text(profile.getEmail());
    $("#image").attr('src', profile.getImageUrl());
    $(".data").css("display", "block");
    $(".g-signin2").css("display", "none");

    $.ajax({
        type: "POST",
        url: "/registrationServicesGoogle",
        data: {"username" : profile.getEmail(),
            "email" : profile.getEmail(),
            "nome" : profile.getName()},
        success: function (risposta) {
            console.log(risposta);
        },
        error: function (xhr) {
            console.log(xhr);
        }
    });
}

function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        alert("You have been signed out successfully");
        $(".data").css("display", "none");
        $(".g-signin2").css("display", "block");
    });
}