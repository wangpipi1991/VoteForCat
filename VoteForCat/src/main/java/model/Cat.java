package model;

public class Cat {
	private String id;
	private String img;
	private int count;
	
	public Cat() {}
	
	public Cat(String id, String img, int count) {
		this.id = id;
		this.img = img;
		this.count = count;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
