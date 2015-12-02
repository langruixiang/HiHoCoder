import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	private static class Node{
		int indegrees = 0;
		int virusCounter = 0;
		List<Integer> outNeighbors = new ArrayList<>();
		
		public void addNeighbor(int index){
			outNeighbors.add(index);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("F:\\EclipseWorkspace\\#1175\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int K = scanner.nextInt();
		
		Node[] allNodes = new Node[N];
		for(int i = 0; i < N; i++){
			allNodes[i] = new Node();
		}
		
		for(int i = 0; i < K; i++){
			allNodes[scanner.nextInt() - 1].virusCounter++;
		}
		
		for(int i = 0; i < M; i++){
			int from = scanner.nextInt() - 1;
			int to = scanner.nextInt() - 1;
			
			allNodes[from].addNeighbor(to);
			allNodes[to].indegrees++;
		}
		
		Queue<Integer> zeroNodes = new LinkedList<>();
		for(int i = 0; i < allNodes.length; i++){
			if(allNodes[i].indegrees == 0){
				zeroNodes.add(i);
			}
		}
		
		int sum = 0;
		while(!zeroNodes.isEmpty()){
			int index = zeroNodes.poll();			
			
			Node node = allNodes[index];

			sum = (sum + node.virusCounter) % 142857;
			
			for(int i : node.outNeighbors){
				allNodes[i].indegrees--;
				if(allNodes[i].indegrees == 0){
					zeroNodes.add(i);
				}
				allNodes[i].virusCounter += node.virusCounter;
			}
		
		}

		System.out.println(sum);
	}

}
