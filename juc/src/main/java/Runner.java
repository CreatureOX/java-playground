import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author CreatureOX
 * date: 2020/8/8
 * description:
 */
public class Runner implements Runnable {
    private String name;
    private int prepareTime;
    private CyclicBarrier cyclicBarrier;

    public Runner(String name, int prepareTime, CyclicBarrier cyclicBarrier){
        this.name  = name;
        this.prepareTime = prepareTime;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(prepareTime);
            System.out.println(name + " prepare ok");
            cyclicBarrier.await();
            System.out.println(name + " running");
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (BrokenBarrierException e){
            e.printStackTrace();
        }
    }
}
