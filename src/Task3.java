import java.text.DecimalFormat;


public class Task3 {
    int orientNum;
    int casioNum;
    int swatchNum;
    int rolexNum;
    double orientProbability;
    double swatchGivenOrientProbability;
    DecimalFormat decimalFormat  = new DecimalFormat("#.##");


    public Task3(final int M, final int N) {
        calcNumOfModels(M, N);
        findOrientProbability();
        findSwatchGivenOrientProbability();
    }

    public void calcNumOfModels(final int M, final int N){
        orientNum = M;
        casioNum = M + N;
        swatchNum = 2 * M;
        rolexNum = M - 3 * N;

    }

    public void findOrientProbability(){
        orientProbability = (double)orientNum/(orientNum + casioNum + swatchNum + rolexNum);
        System.out.println("The probability that an Orient watch was picked ≈ " + decimalFormat.format(orientProbability));
    }


    public void findSwatchGivenOrientProbability(){
        swatchGivenOrientProbability = (double)swatchNum/((orientNum - 1) + casioNum + swatchNum + rolexNum);
        System.out.println("The probability that a Swatch watch was picked ≈ " + decimalFormat.format(swatchGivenOrientProbability));
    }

}
