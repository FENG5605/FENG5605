package com.sxt;

  import java.awt.Graphics;
  import java.awt. Rectangle;

public class PlayerOne extends Tank{

	public PlayerOne(String img, int x, int y, GamePanel gamepanel,
			String upImg, String leftImg, String rightImg,
			String downImg) {
		super(img, x, y, gamepanel, upImg, leftImg, rightImg, downImg);
		// TODO Auto-generated constructor stub
	}
	@Override
    public  void paintSelft(Graphics g) {
		g.drawImage(img,x,y,null);
		
		
	}
	
	@Override
    public  Rectangle gerRec() {
		return null;
	}
}

 