import java.util.Random;
import java.util.Scanner;

public class StonePaperScissor_Game {

  public static void main(String[] args) {
    System.out.println("Let's Start the Game \n Total 5 Turns");
    System.out.println(
      "Use the Following Numbers To give Input\n\t1-> for Rock\n\t2-> for paper\n\t3-> for Scissor"
    );

    Scanner scan = new Scanner(System.in);

    int i = 0;
    int a, flag = 0, ct = 0;
    while (i < 5) {
      System.out.print("Turn " + (i + 1) + ":");
      a = scan.nextInt();
      Random temp = new Random();
      int b = temp.nextInt(3);
      b++;

      if (a != b) {
        if (a == 1 && b == 3) {
          flag++;
          System.out.print("You:Rock     System:Scissor\t Turn Won\n");
        } else if (a == 2 && b == 1) {
          flag++;
          System.out.print("You:Paper     System:Rock\t Turn Won\n");
        } else if (a == 3 && b == 2) {
          flag++;
          System.out.print("You:Scissor     System:Paper\t Turn Won\n");
        } else if (a == 1 && b == 2) {
          System.out.print("You:Rock     System:Paper\t Turn Lost\n");
        } else if (a == 2 && b == 3) {
          System.out.print("You:Paper     System:Scissor\t Turn Lost\n");
        } else if (a == 3 && b == 1) {
          System.out.print("You:Scissor     System:Rock\t Turn Lost\n");
        }
      } else {
        System.out.println("Same Inputs\t Turn Draw\n");
        ct++;
      }
      i++;
    }

    if (flag >= 3) {
      System.out.println("Score: " + flag);
      System.out.println("You Won The Game");
    } else if (
      (flag == 0 && ct == 5) || (flag == 2 && ct == 1) || (flag == 1 && ct == 3)
    ) {
      System.out.println("Score: " + flag);
      System.out.println("Game Drawn");
    } else {
      System.out.println("Score: " + flag);
      System.out.println("You lost The Game");
    }
  }
}
