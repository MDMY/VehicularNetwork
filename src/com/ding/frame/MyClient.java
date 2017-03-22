
/**
 * @author MrDing  E-mail: 13160676651@163.com
 * @version: 2017��3��8�� ����11:40:00
 */


package com.ding.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import com.ding.StaticData.StaticData;
import com.ding.serialException.ExceptionWriter;

//import javax.swing.JFrame;

public class MyClient extends Frame{
	private static final long serialVersionUID= 1L;
	Color color=Color.WHITE;
	Image offScreen=null;
	
	Toolkit toolKit=getToolkit();
	Image icon =toolKit.getImage(MyClient.class.getResource("computer.png"));
	
	MyDataView myDataView=new MyDataView(this);
	
	public static void main(String[] args){
		new MyClient().lanuchFrame();
	}

	
	//��ʾ��ҳ��
	public void lanuchFrame(){
		initView();
		new Thread(new RepaintThread()).start();
	}
	
	
	public void initView(){
		this.setSize(StaticData.WIDTH,StaticData.HEIGHT);
		this.setLocation(com.ding.util.SwingUtil.centreContainer(getSize()));
		this.setTitle("�������ն�ϵͳ");
		this.setIconImage(icon);
		this.setBackground(Color.white);
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		this.addKeyListener(new KeyMonitor());
		this.setResizable(false);
		this.setVisible(true);
	}
	
	//�����¼��ļ����ڲ���
	private class KeyMonitor extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e){
			int keyCode=e.getKeyCode();
			if(keyCode==KeyEvent.VK_ENTER){
				setVisible(false);
				myDataView.setVisible(true);
				myDataView.dataFrame();
			}
		}
	}
	
	/**
	 * ���������������Ԫ��
	 */
	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();

		g.setFont(new Font("΢���ź�", Font.BOLD, 40));
		g.setColor(Color.black);
		g.drawString("��ӭʹ�ó���ϵͳ", 45, 190);

		g.setFont(new Font("΢���ź�", Font.ITALIC, 26));
		g.setColor(Color.BLACK);
		g.drawString("Version��1.0   Powered By��ZWZ", 280, 260);

		g.setFont(new Font("΢���ź�", Font.BOLD, 30));
		g.setColor(color);
		g.drawString("�D�D�D�D���Enter������������D�D�D�D", 100, 480);
		// ʹ���� "�D�D�D�D���Enter������������D�D�D�D" �ڰ���˸
		if (color == Color.WHITE)
			color = Color.black;
		else if (color == color.BLACK)
			color = Color.white;
	}
	
	/**
	 * ˫���巽ʽ�ػ������Ԫ�����
	 */
	@Override
	public void update(Graphics g) {
		if (offScreen == null)
			offScreen = this.createImage(StaticData.WIDTH, StaticData.HEIGHT);
		Graphics gOffScreen = offScreen.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.white);
		gOffScreen.fillRect(0, 0, StaticData.WIDTH, StaticData.HEIGHT);
		this.paint(gOffScreen); // �ػ�����Ԫ��
		gOffScreen.setColor(c);
		g.drawImage(offScreen, 0, 0, null); // ���»��õĻ�����������ԭ������
	}

	/**
	 * �ػ��߳��ڲ��ࣨÿ��250�����ػ�һ�Σ�
	 */
	private class RepaintThread implements Runnable {
		@Override
		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					String err = ExceptionWriter.getErrorInfoFromException(e);
					JOptionPane.showMessageDialog(null, err, "����", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
			}
		}

	}
}
