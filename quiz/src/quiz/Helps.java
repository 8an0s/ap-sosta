package quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*Η παρακάτω κλάση αναλαμβάνει να αρχικοποιήσει τις βοήθειες σε περίπτωση που είναι αδύνατη 
 * η ανάγνωση των αρχείων Save. Σε διαφορετική περίπτωση, διαβάζει τον αριθμό των βοηθειών από το αρχείο
 * και θέτει τις τιμές τους στον πίνακα.
 */
public class Helps {
	
	
	Erwtiseis e=new Erwtiseis();
	int[] noofhelps={0,0,0};
	GUI g=new GUI();
	private Scanner s;
	/*Η παρακάτω μέθοδος αναλαμβάνει να εκχωρίσει στον πίνακα noofhelps τον αριθμό των βοηθειών που έχει ο παίκτης, 
	 * διαβάζοντας από το αρχείο. 
	 */
	public Helps()  {
		
		if (g.choice==1){
			File f = new File("src/quiz/SaveCl.txt");
			try {
				s = new Scanner(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			noofhelps[0]=s.nextInt();
			noofhelps[1]=s.nextInt();
			noofhelps[2]=s.nextInt();
			
		}
		else{
			File f = new File("src/quiz/SaveBtt.txt");
			try {
				s = new Scanner(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			noofhelps[0]=s.nextInt();
			noofhelps[1]=s.nextInt();
			noofhelps[2]=s.nextInt();
			
		}
		
		
	}
	/*Η παρακάτω μέθοδος αναλαμβάνει να στείλει στην Classicframe τον δείκτη 
	 * της σωστής απάντησης, της ερώτησης noofq που δέχεται ως παράμετρο 
	 */
	public int gethelp(int noofq) {
		int correct=0;
		
		Classicframe fr = new Classicframe();
			correct=e.GetCorrect(noofq);
		    return correct;
	}

}
