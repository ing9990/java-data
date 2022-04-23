package code.macro;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class CommandLineExecutor {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        System.out.println("TISTORY 주소 \"https://----.tistory.com\" 양식으로 작성. ");
        String url = sc.next();

        System.out.println("반복할 페이지");
        int page = sc.nextInt();

        System.out.println("반복할 횟수");
        int loop = sc.nextInt();

        for (int l = 0; l < loop; l++) {
            CommandLineExecutor.execute("@start " + url + "/" + page);
            sleep(300);
        }
    }

    public static void execute(String cmd) {
        Process process = null;
        Runtime runtime = Runtime.getRuntime();
        StringBuffer successOutput = new StringBuffer();
        StringBuffer errorOutput = new StringBuffer();
        BufferedReader successBufferReader = null;
        BufferedReader errorBufferReader = null;
        String msg = null;

        List<String> cmdList = new ArrayList<>();

        cmdList.add("cmd");
        cmdList.add("/c");

        cmdList.add(cmd);

        String[] array = cmdList.toArray(new String[cmdList.size()]);

        try {
            process = runtime.exec(array);
            successBufferReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "EUC-KR"));

            while ((msg = successBufferReader.readLine()) != null) {
                successOutput.append(msg + System.getProperty("line.separator"));
            }

            errorBufferReader = new BufferedReader(new InputStreamReader(process.getErrorStream(), "EUC-KR"));
            while ((msg = errorBufferReader.readLine()) != null) {
                errorOutput.append(msg + System.getProperty("line.separator"));
            }

            process.waitFor();

            if (process.exitValue() == 0) {
                System.out.println("성공");
                System.out.println(successOutput.toString());
            } else {
                System.out.println("비정상 종료");
                System.out.println(successOutput.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                process.destroy();
                if (successBufferReader != null) successBufferReader.close();
                if (errorBufferReader != null) errorBufferReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}