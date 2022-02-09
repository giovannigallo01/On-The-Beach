<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Responsive Bootstrap4 Shop Template, Created by Imran Hossain from https://imransdesign.com/">

    <!-- title -->
    <title>${lido.nome}</title>

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

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        .checked {
            color: orange;
        }
    </style>

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
<div id="sticker-sticky-wrapper" class="sticky-wrapper" style="height: 50px;"><div class="top-header-area" id="sticker" style="">
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
                        <h3>Cerca per:</h3>
                        <input type="text" placeholder="Parola chiave" id="testoRicerca">
                        <a onclick="cerca()"><button type="submit">Cerca <i class="fas fa-search"></i></button></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end search area -->

<!-- breadcrumb-section -->
<div class="breadcrumb-section breadcrumb-bg">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 offset-lg-2 text-center">
                <div class="breadcrumb-text">
                    <p>Effettua la prenotazione </p>
                    <h1 id="nomeLido">${lido.nome}</h1>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end breadcrumb section -->

<!-- single product -->
<div class="single-product mt-150 mb-150">
    <div class="container">
        <div class="row">
            <div class="col-md-5">
                <div class="single-product-img">
                    <!-- da controllare le foto -->
                    <img src="data:image/png;base64,${foto}">
                </div>
            </div>
            <div class="col-md-7">
                <div class="single-product-content">
                    <h3>${lido.nome}</h3>
                    <p class="single-product-pricing"><span>1 giorno</span></p>
                    <p>${lido.descrizione}</p>
                    <div class="single-product-form">
                        <form method="get" action="product">
                            <table class="table table-responsive" id="tabellaOmbrelloni">
                                <tbody>
                                    <c:forEach items="${ombrelloni}" var="omb">
                                        <!--<c:if test="${omb.occupato == false}">-->
                                            <tr>
                                                <td><input type="checkbox" id="${omb.idOmbrellone}" /></td>
                                                <td>${omb.idOmbrellone}</td>
                                                <td id="prezzoOmbrellone">${omb.prezzo}</td>
                                            </tr>
                                        <!--</c:if>-->
                                    </c:forEach>
                                </tbody>
                            </table>
                        </form>

                        <br/>
                        <h2 class="label col-form-label">Data Inizio</h2>
                        <input type="date" id="dataInizio" class="dataTable-input bi-clipboard-data"><br/><br/>
                        <h2 class="label col-form-label">Data Fine</h2>
                        <input type="date" id="dataFine"><br/>

                        <br/>
                        <a href="checkout" class="cart-btn" onclick="prenota('${lido.nome}')">Prenota</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end single product -->

<!-- more products -->
<div class="more-products mb-150">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 offset-lg-2 text-center">
                <div class="section-title">
                    <h3><span class="orange-text">Recensioni</span></h3>
                </div>
            </div>
        </div>
        <div class="testimonial-section mt-150 mb-150">
            <div class="container">
                <div class="row">
                    <div class="col-lg-10 offset-lg-1 text-center">
                        <div class="testimonial-sliders">
                            <c:forEach items="${recensioni}" var="rec" varStatus="status">
                                <div class="single-testimonial-slider" onload="stelline('${rec.star}')">
                                    <div class="client-meta" id="headRecensione">
                                        <h3>
                                            ${rec.usernameCliente}
                                            <span class="fa fa-star checked" id="stelleSpan"> <h6>${rec.star}</h6></span>
                                        </h3>
                                        <p class="testimonial-body">
                                            " ${rec.testo} "
                                        </p>
                                        <div class="last-icon">
                                            <i class="fas fa-quote-right"></i>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

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
                    <form action="index.html">
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
<!-- main js -->
<script src="${pageContext.request.contextPath }/resources/assets/js/main.js"></script>

<script src="${pageContext.request.contextPath }/resources/assets/js/prenotazione.js"></script>

<script src="${pageContext.request.contextPath }/resources/assets/js/recensione.js"></script>

<script src="${pageContext.request.contextPath }/resources/assets/js/ricercaLido.js"></script>

</body></html>
