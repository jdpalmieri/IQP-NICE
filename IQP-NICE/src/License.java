/*
 * @author Paul Jasmin
 * @author Jonathan Palmieri
 */
public class License {
	String licenseNum, licenseName, type, category;
	
	public License (String licenseNum, String licenseName, String type, String category) {
		this.licenseName = licenseName;
		this.licenseNum = licenseNum;
		this.type = type;
		this.category = category;

	}
	
	public String formatForCSV() {
		System.out.println(licenseNum + "," + licenseName + "," + type + "," + category + ",");
		return (licenseNum + "," + licenseName + "," + type + "," + category + ",");
	}

}
