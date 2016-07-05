/**
*@author Brody Jackson
*@author 10152939
*/

public class Bus extends PoweredVehicle
{
  //variable initialization for bus's
  private boolean accessabilitySeats;
  /**
  *bus constructor that requires parameters
  *@param accessabilitySeats must be boolean which is if there are seats or not
  *@param doorNumber must be integer which is the number of doors
  *@param enginePower must be double which is the engine power
  *@param maxNumberPassengers must be int which is the max number of passengers
  */
  public Bus(boolean accessabilitySeats, int doorNumber, double enginePower, int maxNumberPassengers)
  {
    setAccessabilitySeats(accessabilitySeats);
    setDoorNumber(doorNumber);
    setEnginePower(enginePower);
    setMaxPassengerCount(maxNumberPassengers);
    setSpeed(0);
    setPassengerArray(123);
    setNumberWheels(4);
  }
  /**
  *constructor that does not require parameters, sets bus characteristics to a default value
  */
  public Bus()
  {
    this(true, 4, 4500, 2);
    setSpeed(0);
    setPassengerArray(123);
    setNumberWheels(4);
  }
  /**
  *setter method for accessability seats
  *@param available must be string which is if there are seats available
  */
  public void setAccessabilitySeats(boolean available)
  {
    this.accessabilitySeats = available;
  }
  /**
  *gets if there are accessability seats
  *@return true/false
  */
  public boolean getAccessabilitySeats()
  {
    return this.accessabilitySeats;
  }
  /**
  *test to see if bus can be driven
  *@return true/false if the bus can be driven or not
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
    setSpeed( getCurrentSpeed() + ((getEnginePower() / 1100)*getNumWheels()));
  }
  /**
  *brake this vehicle
  */
  public void brake()
  {
    setSpeed( getCurrentSpeed() - ((getEnginePower() / 1100)*getNumWheels()));
  }
  /**
  *gets what type of vehicle this is
  *@return a certain vehicle type
  */
  public String getType()
  {
    return "Bus";
  }
  /**
  *turns information about this vehicle into a string
  *@return a string of information
  */
  public String toString()
  {
    String s ="This is a Bus, and it is " + accessabilitySeats + " That there are accessability seats " + "\n" + super.toString();
    return s;
  }
}
