package caculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* ÖÐ×º×ªÄæ²¨À¼ */
public class Polish 
{
	private String[] testString = null;
	private Stack<String> stack = null;
	public List<String> po = new ArrayList<>() ;
	public Polish(String[] testString) 
	{
		// TODO Auto-generated constructor stub
		this.testString = testString;
		this.stack = new Stack<String>();
	}
	public String[] transform()
	{
		for(int i=0; i<testString.length; i++)
		{
			String c = testString[i];
			if(c.equals("+") || c.equals("-"))
			{
				System.out.println("operator");
				if(stack.isEmpty() || stack.peek().equals("("))
				{
					stack.push(c);
				}
				else
				{
					while(!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/") ||
							stack.peek() .equals( "+") || stack.peek().equals( "-")))
					{
						po.add(stack.pop());
					}
					stack.push(c);
				}
			}
			else if (c.equals("*") || c.equals("/"))
			{
				if(stack.isEmpty() || stack.peek().equals("(") || stack.peek().equals("+") || 
						stack.peek().equals("-"))
				{
					stack.push(c);
				}
				else
				{
					while(!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/")) )
					{
						po.add(stack.pop());
					}
					stack.push(c);
				}
			}
			else if (c.equals("("))
			{
				stack.push(c);
			}
			else if (c .equals(")"))
			{
				String temp = " ";
				while ((temp = stack.pop()) != "(")
				{
					po.add(temp);
				}
			}
			else
			{
				System.out.println(c);
				po.add(c);
			}
		}
		while (!stack.isEmpty())
		{
			po.add(stack.pop());
		}
		int size = po.size();
		String[] stringArray = new String[size];
		for (int i=0; i<size; i++)
		{
			stringArray[i] = (String) po.get(i);
		}
		return stringArray;
	}
	/*public static void main(String[] args) 
	{
		String[] txt = {"78", "+", "12"};
		Polish polish = new Polish(txt);
		String[] po = polish.transform();
		for (int i=0; po[i]!=null; i++)
		{
			System.out.println(po[i]);
		}
	}*/
}
