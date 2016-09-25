
package primeThreads.threadMgmt;
import primeThreads.objects.*;
import primeThreads.util.*;

public class CreateWorkers  {

    public static void startWorkers(FileProcessor f, Student s, Course c){
        (new Thread(new WorkerThread(f,s))).start();
    }



}
