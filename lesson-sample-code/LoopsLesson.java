public class LoopsLesson {
    public static void main(String args[]){
        //Loops are another way to control the flow of a program.
        //It allows the program to run codes repeatedly based on certain conditions.
        //There are 3 different types of loops that are commonly used:
        /*
            1. While loop
            2. Do-while loop
            3. For loop
        */

        //While loops are loops that run as long as the condition is true.
        /* Syntax:
            while(condition to check){
                do something
            }
        */
        int num1 = 1;
        while(num1 <= 10){
            System.out.println("Current count: " + num1);
            num1++;
        }
        //The loop will first check if the condition is true and run whatever is inside the loop. After that, it will check the loop condition again and run until the loop condition becomes false.
        //Note that the num1++ in this example is important. This allows the num1 inside the condition to increase and make the condition false.
        //If the num1++ is removed, the condition will always be true and the loop will run continuously. This is called an infinite loop.

        //Do while loop are loops that are similar to while loops except that it would do the code inside first before checking the condition.
        /* Syntax:
            do {
                do something here
            } while (condition);
        */
        int num2 = 10;
        do {
            System.out.println("Current count: " + num2);
            num2--;
        } while (num2 >= 0);

        //For loops are loops that have 3 main parts: the initial setup, the condition to check, and the increment/decrement
        /* Syntax:
            for(setup; condition; increment/decrement){
                do something
            }
        */
        for(int num3 = 0; num3 <= 15; num3++){
            System.out.println("Twice of current num3 is :" + (num3 * 2));
        }

        //Elements in an array can be accessed using loops.
        int grades[] = {100, 99, 81, 76, 66, 78, 99, 65};
        System.out.println("Applying bonus points");
        for(int i = 0; i < grades.length; i++){
            if(grades[i] < 90){
                grades[i] += 5;
            }
            System.out.println("New grade for current student: " + grades[i]);
        }

        //Another way to access elements in an array is through enhanced for loops. Enhanced for loops are for loops that can be used to iterate through elements in a collection or an array
        String attendance[] = {"Adam", "Bea", "Carl", "Denise", "Edward"};
        for (String name : attendance){
            System.out.println("Greetings " + name);
        }

    }
}
