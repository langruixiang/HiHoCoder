import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static class Island{
		int id;
		int x;
		int y;
		
		public Island(int id,int x,int y){
			this.id = id;
			this.x = x;
			this.y = y;
		}
	}
	
	private static class Pair{
		int id;
		int dis;
		
		public Pair(int id,int dis){
			this.id = id;
			this.dis = dis;
		}
	}
	
	private static int getDistance(int i1,int i2,Island[] islands){
		return Math.min(Math.abs(islands[i1].x - islands[i2].x), Math.abs(islands[i1].y - islands[i2].y));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("F:\\HiHocoderWorkspace\\#1138\\src\\in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] dis = new int[N];
		Island[] islands = new Island[N];
		Island[] islandsXY = new Island[N];
		
		ArrayList<ArrayList<Integer>> neighbors = new ArrayList<ArrayList<Integer>>();		
		boolean[] used = new boolean[N];
		
		for(int i = 0; i < N; i++){
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			
			islands[i] = new Island(i,x,y);
			islandsXY[i] = new Island(i, x, y);
			
			neighbors.add(new ArrayList<Integer>());
			
			dis[i] = Integer.MAX_VALUE;
		}		
		scanner.close();
		
		Arrays.sort(islandsXY,new Comparator<Island>() {
			public int compare(Island i1,Island i2){
				return i1.x - i2.x;
			}
		});
		
		for(int i = 0; i < N; i++){
			if(i + 1 < N){
				neighbors.get(islandsXY[i].id).add(islandsXY[i + 1].id);
			}
			if(i - 1 >= 0){
				neighbors.get(islandsXY[i].id).add(islandsXY[i - 1].id);
			}
		}
		
		Arrays.sort(islandsXY,new Comparator<Island>() {
			public int compare(Island i1,Island i2){
				return i1.y - i2.y;
			}
		});
		for(int i = 0; i < N; i++){
			if(i + 1 < N){
				neighbors.get(islandsXY[i].id).add(islandsXY[i + 1].id);
			}
			if(i - 1 >= 0){
				neighbors.get(islandsXY[i].id).add(islandsXY[i - 1].id);
			}
		}
		
		//SPFAÀ„∑®
//		Queue<Integer> queue = new LinkedList<Integer>();
//		dis[0] = 0;
//		queue.add(0);
//		used[0] = true;
//		
//		while(!queue.isEmpty()){
//			int tmp = queue.poll();			
//			used[tmp] = false;
//			
//			ArrayList<Integer> neighbor = neighbors.get(tmp);
//			for(int j : neighbor){
//				int distance = getDistance(tmp, j, islands);
//				if(dis[j] > dis[tmp] + distance){
//					dis[j] = dis[tmp] + distance;
//					if(!used[j]){
//						queue.add(j);
//						used[j] = true;
//					}
//				}
//			}
//		}
		
		//DijkstraÀ„∑®
		Queue<Pair> queue = new PriorityQueue<Pair>(N,new Comparator<Pair>() {
			public int compare(Pair p1,Pair p2){
				return p1.dis - p2.dis;
			}
		});
		
		dis[0] = 0;
		queue.add(new Pair(0, 0));
		
		while(!queue.isEmpty()){
			Pair pair = queue.poll();
			if(used[pair.id]){
				continue;
			}
			
			used[pair.id] = true;
			
			ArrayList<Integer> neighbor = neighbors.get(pair.id);
			for(int i : neighbor){
				int distance = getDistance(pair.id, i, islands);
				if(dis[i] > dis[pair.id] + distance){
					dis[i] = dis[pair.id] + distance;
					queue.add(new Pair(i,dis[i]));
				}
			}
		}		
		
		System.out.println(dis[N - 1]);		
	}

}
