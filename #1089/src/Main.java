import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		
		try{
			scanner = new Scanner(new File("F:\\HiHocoderWorkspace\\#1089\\src\\in.txt"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
		int N,M;
		N = scanner.nextInt();
		M = scanner.nextInt();
		
		int[][] minDistance = new int[N][N];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(i == j){
					minDistance[i][j] = 0;
				}else{
					minDistance[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		for(int i = 0; i < M; i++){
			int u = scanner.nextInt() - 1;
			int v = scanner.nextInt() - 1;
			int dis = scanner.nextInt();
			
			minDistance[u][v] = minDistance[v][u] = Math.min(minDistance[u][v],dis);
		}
		
		scanner.close();
		
		for(int k = 0; k < N; k++){
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					if(minDistance[i][k] != Integer.MAX_VALUE && minDistance[k][j] != Integer.MAX_VALUE){
						minDistance[i][j] = Math.min(minDistance[i][j], minDistance[i][k] + minDistance[k][j]);
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				System.out.print(minDistance[i][j] + " ");
			}
			System.out.println();
		}

	}

}
