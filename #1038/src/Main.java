import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	private static int max(int a,int b){
		return a > b ? a : b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("F:\\EclipseWorkspace\\#1038\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		
		int[] need = new int[N];
		int[] value = new int[N];
		
		for(int i = 0; i < N; i++){
			need[i] = scanner.nextInt();
			value[i] = scanner.nextInt();
		}
		
		int[][] best = new int[2][M + 1];
		
		for(int j = 0; j <= M; j++){
			if(j >= need[0]){
				best[0][j] = value[0];
			}else{
				best[0][j] = 0;
			}
		}
		
		for(int i = 1; i < N; i++){
			if(i % 2 == 1){
				for(int j = 0; j <= M; j++){
					if(j >= need[i]){
						best[1][j] = max(best[0][j - need[i]] + value[i], best[0][j]);
					}else{
						best[1][j] = best[0][j];
					}
				}
			}else{
				for(int j = 0; j <= M; j++){
					if(j >= need[i]){
						best[0][j] = max(best[1][j - need[i]] + value[i], best[1][j]);
					}else{
						best[0][j] = best[1][j];
					}
				}
			}
			
		}
		
		if((N - 1) % 2 == 1){
			System.out.println(best[1][M]);
			return ;
		}
		
		System.out.println(best[0][M]);

	}

}
