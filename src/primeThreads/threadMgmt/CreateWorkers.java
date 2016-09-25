package primeThreads.threadMgmt;

import primeThreads.objects.*;
import primeThreads.util.*;
import java.lang.InterruptedException;

public class CreateWorkers  {

    public static void startWorkers(FileProcessor f/*ObjectPool o*/){
        WorkerThread wt = new WorkerThread(f);
        Thread t = new Thread(wt);
        t.start();
        try{
            t.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }



}
