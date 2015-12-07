import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	private static void preProcess(List<List<Integer>> lists,List<BitSet> reach,int root){
		List<Integer> sons = lists.get(root);
		BitSet res = reach.get(root);
		res.set(root);
		
		for(int iterator : sons){
			preProcess(lists, reach, iterator);
			res.or(reach.get(iterator));
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("F:\\HiHocoder\\#1041\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while(T-- > 0){
			int n = scanner.nextInt();
			List<List<Integer>> lists = new ArrayList<List<Integer>>();
			List<BitSet> reach = new ArrayList<BitSet>();
			Set<Integer> visited = new HashSet<Integer>();
			
			for(int i = 0; i < n; i++){
				lists.add(new ArrayList<Integer>());
				reach.add(new BitSet(n + 5));
			}
			
			for(int i = 0; i < n - 1; i++){
				int from = scanner.nextInt();
				int to = scanner.nextInt();
				
				lists.get(from - 1).add(to - 1);
			}
			
			int m = scanner.nextInt();
			Queue<Integer> queue = new LinkedList<Integer>();
			
			for(int i = 0; i < m; i++){
				queue.add(scanner.nextInt());
			}
		}

	}

}
