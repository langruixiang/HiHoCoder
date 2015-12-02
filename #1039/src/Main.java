import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	private static int clear(StringBuilder str){
		int iniLen = str.length();
		
		int i = 0;
		while(i < str.length()){
			if(i + 1 < str.length() && str.charAt(i + 1) == str.charAt(i)){
				while(i + 1 < str.length() && str.charAt(i + 1) == str.charAt(i)){
					str.deleteCharAt(i + 1);
				}
				str.deleteCharAt(i);
			}else{
				i++;
			}
		}
		
		if(str.length() == iniLen){
			return 0;
		}
		
		return iniLen - str.length() + clear(str);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scanner = null;
//		
//		try {
//			scanner = new Scanner(new File("F:/EclipseWorkspace/1039/src/in.txt"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 0; i < T; i++){
			String word = scanner.nextLine();
			if(word.length() == 0){
				System.out.println(0);
			}else{
				StringBuilder str = new StringBuilder(word);
				int max = 0;
				for(int j = 0; j < str.length();j++){			
					for(char c = 'A'; c <= 'C';c++){					
						StringBuilder tmp = new StringBuilder(str);
						int extra = clear(tmp.insert(j, c));
						max = Math.max(max, extra);
					}
				}
				
				System.out.println(max);
			}
		}

	}

}
