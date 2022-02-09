<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Responsive Bootstrap4 Shop Template, Created by Imran Hossain from https://imransdesign.com/">

	<!-- title -->
	<title>On The Beach</title>

	<!-- favicon -->
	<link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath }/resources/assets/img/favicon2.png">
	<!-- google font -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
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
							<a href="index.jsp">
								<img src="${pageContext.request.contextPath }/resources/assets/img/logo.png" alt="">
							</a>
						</div>
						<!-- logo -->

						<!-- menu start -->
						<nav class="main-menu">
							<ul>
								<li class="current-list-item"><a href="index">Home</a></li>
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

	<!-- home page slider -->
	<div class="homepage-slider">
		<!-- single home slider -->
		<div class="single-homepage-slider homepage-bg-1">
			<div class="container">
				<div class="row">
					<div class="col-md-12 col-lg-7 offset-lg-1 offset-xl-0">
						<div class="hero-text">
							<div class="hero-text-tablecell">
								<p class="subtitle">Per un soggiorno speciale</p>
								<h1>Stabilimenti Balneari</h1>
								<div class="hero-btns">
									<a href="pageShop" class="boxed-btn">Prenota ora</a>
									<a href="contactPage" class="bordered-btn">Contattaci</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- single home slider -->
		<div class="single-homepage-slider homepage-bg-2">
			<div class="container">
				<div class="row">
					<div class="col-lg-10 offset-lg-1 text-center">
						<div class="hero-text">
							<div class="hero-text-tablecell">
								<p class="subtitle">Per una prenotazione 100% sicura</p>
								<h1>Controlla le nostre recensioni</h1>
								<div class="hero-btns">
									<a href="shop.html" class="boxed-btn">Visita Lidi</a>
									<a href="contactPage" class="bordered-btn">Contattaci</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- single home slider -->
		<div class="single-homepage-slider homepage-bg-3">
			<div class="container">
				<div class="row">
					<div class="col-lg-10 offset-lg-1 text-right">
						<div class="hero-text">
							<div class="hero-text-tablecell">
								<p class="subtitle">*SOLO* per proprietari di stabilimenti balneari</p>
								<h1>Inserisci un nuovo lido</h1>
								<div class="hero-btns">
									<a href="pageForm"class="boxed-btn">Richiedi Form</a>
									<a href="contactPage" class="bordered-btn">Contattaci</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end home page slider -->

	<!-- features list section -->
	<div class="list-section pt-80 pb-80">
		<div class="container">

			<div class="row">

				<div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
					<div class="list-box d-flex align-items-center">
						<div class="list-icon">
							<i class="fas fa-phone-volume"></i>
						</div>
						<div class="content">
							<h3>24/7 Supporto</h3>
							<p>Supporto disponibile ogni giorno</p>
						</div>
					</div>
				</div>

			</div>

		</div>
	</div>
	<!-- end features list section -->

	<!-- product section -->
	<div class="product-section mt-150 mb-150">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="section-title">	
						<h3><span class="orange-text">I nostri Stabilimenti Balneari</span></h3>
						<p>Per la tua vacanza ideale, in sicurezza, nei nostri migliori stabilimenti balneari.</p>
					</div>
				</div>
			</div>

			<div class="row">
				<c:forEach items="${lidi}" var="l" varStatus="status">
					<div class="col-lg-4 col-md-6 text-center">
						<div class="single-product-item">
							<div class="product-image">
								<a href="product?lido=${l.nome}"><img width="300" height="200" src="data:image/png;base64,${fotoLidi[status.index]}" alt=""></a>
							</div>
							<h3>${l.nome}</h3>
							<p class="product-price"><span>1 giorno</span> ${ombrelloni[status.index].prezzo} €</p>
							<a href="product?lido=${l.nome}" class="cart-btn"><i class="fas fa-shopping-cart"></i> Prenota</a>
						</div>
					</div>
				</c:forEach>
		</div>
	</div>
	<!-- end product section -->

	<!-- cart banner section -->
	<section class="cart-banner pt-100 pb-100">
    	<div class="container">
        	<div class="row clearfix">
            	<!--Image Column-->
            	<div class="image-column col-lg-6">
                	<div class="image">
							<div class="inner-price">
							</div>
                    	<img src="${pageContext.request.contextPath }/resources/assets/img/spox3.jpg" alt="">
                    </div>
                </div>
                <!--Content Column-->
                <div class="content-column col-lg-6">
					<h3><span class="orange-text">Lido</span> del mese</h3>
                    <h4>SPOX</h4>
                    <div class="text">Lo SPOX è uno degli stabilimenti balneari più famosi di Soverato. L'attività è aperta dal 2013 ed è situato in una posizione strategica sul lungomare. La prenotazione può essere composta da sdraio e lettino. E' incluso il servizio dj dalle 18 in poi, per vivere un'happy hour in riva al mare.</div>
                	<a href="product?lido=Spox" class="cart-btn mt-3"><i class="fas fa-shopping-cart"></i> Prenota</a>
                </div>
            </div>
        </div>
    </section>
    <!-- end cart banner section -->

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
							<li><a href="about.html">About</a></li>
							<li><a href="contactPage">Contatti</a></li>
						</ul>
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

    <script src="${pageContext.request.contextPath }/resources/assets/js/ricercaLido.js"></script>

</body>
</html>