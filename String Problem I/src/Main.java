import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("F:\\HiHocoderWorkspace\\String Problem I\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
		
		List<String> dictionary = new ArrayList<String>();
		List<Integer> lenDictionary = new ArrayList<Integer>();
		
		int N,M;
		N = scanner.nextInt();
		M = scanner.nextInt();
		scanner.nextLine();
		
		while(N-- > 0){
			String word = scanner.nextLine();
			dictionary.add(word);
			lenDictionary.add(word.length());
		}
		
		while(M-- > 0){
			String query = scanner.nextLine();
			int counter = 0;
			for(int i = 0; i < dictionary.size(); i++){
				if(lenDictionary.get(i) != query.length() + 1){
					continue;
				}else{
					String word = dictionary.get(i);
					
					int m = 0;
					int n = 0;
					while(m < query.length() && query.charAt(m) == word.charAt(n)){
						m++;
						n++;
					}
					
					n++;
					while(m < query.length() && query.charAt(m) == word.charAt(n)){
						m++;
						n++;
					}
					
					if(m == query.length()){
						counter++;
					}
				}
			}
			System.out.println(counter);
		}
		
		scanner.close();

	}

}
