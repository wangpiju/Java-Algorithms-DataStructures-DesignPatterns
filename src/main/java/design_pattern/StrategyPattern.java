package design_pattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StrategyPattern {
	
	public  interface Logging{
		void write(String message);
	}
	
	public static class ConsoleLogging implements Logging{

		@Override
		public void write(String message) {
			System.out.println(message);
		}
	}
	
	public static class FileLogging implements Logging{
		private final File toWrite;
		
		FileLogging(final File toWrite){
			this.toWrite = toWrite;
		}

		@Override
		public void write(String message) {
			try {
				final FileWriter fos = new FileWriter(toWrite);
				fos.write(message);
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static class Client{
		private final Logging logging;
		
		Client(Logging logging){
			this.logging = logging;
		}
		
		void doWork(final int count){
			if(count % 2 == 0){
				logging.write("Even number: " + count);
			}
		}
	}
	
	@SuppressWarnings("resource")
	private static void useFileLogging() throws IOException{
		final File tempFile = File.createTempFile("test", "log");
		final Client c = new Client(new FileLogging(tempFile));
		c.doWork(41);
		c.doWork(42);
		c.doWork(43);
		
		final BufferedReader reader = new BufferedReader(new FileReader(tempFile));
		
		System.out.println(reader.readLine());
		System.out.println(reader.read());
	}

	


	public static void main(String[] args) throws IOException {
		useFileLogging();
	}

}
