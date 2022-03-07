import java.util.*;

public class ArraysLesson {
    public static void main(String args[]){
        //Arrays are objects containing a fixed number of values of the same type.
        //The elements of an array are indexed, which means are accessed with numbers (called indices).
        //Arrays are used when we need to collect data that are related to each other and of the same type.
        //For example, the grades of a students of a class or a list of names for pets.

        //To declare an array, the syntax is as follows:
        //<Data type>[] array_name; or <Data type> array_name[];
        //int grades[];
        //String[] names;

        //To initialize an array, indicated the number or elements or the actual elements themselves.
        int grades[] = new int[10]; 
        //the new keyword states that there is a new array with 10 possible elements.
        String names[] = {"John", "Paul", "George", "Ringo"};
        //The actual values can also be specified.

        //Assigning values to the array can be done using the assignment operator. The index must be provided for the array to know where to put.
        //Arrays start with index = 0 and the last element is at index n-1 where n is the size of the array.
        grades[0] = 100;    

        //Calling array values can be done using the index of the element.
        System.out.println("The first element of the names array is " + names[0]);
        System.out.println("The last element of the names array is " + names[3]);

        
        //The issue with arrays in Java is that it is of fixed length, meaning after definition, there is no way to add elements in the array.
        //Hence ArrayLists are used to add versatility to the array.
        //ArrayLists are part of Java's utilities package, so if ArrayLists are to be used, the java.utils.* should be imported.
        //Initialization Syntax:
        //ArrayList<Data_type> variable_name = new ArrayList<Datatype> ();
        ArrayList<String> classroom = new ArrayList<String>();

        //To add elements to the ArrayList, we use the .add() method
        classroom.add("John");
        classroom.add("Mark");
        classroom.add("Jill");
        classroom.add("Clara");

        //To access individual elements in the array list, the .get() and .set() methods are used.
        System.out.println("1st student name is " + classroom.get(0));
        classroom.set(0, "Bob");
        System.out.println("1st student name is " + classroom.get(0));

        //Arrays can also be converted to Arraylists using the asList() method.
        List<String> band = Arrays.asList(names);

        System.out.println(band.get(0));
    }
}
