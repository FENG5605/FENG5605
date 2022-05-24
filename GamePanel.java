package com.sxt;

import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GamePanel extends JFrame {
	//����˫����ͼƬ
	Image offScreemImage=null;

    //���ڳ���
    int width = 800;
    int height = 610;
    //����ͼƬ
    Image select=Toolkit.getDefaultToolkit().getImage("src/Image/tankR.gif");
    		//ָ���ʼ������
    	int y=150;
    	//��Ϸģʽ 0 ��Ϸδ��ʼ��1 ����ģʽ��2 ˫��ģʽ
    	int state=0;
    	int a=1;

    //���ڵ���������
    public void launch(){
        //����
        setTitle("̹�˴�ս");
        //���ڳ�ʼ��С
        setSize(width, height);
        //ʹ��Ļ����
        setLocationRelativeTo(null);
        //��ӹر��¼�
        setDefaultCloseOperation(3);
        //�û����ܵ�����С
        setResizable(false);
        //ʹ���ڿɼ�
        setVisible(true);
        //��Ӽ��̼�����
        this.addKeyListener(new GamePanel.KeyMonitor());
        
        //����
        while(true) {
        	repaint();
        	try {
        		Thread.sleep(20);
        		
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        }
    }

    @Override
    public void paint(Graphics g) {
    	//������Imageһ����С��ͼƬ
    	if(offScreemImage==null) {
    		offScreemImage=this.createImage(width,height);
    	}
    	//��ø�ͼƬ�Ļ���
    	Graphics gImage=offScreemImage.getGraphics();
        //���ñ�����ɫ
        gImage.setColor(Color.green);
        //�����������
        gImage.fillRect(0, 0, width, height);
        //�ұ仭����ɫ
        gImage.setColor(Color.BLUE);
        //�ı����ִ�С����ʽ
        gImage.setFont(new Font("����",Font.BOLD,50));
        // state=0 ��Ϸδ��ʼ
        if(state==0) {
        	  //�������
        gImage.drawString("ѡ����Ϸģʽ",220,100);
        gImage.drawString("������Ϸ",220,200);
        gImage.drawString("˫����Ϸ",220,300);
        gImage.drawString("˫����Ϸ",220,300);
        gImage.drawString("��1��2ѡ��ģʽ�����س���ʼ��Ϸ",0,400);
        //����ָ��
        gImage.drawImage(select,160,y,null);
        }
      //state=0/1 ��Ϸ��ʼ
        else if(state==1||state==2) {
        	gImage.drawString("��Ϸ��ʼ",220,200);
        	if(state==1) {
        		gImage.drawString("������Ϸ",220,200);
        	}
        	else {
        		 gImage.drawString("˫����Ϸ",220,300);
        	}
        }
        /**�����������ƺõ�ͼ���������Ƶ������Ļ�����*/
        g.drawImage(offScreemImage,0,0,null);
        
    }
    //���̼�����
    class KeyMonitor extends KeyAdapter{
    	 //���¼���
    	 @Override
    	 public void keyPressed(KeyEvent e) {
    		//���ؼ�֮
    		 int key=e.getKeyCode();
    		 switch(key) {
    		 case KeyEvent.VK_1:
    		 a=1;
    		 y=150;
    		 break;
    		 case KeyEvent.VK_2:
    		 a=2;
    		 y=250;
    		 break;
    		 case KeyEvent.VK_ENTER:
    		 state=a;
    		 break;
    		 
    		 }
    		 System.out.println(e.getKeyChar());
    	 }
        
    }
     

    public static void main(String[] args) {
        GamePanel gp = new GamePanel();
        gp.launch();
    }
}
