<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Registrazione</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="${pageContext.request.contextPath }/resources/User/assets/img/favicon.png" rel="icon">
  <link href="${pageContext.request.contextPath }/resources/User/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="${pageContext.request.contextPath }/resources/User/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/resources/User/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/resources/User/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/resources/User/assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/resources/User/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/resources/User/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/resources/User/assets/vendor/simple-datatables/style.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="${pageContext.request.contextPath }/resources/User/assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: NiceAdmin - v2.2.0
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <main>
    <div class="container">

      <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

              <div class="d-flex justify-content-center py-4">
                <a href="/" class="logo d-flex align-items-center w-auto">
                  <img src="${pageContext.request.contextPath }/resources/User/assets/img/logo.png" alt="">
                  <span class="d-none d-lg-block">On The Beach</span>
                </a>
              </div><!-- End Logo -->

              <div class="card mb-3">

                <div class="card-body">

                  <div class="pt-4 pb-2">
                    <h5 class="card-title text-center pb-0 fs-4">Crea un account</h5>
                    <p class="text-center small">Inserisci i tuoi dati personali per creare un account</p>
                  </div>

                  <form class="row g-3 needs-validation" novalidate action="registrationServices" method="post">
                    <div class="col-12">
                      <label for="yourName" class="form-label">Nome</label>
                      <input type="text" name="nome" class="form-control" id="yourName" required>
                      <div class="invalid-feedback">Perfavore, inserisci il tuo nome</div>
                    </div>

                    <div class="col-12">
                      <label for="yourCognome" class="form-label">Cognome</label>
                      <input type="cognome" name="cognome" class="form-control" id="yourCognome" required>
                      <div class="invalid-feedback">Inserisci il tuo cognome!</div>
                    </div>

                    <div class="col-12">
                      <label for="yourEmail" class="form-label">Email</label>
                      <input type="email" name="email" class="form-control" id="yourEmail" required>
                      <div class="invalid-feedback">Inserisci un indirizzo email valido!</div>
                    </div>

                    <div class="col-12">
                      <label for="yourUsername" class="form-label">Username</label>
                      <div class="input-group has-validation">
                        <span class="input-group-text" id="inputGroupPrepend">@</span>
                        <input type="text" name="username" class="form-control" id="yourUsername" required>
                        <div class="invalid-feedback">Perfavore scegli un username!</div>
                      </div>
                    </div>

                    <div class="col-12">
                      <label for="yourPassword" class="form-label">Password</label>
                      <input type="password" name="password" class="form-control" id="yourPassword" required>
                      <div class="invalid-feedback">Inserisci la tua password!</div>
                    </div>

                    <div class="col-12">
                      <label for="yourGenere" class="form-label">Genere</label>
                      <select class="form-select" id="yourGenere" name="genere">
                        <option value="maschio">Maschio</option>
                        <option value="femmina">Femmina</option>
                        <option value="altro">Altro</option>
                      </select>
                      <div class="invalid-feedback">Inserisci il tuo genere!</div>
                    </div>

                    <div class="col-12">
                      <label for="yourTipo_utente" class="form-label">Scegli un tipo di utente:</label>
                      <select id="yourTipo_utente" name="tipo_utente" class="form-select">
                        <option value="">--Scegli un tipo di utente--</option>
                        <option value="Cliente">Cliente</option>
                        <option value="GestoreLido">Gestore Lido</option>
                      </select>
                      <div class="invalid-feedback">Scegli il tuo tipo di utente</div>
                    </div>

                    <div class="col-12">
                      <label for="dataNascita" class="col-form-label">Inserisci la tua data di nascita:</label>
                      <input type="date" id="dataNascita" name="dataNascita"
                             value="2001-01-01"
                             min="2001-01-01" max="2018-12-31" class="form-control">
                    </div>

                    <div class="col-12">
                      <div class="form-check">
                        <input class="form-check-input" name="terms" type="checkbox" value="" id="acceptTerms" required>
                        <label class="form-check-label" for="acceptTerms">Acconsento e accetto i <a href="#">termini e condizioni</a></label>
                        <div class="invalid-feedback">Devi accettare prima di proseguire.</div>
                      </div>
                    </div>
                    <div class="col-12">
                      <button class="btn btn-primary w-100" type="submit" id="btnReg">Registrati</button>
                    </div>
                  </form>

                </div>
              </div>

              <div class="credits">
                <!-- All the links in the footer should remain intact. -->
                <!-- You can delete the links only if you purchased the pro version. -->
                <!-- Licensing information: https://bootstrapmade.com/license/ -->
                <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
                <!--Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>-->
              </div>

            </div>
          </div>
        </div>

      </section>

    </div>
  </main><!-- End #main -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="${pageContext.request.contextPath }/resources/User/assets/vendor/apexcharts/apexcharts.min.js"></script>
  <script src="${pageContext.request.contextPath }/resources/User/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${pageContext.request.contextPath }/resources/User/assets/vendor/chart.js/chart.min.js"></script>
  <script src="${pageContext.request.contextPath }/resources/User/assets/vendor/echarts/echarts.min.js"></script>
  <script src="${pageContext.request.contextPath }/resources/User/assets/vendor/quill/quill.min.js"></script>
  <script src="${pageContext.request.contextPath }/resources/User/assets/vendor/simple-datatables/simple-datatables.js"></script>
  <script src="${pageContext.request.contextPath }/resources/User/assets/vendor/tinymce/tinymce.min.js"></script>
  <script src="${pageContext.request.contextPath }/resources/User/assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="${pageContext.request.contextPath }/resources/User/assets/js/main.js"></script>

</body>

</html>