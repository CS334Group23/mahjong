package utils;

public class TerminalIOUtils {
	public static void printIndex(int length) {
		String str = "";
		for(int i=0;i<16;i++) {
			str += " ";
		}
		for(int i=0;i<length;i++) {
			str += "    ";
			str += Integer.toString(i+1);
		}
		System.out.println(str);
	}
}
