/**
*@author Brody Jackson
*@author 10152939
*/
abstract class PoweredVehicle extends Vehicle
{
  private int doorNumber;
  private double enginePower;
  /**
  *setter method for door number
  *@param number must be an integer which is the door number
  */
  public void setDoorNumber(int number)
  {
    this.doorNumber = number;
  }
  /**
  *setter method for engine power
  *@param power must be an integer which is the engine power
  */
  public void setEnginePower(double power)
  {
    this.enginePower = power;
  }
  /**
  *gets the door number
  *@return the door number
  */
  public int getDoorNumber()
  {
    return this.doorNumber;
  }
  /**
  *gets the engine power
  *@return engine power
  */
  public double getEnginePower()
  {
    return this.enginePower;
  }
  /**
  *turns information about this vehicle into a string
  *@return a string of information
  */
  public String toString()
  {
    String s = super.toString();
    s = s + "This Vehicle is powered, with " + doorNumber + " doors" + " and has " + enginePower + " horsepower";
    return s;
  }
}
