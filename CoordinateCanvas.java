import javax.swing.*;
import java.awt.*;

public class CoordinateCanvas extends JPanel{
	public static final int SIZE = 800;
	
	public CoordinateCanvas(){
		super();	
	}		
	public void paint(Graphics g){	
		super.repaint();
		drawGrid(g);
	/****** PUT YOUR CODE IN HERE :) *********/
		
			//EQUILATERAL TRIANGLE
			Coordinate eq1 = new Coordinate(100,300);
			Coordinate eq2 = new Coordinate(200,300);
			Coordinate eq3 = new Coordinate(eq2);
			eq3.rotateAround(eq1, Math.PI/3);
			
			eq1.draw(g,Color.BLUE, 5);
			eq2.draw(g, Color.BLUE, 5);
			eq3.draw(g, Color.BLUE, 5);
			eq1.lineTo(eq2, g, Color.BLUE);
			eq1.lineTo(eq3, g, Color.BLUE);
			eq2.lineTo(eq3, g, Color.BLUE);
			
			//SQUARE
			Coordinate sq1 = new Coordinate(200,550);
			Coordinate sq2 = new Coordinate(250,550);
			//sq2.rotateAround(sq1, Math.PI/4);
			Coordinate sq3 = new Coordinate(sq2);
			sq3.rotateAround(sq1,Math.PI/2);
			Coordinate sq4 = new Coordinate(sq1);
			sq4.rotateAround(sq2, -Math.PI/2);
			
			
			
			sq1.draw(g, Color.WHITE, 5);
			sq2.draw(g, Color.RED, 5);
			sq3.draw(g, Color.CYAN, 5);
			sq4.draw(g, Color.MAGENTA, 5);
			sq1.lineTo(sq2, g, Color.BLUE);
			sq2.lineTo(sq4, g, Color.GREEN);
			sq3.lineTo(sq1, g, Color.YELLOW);
			sq3.lineTo(sq4, g, Color.MAGENTA);
			
			
			//BOWTIE
			Coordinate bt1 = new Coordinate(700,300);
			Coordinate bt2 = new Coordinate(400,500);
			Coordinate bt3 = new Coordinate(bt2);
			Coordinate bt4 = new Coordinate(bt1);
			
			bt4.rotateAround(bt2,Math.PI);
			bt3.rotateAround(bt1, Math.PI/3);
			Coordinate bt5 = new Coordinate(bt3);
			bt5.rotateAround(bt2, -Math.PI);
			
			bt1.draw(g, Color.CYAN, 5);
			bt2.draw(g, Color.CYAN, 5);
			bt3.draw(g, Color.CYAN, 5);
			bt4.draw(g, Color.CYAN, 5);
			bt5.draw(g, Color.CYAN, 5);
			bt1.lineTo(bt2, g, Color.CYAN);
			bt1.lineTo(bt3, g, Color.CYAN);
			bt2.lineTo(bt3, g, Color.CYAN);
			bt4.lineTo(bt2, g, Color.CYAN);
			bt5.lineTo(bt2, g, Color.CYAN);
			bt5.lineTo(bt4, g, Color.CYAN);
			
			// 45-45-90 TRIANGLE
			
			Coordinate rt1= new Coordinate(500,300);
			Coordinate rt2= new Coordinate(600,250);
			Coordinate rt3= new Coordinate(rt2);
			rt3.rotateAround(rt1, Math.PI/2);
			
			rt1.draw(g, Color.BLUE, 5);
			rt2.draw(g, Color.BLUE, 5);
			rt3.draw(g, Color.BLUE, 5);
			rt1.lineTo(rt2, g, Color.ORANGE);
			rt2.lineTo(rt3, g, Color.ORANGE);
			rt3.lineTo(rt1, g, Color.ORANGE);
			
			
			// 30-60-90 TRIANGLE
			Coordinate t30 = new Coordinate(250, 150);
			Coordinate t60 = new Coordinate(100,150);
			Coordinate t90 = new Coordinate(t30);
			t90.rotateAround(t30, Math.PI/2);
			t90.scaleDistFrom(t60, 0.5);
			
			t30.draw(g,Color.RED, 5);
			t60.draw(g,Color.RED, 5);
			t90.draw(g,Color.RED, 5);
			t30.lineTo(t60, g, Color.WHITE);
			t60.lineTo(t90, g, Color.WHITE);
			t90.lineTo(t30, g, Color.WHITE);
			
			
			
	/*********Keep your code up there *********/		
	}//end paint
	
	public static void main(String[] args){
		JFrame app = new JFrame("Coordinate Canvas");
		app.setBackground(Color.BLACK);
		app.getContentPane().add(new CoordinateCanvas());
		app.setSize(SIZE, SIZE);
		app.setVisible(true);		
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	private void drawGrid(Graphics g){
		g.setColor(Color.CYAN);
		for(int x=0; x<SIZE; x+=50){
			g.drawLine(x,0,x,SIZE);
			g.drawString(""+x,x,15);
		}
		for(int y=0; y<SIZE; y+=50){
			g.drawLine(0,y,SIZE,y);
			g.drawString(""+y,4,y-5);
		}
	}
}
