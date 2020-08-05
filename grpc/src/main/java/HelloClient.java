import com.creatureox.grpc.Greeting;
import com.creatureox.grpc.HelloResp;
import com.creatureox.grpc.HelloWorldGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author CreatureOX
 * date: 2020/8/5
 * description:
 */
public class HelloClient {

    private final ManagedChannel channel;
    private final HelloWorldGrpc.HelloWorldBlockingStub blockingStub;

    public HelloClient(String host, int port){
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = HelloWorldGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public String sayHello(String name){
        Greeting request = Greeting.newBuilder().setName(name).build();
        HelloResp response = blockingStub.sayHello(request);
        return response.getReply();
    }

    public static void main(String[] args) throws InterruptedException {
        HelloClient client = new HelloClient("127.0.0.1", 50051);
        String content = client.sayHello("Java client");
        System.out.println(content);
        client.shutdown();
    }

}
