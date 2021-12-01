/*
 * @author Paul Jasmin
 * @author Jonathan Palmieri
 */
public class RSG {
	String name, description, DBAname, corpStructure;
	int FTE, PTE;
	double rev19, rev20, exp19, exp20;
	
	public RSG (String name, String description, String DBAname, String corpStructure, int FTE, int PTE, double rev19, double rev20, double exp19, double exp20) {
		this.name = name;
		this.description = description;
		this.DBAname = DBAname;
		this.corpStructure = corpStructure;
		this.FTE = FTE;
		this.PTE = PTE;
		this.rev19 = rev19;
		this.rev20 = rev20;
		this.exp19 = exp19;
		this.exp20 = exp20;
	}
	
	public String formatForCSV() {
		return (description + "," + corpStructure + "," + FTE + "," + PTE + "," + rev19  + "," + exp19 + "," + rev20 + "," + exp20 + ",");
	}

}
