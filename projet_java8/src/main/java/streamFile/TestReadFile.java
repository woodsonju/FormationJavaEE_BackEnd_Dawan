package streamFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TestReadFile {

	public static void main(String[] args) {
		
		String fileName = "c://lines.txt";
		
		//read  file into stream, try-with-ressources
		try {
			Stream<String> stream = Files.lines(Paths.get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
