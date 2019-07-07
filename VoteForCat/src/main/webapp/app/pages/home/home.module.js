angular.module('catApp.home', ['catApp.service']).controller('HomeController', HomeController);

HomeController.$inject = ['CatService', '$location'];

function HomeController(CatService, $location) {
	var vm = this;
	
	vm.getAllCats = function() {
		CatService.getAllCats().then(function success(response) {
			vm.cats = response.data;
		},
		function failed(error) {
			alert("API Error : Cannot get all cats");
		})
	}
	
	vm.goToVoteCatById = function(id) {
		CatService.getCatById(id).then(function success(response) {
			vm.selectedCat = response.data;
			CatService.setSelectedCat(vm.selectedCat);
			$location.path( "/voteForCat" );
		},
		function failed(error) {
			alert("API Error : Cannot get cat by id");
		});
		
	}
	
	vm.getAllCats();
	
}