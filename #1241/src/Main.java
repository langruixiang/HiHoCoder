import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static class Item{
		long twoCounter;
		long fiveCounter;
		
		public Item(long two,long five){
			twoCounter = two;
			fiveCounter = five;
		}
	}
	
    private static int countTwo(int num){
    	if(num == 0){
    		return Integer.MAX_VALUE;
    	}
    	
    	int ret = 0;
    	while(num % 2 == 0){
    		ret++;
    		num >>= 1;
    	}
    	
    	return ret;
    }
    
    private static int countFive(int num){
    	if(num == 0){
    		return Integer.MAX_VALUE;
    	}
    	
    	int ret = 0;
    	while(num % 5 == 0){
    		ret++;
    		num /= 5;
    	}
    	
    	return ret;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		
//		try {
//			scanner = new Scanner(new File("F:/EclipseWorkspace/#1241/src/in.txt"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		Item[][] arrays = new Item[N][N];		
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				int num = scanner.nextInt();
				arrays[i][j] = new Item(countTwo(num), countFive(num));
			}
		}
		
		scanner.close();
		
		for(int i = 1; i < N; i++){
			arrays[i][0].twoCounter += arrays[i - 1][0].twoCounter;
			arrays[i][0].fiveCounter += arrays[i - 1][0].fiveCounter;

		}
		
		for(int j = 1; j < N; j++){
			arrays[0][j].twoCounter += arrays[0][j - 1].twoCounter;
            arrays[0][j].fiveCounter += arrays[0][j - 1].fiveCounter;
		}
		
		for(int i = 1; i < N; i++){
			for(int j = 1; j < N; j++){
				long minTwo = Math.min(arrays[i - 1][j].twoCounter, arrays[i][j - 1].twoCounter);
				arrays[i][j].twoCounter += minTwo;
				
				long minFive = Math.min(arrays[i - 1][j].fiveCounter, arrays[i][j - 1].fiveCounter);
				arrays[i][j].fiveCounter += minFive;
			}
		}
		
		System.out.println(Math.min(arrays[N - 1][N - 1].twoCounter, arrays[N - 1][N - 1].fiveCounter));
	}

}
