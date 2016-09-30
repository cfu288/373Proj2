CS442 Design Patterns
Fall 2016
PROJECT 2 README FILE

Due date: Friday, September 30, 2016
Submission Date: Monday, September 30, 2016
Grace Period Used This Project: 0 Days
Grace Period Remaining: <DAYS> Days
Author(s): Mariuxi Yagual and Chris Fu
e-mail(s): myagual1@binghamton.edu and cfu6@binghamton.edu

PURPOSE:

[
  This program assigns courses to students based on their preferences.
  There are 7 courses (A, B, C, D, E, F, G) being offered in the summer session. The capacity for 
  each course is 60. The total number of students is 80. Each student is required to register for 
  5 courses.
  
  In Result.java, we used an array list to save the results and used Collections.synchronizedList 
  function to create a synchronized list so that it is thread-friendly. While we could have used
  vector instead since it is already thread friendly, sources online mentioned that vector 
  synchronizes on each individual operation, which can be undesireable. We opted for a simple data
  structure since we only write to it; using more complex data structures would add no extra 
  benifit. We only access the array when we are printing at the end.

  In our ObjectPool, we decide to use dual HashMaps, one to store classes that were blocked and
  another to store unlocked classes. Classes were popped off one HashMap and placed in the other
  whenever that class was borroed or returned. Since we needed to search to see whether a class
  existed in each catagory, HashMaps made sense due to their near O(1) lookup times. It also gave
  us the ability to search classes by name by using the name as the hash key.
]

PERCENT COMPLETE:

[
  We completed 100% of this project
]

PARTS THAT ARE NOT COMPLETE:

[
  All parts are complete. 
]

BUGS:
[
 None
]

FILES:
[
  Included with this project are 12 files:
  Driver.java, the main file associated with the program also contains main
  Course.java, the file responsible for keeping track the capacity of a course, it's name and remaining spots
  Student.java, the file which contains the preferences of the student, the student's name and assigned courses
  ObjectPool.java, this file manages thread access to our courses using the singleton pattern with double locking.
  SuperObjectPool.java, the file that contains the declaration of attributes and methods of the object pool
  Results.java, the file that is in charge of print out the results for all students
  StdoutDisplayInterface.java, the file that contains the interface implemented by results
  CreateWorkers.java, the file that creates NUM_THREADS threads (via the threaded class WorkerThread), start them and join on them.
  WorkerThread.java, the file that contains the algorithm to enroll a student in courses
  FileProcessor.java, the file that contains the methods to read from a file and write in one.
  Logger.java, the file used for debugging purposes
  README, the text file you are presently reading
]

SAMPLE OUTPUT:
[
  Mariuxis-MacBook-Air:src mariuxiyagual$ ant run1
  Buildfile: /Users/mariuxiyagual/Desktop/cs442/442Proj2/src/build.xml

  jar:

  run1:
     [java] input.txt output.txt 3 1
     [java] 
     [java] Student_2 A D G D G 15
     [snip here]
     [java] Student_80 E F B F B 16
     [java] Average preference_score is: 15.0125

  BUILD SUCCESSFUL
  Total time: 0 seconds
  Mariuxis-MacBook-Air:src mariuxiyagual$
]

TO COMPILE:
[
  Extract the files and type "ant -buildfile src/build.xml all"

]

TO RUN:

[
  To run by specifying arguments from command line [similarly for the 2nd argument and so on ...]
  "ant -buildfile src/build.xml run -Darg0=firstarg "
 
]

EXTRA CREDIT:

[
  N/A
]

BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.

[
  http://stackoverflow.com/questions/2885173/how-to-create-a-file-and-write-to-a-file-in-java
  http://www.javaworld.com/article/2076690/java-concurrency/build-your-own-objectpool-in-java-to-boost-app-speed.html 
  The first link was used for a reference to I/O, the second provided the idea of using dual hashmaps for the 
  ObjectPool.
]

ACKNOWLEDGEMENT:

[
  During the coding process no classmates were consulted.
]

