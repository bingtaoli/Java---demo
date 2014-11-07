package caculator;

import java.util.Stack;

/* ¼ÆËãÄæ²¨À¼Ê½ */
public class Caculate 
{
	int num1 =0, num2 = 0;
	public int caculate(String[] test)
	{
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<test.length; i++)
		{
			String s = test[i];
			if (s.matches("(\\d+)"))
			{
				stack.push(Integer.parseInt(s));
			}
			else if (s.equals("+"))
			{
				int num1 = (int) stack.pop();
				int num2 = (int) stack.pop();
				int num3 = num1 + num2;
				stack.push(num3);
			}
			else if (s.equals("*"))
			{
				int num1 = (int) stack.pop();
				int num2 = (int) stack.pop();
				int num3 = (int) (num2*1.0 * num1);
				stack.push(num3);
			}
			else if (s.equals("-"))
			{
				int num1 = (int) stack.pop();
				int num2 = (int) stack.pop();
				int num3 = num2 - num1;
				stack.push(num3);
			}
			else if (s.equals("/"))
			{
				int num1 = (int) stack.pop();
				int num2 = (int) stack.pop();
				int num3 = (int) (num2*1.0 / num1);
				stack.push(num3);
			}
		}
		return stack.pop();
	}
	/*public static void main(String[] args) 
	{
		String[] test1 = {"78", "12", "+"};
		Caculate ca = new Caculate();
		System.out.println(ca.caculate(test1));
	}*/
}
