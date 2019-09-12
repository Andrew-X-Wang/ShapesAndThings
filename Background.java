import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
import java.util.ArrayList;

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends JPanel
{
    int xDim = 700;
    int yDim = 700;
    
    int PAD = 250;
    
    ArrayList<Shape> shapeList = new ArrayList<Shape>();
    
    int num = 6;
    
    String shape = "Triangle";
    
    boolean sier = true;
    
    /**
     * Constructor for objects of class Background
     */
    public Background()
    {
        setPreferredSize(new Dimension(xDim, yDim));
        setBackground(Color.BLUE);      //WHY DOESNT THIS DO ANYTHING??
        setLayout(new BorderLayout());
        
        //Triangle triangle = new Triangle(xDim / 2, PAD, xDim / 2 + (yDim - 2 * PAD) / 2, yDim - PAD, xDim / 2 - (yDim - 2 * PAD) / 2, yDim - PAD, num);
        //triList.add(triangle);
        
        repaint();
        updateAll();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void paintComponent(Graphics g)
    {
        if(shape.equals("Triangle"))
        {
            shapeList.add(new Triangle(xDim / 2, PAD, xDim / 2 + (yDim - 2 * PAD) / 2, yDim - PAD, xDim / 2 - (yDim - 2 * PAD) / 2, yDim - PAD, num));
        }
        
        if(shape.equals("Square"))
        {
            shapeList.add(new Square(xDim + PAD, yDim - PAD, yDim - 2 * PAD, num, sier));
        }
        
        if(shape.equals("Pentagon"))
        {
            
        }
        
    }
    
    public void updateAll()
    {
        for(int counter = 0; counter < shapeList.size(); counter ++)
        {
            shapeList.get(counter).repaint();
        }
    }
}
