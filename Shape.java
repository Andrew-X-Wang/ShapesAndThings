import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
import java.util.ArrayList;

/**
 * Write a description of class Shape here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shape extends Background
{
    int xDim;
    int yDim;
    /**
     * Constructor for objects of class Shape
     */
    public Shape()
    {
        xDim = super.xDim;      //does this do anything? is it necessary?
        yDim = super.yDim;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void paintComponent(Graphics g)
    {
        //super.paintComponent(g);
    }
}
