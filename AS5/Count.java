//Brody Jackson 10152939
//CPSC 233 Spring 2016 Assignment 5
package lab5;
//imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.swing.*;

public class Count extends Thread
{
	//variable initialization
	protected static int i = View.lowerNum;
	protected static boolean first = true;
	//when thread runs
	public void run()
	{
		//next few lines are for declaring printwriters
		File file = new File("lab5/numbers.txt");
		PrintWriter writer = null;
		try
        {
            writer = new PrintWriter(file);
        }
		catch(FileNotFoundException y)
		{

		}
		while(true)
		{
			try
			{
				//determines if we are at the end
				if(( i == View.upperNum + 1)||(i > View.upperNum + 1))
				{
					if(i< View.upperNum+1)
					{
						View.number.setText(View.number.getText() + " " + View.upperNum + 1);
						//write to textfile
						writer.print(View.upperNum + 1 + " ");
						writer.flush();
					}
					first = true;
					//pause until submit button pressed next
					suspend();
				}
				else
				{
					//skip the first entry
					if(first == true)
					{
						View.number.setText("");
					}
					//add another number
					View.number.setText(View.number.getText() + " " + String.valueOf(i));
					//print new number to output file
					if (first == true)
					{
						writer.println("\nthe range for this output is: " + View.lowerNum + " to " + View.upperNum);
					}
					//printing
					writer.print(String.valueOf(i) + " ");
					writer.flush();
					//sleep for amount determined
					Thread.sleep(View.delayTimeInt);
					i = i + View.incrementInt;
					first = false;
				}
			}
			catch(InterruptedException e)
			{

			}
		}
	}
}
