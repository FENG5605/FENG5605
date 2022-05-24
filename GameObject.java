package com.sxt;

import java.awt.Graphics;
import java.awt.Image;
import java.awt. Rectangle;
import java.awt.Toolkit;

public  abstract class GameObject {
	//ͼƬ
	public Image img;
	//����
	public int y;
	public int x;
	//����
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
