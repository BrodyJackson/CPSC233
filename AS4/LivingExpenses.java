/**
 *@author Brody Jackson
 *@author ID = 10152939
 */

package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LivingExpenses extends JFrame
{
	//variable initialization for the various components
	private JTextField [] numberInput = new JTextField[14];
	private JLabel welcome;
	private JLabel label;
	private JButton submit;
	private JButton reset;
	private JPanel message;
	private JPanel center;
	private JPanel numbers;
	private JPanel bottom;
	private JPanel buttons;
	private JButton nextButton = new JButton("Next");
	private JButton goBackButton = new JButton("Go Back");
	private JPanel endMessage;
	private JPanel incomeAndTax;
	private JButton done = new JButton("Done");

	/**
	 * constructor that does not require parameters, this is responsible for creating the initial gui view
	 */
	public LivingExpenses()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,300);
		setLayout(new BorderLayout());
		//make various panels
		message = new JPanel();
		message.setLayout(new BorderLayout());
		message.setBackground(Color.PINK);

		center = new JPanel();
		center.setLayout(new BorderLayout());
		center.setBackground(Color.ORANGE);

		numbers = new JPanel();
		numbers.setLayout(new GridLayout(1,5));
		numbers.setBackground(Color.WHITE);

		bottom = new JPanel();
		bottom.setLayout(new BorderLayout());

		buttons = new JPanel();
		buttons.setLayout(new GridLayout(1,3));
		buttons.setBackground(Color.PINK);

		JPanel housingExpenses = new JPanel();
		housingExpenses.setLayout(new GridLayout(4,1));

		JPanel transportation = new JPanel();
		transportation.setLayout(new GridLayout(4,1));

		JPanel living = new JPanel();
		living.setLayout(new GridLayout(5,1));

		JPanel lifestyle = new JPanel();
		lifestyle.setLayout(new GridLayout(3,1));

		incomeAndTax = new JPanel();
		incomeAndTax.setLayout(new GridLayout(3,1));

		welcome = new JLabel("Please enter a value Integer value in EVERY box below for month 1");
		welcome.setFont(new Font("Calibri", Font.PLAIN, 18));
		welcome.setHorizontalAlignment(JLabel.CENTER);
		message.add(welcome, BorderLayout.CENTER);

		submit = new JButton("Submit");
		submit.setName("submit");
		reset = new JButton("Reset");
		reset.setName("reset");


		//add the different types of expenses panels to the center panel
		numbers.add(housingExpenses);
		numbers.add(transportation);
		numbers.add(living);
		numbers.add(lifestyle);
		numbers.add(incomeAndTax);

		//add submit reset and previous to the bottom
		buttons.add(submit);
		buttons.add(reset);


		bottom.add(buttons);

		center.add(numbers);

		add(message,BorderLayout.NORTH);
		add(center,BorderLayout.CENTER);
		add(bottom,BorderLayout.SOUTH);
		//creates the text fields and labels
		label = new JLabel("Housing Expenses");
		label.setHorizontalAlignment(JLabel.CENTER);
		housingExpenses.add(label, BorderLayout.CENTER);

		numberInput[0] = new JTextField("Enter Housing Expenses",20);
		numberInput[0].setBackground(Color.WHITE);
		housingExpenses.add(numberInput[0]);

		numberInput[1] = new JTextField("Enter Insurance Expenses",20);
		numberInput[1].setBackground(Color.WHITE);
		housingExpenses.add(numberInput[1]);

		numberInput[2] = new JTextField("Enter Utilitie Expenses",20);
		numberInput[2].setBackground(Color.WHITE);
		housingExpenses.add(numberInput[2]);

		label = new JLabel("Transportation costs");
		label.setHorizontalAlignment(JLabel.CENTER);
		transportation.add(label, BorderLayout.CENTER);

		numberInput[3] = new JTextField("Enter Fuel Costs",20);
		numberInput[3].setBackground(Color.WHITE);
		transportation.add(numberInput[3]);

		numberInput[4] = new JTextField("Enter Ticket fees",20);
		numberInput[4].setBackground(Color.WHITE);
		transportation.add(numberInput[4]);

		numberInput[5] = new JTextField("Enter Parking fees",20);
		numberInput[5].setBackground(Color.WHITE);
		transportation.add(numberInput[5]);

		label = new JLabel("Living costs");
		label.setHorizontalAlignment(JLabel.CENTER);
		living.add(label, BorderLayout.CENTER);

		numberInput[6] = new JTextField("Enter Grocerie Costs",20);
		numberInput[6].setBackground(Color.WHITE);
		living.add(numberInput[6]);

		numberInput[7] = new JTextField("Enter Clothing Costs",20);
		numberInput[7].setBackground(Color.WHITE);
		living.add(numberInput[7]);

		numberInput[8] = new JTextField("Enter Personal Care Costs",20);
		numberInput[8].setBackground(Color.WHITE);
		living.add(numberInput[8]);

		numberInput[9] = new JTextField("Enter Medication Costs",20);
		numberInput[9].setBackground(Color.WHITE);
		living.add(numberInput[9]);

		label = new JLabel("lifestyle costs");
		label.setHorizontalAlignment(JLabel.CENTER);
		lifestyle.add(label, BorderLayout.CENTER);

		numberInput[10] = new JTextField("Enter Dining Out Costs",20);
		numberInput[10].setBackground(Color.WHITE);
		lifestyle.add(numberInput[10]);

		numberInput[11] = new JTextField("Enter Vacation Costs",20);
		numberInput[11].setBackground(Color.WHITE);
		lifestyle.add(numberInput[11]);

		label = new JLabel("Income");
		label.setHorizontalAlignment(JLabel.CENTER);
		incomeAndTax.add(label, BorderLayout.CENTER);

		numberInput[12] = new JTextField("Enter Income before tax",20);
		numberInput[12].setBackground(Color.WHITE);
		incomeAndTax.add(numberInput[12]);

		numberInput[13] = new JTextField("Enter Tax Percentage i.e (0.4)",20);
		numberInput[13].setBackground(Color.WHITE);
		incomeAndTax.add(numberInput[13]);
	}
	/**
	 * method for adding an action listener from the driver class to certain button components
	 * @param listener must be a type ActionListener from the Driver class
	 */
	public void setEventListener(ActionListener listener)
	{
		submit.addActionListener(listener);
		reset.addActionListener(listener);
		nextButton.addActionListener(listener);
		goBackButton.addActionListener(listener);

	}
	/**
	 * responsible for getting the values entered
	 * @return the array of all the numbers entered into the text fields
	 */
	public String[] getFieldInputs()
	{
		String[] fieldInputs = new String[14];
		for(int i = 0; i<14; i++)
		{
			fieldInputs[i] = numberInput[i].getText();
		}
		return fieldInputs;
	}
	/**
	 * makes a new panel with certain specifications
	 * @param text the message that you want the panel to display
	 * @param type what type of panel we are creating, depending on button pushed
	 */
	public void makePanel(String text,String type)
	{
		message.setVisible(false);
		center.setVisible(false);
		numbers.setVisible(false);
		bottom.setVisible(false);
		buttons.setVisible(false);
		endMessage = new JPanel(new BorderLayout());
		JLabel endText = new JLabel(text);
		endText.setHorizontalAlignment(JLabel.CENTER);
		if(type.equals("error"))
		{
			goBackButton.setName("goBack");
			endMessage.add(endText,BorderLayout.CENTER);
			endMessage.add(goBackButton,BorderLayout.SOUTH);
			add(endMessage,BorderLayout.CENTER);
		}
		else
		{
			nextButton.setName("next");
			endMessage.add(endText,BorderLayout.CENTER);
			endMessage.add(nextButton,BorderLayout.SOUTH);
			add(endMessage,BorderLayout.CENTER);
		}
	}
	/**
	 * refreshes the main panel when you advance to the next month
	 * @param type to tell if we are refreshing with the salary and tax still present or not
	 */
	public void refreshMainPanel(String type)
	{
		welcome.setText("Please enter a value Integer value in EVERY box below for month " + Driver.getMonth());
		message.setVisible(true);
		center.setVisible(true);
		numbers.setVisible(true);
		bottom.setVisible(true);
		buttons.setVisible(true);
		endMessage.setVisible(false);
		if (type.equals("null"))
		{
			incomeAndTax.remove(numberInput[12]);
			incomeAndTax.remove(numberInput[13]);
			incomeAndTax.remove(label);
		}
	}
	/**
	 * resets all the messages of the input fields
	 * @param text the text that you want the input field to say
	 * @param index which input field you are changing
	 */
	public void setInputText(String text, int index)
	{
		numberInput[index].setText(text);
	}
	/**
	 * creates a gui panel that shows the summary information, also presents a done button that will close the program on click
	 * @param totalInfo takes the array of info for all the months entered so far
	 */
	public void makeFinalScreen(Person[] totalInfo)
	{
		message.setVisible(false);
		center.setVisible(false);
		numbers.setVisible(false);
		bottom.setVisible(false);
		buttons.setVisible(false);
		endMessage.setVisible(false);
		JPanel finalScreen = new JPanel();
		finalScreen.setLayout(new BoxLayout(finalScreen,BoxLayout.PAGE_AXIS));
		finalScreen.setBackground(Color.WHITE);

		JPanel finalMonthInfo = new JPanel();
		JPanel finalInfo = new JPanel();

		finalMonthInfo.setLayout(new BoxLayout(finalMonthInfo,BoxLayout.LINE_AXIS));
		finalInfo.setLayout(new BoxLayout(finalInfo,BoxLayout.Y_AXIS));
		double mostExpensive = 0;
		double leastExpensive = 1234567;
		int expensiveMonth = 0;
		int cheapMonth = 0;
		//diplay info for each month
		for(int i=1; i<5; i++)
		{
			if (totalInfo[i].getTotalExpenses() > mostExpensive)
			{
				mostExpensive = totalInfo[i].getTotalExpenses();
				expensiveMonth = i;
			}
			if (totalInfo[i].getTotalExpenses() < leastExpensive)
			{
				leastExpensive = totalInfo[i].getTotalExpenses();
				cheapMonth = i;
			}
			finalMonthInfo.add(makeFinalMonthLabels(totalInfo,i));
			finalMonthInfo.add(Box.createHorizontalStrut(45));
		}
		JLabel message = new JLabel("Here is the final info");
		message.setAlignmentX(Component.CENTER_ALIGNMENT);
		message.add(Box.createVerticalStrut(100));
		message.setFont(new Font("calibri", Font.PLAIN, 20));
		double tot = totalInfo[1].getTotalExpenses() + totalInfo[2].getTotalExpenses() + totalInfo[3].getTotalExpenses() + totalInfo[4].getTotalExpenses();
		double overallSalary = ((totalInfo[1].getIncome()*4) - ((totalInfo[1].getIncome()*4)*totalInfo[1].getTax()));
		JLabel salary = new JLabel("The total salary earned after tax was: $" + (overallSalary));
		salary.setAlignmentX(Component.CENTER_ALIGNMENT);
		//labels
		JLabel monthSalary = new JLabel("This meant there was $" + (overallSalary /4) + " to spend per month");
		monthSalary.setAlignmentX(Component.CENTER_ALIGNMENT);


		JLabel totalCosts = new JLabel("The Total cost was: $" + tot );
		totalCosts.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel savings = new JLabel("After the total expenses there was: $" + (overallSalary - tot) + " In savings");
		savings.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel expensive = new JLabel("The most expensive month was: month " + expensiveMonth + " Which cost $" + mostExpensive);
		expensive.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel cheap = new JLabel("The least expensive month was: month " + cheapMonth + " Which cost $" + leastExpensive);
		cheap.setAlignmentX(Component.CENTER_ALIGNMENT);

		done.setName("done");
		done.addActionListener(new ActionListener()
		{
	           public void actionPerformed(ActionEvent e)
	           {
	        	  System.exit(0);
	           }
		});
		done.setAlignmentX(Component.CENTER_ALIGNMENT);
		//adding to the final panel
		finalInfo.add(salary);
		finalInfo.add(monthSalary);
		finalInfo.add(totalCosts);
		finalInfo.add(savings);
		finalInfo.add(expensive);
		finalInfo.add(cheap);
		finalScreen.add(message);
		finalScreen.add(finalMonthInfo);
		finalScreen.add(finalInfo);
		finalScreen.add(done);
		add(finalScreen);
		setSize(1200,500);
		finalScreen.setVisible(true);
	}
	/**
	 * makes the final info summary for each month, to be used on the final summary panel
	 * @param totalInfo the array of info for each month
	 * @param index which month we are referring to
	 * @return a JLabel for the final screen
	 */
	public JLabel makeFinalMonthLabels(Person[] totalInfo, int index)
	{
		String info = "<p align=center>Month" + index + "</p><br>";
		info = info + "<p>Total Housing Expenses: $" + totalInfo[index].getHousingExpenses() + "</p><br>";
		info = info + "<p>Total Transportation Expenses: $" + totalInfo[index].getTransportationExpenses() + "</p><br>";
		info = info + "<p>Total Living Essential Expenses: $" + totalInfo[index].getLivingEssentialExpenses() + "</p><br>";
		info = info + "<p>Total Life Style Expenses: $" + totalInfo[index].getLifeStyleExpenses() + "</p><br>";
		info = info + "<p>The Total Cost of the month was: $" + totalInfo[index].getTotalExpenses() + "</p><br>";
		JLabel head = new JLabel("<html>"+info+"</html>");
		return head;
	}
}
