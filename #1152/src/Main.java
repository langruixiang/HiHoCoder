import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	private static int countCharacter(String str){
		Set<Character> set = new HashSet<Character>();
		
		for(int i = 0; i < str.length(); i++){
			set.add(str.charAt(i));
		}
		
		return set.size();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("F:\\HiHocoderWorkspace\\#1152\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
	    boolean[] fib = new boolean[101];
		fib[1] = true;
		int pre1 = 1;
		int pre2 = 1;
		
		int num = pre1 + pre2;
		while(num <= 100){
			fib[num] = true;
			pre1 = pre2;
			pre2 = num;
			
			num = pre1 + pre2;
		}
		
		String line = scanner.nextLine();
		scanner.close();
		
		Set<String> res = new TreeSet<String>();
		
		for(int i = 0; i < line.length(); i++){
			for(int j = i + 1; j <= line.length(); j++){
				String subString = line.substring(i, j);
				if(fib[countCharacter(subString)]){
					res.add(subString);
				}
			}
		}
		
		Iterator<String> iterator = res.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

}
