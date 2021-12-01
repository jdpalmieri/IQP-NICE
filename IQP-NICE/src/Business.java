import java.util.ArrayList;
/*
 * @author Paul Jasmin
 * @author Jonathan Palmieri
 */
public class Business {
	
String name, sector, address;
int NAICS;
PPP ppp;
DBA dba;
License license;
ArrayList<License> licenses;
ArrayList<Permit> permits;
RSG rsg;
Permit permit;

	public Business (String name, String sector, int NAICS, String address, PPP ppp, DBA dba, License license, RSG rsg) {
		this.name = name;
		this.sector = sector;
		this.NAICS = NAICS;
		this.ppp = ppp;
		this.dba = dba;
		this.license = license;
		this.address = address;
	}
	public Business (String name, String sector, int NAICS, String address, PPP ppp, DBA dba, ArrayList<License> licenses, RSG rsg) {
		this.name = name;
		this.sector = sector;
		this.NAICS = NAICS;
		this.ppp = ppp;
		this.dba = dba;
		this.licenses = licenses;
		this.address = address;
	}
	
	public Business (String name, String sector, int NAICS, String address, PPP ppp, DBA dba, License license, RSG rsg, Permit permit) {
		this.name = name;
		this.sector = sector;
		this.NAICS = NAICS;
		this.ppp = ppp;
		this.dba = dba;
		this.license = license;
		this.permit = permit;
		this.address = address;
	}
	
	public Business (String name, String sector, int NAICS, String address, PPP ppp, DBA dba, License license, RSG rsg, ArrayList<Permit> permits) {
		this.name = name;
		this.sector = sector;
		this.NAICS = NAICS;
		this.ppp = ppp;
		this.dba = dba;
		this.permits = permits;
		this.address = address;
	}
	
	public String formatToCSV() {
		String pppPrint, dbaPrint, licensePrint, rsgPrint, permitPrint;

		//System.out.println("Processing: " + this.address);

		if(this.ppp != null) {
			pppPrint = this.ppp.formatForCSV();
		}
		else {
			pppPrint = (",,,,,,,,,");
		}
		
		if(this.dba != null) {
			dbaPrint = this.dba.formatForCSV();
		}
		else {
			dbaPrint = (",,,");
		}
		
		if(this.rsg != null) {
			rsgPrint = this.rsg.formatForCSV();
		}
		else {
			rsgPrint = (",,,,,,,,");
		}
		
		if(this.license != null) {
			licensePrint = this.license.formatForCSV();
		}
		else {
			licensePrint = (",,,,");
		}
		
		if(this.permit != null) {
			permitPrint = this.permit.formatForCSV();
		}
		else {
			permitPrint = (",,,,,");
		}
		
		
		return (this.name + "," + this.sector + "," + this.NAICS + "," + this.address + "," + pppPrint + dbaPrint + licensePrint + rsgPrint + permitPrint);
	}
	
}
