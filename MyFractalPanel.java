import java.awt.Color;
import java.awt.Graphics2D;


public class MyFractalPanel extends FractalPanel{
	//INHERITED THIS FROM DAD: don't uncomment these!
	//protected Graphics2D myGraphics;	<<--- Your crayon
	//protected int totalLevels; <<---how many levels you need to draw
	//protected Color bgColor = Color.WHITE;
	private static Color[] SCHEME;
	
	public static void main(String[] args) {
		SCHEME= makeScheme();//Makes the random color scheme
		new FractalFrame( new MyFractalPanel());//makes the fractal
	}
	
	public static Color[] makeScheme(){
		int R = (int)(Math.random()*256);//Variable for RED
		int G = (int)(Math.random()*256);//Variable for BLUE
		int B = (int)(Math.random()*256);//Variable for GREEN
		Color[] ans = {new Color( R, G, B), new Color( R,(G+40)%256, (B+60)%256), new Color((R+40)%256, G,(B+40)%256), new Color( (R+60)%256, (G+60)%256, B) };//Array of Colors for Scheme
		return ans;//reurns color scheme
	}
	
	public void getStarted(int numLevels){
		//the image is cleared (set to blank & white)
		super.getStarted(numLevels);
		/********************************************************
		 * 	Place the FIRST call to recursive drawing function here!!
		/********************************************************/
		//COLOR SCHEME GENERATOR
		
		
		Coordinate tl = new Coordinate(400,400);//topleft corner of square
		Coordinate tr = new Coordinate(500,400);//topright corner of square
		Coordinate bl = new Coordinate(400,500);//bottomleft corner of square
		Coordinate br = new Coordinate(500,500);//bottomright corner of square
		
		
		//DRAWING CENTER SQUARE
		//Coordinate[] centersquare = {tl,tr,br,bl};//array of coordinates of the center square
		//EZPolygon centercolor = new EZPolygon(centersquare);
		//centercolor.draw(myGraphics, SCHEME[0]);//colors in the center square
		
		recur(0, tl, tr, SCHEME);//top Pythagoras tree
		//recur(0, tr, br, SCHEME);//right Pythagoras tree
		//recur(0, br, bl, SCHEME);//bottom Pythagoras tree
		//recur(0, bl, tl, SCHEME);//left Pythagoras tree
		
		
		
		
		
		
	}//end getStarted
	
	/*Preconditions:
	 * 	g is the graphics object for the bufferedImage to which the fractal will be drawn
	 * 
	 *Postconditions: Part of the current level is drawn, and recurvsive calls are executed
	 *      that will draw the next level of the fractal 
	 */
	//private void recursiveDraw(Graphics2D g, Color c, int num, int x, int y, int sz){
	private void recur(int levelsDrawn, Coordinate bottomleft, Coordinate bottomright, Color[] scheme){
		
		//pause(30.0/totalLevels, levelsDrawn);
		//STOPPING STATE!!!!!!!!!!!!!!!!!
		if (levelsDrawn>=totalLevels)
			return;
		
		
		
		
		
		//MAKING THE SQUARE
		Coordinate topright = new Coordinate(bottomleft);//makes the topright corner of the Pythagoras tree base square
		topright.rotateAround(bottomright, -Math.PI/2);//puts it in the topright
		Coordinate topleft = new Coordinate(bottomright);//makes the bottomright corner of the Pythagoras tree base square
		topleft.rotateAround(bottomleft, Math.PI/2);//puts it in the bottomright
		
		Coordinate[] squarecoord = {topleft, topright, bottomright, bottomleft};//makes the coordinates into an array for ezpolygon
		EZPolygon square = new EZPolygon(squarecoord);//puts the coordinates in an ezpolygon to fill it in
		
		
		
		//DRAWING THE SQUARE
		
		
		square.draw(myGraphics, scheme[1]);//fills in the square
		
		//MAKING THE TRIANGLE
		Coordinate rightangle= new Coordinate(topright);//makes the top point for the right triangle
		rightangle.rotateAround(topleft, Math.PI/6);//rotates it to the top
		rightangle.scaleDistFrom(topleft,Math.sqrt(3)/2);//scales it to size
		
		Coordinate[] tricoord = {topleft, topright, rightangle};//puts the triangle coordinates into an array for ezpolygon
		EZPolygon tri = new EZPolygon(tricoord);//makes the array an ezpolygon to fill in
		
		//DRAWING THE TRIANGLE
		
		tri.draw(myGraphics, scheme[2]);//fills in the triangle
		
		//NEW TINY SQUARE
		recur(levelsDrawn+1, rightangle, topright, scheme);//repeats the function with the small side of the triangle
		
		//NEW BIG SQUARE
		recur(levelsDrawn+1, topleft, rightangle, scheme);//repeats the function with the large side of the triangle
		
	}//end recur function

}
