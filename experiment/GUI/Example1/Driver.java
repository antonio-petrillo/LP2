import java.awt.*;
import javax.swing.*;

public class Driver {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new JFrame();
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}
