Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

## To compile: 
ant -buildfile src/build.xml all

## To run by specifying arguments from command line [similarly for the 2nd argument and so on ...]
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=firstarg 

## To run by specifying args in build.xml (just for debugging, not for submission)
ant -buildfile src/build.xml run
ant -buildfile src/build.xml run1 //Run with debug val of 1 
ant -buildfile src/build.xml run2 //Run with debug val of 2
ant -buildfile src/build.xml run3
ant -buildfile src/build.xml run4

## To create tarball for submission
ant -buildfile src/build.xml tarzip


