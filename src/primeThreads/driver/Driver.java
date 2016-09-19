package primeThreads.driver;

import primeThreads.util.*;

public class Driver{
	public static void main(String args[]) {

		System.out.println("\n The args[0] is: " + args[0]);
        Logger l = new Logger();
        l.setDebugValue(4);
        l.writeMessage("Testing level 4",4);
        l.writeMessage("Testing level 3",3);
        l.writeMessage("Testing level 2",2);
        l.writeMessage("Testing level 1",1);
        l.writeMessage("Testing level 0",0);

	} // end main(...)

} // end public class Driver
