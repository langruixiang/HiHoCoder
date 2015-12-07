import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static int maxLength = 0;
	
	private static void getHeight(List<List<Integer>> lists,int[] height,int root){
		List<Integer> sons = lists.get(root);
		if(sons.isEmpty()){
			height[root] = 1;
		}else{		
			int first = 0;
			int second = 0;
			
			for(int iterator : sons){
				getHeight(lists, height, iterator);
				if(height[iterator] >= first){
					second = first;
					first = height[iterator];
				}else if(height[iterator] > second){
					second = height[iterator];
				}
			}
			
			if(first + second > maxLength){
				maxLength = first + second;
			}
			
			height[root] = first + 1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("F:\\HiHocoder\\#1050\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		int[] height = new int[N];
		
		for(int i = 0; i < N; i++){
			lists.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < N - 1; i++){
			int from = scanner.nextInt();
			int to = scanner.nextInt();
			
			lists.get(from - 1).add(to - 1);
		}
		
		scanner.close();
		
		if(N <= 1){
			System.out.println("0");
			return ;
		}
		
		getHeight(lists, height, 0);
		
		System.out.println(maxLength);
	}

}
