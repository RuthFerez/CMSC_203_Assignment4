public class Property {

	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	public Property() {
		this.owner = "";
		this.city = "";
		this.propertyName = "";
		this.rentAmount = 0.0;
		this.plot = new Plot();
	}
	
	public Property(Property p){
		 
		 class Plot {

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
					
					//check if top left corner of this is overlapping new plot
					if((LeftX > otherLeftX && LeftX < otherRightX) && (TopY > otherTopY && TopY < otherBottomY))
						topLeft1 = true;
					
					//check if top right corner of this is overlapping new plot
					if((RightX > otherLeftX && RightX < otherRightX) && (TopY > otherTopY && TopY < otherBottomY))
						topRight1 = true;
					
					//check if bottom left corner of this is overlapping new plot
					if((LeftX > otherLeftX && LeftX < otherRightX) && (BottomY > otherTopY && BottomY < otherBottomY))
						bottomLeft1 = true;
					
					//check if bottom right corner of this is overlapping new plot
					if((RightX > otherLeftX && RightX < otherRightX) && (BottomY > otherTopY && BottomY < otherBottomY))
						bottomRight1 = true;
					
					//check if top left corner of new plot is overlapping this
					if((otherLeftX > LeftX && otherLeftX < RightX) && (otherTopY > TopY && otherTopY < BottomY))
						topLeft2 = true;
					
					//check if top right corner of new plot is overlapping this
					if((otherRightX > LeftX && otherRightX < RightX) && (otherTopY > TopY && otherTopY < BottomY))
						topRight2 = true;
					
					//check if bottom left corner of new plot is overlapping this
					if((otherLeftX > LeftX && otherLeftX < RightX) && (otherBottomY > TopY && otherBottomY < BottomY))
						bottomLeft2 = true;
					
					//check if bottom right corner of new plot is overlapping this
					if((otherRightX > LeftX && otherRightX < RightX) && (otherBottomY > TopY && otherBottomY < BottomY))
						bottomRight2 = true;
					
					//check if this encompasses new plot
					if(this.encompasses(plot))
						encompass1 = true;
					
					//check if new plot encompasses this
					if(plot.encompasses(this))
						encompass2 = true;
					
					//Check if neither are encompassed, but the left or right line is inside
					if((TopY == otherTopY && BottomY == otherBottomY) && ((LeftX > otherLeftX && LeftX < otherRightX) || (RightX > otherLeftX && RightX < otherRightX)))
						halfInside1 = true;
					
					//Check if neither are encompassed, but the top or bottom line is inside
					if((LeftX == otherLeftX && RightX == otherRightX) &&((TopY > otherTopY && TopY < otherBottomY) || (BottomY > otherTopY && BottomY < otherBottomY)))
						halfInside2 = true;
					
					return topLeft1 || topRight1 || bottomLeft1 || bottomRight1 || topLeft2 || topRight2 || bottomLeft2 || bottomRight2 || encompass1 || encompass2 || halfInside1 || halfInside2;
				}
				
				//takes a Plot instance and determines if the current plot contains it.
				public boolean encompasses(Plot plot) {
					int myLeftX = x;
					int myRightX = x + width;
					int myTopY = y;
					int myBottomY = y + depth;
					
					int otherLeftX = plot.getX();
					int otherRightX = plot.getX() + plot.getWidth();
					int otherTopY = plot.getY();
					int otherBottomY = plot.getY() + plot.getDepth();
					
					return (myLeftX <= otherLeftX) && (myRightX >= otherRightX) && (myTopY <= otherTopY) && (myBottomY >= otherBottomY);
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
		this.owner = p.getOwner();
		this.city = p.getCity();
		this.propertyName = p.getPropertyName();
		this.rentAmount = p.getRentAmount();
		this.setPlot(p.getPlot().getX(), p.getPlot().getY(), p.getPlot().getWidth(), p.getPlot().getDepth());
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.setPlot(0, 0, 1, 1);
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.setPlot(x, y, width, depth);
	}
	
	public Plot getPlot() {
		return plot;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public double getRentAmount() {
		return rentAmount;
	}
	
	public void setPlot(int x, int y, int width, int depth) {
		plot = new Plot(x, y, width, depth);
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	public String toString() {
		return "Property Name: " + propertyName +  "\nLocated in " + city + "\nBleonging to: " + owner + "\nRent Amount: " + rentAmount;
	}
}
