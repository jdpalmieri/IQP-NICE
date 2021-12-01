import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
/*
 * @author Jonathan Palmieri
 */

public class OCR extends ReadFile{

	public static final String PATH = "OCR.txt";
	public static File file = new File(PATH);
	static ArrayList<String> phoneNum = new ArrayList<String>();
	static ArrayList<String> names = new ArrayList<String>();
	static ArrayList<String> address = new ArrayList<String>();
	static final char[] list = {'1','2','3','4','5','6','7','8','9'};
	public static void main(String[] args) {
		OCR m = new OCR();
		for(int j = 0; j < list.length; j++) {
			if('2' == list[j]) {
				
			}
		}
		
		lines.clear();
		read(file);
		for(String s: lines) {
			//System.out.println(s);
		}
		for(String s: lines) {
			if(s.contains("508")) {
				//System.out.println(removeChar(s,'.')); 
				//System.out.println(s);	
				if(removeChar(s,'.').length() == 12) {
					phoneNum.add(removeChar(s,'.'));
				}else {
					//phoneNum.add(removeChar(s,'.'));
					String temp = removeChar(s,'.');
					int size = temp.length();
					phoneNum.add(temp.substring(size-13, size));
				}	
			}else if(s.charAt(0) =='A' && s.length() > 6){
				//s = m.checkForAdd(s);
				names.add(s);
			}else{
				address.add(s);
			}
		}
		
		
		//m.test();
		m.test2();
		//Collections.sort(phoneNum);
		//Collections.sort(phoneNum, (a, b)->Integer.compare(a.length(), b.length()));
		
	}
	public String checkForAdd(String s) {
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < list.length; j++) {
				if(s.charAt(i) == list[j]) {
					//System.out.println("HELLO WORLD");
					address.add(s.substring(i-1));
					s = s.substring(0,i-1);
					return s;
				}
			}	
		}
		return s;
	}
	public void test2() {
		for(int i = 0; i < names.size(); i++){
			System.out.printf("%s : %s \n", phoneNum.get(i+16), names.get(i));
		}
	}
	public void test() {
		
		for(String s: phoneNum) {
			System.out.println(s);
		}
		for(String s: names) {
			System.out.println(s);
		}
		for(String s: address) {
			System.out.println(s);
		}
		System.out.println(phoneNum.size());
		System.out.println(names.size());
		System.out.println(address.size());		
	}
	
}
