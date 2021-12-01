import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/*
 * @author Jonathan Palmieri
 * @author Paul Jasmin
 */
public class ReadFile {
	//"LicenseeList2021.csv"
	public static ArrayList<String> lines = new ArrayList<String>();

	public static final String PATH2 = "C:\\Users\\Paul\\Desktop\\IQP\\CSVs\\DBA CSV.csv";
	public static final String PATH3 = "C:\\Users\\Paul\\Desktop\\IQP\\CSVs\\Rock Solid Grant.csv";
	public static final String PATH4 = "C:\\Users\\Paul\\Desktop\\IQP\\CSVs\\Alcohol License Data.csv";
	public static final String PATH5 = "C:\\Users\\Paul\\Desktop\\IQP\\CSVs\\PPP.csv";
	public static final String PATH6 = "C:\\Users\\Paul\\Desktop\\IQP\\CSVs\\Permit Data.csv";
	public static final String PATH7 = "C:\\Users\\Paul\\Desktop\\IQP\\CSVs\\PPP FULL.csv";
	// input location of desired file to read from its file location in computer
	
	public static File fileDBA = new File(PATH2);
	public static File fileRSG = new File(PATH3);
	public static File fileALC = new File(PATH4);
	public static File filePPP = new File(PATH5);
	public static File filePERM = new File(PATH6);
	public static File filePPPFULL = new File(PATH7);
	
	
	static ArrayList <Business> Businesses = new ArrayList<Business>();
	
	
	public static void main(String[] args) throws Exception {
		//addLine(file);
	    //System.out.flush();
		//Businesses.forEach(e -> System.out.println(e.address));
	    //ScannerCSV(file);
	    //System.out.printf("this: %d", 4);	
		
		
		read(fileDBA);
		processDBA(lines);
		lines = new ArrayList<String>();
		
		//read(filePPP);
		read(filePPPFULL);
		processPPP(lines);
		lines = new ArrayList<String>();
		

		read(fileRSG);
		processRSG(lines);
		lines = new ArrayList<String>();
		
		read(fileALC);
		processLicense(lines);
		lines = new ArrayList<String>();
		
		read(filePERM);
		processPermit(lines);
		lines = new ArrayList<String>();
		
		pasteToExcel();		
     
	}
	
	public static void read(File file) {
		try {
	        Scanner sc = new Scanner(file);
	        while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lines.add(line);
                //System.out.println(line);
            }
	        sc.close();
	        //System.out.println(lines.size());
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
		
	}
	
	public static String removeChar(String s, char c) {
		String temp ="";
		for(char c1 : s.toCharArray()) {
			if(c1 != c) {
				temp += c1;
			}
		}
		return temp;
	}
	
	public static String removeChar(String s1, String s2) {
		String temp2 = s1;
		for(char c : s2.toCharArray()) {
			temp2 = removeChar(temp2, c);
		}
		return temp2;
	}
	  	
	public static float stringSimilarity(String s1, String s2) {
		int size;
		int dif = 0;
		int start = 0;
		int count = 0;
		int total = 0;
		
		//s1 = s1.toLowerCase();
		//s2 = s2.toLowerCase();
		s1 = removeChar(s1, " ");
		s2 = removeChar(s2, " ");
		if(s1.equals(s2)) {
			return 1;
		}	
		//System.out.println(dif);
		ArrayList<String> temp = new ArrayList<String>();
		if(s1.length() > s2.length()) {
			size = s1.length();
			dif = s1.length()-s2.length();
			for(int i = 0; i < dif; i++) {
				s2 = s2 + ";";
			}
		}else {
			size = s2.length();
			dif = s2.length()-s1.length();
			for(int i = 0; i < dif; i++) {
				s1 = s1 + ";";
			}
		}
		
		//System.out.println(s1);	
		for(int i = 0; i < size; i++) {
			if(s1.charAt(i) != s2.charAt(i)){
				temp.add(s1.substring(start,i));
				start = i;
				if(temp.get(temp.size()-1).equals(";")){
					count++;
				}
			}
		}
		
		//printArray(temp);
		for(int i = 0; i < count; i++) {
			temp.remove(";");
		}
		
		//printArray(temp);
		for(String s : temp) {
			if(s2.contains(s)) {
				total += s.length();
			}			
		}
	 	//System.out.println((double)total/(double)size);
		return (float)((double)total/(double)size);
	}
	
