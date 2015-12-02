import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	private static class Index{
		int i;
		int j;
		
		public Index(int i,int j){
			this.i = i;
			this.j = j;
		}
		
		@Override
		public int hashCode(){
			int result = 17;
			result = 31 * result + i;
			result = 31 * result + j;
			
			return result;
		}
		
		@Override
		public boolean equals(Object o){
			if(o == this){
				return true;
			}
			
			if(o instanceof Index){
			     Index item = (Index)o;
			     return item.i == this.i && item.j == this.j;
			}
			
			return false;			
		}
	}
	
	private static class  Constellations{
		int numOfStar = 0;
		List<Index> deltaList = new ArrayList<>();
		
		public void add(int deltai,int deltaj){
			Index index = new Index(deltai,deltaj);
			deltaList.add(index);
			
			numOfStar++;
		}
		
	}
	
	private static class Sky{
		int numOfStars = 0;
		Set<Index> set = new HashSet<>();
		
		public void add(int indexi,int indexj){
			Index index = new Index(indexi,indexj);
			set.add(index);
			numOfStars++;
		}
	}

	private static boolean SkyContains(Sky sky,Constellations constellations){
		boolean find = true;
		
		for(Index index : sky.set){
			find = true;
			int i = index.i;
			int j = index.j;
			for(Index delta : constellations.deltaList){
				if(!sky.set.contains(new Index(i + delta.i,j + delta.j))){
					find = false;
					break;
				}
			}
			
			if(find){
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("F:\\EclipseWorkspace\\#71\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
		
		List<Constellations> constellationList = new ArrayList<>();		
		
		int K = scanner.nextInt();
		for(int i = 0; i < K; i++){
			int H = scanner.nextInt();
			int W = scanner.nextInt();
			scanner.nextLine();
			
			Constellations constellation = new Constellations();
			int baseI = 0;
			int baseJ = 0;
			boolean first = true;
			
			for(int j = 0; j < H; j++){
				String line = scanner.nextLine();
				if(line.contains("#")){
					char[] arr = line.toCharArray();
					for(int k = 0; k < W; k++){						
						if(arr[k] == '#'){
							if(first){
								baseI = j;
								baseJ = k;
								constellation.add(0, 0);
								first = false;
							}else{
								constellation.add(j - baseI, k - baseJ);
							}
						}
						
					}
				}
			}
			
			constellationList.add(constellation);
		}
		
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		scanner.nextLine();
		
		Sky sky = new Sky();
		
		for(int i = 0; i < N; i++){
			String line = scanner.nextLine();
			if(line.contains("#")){
				char[] arr = line.toCharArray();
				for(int j = 0; j < M; j++){
					if(arr[j] == '#'){
						sky.add(i, j);
					}
				}
			}
		}
		
		for(Constellations conIterator : constellationList){
			if(sky.numOfStars >= conIterator.numOfStar){
				if(SkyContains(sky,conIterator)){
					System.out.println("Yes");
				}else{
					System.out.println("No");
				}
			}else{
				System.out.println("No");
			}
		}

	}

}

