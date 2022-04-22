package school.poly.swing.event.src.가위바위보;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @author TaeWK
 */
public class Main extends JFrame {

    /*
        되게 열심히 했는데 점수판이 안붙네요.
        코드가 생각보다 더러워서 주석에 설명 달았습니다.

        -- 일단 Console로 승 패 처리했습니다.
     */


    static Random random = new Random();

    // 로직에서 1,2,3 하면  뭐가 뭔지 모를까봐ㄴ 상수로 정의했습니다.
    static final int ROCK = 1;
    static final int SCISSORS = 2;
    static final int PAPPER = 3;

    // score
    static int player_win = 0;
    static int computer_win = 0;
    static int draw = 0;


    static int userPick = (int) 2e10;
    static int computerPick = (int) 2e10;


    JButton rockButton = new JButton("1");
    JButton scissorsButton = new JButton("2");
    JButton papperButton = new JButton("3");


    JLabel label = new JLabel();
    JLabel scoreLabel = new JLabel();
    JLabel computerLabel = new JLabel();
    JLabel userLabel = new JLabel();


    ImageIcon computer = new ImageIcon(Main.class.getResource("robot.jpg"));
    ImageIcon user = new ImageIcon(Main.class.getResource("user.png"));
    ImageIcon rock = new ImageIcon(Main.class.getResource("rock.png"));
    ImageIcon scissors = new ImageIcon(Main.class.getResource("scissors.png"));
    ImageIcon papper = new ImageIcon(Main.class.getResource("papper.png"));


    // Default Constructor
    Main() {
        setDefault();
        refresh();
        setLabel();
        refresh();
        setSelectionImage();
        refresh();
    }


    void setLabel() {
        label.setSize(900, 50);
        label.setLocation(280,0);
        label.setText("바위 가위 보자기 중 하나를 선택하면 게임이 시작됩니다.");
        label.setBackground(Color.black);
        label.setVisible(true);
        add(label);
    }

    void refresh() {
        setVisible(false);
        setVisible(true);
    }

    // 사진 배치
    void setSelectionImage() {

        // 사진들 사이즈 조정 ( 사용자 정의함수 )
        rock = imageSetSize(rock, 300, 300);
        scissors = imageSetSize(scissors, 300, 300);
        papper = imageSetSize(papper, 300, 300);
        computer = imageSetSize(computer,400,300);
        user = imageSetSize(user,400,300);


        // 각 버튼에 이미지 삽입
        rockButton.setIcon(rock);
        scissorsButton.setIcon(scissors);
        papperButton.setIcon(papper);

        // 각 라벨에 이미지 삽입
        computerLabel.setIcon(computer);
        userLabel.setIcon(user);

        
        // 사이즈 조절
        rockButton.setBounds(0, 50, 300, 300);
        scissorsButton.setBounds(300, 50, 300, 300);
        papperButton.setBounds(600, 50, 300, 300);
        computerLabel.setBounds(50,400, 400,300);
        userLabel.setBounds(450,400,400,300);

        // score 라벨
        scoreLabel.setBackground(Color.black);
        scoreLabel.setText(String.valueOf(computer_win +"  :  "+ player_win));
        scoreLabel.setSize(200,200);
        scoreLabel.setLocation(450,900);
        scoreLabel.setForeground(Color.black);


        ActionListener actionListener = new MyActionListener();

        rockButton.addActionListener(actionListener);
        scissorsButton.addActionListener(actionListener);
        papperButton.addActionListener(actionListener);

        add(rockButton);
        add(scissorsButton);
        add(papperButton);

        add(computerLabel);
        add(userLabel);
        add(scoreLabel);

        setVisible(true);
    }

    // 이미지 사이즈 변환 사용자 정의 함수.
    ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
        Image ximg = icon.getImage();  //ImageIcon을 Image로 변환.
        Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
        ImageIcon xyimg = new ImageIcon(yimg);
        return xyimg;
    }


    // 사진 클릭 시 발생할 이벤트 (가위바위보 로직)
    class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();

            userPick = Integer.parseInt(button.getText());
            computerPick = random.nextInt(3) + 1;


            // 컴퓨터 사진 바꾸기.
            if(computerPick == ROCK){
                computerLabel.setIcon(rock);
            }else if(computerPick == SCISSORS){
                computerLabel.setIcon(scissors);
            }else if(computerPick == PAPPER){
                computerLabel.setIcon(papper);
            }

            // 플레이어 사진 바꾸기.
            if(userPick == ROCK){
                userLabel.setIcon(rock);
            }else if(userPick == SCISSORS){
                userLabel.setIcon(scissors);
            }else if( userPick == PAPPER){
                userLabel.setIcon(papper);
            }


            if(userPick == computerPick) {
                System.out.println("Draw");
                draw++;
                return;
            }

            if(userPick == ROCK){
                if(computerPick == SCISSORS){
                    System.out.println("Player 승리");
                    player_win ++;
                }else if(computerPick == PAPPER){
                    System.out.println("Player 패배");
                    computer_win++;
                }
            }else if(userPick == SCISSORS){
                if(computerPick == ROCK){
                    System.out.println("Player 패배");
                    computer_win++;
                }else if(computerPick == PAPPER){
                    System.out.println("Player 승리");
                    player_win ++;
                }

            }else if(userPick == PAPPER){
                if(computerPick == ROCK){
                    System.out.println("Player 승리");
                    player_win ++;
                }else if(computerPick == SCISSORS){
                    System.out.println("Player 패배");
                    computer_win++;
                }
            }
            System.out.println("컴퓨터: "+ computer_win +"\t" + "유저: "+ player_win + "\t무승부: " + draw);
        }
    }

    void setDefault() {
        setSize(900, 1000);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
