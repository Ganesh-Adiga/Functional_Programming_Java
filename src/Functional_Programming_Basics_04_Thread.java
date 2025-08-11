import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Functional_Programming_Basics_04_Thread {
    public static void main(String[] args) throws IOException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getId()+":"+i);
                }
            }
        };

        Runnable runnable2 = ()-> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getId()+":"+i);
            }
        };
        Thread t1 = new Thread(runnable2);
        t1.start();

        Thread t2 = new Thread(runnable2);
        t2.start();


        Thread t3 = new Thread(runnable2);
        t3.start();

        Runnable runnable3 = ()-> IntStream.range(0,1000).forEach(i->System.out.println(Thread.currentThread().getId()+"::"+i));

        Thread t4 = new Thread(runnable3);
        t4.start();
    }



}



