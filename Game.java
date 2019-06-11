import java.util.*;

/**
Pass an instance of your class that implements the Runnable interface to the
constructor of a Thread

call .start();
*/
public class Game {
  public static void main(String[] args) {
    System.out.println("Hello world");

    KeyBoardListener keyboardListener = new KeyBoardListener(new Scanner(System.in));
    Thread keyboardThread = new Thread(keyboardListener);
    keyboardThread.start();

    //keyboardListener.kill();
  }
}



/**
Create a class that implements the Runnable interface which only has 1
public abstarct method - run()
*/
class KeyBoardListener implements Runnable {
  private boolean isListening = true;
  private Scanner keyboard;

  public KeyBoardListener(Scanner scanner) {
    this.keyboard = scanner;
  }

  @Override
  public void run() {
    while (this.isListening) {
      String myInput = keyboard.nextLine();
      System.out.println("Input: " + myInput);
    }
  }

  public void kill() {
    this.isListening = false;
  }
}
