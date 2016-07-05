/**
*@author Brody Jackson
*@author 10152939
*/

public class Bike extends NonPoweredVehicle
{
  private double weight;
  private String frameMaterial;
  /**
  *constructor that requires parameters
  *@param weight must be a double that is the bike weight
  *@param frameMaterial must be a string that is the material it is made of
  *@param maxNumberPassengers must be an int that is the max riders
  */
  public Bike(double weight, String frameMaterial, int maxNumberPassengers)
  {
    setWeight(weight);
    setFrameMaterial(frameMaterial);
    setPassengerArray(1);
    setMaxPassengerCount(maxNumberPassengers);
  }
  /**
  *constructor that does not require parameters, sets the bike to default values
  */
  public Bike()
  {
    this(20,"steel",1);
    setPassengerArray(1);
  }
  /**
  *setter method for the frame material
  *@param material which is a string
  */
  public void setFrameMaterial(String material)
  {
    this.frameMaterial = material;
  }
  /**
  *gets the frame material
  *@return the frame material
  */
  public String getFrameMaterial()
  {
    return this.frameMaterial;
  }
  /**
  *test to see if bike can be driven
  *@return true/false if the bike can be driven or not
  */
  public boolean canBeDriven()//make sure to add a check to see if the speed is already 0 !!
  {
    for (int i = 0 ; i < this.getMaxPassengerCount(); i++)
    {
      if ((getPassenger(i).getLicenseClass() != -1))
      {
        return true;
      }
    }
    return false;
  }
  /**
  *accelerate this vehicle
  */
  public void accelerate()
  {
    setSpeed(getCurrentSpeed()+ 5);
  }
  /**
  *brake this vehicle
  */
  public void brake()
  {
    setSpeed(getCurrentSpeed()- 5);
  }
  /**
  *gets what type of vehicle this is
  *@return a certain vehicle type
  */
  public String getType()
  {
    return "Bike";
  }
  /**
  *turns information about this bike into a string
  *@return a string of information
  */
  public String toString()
  {
    String s = "This is a bike with a " + frameMaterial + " frame\n" + super.toString();
    return s;
  }

}
