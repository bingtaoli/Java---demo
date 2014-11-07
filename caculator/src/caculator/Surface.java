package caculator;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

/* 外观 */
public class Surface 
{
	public void surface()
	{
		JFrame jf = new JFrame();
		jf.setTitle("给杰哥的计算器");
		jf.setSize(295, 400);
		jf.setLocation(500, 500);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(3); /*设置点击关闭按钮后执行的操作这里设置为点击后关闭应用程序*/
		
		/* 实例化三个面板 */
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.setLayout(new FlowLayout());  /* 设置面板的布局 */
		JTextField text = new JTextField("0");
		text.setPreferredSize(new Dimension(240, 90));   /* 设置文本框的大小 */
		text.setFont(new Font("黑体", Font.BOLD, 30));
		p1.add(text);
		jf.add(p1, "North");
		
		p2.setLayout(new GridLayout(5, 5));  /* 第二个面板的布局设为网格布局，用来放置计算器的按 */
		Listener listener = new Listener(text);
		String s = "+-*/7891456C1230=";
		for (int i=0; i<s.length(); i++)
		{
			JButton b = new JButton(s.substring(i, i+1));
			p2.add(b);
			b.addActionListener(listener);
		}
		jf.add(p2, "Center");
		jf.setVisible(true);
	}
	public static void main(String[] args) 
	{		
		Surface surface = new Surface();
		surface.surface();
	}
}
