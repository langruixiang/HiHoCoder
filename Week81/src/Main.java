import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {	
	private static class StartedModules{
		List<Integer> moduleIdArray = new ArrayList<Integer>();
		List<String> moduleSignal = new ArrayList<String>();
	}
	
	private static void bfs(String[] initSignal,Map<String,StartedModules> map,int[] counter){
		Queue<String> queue = new LinkedList<String>();
		for(String ite : initSignal){
			queue.add(ite);
		}
		
		while(!queue.isEmpty()){
			String ite = queue.poll();
			
			StartedModules modules = map.get(ite);
			if(modules != null){
				for(int i : modules.moduleIdArray){
					counter[i] = (counter[i] + 1) % 142857 ;
				}
				
				for(String str : modules.moduleSignal){
					queue.add(str);
				}
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("F:\\HiHocoderWorkspace\\Week81\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0){
			String[] words = br.readLine().split(" ");
			int N = Integer.parseInt(words[0]);
			int M = Integer.parseInt(words[1]);
			
			int[] counter = new int[N];
			String[] initSignal = new String[M];
			
			initSignal = br.readLine().split(" ");
			
			Map<String,StartedModules> map = new HashMap<String,StartedModules>(N);
			
			for(int i = 0; i < N; i++){
				words = br.readLine().split(" ");
				StartedModules modules = null;
				if(map.containsKey(words[0])){
					modules = map.get(words[0]);
				}else{
				    modules = new StartedModules();
				    map.put(words[0], modules);
				}
				
				modules.moduleIdArray.add(i);
				
				for(int j = 2; j < words.length; j++){
					modules.moduleSignal.add(words[j]);
				}
			} 
			
			bfs(initSignal,map,counter);
			
			System.out.print(counter[0]);
			for(int i = 1; i < counter.length; i++){
				System.out.print(" " + counter[i]);
			}
			System.out.println();
		}

	}

}
