import java.util.concurrent.CountDownLatch;

/**
 * @author CreatureOX
 * date: 2020/8/8
 * description:
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Worker workerA = new Worker("A", 2000, countDownLatch);
        Worker workerB = new Worker("B", 3000, countDownLatch);
        workerA.start();
        workerB.start();
        long startTime = System.currentTimeMillis();
        countDownLatch.await();
        System.out.println("total cost time: " + (System.currentTimeMillis() - startTime) + "ms");
    }

}
