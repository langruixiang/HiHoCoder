import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {	
	private static class Node{
		String url = "";
		Node pre = null;
		Node next = null;
		
		public Node(String u){
			url = u;
		}
	}
	
	private static class LRUCache{
		int maxSize = 0;
		int nowSize = 0;
		
		private Node head = new Node("");
		private Node tail = new Node("");
		
		private Map<String,Node> map = new HashMap<>();
		
		public LRUCache(int capacity){
			maxSize = capacity;
			nowSize = 0;
			
			head.next = tail;
			tail.pre = head;
		}
		
		private void replaceToHead(Node node){
			node.pre.next = node.next;
			node.next.pre = node.pre;
			
			node.next = head.next;
			node.next.pre = node;
			
			node.pre = head;			
			head.next = node;			
		}
		
		private void addToHead(Node node){
			node.next = head.next;
			node.next.pre = node;
			
			head.next = node;
			node.pre = head;
			
			map.put(node.url, node);
		}
		
		private void removeTail(){
			map.remove(tail.pre.url);
			
			tail.pre = tail.pre.pre;
			tail.pre.next = tail;			
		}
		
		public boolean inCache(String url){
			if(map.containsKey(url)){
				Node node = map.get(url);
				replaceToHead(node);
				
				return true;
			}else{
				if(nowSize < maxSize){
					Node node = new Node(url);
					addToHead(node);
					nowSize++;
				}else{
					Node node = new Node(url);
					addToHead(node);
					removeTail();
				}
				
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("F:\\EclipseWorkspace\\#1086\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		scanner.nextLine();
		
		LRUCache cache = new LRUCache(M);
		
		for(int i = 0; i < N; i++){
			String url = scanner.nextLine();
			if(cache.inCache(url)){
				System.out.println("Cache");
			}else{
				System.out.println("Internet");
			}
		}
		
		scanner.close();
	}

}
