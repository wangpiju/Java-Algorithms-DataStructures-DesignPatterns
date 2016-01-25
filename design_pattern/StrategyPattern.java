package design_pattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StrategyPattern {
	
	public static interface Logging{
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
		
		public FileLogging(final File toWrite){
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
		
		public Client(Logging logging){
			this.logging = logging;
		}
		
		public void doWork(final int count){
			if(count % 2 == 0){
				logging.write("Even number: " + count);
			}
		}
	}
	
	public static void useConsoleLogging(){
		final Client c = new Client(new ConsoleLogging());
		c.doWork(32);
	}
	
	@SuppressWarnings("resource")
	public static void useFileLogging() throws IOException{
		final File tempFile = File.createTempFile("test", "log");
		final Client c = new Client(new FileLogging(tempFile));
		c.doWork(41);
		c.doWork(42);
		c.doWork(43);
		
		final BufferedReader reader = new BufferedReader(new FileReader(tempFile));
		
		System.out.println(reader.readLine());
		System.out.println(reader.read());
	}
	
	public static void useMockLogging(){
		final Logging  mockLogging = mock(Logging.class);
		
		final Client c = new Client(mockLogging);
		c.doWork(1);
		c.doWork(2);
	}
	
	private static Logging mock(Class<Logging> class1) {
		
		return null;
	}

	public static void main(String[] args) throws IOException {
		useFileLogging();

	}

}
