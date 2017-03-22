
/**
 * @author MrDing  E-mail: 13160676651@163.com
 * @version: 2017年3月8日 上午11:40:00
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

	
	//显示主页面
	public void lanuchFrame(){
		initView();
		new Thread(new RepaintThread()).start();
	}
	
	
	public void initView(){
		this.setSize(StaticData.WIDTH,StaticData.HEIGHT);
		this.setLocation(com.ding.util.SwingUtil.centreContainer(getSize()));
		this.setTitle("车载网终端系统");
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
	
	//键盘事件的监听内部类
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
	 * 画出程序界面各组件元素
	 */
	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();

		g.setFont(new Font("微软雅黑", Font.BOLD, 40));
		g.setColor(Color.black);
		g.drawString("欢迎使用车载系统", 45, 190);

		g.setFont(new Font("微软雅黑", Font.ITALIC, 26));
		g.setColor(Color.BLACK);
		g.drawString("Version：1.0   Powered By：ZWZ", 280, 260);

		g.setFont(new Font("微软雅黑", Font.BOLD, 30));
		g.setColor(color);
		g.drawString("――――点击Enter键进入主界面――――", 100, 480);
		// 使文字 "――――点击Enter键进入主界面――――" 黑白闪烁
		if (color == Color.WHITE)
			color = Color.black;
		else if (color == color.BLACK)
			color = Color.white;
	}
	
	/**
	 * 双缓冲方式重画界面各元素组件
	 */
	@Override
	public void update(Graphics g) {
		if (offScreen == null)
			offScreen = this.createImage(StaticData.WIDTH, StaticData.HEIGHT);
		Graphics gOffScreen = offScreen.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.white);
		gOffScreen.fillRect(0, 0, StaticData.WIDTH, StaticData.HEIGHT);
		this.paint(gOffScreen); // 重画界面元素
		gOffScreen.setColor(c);
		g.drawImage(offScreen, 0, 0, null); // 将新画好的画布“贴”在原画布上
	}

	/**
	 * 重画线程内部类（每隔250毫秒重画一次）
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
					JOptionPane.showMessageDialog(null, err, "错误", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
			}
		}

	}
}
