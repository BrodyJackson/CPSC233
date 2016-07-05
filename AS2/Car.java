/**
*@author Brody Jackson
*@author ID = 10152939
*/
public class Car
{
  //variable initialization for the cars
  private static int ID = 0;
  private static int totalIDs = 0;
  private double maxSpeed;
  private String colour;
  private int year;
  private String make;
  private String model;
  private double currentSpeed;
  private int carID;
  private boolean activeInstance = false;

  /**
  * constructor that does not require parameters, sets the car characterics to default values
  */
  public Car()
  {
    setMake("none");
    setModel("none");
    setColour("none");
    setYear(0);
    this.maxSpeed = 200;
    this.currentSpeed = 0;
    ID++;
    carID = ID;
    totalIDs++;
    activeInstance = true;
  }
  /**
  *constructor that requires parameters
  *@param make must be a string which is the make of the car (EXP.Honda)
  *@param model must be a string which is the model of the car (EXP.Civic)
  *@param colour must be a string which is the colour of the car (EXP.White)
  *@param year must be an integer which is the manufacturing year, must be at a time when cars existed
  */

  public Car(String make,String model,String colour,int year)
  {
    setMake(make);
    setModel(model);
    setColour(colour);
    setYear(year);
    this.maxSpeed = 200;
    this.currentSpeed = 0;
    ID++;
    carID = ID;
    totalIDs++;
    activeInstance = true;
  }
  /**
  *Copy Constructor
  *@param copyCar must be another car object which will be duplicated
  */
  public Car(Car copyCar)
  {
    setMake(copyCar.make);
    setModel(copyCar.model);
    setColour(copyCar.colour);
    setYear(copyCar.year);
    this.maxSpeed = 200;
    this.currentSpeed = 0;
    ID++;
    carID = totalIDs + 1;
    totalIDs++;
    activeInstance = true;
  }
  /**
  *setter method for make
  *@param make needs a string of make to set for the car
  */
  public void setMake(String make)
  {
    this.make = make;
  }
  /**
  *setter method for model
  *@param model needs a string of the model to set for the car
  */
  public void setModel(String model)
  {
    this.model = model;
  }
  /**
  *setter method for colour
  *@param colour needs a string of the colour to set for the car
  */
  public void setColour(String colour)
  {
    this.colour = colour;
  }
  /**
  *setter method for year
  *@param year needs a integer of the year to set for the car
  */
  public void setYear(int year)
  {
    this.year = year;
  }
  /**
  * gets the make of the car
  *@return the make of the car object
  */
  public String getMake()
  {
    return this.make;
  }
  /**
  *gets the model of the car
  *@return the model of the car object
  */
  public String getModel()
  {
    return this.model;
  }
  /**
  *gets the colour of the car
  *@return the colour of the car object
  */
  public String getColour()
  {
    return this.colour;
  }
  /**
  *gets the manufacturing year of the car
  *@return the manufacturing year of the car object
  */
  public int getYear()
  {
    return this.year;
  }
  /**
  *gets the current speed of the car
  *@return the current speed of the car object
  */
  public double getCurrentSpeed()
  {
    return this.currentSpeed;
  }
  /**
  *gets the max speed of the car
  *@return the max speed of the car object
  */
  public double getMaxSpeed()
  {
    return this.maxSpeed;
  }
  /**
  *Method to set the current speed of the car
  *@param speed Takes a speed value to set as the current speed
  */
  public void move(double speed)
  {
    if (speed <= maxSpeed)
    {
      this.currentSpeed = speed;
    }
    else
    {
      this.currentSpeed = maxSpeed;
    }
  }
  /**
  *method to set current speed of car to 0
  */
  public void stop()
  {
    this.currentSpeed = 0;
  }
  /**
  *Method to see how long journey will take in hours
  *@param distanceToTravel an integer which represents how many KM the user wants to travel
  *@return the amount of time in hours needed to make the journey
  */
  public double calculateJourneyTime(double distanceToTravel)
  {
    if (currentSpeed == 0)
    {
      return -1;
    }
    else
    {
      return distanceToTravel / this.currentSpeed;
    }
  }
  /**
  *To string method for printing the information for each car
  *@return the info of the car in a string
  */
  public String toString()
  {
    String info = new String();
    info = "" + "For car ID: " + this.carID();
    info = info + " The make is: " + this.getMake();
    info = info + " The model is: " + this.getModel();
    info = info + " The colour is: " + this.getColour();
    info = info + " The manufacturing year is: " + this.getYear() + ",";
    info = info + " And this car is moving at " + this.getCurrentSpeed() + " KM/H";
    return info;

  }
  /**
  *get method to return the carID
  *@return the ID for this car
  */
  public int carID()
  {
    return this.carID;
  }
  /**
  *method to test if a car is active or not
  *@param isThisActive needs a car as a paremeter to test
  *@return either true or false if car is active
  */
  public static boolean activeTest(Car isThisActive)
  {
    if((isThisActive != null) && (isThisActive.activeInstance = true))
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  /**
  *method to test if one car equals another
  *@param testThisCar needs a car passed to determine if it is equal to any other cars
  *@return true or false depending on if it equals other cars
  */
  public boolean equals(Car testThisCar)
  {
    if ((this.make.equals(testThisCar.make)) && (this.model.equals(testThisCar.model)) && (this.colour.equals(testThisCar.colour)) && (this.year==testThisCar.year))
    {
      return true;
    }
    else
    {
      return false;
    }


  }
  /**
  *get string with info of identical cars
  *@return the string of info for the cars that are identical
  */
  public String identicalInfoString()
  {
    String identicalInfo = new String();
    identicalInfo = "" + " The make is: " + this.getMake();
    identicalInfo = identicalInfo + " The model is: " + this.getModel();
    identicalInfo = identicalInfo + " The colour is: " + this.getColour();
    identicalInfo = identicalInfo + " The manufacturing year is: " + this.getYear();
    return identicalInfo;
  }

  /**
  *method to force garbage collection
  */
  public static void fullGC()
  {
    Runtime rt = Runtime.getRuntime();
    long isFree = rt.freeMemory();
    long wasFree;
    do
    {
      wasFree = isFree;
      rt.runFinalization();
      rt.gc();
      isFree = rt.freeMemory();
    }while(isFree>wasFree);
  }
  /**
  *method for garbage collection
  */
  protected void finalize() throws Throwable
  {
    super.finalize();
    ID--;
  }
}