	public static float stringSimilarity2(String s1, String s2) {
		int size;
		int dif = 0;
		int start = 0;
		int count = 0;
		int total = 0;
		//boolean b = s1.length() > s2.length();
		//s1 = s1.toLowerCase();
		//s2 = s2.toLowerCase();
		s1 = removeChar(s1, " ");
		s2 = removeChar(s2, " ");
		boolean b = s1.length() > s2.length();
		if(s1.equals(s2)) {
			return 1;
		}
		//System.out.println(dif);
		ArrayList<String> temp = new ArrayList<String>();
		if(b) {
			size = s1.length();
			dif = s1.length()-s2.length();
			for(int i = 0; i < dif; i++) {
				s2 = s2 + ";";
			}
		}else {
			size = s2.length();
			dif = s2.length()-s1.length();
			for(int i = 0; i < dif; i++) {
				s1 = s1 + ";";
			}
		}
		
		//System.out.println(s1);
		if(b) {
			for(int i = 0; i < size; i++) {
				if(s1.charAt(i) != s2.charAt(i)){
					temp.add(s1.substring(start,i));
					start = i;
					if(temp.get(temp.size()-1).equals(";")){
						count++;
					}
				}
			}
		}else {
			for(int i = 0; i < size; i++) {
				if(s1.charAt(i) != s2.charAt(i)){
					temp.add(s2.substring(start,i));
					start = i;
					if(temp.get(temp.size()-1).equals(";")){
						count++;
					}
				}
			}
		}
		
		//printArray(temp);
		for(int i = 0; i < count; i++) {
			temp.remove(";");
		}
		
		//printArray(temp);
		if(b) {
			for(String s : temp) {
				if(s2.contains(s)) {
					total += s.length();
				}
			}
		}else {
			for(String s : temp) {
				if(s1.contains(s)) {
					total += s.length();
				}
			}
		}
		
	 	//System.out.println((double)total/(double)size);
		return (float)((double)total/(double)size);
	}
	
