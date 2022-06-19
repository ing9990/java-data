package school.poly.socket.threadChat;

/**
 * @author Taewoo
 */


import lombok.SneakyThrows;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Echo2Client {
    @SneakyThrows
    public static void main(String[] args) {

        Socket client = new Socket();
        System.out.println("에코 서버와 연결 시도 ...");
        client.connect(new InetSocketAddress("localhost", 5000), 3000);

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);
        String msg;

        System.out.println("보낼 메세지가 있나요??");

        while ((msg = sc.nextLine()) != null) {
            if (msg.contains("bye")) break;

            out.println(msg);
            System.out.println("더 보낼 메세지가 있나요??");
        }

        System.out.println("클라이언트 종료.");

        out.close();
        sc.close();
        client.close();
    }
}
