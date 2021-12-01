/*
 * @author Paul Jasmin
 * @author Jonathan Palmieri
 */
public class DBA {
	String dbaName, issued, expires;
	
	public DBA(String dbaName, String issued, String expires) {
		this.dbaName = dbaName;
		this.issued = issued;
		this.expires = expires;
	}
	
	public String formatForCSV() {
		return (dbaName + "," + issued + "," + expires + ",");
	}

}
