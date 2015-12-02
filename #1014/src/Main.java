import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	private static class TrieNode{
		int count = 0;
		TrieNode[] map = new TrieNode[26];		
	}
	
	private static void insert(TrieNode root,String word){
		TrieNode iterator = root;
		for(int i = 0; i < word.length() ;i++){
			int index = word.charAt(i) - 'a';			
			iterator.count++;
			
			if(iterator.map[index] != null){
				iterator = iterator.map[index];
			}else{
				TrieNode tmp = new TrieNode();
				iterator.map[index] = tmp;
				
				iterator = tmp;
			}
		}
		
		iterator.count++;
	}
	
	private static int search(TrieNode root,String prefix){
		TrieNode iterator = root;
		for(int i = 0; i < prefix.length(); i++){
			int index = prefix.charAt(i) - 'a';
			if(iterator.map[index] != null){
				iterator = iterator.map[index];
			}else{
				return 0;
			}
		}
		
		return iterator.count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("F:/EclipseWorkspace/#1014/src/in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
		
		TrieNode root = new TrieNode();	
		
	    int size = scanner.nextInt();
	    scanner.nextLine();
	    
	    for(int i = 0; i < size; i++){
	    	String word = scanner.nextLine();
	    	insert(root, word);
	    }
	    
	    int m = scanner.nextInt();
	    scanner.nextLine();
	    for(int i = 0; i < m; i++){
	    	String prefix = scanner.nextLine();
	    	System.out.println(search(root, prefix));
	    }
	    
	    scanner.close();
	}

}
