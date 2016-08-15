window.safeApply = function(fn) {
  var phase = this.$root.$$phase;
  if(phase == '$apply' || phase == '$digest') {
    if(fn && (typeof (fn) === 'function')) {
      fn();
    }
  }
  else {
    this.$apply(fn);
  }
};

(function ($app) {
    angular.module('custom.controllers', []);

    app.controller('AdminController', ['$scope', '$http', '$location', '$rootScope', '$window', '$state', '$translate', 'Notification', function ($scope, $http, $location, $rootScope, $window, $state, $translate, Notification) {

        $scope.message = {};

        $scope.login = function () {

            $scope.message.error = undefined;

            var user = { username: $scope.username.value, password: $scope.password.value };

            $http({
                method: 'POST',
                url: 'auth',
                data: $.param(user),
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
            }).success(handleSuccess).error(handleError);
        }
        
        $rootScope.infiniteReached = function() {
          //
        }

        function handleSuccess(data, status, headers, config) {
            // Store data response on session storage
            // The session storage will be cleaned when the browser window is closed
            if(typeof(Storage) !== "undefined") {
                // save the user data on localStorage
                sessionStorage.setItem("_u",JSON.stringify(data));
            } else {
                // Sorry! No Web Storage support.
                // The home page may not work if it depends
                // on the logged user data
            }
            
            // Redirect to home page
            $state.go("home");
        }

        function handleError(data, status, headers, config) {
            var error = status == 401 ? $translate.instant('Login.view.invalidPassword') : data;
            Notification.error(error);
        }
    }]);

    app.controller('HomeController', ['$scope', '$http', '$rootScope', '$state', '$translate', 'Notification', function ($scope, $http, $rootScope, $state, $translate, Notification) {
        
        $scope.selecionado = {
          valor : 1
        }
        
        // When access home page we have to check
        // if the user is authenticated and the userData
        // was saved on the browser's sessionStorage
        $rootScope.session = (sessionStorage._u) ? JSON.parse(sessionStorage._u) : null;
        if(!$rootScope.session) {
          // If there isn't a user registered on the sessionStorage
          // we must send back to login page
          // TODO - REVISAR login oauth2
          //$state.go("login");
        }
        
        $rootScope.logout = function logout() {
            $http({
                method: 'GET',
                url: 'logout',
            }).then(handleSuccess, handleError)

            $rootScope.session = {};
        }

        function handleSuccess(data) {
            // Before redirect to login page we 
            // have to clean the user data from the 
            // session storage
            if(typeof(Storage) !== "undefined") {
                // save the user data on localStorage
                sessionStorage.removeItem("_u");
            } else {
                // It's not working with sessionStorage
            }
            $state.go("admin");
        }

        function handleError(error) {
            $rootScope.session.error = error;
        }
        
        $scope.changePassword = function () {
            var user = { oldPassword: oldPassword.value, newPassword: newPassword.value, newPasswordConfirmation: newPasswordConfirmation.value };
            $http({
                method: 'POST',
                url: 'changePassword',
                data: $.param(user),
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
            }).success(changeSuccess).error(changeError);
            
            function changeSuccess(data, status, headers, config) {
              Notification.info($translate.instant('Home.view.passwordChanged'));
              cleanPasswordFields();
            }
    
            function changeError(data, status, headers, config) {
                var error = status >= 401 ? $translate.instant('Home.view.InvalidPassword') : data;
                Notification.error(error);
            }     
            
            function cleanPasswordFields() {
                oldPassword.value = "";
                newPassword.value = "";
                newPasswordConfirmation.value = "";
                $("#modalPassword").modal("hide");
            }
        }
        
        var closeMenuHandler = function () {
          var element = $(this);
          if(element.closest('.sub-menu').length > 0) {
            element.closest(".navbar-nav").collapse('hide');
          }
        }
          
        $scope.$on('$viewContentLoaded', function(){
          var navMain = $(".navbar-nav");
          
          //Here your view content is fully loaded !!
          navMain.off("click", "a", closeMenuHandler);
          navMain.on("click", "a", closeMenuHandler);
        });
    }]);
    
    // General Commerce controller
    app.controller('PageCommerceController', ['$scope', '$http', '$location', '$rootScope', '$state', function ($scope, $http, $location, $rootScope, $state) {
      
      var service, id, test = $location.url().split('/commerce/')[1];
      $scope.logged = false;
      $scope.safeApply = safeApply;

      $scope.emptyShoppingCart = function(){
        $scope.products = [];
        $rootScope.shoppingcart = [];
        $rootScope.price = "0,00";
      }
      
      $scope.register = function(){
        var user = { email: $scope.User.email, name: $scope.User.name, login: $scope.User.login, password: $scope.User.password };
        $http({
            method: 'POST',
            url: 'registerNewUser',
            data: $.param(user),
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        }).success(registerClientOk).error(registerClientNok);
        
        function registerClientOk() {
          cleanRegisterFields();
          $state.go('login');
        }
    
        function registerClientNok() {
          cleanRegisterFields();
          var error = status >= 401 ? $translate.instant('Home.view.InvalidPassword') : data;
          Notification.error(error);
        }
        
        function cleanRegisterFields() {
          $scope.User.email = "";
          $scope.User.name = "";
          $scope.User.password = "";
        }
      }
      
      updateScope(test);
          
      $scope.$on('$locationChangeStart', function(event) {
        updateScope($location.url().split('/commerce/')[1]);
      });
      
      $scope.addCart = function(product){
        if (product != null){
          $rootScope.shoppingcart.push(product);
          $rootScope.price = (
            parseFloat($rootScope.price.replace(",", ".")) + 
            parseFloat(product.value.replace(',', '.'))).toString();
          };
        
        if ($rootScope.price && $rootScope.price.indexOf('.') != -1){
          $rootScope.price.replace('.', ',');
        } else {
          $rootScope.price += ',00';
        }
      }
      
      //configurando rotas de commerce
      function updateScope(test){
        if (typeof test !== 'undefined'){
          if (test.indexOf('?') != -1){
            var service = test.split('?')[0];
            var id = test.split('?')[1].split('=')[1];
          } else {
            service = test;
          }
  
          switch(service){
            case 'product':
              $http({
                    method: 'GET',
                    url: '/api/rest/cronoscommerce/Product/'+id,
                }).then(handleSuccess, handleError);
              
              function handleSuccess(response) {
                $scope.prod = response.data;
              }
              
              function handleError(error) {
                $scope.prod.error = error;
              }
            break;
            case 'products':
              if (id){
                $http({
                    method: 'GET',
                    url: '/api/rest/cronoscommerce/Product/listBySub_category/'+id,
                }).then(handleSuccess, handleError);
              } else {
                $http({
                    method: 'GET',
                    url: '/api/rest/cronoscommerce/Product'
                }).then(handleSuccess, handleError);
              }
              
              function handleSuccess(response) {
                $scope.products = response.data.content;
              }
      
              function handleError(error) {
                $scope.products.error = error;
              }
              break;
            case 'shoppingcart':
              if ($rootScope.shoppingcart){
                $scope.products = $rootScope.shoppingcart;
              }
              break;
            case 'login':
             $scope.logon = function(){
                if ($scope.user == "cliente" && $scope.password == "123"){
                  $scope.clientLogged = true;
                } else{
                  alert('usuario e senha invalido');
                  $scope.clientLogged = false;
                }
              }
              break;  
          }
        }
      }
    }]);
} (app));
