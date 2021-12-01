import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/*
 * @author Jonathan Palmieri
 */
public class Combine extends ReadFile {

	static ArrayList<String> names2 = new ArrayList<String>();
	static ArrayList<String> names = new ArrayList<String>();
	static ArrayList<String> codes = new ArrayList<String>();
	static ArrayList<String> sectors = new ArrayList<String>();
	
	public static final String PATH = "1.txt";
	public static final String PATH2 = "2.txt";
	public static final String PATH3 = "3.txt";
	public static final String PATH4 = "4.txt";
	
	public static File file = new File(PATH);
	public static File file2 = new File(PATH2);
	public static File file3 = new File(PATH3);
	public static File file4 = new File(PATH4);
	
	static ArrayList<SBA> list = new ArrayList<SBA>(); 
	
	public static void main(String[] args) {
		lines.clear();
		read(file);
		for(String s: lines) {
			names.add(s);
		}
		lines.clear();
		read(file2);
		for(String s: lines) {
			codes.add(s);
		}
		lines.clear();
		read(file3);
		for(String s: lines) {
			sectors.add(s);
		}
		lines.clear();
		
		read(file4);
		for(String s: lines) {
			names2.add(s);
		}
		lines.clear();
		
		for(int i = 0; i < names.size(); i++) {
			list.add(new SBA(names.get(i), codes.get(i),sectors.get(i)));
		}
		int count = 0;
		ArrayList<String> f = new ArrayList<String>();
		ArrayList<String> g = new ArrayList<String>();
		
		//O(n^2)
		for(SBA s: list) {
			for(String str: names2) {
				if(s.Company.equals(str)) { //stringSimilarity(s.Company,str) == 1
					//System.out.println(stringSimilarity(s.Company,str));
					f.add(s.Company);
					g.add(s.Code);
					//f.add(s.Sector);
					//System.out.println(s.Company+ " " + s.Code + " " + s.Sector);
				}
			}
		}
		
		for(int i = 1; i < f.size(); i++) {
			if(f.get(i).equals(f.get(i-1))) {
				f.remove(i);
				g.remove(i);
			}
		}
		/*
		for(String s: f) {
			System.out.println(s);
			count++;
		}
		System.out.println(count);
		*/
		count = 0;
		for(String s: g) {
			System.out.println(s);
			count++;
		}
		System.out.println(count);
		
		/*
		for(SBA s: list) {
			System.out.println(s.Company+ " " + s.Code + " " + s.Sector);
		}
		*/
	}

}
