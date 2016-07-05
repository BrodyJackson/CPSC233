//Brody Jackson 10152939
//CPSC 233 Spring 2016 Assignment 5
package lab5;
//declaring imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class View extends JFrame implements ActionListener
{
	//declaring jelements that are used in multiple places and other variables
	JPanel overall = new JPanel();

	JPanel entry = new JPanel();
	JLabel message = new JLabel("<HTML><p>Please Enter the Upper and Lower Bound</p><b> <p>Then Press submit</p></HTMl>");
	JTextField lowerBound = new JTextField();
	JTextField upperBound = new JTextField();
	JTextField delayTime = new JTextField();
	JTextField increment = new JTextField();
	JButton submit = new JButton("Submit");
	JPanel counting = new JPanel();
	public static JTextArea number = new JTextArea(40,40);
	protected static int lowerNum;
	protected static int upperNum;
	protected static int delayTimeInt;
	protected static int incrementInt;
	Count count = new Count();
	protected static boolean firstTime = true;


	public static void main(String[] args)
	{
		//create view
		View view = new View();
		view.setVisible(true);
	}


	//constructor for the view, creates and adds frame elements
	public View()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,100);
		//set text area characteristics
		number.setLineWrap(true);
		number.setWrapStyleWord(true);

		overall.setLayout(new BoxLayout(overall,BoxLayout.PAGE_AXIS));
		entry = new JPanel();
		entry.setLayout(new BoxLayout(entry,BoxLayout.LINE_AXIS));


		lowerBound = new JTextField();
		lowerBound.setText("Enter the Lower Bound");

		upperBound = new JTextField();
		upperBound.setText("Enter the Upper Bound");

		delayTime = new  JTextField();
		delayTime.setText("Enter the delay time(ms)");

		increment = new JTextField();
		increment.setText("Enter the increment value");

		JButton submit = new JButton("Submit");
		submit.setName("submit");
		submit.addActionListener(this);

		//add elements
		entry.add(message);
		entry.add(lowerBound);
		entry.add(upperBound);
		entry.add(delayTime);
		entry.add(increment);
		entry.add(submit);
		overall.add(entry);
		add(overall);

	}

	//action listener, determines if submit, pause, or continue button was clicked and responds accrodingly
	public void actionPerformed(ActionEvent e)
	{
		JButton button = (JButton)e.getSource();
		if (button.getName().equals("submit"))
		{
			//parse info from text boxes
			try
			{
				number.setText("");
				if(firstTime == true )
				{
					lowerNum = Integer.parseInt(lowerBound.getText());
					upperNum = Integer.parseInt(upperBound.getText());
					delayTimeInt = Integer.parseInt(delayTime.getText());
					incrementInt = Integer.parseInt(increment.getText());
					if(lowerNum > upperNum)
					{
						message.setText("Lower # must be less than greater #");
						return;
					}
					//make new screen for numbers to be shown
					makeCountingScreen();
					//start thread
					count.start();
					firstTime = false;
					if (!message.getText().equals("<HTML><p>Please Enter the Upper and Lower Bound</p><b> <p>Then Press submit</p></HTMl>"))
					{
						message.setText("<HTML><p>Please Enter the Upper and Lower Bound</p><b> <p>Then Press submit</p></HTMl>");
					}
				}
				//to run if not first time clicking submit
				if(firstTime == false)
				{

					if (!message.getText().equals("<HTML><p>Please Enter the Upper and Lower Bound</p><b> <p>Then Press submit</p></HTMl>"))
					{
						message.setText("<HTML><p>Please Enter the Upper and Lower Bound</p><b> <p>Then Press submit</p></HTMl>");
					}
					lowerNum = Integer.parseInt(lowerBound.getText());
					upperNum = Integer.parseInt(upperBound.getText());
					delayTimeInt = Integer.parseInt(delayTime.getText());
					incrementInt = Integer.parseInt(increment.getText());
					if(lowerNum > upperNum)
					{
						message.setText("Lower # must be less than greater #");
						return;
					}
					number.setText(String.valueOf(lowerNum));
					count.i= lowerNum;
					count.resume();
				}
			}
			catch(NumberFormatException x)
			{

				message.setText("Invalid entry: please enter only integers");
			}

		}
		//pause thread
		if(button.getName().equals("pause"))
		{

			count.suspend();
		}
		//resume thread
		if(button.getName().equals("resume"))
		{
			count.resume();
		}
		//option to exit program
		if(button.getName().equals("exit"))
		{
			System.exit(0);
		}
	}


	//make the screen that shows the numbers counting
	public void makeCountingScreen()
	{
		counting.setLayout(new BoxLayout(counting,BoxLayout.LINE_AXIS));
		JPanel theNumbers = new JPanel();
		theNumbers.setLayout(new FlowLayout());

		JButton pause = new JButton("Pause");
		pause.setName("pause");
		pause.addActionListener(this);

		JButton resume = new JButton("Continue");
		resume.setName("resume");
		resume.addActionListener(this);

		JButton exit = new JButton("Exit Program");
		exit.setName("exit");
		exit.addActionListener(this);

		JScrollPane scroll = new JScrollPane(number);
		//scroll.setPreferredSize(new Dimension(500,1000));;
		theNumbers.add(scroll);

		//add elements
		counting.add(theNumbers);
		counting.add(pause);
		counting.add(resume);
		counting.add(exit);
		counting.setVisible(true);
		overall.add(counting);
		setSize(1000,500);
	}

	//the the label number
	public String getLabelNumber()
	{
		return number.getText();
	}
	//set the label number
	public void setLabelNumber(String next)
	{
		number.setText(next);
	}
}
