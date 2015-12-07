import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("F:\\HiHocoder\\#1043\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
		int N,M;
		N = scanner.nextInt();
		M = scanner.nextInt();
		
		int[] need = new int[N];
		int[] value = new int[N];
		
		for(int i = 0; i < N; i++){
			need[i] = scanner.nextInt();
			value[i] = scanner.nextInt();
		}
		
		scanner.close();
		
		int[][] array = new int[2][M + 1];
		for(int i = 0; i <= M; i++){
			if(i < need[0]){
				array[0][i] = 0;
			}else{
				array[0][i] = array[0][i - need[0]] + value[0];
			}
		}
		
		int counter = 1;
		while(counter < N){
			if(counter % 2 == 1){
				for(int i = 0; i <= M; i++){
					if(i < need[counter]){
						array[1][i] = array[0][i];
					}else{
						array[1][i] = Integer.max(array[1][i - need[counter]] + value[counter], array[0][i]);
					}
				}
			}else{
				for(int i = 0; i <= M; i++){
					if(i < need[counter]){
						array[0][i] = array[1][i];
					}else{
						array[0][i] = Integer.max(array[0][i - need[counter]] + value[counter], array[1][i]);
					}
				}
				
			}
			counter++;
		}
		
		if(counter % 2 == 1){
			System.out.println(array[0][M]);
			return ;
		}
		
		System.out.println(array[1][M]);
	}

}
