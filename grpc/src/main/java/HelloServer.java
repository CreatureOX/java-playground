import com.creatureox.grpc.Greeting;
import com.creatureox.grpc.HelloResp;
import com.creatureox.grpc.HelloWorldGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author CreatureOX
 * date: 2020/8/5
 * description:
 */
public class HelloServer {

    private Server server;

    private void start() throws IOException {
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService(new HelloImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    HelloServer.this.stop();
                }catch (InterruptedException e){
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });

    }

    private void stop() throws InterruptedException {
        if (server != null){
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null){
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final HelloServer server = new HelloServer();
        server.start();
        server.blockUntilShutdown();
    }

    private static class HelloImpl extends HelloWorldGrpc.HelloWorldImplBase {
        @Override
        public void sayHello(Greeting request, StreamObserver<HelloResp> respStreamObserver){
            HelloResp helloResp = HelloResp.newBuilder().setReply("Hello," + request.getName() + "!I am server").build();
            respStreamObserver.onNext(helloResp);
            respStreamObserver.onCompleted();
        }

    }

}
