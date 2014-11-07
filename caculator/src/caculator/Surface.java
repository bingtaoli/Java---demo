package caculator;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

/* ��� */
public class Surface 
{
	public void surface()
	{
		JFrame jf = new JFrame();
		jf.setTitle("���ܸ�ļ�����");
		jf.setSize(295, 400);
		jf.setLocation(500, 500);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(3); /*���õ���رհ�ť��ִ�еĲ�����������Ϊ�����ر�Ӧ�ó���*/
		
		/* ʵ����������� */
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.setLayout(new FlowLayout());  /* �������Ĳ��� */
		JTextField text = new JTextField("0");
		text.setPreferredSize(new Dimension(240, 90));   /* �����ı���Ĵ�С */
		text.setFont(new Font("����", Font.BOLD, 30));
		p1.add(text);
		jf.add(p1, "North");
		
		p2.setLayout(new GridLayout(5, 5));  /* �ڶ������Ĳ�����Ϊ���񲼾֣��������ü������İ� */
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
