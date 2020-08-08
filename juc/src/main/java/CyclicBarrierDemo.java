import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author CreatureOX
 * date: 2020/8/8
 * description:
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Runner runnerA = new Runner("A", 2000, cyclicBarrier);
        Runner runnerB = new Runner("B", 1000, cyclicBarrier);
        Runner runnerC = new Runner("C", 4000, cyclicBarrier);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(runnerA);
        executorService.execute(runnerB);
        executorService.execute(runnerC);

        executorService.shutdown();
    }

}
