package GamePractice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import GamePractice.GameFrame02.PaintThread;

public class GameFrame05  extends MyFrame{
	
	
	
	/**
	 * ����ط���Ϊ�˼��طɻ���ͼƬ
	 */
	Image img =GameUtil.getImage("images/plane.jpg");
	Image bg = GameUtil.getImage("images/bg.jpg");
	
	
	
	
	private double x=100, y=100; //����Ƿɻ��ĳ�ʼλ��
	private double degree=3.14/3 ;//����ǽǶȷ�Χ�ǡ�0-2pi��,Ҫ�ȸ�һ����ʼ�Ƕ�
	private double speed =10;
	/*private boolean left;    //����ǿ���x��ķ�����ƶ���
	private boolean up;    //����ǿ���Y�᷽���*/	
	
	@Override
	public void paint(Graphics g) {

	
		
		g.drawImage(img, (int )x,(int ) y,null );  //������ڴ����ϻ�һ��ͼƬ �м��x��y��ʾ���Ƿɻ�ÿ�α仯������
		g.drawImage(bg, 0, 0, null);
		
		x += speed*Math.cos(degree); //���10 Ҳ�ǿ��Կ��Ʒɻ����ٶ�
		y += speed*Math.sin(degree);
		
		degree += 0.05;
	}
		
	public static void main(String[] args){
		
		GameFrame05 gf = new GameFrame05();
		gf.launchFrame();
		
	}
	

}
