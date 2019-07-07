package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Cat;
import service.CatService;

@RestController
@RequestMapping("/api")
public class CatController {
	
	@Autowired
	private CatService catService;
	
	@RequestMapping(method=RequestMethod.GET, value="cats")
	public List<Cat> getAllCats() {
		return catService.getAllCats();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="cats/{id}")
	public Cat getCatById(@PathVariable("id") String id) {
		return catService.getCatById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="cats/{id}")
	public void putCatCountById(@PathVariable("id") String id) {
		catService.putCatCountById(id);
	}
}
