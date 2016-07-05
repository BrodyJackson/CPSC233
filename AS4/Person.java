/**
 *@author Brody Jackson
 *@author ID = 10152939
 */

package lab4;

public class Person 
{
	//initializes variables for a person
	private double rent; 
	private double insurance;
	private double utilities;
	private double fuel;
	private double tickets;
	private double parking;
	private double groceries;
	private double clothing;
	private double personalCare;
	private double medication;
	private double dining;
	private double vacation;
	private double income;
	private double tax;
	private double netIncomeYear; 
	private double netIncomeMonth;
	private double housingExpenses; 
	private double transportationExpenses;
	private double livingEssentialExpenses; 
	private double lifeStyleExpenses;
	private double totalExpenses; 
	private double highestExpense = 0;
	private double lowestExpense = 123456789;  
	private double savings; 
	/**
	 * default constructor
	 */
	public Person()
	{
		
	}
	/**
	 * copy Constructor
	 * @param copy takes another model as a copy
	 */
	public Person(Person copy)
	{
		this.insurance = copy.insurance; 
		this.utilities = copy.utilities;
		this.fuel = copy.fuel; 
		this.tickets = copy.tickets; 
		this.parking = copy.parking; 
		this.groceries = copy.groceries;
		this.clothing = copy.clothing;
		this.personalCare = copy.personalCare;
		this.medication = copy.medication;
		this.dining = copy.dining;
		this.vacation = copy.vacation;
		this.income = copy.income;
		this.tax = copy.tax;
		this.netIncomeYear = copy.netIncomeYear; 
		this.netIncomeMonth = copy.netIncomeMonth;
		this.housingExpenses = copy.housingExpenses; 
		this.transportationExpenses = copy.transportationExpenses;
		this.livingEssentialExpenses = copy.livingEssentialExpenses; 
		this.lifeStyleExpenses = copy.lifeStyleExpenses;
		this.totalExpenses = copy.totalExpenses; 
		this.highestExpense = copy.highestExpense;
		this.lowestExpense = copy.highestExpense;  
		this.savings = copy.savings; 
	}
	/**
	 * gets the rent
	 * @return rent for this model object
	 */
	public double getRent()
	{
		return rent; 
	}
	/**
	 * setter method for rent
	 * @param amount double
	 */
	public void setRent(double amount)
	{
		this.rent = amount;
	}
	/**
	 * gets the insurance
	 * @return insurance insurance for this model object
	 */
	public double getInsurance()
	{
		return insurance; 
	}
	/**
	 * setter method for insurance
	 * @param amount double
	 */
	public void setInsurance(double amount)
	{
		this.insurance = amount;
	}
	/**
	 * gets the utilities
	 * @return utilities utilities for this model object
	 */
	public double getUtilities()
	{
		return utilities; 
	}
	/**
	 * setter method for utilities
	 * @param amount double
	 */
	public void setUtilities(double amount)
	{
		this.utilities = amount;
	}
	/**
	 * gets the fuel
	 * @return fuel fuel for this model object
	 */
	public double getFuel()
	{
		return fuel; 
	}
	/**
	 * setter method for fuel
	 * @param amount double
	 */
	public void setFuel(double amount)
	{
		this.fuel = amount;
	}
	/**
	 * gets the tickets
	 * @return tickets tickets for this model object
	 */
	public double getTickets()
	{
		return tickets; 
	}
	/**
	 * setter method for tickets
	 * @param amount double
	 */
	public void setTickets(double amount)
	{
		this.tickets = amount;
	}
	/**
	 * gets the parking
	 * @return parking parking for this model object
	 */
	public double getParking()
	{
		return parking; 
	}
	/**
	 * setter method for parking
	 * @param amount double
	 */
	public void setParking(double amount)
	{
		this.parking = amount;
	}
	/**
	 * gets the groceries
	 * @return groceries groceries for this model object
	 */
	public double getGroceries()
	{
		return groceries; 
	}
	/**
	 * setter method for groceries
	 * @param amount double
	 */
	public void setGroceries(double amount)
	{
		this.groceries = amount;
	}
	/**
	 * gets the clothing
	 * @return clothing clothing for this model object
	 */
	public double getClothing()
	{
		return clothing; 
	}
	/**
	 * setter method for clothing
	 * @param amount double
	 */
	public void setClothing(double amount)
	{
		this.clothing = amount;
	}
	/**
	 * gets the personal care
	 * @return personalCare personal care for this model object
	 */
	public double getPersonalCare()
	{
		return personalCare; 
	}
	/**
	 * setter method for personal care
	 * @param amount double
	 */
	public void setPersonalCare(double amount)
	{
		this.personalCare = amount;
	}
	/**
	 * gets the medication
	 * @return medication medication for this model object
	 */
	public double getMedication()
	{
		return medication; 
	}
	/**
	 * setter method for medication
	 * @param amount double
	 */
	public void setMedication(double amount)
	{
		this.medication = amount;
	}
	/**
	 * gets the dining
	 * @return dining dining for this model object
	 */
	public double getDining()
	{
		return dining; 
	}
	/**
	 * setter method for dining
	 * @param amount double
	 */
	public void setDining(double amount)
	{
		this.dining = amount;
	}
	/**
	 * gets the vacation
	 * @return vacation vacation for this model object
	 */
	public double getVacation()
	{
		return vacation; 
	}
	/**
	 * setter method for vacation
	 * @param amount double
	 */
	public void setVacation(double amount)
	{
		this.vacation = amount;
	}
	/**
	 * gets the income
	 * @return income income for this model object
	 */
	public double getIncome()
	{
		return income; 
	}
	/**
	 * setter method for income
	 * @param amount double
	 */
	public void setIncome(double amount)
	{
		this.income = amount;
	}
	/**
	 * gets the tax
	 * @return tax tax for this model object
	 */
	public double getTax()
	{
		return tax; 
	}
	/**
	 * setter method for tax
	 * @param amount double
	 */
	public void setTax(double amount)
	{
		this.tax = amount;
	}
	/**
	 * gets the net income for the year
	 * @return netIncomeYear net year income for this model object
	 */
	public double getNetIncomeYear()
	{
		return netIncomeYear; 
	}
	/**
	 * gets the net income for the month
	 * @return netIncomeMonth net month income for this model object
	 */
	public double getNetIncomeMonth()
	{
		return netIncomeMonth; 
	}
	/**
	 * gets the housing expenses
	 * @return housingExpenses housing expenses for this model object
	 */
	public double getHousingExpenses()
	{
		return housingExpenses; 
	}
	/**
	 * gets the transportation expenses
	 * @return transportationExpenses transportation cost for this model object
	 */
	public double getTransportationExpenses()
	{
		return transportationExpenses; 
	}
	/**
	 * gets the living essentials 
	 * @return livingEssentialExpenses for this model object
	 */
	public double getLivingEssentialExpenses()
	{
		return livingEssentialExpenses; 
	}
	/**
	 * gets the lifestyle expenses
	 * @return lifeStyleExpenses life style costs for this model object
	 */
	public double getLifeStyleExpenses()
	{
		return lifeStyleExpenses; 
	}
	/**
	 * gets the total expenses
	 * @return totalExpenses total expenses for this model object
	 */
	public double getTotalExpenses()
	{
		return totalExpenses; 
	}
	/**
	 * gets the savings
	 * @return savings savings for this model object
	 */
	public double getSavings()
	{
		return savings; 
	}
	/**
	 * gets the highest expense
	 * @return highestExpense highest cost for this model object
	 */
	public double getHighestExpense()
	{
		return highestExpense; 
	}
	/**
	 * gets the lowest cost
	 * @return lowestExpense lowest expense for this model object
	 */
	public double getLowestExpense()
	{
		return lowestExpense; 
	}
	/**
	 * sets the values for various monthly budget expenses
	 */
	public void calculateMonthBudget()
	{ 
		housingExpenses = rent + insurance + utilities; 
		transportationExpenses = fuel + tickets + parking; 
		livingEssentialExpenses = groceries + clothing + personalCare + medication; 
		lifeStyleExpenses = dining + vacation; 
		totalExpenses = housingExpenses + transportationExpenses + livingEssentialExpenses + lifeStyleExpenses;  
	}
	/**
	 * creates string to be used after each month is submitted
	 * @return a string to be used as monthly info 
	 */
	public String toStringMonth()
	{
		String info = "<p>Here is the basic Info for just this month:</p><br>"; 
		info = info + "<p>The total expenses this month were $" + getTotalExpenses() + "</p><br>";
		info = info + "<p>This month's total Housing Expenses cost was $" + getHousingExpenses() + "</p><br>";
		info = info + "<p>This month's total Transportation cost was $" + getTransportationExpenses() + "</p><br>"; 
		info = info + "<p>This month's total Living Essentials cost was $" + getLivingEssentialExpenses() + "</p><br>"; 
		info = info + "<p>This Months lifestyle cost was $" + getLifeStyleExpenses() + "</p><br>";
		info = info + "<p> If this info looks correct, then please click 'next month' to advance to the next entry. Otherwise press 'reset'</p><br>."; 
		return ("<html>"+info+"</html>"); 
	}
	
	
	
}
