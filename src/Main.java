import java.util.Date;

/**
 * Created by Nastya on 23.09.2017.
 */
public class Main {
    final static Date A = new Date(1998, 6, 20);
    final static Date B = new Date(1998, 3, 17);
    final static Date C = new Date(1998, 9, 28);
    final static Date D = new Date(1999, 5, 27);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=======\nTask 1:\n=======");
        Task1 task1 = new Task1(A, B, C, D);
        task1.execute();
        System.out.println("===============\nTask 1 finished\n===============\n\n");
        Thread.sleep(1000);
        System.out.println("=======\nTask 2:\n=======");
        Task2 task2 = new Task2(A, B, C, D);
        task2.execute();
        System.out.println("===============\nTask 2 finished\n===============\n\n");
        Thread.sleep(1000);
        System.out.println("=======\nTask 3:\n=======");
        Task3 task3 = new Task3(task2.output.length(), 4);
        task3.execute();
        System.out.println("===============\nTask 3 finished\n===============\n\n");
        Thread.sleep(1000);
        System.out.println("=======\nTask 4:\n=======");
        System.out.println("Damir, we expect your implementation here");
        System.out.println("===============\nTask 4 finished\n===============\n\n");
        Thread.sleep(1000);
        System.out.println("=======\nTask 5:\n=======");
        Task5 task5 = new Task5();
        task5.execute();
        System.out.println("===============\nTask 5 finished\n===============\n\n");
    }
}
