package nio;

import io.IOServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author CreatureOX
 * date: 2020/5/24
 * description:
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        Selector serverSelector = Selector.open();
        Selector clientSelector = Selector.open();

        new Thread(() -> {
            try {
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.socket().bind(new InetSocketAddress(IOServer.PORT));
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.register(serverSelector, SelectionKey.OP_ACCEPT);
                while (true){
                    if (serverSelector.select(1) > 0){
                        Set<SelectionKey> selectionKeySet = serverSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = selectionKeySet.iterator();
                        while (keyIterator.hasNext()){
                            SelectionKey key = keyIterator.next();
                            if (key.isAcceptable()){
                                try {
                                    SocketChannel socketChannel = ((ServerSocketChannel) key.channel()).accept();
                                    socketChannel.configureBlocking(false);
                                    socketChannel.register(clientSelector, SelectionKey.OP_READ);
                                }finally {
                                    keyIterator.remove();
                                }
                            }
                        }
                    }
                }
            }catch (IOException e){

            }
        }).start();

        new Thread(() -> {
            try {
                while (true){
                    if (clientSelector.select(1L) > 0){
                        Set<SelectionKey> selectionKeySet = clientSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = selectionKeySet.iterator();
                        while (keyIterator.hasNext()){
                            SelectionKey key = keyIterator.next();
                            if (key.isReadable()){
                                try {
                                    SocketChannel socketChannel = (SocketChannel) key.channel();
                                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                    socketChannel.read(byteBuffer);
                                    byteBuffer.flip();
                                    System.out.println(String.format("receive message: %s", Charset.defaultCharset().newDecoder().decode(byteBuffer).toString()));
                                }finally {
                                    keyIterator.remove();
                                    key.interestOps(SelectionKey.OP_READ);
                                }
                            }
                        }
                    }
                }
            }catch (IOException e){

            }
        }).start();
    }
}
