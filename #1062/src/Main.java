import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	private static class Node{
		String name = "";
		Node father = null;
		
		public Node(String n){
			name = n;
		}
	}
	
	private static Map<String,Node> nodes= new HashMap<>();
	
	private static Node getNode(String name){
		if(nodes.containsKey(name)){
			return nodes.get(name);
		}else{
			Node tmp = new Node(name);
			nodes.put(name, tmp);
			return tmp;
		}		
	}	
	
	private static String find(String person1,String person2){
		Node node1 = getNode(person1);
		Node node2 = getNode(person2);
		
		Set<String> set = new HashSet<>();
		
		Node iterator = node1;
		while(iterator != null){
			set.add(iterator.name);
			iterator = iterator.father;
		}
		
		iterator = node2;
		while(iterator != null){
			if(set.contains(iterator.name)){
				return iterator.name;
			}else{
				iterator = iterator.father;
			}
		}
		
		return "-1";
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("F:\\EclipseWorkspace\\#1062\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 0; i < N; i++){
			String[] info = scanner.nextLine().split(" ");
			
			Node father = getNode(info[0]);			
			Node son = new Node(info[1]);
			son.father = father;
			
			nodes.put(son.name, son);					
		}
		
		int M = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 0; i < M; i++){
			String[] info = scanner.nextLine().split(" ");
			System.out.println(find(info[0], info[1]));			
		}

	}

}
