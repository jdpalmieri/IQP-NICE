/*
 * @author Paul Jasmin
 * @author Jonathan Palmieri
 */
public class PPP {
	double round1, round2, round3, total, r1jobs, r2jobs, r3jobs;

	public PPP (double round1, double round2, double round3, double total, double r1jobs, double r2jobs, double r3jobs) {
		this.round1 = round1;
		this.round2 = round2;
		this.round3 = round3;
		this.total = total;
		this.r1jobs = r1jobs;
		this.r2jobs = r2jobs;
		this.r3jobs = r3jobs;
	}
	
	public String formatForCSV() {
		return (round1 + "," + r1jobs + "," + round2 + "," + r2jobs + "," + ","  + "," + "," + "," + total + ",");
	}
}
