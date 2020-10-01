import java.io.*;

public class Program {
	
	public static void main(String[] args) throws IOException, InterruptedException {
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
			
		}
		catch(FileNotFoundException exc) {
			exc.getMessage();
		}
		catch(NullPointerException exc) {
			exc.getMessage();
		}
		catch(InterruptedException exc) {
			exc.getMessage();
		}
		catch(IOException exc) {
			exc.getMessage();
		}
	}
}
