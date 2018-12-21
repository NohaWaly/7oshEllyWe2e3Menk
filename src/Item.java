
public class Item {
	public String classification;
	public String category;
	public String color;
	public String shape;
	public String size;
	public String material;
	public String targeted_group;
	public String screen_size;
	public String city;
	public String District;
	public String street;
	public String Date;
	public int count=0;
	public Item(String classification, String category,String color,String shape, String size, String material,
			String targeted_group, String screen_size,String Date,String city,String District,String street) {
		this.category=category;
		this.color=color;
		this.classification=classification;
		this.shape=shape;
		this.size=size;
		this.material=material;
		this.targeted_group=targeted_group;
		this.screen_size=screen_size;
		this.city=city;
		this.District=District;
		this.street=street;
		this.Date=Date;
	}
}
