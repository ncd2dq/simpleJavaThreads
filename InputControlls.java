
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class InputControlls {

  public static void main(String[] argv) throws Exception {

    JTextField textField = new JTextField();
    textField.addKeyListener(new MKeyListener());

    JFrame jframe = new JFrame();

    jframe.add(textField);

    jframe.setSize(400, 350);

    jframe.setVisible(true);
  }
}

class MKeyListener extends KeyAdapter {

  @Override
  public void keyPressed(KeyEvent event) {
    System.out.println("KeyPressed -> " + event.getKeyChar());
  }
}
