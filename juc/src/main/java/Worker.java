import java.util.concurrent.CountDownLatch;

/**
 * @author CreatureOX
 * date: 2020/8/8
 * description:
 */
public class Worker extends Thread {
    private String name;
    private int workTime;
    private CountDownLatch countDownLatch;

    public Worker(String name, int workTime, CountDownLatch countDownLatch){
        this.name = name;
        this.workTime = workTime;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run(){
        System.out.println(name + " fix bug start");
        try {
            Thread.sleep(workTime);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name + " fix bug end");
        countDownLatch.countDown();
    }

}
