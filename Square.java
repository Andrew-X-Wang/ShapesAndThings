import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
import java.util.ArrayList;

/**
 * Write a description of class Triangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Square extends Shape
{
    int xPos;   //top left hand corner coords
    int yPos;
    int height;
    
    int num; //is this necessary
    
    Square[] fourSquare = new Square[4];
    
    /**
     * Constructor for objects of class Triangle
     */
    public Square(int xp, int yp, int h, int n)
    {
        setPreferredSize(new Dimension(super.xDim, super.yDim));
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        
        xPos = xp;
        yPos = yp;
        height = h;
        
        num = n;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void addSquares()//not done
    {
        fourSquare[0] = new Square(xPos + height / 4, yPos - height / 2, height / 2, num - 1);    //top
        fourSquare[1] = new Square(xPos + height / 4, yPos + height, height / 2, num - 1);    //bottom
        fourSquare[2] = new Square(xPos - height / 2, yPos + height / 4, height / 2, num - 1);    //left
        fourSquare[3] = new Square(xPos + height, yPos + height / 4, height / 2, num - 1);    //right
    }
    
    public void paintComponent(Graphics g)
    {
        //@TODO: outside square?
        g.setColor(Color.BLACK);
        
        g.drawRect(xPos, yPos, height, height);
        g.drawRect(0, 0, 10, 10);
        //System.out.println(num); this prints??
        System.out.println("xPos: " + xPos + " yPos: " + yPos + " Height: " + height);
        //num --;
        if(num > 0)
        {
            addSquares();
            for(int counter = 0; counter < fourSquare.length; counter ++)
            {
                fourSquare[counter].paintComponent(g);
            }
        }
    }
}
