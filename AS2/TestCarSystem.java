// Brody Jackson
// I.D = 10152939
// CPSC-233 Assignment 2 Spring 2016

import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;

public class TestCarSystem {

  public static void main(String[] args)
  {
    //Creating the array for car objects
    Car[] carsObjectArray = new Car[12345];
    int carEntryNumber = 0;
    //loop for user input for the make, model, colour and year of the cars
    //first three times through provides constructor with parameters
    //fourth time through, car is created fist and then setters are used
    while(true)
    {
      Scanner input = new Scanner(System.in);
      //only runs this statement on final time through
      if (carEntryNumber == 3)
      {
        System.out.println("A final car was just created with default values, please enter the info to set for this car");
        Car newCar = new Car();
        carsObjectArray[3] = newCar;
      }
      //make
      System.out.println("Please enter the make of car " + (carEntryNumber+1) + " (Exp. Honda)");
      String[] carInfoArray = new String[4];
      while(true)
      {
        String carInfo = input.nextLine();
        //check if the info is valid
        if (validEntryTest(carInfo) == false)
        {
          System.out.println("Sorry, that isn't a valid entry, enter another value...");
          continue;
        }
        else
        {
          carInfoArray[0] = carInfo;
          break;
        }
      }
      //model
      System.out.println("Please enter the model of car " + (carEntryNumber+1) +  " (Exp. Civic)");
      while(true)
      {
        String carInfo = input.nextLine();
        if (validEntryTest(carInfo) == false)
        {
          System.out.println("Sorry, that isn't a valid entry, enter another value...");
          continue;
        }
        else
        {
          carInfoArray[1] = carInfo;
          break;
        }
      }
      //colour
      System.out.println("Please enter the colour of car " + (carEntryNumber+1) + " (Exp. White)");
      while(true)
      {
        String carInfo = input.nextLine();
        if (validEntryTest(carInfo) == false)
        {
          System.out.println("Sorry, that isn't a valid entry, enter another value...");
          continue;
        }
        else
        {
          carInfoArray[2] = carInfo;
          break;
        }
      }
      //year
      System.out.println("Please enter the manufacturing year of car " + (carEntryNumber+1) + " (Exp. 2015)");
      int carYearInfo;
      //check for valid integer for the year, also checks if car existed at the time
      while(true)
      {
        if(input.hasNextInt())
        {
          carYearInfo = input.nextInt();
          if ((carYearInfo > 2016)||(carYearInfo<1886))
          {
            System.out.println("It seems the car could not have existed at this date, please try again");
            continue;
          }
          else
          {
            String carInfo = String.valueOf(carYearInfo);
            carInfoArray[3] = carInfo;
            break;
          }
        }
        else
        {
          System.out.println("Please enter a valid integer value for the manufacturing year");
          input.nextLine();
          continue;
        }
      }
      if (carEntryNumber == 3)
      {
        carsObjectArray[3].setMake(carInfoArray[0]);
        carsObjectArray[3].setModel(carInfoArray[1]);
        carsObjectArray[3].setColour(carInfoArray[2]);
        carsObjectArray[3].setYear(Integer.parseInt(carInfoArray[3]));
        break;
      }
      //create the cars
      Car newCar = new Car(carInfoArray[0],carInfoArray[1],carInfoArray[2],Integer.parseInt(carInfoArray[3]));
      carsObjectArray[carEntryNumber] = newCar;
      carEntryNumber++;


    }

    //the next part is the loop to set the speeds for the first three cars
    Scanner input = new Scanner(System.in);
    for(int i = 0; i < 3; i++)
    {
      System.out.println("Please enter the speed value in KM/hour for car " + (i+1));
      while(true)
      {
        //check if it is a valid double
        if(input.hasNextDouble())
        {
          Double speedInfoDouble;
          speedInfoDouble = input.nextDouble();
          //check if the entry is higher than the car's max speed
          if(speedInfoDouble > carsObjectArray[i].getMaxSpeed())
          {
            System.out.println("Sorry, the max speed of this car is " + carsObjectArray[i].getMaxSpeed() + "KM/h, please retry...");
            continue;
          }
          //using setter to set the speed
          carsObjectArray[i].move(speedInfoDouble);
          System.out.println("Car " + (i+1) + " is now moving at " + speedInfoDouble + " KM/hour");
          break;
        }
        else
        {
          System.out.println("Please enter a valid integer value for the speed");
          input.nextLine();
          continue;
        }
      }
    }


    // use the toString method to get info for the currently active cars
    System.out.println("Here is the information for each car");
    int numberActive = 0;
    for (int i = 0; i < 4;i++)
    {
      System.out.println(carsObjectArray[i].toString());
      if (Car.activeTest(carsObjectArray[i]) == true)
      {
        numberActive++;
      }
    }
    System.out.println("there are " + numberActive + " cars that are active");

    // move the last created car at a random speed
    System.out.println("The last car you created will now move at some random speed...");
    //http://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
    Random randNum = new Random();
    int randomNumber = randNum.nextInt((200 - 0)+1);
    carsObjectArray[3].move(randomNumber);
    System.out.println("It is now moving at " + randomNumber + "KM/hour");

    // stop the first car from moving at all
    System.out.println("The first car created will now stop moving...");
    carsObjectArray[0].stop();
    System.out.println("Car successfully stopped ");

    //calculating how long a user inputed distance would take to travel for every car in hours
    System.out.println("We will now calculate how long a certain distance will take to travel for each car");
    System.out.println("Please enter a distance to travel (KM)...");
    double distance = input.nextDouble();
    DecimalFormat timeFormat = new DecimalFormat("#.00");
    for (int i = 0; i < 4;i++)
    {
      if (carsObjectArray[i].getCurrentSpeed() == 0)
      {
        System.out.println("Car " + (i+1) + " is not moving so distance time = N/A");
      }
      else
      {
        System.out.println("Car " + (i+1) + " would take " +timeFormat.format(carsObjectArray[i].calculateJourneyTime(distance)) + " hours to complete the trip");
      }
    }

    //this next bit is to see if there are equal cars, will provide their information
    System.out.println("The program is now testing to see if there are any identical cars");
    for(int i = 0; i<4;i++)
    {
      for (int y = 0; y<4;y++)
      {
        if (i == y)
        {
          continue;
        }
        if (y<i)
        {
          continue;
        }
        else if(carsObjectArray[i].equals(carsObjectArray[y]))
        {
          System.out.println("car ID: " + carsObjectArray[i].carID() + " and car ID: " + carsObjectArray[y].carID() + " are identical, here is their info:");
          System.out.println(carsObjectArray[i].identicalInfoString());
        }
      }
    }

    //THis is to force the garbage collection
    System.out.println("The program is now forcing garbage collection of the second car");
    carsObjectArray[1] = null;
    carsObjectArray[1].fullGC();
    System.out.println("Car 2 was sucessfully garbage collected");

    //determine the amount of cars that are active
    numberActive = 0;
    double totalLiveSpeed = 0;
    for(int i = 0; i<4; i++)
    {
      if (Car.activeTest(carsObjectArray[i]) == true)
      {
        numberActive++;
        totalLiveSpeed = totalLiveSpeed + carsObjectArray[i].getCurrentSpeed();
      }
      else
      {
        continue;
      }
    }
    System.out.println("There are Currently " + numberActive + " active cars ");

    //This is to make a copy of the first car
    System.out.println("the system is now creating a new car which is a copy of the first car");
    Car newCopyCar = new Car(carsObjectArray[0]);
    carsObjectArray[4] = newCopyCar;
    //set speed of the copied car to average of all cars
    carsObjectArray[4].move(totalLiveSpeed/numberActive);
    System.out.println("this copied car is moving at the average speed of all cars which is " + timeFormat.format(carsObjectArray[4].getCurrentSpeed()) + " KM/hour");


    //print all remaining car info and number of active cars
    System.out.println("The Program will now print out the final number of active cars, and their information");
    numberActive = 0;
    for(int i = 0; i<5; i++)
    {
      if (Car.activeTest(carsObjectArray[i]) == true)
      {
        numberActive++;
      }
      else
      {
        continue;
      }
    }
    System.out.println("there are " + numberActive + " cars that are active");
    System.out.println("Here is the final information for each car:");
    for (int i = 0; i < 5;i++)
    {
      if(carsObjectArray[i] == null)
      {
        continue;
      }
      else
      {
        System.out.println(carsObjectArray[i].toString());///fix the toString swapped make and model
      }
    }
  }

  //this method is used to test is the entries provided for the car info are valid
  public static boolean validEntryTest(String infoProvided)
  {
    if (infoProvided.length() == 0)
    {
      return false;
    }
    for (int i = 0; i < infoProvided.length(); i++)
    {
      if (Character.isLetter(infoProvided.charAt(i)))
      {
        return true;
      }
      else
      {
        return false;
      }
    }
    return true;
  }
}