	public static String processAddress(String a) {
		String[] streets = {"Street", "street", "STREET"};
		String[] roads = {"Road", "road", "ROAD"};
		String[] aves = {"Avenue", "avenue", "AVENUE"};
		String[] lanes = {"Lane", "lane", "LANE"};
		String[] drives = {"Drive", "drive", "DRIVE"};
		String[] ways = {"Way", "way", "WAY"};
		
		if(a == null) {
			return "";
		}
		
		for(int i = 0; i<streets.length; i++) {
			if (a.contains(streets[i])) {
				a = a.replace(streets[i], "st");
				break;
			}
		}
		
		for(int i = 0; i<roads.length; i++) {
			if (a.contains(roads[i])) {
				a = a.replace(roads[i], "rd");
				break;
			}
		}
		
		for(int i =0; i<aves.length; i++) {
			if (a.contains(aves[i])) {
				a = a.replace(aves[i], "ave");
				break;
			}
		}

		for(int i =0; i<lanes.length; i++) {
			if (a.contains(lanes[i])) {
				a = a.replace(lanes[i], "ln");
				break;
			}
		}
		
		for(int i =0; i<drives.length; i++) {
			if (a.contains(drives[i])) {
				a = a.replace(drives[i], "dr");
				break;
			}
		}
		
		for(int i = 0; i<ways.length; i++) {
			if (a.contains(ways[i])) {
				a = a.replace(ways[i], "st");
				break;
			}
		}
		
		
		a = a.replace(".", "");
		a = a.replace(",", "");
		a = a.replace(" ", "");
		
		return a.toLowerCase().trim();
}
	
	
	public static void processDBA (ArrayList<String> lines) {
		lines.remove(0);
		
		for(String line: lines) {
			//System.out.println(line);
			String[] splitLines = line.split("," , -1);
			//for (int i =0; i<splitLines.length; i++) {
				//System.out.println(i + " : " + splitLines[i]);
			//}
			boolean foundMatch = false;
			for (Business business: Businesses) {
				if(business.address != null) {
					//System.out.println("Compare: " + splitLines[1] + " : " + business.address);
				}
				if(processAddress(splitLines[1]).equals(processAddress(business.address))){
					foundMatch = true;
					if (business.dba == null) {
						business.dba = new DBA(splitLines[0], splitLines[4], splitLines[6]);
					}
				}
		   }
			if (!foundMatch) {
				Business b = new Business("", "", 0 , splitLines[1].trim(), (PPP)null, (DBA)null, (License)null, (RSG)null);
				Businesses.add(b);
				b.dba = new DBA(splitLines[0], splitLines[4], splitLines[6]);
			}
		}
	}

	
	public static void processRSG(ArrayList<String> lines) {
		lines.remove(0);
		lines.remove(lines.size()-1);
		
		
		
		for(String line: lines) {
			String[] splitLines = line.split("," , -1);
			
			
	
			boolean foundMatch = false;
			for (Business business: Businesses) {
				if(business.address != null) {
					//System.out.println("Compare: " + splitLines[15] + " : " + business.address);
				}
				if(processAddress(splitLines[15]).equals(processAddress(business.address))){
					foundMatch = true;
						if(business.rsg !=null){
								continue;
						}
						else {
						business.rsg = new RSG(splitLines[0], splitLines[7], splitLines[1], splitLines[3], Integer.parseInt(splitLines[5]), Integer.parseInt(splitLines[6]), Double.parseDouble(splitLines[11]), Double.parseDouble(splitLines[13]), Double.parseDouble(splitLines[12]), Double.parseDouble(splitLines[14]));
						business.name = splitLines[0];
						continue;
						}
				}
		   }
			if (!foundMatch) {
				Business b = new Business(splitLines[0], "", 0 , splitLines[15].trim(), (PPP)null, (DBA)null, (License)null, (RSG)null, (Permit)null);
				Businesses.add(b);
				b.rsg = new RSG(splitLines[0], splitLines[7], splitLines[1], splitLines[3], Integer.parseInt(splitLines[5]), Integer.parseInt(splitLines[6]), Double.parseDouble(splitLines[11]), Double.parseDouble(splitLines[13]), Double.parseDouble(splitLines[12]), Double.parseDouble(splitLines[14]));
			}
		}
	}

	
	public static void processLicense(ArrayList<String> lines) {

		lines.remove(0);
		
		for(String line: lines) {
			String[] splitLines = line.split("," , -1);
			
			boolean foundMatch = false;
			for (Business business: Businesses) {
				if(business.address != null) {
					//System.out.println("Compare: " + splitLines[3] + " : " + business.address);
				}
				if(processAddress(splitLines[3]).equals(processAddress(business.address))){
					foundMatch = true;
						if(business.license !=null){
								continue;
						}
						else {
						business.license = new License(splitLines[0], splitLines[1], splitLines[7], splitLines[8]);
						continue;
						}
				}
		   }
			if (!foundMatch) {
				Business b = new Business("", "", 0 , splitLines[3].trim(), (PPP)null, (DBA)null, (License)null, (RSG)null);
				Businesses.add(b);
				b.license = new License(splitLines[0], splitLines[1], splitLines[7], splitLines[8]);
			}
		}
	}
	

	
	public static void processPermit(ArrayList<String> lines) {
		lines.remove(0);
		
		for(String line: lines) {
			String[] splitLines = line.split("," , -1);
			
			boolean foundMatch = false;
			for (Business business: Businesses) {
				if(business.address != null) {
					//System.out.println("Compare: " + splitLines[1] + " : " + business.address);
				}
				if(processAddress(splitLines[1]).equals(processAddress(business.address))){
					//System.out.println(splitLines[1] + " " + business.address);
					foundMatch = true;
						if(business.permit !=null){
								continue;
						}
						else {
						business.permit = new Permit(splitLines[0], splitLines[4], splitLines[2], splitLines[3], splitLines[6], splitLines[7], splitLines[1]);
						
						String n = "";
						String d = "";
						for(int i = 0; i<splitLines[4].length()-1; i++) {
							if(splitLines[4].charAt(i) == 'd') {
								if(splitLines[4].charAt(i+1) == 'b') {
									if(splitLines[4].charAt(i+2) == 'a') {
										n = splitLines[4].substring(0,i);
										d = splitLines[4].substring(i+3);	
									}
								}
							}
						}
						business.name = n;
						if(business.dba !=null) {
							business.dba.dbaName = d;
							}
							else {
								business.dba = new DBA (d, "", "");
							}
						
						continue;
						}
				}
			}
			
			if (!foundMatch){
				Business b = new Business("", "", 0 , splitLines[1].trim(), (PPP)null, (DBA)null, (License)null, (RSG)null, (Permit)null);
				Businesses.add(b);
				b.permit = new Permit(splitLines[0], splitLines[4], splitLines[2], splitLines[3], splitLines[6], splitLines[7], splitLines[1]);
				
				String n = "";
				String d = "";
				for(int i = 0; i<splitLines[4].length()-1; i++) {
					if(splitLines[4].charAt(i) == 'd') {
						if(splitLines[4].charAt(i+1) == 'b') {
							if(splitLines[4].charAt(i+2) == 'a') {
								n = splitLines[4].substring(0,i);
								d = splitLines[4].substring(i+3);	
							}
						}
					}
				}
				b.name = n;
				
				if(b.dba !=null) {
				b.dba.dbaName = d;
				}
				else {
					b.dba = new DBA (d, "", "");
				}
		}
	}
}

		
	
