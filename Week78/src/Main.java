import java.io.*;
import java.util.*;

public class Main {
	private static class TrieNode{
		int count = 0;
		TrieNode[] sons = new TrieNode[26];
	}
	
	private static TrieNode root = new TrieNode();
	private static int ret = 0;
	
	private static void insert(TrieNode root,String word){
		TrieNode iterator = root;
		for(int i = 0; i < word.length(); i++){
			iterator.count++;
			int index = word.charAt(i) - 'a';
			if(iterator.sons[index] == null){
				TrieNode tmp = new TrieNode();
				iterator.sons[index] = tmp;
				iterator = tmp;
			}else{
				iterator = iterator.sons[index];
			}
		}
		
		iterator.count++;
	}
	
	private static void count(TrieNode root){	
//		if(root.count <= 5){
//			ret++;
//		}else{
//			for(int i = 0; i < 26; i++){
//				if(root.sons[i] != null){
//					count(root.sons[i]);
//				}
//			}
//		}		
		
		Queue<TrieNode> queue = new LinkedList<TrieNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TrieNode tmp = queue.poll();
			if(tmp.count <= 5){
				ret++;
			}else{
				for(int i = 0; i < 26; i++){
					if(tmp.sons[i] != null){
						queue.add(tmp.sons[i]);
					}
				}
			}
		}
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("F:\\HiHocoderWorkspace\\Week78\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.nextLine();
		while(N-- > 0){
			String word = scanner.nextLine();
			insert(root, word);
		}
		
		if(root.count <= 5){
			System.out.println("0");
		}else{
			count(root);
			System.out.println(ret);
		}

	}

}
