/**
*@author Brody Jackson
*@author 10152939
*/
public abstract class Vehicle
{
  //variable initialization for vehicles
  private int numberOfWheels;
  private int passengerCount;
  private int maxNumberPassengers;
  private double currentSpeed;
  private Passenger [] passengers;

  /**
  *setter method for max passenger count
  *@param max must be an integer which is the max # passengers
  */
  public void setMaxPassengerCount(int max)
  {
    this.maxNumberPassengers = max;
  }
  /**
  *gets the max passenger count
  *@return the max # of passengers
  */
  public int getMaxPassengerCount()
  {
    return this.maxNumberPassengers;
  }
  /**
  *adds passengers to vehicles
  *@param addThis needs a passenger to add to a certain vehicle
  *@return if adding was sucessfull or not
  */
  public boolean addPassenger(Passenger addThis)
  {
    for(int i = 0;i< this.maxNumberPassengers; i++)
    {
      if (this.passengers[i] == null)
      {
        addThis.setInVehicle(this.getType());
        this.passengers[i] = addThis;
        this.passengerCount++;
        return true;
      }
      else if (i == (this.maxNumberPassengers - 1))
      {
        System.out.println("Vehicle full");
        return false;
      }
    }
    return false;
  }
  /**
  *removes passengers from vehicles
  *@param removeThis needs a passenger to remove from a certain vehicle
  */
  public void removePassenger(Passenger removeThis)
  {
    boolean removed = false;
    for(int i = 0; i< this.maxNumberPassengers;i++)
    {
      if(this.passengers[i]==removeThis)
      {
        this.passengers[i] = null;
        System.out.println("sucessfully removed");
        removed = true;
        break;
      }
    if(removed == false)
    {
      System.out.println("This passenger was not on the vehicle");
    }
    }
  }
  /**
  *gets the current passenger count
  *@return the current # of passengers
  */
  public int getPassengerCount()
  {
    return this.passengerCount;
  }
  /**
  *setter method for number of wheels
  *@param wheels must be an integer which is the number of wheels
  */
  public void setNumberWheels(int wheels)
  {
    this.numberOfWheels = wheels;
  }
  /**
  *gets if there is a driver in the vehicle or not
  *@return the driver Passenger object
  */
  public Passenger getDriver()
  {
    boolean driverFound = false;
    for(int i = 0; i<this.maxNumberPassengers;i++)
    {
      if(this.passengers[i].getDriverStatus() == true)
      {
        driverFound = true;
        return this.passengers[i];
      }
    }
    if (driverFound = false)
    {
      System.out.print("no driver found");
    }
    return null;
  }
  /**
  *gets the number of wheels
  *@return the number of wheels
  */
  public int getNumWheels()
  {
    return this.numberOfWheels;
  }
  /**
  *gets the current speed
  *@return the current speed
  */
  public double getCurrentSpeed()
  {
    return this.currentSpeed;
  }
  /**
  *setter method for the passenger count
  *@param passengerCount which is an integer
  */
  public void setPassengerCount(int passengerCount)
  {
    this.passengerCount = passengerCount;
  }
  /**
  *setter method for this vehicles speed
  *@param speed must be an integer which is the speed
  */
  public void setSpeed(double speed)
  {
    this.currentSpeed = speed;
  }
  /**
  *setter method for size of passenger array
  *@param size which must be an integer representing size of passenger array
  */
  public void setPassengerArray(int size)
  {
    this.passengers = new Passenger[size];
  }
  /**
  *gets a certain passenger from the passenger array for this vehicle
  *@return a certain passenger object
  *@param passengerIndex int value which indicates the passenger you want
  */
  public Passenger getPassenger(int passengerIndex)
  {
    return this.passengers[passengerIndex];
  }
  /**
  *see Subclasses
  */
  public abstract void accelerate();
  /**
  *see Subclasses
  */
  public abstract void brake();
  /**
  *see Subclasses
  */
  public abstract boolean canBeDriven();
  /**
  *gets what type of vehicle this is
  *@return a certain vehicle type
  */
  public String getType()
  {
    return "Vehicle";
  }
  /**
  *turns information about this vehicle into a string
  *@return a string of information
  */
  public String toString()
  {
    String s = "";
    s = s + "This Vehicle has " + numberOfWheels + " Wheels ";
    s = s + "and " + passengerCount + " current passengers ";
    s = s + ", The maximum number of passengers is " + maxNumberPassengers;
    s = s + " And the current speed is " + currentSpeed + "Km/h\n";
    return s;
  }
}
