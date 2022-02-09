<%--
  Created by IntelliJ IDEA.
  User: nikod
  Date: 25/01/2022
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en"><head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description">

    <!-- title -->
    <title>Richiesta Registrazione Lido</title>

    <!-- favicon -->
    <link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath }/resources/assets/img/favicon2.png">
    <!-- google font -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&amp;display=swap" rel="stylesheet">
    <!-- fontawesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/all.min.css">
    <!-- bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/bootstrap/css/bootstrap.min.css">
    <!-- owl carousel -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/owl.carousel.css">
    <!-- magnific popup -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/magnific-popup.css">
    <!-- animate css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/animate.css">
    <!-- mean menu css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/meanmenu.min.css">
    <!-- main style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/main.css">
    <!-- responsive -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/responsive.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/scss/maps.css" />

</head>
<body>

<!--PreLoader-->
<div class="loader">
    <div class="loader-inner">
        <div class="circle"></div>
    </div>
</div>
<!--PreLoader Ends-->

<!-- header -->
<div class="top-header-area" id="sticker">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-sm-12 text-center">
                <div class="main-menu-wrap">
                    <!-- logo -->
                    <div class="site-logo">
                        <a href="index">
                            <img src="${pageContext.request.contextPath }/resources/assets/img/logo.png" alt="">
                        </a>
                    </div>
                    <!-- logo -->

                    <!-- menu start -->
                    <nav class="main-menu">
                        <ul>
                            <li><a href="index">Home</a></li>
                            <li><a href="pageShop">Prenota Qui</a></li>
                            <li><a href="contactPage">Contatti</a></li>
                            <li>
                                <div class="header-icons">
                                    <c:if test="${username == null}">
                                        <a class="shopping-cart" href="login"><i class="fas fa-shopping-bag"></i></a>
                                    </c:if>
                                    <c:if test="${username != null}">
                                        <a class="shopping-cart" href="profile"><i class="fas fa-shopping-cart"></i></a>
                                    </c:if>
                                    <a class="mobile-hide search-bar-icon" href="#"><i class="fas fa-search"></i></a>
                                </div>
                            </li>
                        </ul>
                    </nav>
                    <a class="mobile-show search-bar-icon" href="#"><i class="fas fa-search"></i></a>
                    <div class="mobile-menu"></div>
                    <!-- menu end -->
                </div>
            </div>
        </div>
    </div>
</div></div>
<!-- end header -->

<!-- search area -->
<div class="search-area">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <span class="close-btn"><i class="fas fa-window-close"></i></span>
                <div class="search-bar">
                    <div class="search-bar-tablecell">
                        <h3>Search For:</h3>
                        <input type="text" placeholder="Parola chiave" id="testoRicerca">
                        <a onclick="cerca()"><button type="submit">Cerca <i class="fas fa-search"></i></button></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end search area -->

<div class="breadcrumb-section breadcrumb-bg">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 offset-lg-2 text-center">
                <div class="breadcrumb-text">
                    <h1>RICHIESTA REGISTRAZIONE STABILIMENTO BALNEARE</h1>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- contact form -->
<div class="contact-from-section mt-150 mb-150">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 mb-5 mb-lg-0">
                <div class="form-title">
                    <h2>Sei il gestore di uno stabilimento balneare?</h2>
                    <p>Compila il questionario per richiedere la registrazione del tuo lido!</p>
                </div>
                <div id="form_status"></div>
                <p class="contact-form">
                    <form method="post" action="InsertLido" enctype="multipart/form-data">
                        <p>
                            <input type="text" placeholder="Nome Lido" name="nome" id="inputNome" required>
                    </p>
                    <p>
                            <input type="text" placeholder="(Username)Gestore Lido"name="usernameGestore" id="inputUsernameGestore" required>
                </p>
                <p>
                    <input type="text" placeholder="Località" name="posizione" id="inputPosizione" required>
                </p>
                <p>
                    <input type="tel" placeholder="Telefono" name="numero" id="inputTelefono" required>
                </p>
                        <p>
                            <input type="email" placeholder="Email" name="email" id="inputEmailLido">
                        </p>
                <p>
                    <label for="inputNumOmbrelloni">Numero Ombrelloni:</label>
                    <input type="number"
                           id="inputNumOmbrelloni" name="numeroOmbrelloni">
                </p>
                <p>
                <label for="inputFoto">Inserisci Foto:</label>
                <input type="file"
                       id="inputFoto" name="foto"
                       accept="image/png, image/jpeg" multiple>

                </p>
                        <p><textarea name="descrizione" id="inputDescrizione" cols="100" rows="7" placeholder="Descrizione"></textarea></p>
                        <input type="hidden" name="token" value="FsWga4&amp;@f6aw">
                        <p><input type="submit" id="btnInsertLido" value="Invia"></p>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>
<!-- end contact form -->




<div style="display: none">
    <input
            id="pac-input"
            class="controls"
            type="text"
            placeholder="Enter a location"
    />
