package genericDeser.fileOperations;



import genericDeser.util.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;




public class FileProcessor implements FpInterface{
	
	
	String inputFileName;
	BufferedReader br;
	BufferedWriter bw;
	
	
		
	

	public FileProcessor(String file_IN) 
	{
		
		inputFileName = file_IN;
		 
		try {
			br = new BufferedReader(new FileReader(inputFileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("file does not exist");
			e.printStackTrace();
			System.exit(0);
		}
		
		
		Logger.writeMessage("FileProcessor constructor called....", Logger.DebugLevel.CONSTRUCTOR);

		
	}




	public String readOneLine()
	{
		String line="";
		try {
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("cannot read the input");
			e.printStackTrace();
			System.exit(0);
		}
		return line;
	}


	



	public void closeFile()
	{
		try {
			br.close();
			//bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("error in closing the file");
			e.printStackTrace();
			System.exit(0);
		}
	}


	
	
	
}
