/**
*@author Brody Jackson
*@author 10152939
*/
public class Passenger
{
  //initialization of passenger variables
  private String name;
  private boolean driver;
  private int licenseClass;
  private String inVehicle;
  /**
  *constructor for passenger
  *@param name must be string that is the passengers name
  */
  public Passenger(String name)
  {
    this.name = name;
    this.driver = false;  //defaults to passenger and not driver
    this.licenseClass = -1;
    this.inVehicle = "none";
  }
  /**
  *setter method for driver status
  *@param driver must be a boolean that is the new status
  */
  public void setDriverStatus(boolean driver)
  {
    this.driver = driver;
  }
  /**
  *gets the driver status
  *@return the driver status
  */
  public boolean getDriverStatus()
  {
    return this.driver;
  }
  /**
  *setter method for license class
  *@param licenseClass must be int that is the new license class
  */
  public void updateLicenseClass(int licenseClass)
  {
    this.licenseClass = licenseClass;
  }
  /**
  *gets the driver name
  *@return the driver name
  */
  public String getName()
  {
    return this.name;
  }
  /**
  *gets the driver license class
  *@return the license class
  */
  public int getLicenseClass()
  {
    return this.licenseClass;
  }
  /**
  *setter method for what vehicle the passenger is in
  *@param vehicle must be string of what vehicle it is in
  */
  public void setInVehicle(String vehicle)
  {
    this.inVehicle = vehicle;
  }
  /**
  *gets the vehicle that this passenger is in
  *@return the vehicle
  */
  public String getWhatVehicleIn()
  {
    return this.inVehicle;
  }
  /**
  *turns information about this person into a string
  *@return a string of information for passenger
  */
  public String toString()
  {
    String p = "";
    p = p + "The passengers name is: " + this.getName() + "\n";
    if (this.getLicenseClass() > -1)
    {
      p = p + "This person's licence class is " + this.getLicenseClass();
    }
    else if (this.getLicenseClass() == -1)
    {
      p = p + "This person does not have a valid licence class";
    }
    if (this.driver == true)
    {
      p = p + ", and he/she is a driver";
    }
    else
    {
      p = p + ", and he/she is not a driver";
    }

    return p;
  }
}
