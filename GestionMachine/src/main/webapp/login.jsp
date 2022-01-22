<!DOCTYPE html>
<% String message = (String)request.getAttribute("message") ; %>
<% message = (message == null) ? "" : message; %>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="ressources/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="ressources/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <link rel="stylesheet" href="ressources/vendors/select2/select2.min.css">
    <link rel="stylesheet" href="ressources/vendors/select2-bootstrap-theme/select2-bootstrap.min.css">
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="ressources/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="ressources/images/favicon.png" />
  </head>
  <body>
    <div class="container-scroller">
        <!-- partial -->
        <div class="main-panel">
          <div class="content-wrapper">
            <div class="row d-flex justify-content-center">
              <div class="col-md-6 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">Connexion</h4>
                    <p class="card-description"> Entrez vos coordonnées</p>
                    <p class="text-danger"><%= message %></p>             
                    <form class="forms-sample" method="post" action="login">
                      <div class="form-group">
                        <label for="exampleInputUsername1">Email</label>
                        <input type="email" class="form-control" name="email" id="exampleInputUsername1" placeholder="Username">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword1">Mot de passe</label>
                        <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="Password">
                      </div>
                      <div class="form-check form-check-flat form-check-primary">
                        <label class="form-check-label">
                          <input type="checkbox" class="form-check-input"> Se souvenir de moi </label>
                      </div>
                      <button type="submit" class="btn btn-primary mr-2">Se connecter</button>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- content-wrapper ends -->
          <!-- partial:../../partials/_footer.html -->
          <footer class="footer">
            <div class="d-sm-flex justify-content-center justify-content-sm-between">
              <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © bootstrapdash.com 2020</span>
              <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center"> Free <a href="https://www.bootstrapdash.com/bootstrap-admin-template/" target="_blank">Bootstrap admin templates</a> from Bootstrapdash.com</span>
            </div>
          </footer>
          <!-- partial -->
        </div>
        <!-- main-panel ends -->
      </div>
      <!-- page-body-wrapper ends -->
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="ressources/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <script src="ressources/vendors/select2/select2.min.js"></script>
    <script src="ressources/vendors/typeahead.js/typeahead.bundle.min.js"></script>
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="ressources/js/off-canvas.js"></script>
    <script src="ressources/js/hoverable-collapse.js"></script>
    <script src="ressources/js/misc.js"></script>
    <script src="ressources/js/settings.js"></script>
    <script src="ressources/js/todolist.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
    <script src="ressources/js/file-upload.js"></script>
    <script src="ressources/js/typeahead.js"></script>
    <script src="ressources/js/select2.js"></script>
    <!-- End custom js for this page -->
  </body>
</html>