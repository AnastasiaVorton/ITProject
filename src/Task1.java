import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Nastya on 23.09.2017.
 * Class for task number 1
 */
public class Task1 {
    Date A, B, C, D; //Dates of birth of team members
    int ageA, ageB, ageC, ageD; //Ages of team members
    HashMap<Integer, Integer> distribution; //Hash map to represent the distribution of ages of team members
    double infContent; //Information content of the message "”Random student’s	age	is C"
    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    /**
     * Class constructor
     *
     * @param a A's date of birth
     * @param b B's date of birth
     * @param c C's date of birth
     * @param d D's date of birth
     */
    Task1(Date a, Date b, Date c, Date d) {
        A = a;
        B = b;
        C = c;
        D = d;
        distribution = new HashMap<>();
    }

    /**
     * Calculates the current age of each student on a given day
     *
     * @param currentDate - given date
     */
    public void calculateAges(Date currentDate) {
        distribution = new HashMap<>();
        Date dateA = new Date(currentDate.getYear(), A.getMonth(), A.getDate());
        Date dateB = new Date(currentDate.getYear(), B.getMonth(), B.getDate());
        Date dateC = new Date(currentDate.getYear(), C.getMonth(), C.getDate());
        Date dateD = new Date(currentDate.getYear(), D.getMonth(), D.getDate());
        if (dateA.before(currentDate)) {
            ageA = currentDate.getYear() - A.getYear();
        } else if (dateA.after(currentDate)) {
            ageA = currentDate.getYear() - A.getYear() - 1;
        }
        putToMap(ageA);
        if (dateB.before(currentDate)) {
            ageB = currentDate.getYear() - B.getYear();
        } else if (dateB.after(currentDate)) {
            ageB = currentDate.getYear() - B.getYear() - 1;
        }
        putToMap(ageB);
        if (dateC.before(currentDate)) {
            ageC = currentDate.getYear() - C.getYear();
        } else if (dateC.after(currentDate)) {
            ageC = currentDate.getYear() - C.getYear() - 1;
        }
        putToMap(ageC);
        if (dateD.before(currentDate)) {
            ageD = currentDate.getYear() - D.getYear();
        } else if (dateD.after(currentDate)) {
            ageD = currentDate.getYear() - D.getYear() - 1;
        }
        putToMap(ageD);
    }

    /**
     * Puts the age to the hash map
     *
     * @param a
     */
    public void putToMap(int a) {
        if (distribution.get(a) == null) {
            distribution.put(a, 1);
        } else {
            distribution.put(a, distribution.get(a) + 1);
        }
    }

    /**
     * Calculates the information content of a message ”Random student’s age is	C"
     */
    public void countInfContent() {
        double probability = distribution.get(ageC) / 4.0;
        infContent = Math.log10(1.0 / probability) / Math.log10(2);
    }

    /**
     * Executes task 1
     */
    public void execute() {
        System.out.println("Starting the execution of task 1...");
        Scanner reader = new Scanner(System.in);
        System.out.println("Please, enter the date.");
        System.out.println("Enter day:");
        int day = reader.nextInt();
        System.out.println("Enter month:");
        int month = reader.nextInt();
        Date currentDate = new Date(2017, month, day);
        calculateAges(currentDate);
        countInfContent();
        System.out.println("The message \"Random student's age is C\" contains " + decimalFormat.format(infContent) + " bits of information");
    }

}
