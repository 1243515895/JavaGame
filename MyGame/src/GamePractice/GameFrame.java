package GamePractice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.PaintContext;
import java.awt.RenderingHints;
import java.awt.dnd.DragGestureEvent;
import java.awt.event.PaintEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.util.PrimitiveIterator;

import javax.swing.WindowConstants;
import org.omg.PortableServer.POAPackage.AdapterAlreadyExists;


public class GameFrame extends Frame {
		
	/**
	 * ����ط���Ϊ�˼��طɻ���ͼƬ
	 */
	Image img =GameUtil.getImage("images/plane.jpg");
	
	
	public void launchFrame(){  //����һ�����ش��ڵķ���
		setSize(500, 500);
		setLocation(100, 100);
		setVisible(true);
		
		new PaintThread().start();
		
		addWindowListener(new WindowAdapter() { //����һ���ڲ���Դ��ڵļ������󣬿����Ǵ��ڿ����˳�

			@Override
			public void windowClosing(WindowEvent e) {  //����Ƕ�windowClosing������д
				System.exit(0);
			}  
			
		});
	}
	
	private double x, y;
	
	@Override
	public void paint(Graphics g) {
		g.drawLine(100, 100, 200, 250);
		g.drawRect(100, 100, 200, 200);
		
		Font f = new Font("����", Font.BOLD, 30);
		g.setFont(f);
		
		Color c  = g.getColor();
		g.setColor(Color.red);
		g.drawString("�����ҵ���Ϸ����", 100, 200);
		g.getColor();
		
		g.drawImage(img, (int )x,(int ) y,null);  //������ڴ����ϻ�һ��ͼƬ �м��x��y��ʾ���Ƿɻ�ÿ�α仯������
	
		x+=3;
		y+=2;
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
		GameFrame   gh = new GameFrame();  // ����һ����Ϸ���ڵĶ���
		gh.launchFrame();
		
	}
}
