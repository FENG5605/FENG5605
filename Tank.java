package com.sxt;

    import java.awt.Graphics;
    import java.awt. Rectangle;
    
public abstract class Tank extends GameObject {
	//尺寸
	public int width=40;
	public int height=50;
	//速度
	private int speed=3;
	//方向
	private Direction direction=Direction.UP;
	//四个方向图片
	private String upImg;
	private String leftImg;
	private String rightImg;
	private String downImg;
	
	public Tank(String img,int x,int y,GamePanel gamepanel,
			String upImg,String leftImg,String rightImg,String downImg) {
		super(img, x, y, gamepanel);
		this.upImg=upImg;
		this.leftImg=leftImg;
		this.rightImg=rightImg;
		this.downImg=downImg;
		
	}
    @Override
    public abstract void paintSelft(Graphics g);
    @Override
    public abstract Rectangle gerRec();
	

}
