package quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
/* Ο ακροατής του combo box που περιέχεται στο παραθυρο των σκορ.*/
public class comboboxlistener implements ActionListener {
	
	JComboBox c;
	String Cat;
	int i = 0;
	scores sc = new scores();
	
	public comboboxlistener(JComboBox cb) {
		c = cb;
	}
	
	public void actionPerformed(ActionEvent e) {
		    c = (JComboBox)e.getSource();
	        Cat = (String)c.getSelectedItem();

	        
	    }
	  /* getter που δέχεται την κατηγορία που επιλέχθηκε για να ορίσει τον μετρητή που χρειάζεται για να 
	   * εμφανιστούν τα σκορ.
	   */
	public int getSelectedCat() {
		switch (Cat) {
		case "Athlitika"    : i=0;
		case "Epistimi"     : i=20;
		case "Fagita-pota"  : i=40;
		case "Games"        : i=60;
		case "Geografia"    : i=80;
		case "Glossa"       : i=100;
		case "Istoria"      : i=120;
		case "Texnologia"   : i=140;
		case "Texni"        : i=160;
		default             : i=0;
		}
 		 return i;
	 }
}
