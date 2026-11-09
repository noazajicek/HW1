public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi_factor = 0;
        double approxPi = 0;

        int approximation_idx = Integer.parseInt(args[0]);

        for (int i = 0; i < approximation_idx; i++) {
            approxPi_factor += ((Math.pow(-1, i) / (2 * i + 1)));
        }

        approxPi = approxPi_factor * 4;
        System.out.println(approxPi + " " + actualPi);
    }

}
