import java.text.DecimalFormat;
import java.util.Date;

public class Task2 {
    final Date A;
    final Date B;
    final Date C;
    final Date D;
    Date[] dates;
    int ageA;
    int ageB;
    int ageC;
    int ageD;
    Date date;
    double x = Double.MAX_VALUE;
    String output;
    double entropy = 0;
    DecimalFormat decimalFormat  = new DecimalFormat("#.##");


    public Task2(Date a, Date b, Date c, Date d) {
        dates = new Date[4];
        A = a;
        dates[0] = A;
        B = b;
        dates[1] = B;
        C = c;
        dates[2] = C;
        D = d;
        dates[3] = D;
    }

    public void execute(){
        findMinInfo();
        output = "Minimal amount of information bits for previous question for Nikolay, Dmitry, Anastasiia, Damir is "+decimalFormat.format(x)+" bits. This value can be achieved for previous question asked on "+date.getDate()+"."+date.getMonth()+".2017.";
        System.out.println(output);
        findEntropy();
        System.out.println("The entropy of randomly chosen symbol from this text is "+decimalFormat.format(entropy)+" bits.");
    }


    /**
     * finds the minimal amount of information bits for previous question and on which data we can get it.
     */
    public void findMinInfo(){
        Task1 task1 = new Task1(A,B,C,D);
        sort(dates);
        Date tempDate;
        //divide year into five periods and our birth dates are the dividers. Then uses the code from the first task
        //to find the amount of information bits for each period and saves the minimal one
        for (int i = 0; i < dates.length; i++) {
            tempDate = new Date(2017, dates[i].getMonth(), dates[i].getDate() - 1 );
            task1.calculateAges(tempDate);
            task1.countInfContent();
            x = Math.min(x, task1.infContent);
            date = x == task1.infContent ? tempDate : date;
        }
        tempDate = new Date(2017, dates[3].getMonth(), dates[3].getDate() - 1 );
        task1.calculateAges(tempDate);
        task1.countInfContent();
        x = Math.min(x, task1.infContent);
        date = x == task1.infContent ? tempDate : date;
    }

    /**
     * Counts the entropy of randomly chosen symbol from the output text, considering alphabet that includes only symbols
     * used in text. Assumes that all the letters are lowercase from English alphabet. The probability of symbol is constant.
     */
    public void findEntropy(){
        int[] frequencies = new int[255];
        //lowercasing the string
        output = output.toLowerCase();
        char[] chars = output.toCharArray();
        for (char symbol : chars) {
            //each char has int associated with it. We take a char from the string, and increment the value
            //in the array at the index equal to the char code. Eventually we get an array with frequencies of each char
            frequencies[symbol]++;
        }
        for (int i = 0; i < frequencies.length; i++) {
            double probability;
            if (frequencies[i] != 0){
                //finding the entropy by the formula sumOfAllX(p(x)*log(1/p(x)))
                probability = (double)frequencies[i]/output.length();
                entropy += probability*(Math.log10(1.0/probability)/Math.log10(2));
            }
        }
    }

    /**
     * sorts birth dates so that they go consequently within one year (it is required in order to divide a year into
     * periods, which we need to check to find the smallest amount of information)
     * Uses bubble sort
     * @param dates
     */
    void sort(Date[] dates) {
        int n = dates.length;
        Date temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (dates[j - 1].getMonth() > dates[j].getMonth() || dates[j - 1].getDate() > dates[j].getDate()) {
                    //swap elements
                    temp = dates[j - 1];
                    dates[j - 1] = dates[j];
                    dates[j] = temp;
                }

            }
        }
    }
}