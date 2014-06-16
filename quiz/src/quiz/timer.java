package quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/*Η παρακάτω κλάση αναλαμβάνει να αρχίσει μία αντίστροφη μέτρηση 60 δευτερολέπτων,να ειδοποιήσει το πρόγραμμα
 * στο τέλος του χρόνου.Στο παιχνίδι ενάντια στον χρονο ανααμβάνει να ενημερώσει τον χρόνο σε κάθε σωστή απάντηση
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
	//Ο κατασκευαστής της κλάσης.
	public timer() {
		
		
		Timeclass tc = new Timeclass(60);
		time = new Timer(1000, tc);
		
	}
	public int k;
//Εσωτερική κλάση. Υλοποιεί ακροατή για αλλαγές στο χρόνο.
public class Timeclass implements ActionListener {

	
	public Timeclass(int initialtime) {
		counter = 60;	
	}
	public void actionPerformed(ActionEvent tc) {
		counter--;
		
		if(counter>=0) {
			timerlabel.setText("Χρόνος: " + counter);
			
		}
		else {
			time.stop();
			timerstate = false;
			EndGame end=new EndGame(false,scoreg,2);
						
		}
	}
}
//παύση του μετρητή.
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
//εκκίνηση του μετρητή.
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
//αύξηση του μετρητή κατά 5 δευτερόλεπτα. χρησιμοποιείται σε κάθε σωστή απάντηση στο παιχνίδι ενάντια στο χρόνο.
public void addtime() {
	
		counter +=5;
	
}


}


