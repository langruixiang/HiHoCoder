import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	private static boolean bfs(List<List<Integer>> edges,int N,int[] color,int begin){
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(begin);
		
		while(!queue.isEmpty()){
			int from = queue.poll();
			List<Integer> neighbors =  edges.get(from);
			for(int i : neighbors){
				if(color[i] == 0){
					color[i] = - color[from];
					queue.add(i);
				}else if(color[i] == color[from]){
					return false;
				}
			}
		}		
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("F:\\HiHocoderWorkspace\\#1121\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		
		while(T-- > 0){
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			
			List<List<Integer>> edges = new ArrayList<List<Integer>>();
			for(int i = 0; i < N; i++){
				edges.add(new ArrayList<Integer>());
			}
			
			int[] color = new int[N];
			
			for(int i = 0; i < M; i++){
				int from = scanner.nextInt() - 1;
				int to = scanner.nextInt() - 1;
				
				edges.get(from).add(to);
				edges.get(to).add(from);
			}
			
			int i;
			for(i = 0; i < N; i++){
				if(color[i] == 0){
					color[i] = 1;
					if(!bfs(edges,N,color,i)){
						System.out.println("Wrong");
						break;
					}
				}
			}
			
			if(i == N){
				System.out.println("Correct");
			}
		}

	}

}
