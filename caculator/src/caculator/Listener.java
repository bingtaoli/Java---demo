package caculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/* ¼àÌý°´Å¥ÊÂ¼þ */
public class Listener implements ActionListener 
{
	public JTextField text;
	public Listener(JTextField text)
	{
		this.text = text;
	}
	public boolean again = false;
	public void actionPerformed(ActionEvent event)
	{
		String e = event.getActionCommand();
		String ts = text.getText();
		if (e.equals("C"))
		{
			text.setText("0");
			again = true;
		}
		else if (e.charAt(0) >= '0' && e.charAt(0) <= '9')
		{
			if (again == true)
			{
				text.setText(e);
				again = false;
			}
			else 
			{
				if (ts.equals("0"))
				{
					text.setText(e);
				}
				else
				{
					text.setText(ts+e);
				}
			}
		}
		else if (e.equals("+") || e.equals("-") || e.equals("*") || e.equals("/"))
		{
			text.setText(ts+e);
		}
		else if (e.equals("="))
		{
			ReForNumber reNumber= new ReForNumber();		
			String[] normal = reNumber.toStringArray(ts);
			String[] polish = new Polish(normal).transform();
			System.out.println(polish[1]);
			int result = new Caculate().caculate(polish);
			text.setText(Integer.toString(result));
			again = true;
		}		
	}
}