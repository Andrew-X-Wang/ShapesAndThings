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
public class Triangle extends Shape
{
    int xTop;
    int yTop;
    int xRight;
    int yRight;
    int xLeft;
    int yLeft;
    
    int num; //is this necessary
    
    int height;
    int width;
    int xCenter;
    int yBottom;
    
    Triangle[] threeTri = new Triangle[3];
    
    /**
     * Constructor for objects of class Triangle
     */
    public Triangle(int xT, int yT, int xR, int yR, int xL, int yL, int n)
    {
        setPreferredSize(new Dimension(super.xDim, super.yDim));
        setBackground(Color.BLUE);
        setLayout(new BorderLayout());
        
        xTop = xT;
        yTop = yT;
        xRight = xR;
        yRight = yR;
        xLeft = xL;
        yLeft = yL;
        
        num = n;
        
        height = yRight - yTop;
        width = xRight - xLeft;
        xCenter = xTop;
        yBottom = yRight;
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void addTriangles()
    {
        threeTri[0] = new Triangle(xTop, yRight, xTop + height / 4, yRight + height / 2, xTop - height / 4, yLeft + height / 2, num -1);    //bottom
        threeTri[1] = new Triangle(xTop + width / 2 ,yTop, xTop + width * 3 / 4, yTop + height / 2, xTop + width / 4, yTop + height / 2, num - 1);    //left
        threeTri[2] = new Triangle(xTop - width / 2, yTop, xTop - width * 3 / 4, yTop + height / 2, xTop - width / 4, yTop + height / 2, num -1);    //right 
    }
    
    public void paintComponent(Graphics g)
    {   //first draws outermost triangle... means it draws it over again every time but idrc
        g.setColor(Color.BLUE);
        
        g.drawLine(PAD - (xDim - 2*PAD) / 2, PAD, xDim - (PAD - (xDim - 2*PAD) / 2), PAD);                               //   (xDim - 2*PAD) = width;
        g.drawLine(PAD - (xDim - 2*PAD) / 2, PAD, xDim / 2, PAD + 2 * (yDim - 2 * PAD));
        g.drawLine(xDim / 2, PAD + 2 * (yDim - 2 * PAD), xDim - (PAD - (xDim - 2*PAD) / 2), PAD);          //  yDim - 2*PAD = height; pad + 1.5 * height = yDim - 
        
        /**for(int counter = 0; counter < shapeList.size(); counter ++)
        {
            System.out.println("-----");
            System.out.println(counter);
            System.out.println("");
            
            Shape thisTri = shapeList.get(counter);
            g.drawLine(thisTri.xTop, thisTri.yTop, thisTri.xRight, thisTri.yRight);
            System.out.println(thisTri.xTop + " " + thisTri.yTop + " " + thisTri.xRight + " " + thisTri.yRight);
            
            g.drawLine(thisTri.xTop, thisTri.yTop, thisTri.xLeft, thisTri.yLeft);
            System.out.println(thisTri.xTop + " " + thisTri.yTop + " " + thisTri.xLeft + " " + thisTri.yLeft);
            
            g.drawLine(thisTri.xLeft, thisTri.yLeft, thisTri.xRight, thisTri.yRight);
            System.out.println(thisTri.xLeft + " " + thisTri.yLeft + " " + thisTri.xRight + " " + thisTri.yRight);
            
            thisTri.addTriangles();
            
            for(int counter2 = 0; counter2 < thisTri.threeTri.length; counter2 ++)
            {
                if(thisTri.threeTri[counter2] != null)
                {
                    triList.add(thisTri.threeTri[counter2]);
                }
            }
        }*/
        
        System.out.println("-----");
        System.out.println(num);
        System.out.println("");
            
        //this below draws the actual triangle in question
        g.drawLine(xTop, yTop, xRight, yRight);
        System.out.println(xTop + " " + yTop + " " + xRight + " " + yRight);
        
        g.drawLine(xTop, yTop, xLeft, yLeft);
        System.out.println(xTop + " " + yTop + " " + xLeft + " " + yLeft);
            
        g.drawLine(xLeft, yLeft, xRight, yRight);
        System.out.println(xLeft + " " + yLeft + " " + xRight + " " + yRight);
        
        //num --;
        if(num > 0)
        {
            this.addTriangles();
            System.out.println("New Triangle:" + num);
            for(int counter = 0; counter < threeTri.length; counter ++)
            {
                Triangle thisTri = threeTri[counter];
                thisTri.paintComponent(g);  //code reaches this line successfully but the repaint fails? I'm 99% certain I spelled it corrently so it should call the paintComponent(g)??
            }
        }
    }
}
