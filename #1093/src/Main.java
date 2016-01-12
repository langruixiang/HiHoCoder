import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
	private static List<List<Node>> edges = new ArrayList<List<Node>>();
	
	private static class Node{
		int id;
		int distance;
		
		public Node(int id,int distance){
			this.id = id;
			this.distance = distance;
		}
	}

	private static void update(int from,int to,int len){
		List<Node> neighbors = edges.get(from);
		boolean find = false;
		for(Node n : neighbors){
			if(n.id == to){
				n.distance = Math.min(n.distance, len);
				find = true;
				break;
			}
		}
		if(!find){
			neighbors.add(new Node(to,len));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("F:\\HiHocoderWorkspace\\#1093\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int S = scanner.nextInt();
		int T = scanner.nextInt();
		
		for(int i = 0; i < N; i++){
			edges.add(new ArrayList<Node>());
		}
		
		while(M-- > 0){
			int from = scanner.nextInt() - 1;
			int to = scanner.nextInt() - 1;
			int len = scanner.nextInt();
			
			update(from, to, len);
			update(to, from, len);
		}
		
		scanner.close();
		
		int[] distance = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		boolean[] inQueue = new boolean[N];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		
		distance[S - 1] = 0;
		queue.add(S - 1);
		inQueue[S - 1] = true;
		
		while(!queue.isEmpty()){
			int u = queue.poll();
			inQueue[u] = false;
			
			List<Node> neighbors = edges.get(u);
			for(Node n : neighbors){
			    if(distance[u] + n.distance < distance[n.id]){
			    	distance[n.id] = distance[u] + n.distance;
	    			if(!inQueue[n.id]){
						queue.add(n.id);
						inQueue[n.id] = true;
					}			    	
			    }
			}
		}
		
		System.out.println(distance[T - 1]);
	}

}

