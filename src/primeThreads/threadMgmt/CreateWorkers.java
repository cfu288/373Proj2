package primeThreads.threadMgmt;

import primeThreads.objects.ObjectPool;
import primeThreads.util.FileProcessor;
import primeThreads.util.Logger;
import primeThreads.store.Results;
import java.lang.InterruptedException;

public class CreateWorkers  {

    public static void startWorkers(FileProcessor f, int NUM_THREADS, ObjectPool o, Results r, Logger l){
        Thread[] threads = new Thread[NUM_THREADS];
        for(int n = 0; n < NUM_THREADS; n++){
            WorkerThread wt = new WorkerThread(f,o,r,l);
            Thread t = new Thread(wt);
            threads[n] = t;
        }
        for(int n = 0; n < NUM_THREADS; n++) threads[n].start();
        for(int n = 0; n < NUM_THREADS; n++){
            try{
                threads[n].join();
            }catch(InterruptedException e){System.out.println("Interruped in CreateWorker: " + e);}   
        }
    }
}
