package primeThreads.driver;

import primeThreads.util.*;

public class Driver{
	public static void main(String args[]) {
        if(args.length < 3) System.out.println("INCORRECT ARGS(4)");
        else{
		    String inp = args[0]; String out = args[1];
            int NUM_THREADS = Integer.parseInt(args[2]);
            int DEBUG_VALUE = Integer.parseInt(args[3]);
            Logger l = new Logger();
            l.setDebugValue(DEBUG_VALUE);
            


        }
	} // end main(...)

} // end public class Driver
