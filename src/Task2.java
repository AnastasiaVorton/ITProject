import java.util.Date;

public class Task2 {
    final Date A;
    final Date B;
    final Date C;
    final Date D;
    int ageA;
    int ageB;
    int ageC;
    int ageD;


    public Task2(Date a, Date b, Date c, Date d) {
        A = a;
        B = b;
        C = c;
        D = d;
    }
    public void calcAges(Date current){
        ageA = calcAge(A, current);
        ageB = calcAge(B, current);
        ageC = calcAge(C, current);
        ageD = calcAge(D, current);

    }
    public static int calcAge(Date birthDate, Date current){
        Date dateOfBirthThisYear = new Date(current.getYear(),birthDate.getMonth(),birthDate.getDate());
        return current.before(dateOfBirthThisYear) ? current.getYear() - birthDate.getYear() - 1 : current.getYear() - birthDate.getYear() ;
    }


}
