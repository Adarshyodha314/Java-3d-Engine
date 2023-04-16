package _3DENGINE;
import java.awt.*;  
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

  /*  NSTRUCTIONS TO MAKE 3D SHPAES
YOU HAVE TO ASSIGN A 2D ARRAY AND YOU HAVE TO STORE THE COORDINATES OF YOUR 3D SHAPE IN THAT ARRAY .
THE FIRST COORDINATE WILL BE JOINED WITH THE SECOND THROUGH A LINE AND SECOND WILL BE JOINED WITH THIRD WITH A LINE AND THIS 3D ENGINE WILL FOLLOW THIS PATTERN TO FORM A 3D SHAPE.YOU CAN CHECK THE EXAMPLE OF CUBE IN THIS FUNCTION. */
public class MAIN extends Canvas{  
      
    public void paint(Graphics g) {  
     // ROTATION (ANGLES)(N DEGREES)
     //YOU CAN ROTATE CUBE BY CHANGING THE VALUE OF DEGX,Y,Z.
      double degx=0;
      double degy=0;
      double degz=0;
      
      //MAKING CUBE 
 //CUBE COORDINATES    
      int size = 150;
double[][] cube = {
    {0, 0, 0}, {size, 0, 0}, 
    {size, 0, 0}, {size, size, 0},
    {size, size, 0}, {0, size, 0},
    {0, size, 0}, {0, 0, 0},
    {0, 0, size}, {size, 0, size},
    {size, 0, size}, {size, size, size},
    {size, size, size}, {0, size, size},
    {0, size, size}, {0, 0, size},
    {0, 0, 0}, {0, 0, size},
    {size, 0, 0}, {size, 0, size},
    {size, size, 0}, {size, size, size},
    {0, size, 0}, {0, size, size}
}; 
  TDFUN.MAKE3D(cube, g, new Color(0,0,0), degx, degy, degz);

   // 3D AXIS {
   double[][] axisy={{0,0,0},
                    {0,-200,0}};
   double[][] axisx={{0,0,0},
                    {200,0,0}};
   double[][] axisz={{0,0,0},
                    {0,0,200}};
 TDFUN.MAKE3D(axisx,g,new Color(206,0,0),0,0,0);
 TDFUN.MAKE3D(axisy,g,new Color(40,155,0),0,0,0);
 TDFUN.MAKE3D(axisz,g,new Color(17,0,173),0,0,0); //}
  }  
  public static void main(String[] args) {     
   //THIS IS THE MAIN FUNCTION FOR GUI IMPLEMENTATION OF THE 3D SHAPES THAT WE HAVE MADE.
        MAIN m=new MAIN();  
        JFrame f=new JFrame();  
        f.add(m);  
        f.setSize(500,500);  
        f.getContentPane().setBackground(Color.WHITE);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true); 
}
}
