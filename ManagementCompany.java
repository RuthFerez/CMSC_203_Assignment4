public class ManagementCompany {

	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private double mgmFeePer;
	private String name;
	private String taxID;
	private Property[] properties;
	
	private Plot plot;
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		mgmFeePer = 0.0;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.getName();
		this.taxID = otherCompany.getTaxID();
		this.mgmFeePer = otherCompany.getMgmFeePer();
		this.properties = otherCompany.getProperties();
	}
	
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	
	public String getName() {
		return name;
	}
	
	public double getMgmFeePer() {
		return mgmFeePer;
	}
	
	public Property[] getProperties() {
		return properties;
	}
	
	public String getTaxID() {
		return taxID;
	}
	
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	
	
	public Plot getPlot() {
		return plot;
	}
	
	public void setPlot(Plot p) {
		this.plot = new Plot(p);
	}
	
	public void setPlot() {
		this.plot = new Plot();
	}
	
	
	
	public void setPlot(int x, int y, int width, int depth) {
		this.plot = new Plot(x, y, width, depth);
	}
	
	public int addProperty(Property property) {
		
		boolean Full = true;
		boolean overlap = false;
		int firstNull = -1;
		
		
		for(int x = 0; x < MAX_PROPERTY; x++) {
			if(properties[x] == null) {
				Full = false;
				firstNull = x;
				x = MAX_PROPERTY;
			}
			else if(properties[x].getPlot().overlaps(property.getPlot())) {
				overlap = true;
				x = MAX_PROPERTY;
			}
		}
		
		if(Full)
			return -1;
		else if(property.getCity() == null)
			return -2;
		else if(!plot.encompasses(property.getPlot()))
			return -3;
		else if(overlap)
			return -4;
		else {
			properties[firstNull] = property;
			return firstNull;
		}
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		//adds a property to the array and/or returns an int with what happened
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		
		boolean Full = true;
		boolean overlap = false;
		int firstNull = -1;
		
		
		for(int i = 0; i < MAX_PROPERTY; i++) {
			if(properties[i] == null) {
				Full = false;
				firstNull = i;
				i = MAX_PROPERTY;
			}
			else if(properties[i].getPlot().overlaps(property.getPlot())) {
				overlap = true;
			}
		}
		
		if(Full)
			return -1;
		else if(property.getCity() == null)
			return -2;
		else if(!plot.encompasses(property.getPlot()))
			return -3;
		else if(overlap)
			return -4;
		else {
			properties[firstNull] = property;
			return firstNull;
		}
	}

	public int addProperty(String name, String city, double rent, String owner) {
		//adds a property to the array and/or returns an int with what happened
		Property property = new Property(name, city, rent, owner);
		
		boolean Full = true;
		boolean overlap = false;
		int firstNull = -1;
		
		
		for(int x = 0; x < MAX_PROPERTY; x++) {
			if(properties[x] == null) {
				Full = false;
				firstNull = x;
				x = MAX_PROPERTY;
			}
			else if(properties[x].getPlot().overlaps(property.getPlot())) {
				overlap = true;
				x = MAX_PROPERTY;
			}
		}
		
		if(Full)
			return -1;
		else if(property.getCity() == null)
			return -2;
		else if(!plot.encompasses(property.getPlot()))
			return -3;
		else if(overlap)
			return -4;
		else {
			properties[firstNull] = property;
			return firstNull; }
	}
	
	
	public String displayPropertyAtIndex(int i) {
		return properties[i].toString();}
	
	private int maxRentPropertyIndex() {
		int index = -1;
		double temp = 0.0;
		for(int x = 0; x < properties.length; x++) {
			if(properties[x] == null)
				continue;
			else if(properties[x].getRentAmount() > temp) {
				temp = properties[x].getRentAmount();
				index = x;
			}
		}
		return index;}
	
	
	public double maxRentProp() {
		int maxIndex = maxRentPropertyIndex();
		return properties[maxIndex].getRentAmount();}
	
	
	public double totalRent() {
		
		double total = 0.0;
		for(int x = 0; x < properties.length; x++) {
			if(properties[x] == null)
				continue;
			total += properties[x].getRentAmount();
		}
		return total;}
	
	public String toString() {
		String output = "List of the properties for " + name + ", taxID: " + taxID +"\n";
		for(int x = 0; x < 55; x++) {
			output += "_";
		}
		output += "\n";
		for(int y = 0; y < properties.length; y++) {
			output += properties[y].toString();
			output += "\n";
		}
		for(int z = 0; z < 55; z++) {
			output += "_";
		}
		output += "\nTotal Management Fee: " + (this.totalRent() * mgmFeePer);
		return output;}
	}
