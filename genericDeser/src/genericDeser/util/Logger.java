package genericDeser.util;


public class Logger {
	
	 public static enum DebugLevel {NONE, OBJECT_ADDED, DESEROBJECTS_METHOD, DUPLICATE_DETECTED, CONSTRUCTOR
		};

private static DebugLevel debugLevel;


public static void setDebugValue (int levelIn) {
switch (levelIn) {
case 0: debugLevel = DebugLevel.NONE; break;
case 1: debugLevel = DebugLevel.OBJECT_ADDED; break;
case 2: debugLevel = DebugLevel.DESEROBJECTS_METHOD; break;
case 3: debugLevel = DebugLevel.DUPLICATE_DETECTED; break;
case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
}
}

public static void setDebugValue (DebugLevel levelIn) {
debugLevel = levelIn;
}

// @return None
public static void writeMessage (String message, DebugLevel levelIn ) {
if (levelIn == debugLevel)
System.out.println(message);
}

public String toString() {
return "Debug Level is " + debugLevel;
}

	
	

}
