package com.ding.util;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

public class CAPTCHALabel extends JLabel{
	private static final long serialVersionUID=-963570191302793615L;
    private String text;
    public CAPTCHALabel(String text){
    	this.text=text;
    	setPreferredSize(new Dimension(60,36));
    }
    @Override
    public void paint(Graphics g){
    	super.paint(g);
    	g.setFont(new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,16));
    	g.drawString(text, 5, 25);
    }
}
