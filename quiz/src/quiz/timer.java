package quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/*� �������� ����� ����������� �� ������� ��� ���������� ������� 60 �������������,�� ����������� �� ���������
 * ��� ����� ��� ������.��� �������� ������� ���� ����� ���������� �� ���������� ��� ����� �� ���� ����� ��������
 */
public class timer {
	
	public static JLabel timerlabel = new JLabel();
	public int labeltime = 60;
	Timer time;
	GUI g=new GUI();
	boolean timerstate = false;
	public int scoreg;
	
	int counter;
	public int a;
	//� ������������� ��� ������.
	public timer() {
		
		
		Timeclass tc = new Timeclass(60);
		time = new Timer(1000, tc);
		
	}
	public int k;
//��������� �����. �������� ������� ��� ������� ��� �����.
public class Timeclass implements ActionListener {

	
	public Timeclass(int initialtime) {
		counter = 60;	
	}
	public void actionPerformed(ActionEvent tc) {
		counter--;
		
		if(counter>=0) {
			timerlabel.setText("������: " + counter);
			
		}
		else {
			time.stop();
			timerstate = false;
			EndGame end=new EndGame(false,scoreg,2);
						
		}
	}
}
//����� ��� �������.
public void pause() {
	if(timerstate) {
		time.stop();
		timerstate = false;
	}
	else {
		time.start();
		timerstate = true;
	}
}
//�������� ��� �������.
public void start() {
	if(g.choice==1){
		counter = 60;
	}
	else{
		Scanner s=null;
		File f = new File("src/quiz/SaveBtt.txt");
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		counter=s.nextInt();
		counter=s.nextInt();
		counter=s.nextInt();
		counter=s.nextInt();
		String cat=s.next();
		counter=s.nextInt();
		counter=s.nextInt();
		
	}
	time.start(); 
	timerstate = true;
}
//������ ��� ������� ���� 5 ������������. ��������������� �� ���� ����� �������� ��� �������� ������� ��� �����.
public void addtime() {
	
		counter +=5;
	
}


}


