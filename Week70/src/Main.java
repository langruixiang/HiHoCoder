import java.util.Scanner;

public class Main {
	private static long findSolutions(int N,int M,long sum, long mul,int last){		
		if(N == sum){
			if(mul % M == 0){
				return 1;
			}else{
				return 0;
			}
		}else{
			long ret = 0;
			for(int i = last + 1; i <= N - sum; i++){
				ret += findSolutions(N, M, sum + i, mul * i, i);
			}
			
			return ret % 1000000007;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		scanner.close();
		
		System.out.println(findSolutions(N,M,0,1,0));
	}

}
