import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("F:\\HiHocoderWorkspace\\#1037\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] counter = new int[2][n + 1];
		counter[0][1] = scanner.nextInt();
		
		for(int i = 1; i < n; i++){			
			if(i % 2 == 1){
				for(int j = 1; j <= i + 1; j++){
					counter[1][j] = scanner.nextInt();
					counter[1][j] += Math.max(counter[0][j - 1], counter[0][j]);
				}				
			}else{
				for(int j = 1; j <= i + 1; j++){
					counter[0][j] = scanner.nextInt();
					counter[0][j] += Math.max(counter[1][j - 1], counter[1][j]);
				}
			}
		}
		
		int ret = 0;
		if(n % 2 == 1){
			for(int i = 1; i <= n; i++){
				ret = ret > counter[0][i] ? ret : counter[0][i];
			}
		}else{
			for(int i = 1; i <= n; i++){
				ret = ret > counter[1][i] ? ret : counter[1][i];
			}
		}
		
		System.out.println(ret);

		scanner.close();
	}

}
