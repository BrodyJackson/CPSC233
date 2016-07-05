// Brody jackson
// 10152939
// CPSC-233 Spring 2016 Assignment1


//the next two lines allow for user input and math functions used later on
import java.util.Scanner;
import java.lang.Math;


class Salaries{
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);
    //the next few lines are where I initialize the variables used in the program
    double salaryInput = 0;
    int salary = 0;
    int entryNumber = 0;
    double totalSalary = 0;
    double averageSalary = 0;
    double highestSalary = 0;
    double lowestSalary = 0;
    int internDev = 0;
    int juniorDev = 0;
    int dev = 0;
    int srDev = 0;
    int plDev = 0;
    int technicalLead = 0;
    double positionHierarchy = 0;
    String endStatement = "";
    boolean validInitials = false;
    //This is the loop that is controlled by a sentinel of blank initials or -1 or less as a salary
    while(true){
      //prompt for initials and check for blank initials
      System.out.println("Please enter a software developers initials");
      String initials = keyboard.nextLine();
      if (initials.length() == 0){
        break;
      }
      //This is to check if the initials contain at least one letter
      for(int i = 0; i < initials.length(); i++){
        if (Character.isLetter(initials.charAt(i))){
          validInitials = true;
        }
      }
      //will reprompt if the initials do not contain at least one letter
      if(validInitials == false){
        System.out.println("A developers initials must contain at least one letter, please try again");
        continue;
      }

      //promt for salary
      System.out.println("Please enter this employees salary as a number");
      //loop used to determine if the user input is actually a valid number, if not it will reprompt until it recieves valid number
      while(true){
        if(keyboard.hasNextDouble()){
          salaryInput = keyboard.nextDouble();
          salary = (int)(salaryInput);
          break;
        }else{
          System.out.println("Please enter a valid salary");
          keyboard.nextLine();
          continue;
        }
      }
      //sentinel for breaking out of loop
      if (salary <= -1){
        break;
      }
      keyboard.nextLine();
      //used to determine the highest salary
      if (salary > highestSalary){
        highestSalary = salary;
      }
      //used for beggining lowest salary
      if (lowestSalary == 0){
        lowestSalary = salary;
      }
      //used to determine the lowest salary
      else if (salary < lowestSalary){
        lowestSalary = salary;
      }
      //determine how many intern developers
      if (salary < 50000){
        internDev = internDev + 1;
        positionHierarchy = positionHierarchy + 1;
      }
      //determine how many juniordevs
      if (50000 <= salary && salary <= 59999){
        juniorDev = juniorDev + 1;
        positionHierarchy = positionHierarchy + 2;
      }
      //Determine how many developers
      if (60000 <= salary && salary <= 74999){
        dev = dev + 1;
        positionHierarchy = positionHierarchy + 3;

      }
      //determine how many senior developers
      if (75000 <= salary && salary <= 94999){
        srDev = srDev + 1;
        positionHierarchy = positionHierarchy + 4;

      }
      //determine how many project lead developers
      if (95000 <= salary && salary <= 109999){
        plDev = plDev + 1;
        positionHierarchy = positionHierarchy + 5;

      }
      //determine how many project leads
      if (salary >= 110000){
        technicalLead = technicalLead + 1;
        positionHierarchy = positionHierarchy + 6;

      }
      //this wil print out the initials and salary after each entry
      System.out.println(initials + " earns $" + salary);
      //makes a string of the initials and salary for this iteration to be saved in the total intitials and salary string
      String personInfo = (initials + " earns $" + salary);
      //total number of entries
      entryNumber = entryNumber + 1;
      //total amount of money paid
      totalSalary = totalSalary + salary;
      //average salary
      averageSalary = totalSalary / entryNumber;
      //This will continuouslly update all the initials and salary's to be printed at the end as one big string
      endStatement = endStatement + personInfo + "\n";

    }
    //the next line rounds the position hierarchy to the nearest average position level
    double averagePosition = Math.round(positionHierarchy / entryNumber);
    String averagePositionString = "";
    //the next few statements determine which is the average position level that people in the company hold
    if (averagePosition == 1){
      averagePositionString = "Intern Developer";
    }
    else if (averagePosition == 2){
      averagePositionString = "Junior Developer";
    }
    else if (averagePosition == 3){
      averagePositionString = "Developer";
    }
    else if (averagePosition == 4){
      averagePositionString = "Senior Developer";
    }
    else if (averagePosition == 5){
      averagePositionString = "Project lead developer";
    }
    else if (averagePosition == 6){
      averagePositionString = "Technical Leader";
    }
    System.out.println("sentinel detected, info for the values entered will be provided below: " + "\n");
    //print all initials and names
    System.out.println(endStatement);
    //print how many people were paid
    System.out.println("The total number of salary's paid was: " + entryNumber);
    //print total amount of money paid
    System.out.println("The total amount of salary paid to employees was: $" + totalSalary);
    //print highest salary
    System.out.println("The Highest Salary is: $" + highestSalary);
    //print lowest salary
    System.out.println("The Lowest Salary is: $" + lowestSalary);
    //print average salary
    System.out.println("The Average Salary is: $" + averageSalary);
    //the next few lines are used to print how many people are in various positions based on salary
    System.out.println("There are: " + internDev + " Internship Developers");
    System.out.println("There are: " + juniorDev + " Junior Developers");
    System.out.println("There are: " + dev + " Developers");
    System.out.println("There are: " + srDev + " Senior Developers");
    System.out.println("There are: " + plDev + " Project Lead Developers");
    System.out.println("There are: " + technicalLead + " Technical Leads");
    //print the average position that people hold based on salary
    System.out.println("The average position is based on salary is: " + averagePositionString);

  }
}
