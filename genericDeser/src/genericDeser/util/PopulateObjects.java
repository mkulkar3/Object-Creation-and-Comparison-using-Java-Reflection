package genericDeser.util;


import genericDeser.fileOperations.FpInterface;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import genericDeser.util.Logger;

public class PopulateObjects implements PopulateIn {

	private List<Object> firstObj = new ArrayList<Object>();
	private List<Object> secondObj = new ArrayList<Object>();
	private List<Object> tocheck = new ArrayList<Object>();
	
	Map<String, Class<?>> hmap = new HashMap<String, Class<?>>();
	

	private Class<?> cls;
	private Object obj = null;
	private String arr[] = null;

	private int firstDup = 0, secondDup = 0;

	FpInterface fp;

	public PopulateObjects(FpInterface fpIn) {
		fp = fpIn;
		
		hmap.put("int", Integer.TYPE);
		hmap.put("float", Float.TYPE);
		hmap.put("double", Double.TYPE);
		hmap.put("short", Short.TYPE);
		hmap.put("String", String.class);
		hmap.put("boolean", Boolean.TYPE);
		
		
		Logger.writeMessage("PopulateObjects constructor called....", Logger.DebugLevel.CONSTRUCTOR);
		
	}

	public void deserObjects() {
		String line = null;

		Logger.writeMessage("In deserObjects method...", Logger.DebugLevel.DESEROBJECTS_METHOD);

		
		while ((line = fp.readOneLine()) != null) {
			if (line.trim().isEmpty()) {
			    break;
			}
			parseLine(line);
		}

		fp.closeFile();
	}

	public void checkDuplicates() {
		
		for (int i = 0; i < firstObj.size(); i++) 
		{
			if (tocheck.contains(firstObj.get(i))) 
			{		
				firstDup++;
				Logger.writeMessage("Duplicate detected....", Logger.DebugLevel.DUPLICATE_DETECTED);
			}
			
			tocheck.add(firstObj.get(i));

		}

		tocheck.clear();

		for (int i = 0; i < secondObj.size(); i++) 
		{
			if (tocheck.contains(secondObj.get(i))) 
			{
				secondDup++;
				Logger.writeMessage("Duplicate detected....", Logger.DebugLevel.DUPLICATE_DETECTED);

			}
			
			tocheck.add(secondObj.get(i));

		}

	
	}
	
	
	
	
	
	
	public void numberOfInstancesFirst()
	{
		Logger.writeMessage("Unique First Objects: "+ (firstObj.size() - firstDup), Logger.DebugLevel.NONE);
		Logger.writeMessage("Total First Objects: " + firstObj.size(),  Logger.DebugLevel.NONE);
	}
	
	
	
	
	public void numberOfInstancesSecond()
	{
		Logger.writeMessage("Unique Second Objects: "+ (secondObj.size() - secondDup), Logger.DebugLevel.NONE);
		Logger.writeMessage("Total Second Objects: " + secondObj.size(), Logger.DebugLevel.NONE);
		
	}
	
	

	public void parseLine(String line) {
		
		int IntValue;
		float FloatValue;
		short ShortValue;
		String StringValue;
		double DoubleValue;
		boolean BooleanValue;

		
		
		
		if (line.contains("fqn")) {

			arr = line.split(":");
			String clsName = arr[1];
			try {

				cls = Class.forName(clsName);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("Invalid Class");
				e.printStackTrace();
				System.exit(0);
			}

			try {

				obj = cls.newInstance();

			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				System.err.println("error in creating instance");
				e.printStackTrace();
				System.exit(0);

			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				System.err.println("Access denied");
				e.printStackTrace();
				System.exit(0);
			}

			if (arr[1].contains("First"))
				firstObj.add(obj);
			else
				secondObj.add(obj);
			
			Logger.writeMessage("Object added in data structure....", Logger.DebugLevel.OBJECT_ADDED);


		}

		else {

			Class<?>[] signature = new Class[1];

			String para[];
			para = line.split(", ");
			String arr2[] = para[0].split("=");
			String type = arr2[1];
			arr2 = para[1].split("=");
			String name = arr2[1];
			arr2 = para[2].split("=");

			Object[] params = new Object[1];

			if (type.equals("int")) {
				IntValue = Integer.parseInt(arr2[1]);
				params[0] = new Integer(IntValue);
			} else if (type.equals("float")) {
				FloatValue = Float.parseFloat(arr2[1]);
				params[0] = new Float(FloatValue);
			} else if (type.equals("short")) {
				ShortValue = Short.parseShort(arr2[1]);
				params[0] = new Short(ShortValue);

			} else if (type.equals("double")) {
				DoubleValue = Double.parseDouble(arr2[1]);
				params[0] = new Double(DoubleValue);
			} else if (type.equals("boolean")) {
				BooleanValue = Boolean.parseBoolean(arr2[1]);
				params[0] = new Boolean(BooleanValue);
			} else {
				StringValue = arr2[1];
				params[0] = new String(StringValue);

			}

			signature[0] = hmap.get(type);
			String methodName = "set" + name;
			Method meth = null;
			
			
			try {
				meth = cls.getMethod(methodName, signature);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				System.err.println("method not found");
				e.printStackTrace();
				System.exit(0);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				System.err.println("cannot access the method access denied");
				e.printStackTrace();
				System.exit(0);
			}

				try {
					meth.invoke(obj, params);
				} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				System.err.println("error in invoking method, access denied");
				e.printStackTrace();
				System.exit(0);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				System.err.println("invalid number of arguments");
				e.printStackTrace();
				System.exit(0);
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				System.err.println("error in invocation");
				e.printStackTrace();
				System.exit(0);
			}

		}

	}

}
