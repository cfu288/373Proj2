package primeThreads.driver;

import primeThreads.util.FileProcessor;
import primeThreads.util.Logger;
import primeThreads.objects.Course;
import primeThreads.objects.ObjectPool;
import primeThreads.objects.SuperObjectPool;
import primeThreads.objects.Student;
import primeThreads.store.Results;
import primeThreads.store.StdoutDisplayInterface;
import primeThreads.threadMgmt.CreateWorkers;
import primeThreads.threadMgmt.WorkerThread;
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
            Logger l = new Logger();//implement 4, constructor is called
            l.setDebugValue(DEBUG_VAL);
            FileProcessor fp = new FileProcessor();
            fp.openReader(inp);
            CreateWorkers c = new CreateWorkers();
            Results r= new Results(l);
            ObjectPool o = ObjectPool.getInstance();
            c.startWorkers(fp,NUM_THREADS,o,r,l);
            fp.closeReader();
            l.writeMessage(r.schedulesToString(),1);
            l.writeMessage(r.averageToString(),0);
            l.close();
        }
	}
}
