package school.poly.socket.threadChat;

/**
 * @author Taewoo
 */


import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Echo2Server extends Thread {

    protected static boolean cont = true;
    protected Socket connetion = null;

    @SneakyThrows
    public static void main(String[] args) {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("소켓 서버 생성.");

        while (cont) {
            System.out.println("연결 대기 중...");
            new Echo2Server(server.accept());
        }
        server.close();
    }

    private Echo2Server(Socket clientSocket) {
        connetion = clientSocket;
        start();
    }

    @SneakyThrows
    public void run() {
        System.out.println("클라이언트 통신을 위한 새로운 소켓 생성");

        BufferedReader in = new BufferedReader(new InputStreamReader(connetion.getInputStream()));
        String msg;

        while ((msg = in.readLine()) != null) System.out.println("읽은 메세지 메아리: " + msg);

        in.close();
        connetion.close();
    }

}
