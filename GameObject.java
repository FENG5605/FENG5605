package com.sxt;

import java.awt.Graphics;
import java.awt.Image;
import java.awt. Rectangle;
import java.awt.Toolkit;

public  abstract class GameObject {
	//Í¼Æ¬
	public Image img;
	//×ø±ê
	public int y;
	public int x;
	//½çÃæ
	private GamePanel gamePanel;
	
	public GameObject(String img,int x,int y,GamePanel gamePanel) {
		this.img=Toolkit.getDefaultToolkit().getImage(img);
		this.x=x;
		this.y=y;
		this.gamePanel=gamePanel;
	}
	public abstract void paintSelft(Graphics g);
	
	public abstract Rectangle gerRec();

}