	public static void processPPP(ArrayList<String> lines) {
		lines.remove(0);
		lines.remove(0);
		lines.remove(lines.size()-1);

		
		for(String line: lines) {
			//System.out.println(line);
			String[] splitLines = line.split("," , -1);
			//System.out.println(splitLines[4] + Double.parseDouble(splitLines[4]));
//			for (int i =0; i<splitLines.length; i++) {
//				System.out.println(i + " : " + splitLines[i]);
//			}
			boolean foundMatch = false;
			for (Business business: Businesses) {
				if(business.address != null) {
					//System.out.println("Compare: " + splitLines[8] + " : " + business.address);
				}
				if(processAddress(splitLines[8]).equals(processAddress(business.address))){
					foundMatch = true;
						if(business.ppp !=null){
								continue;
						}
						else {
						business.ppp = new PPP(Double.parseDouble(splitLines[4]), Double.parseDouble(splitLines[6]), 0.0,Double.parseDouble(splitLines[3]), Double.parseDouble(splitLines[5]), Double.parseDouble(splitLines[7]), 0.0);
						business.name = splitLines[1];
						business.sector = splitLines[0];
						business.NAICS = Integer.parseInt(splitLines[9]);
						//System.out.println(business.NAICS);
						continue;
						}
				}
		   }
			if (!foundMatch) {
				Business b = new Business(splitLines[1], splitLines[0], Integer.parseInt(splitLines[9]) , splitLines[8].trim(), (PPP)null, (DBA)null, (License)null, (RSG)null, (Permit)null);
				Businesses.add(b);
				double d4 = Double.parseDouble(splitLines[4]);
				double d6 = Double.parseDouble(splitLines[6]);
				double d3 = Double.parseDouble(splitLines[3]);
				double d5 = Double.parseDouble(splitLines[5]);
				double d7 = Double.parseDouble(splitLines[7]);
				
				
				b.ppp = new PPP(d4, d6, 0.0, d3, d5, d7, 0.0);
				//System.out.println(b.NAICS);
			}
		}
	}
	
	
	public static void pasteToExcel() {
		
		//Setup CSV output
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new File("C:\\Users\\Paul\\Desktop\\IQP\\CSVs\\deliverable.csv"));
        }catch(FileNotFoundException e){
            e.printStackTrace();
            return; //Something broke
        }
        
        for(Business j: Businesses){
            pw.write(j.formatToCSV() + "\n");
            pw.flush();
        }

        pw.close();
   }
		

	


		
		
		
		
		
		
		
		
	
	
	
}