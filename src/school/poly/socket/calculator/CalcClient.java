package school.poly.socket.calculator;

/**
 * @author Taewoo
 */


import lombok.SneakyThrows;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.*;

public class CalcClient {
    @SneakyThrows
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Socket client = new Socket();
        System.out.println("계산기 서버와 연결 시도 중...");

        client.connect(new InetSocketAddress("localhost", 5001), 3000);
        System.out.println("계산기 서버와 연결 성공 ...");

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        System.out.println("수식을 입력해주세요.");

        String msg;
        while ((msg = sc.nextLine()) != null) {
            if (msg.contains("bye")) break;

            out.println(msg);

            System.out.println("보낼 수식이 더 있나요? (없다면 bye를 입력해주세요.)");
        }

        System.out.println("클라이언트 종료 ...");

        out.close();
        sc.close();
        client.close();
    }
}
