<%--
  Created by IntelliJ IDEA.
  User: nikod
  Date: 24/01/2022
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en"><head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport">
    <meta name="description">

    <!-- title -->
    <title>Contatti</title>

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

</head>
<body>

<!--PreLoader-->
<div class="loader" style="display: none;">
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
                            <li class="current-list-item"><a href="contactPage">Contatti</a></li>
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
</div>
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
<!-- end search arewa -->

<!-- breadcrumb-section -->
<div class="breadcrumb-section breadcrumb-bg">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 offset-lg-2 text-center">
                <div class="breadcrumb-text">
                    <p>Supporto 24/7 </p>
                    <h1>Contattaci</h1>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end breadcrumb section -->

<!-- contact form -->
<div class="contact-from-section mt-150 mb-150">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 mb-5 mb-lg-0">
                <div class="form-title">
                    <h2>Hai qualche domanda?</h2>
                    <p>Compila il questionario per risolvere tutti i tuoi dubbi!</p>
                </div>
                <div id="form_status"></div>
                <div class="contact-form">
                    <form type="POST" id="fruitkha-contact" onsubmit="return valid_datas( this );">
                        <p>
                            <input type="text" placeholder="Nome" name="name" id="name">
                            <input type="email" placeholder="Email" name="email" id="email">
                        </p>
                        <p>
                            <input type="tel" placeholder="Telefono" name="phone" id="phone">
                            <input type="text" placeholder="Argomento" name="subject" id="subject">
                        </p>
                        <p><textarea name="message" id="message" cols="30" rows="10" placeholder="Messaggio"></textarea></p>
                        <input type="hidden" name="token" value="FsWga4&amp;@f6aw">
                        <p><input type="submit" value="Invia" id="btnInvia"></p>
                    </form>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="contact-form-wrap">
                    <div class="contact-form-box">
                            <h4><i class="fas fa-map"></i> Indirizzo</h4>
                        <p>Pietro Bucci, Rende <br>  Calabria. <br> Italia</p>
                    </div>
                    <div class="contact-form-box">
                        <h4><i class="far fa-clock"></i> Orario</h4>
                        <p>LUN-VEN: 8:00 - 20:00 <br> SAB - DOM: 8:00 - 13:30  </p>
                    </div>
                    <div class="contact-form-box">
                        <h4><i class="fas fa-address-book"></i> Contatti</h4>
                        <p>Phone: +00 111 222 3333 <br> Email: support@onthebeach.com</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end contact form -->

<!-- find our location -->
<div class="find-location blue-bg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <p> <i class="fas fa-map-marker-alt"></i> Dove siamo</p>
            </div>
        </div>
    </div>
</div>
<!-- end find our location -->

<!-- google map section -->
<div class="embed-responsive embed-responsive-21by9">
    <!--
    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d26432.42324808999!2d-118.34398767954286!3d34.09378509738966!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x80c2bf07045279bf%3A0xf67a9a6797bdfae4!2sHollywood%2C%20Los%20Angeles%2C%20CA%2C%20USA!5e0!3m2!1sen!2sbd!4v1576846473265!5m2!1sen!2sbd" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen="" class="embed-responsive-item"></iframe>
-->
    <iframe src="https://maps.google.com/maps?q=universit%C3%A0%20della%20calabria%20pietro%20bucci%2087036&t=&z=13&ie=UTF8&iwloc=&output=embed"  width="600" height="450" frameborder="0" style="border:0;" allowfullscreen="" class="embed-responsive-item"></iframe>
    <!--
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

<script src="${pageContext.request.contextPath }/resources/assets/js/ricercaLido.js"></script>

<script>
    document.getElementById("btnInvia").addEventListener("click", function () {
        alert("Segnalazione inviata");
        //window.location.href="index";
    });
</script>

</body></html>

