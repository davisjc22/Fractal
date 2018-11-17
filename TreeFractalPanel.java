import java.awt.Color;
import java.awt.Graphics2D;


public class TreeFractalPanel extends FractalPanel{
	private Color[] rainbow = {Color.BLUE, Color.RED, Color.MAGENTA, Color.CYAN, new Color(102,255,10)};
	//INHERITED THIS FROM DAD: don't uncomment these!
	//protected Graphics2D myGraphics;	<<--- Your crayon
	//protected int totalLevels; <<---how many levels you need to draw
	//protected Color bgColor = Color.WHITE;
	
	public static void main(String[] args) {
		
		new FractalFrame( new TreeFractalPanel());
	}
	
	public void getStarted(int numLevels){
		//the image is cleared (set to blank & white)
		super.getStarted(numLevels);
		/********************************************************
		 * 	Place the FIRST call to recursive drawing function here!!
		/********************************************************/
	
		Coordinate top = new Coordinate (400,400);
		Coordinate bottom = new Coordinate (400,600);
		top.lineTo(bottom, myGraphics);
		//now give the tree trunk bunny ears
		
		recur(0, bottom, top);
		
		
		
	}//end getStarted
	
	/*Preconditions:
	 * 	g is the graphics object for the bufferedImage to which the fractal will be drawn
	 * 
	 *Postconditions: Part of the current level is drawn, and recurvsive calls are executed
	 *      that will draw the next level of the fractal 
	 */
	//private void recursiveDraw(Graphics2D g, Color c, int num, int x, int y, int sz){
	private void recur(int levelsDrawn, Coordinate b, Coordinate t){
		//STOPPING STATE!!!!!!!!!!!!!!!!!
		if (levelsDrawn>=totalLevels)
			return;
		
		pause(30.0/totalLevels, levelsDrawn);
		//BUNNY EAR FUNCTION!!!!!!!!!!!
		Color theColor = rainbow[(int)(Math.random()*rainbow.length)];
		//right ear!
		Coordinate right = new Coordinate(b);
		right.rotateAround(t,3*Math.PI/4);
		right.scaleDistFrom(t,.75);
		right.lineTo(t, myGraphics, theColor);
		
		//left ear!
		Coordinate left= new Coordinate(b);
		left.rotateAround(t, -3*Math.PI/4);
		left.scaleDistFrom(t,.75);
		left.lineTo(t, myGraphics, theColor);
		
		
		//recursive steps!!!!
		recur(levelsDrawn+1, t, left);
		recur(levelsDrawn+1, t, right);
		
		
	}//end recur function

}
