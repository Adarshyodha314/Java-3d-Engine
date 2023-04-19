package _3DENGINE;
import java.lang.Math.*;
import java.util.*;
import java.awt.*; 
class TDFUN{
  // THIS FUNCTION IS USED TO PROJECT THE 3D COORDINATES ON 2D SPACE/SCREEN.
 // Check This : https://stackoverflow.com/a/74890600/20496842
 // This Answer on stackoverflow will help you to understand this Function 
public static double PERSPECTIVE_PROJECTION(double[] a,double degx, double degy, double degz,int b){
// THIS ARE some ROTATION MATRIX's USED FOR ROTATION OF 3D MODEL
  double[][] rttz={
    {(Cos(degz)),(-1*(Sin(degz))),0},
    {(Sin(degz)),(Cos(degz)),0},
    {0,    0     ,       1    },
  };
  
  double[][] rtty={
    {(Cos(degy)),0,(Sin(degy))},
    {0,    1     ,       0    },
    {(-1*(Sin(degy))),0,(Cos(degy))},
  };
  
   double[][] rttx={
    {1,    0     ,       0     },
    {0,(Cos(degx)),(-1*(Sin(degx)))},
    {0,(Sin(degx)),(Cos(degx))}};
  double[] rotated=Matmul(Matmulr(Matmulr(a,rttz),rtty),rttx);
  int fovl=1000;  // THIS VALUE CAN BE ADJUSTED IF YOUR MODEL STRETCHES.
  double oldpos=rotated[b];
  double z=rotated[2];
  double newpos=(double)(fovl/(fovl+z))*oldpos;
  return newpos;
 }
 
 // FUNCTION TO MULTIPLY MATRIX .IT IS USED IN PERSPECTIVE PROJECTION.
public static double[] Matmul(double[] a,double[][] b){
   double[] result= new double[b.length];
  double sum=0;
  for(int i=0;i!=b.length;i++){
  for(int j=0;j!=b[0].length;j++){
   sum+=b[i][j]*a[j];}
   result[i]=sum+250;// THIS 250 IS ADDED TO TAKE THE 3D MODEL IN CENTRE ELSE 3D MODEL WILL BE SHOWED ON TOP LEFT CORNER AS IT IS THE (0,0) coordinate ACCORDING TO JAVA.
sum=0;
}
 return result;
     }
     
 // SIMPLE MATRIX MULTIPLICATION FOR MULTIPLYING ROTATION MATRIX WITH 3D COORDINATES.
public static double[] Matmulr(double[] a,double[][] b){
   double[] result= new double[b.length];
  double sum=0;
  for(int i=0;i!=b.length;i++){
  for(int j=0;j!=b[0].length;j++){
   sum+=b[i][j]*a[j];}
   result[i]=sum;
sum=0;
}
 return result;
     }
public static double Sin(double a){
   double radians = Math.toRadians(a); 
        double sinValue = Math.sin(radians); 
        return sinValue;
 }
public static double Cos(double a){
   double radians = Math.toRadians(a); 
        double cosValue = Math.cos(radians); 
        return cosValue;
 }
 
  // 3D GRAPHICS BASED FUNCTION THAT MAKES 3D OBJECT ON SCREEN
 
 // THIS FUNCTION CONNECTS 2 POINTS IN 2D SCREEN AFTER CONVERSION OF 3D COORDINATES TO 2D COORDINATES.THIS FUNCTION IS USED IN MAKE3D FUNCTION.
  public static void drawtopoint(Graphics g,int[] x,int[] y,Color c){
   Graphics2D g2d = (Graphics2D) g;
   g2d.setStroke(new BasicStroke(3.0f));
 for(int j=0;j!=x.length-1;j++){
        g.setColor(c);
  g2d.drawLine(x[j],y[j],x[j+1],y[j+1]);
  g2d.drawLine(x[x.length-1],y[y.length-1],x[0],y[0]);
 }
 }
  
 //  THIS FUNCTION TAKE 3D COORDINATES AND CONVERTS IT TO 2D COORDINATES WITH HELP OF PERSPECTIVE PROJECTION FUNCTION AND THEN IT CONNECTS THE COORDINATES TO FORM A LINE AND TO FORM A 3D SHAPE.
    public static void MAKE3D(double[][] p, Graphics g,Color c,double degx,double degy,double degz){
int[] x= new int[p.length];
int[] y= new int[p.length];
   for(int i=0;i!=p.length;i++){
   double[] arr={ p[i][0],p[i][1],p[i][2]  };
 x[i]=(int)PERSPECTIVE_PROJECTION(arr,degx,degy,degz, 0);
 y[i]=(int)PERSPECTIVE_PROJECTION(arr,degx,degy,degz, 1);
   }
   drawtopoint(g,x,y,c);
  }
  
  
}


