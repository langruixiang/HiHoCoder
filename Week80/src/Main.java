import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("F:\\HiHocoderWorkspace\\Week80\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
		int[] delta = new int[3];
		delta[0] = scanner.nextInt();
		delta[1] = scanner.nextInt();
		delta[2] = scanner.nextInt();
		
		Arrays.sort(delta);
		
		scanner.nextLine();
		
		char[] line = scanner.nextLine().toCharArray();
		scanner.close();
		
		int ret = -1;
		int numR = 0;
		int numB = 0;
		int numY = 0;
		
		int[] difference = new int[3];
		
		for(int i = 0; i < line.length; i++){
			if(line[i] == 'R'){
				numR++;
			}else if(line[i] == 'B'){
				numB++;
			}else{
				numY++;
			}
			
			if(numR + numB + numY > ret){
				ret = numR + numB + numY;
			}
			
			difference[0] = Math.abs(numR - numB);
			difference[1] = Math.abs(numR - numY);
			difference[2] = Math.abs(numB - numY);
			
			Arrays.sort(difference);
			
			int j = 0;
			for(j = 0; j < 3; j++){
				if(difference[j] != delta[j]){
					break;
				}
			}
			
			if(j == 3){
				numR = 0;
				numB = 0;
				numY = 0;
			}
		}
		
		System.out.println(ret);
	}

}
