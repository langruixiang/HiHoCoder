import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	private static boolean isMatch(char[][] arr1, char[][] map,int iIndex, int jIndex){
		for(int i = 0; i < 3 ;i++){
			for(int j = 0; j < 3; j++){
				if(arr1[i][j] != map[iIndex + i][jIndex + j]){
					return false;
				}
			}
		}
		
		return true;
	}
	
	private static char[][] ratate(char[][] arr){
		char[][] ret = new char[3][3];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				ret[2 - i][2 - j] = arr[i][j];
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args){
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("F:/EclipseWorkspace/#1094/src/in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
//		scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		scanner.nextLine();
		
		char[][] map = new char[N][M];
		for(int i = 0; i < N; i++){
			String line = scanner.nextLine();
			map[i] = line.toCharArray();
		}
		
		char[][][] position = new char[4][3][3];
		for(int i = 0; i < 3; i++){
			String line = scanner.nextLine();
			position[0][i] = line.toCharArray();
		}
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				position[1][2 - j][i] = position[0][i][j];
			}
		}
		
		position[2] = ratate(position[0]);
		position[3] = ratate(position[1]);
		
		for(int i = 0; i <= N - 3; i++){
			for(int j = 0; j <= M - 3; j++){
				for(int k = 0; k < 4; k++){
					if(isMatch(position[k], map,i,j)){
						int row = i + 2;
						int clown = j + 2;
						System.out.println(row + " " + clown);
						break;
					}
				}
			}
		}
		
		scanner.close();
	}

}
