package io;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author CreatureOX
 * date: 2020/5/24
 * description:
 */
public class IOServer {

    public static final String HOST = "127.0.0.1";

    public static final int PORT = 8010;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        new Thread(() -> {
            while (true){
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println(String.format("accept socket: %s", socket.getInetAddress()));
                    new Thread(() -> {
                        try {
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            while (true) {
                                int len;
                                while((len = inputStream.read(data)) != -1) {
                                    System.out.println(String.format("receive message: %s", new String(data, 0, len)));
                                }
                            }
                        }catch (Exception e){

                        }
                    }).start();
                }catch (Exception e){

                }
            }
        }).start();
    }
}
