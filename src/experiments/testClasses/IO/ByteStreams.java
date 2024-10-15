package experiments.testClasses.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ByteStreams {

	FileInputStream in = null;
	FileOutputStream out = null;
	
	public ByteStreams () {
		
		try {
			in = new FileInputStream("andre.txt");
			out = new FileOutputStream("andre.txt");
			
			int o;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		
		
	}
	
}
