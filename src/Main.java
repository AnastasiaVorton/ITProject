public class Main {
    public static void main(String[] args) {
        System.out.println("Probability that victim has taken killing pill given that he has died:");
        System.out.printf("%.3f", Task5.computeFirstSubtask());
        System.out.println();
        System.out.println("Probability that victim has survived after taking all types of pills independently:");
        System.out.printf("%.3f", Task5.computeSecondSubtask());

    }
}