</div>
<div id="map"></div>
<div id="infowindow-content">
    <span id="place-name" class="title"></span><br />
    <strong>Place ID</strong>: <span id="place-id"></span><br />
    <span id="place-address"></span>
</div>

<!-- Async script executes immediately and must be after any DOM elements used in callback. -->
<script
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAPPE3t9S8PbhsknpEBc6bAxQu5She2k_Q&callback=initMap&libraries=places&v=weekly"
        async
></script>

<!-- end find our location -->


<!-- google map section
<div class="embed-responsive embed-responsive-21by9">

    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d26432.42324808999!2d-118.34398767954286!3d34.09378509738966!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x80c2bf07045279bf%3A0xf67a9a6797bdfae4!2sHollywood%2C%20Los%20Angeles%2C%20CA%2C%20USA!5e0!3m2!1sen!2sbd!4v1576846473265!5m2!1sen!2sbd" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen="" class="embed-responsive-item"></iframe>

    <iframe src="https://maps.google.com/maps?q=universit%C3%A0%20della%20calabria%20pietro%20bucci%2087036&t=&z=13&ie=UTF8&iwloc=&output=embed"  width="600" height="450" frameborder="0" style="border:0;" allowfullscreen="" class="embed-responsive-item"></iframe>

    <div class="mapouter"><div class="gmap_canvas"><iframe width="600" height="500" id="gmap_canvas" src="https://maps.google.com/maps?q=pietro%20bucci%20rende&t=&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe><a href="https://fmovies-online.net">fmovies</a><br><style>.mapouter{position:relative;text-align:right;height:500px;width:600px;}</style><a href="https://www.embedgooglemap.net">google custom map</a><style>.gmap_canvas {overflow:hidden;background:none!important;height:2500px;width:2600px;}</style></div></div>
-->
</div>
<!-- end google map section -->


<!-- footer -->
<div class="footer-area">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-6">
                <div class="footer-box about-widget">
                    <h2 class="widget-title">About us</h2>
                    <p>Siamo un gruppo di 4 studenti che hanno realizzato questo sito per un progetto universitario.</p>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="footer-box get-in-touch">
                    <h2 class="widget-title">Resta in Contatto</h2>
                    <ul>
                        <li> Italia, Calabria, Rende, 87036, Via Pietro Bucci</li>
                        <li>support@onthebeach.com</li>
                        <li>+00 111 222 3333</li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="footer-box pages">
                    <h2 class="widget-title">Pagine</h2>
                    <ul>
                        <li><a href="index">Home</a></li>
                        <li><a href="pageShop">Negozio</a></li>
                        <li><a href="contactPage">Contatti</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="footer-box subscribe">
                    <h2 class="widget-title">Subscribe</h2>
                    <p>Iscriviti con la tua mail per ottenere i prossimi aggiornamenti.</p>
                    <form action="index">
                        <input type="email" placeholder="Email">
                        <button type="submit"><i class="fas fa-paper-plane"></i></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end footer -->

<!-- copyright -->
<div class="copyright">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-12">
                <p>Copyrights &copy; 2022 - <a href="https://informatica.unical.it/">Unical</a>,  All Rights Reserved.
                </p>
            </div>
            <div class="col-lg-6 text-right col-md-12">
                <div class="social-icons">

                </div>
            </div>
        </div>
    </div>
</div>
<!-- end copyright -->

<!-- jquery -->
<script src="${pageContext.request.contextPath }/resources/assets/js/jquery-1.11.3.min.js"></script>
<!-- bootstrap -->
<script src="${pageContext.request.contextPath }/resources/assets/bootstrap/js/bootstrap.min.js"></script>
<!-- count down -->
<script src="${pageContext.request.contextPath }/resources/assets/js/jquery.countdown.js"></script>
<!-- isotope -->
<script src="${pageContext.request.contextPath }/resources/assets/js/jquery.isotope-3.0.6.min.js"></script>
<!-- waypoints -->
<script src="${pageContext.request.contextPath }/resources/assets/js/waypoints.js"></script>
<!-- owl carousel -->
<script src="${pageContext.request.contextPath }/resources/assets/js/owl.carousel.min.js"></script>
<!-- magnific popup -->
<script src="${pageContext.request.contextPath }/resources/assets/js/jquery.magnific-popup.min.js"></script>
<!-- mean menu -->
<script src="${pageContext.request.contextPath }/resources/assets/js/jquery.meanmenu.min.js"></script>
<!-- sticker js -->
<script src="${pageContext.request.contextPath }/resources/assets/js/sticker.js"></script>
<!-- form validation js -->
<script src="${pageContext.request.contextPath }/resources/assets/js/form-validate.js"></script>
<!-- main js -->
<script src="${pageContext.request.contextPath }/resources/assets/js/main.js"></script>

<script src="${pageContext.request.contextPath }/resources/User/assets/js/gestioneLido.js"></script>
<script src="${pageContext.request.contextPath }/resources/assets/js/googlemaps.js"></script>

<script src="${pageContext.request.contextPath }/resources/assets/js/ricercaLido.js"></script>
</body></html>

