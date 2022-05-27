package com.sxt;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



import javax.swing.JFrame;

public class GamePanel extends JFrame {
	static URL url;
	@SuppressWarnings("deprecation")
	static AudioClip ac;

    /** ����˫����ͼƬ */
    private Image offScreenImage = null;
    //��Ϸ״̬ 0 ��Ϸδ��ʼ��1 ����ģʽ��2 ˫��ģʽ�� 3 ��Ϸ��ͣ�� 4 ��Ϸʧ�ܣ�5 ��Ϸ�ɹ�
    public int state= 0;
    //��ʱ����
    private int a = 1;
    //�ػ����
    public int count = 0;
    //���ڳ���
    private int width = 800;
    private int height = 610;
    //��������
    private int enemyCount = 0;
    //�߶�
    private int y = 150;
    //�Ƿ�ʼ
    private boolean start = false;
    //���弯��
    public List<Bullet> bulletList = new ArrayList<>();
    public List<Bot> botList = new ArrayList<>();
    public List<Tank> tankList = new ArrayList<>();
    public List<Wall> wallList = new ArrayList<>();
    public List<Bullet> removeList = new ArrayList<>();
    public List<Base> baseList = new ArrayList<>();
    public List<BlastObj> blastList = new ArrayList<>();
    //����ͼƬ
    public Image background = Toolkit.getDefaultToolkit().getImage("src/Image/images/background.jpg");
    //ָ��ͼƬ
    private Image select = Toolkit.getDefaultToolkit().getImage("src/Image/tankR.gif");
    //����
    private Base base = new Base("src/Images/images/star.gif", 375, 570, this);
    //���
    private PlayerOne playerOne = new PlayerOne("src/Image/tankU.gif", 125, 510,
            "src/Image/tankU.gif","src/Image/tankD.gif",
            "src/Image/tankL.gif","src/Image/tankR.gif", this);
    private PlayerTwo playerTwo = new PlayerTwo("src/Images/images/player2/p2tankU.gif", 500,510,
            "src/Images/images/player2/p2tankU.gif","src/Images/images/player2/p2tankD.gif",
            "src/Images/images/player2/p2tankL.gif","src/Images/images/player2/p2tankR.gif", this);

