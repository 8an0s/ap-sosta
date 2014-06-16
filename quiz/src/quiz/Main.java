package quiz;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.media.CannotRealizeException;
import javax.media.NoPlayerException;

/* Το λογισμικό λειτουργεί χωρίς προβλήματα. Παρ' όλα αυτά, δεν έχει υλοποιηθεί η λειτουργία του update των ερωτήσεων 
 * και η κατηγορία logo στις κατηγορίες ερωτήσεων. 
 * Επιπλέον, για να μεταγλωττιστεί το πρόγραμμα ΑΠΑΙΤΕΙΤΑΙ η εγκατάσταση του Java Media Framework (JMF).
 */

public class Main {

	public static void main(String[] args) throws NoPlayerException, CannotRealizeException, MalformedURLException, IOException {
		GUI a = new GUI();
		a.createAndShowGUI();
		
	}
}