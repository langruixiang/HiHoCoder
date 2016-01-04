import java.util.*;
import java.io.*;

public class Main{
	
	private static List<Integer> getDivisor(int num){
		List<Integer> divisor = new ArrayList<Integer>();
		
		int root = (int)Math.sqrt(num);
		
		int counter = 0;
        for(int i = 1; i <= root; i++){
            if(num % i == 0){
                divisor.add(counter,i);
                if(num / i != i){
                	divisor.add(counter + 1, num / i);
                }
                counter++;
            }
        }
       
        return divisor;
	}
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int P = scanner.nextInt();
        int Q = scanner.nextInt();
        
        scanner.close();
        
        List<Integer> divisorP = getDivisor(P);
        List<Integer> divisorQ = getDivisor(Q);
        
        for(int i = 0; i < divisorP.size(); i++){
            int x = divisorP.get(i);
            for(int j = 0; j < divisorQ.size(); j++){
                System.out.println(x + " " + divisorQ.get(j));
            }
        }
    
    }
}