
package primeThreads.threadMgmt;

public class CreateWorkers  {

    public static void startWokers(FileProcessor f, Student s, Course c){
        (new Thread(new WorkerThread())).start();
    }



}
