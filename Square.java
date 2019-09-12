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
    
    boolean sier;
    
    Square[] nineSquare = new Square[9];
    
    Square[] fourSquare = new Square[4];
    
    /**
     * Constructor for objects of class Triangle
     */
    public Square(int xp, int yp, int h, int n, boolean s)
    {
        setPreferredSize(new Dimension(super.xDim, super.yDim));
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        
        xPos = xp;
        yPos = yp;
        height = h;
        
        num = n;
        
        sier = s;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void addSquares()//not done
    {
        if (sier)
        {
            int newXPos;
            int newYPos;
            int newHeight;
            int newNum = num - 1;
            for (int row = 0; row < 3; row ++)
            {
                for (int col = 0; col < 3; col ++)
                {
                    newXPos = xPos + height * row - height * 2 / 3;
                    newYPos = yPos + height * col - height * 2 / 3;
                    newHeight = height / 3;
                    nineSquare[3 * row + col] = new Square(newXPos, newYPos, newHeight, newNum, sier);
                }
            }  
        }
        else
        {
            fourSquare[0] = new Square(xPos + height / 4, yPos - height / 2, height / 2, num - 1, sier);    //top
            fourSquare[1] = new Square(xPos + height / 4, yPos + height, height / 2, num - 1, sier);    //bottom
            fourSquare[2] = new Square(xPos - height / 2, yPos + height / 4, height / 2, num - 1, sier);    //left
            fourSquare[3] = new Square(xPos + height, yPos + height / 4, height / 2, num - 1, sier);    //right
        }
    }
    
    public void paintComponent(Graphics g)
    {
        //@TODO: outside square?
        g.setColor(Color.BLACK);
        
        g.drawRect(xPos, yPos, height, height);
        System.out.println("Num: " + num);
        System.out.println("xPos: " + xPos + " yPos: " + yPos + " Height: " + height);
        if(num > 0)
        {
            addSquares();
            if (sier)
            {
                for (int counter = 0; counter < nineSquare.length; counter ++) 
                {
                    if (counter != 4)
                    {
                        nineSquare[counter].paintComponent(g);
                    }
                }
            }
            else
            {
                for(int counter = 0; counter < fourSquare.length; counter ++)
                {
                    fourSquare[counter].paintComponent(g);
                }
            }
        }
    }
}
