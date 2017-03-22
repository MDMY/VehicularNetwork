package com.ding.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.apache.commons.lang.RandomStringUtils;

import com.ding.util.CAPTCHALabel;
import com.ding.util.DBHelper;

public class Login extends JFrame{
	private static final long serialVersionUID= -4655235896173916415L;
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private JTextField validateTextField;
	private String randomText;
	
	
	public static void main(String args[]){
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Throwable e){
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable(){
			public void run(){
			try{
				Login frame=new Login();
				frame.setVisible(true);
			}catch(Exception e){
				e.printStackTrace();
			}
			}
		});
	}
	
	
	public Login(){
		//����window��icon
		Toolkit toolkit=getToolkit();
		Image icon=toolkit.getImage(Login.class.getResource("computer.png"));
		setIconImage(icon);
		setBackground(Color.white);
		setTitle("����������ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane=new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.PAGE_AXIS));
		setSize(400,250);	
		setResizable(false);
		JPanel usernamePanel=new JPanel();
		contentPane.add(usernamePanel);
		JLabel usernameLabel=new JLabel("\u7528\u6237\u540D\uFF1A");
		usernameLabel.setFont(new Font("΢���ź�",Font.PLAIN,15));
		usernamePanel.add(usernameLabel);
		//usernamePanel.setLocation(100, 100);
		usernameTextField=new JTextField();
		usernameTextField.setFont(new Font("΢���ź�",Font.PLAIN,15));
		usernamePanel.add(usernameTextField);
		usernameTextField.setColumns(10);
		JPanel passwordPanel=new JPanel();
		contentPane.add(passwordPanel);
		JLabel passwordLabel=new JLabel("\u5BC6 \u7801 \uFF1A");
		passwordLabel.setFont(new Font("΢���ź�",Font.PLAIN,15));
		passwordPanel.add(passwordLabel);
		passwordField=new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setFont(new Font("΢���ź�",Font.PLAIN,15));
		passwordPanel.add(passwordField);
		JPanel validatePanel=new JPanel();
		contentPane.add(validatePanel);
		JLabel validateLabel=new JLabel("\u9A8C\u8BC1\u7801\uFF1A");
		validateLabel.setFont(new Font("΢���ź�",Font.PLAIN,15));
		validatePanel.add(validateLabel);
		validateTextField=new JTextField();
		validateTextField.setFont(new Font("΢���ź�",Font.PLAIN,15));
		validatePanel.add(validateTextField);
		validateTextField.setColumns(5);
		randomText=RandomStringUtils.randomAlphanumeric(4);
		CAPTCHALabel label=new CAPTCHALabel(randomText);
		label.setFont(new Font("΢���ź�",Font.PLAIN,15));
		validatePanel.add(label);
		
		JPanel buttonPanel=new JPanel();
		contentPane.add(buttonPanel);
		JButton submitButton=new JButton("��¼");
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				do_submitButton_actionPerformed(e);
			}
		});
		submitButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
		buttonPanel.add(submitButton);
		
		JButton cancelButton=new JButton("�˳�");
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				do_cancelButton_actionPerformed(e);
			}
		});
		cancelButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
		buttonPanel.add(cancelButton);
		JPanel buttonPanel2=new JPanel();
		contentPane.add(buttonPanel2);
		JButton registerButton=new JButton("ע��");
		registerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				do_registerButton_actionPerformed(e);
			}
		});
		registerButton.setFont(new Font("΢���ź�",Font.PLAIN,15));
		buttonPanel2.add(registerButton);
		
		
		//pack();
		setLocation(com.ding.util.SwingUtil.centreContainer(getSize()));
		
	
	}


	protected void do_registerButton_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Register register=new Register();
		register.setVisible(true);
		this.dispose();
	}


	protected void do_cancelButton_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}


	protected void do_submitButton_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String username=usernameTextField.getText();
		String  password=passwordField.getText();
		String validate=validateTextField.getText();
		if(username.isEmpty()){
			JOptionPane.showMessageDialog(null,"�û�������Ϊ�գ�","������Ϣ",JOptionPane.WARNING_MESSAGE);
			return;
	    }
		if(new String(password).isEmpty()){
			JOptionPane.showMessageDialog(null,"���벻��Ϊ�գ�","������Ϣ",JOptionPane.WARNING_MESSAGE);
			return;
	    }
		if(validate.isEmpty()){
			JOptionPane.showMessageDialog(null,"��֤�벻��Ϊ�գ�","������Ϣ",JOptionPane.WARNING_MESSAGE);
			return;
	    }
		if(!DBHelper.exists(username)){
			JOptionPane.showMessageDialog(null,"�û��������ڣ�","������Ϣ",JOptionPane.WARNING_MESSAGE);
			return;
	    }
		if(!DBHelper.check(username,password.toCharArray())){
			JOptionPane.showMessageDialog(null,"�������","������Ϣ",JOptionPane.WARNING_MESSAGE);
			return;
	    }
		if(!validate.equals(randomText)){
			JOptionPane.showMessageDialog(null,"��֤�����","������Ϣ",JOptionPane.WARNING_MESSAGE);
			return;
	    }
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				try{
					//MainFrame frame=new MainFrame();
					/*MyClient frame=new MyClient();
					frame.setVisible(true);*/
					new MyClient().lanuchFrame();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		this.dispose();
	}
}
