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
  /**
  1) Please ensure that boolean variable which is used to stop the thread is volatile, otherwise, in the worst case your thread may not stop and run infinitely, Why? because, in the absence of any synchronization instruction e.g. volatile modifier here, the compiler is free to cache the value of boolean variable exit, which means even if the main thread makes it true, Server will always see it false, thus running infinitely. This concept is often tested in Java interviews as well.
  */
  private volatile boolean isListening = true;
  private Scanner keyboard;
  private String killWord = "secret";

  public KeyBoardListener(Scanner scanner) {
    this.keyboard = scanner;
  }

  @Override
  public void run() {
    // This is the main entry method to this separate threaded class
    while (this.isListening) {
      // (Blocking) listening for keyboard inputs
      String myInput = keyboard.nextLine();
      // Check if input is kill string
      if (myInput.equals(this.killWord)) this.kill();
      System.out.println("Input: " + myInput);
    }
  }

  public void kill() {
    // End this thread
    this.isListening = false;
  }
}
