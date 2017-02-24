
package genericDeser.driver;

import genericDeser.fileOperations.FileProcessor;
import genericDeser.fileOperations.FpInterface;
import genericDeser.util.Logger;
import genericDeser.util.PopulateIn;
import genericDeser.util.PopulateObjects;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length != 2)
		{
			System.out.println("Invalid number of arguments...");
			System.exit(0);
		}
		
		String filename = args[0];
		
		
		int debug_value = 0;
		
		try {
			debug_value = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.err.println("debug value should be an integer...");
			e.printStackTrace();
			System.exit(0);
		}
		
		if(debug_value > 4 || debug_value < 0)
		{
			System.out.println("Debug value should be between 0 to 4");
			System.exit(0);
		}
		
		Logger.setDebugValue(debug_value);
		
		FpInterface fp = new FileProcessor(filename);
		PopulateIn pob = new PopulateObjects(fp);
		
		pob.deserObjects();
		pob.checkDuplicates();
		
		pob.numberOfInstancesFirst();
		pob.numberOfInstancesSecond();
		
	}

}
