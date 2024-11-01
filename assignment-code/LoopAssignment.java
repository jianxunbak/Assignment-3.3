public class LoopAssignment {
    public static void main(String args[]) {
        // Task 1. Create a while loop that prints all the odd numbers from 1 to 50
        System.err.println("\nTask 1\n");

        boolean printing = true;
        while (printing) {
            for (int i = 1; i <= 50; i++) {
                if (i % 2 != 0) {
                    System.out.print(i + " ");
                }
                printing = false;
            }
        }

        /*
         * Task 2. Create a do-while loop that prints the following pattern from 1 to
         * 30:
         * If the number is divisible by 3, print "Fizz"
         * If the number is divisible by 5, print "Buzz"
         * If the number is divisible by 3 AND 5, print "FizzBuzz"
         * If the number is not divisible by 3 nor 5, print "Pop"
         */

        System.err.println("\nTask 2\n");
        boolean running = true;
        do {
            for (int i = 1; i <= 30; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println(i + ": " + "FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println(i + ": " + "Fizz");
                } else if (i % 5 == 0) {
                    System.out.println(i + ": " + "Buzz");
                } else
                    System.out.println(i + ": " + "Pop");
            }
            running = false;

        } while (running);

        // Task 3. Use an enhanced for-loop to compute for the average of the given
        // array
        System.err.println("\nTask 3\n");

        int expenses[] = { 120, 130, 114, 112, 132, 154, 123, 112, 165, 144, 188, 200
        };
        float total = 0.0f;

        for (int num : expenses) {
            total += num;
        }

        float average = (total / expenses.length);
        System.out.println("Average: " + average);

    }
}
