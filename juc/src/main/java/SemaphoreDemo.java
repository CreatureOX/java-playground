import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author CreatureOX
 * date: 2020/8/8
 * description:
 */
public class SemaphoreDemo {
    private static final int COUNT = 20;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT);
        Semaphore semaphore = new Semaphore(5);

        Random random = new Random();
        for (int i=0; i<COUNT; i++){
            int no = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("no: " + no + " car can pass");
                        Thread.sleep(random.nextInt(2000));
                        semaphore.release();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
    }

}
