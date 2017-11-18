package GamePractice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.text.html.MinimalHTMLWriter;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;

import GamePractice.GameFrame.PaintThread;




public class GameFrame02 extends Frame {
		
	/**
	 * ����ط���Ϊ�˼��طɻ���ͼƬ
	 */
	Image img =GameUtil.getImage("images/plane.jpg");
	
	
	public void launchFrame(){  //����һ�����ش��ڵķ���
		setSize(700, 700); //��������õĴ��ڵĴ�С
		setLocation(200, 200);
		setVisible(true);  //��Ҫ�Ѵ������ó�Ϊ�ɼ���
		
		new PaintThread().start(); //����������߳�
		
		addWindowListener(new WindowAdapter() { //����һ���ڲ���Դ��ڵļ������󣬿����Ǵ��ڿ����˳�

			@Override
			public void windowClosing(WindowEvent e) {  //����Ƕ�windowClosing������д
				System.exit(0);
			}  
			
		});
	}
	
	private double x=100, y=100; //����Ƿɻ��ĳ�ʼλ��
	private double degree=3.14/3 ;//����ǽǶȷ�Χ�ǡ�0-2pi��,Ҫ�ȸ�һ����ʼ�Ƕ�
	private double speed =10;
	/*private boolean left;    //����ǿ���x��ķ�����ƶ���
	private boolean up;    //����ǿ���Y�᷽���*/	
	
	@Override
	public void paint(Graphics g) {

		Color c  = g.getColor();
		g.setColor(Color.red);
	
		g.getColor();
		
		g.drawImage(img, (int )x,(int ) y,null );  //������ڴ����ϻ�һ��ͼƬ �м��x��y��ʾ���Ƿɻ�ÿ�α仯������
		
		if(speed >0){
			speed -=0.03;
		}
		else{
			speed=0;
		}
		x += speed*Math.cos(degree); //���10 Ҳ�ǿ��Կ��Ʒɻ����ٶ�
		y += speed*Math.sin(degree);
		
		if(y>700-60){	
			degree = -degree;
		}						//���������Ժϲ�һ��������||�Ϳ��Ժϲ�һ��
		if(y<60){
			degree = -degree;
		}
		
		if(x<0){
			degree = Math.PI- degree;
		}
		if(x>700-60){
			degree = Math.PI -degree;
		}
	 /* if(left){
			x -=4;  //����ͨ���ı�ÿ��x��y�����ӻ��߼��ٵ�ֵ������ �ɻ����е� �ٶ�
		}
		else{
			x+=5;
		}
		if(x >700-60){	//���30��ָ�ɻ�����ĳ��ȣ�����������60
			left = true;
		}
		if(x<0){
			left = false;
		}
///////////////////////////////////////////////	
		if(up){
			y -=3;
		}
		else{
			y+=3;
		}
		if(y >700-60){	//���30��ָ�ɻ�����ĳ��ȣ�����������60
			up = true;
		}
		if(y<0){
			up= false;
		}
		*/
		
	}
	
	
	/**
	 * @author user
	 *����һ���߳��࣬���һ���һ���ڲ���
	 */
 class PaintThread extends Thread{
		public void run(){
			while (true){
				repaint();
				try {
					Thread.sleep(40); //1s ����1000ms  Ҳ����һ������ظ���25�δ���
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}
		}
		
		
	}
	
	

	public static void main(String[] args){
		GameFrame02   gh = new GameFrame02();  // ����һ����Ϸ���ڵĶ���
		gh.launchFrame();
		
	}

}
