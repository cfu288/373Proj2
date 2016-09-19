package primeThreads.util;

public class Logger{
    //public static enum DebugLevel {CONSTRUCTOR};
    //private static DebugLevel debugLevel;
    private static int debugLevel;
    
    /*public static void setDebugValue (int levelIn) {
	    switch (levelIn) {
	        case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	    }
    }*/

    public static void setDebugValue (int levelIn) {
	    debugLevel = levelIn;
    }
    // @return None
    public static void writeMessage (String message, int levelIn ) {
	    if (levelIn == debugLevel)
	        System.out.println(message);
    }

    public static void writeOutput(){
        
    }

    public String toString() {
        return "Debug Level is " + debugLevel;
    }
}
