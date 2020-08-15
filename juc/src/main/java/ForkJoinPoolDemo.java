import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author CreatureOX
 * date: 2020/8/16
 * description:
 */
public class ForkJoinPoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinPoolTask sumTask = new ForkJoinPoolTask(1, 100);
        ForkJoinTask<Integer> result = forkJoinPool.submit(sumTask);

        System.out.println("sum: " + result.get());
        forkJoinPool.shutdown();
    }

}
