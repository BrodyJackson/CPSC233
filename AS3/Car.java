/**
*@author Brody Jackson
*@author 10152939
*/
class Car extends PoweredVehicle
{
  //variable initialization for the cars
  private String colour;
  private String model;
  /**
  *car constructor that requires parameters
  *@param colour must be String which is the colour of the car
  *@param model must be String which is the model of the car
  *@param doornumber must be integer which is the number of doors
  *@param enginePower must be double which is the engine power
  *@param maxNumberPassengers must be int which is the max number of passengers
  */
  public Car(String colour, String model, int doorNumber, double enginePower, int maxNumberPassengers)
  {
    setNumberWheels(4);
    setPassengerCount(0);
    setMaxPassengerCount(maxNumberPassengers);
    setColour(colour);
    setModel(model);
    setDoorNumber(doorNumber);
    setEnginePower(enginePower);
    setSpeed(0);
    setPassengerArray(123);
  }
  /**
  *constructor that does not require parameters, sets car characteristics to a default value
  */
  public Car()
  {
    this("red","ford",4,2200,2);
    setNumberWheels(4);
    setPassengerCount(0);
    setPassengerArray(123);
  }

  /**
  *setter method for colour
  *@param colour must be string which is the car colour
  */
  public void setColour(String colour)
  {
    this.colour = colour;
  }
  /**
  *setter method for model
  *@param model must be String which is the model
  */
  public void setModel(String model)
  {
    this.model = model;
  }
  /**
  *gets the colour
  *@return colour
  */
  public String getColour()
  {
    return this.colour;
  }
  /**
  *gets the model
  *@return model
  */
  public String getModel()
  {
    return this.model;
  }
  /**
  *test to see if car can be driven
  *@return true/false if the car can be driven or not
  */
  public boolean canBeDriven()
  {
    if (this.getNumWheels() <= 4)
    {
      for (int i = 0 ; i < this.getMaxPassengerCount(); i++)
      {
        if ((getPassenger(i).getLicenseClass() == 1) || (getPassenger(i).getLicenseClass() == 5))
        {
          return true;
        }
      }
    }
    return false;
  }
  /**
  *accelerate this vehicle
  */
  public void accelerate()
  {
    setSpeed( getCurrentSpeed() + ((getEnginePower() / 1000)*getNumWheels()));
  }
  /**
  *brake this vehicle
  */
  public void brake()
  {
    setSpeed( getCurrentSpeed() - ((getEnginePower() / 1000)*getNumWheels()));
  }
  /**
  *gets what type of vehicle this is
  *@return a certain vehicle type
  */
  public String getType()
  {
    return "Car";
  }
  /**
  *turns information about this vehicle into a string
  *@return a string of information
  */
  public String toString()
  {
    if (this.getClass().equals(Car.class))
    {
      String s = "This is a " + colour + " Car, the model is " + model + "\n" + super.toString();
      return s;
    }
    else
    {
      String s = super.toString();
      return s;
    }
  }
}
