package service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import model.Cat;
import utils.JsonReader;

@Service
public class CatService {
	private List<Cat> cats = new ArrayList<Cat>();
	
	CatService() {
		try {
			String stringObject = JsonReader.readUrl("https://latelier.co/data/cats.json");
			Gson gson = new Gson();
			JsonObject jsonObject = gson.fromJson(stringObject, JsonObject.class);
			JsonElement jsonCatsList = jsonObject.get("images").getAsJsonArray();
			for (JsonElement jsonCat : jsonCatsList.getAsJsonArray()) {
				JsonObject jsonObjectCat = jsonCat.getAsJsonObject();
				String id = jsonObjectCat.get("id").getAsString();
				String img = jsonObjectCat.get("url").getAsString();
				Cat cat = new Cat();
				cat.setId(id);
				cat.setImg(img);
				cat.setCount((int)(Math.random() * 100));
	        	cats.add(cat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Cat> getAllCats() {
	    return this.cats;
	}
	
	public Cat getCatById(String id) {
		List<Cat> cats = getAllCats();
		return cats.stream().filter(cat-> id.equals(cat.getId())).findAny().orElse(null);
	}
	
	public void putCatCountById(String id) {
		Cat cat = getCatById(id);
		int count = cat.getCount();
		cat.setCount(count + 1);
	}
   
}
