import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        if (direction != 'L' && direction != 'R' || array.length == 0) {
            return array;
        }

        move = move % array.length; // Normalize the move value to be within the array length

        // If move is negative, convert it to a positive equivalent
        if (move < 0) {
            move = array.length + move;
        }

        // If the direction is left, we can convert it to a right shift by subtracting from the array length
        if (direction == 'L') {
            move = array.length - move;
        }

        // Perform the cyclic shift
        int needed_shifts = move % array.length;
        int next_val = array[0];
        int next_idx = 0;
        for (int i = 0; i < array.length; i++) {
            int temp = array[(next_idx + needed_shifts) % array.length];
            array[(next_idx + needed_shifts) % array.length] = next_val;
            next_val = temp;
            next_idx = (next_idx + needed_shifts) % array.length;
            }
  
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}