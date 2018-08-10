
public class PersonItem {
	
	String name, latitude,lonitude;
	 long user_id;
	 Double distance;
	public PersonItem() {}
	public PersonItem(String name, String latitude,String longitude, long user_id) {
		this.name = name;
		this.latitude = latitude;
		this.lonitude = longitude;
		this.user_id =user_id;
	}
	public PersonItem(String name, String latitude,String longitude, long user_id,Double distance) {
		this.name = name;
		this.latitude = latitude;
		this.lonitude = longitude;
		this.user_id =user_id;
		this.distance = distance;
	}
	
	

}
