package proves;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogManager {
	
	private static LogManager logger;
	private String arxiuLog = "C:\\Users\\Arnau\\eclipse-workspace\\UHC\\src\\main\\java\\proves\\logs.txt";
	
	public LogManager(){
	}
	
	public static LogManager getReference(){
		if(logger==null)
			logger = new LogManager();
		return logger;
	}
	
	public void log(String addr, String accio) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		
		FileWriter fw = new FileWriter(arxiuLog, true); //Set true for append mode
		PrintWriter pw = new PrintWriter(fw); 
	  
		pw.append(dtf.format(now)+"\t"+addr+"\t"+accio+"\n");
		System.out.println(dtf.format(now)+"\t"+addr+"\t"+accio);
	    pw.close();
	    
	}

}
