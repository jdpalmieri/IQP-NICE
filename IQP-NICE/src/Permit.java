/*
 * @author Paul Jasmin
 * @author Jonathan Palmieri
 */
public class Permit {
	String permitNum, companyName, type, category, issued, expires, address;
	
	public Permit (String permitNum, String companyName, String type, String category, String issued, String expires, String address) {
		this.permitNum = permitNum;
		this.companyName = companyName;
		this.type = type;
		this.category = category;
		this.issued = issued;
		this.expires = expires;
		this.address = address;
	}
	
	public String formatForCSV() {
		return (permitNum + "," + type + "," + category + "," + issued + "," + expires  + ",");
	}

}
