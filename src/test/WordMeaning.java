package test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class WordMeaning {
	
	public static void main(String[] args) throws IOException {
		
		doesFileExist("Word.txt");  
    }
	
	// print the file if it exists
    public static void doesFileExist(String path) throws IOException {
    	File file = new File(path);
    	
    		try { 
    			if (file.exists())
    				System.out.println("File exists");
    	    		
    			BufferedReader reader = new BufferedReader(new FileReader(file)); // read the file
 			   	String line = null;
 			   
 			   	while((line = reader.readLine()) != null) { 						// print each line of the file
 			   		System.out.println(line.toString().replace("-" , "\n" ).replace("," , "\n"));
 		        } 
 			   
    		} catch (FileNotFoundException e) {									// catch exception if file does not exist
 				 System.out.println("File does not exist " + e);
    		}  
    		
    }
	
	
}
 	  

