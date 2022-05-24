package com.sxt;

    import java.awt.Graphics;
    import java.awt. Rectangle;
    
public abstract class Tank extends GameObject {
	//�ߴ�
	public int width=40;
	public int height=50;
	//�ٶ�
	private int speed=3;
	//����
	private Direction direction=Direction.UP;
	//�ĸ�����ͼƬ
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
