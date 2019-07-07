angular.module('catApp.service', []).factory('CatService', CatService);

CatService.$inject = ['$http'];

function CatService($http) {
	var vm = this;
	
	vm.selectedCat = {};
	
	vm.getAllCats = function() {
		return $http.get('/api/cats');
	}
	
	vm.putCatById = function(id) {
		return $http.put('/api/cats/' + id);
	}
	
	vm.getCatById = function(id) {
		return $http.get('/api/cats/' + id);
	}
	
	vm.setSelectedCat = function(selectedCat) {
		vm.selectedCat = selectedCat;
	}
	
	vm.getSelectedCat = function() {
		return vm.selectedCat;
	}
	
	return vm;
}