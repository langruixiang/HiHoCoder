import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = null;
		scanner = new Scanner(System.in);
		
		double[] salaryBound = {0, 3500, 5000, 8000, 12500, 38500, 58500,  83500};
		double[] taxBound =    {0, 45,   345,  1245, 7745,  13745, 22495,  Integer.MAX_VALUE};
		double[] taxRate =     {0, 0.03, 0.1,  0.2,  0.25,  0.3,   0.35,   0.45};
		
		double taxNum = scanner.nextDouble();
		scanner.close();
		
		
		int rate = 0;
		
		for(int i = 0; i < taxBound.length; i++){
			if(taxNum <= taxBound[i]){
				rate = i;
				break;
			}
		}
		
		
		long salary = (int)(salaryBound[rate] + (taxNum - taxBound[rate - 1]) / taxRate[rate]);
		
		System.out.println(salary);
	}

}
