//Brody Jackscon
//10152939
//CPSC-233 Assignment3 Test.class
import java.util.Random;
public class Test
{
  public static void main(String [] args)
  {
    //the first part of this will breate 8 new vehicles of different types as per the assignment specifications, it will store them in an array of vehicles
    //then it will cast each one to its certain type for later use
    System.out.println("The program is now creating vehicles, as per the assignment specifications...");
    System.out.println("All vehicles created successfully.");
    Vehicle[] allVehicles = new Vehicle[8];
    allVehicles[0] = new Car("white", "honda", 4, 4500, 4);
    allVehicles[1] = new Car();
    allVehicles[2] = new Truck("black", "ford", 10, 2, 6000, 3);
    allVehicles[3] = new Truck();
    allVehicles[4] = new Bus(true, 2, 5500, 10);
    allVehicles[5] = new Bus();
    allVehicles[6] = new Bike(5,"plastic",1);
    allVehicles[7] = new Bike();
    Car car1 = (Car)allVehicles[0];
    Car car2 = (Car)allVehicles[1];
    Truck truck1 = (Truck)allVehicles[2];
    Truck truck2 = (Truck)allVehicles[3];
    Bus bus1 = (Bus)allVehicles[4];
    Bus bus2 = (Bus)allVehicles[5];
    Bike bike1 = (Bike)allVehicles[6];
    Bike bike2 = (Bike)allVehicles[7];

    //the next part will create 22 passengers with random names
    System.out.println("The program is now creating 22 passenger objects with random names...");
    System.out.println("all passengers successfully created.");
    Passenger[] passengerList = new Passenger[22];
    String[] possibleNames = new String[]{"Bill", "David", "Brody", "Josh", "Zach", "Colin", "Max", "Dustin", "Taylor", "Rhyan", "Brett", "Heather", "Colleen", "Ben", "Blake", "Dennis", "Pat", "Jennifer", " Warren", "Alex", "Jordan", "Cale"};
    for(int i = 0; i<22; i++)
    {
      String randomName = (possibleNames[(new Random().nextInt(possibleNames.length))]);
      passengerList[i] = new Passenger(randomName);
    }

    //the next part will promote passengers to drivers as per the assignment specifications
    System.out.println("The first seven passengers are now being promoted to drivers as per the assignment specifications...");
    System.out.println("Drivers successfully promoted.");
    for (int i = 0; i<7; i++)
    {//busses
      if(i<1)
      {
        passengerList[i].setDriverStatus(true);
        passengerList[i].updateLicenseClass(1);
      }
      //truck
      else if ((i<2)&&(i>0))
      {
        passengerList[i].setDriverStatus(true);
        passengerList[i].updateLicenseClass(1);
      }
      //bikes
      else if ((i>1)&&(i<4))
      {
        passengerList[i].setDriverStatus(true);
        passengerList[i].updateLicenseClass(5);
      }
      //cars
      else if (i>=4)
      {
        passengerList[i].setDriverStatus(true);
        passengerList[i].updateLicenseClass(5);
      }
    }

    //the next part will print the current information for every vehicle
    System.out.println("\nThe program will now print the current information for each vehicle\n");
    for(int i = 0; i<8;i++)
    {
      System.out.println("Here is the info for Vehicle " + (i+1) +":");
      System.out.println(allVehicles[i].toString());
      System.out.println("");
    }

    //the next part will print the current info for ever passenger
    System.out.println("The program will now print the current information for each passenger\n");
    for(int i = 0; i<passengerList.length; i++)
    {
      System.out.println("Here is the info for passenger " + (i+1));
      System.out.println(passengerList[i].toString());
      System.out.println("");
    }

    //The next part will add passengers to the vehicles as per assignment specifications
    System.out.println("The program will now add drivers to vehicles as per the assignment specifications...\n");
    //add passengers to bus
    System.out.println("adding driver to bus...");
    allVehicles[4].addPassenger(passengerList[0]);
    //add passenger to truck
    System.out.println("adding driver to truck...");
    allVehicles[2].addPassenger(passengerList[1]);
    //add to bike
    System.out.println("adding driver to bike...");
    allVehicles[6].addPassenger(passengerList[2]);
    //add to cars
    System.out.println("adding driver to cars 1 and 2...");
    allVehicles[0].addPassenger(passengerList[4]);
    allVehicles[1].addPassenger(passengerList[5]);
    //add last car driver to bike
    System.out.println("adding last car driver to final bike...");
    allVehicles[7].addPassenger(passengerList[6]);

    //new info for vehicles will now be printed, as well as if it can be driven or not
    System.out.println("\nThe program will now print updated info about the vehicles and if they can be driven or not\n");
    for(int i = 0; i<8;i++)
    {
      System.out.println("Here is the updated info for Vehicle " + (i+1) +":");
      System.out.println(allVehicles[i].toString());
      if (allVehicles[i].canBeDriven() == true)
      {
        System.out.println("This vehicle can currently be driven");
      }
      else if (allVehicles[i].canBeDriven() == false)
      {
        System.out.println("This vehicle cannot currently be driven");
      }
      System.out.println("");
    }


    //creating array of passengers that still haven't been added to a vehicle
    int passengerAdding = 7;
    Passenger [] possiblePassengers = new Passenger[21];
    for(int i = 7; i<21;i++)
    {
      possiblePassengers[i] = passengerList[i];
    }

    //adding all of the passengers that were not previously added, to a vehicle
    //cars will fill first, then the remaining passengers will be added until there are none left
    System.out.println("The program will now add all remaining passengers to the vehicles, starting with the cars and then filling what is left");
    System.out.println("This will occur until there are no passengers left\n");
    int currentVehicle = 0;
    int currentPassenger = 7;
    while (true)
    {
      if (allVehicles[currentVehicle].getPassengerCount() == allVehicles[currentVehicle].getMaxPassengerCount())
      {
        currentVehicle++;
        continue;
      }
      if (currentPassenger == 21)
      {
        System.out.println("We have added all the previoulsy created non-driver's to a vehicle... ");
        break;
      }
      else
      {
        while (true)
        {
          if (allVehicles[currentVehicle].getPassengerCount() == allVehicles[currentVehicle].getMaxPassengerCount())
          {
            System.out.println("This vehicle is now full, moving to next vehicle");
            currentVehicle++;
            break;
          }
          if (currentPassenger == 21)
          {
            break;
          }
          allVehicles[currentVehicle].addPassenger(possiblePassengers[currentPassenger]);
          currentPassenger++;
          String s = "passenger added to vehicle " + (currentVehicle + 1) + " Which is a ";
          s = s + allVehicles[currentVehicle].getType() + ", and currently has ";
          s = s + allVehicles[currentVehicle].getPassengerCount() + " Passengers" + ". This vehicle can hold a maximum of ";
          s = s + allVehicles[currentVehicle].getMaxPassengerCount() + " People";
          System.out.println(s);
        }
      }
    }

    //the cars will now be accelerated 10 times, and other vehicles 8 times
    System.out.println("\nThe cars will now be moved 10 times, and all other vehicles 8 times...\n");
    //now accelerating the cars
    for (int i = 0; i<10;i++)
    {
      car1.accelerate();
      car2.accelerate();
      if (i==9)
      {
        System.out.println("The car's were both just accelerated 10 times each");
      }
    }

    for(int i = 0; i<8; i++)
    {
      truck1.accelerate();
      truck2.accelerate();
      bus1.accelerate();
      bus2.accelerate();
      bike1.accelerate();
      bike2.accelerate();
      if (i==7)
      {
        System.out.println("All other vehicles were just accelerated 8 times each");
      }
    }

    System.out.println("\nThe cars will now be slowed 5 times, and all other vehicles 4 times...\n");

    //the cars will now be braked 10 times, and other vehicles 8 times
    //now braking the cars
    for (int i = 0; i<5;i++)
    {
      car1.brake();
      car2.brake();
      if (i==4)
      {
        System.out.println("The car's were both just braked 5 times each");
      }
    }

    for(int i = 0; i<4; i++)
    {
      truck1.brake();
      truck2.brake();
      bus1.brake();
      bus2.brake();
      bike1.brake();
      bike2.brake();
      if (i==3)
      {
        System.out.println("All other vehicles were just braked 4 times each");
      }
    }
    //the program will now determine and print the info for the fastes vehicle
    System.out.println("\nThe fastest vehicle will now be shown...\n");
    //find which vehicle is the fastest
    double currentFastest = 0;
    int fastestVehicle = 0;
    for (int i = 0; i < 8; i++)
    {
      if (allVehicles[i].getCurrentSpeed() > currentFastest)
      {
        currentFastest = allVehicles[i].getCurrentSpeed();
        fastestVehicle = i;
      }
    }
    String s = "The fastest vehicle was one of the " + allVehicles[fastestVehicle].getType() + "'s";
    s = s + " and is here its information: \n";
    s = s + allVehicles[fastestVehicle].toString();
    System.out.println(s);



    //the program will now determine and print the info for the slowest vehicle
    System.out.println("\nThe slowest vehicle will now be shown...\n");
    double currentSlowest = 500;
    int slowestVehicle = 0;
    for (int i = 0; i < 8; i++)
    {
      if (allVehicles[i].getCurrentSpeed() < currentSlowest)
      {
        currentSlowest = allVehicles[i].getCurrentSpeed();
        slowestVehicle = i;
      }
    }
    String x = "The slowest vehicle was one of the " + allVehicles[slowestVehicle].getType() + "'s";
    if (allVehicles[slowestVehicle].getType().equals("Bike"))
    {
      x = x + " moving at " + currentSlowest + " km/h";
    }
    x = x + " and is here its information: \n";
    x = x + allVehicles[slowestVehicle].toString();
    System.out.println(x);


    //The program will now determine if a car object cannot be driven, then delete that object
    System.out.println("\nThe program will now delete vehicles that cannot be driven....\n");
    //delete all that cant be driven
    for(int i = 0; i<8;i++)
    {
      if (allVehicles[i].canBeDriven() == true)
      {
        continue;
      }
      else if (allVehicles[i].canBeDriven() == false)
      {
        System.out.println("Vehicle " + (i+1) + " which is a " + allVehicles[i].getType() + " cannot be driven, and has therefore been deleted");
        allVehicles[i] = null;
      }
      System.out.println("");
    }

    //the next part is reponsible for printing the final info for all vehicles and passengers
    //it will also tell you what type of vehicle that passenger is riding in
    System.out.println("The final information for every vehicle and passenger will now be printed...\n");
    for(int i = 0; i<8;i++)
    {
      if (allVehicles[i] == null)
      {
        continue;
      }
      System.out.println("Here is the final info for vehicle " + (i+1) +":");
      System.out.println(allVehicles[i].toString());
      if (allVehicles[i].canBeDriven() == true)
      {
        System.out.println("This vehicle can currently be driven");
      }
      else if (allVehicles[i].canBeDriven() == false)
      {
        System.out.println("This vehicle cannot currently be driven");
      }
      System.out.println("");
    }

    for(int i = 0; i<passengerList.length; i++)
    {
      System.out.println("Here is the info for passenger " + (i+1));
      System.out.println(passengerList[i].toString());
      if(passengerList[i].getWhatVehicleIn() != "none")
      {
        System.out.println("This passenger is riding in a " + passengerList[i].getWhatVehicleIn());
      }
      else
      {
        System.out.println("This passenger is not riding in a vehicle");
      }
      System.out.println("");
    }
  }
}
