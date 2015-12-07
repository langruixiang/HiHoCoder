import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args){
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("F:\\HiHocoder\\Week75\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		
		scanner.close();
		
		line = "<black>" + line;
		line += "</black>";
		
		final int RED = 0;
	    final int YELLOW = 1;
	    final int BLUE = 2;
	    final int BLACK = 3;
	    
	    final String REDBEGIN = "<red>";
	    final String REDEND = "</red>";
	    final String YELLOWBEGIN = "<yellow>";
	    final String YELLOWEND = "</yellow>";
	    final String BLUEBEGIN = "<blue>";
	    final String BLUEEND = "</blue>";
	    final String BLACKBEGIN = "<black>";
	    final String BLACKEND = "</black>";
	    
	    int[] counter = new int[4];
	    
	    Stack<Integer> stack = new Stack<>();
	    
	    int index = 0;
	    while(index < line.length()){
	    	if(line.charAt(index) == '<'){
	    		String tag = "<";
	    		while(line.charAt(++index) != '>'){
	    			tag += line.charAt(index);
	    		}
	    		
	    		tag += line.charAt(index++);
	    		
	    		if(tag.equals(REDBEGIN)){
	    			stack.push(RED);
	    		}else if(tag.equals(REDEND)){
	    			stack.pop();
	    		}else if(tag.equals(YELLOWBEGIN)){
	    			stack.push(YELLOW);
	    		}else if(tag.equals(YELLOWEND)){
	    			stack.pop();
	    		}else if(tag.equals(BLUEBEGIN)){
	    			stack.push(BLUE);
	    		}else if(tag.equals(BLUEEND)){
	    			stack.pop();
	    		}else if(tag.equals(BLACKBEGIN)){
	    			stack.push(BLACK);
	    		}else if(tag.equals(BLACKEND)){
	    			stack.pop();
	    		}
	    	}else{
	    		if(line.charAt(index) != ' '){
	    			counter[stack.peek()]++;
	    		}
	    		index++;
	    	}
	    }

	    	System.out.println(counter[0] + " " + counter[1] + " " + counter[2]);    
	}
}
