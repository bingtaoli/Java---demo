package caculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReForNumber 
{
	public String[] toStringArray(String txt) 
	{
		Pattern p1 = Pattern.compile("(\\d+)");
		Matcher m1 = p1.matcher(txt);
		List<String> list = new ArrayList<>();
		while (m1.find())
		{
			String find = m1.group(1);
			list.add(find);
			int start = txt.indexOf(find);			
			txt = txt.substring(start+find.length());
			Matcher m2 = p1.matcher(txt);
			if (m2.find())
			{
				String find2 = m2.group(1);
				int start2 = txt.indexOf(find2);
				String operator = txt.substring(0,start2);
				list.add(operator);
			}
		}
		if (txt.length() != 0)
		{
			list.add(txt);
		}
		int size = list.size();
		String[] stringArray = new String[size];
		for (int i=0; i<size; i++)
		{
			stringArray[i] = (String) list.get(i);
		}
		return stringArray;
	}
	
}
