package io;

import java.net.Socket;

/**
 * @author CreatureOX
 * date: 2020/5/24
 * description:
 */
public class IOClient {

    public static final String PAYLOAD = "hello world";

    public static final long SLEEP_MILLIS = 2 * 1000L;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket(IOServer.HOST, IOServer.PORT);
                while (true){
                    try {
                        socket.getOutputStream().write(PAYLOAD.getBytes());
                        socket.getOutputStream().flush();
                        System.out.println(String.format("send message: %s", PAYLOAD));
                        Thread.sleep(SLEEP_MILLIS);
                    }catch (Exception e){

                    }
                }
            }catch (Exception e){

            }
        }).start();
    }
}
