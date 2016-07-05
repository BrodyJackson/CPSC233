/**
 *@author Brody Jackson
 *@author ID = 10152939
 */
package lab4;

import java.awt.event.*;
import javax.swing.JButton;


public class Driver implements ActionListener
{
	// initialization of gui view, and person(which is the model). Also initializes other variables
	private LivingExpenses view;
	private Person person;
	private boolean finished;
	private static int month = 1;
	private double yearIncome;
	private double fixedTax;
	private Person [] totalInfo = new Person[5];
	/**
	 * constructor that takes a view and model
	 * @param view the gui to be associated
	 * @param person the model class to be associated
	 */
	public Driver(LivingExpenses view, Person person)
	{
		this.view= view;
		this.person  = person;
		view.setEventListener((ActionListener)this);
	}
	/**
	 * main function, creates view and model, sets visible to true
	 * @param args arguments
	 */
	public static void main(String[] args)
	{
		LivingExpenses view = new LivingExpenses();
		Person person = new Person();
		Driver thisDriver = new Driver(view,person);
		view.setVisible(true);

	}

	/**
	 * action Listener class that listens for events from the view class handles them different ways depending on type
	 */
	public void actionPerformed(ActionEvent e)
	{
		JButton button = (JButton)e.getSource();
		if (month > 4)
		{
			view.makeFinalScreen(totalInfo);
		}
		//defines actions for submit info buttons
		else if (button.getName().equals("submit"))
		{
			String[] initialInputs = view.getFieldInputs();
			double[] parsedInputs = new double[14];
			for(int i = 0; i<14; i++)
			{
				try
				{
					if ((month != 1) &&((i == 12 )||(i == 13)))
					{
						continue;
					}
					else
					{
						parsedInputs[i] = Double.parseDouble(initialInputs[i]);
						if(((parsedInputs[13] > 1.0)||(parsedInputs[i] < 0.0)))
						{
							view.makePanel("The tax value must be between 0 and 1. Please try again, and ensure that you are entering valid numbers","error");;
							return;
						}
					}
				}
				catch(NumberFormatException x)
				{
					view.makePanel("It Appears that you have some sort of error in the values entered. Please try again, and ensure that you are entering valid numbers","error");;
					return;
				}
			}
			//parse the numbers in the text fields
			person.setRent(parsedInputs[0]);
			person.setInsurance(parsedInputs[1]);
			person.setUtilities(parsedInputs[2]);
			person.setFuel(parsedInputs[3]);
			person.setTickets(parsedInputs[4]);
			person.setParking(parsedInputs[5]);
			person.setGroceries(parsedInputs[6]);
			person.setClothing(parsedInputs[7]);
			person.setPersonalCare(parsedInputs[8]);
			person.setMedication(parsedInputs[9]);
			person.setDining(parsedInputs[10]);
			person.setVacation(parsedInputs[11]);
			if(month == 1)
			{
				person.setIncome(parsedInputs[12]);
				person.setTax(parsedInputs[13]);
				yearIncome = parsedInputs[12];
				fixedTax = parsedInputs[13];
			}
			else
			{
				person.setIncome(yearIncome);
				person.setTax(fixedTax);
			}
			person.calculateMonthBudget();

			view.makePanel(person.toStringMonth(),"null");
			totalInfo[month] = new Person(person);
			month++;

		}
		//define actions for reset button
		else if(button.getName().equals("reset"))
		{
			reset();
		}
		//define actions for next button or goBack button
		else if(button.getName().equals("next")||button.getName().equals("goBack"))
		{
			if (button.getName().equals("goBack") && (month == 1))
			{
				view.refreshMainPanel("month1");
				reset();
			}
			else
			{
				view.refreshMainPanel("null");
				reset();
			}
		}
	}

	/**
	 * method that is responsible for reseting the text fields of the view
	 */
	public void reset()
	{
		view.setInputText("Enter Housing Expenses",0);
		view.setInputText("Enter Insurance Expenses",1);
		view.setInputText("Enter Utilitie Expenses",2);
		view.setInputText("Enter Fuel Costs",3);
		view.setInputText("Enter Ticket fees",4);
		view.setInputText("Enter Parking fees",5);
		view.setInputText("Enter Grocerie Costs",6);
		view.setInputText("Enter Clothing Costs",7);
		view.setInputText("Enter Personal Care Costs",8);
		view.setInputText("Enter Medication Costs",9);
		view.setInputText("Enter Dining Out Costs",10);
		view.setInputText("Enter Vacation Costs",11);
		view.setInputText("Enter Income before tax",12);
		view.setInputText("Enter Tax Percentage i.e (0.4)",13);
	}
	/**
	 * returns the month that we are currently on
	 * @return the months that we are currently working on
	 */
	public static int getMonth()
	{
		return month;
	}








}
