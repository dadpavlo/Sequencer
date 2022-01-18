import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel{


    public void paintComponent(Graphics g) {
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color color = new Color(red, green , blue);
        g.setColor(color);
        g.fillOval(70,70,100,100);
    }
}
