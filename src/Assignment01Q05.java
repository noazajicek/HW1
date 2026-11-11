public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {

        if (i == j) {
            return 0; // If the start and end indices are the same, return 0
        }
        int[] next_level_idx = new int[m[0].length]; // Initialize an array filled with 0
        int[] distances_from_i = new int[m[0].length]; // Initialize an array to store distances
        int cur_check = i;

        while (isFilledWithNegativeOne(next_level_idx) == 0) {
            next_level_idx[cur_check] = -1; // Mark the current index as visited
            for (int k=0; k<m[0].length; k++){
                if(m[cur_check][k] == 1 && next_level_idx[k] == 0){
                    next_level_idx[k] = 1;
                    distances_from_i[k] = distances_from_i[cur_check] + 1;
                }
            }

            cur_check = firstOneIdx(next_level_idx);
            if (cur_check == -1) {
                break;
            }
                        
            if (cur_check == j) {   
                return distances_from_i[j]; // Return the number of levels traversed to reach
            }
            }


        return -1;
    }

    public static int isFilledWithNegativeOne(int[] arr) {
        for (int i : arr) {
            if (i != -1) {
                return 0; // Found an element that is not -1
            }
        }
        return 1; // All elements are -1
    }

    public static int firstOneIdx(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                return i; // Return the index of the first 1 found
            }
        }
        return -1; // Return -1 if no 1 is found
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}