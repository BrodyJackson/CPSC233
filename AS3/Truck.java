/**
*@author Brody Jackson
*@author 10152939
*/

public class Truck extends Car
{
  //variable initialization for the trucks
  private double size;
  /**
  *truck constructor that requires parameters
  *@param colour must be String which is the colour of the truck
  *@param model must be String which is the model of the truck
  *@param size must be double which is the size of the truck
  *@param doorNumber must be integer which is the number of doors
  *@param enginePower must be double which is the engine power
  *@param maxNumberPassengers must be int which is the max number of passengers
  */
  public Truck(String colour, String model, double size, int doorNumber, double enginePower, int maxNumberPassengers)
  {
    super(colour, model, doorNumber, enginePower, maxNumberPassengers);
    setSize(size);
  }
  /**
  *constructor that does not require parameters, sets truck characteristics to a default value
  */
  public Truck()
  {
    super();
    setSize(13);
    setDoorNumber(4);
    setEnginePower(5000);
    setMaxPassengerCount(2);
  }
  /**
  *setter method for size
  *@param size must be double which is the size
  */
  public void setSize (double size)
  {
    this.size = size;
  }
  /**
  *gets the size
  *@return size
  */
  public double getSize()
  {
    return this.size;
  }
  /**
  *test to see if truck can be driven
  *@return true/false if the truck can be driven or not
  */
  public boolean canBeDriven()//make sure to add a check to see if the speed is already 0 !!
  {
    if (this.getPassengerCount() == 0)
    {
      return false;
    }
    for (int i = 0 ; i < this.getMaxPassengerCount(); i++)
    {
      if ((getPassenger(i).getLicenseClass() == 1))
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
    setSpeed( getCurrentSpeed() + ((getEnginePower() / 1200)*getNumWheels()));
  }
  /**
  *brake this vehicle
  */
  public void brake()
  {
    setSpeed( getCurrentSpeed() - ((getEnginePower() / 1200)*getNumWheels()));
  }
  /**
  *gets what type of vehicle this is
  *@return a certain vehicle type
  */
  public String getType()
  {
    return "Truck";
  }
  /**
  *turns information about this vehicle into a string
  *@return a string of information
  */
  public String toString()
  {
    String s ="This is a " + this.getColour() + " Truck, the model is " + this.getModel() + " and the size is " + size + "Square Meters" + "\n" + super.toString();
    return s;
  }
}
