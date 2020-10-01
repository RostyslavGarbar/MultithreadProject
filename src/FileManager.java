import java.io.*;

public class FileManager {

	public static File createFile(String path) throws NullPointerException {
		return new File(path);
	}

	public static void fillFiles(File file, char data) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(file);
			
		for(int j = 0; j < CommonRecourses.N2; ++j) {
			writer.print(data);
		}
		
		writer.close();
	}
	
	public static void readFilesPer32Bytes(File file) throws IOException {
		byte[] tempBuf = new byte[CommonRecourses.N3];
		InputStream inputStream = new FileInputStream(file);
		
        while (inputStream.read(tempBuf) != -1) {
        	synchronized (CommonRecourses.myLock) {
				for (byte b : tempBuf) {
					if (b != 0) {
						CommonRecourses.buffer[CommonRecourses.buffer_index++] = b;
					}
				}
        	}    
        }
        
        inputStream.close();	 
	}
	
	public static void writeFromBufferToFile(File file, byte[] data) throws IOException {
		OutputStream outputStream = new FileOutputStream(file);
		outputStream.write(data);	
		outputStream.close();
	}
}

