import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class textFileToHashMap {
	
	public static void main(String[] args) throws FileNotFoundException {
		textFileToHashMap fs = new textFileToHashMap();
		System.out.println(fs.getNameAddress());

	}
	
	public HashMap<String, String> readFile(String fileName) throws FileNotFoundException {
		
		HashMap<String, String> details = new HashMap<>();
		Scanner sc = new Scanner(new File(fileName));
		String line;
		while(sc.hasNext())
		{
			line = sc.nextLine();
			String[] keyvalue = line.split(":");
			keyvalue[1] = keyvalue[1].trim();
			details.put(keyvalue[0], keyvalue[1]);
		}
		sc.close();
		
		return details;
		
	}
	
	public String getNameAddress() throws FileNotFoundException {
		HashMap<String, String> hm = readFile("C:\\Users\\Shilpa\\Desktop\\data.txt");
		return hm.get("name")+ "," + hm.get("address");
	}

}
