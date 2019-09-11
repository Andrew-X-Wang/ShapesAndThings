import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
import java.util.ArrayList;

/**
 * Write a description of class BackgroundDriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackgroundDriver extends JFrame
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Try this");
        Background b = new Background();
        if(b.shape.equals("Triangle"))
        {
            frame.add(new Triangle(b.xDim / 2, b.PAD, b.xDim / 2 + (b.yDim - 2 * b.PAD) / 2, b.yDim - b.PAD, b.xDim / 2 - (b.yDim - 2 * b.PAD) / 2, b.yDim - b.PAD, b.num));
        }
        if(b.shape.equals("Square"))
        {
            frame.add(new Square(b.xDim + b.PAD, b.yDim - b.PAD, b.yDim - 2 * b.PAD, b.num));
        }
        //frame.add(b);
        frame.pack(); // prepares frame for display
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
