import java.util.*;
import java.io.*;

public class Main {
	
	private static int count(int i,int n){
		if(n == 0){
			return 0;
		}
		
		if(i % 4 == 2 || i % 4 == 3){
			return n;
		}else{
			return count((i + 3) / 4, n - 1);
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("F:\\HiHocoderWorkspace\\Week77\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		while(T-- > 0){
			int i = scanner.nextInt();
			int n = scanner.nextInt();
			
			System.out.println(count(i, n));
		}

	}

}
