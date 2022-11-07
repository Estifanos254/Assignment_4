/*
 * Class: CMSC203 
 * Instructor: Professor Grigoriy Grinberg
 * Description: (the first class, Management company has constant variables
          instance and variable arrays,and methods from the add property to the toString which returns
          the values of all the properties in this class)
 * Due: 10/24/2022
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Estifanos  Kebebew__________
*/
public class ManagementCompany{
	  final int MAX_PROPERTY = 5;
	  private int MGMT_DEPTH = 10;
	  private int MGMT_WIDTH = 10;
	  private String name;
	private String taxID;
	private double mgmFee;
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties = 0;
	private double RATE = 0.1;

	  public ManagementCompany() {
		this.name = "";
		  this.taxID = "";
		  this.mgmFee = 0;
		  this.properties = new Property[MAX_PROPERTY];
		  this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		  this.numberOfProperties = 0;
	  }

	  public ManagementCompany(String name, String taxID, double mgmFee) {
	    this.name = name;
	    this.taxID = taxID;
	    this.mgmFee = mgmFee;
		  this.properties = new Property[MAX_PROPERTY];
		  this.plot = new Plot(0,0, MGMT_WIDTH, MGMT_DEPTH);
		  this.numberOfProperties = 0;
	  }

	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(x, y, width, depth);
		this.numberOfProperties = 0;
	}

	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFee = otherCompany.mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(otherCompany.plot);
		this.numberOfProperties = otherCompany.numberOfProperties;

		for (int i = 0; i < numberOfProperties; i++) this.properties[i] = otherCompany.properties[i];
	}

	public String getName()
	{
		return name;
	}

	public String getTaxID()
	{
		return taxID;
	}

	public Plot getPlot()
	{
		return plot;
	}

	public Property[] getProperties()
	{
		return properties;
	}

	public int addProperty(Property property) {
		if (numberOfProperties == MAX_PROPERTY) return -1;

		if (property == null) return -2;

		if (!plot.encompasses(property.getPlot())) return -3;

		for (int i = 0; i < numberOfProperties; i++)
		{
			Property property2 = properties[i];

			if (property.getPlot().overlaps(property2.getPlot())) return -4;
		}

		int result = numberOfProperties;
		properties[numberOfProperties] = new Property(property);
		numberOfProperties++;
		return result;
	 }
	 
	 /**
	  * A method that adds the property with four arguments  and a default plot to the array.
	  * 
	  * @param name
	  * @param city
	  * @param rent
	  * @param owner
	  * @return
	  */
	  public int addProperty(String name, String city, double rent, String owner) {
		  Property property = new Property(name, city, rent, owner);
		  return addProperty(property);
	  }
	  
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		return addProperty(property);
	}
    // This method accesses each "Property" object within the properties array, 
	//sums up the property rent and returns the total amount.
	  public double getTotalRent() {
	    double total = 0;

	    for (int i = 0; i < numberOfProperties; i++) {
			total += properties[i].getRentAmount();
	    }

	    return total;
	  }
	  //Returns the number of existing properties in the array
	  public int getPropertiesCount()
	  {
		  return numberOfProperties;
	  }
       /*
        * Returns the Property object with the highest rent amount within the properties array.
        */
	  public Property getHighestRentPropperty()
	  {
		  int index = -1;
		  double max = 0;

		  for (int i = 0; i < numberOfProperties; i++)
		  {
			  Property property = properties[i];
			  double amount = property.getRentAmount();

			  if (amount > max)
			  {
				  max = amount;
				  index = i;
			  }
		  }

		  return index != -1 ? properties[index] : null;
	  }

	  public double getMgmFeePer()
	  {
		  return mgmFee;
	  }

   /*
    *  Checks if the management company has a valid (between 0-100) fee
    */
	public boolean isMangementFeeValid()
	{
		return mgmFee >= 0 && mgmFee <= 100;
	}
	
    //Checks if the properties array has reached the maximum capacity
	public boolean isPropertiesFull()
	{
		return numberOfProperties == MAX_PROPERTY;
	}
    // Removes the LAST property in the properties array
	public void removeLastProperty()
	{
		if (numberOfProperties != 0)
		{
			numberOfProperties--;
			properties[numberOfProperties] = null;
		}
	}
    //   Returns information of ALL the properties within this management company by accessing
	// the "Properties" array
	public String toString() {
		String result =
			"List of the properties for " + name + ", taxID:" + taxID + "\n" +
			"__________________________________________________\n";

		for (int i = 0; i < numberOfProperties; i++)
		{
			Property property = properties[i];
			result += property.getPropertyName() + ", " + property.getCity()
			+ ", " + property.getOwner()+ ", " + property.getRentAmount() + "\n";
		}

		result += "___________________________________________________\n" +
			"Total management Fee: "+ RATE*getTotalRent();
		
		return result;
	  }

}
