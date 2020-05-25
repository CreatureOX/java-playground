package netty;

import io.IOClient;
import io.IOServer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author CreatureOX
 * date: 2020/5/24
 * description:
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();

        NioEventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) {
                        channel.pipeline().addLast(new StringEncoder());
                    }
                });

        Channel channel = bootstrap.connect(IOServer.HOST, IOServer.PORT).channel();
        while (true){
            channel.writeAndFlush(IOClient.PAYLOAD);
            System.out.println(String.format("send message: %s", IOClient.PAYLOAD));
            Thread.sleep(IOClient.SLEEP_MILLIS);
        }
    }
}
