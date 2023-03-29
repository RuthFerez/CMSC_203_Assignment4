public class Plot {

	private int x;
	private int y;
	private int width;
	private int depth;
	
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}
	
	public Plot(Plot p) {
		this.x = p.getX();
		this.y = p.getY();
		this.width = p.getWidth();
		this.depth = p.getDepth();
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public boolean overlaps(Plot plot) {
		int LeftX = x;
		int RightX = x + width;
		int TopY = y;
		int BottomY = y + depth;
		
		int otherLeftX = plot.getX();
		int otherRightX = plot.getX() + plot.getWidth();
		int otherTopY = plot.getY();
		int otherBottomY = plot.getY() + plot.getDepth();
		
		boolean topLeft1 = false, topRight1 = false, bottomLeft1 = false, bottomRight1 = false, topLeft2 = false, topRight2 = false, bottomLeft2 = false, bottomRight2 = false;
		boolean encompass1 = false, encompass2 = false;
		boolean halfInside1 = false, halfInside2 = false;
		
		
		if((LeftX > otherLeftX && LeftX < otherRightX) && (TopY > otherTopY && TopY < otherBottomY))
			topLeft1 = true;
		
	
		if((RightX > otherLeftX && RightX < otherRightX) && (TopY > otherTopY && TopY < otherBottomY))
			topRight1 = true;
		
		
		if((LeftX > otherLeftX && LeftX < otherRightX) && (BottomY > otherTopY && BottomY < otherBottomY))
			bottomLeft1 = true;
		
		
		if((RightX > otherLeftX && RightX < otherRightX) && (BottomY > otherTopY && BottomY < otherBottomY))
			bottomRight1 = true;
		
		
		if((otherLeftX > LeftX && otherLeftX < RightX) && (otherTopY > TopY && otherTopY < BottomY))
			topLeft2 = true;
		
		
		if((otherRightX > LeftX && otherRightX < RightX) && (otherTopY > TopY && otherTopY < BottomY))
			topRight2 = true;
		
		
		if((otherLeftX > LeftX && otherLeftX < RightX) && (otherBottomY > TopY && otherBottomY < BottomY))
			bottomLeft2 = true;
		
		
		if((otherRightX > LeftX && otherRightX < RightX) && (otherBottomY > TopY && otherBottomY < BottomY))
			bottomRight2 = true;
		
		
		if(this.encompasses(plot))
			encompass1 = true;
		
		
		if(plot.encompasses(this))
			encompass2 = true;
		
		
		if((TopY == otherTopY && BottomY == otherBottomY) && ((LeftX > otherLeftX && LeftX < otherRightX) || (RightX > otherLeftX && RightX < otherRightX)))
			halfInside1 = true;
		
		
		if((LeftX == otherLeftX && RightX == otherRightX) &&((TopY > otherTopY && TopY < otherBottomY) || (BottomY > otherTopY && BottomY < otherBottomY)))
			halfInside2 = true;
		
		return topLeft1 || topRight1 || bottomLeft1 || bottomRight1 || topLeft2 || topRight2 || bottomLeft2 || bottomRight2 || encompass1 || encompass2 || halfInside1 || halfInside2;
	}
	
	
	public boolean encompasses(Plot plot) {
		int LeftX = x;
		int RightX = x + width;
		int TopY = y;
		int BottomY = y + depth;
		
		int otherLeftX = plot.getX();
		int otherRightX = plot.getX() + plot.getWidth();
		int otherTopY = plot.getY();
		int otherBottomY = plot.getY() + plot.getDepth();
		
		return (LeftX <= otherLeftX) && (RightX >= otherRightX) && (TopY <= otherTopY) && (BottomY >= otherBottomY);
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public String toString() {
		return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
	}
	
}

