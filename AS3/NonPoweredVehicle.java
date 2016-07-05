/**
*@author Brody Jackson
*@author 10152939
*/
abstract class NonPoweredVehicle extends Vehicle
{
  //initialize non powered vehicle variables
  private double weight;
  /**
  *setter method for vehicle weight
  *@param weight must be a double that is the new weight
  */
  public void setWeight(double weight)
  {
    this.weight = weight;
  }
  /**
  *gets the weight
  *@return the weight
  */
  public double getWeight()
  {
    return this.weight;
  }
  /**
  *turns information about this non powered vehicle into a string
  *@return a string of information
  */
  public String toString()
  {
    String s = "this vehicle is not powered and weights " + weight +" pounds";
    return s;
  }
}
