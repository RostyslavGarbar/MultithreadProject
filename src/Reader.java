import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Reader implements Runnable {
	public Thread thread;
	private File file;
	
	public Reader(File file) {
		thread = new Thread(this, "Thread" + file.getName());
		this.file = file;
		thread.start();
	}

	@Override
	public void run() {
		try {
			FileManager.readFilesPer32Bytes(file);
		}
		catch(FileNotFoundException exc) {
			exc.getMessage();
		}
		catch(IOException exc){
			exc.getMessage();
		}		
	}
	
}
