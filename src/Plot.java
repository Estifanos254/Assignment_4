/*
 * Class: CMSC203 21754
 * Instructor: Professor Grigoriy Grinberg
 * Description: (this class contains attributes of instance variables x and y, and methods that consist of
constructors, setters/ getters, and the overlap method that
   determines if it is overlapped by the current plot. )
 * Due: 10/24/2022
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Estifanos  Kebebew__________
*/
public class Plot
{
	private int x;
	private int y;
	private int width;
	private int depth;

	public Plot()
	{
		this(0, 0, 1, 1);
	}

	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	public Plot(Plot otherPlot)
	{
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getDepth()
	{
		return depth;
	}

	public void setDepth(int depth)
	{
		this.depth = depth;
	}
  // takes a Plot instance and determines if the current plot contains it
	public boolean encompasses(Plot plot)
	{
		int x = this.x;
		int y = this.y;
		int x2 = x + this.width;
		int y2 = y + this.depth;
		int X = plot.x;
		int Y = plot.y;
		int X2 = X + plot.width;
		int Y2 = Y + plot.depth;

		// x = "["; x2 = "]"; X = "("; X2 = ")"
		boolean encompassesX = x <= X && x2 >= X2; // [ ( ) ]
		boolean encompassesY = y <= Y && y2 >= Y2; // [ ( ) ]

		return encompassesX && encompassesY;
	}
   // determines Plot instance and determines if it is overlapped by the current plot. 
	public boolean overlaps(Plot plot)
	{
		int x = this.x;
		int y = this.y;
		int x2 = x + this.width;
		int y2 = y + this.depth;
		int X = plot.x;
		int Y = plot.y;
		int X2 = X + plot.width;
		int Y2 = Y + plot.depth;

		// x = "["; x2 = "]"; X = "("; X2 = ")"
		boolean overlapX0 = x <= X && x2 >= X2; // [ ( ) ]
		boolean overlapX1 = x <= X && x2 > X; // [ ( ] )
		boolean overlapX2 = x < X2 && x2 >= X2; // ( [ ) ]
		boolean overlapX3 = x >= X && x2 <= X2; // ( [ ] )

		boolean overlapY0 = y <= Y && y2 >= Y2; // [ ( ) ]
		boolean overlapY1 = y <= Y && y2 > Y; // [ ( ] )
		boolean overlapY2 = y < Y2 && y2 >= Y2; // ( [ ) ]
		boolean overlapY3 = y >= Y && y2 <= Y2; // ( [ ] )

		return (overlapX0 || overlapX1 || overlapX2 || overlapX3) && (overlapY0 || overlapY1 || overlapY2 || overlapY3);
	}

	@Override
	public String toString()
	{
		return "" + x + "," + y + "," + width + "," + depth;
	}
}

