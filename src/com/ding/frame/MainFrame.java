package com.ding.frame;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ding.util.SwingUtil;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450,300);
		JPanel contentPane=new JPanel();
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		JLabel tipLabel=new JLabel("¹§Ï²Äã³É¹¦µÇÂ¼ÏµÍ³");
		tipLabel.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,40));
		contentPane.add(tipLabel,BorderLayout.CENTER);
		setLocation(SwingUtil.centreContainer(getSize()));
	}
	
}
