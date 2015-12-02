import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File("F:/EclipseWorkspace/#1082/src/in.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		scanner = new Scanner(System.in);
		
		String fish = "marshtomp";
		String person = "fjxmlhx";
		
		while(scanner.hasNextLine()){
			StringBuilder line = new StringBuilder(scanner.nextLine());
			for(int i = 0; i <= line.length() - 9; i++){
				if(line.substring(i, i + 9).equalsIgnoreCase(fish)){
					line.delete(i, i + 9);
					line.insert(i, person);
				}
			}
			
			System.out.println(line.toString());			
		}

	}

}
