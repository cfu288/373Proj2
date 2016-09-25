package primeThreads.threadMgmt;

import primeThreads.objects.*;
import primeThreads.util.*;

public class CreateWorkers  {

    public static void startWorkers(FileProcessor f/*ObjectPool o*/){
        Thread t = new Thread(new WorkerThread(f));
        t.start();
        t.join();
    }



}
