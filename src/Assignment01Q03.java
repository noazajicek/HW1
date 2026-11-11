public class Assignment01Q03 {
    public static void main(String[] args) {
        if (args.length == 0) { // Check if the user provided an argument
            System.out.println("Please provide the number of Fibonacci numbers to generate.");
            return;
        }
        // Parse the first argument as an integer
        int x =  Integer.parseInt(args[0]);
        int fib_array[] = new int[x];
        System.out.println("The first " + x + " Fibonacci numbers are:");

        //generate Fibonacci numbers and count odd numbers
        int first_fib = 1;
        int second_fib = 1;
        int numOdd = 0;
        int temp = 0;
        for(int i = 0; i < x; i++) {
            fib_array[i] = first_fib; // Store the Fibonacci number in the array
            if (first_fib % 2 != 0) { // Check if the Fibonacci number is odd
                numOdd++;
            }
            temp = first_fib + second_fib;
            first_fib = second_fib;
            second_fib = temp;
        }

        // Print the Fibonacci numbers
        for (int i = 0; i < x; i++) {
            System.out.print(fib_array[i]);
            if (i < x - 1) 
                System.out.print(" "); // Make sure we don't print a trailing space
        }
        System.out.println();
        
        ////////////////////////////////////////////////////////////////
        
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
