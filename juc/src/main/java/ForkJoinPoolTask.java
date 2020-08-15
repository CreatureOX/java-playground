import javafx.concurrent.Task;

import java.util.concurrent.RecursiveTask;

/**
 * @author CreatureOX
 * date: 2020/8/16
 * description:
 */
public class ForkJoinPoolTask extends RecursiveTask<Integer> {

    private int start;

    private int end;

    private int mid;

    private static final Integer DIRECT_COMPUTE_UPPER_BOUND = 6;

    public ForkJoinPoolTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (end - start < DIRECT_COMPUTE_UPPER_BOUND){
            for (int i=start; i<end; i++){
                sum += i;
            }
            System.out.println(Thread.currentThread().getName() + " sum: " + sum);
        }else {
            mid = (end - start)/2 + start;
            ForkJoinPoolTask leftTask = new ForkJoinPoolTask(start, mid);
            ForkJoinPoolTask rightTask = new ForkJoinPoolTask(mid + 1, end);

            leftTask.fork();
            rightTask.fork();

            sum += leftTask.join();
            sum += rightTask.join();
        }
        return sum;
    }
}