    //���ڵ���������
    public void launch(){
        //����
        setTitle("̹�˴�ս");
        //���ڳ�ʼ��С
        setSize(width, height);
        //�û����ܵ�����С
        setResizable(false);
        //ʹ���ڿɼ�
        setVisible(true);
        //��ȡ��Ļ�ֱ��ʣ�ʹ��������ʱ����
        setLocationRelativeTo(null);
        //��ӹر��¼�
        setDefaultCloseOperation(3);
        //��Ӽ����¼�
        this.addKeyListener(new GamePanel.KeyMonitor());
        //���Χǽ
        for(int i = 0; i< 14; i ++){
            wallList.add(new Wall("src/Images/images/walls.gif", i*60 ,170, this ));
        }
        wallList.add(new Wall("src/Images/images/walls.gif", 305 ,560,this ));
        wallList.add(new Wall("src/Images/images/walls.gif", 305 ,500,this ));
        wallList.add(new Wall("src/Images/images/walls.gif", 365 ,500,this ));
        wallList.add(new Wall("src/Images/images/walls.gif", 425 ,500,this ));
        wallList.add(new Wall("src/Images/images/walls.gif", 425 ,560,this ));
        wallList.add(new Wall("src/Images/images/walls.gif", 305 ,360,this ));
        wallList.add(new Wall("src/Images/images/walls.gif", 365 ,360,this ));
        wallList.add(new Wall("src/Images/images/walls.gif", 425 ,360,this ));
        wallList.add(new Wall("src/Images/images/walls.gif", 125 ,260,this ));
        wallList.add(new Wall("src/Images/images/walls.gif", 625 ,260,this ));
        //��ӻ���
        baseList.add(base);

        while (true){
            if(botList.size() == 0 && enemyCount == 10){
                state = 5;
            }
            if(tankList.size() == 0 && (state == 1 || state == 2)){

                state = 4;
            }
            if(state == 1 || state == 2){
                if (count % 100 == 1 && enemyCount < 10) {
                    Random r = new Random();
                    int rnum =r.nextInt(800);//���
                    botList.add(new Bot("src/Images/images/enemy/enemy1U.gif", rnum, 110,
                            "src/Images/images/enemy/enemy1U.gif","src/Images/images/enemy/enemy1D.gif",
                            "src/Images/images/enemy/enemy1L.gif","src/Images/images/enemy/enemy1R.gif", this));
                    enemyCount++;
                    //System.out.println("bot: " + botList.size());
                }
            }
            repaint();
            try {
                //�߳�����  1�� = 1000����
                Thread.sleep(25);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        //System.out.println(bulletList.size());
        //System.out.println("tank"+tankList.size());
        //����������һ����С��ImageͼƬ
        if(offScreenImage ==null){
            offScreenImage=this.createImage(width, height);
        }
        //��ø�ͼƬ�Ļ���
        Graphics gImage= offScreenImage.getGraphics();
        //���ñ�����ɫ
        gImage.setColor(Color.green);
        //�����������
        gImage.fillRect(0, 0, width, height);
        //�ı仭�ʵ���ɫ
        gImage.setColor(Color.blue);
        //�ı����ִ�С����ʽ
        gImage.setFont(new Font("����",Font.BOLD,50));
        if(state == 0){
            //�������
            gImage.drawString("ѡ����Ϸģʽ",220,100);
            gImage.drawString("������Ϸ",220,200);
            gImage.drawString("˫����Ϸ",220,300);
            gImage.drawString("��1��2ѡ��ģʽ�����س���ʼ��Ϸ",0,400);
            gImage.drawImage(select,160,y,null);
        }
        else if(state == 1||state == 2){
            gImage.setColor(Color.red);
            gImage.setFont(new Font("����",Font.BOLD,20));
            gImage.drawString("WASD�����ƶ�",0,510);
            gImage.drawString("�ո����",0,550);
            gImage.drawString("ʣ�����:"+botList.size(),0,50);
            if(state == 2){
                gImage.drawString("����������ƶ�",575,510);
                gImage.drawString("K���",575,550);
            }

            //paint�ػ���ϷԪ��
            for(Tank tank : tankList){
                tank.paintSelf(gImage);
            }
            for(Bullet bullet: bulletList){
                bullet.paintSelf(gImage);
            }
            bulletList.removeAll(removeList);
            for(Bot bot: botList){
                bot.paintSelf(gImage);
            }
            for (Wall wall: wallList){
                wall.paintSelf(gImage);
            }
            for(Base base : baseList){
                base.paintSelf(gImage);
            }
            for(BlastObj blast : blastList){
                blast.paintSelf(gImage);
            }
            //�ػ����+1
            count++;
        }
        else if(state == 3){
            gImage.drawString("��Ϸ��ͣ",220,200);
        }
        else if(state == 4){
            gImage.drawString("��Ϸʧ��",220,200);
        }
        else if(state == 5){
            gImage.drawString("��Ϸʤ��",220,200);
        }
        /** �����������ƺõ�ͼ���������Ƶ������Ļ����� */
        g.drawImage(offScreenImage, 0, 0, null);
    }

    private class KeyMonitor extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            //super.keyPressed(e);
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_1:
                    y = 150;
                    a = 1;
                    break;
                case KeyEvent.VK_2:
                    y = 250;
                    a = 2;
                    break;
                case KeyEvent.VK_ENTER:
                    state = a;
                    //������
                    if(state == 1 && !start){
                        tankList.add(playerOne);
                    }else{
                        tankList.add(playerOne);
                        tankList.add(playerTwo);
                          playerTwo.alive=true;
                    }
                    start = true;
                    playerOne.alive=true;
                  
                    break;
                case KeyEvent.VK_P:
                    if(state != 3){
                        a = state;
                        state = 3;
                    }
                    else{
                        state = a;
                        if(a == 0) {
                            a = 1;
                        }
                    }
                    break;
                default:
                    playerOne.keyPressed(e);
                    playerTwo.keyPressed(e);
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e){
            playerOne.keyReleased(e);
            playerTwo.keyReleased(e);
        }
    }
    public static void main(String[] args) throws MalformedURLException {
  	  File f1 = new File("src/Images/images/war1.wav");
  	  url = f1.toURL();
  	  ac = Applet.newAudioClip(url);
  	  ac.loop();
        GamePanel gamePanel = new GamePanel();
        gamePanel.launch();
    }
}