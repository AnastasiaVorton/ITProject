import java.text.DecimalFormat;


public class Task3 {
    int orientNum;
    int casioNum;
    int swatchNum;
    int rolexNum;
    double orientProbability;
    double swatchGivenOrientProbability;
    DecimalFormat decimalFormat  = new DecimalFormat("#.##");

    /**
     * @param M the total amount of symbols in text generated on previous step
     * @param N number of the team members
     */
    public Task3(final int M, final int N) {
        calcNumOfModels(M, N);
    }

    public void execute(){
        findOrientProbability();
        System.out.println("The probability that an Orient watch was picked ≈ " + decimalFormat.format(orientProbability));
        findSwatchGivenOrientProbability();
        System.out.println("The probability that a Swatch watch was picked second given that Orient watches were picked first ≈ " + decimalFormat.format(swatchGivenOrientProbability));
    }

    /**
     * calculates the amount of models each brand of watches.
     * @param M calculated from the task 2
     * @param N number of members in the team
     */
    public void calcNumOfModels(final int M, final int N){
        orientNum = M;
        casioNum = M + N;
        swatchNum = 2 * M;
        rolexNum = M - 3 * N;

    }
    /**
     * finds the probability that Orient watches were picked
     */
    public void findOrientProbability(){
        // probability = amount of Orient watches / total amount of watches
        orientProbability = (double)orientNum/(orientNum + casioNum + swatchNum + rolexNum);
    }

    /**
     * finds the probability that Swatch watches were picked second given that Orient watches were picked first
     */
    public void findSwatchGivenOrientProbability(){
        // conditional probability = P(A|B) = P(A ∩ B)/P(B)
        swatchGivenOrientProbability = (double)swatchNum/((orientNum - 1) + casioNum + swatchNum + rolexNum);
    }

}
