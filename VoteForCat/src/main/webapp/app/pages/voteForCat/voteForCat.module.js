angular.module('catApp.voteForCat', ['catApp.service']).controller('VoteForCatController', VoteForCatController);

VoteForCatController.$inject = ['CatService', '$location'];

function VoteForCatController(CatService, $location) {
	var vm = this;
	
	vm.cat = CatService.getSelectedCat();
	
	vm.putCatById = function(id) {
		CatService.putCatById(id).then(function success() {
			alert("Thanks for your vote! Now we return to the home page");
			$location.path( "/cats" );
		},
		function failed(error) {
			alert("API Error: Cannot modify the cat by id");
		})
	}
}