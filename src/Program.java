import java.io.*;

public class Program {

	public static void main(String[] args){
		File[] files = new File[CommonRecourses.N1];
		Reader[] readers = new Reader[CommonRecourses.N1];
		
		try {
			for(int i = 0; i < CommonRecourses.N1; ++i) {
				files[i] = FileManager.createFile("File" + (i + 1) + ".txt");
				FileManager.fillFiles(files[i], CommonRecourses.data[i]);
			}
			
			for(int i = 0; i < CommonRecourses.N1; ++i)
				readers[i] = new Reader(files[i]);

			for(int i = 0; i < CommonRecourses.N1; ++i)
				readers[i].thread.join();
			
			File outputFile = FileManager.createFile("out.txt");
			FileManager.writeFromBufferToFile(outputFile, CommonRecourses.buffer);
			
		} catch(NullPointerException | InterruptedException | IOException exc) {
			exc.getMessage();
		}
	}
}
