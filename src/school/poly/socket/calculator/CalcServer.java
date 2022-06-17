package school.poly.socket.calculator;

/**
 * @author Taewoo
 */

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class CalcServer {
    @SneakyThrows
    public static void main(String[] args) {
        ServerSocket server = new ServerSocket(5001);
        System.out.println("사용자 연결 대기 중...");

        Socket connection = server.accept();
        System.out.println("계산식 입력 대기 중...");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String msg;

        while ((msg = in.readLine()) != null) {
            if (msg.contains("bye")) break;

            String token = msg.split(" ")[1];

            int left = Integer.parseInt(msg.split(" ")[0]);
            int right = Integer.parseInt(msg.split(" ")[2]);

            if (token.equals("+")) System.out.println(left + right);
            else if (token.equals("-")) System.out.println(Math.max(left, right) - Math.min(left, right));
            else if (token.equals("*")) System.out.println(left * right);
            else System.out.println("잘못된 수식이 입력되었습니다.");

        }

        System.out.println("서버 종료...");
        in.close();
        connection.close();
        server.close();
    }
}

