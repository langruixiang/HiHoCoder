import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		
//		try {
//			scanner = new Scanner(new File("F:/EclipseWorkspace/#1051/src/in.txt"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		for(int i = 0; i < T; i++){
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			
			if(N == 0){
				System.out.println(100);
			}else{
				int[] array = new int[N + 1];
				int[] days = new int[N];
				
				for(int j = 0; j < N; j++){
					days[j] = scanner.nextInt();
				}
				
				array[0] = days[0] - 1;
				for(int j = 1; j < N; j++){
					array[j] = days[j] - days[j - 1] - 1;
				}
				array[N] = 100 - days[N - 1];
				
				int max = 0;
				for(int j = 0 ; j <= N; j++){
					int sum = array[j];
					for(int k = 1; k <= M; k++){
						if(j + k > N){
							break;
						}
						sum += array[j + k] + 1;
					}
					
					max = max > sum ? max : sum;
				}
				
				System.out.println(max);
			}
			
			
		}
		
		scanner.close();
	}

}
