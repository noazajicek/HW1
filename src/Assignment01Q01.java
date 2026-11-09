public class Assignment01Q01 {
    public static void main(String[] args) {
        for (String arg : args) {
            if (!arg.isEmpty() && (int)arg.charAt(0) % 5 == 0) {
                System.out.println(arg);
            }
        }
    }
}
