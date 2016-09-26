package primeThreads.driver;

import primeThreads.util.*;
import primeThreads.threadMgmt.*;
import java.io.BufferedReader;

public class Driver{
	public static void main(String args[]) {
        if(args.length < 3) System.out.println("INCORRECT ARGS(4)");
        else{
            //COMMAND LINE ARG PARSING AND VERIFICATION
		    String inp = args[0]; String out = args[1];
            int NUM_THREADS = Integer.parseInt(args[2]);
            int DEBUG_VAL = Integer.parseInt(args[3]);
            System.out.println(inp+" " + out+" " +NUM_THREADS+ " " +DEBUG_VAL+"\n");
            if(NUM_THREADS<1 || NUM_THREADS>3 || DEBUG_VAL < 0 || DEBUG_VAL > 4){
                System.out.println("INCORRECT THREAD NUM OR DEBUG VAL");
                System.exit(0);
            }
            //CALLING CREATEWORKERS, INSTANTIATING CLASSES
            Logger l = new Logger();
            l.setDebugValue(DEBUG_VAL);
            FileProcessor fp = new FileProcessor();
            fp.openReader(inp);
            CreateWorkers c = new CreateWorkers(); 
            Results r = new Results();
            ObjectPool o = o.getInstance();
            c.startWorkers(fp,NUM_THREADS,r,o);
            fp.closeReader();

        }
	} // end main(...)

} // end public class Driver
