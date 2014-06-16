package quiz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
/* Η κλάση αυτή υλοποιεί το παράθυρο διαλόγου που εμφανίζεται σε περίπτωση που τελειώσει το παιχνίδι. 
 */
public class EndGame extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	GUI g = new GUI();
	set s = new set();
	Classicframe f = new Classicframe();
	JButton okButton = new JButton("Oκ");
	Save sav=new Save();
	ScoresRW t= new ScoresRW();
	final JLabel label = new JLabel("Γράψε το όνομά σου για να προστεθέι στην λίστα των Σκορ!");
	boolean isQualified = false;
	JTextField nameinput;
	JLabel congrats = new JLabel();
	int erwt=0;
/* Ο κατασκευαστής της κλάσης. Δέχεται μεταβλητή που δείχνει εάν η απάντηση του παίκτη είναι σωστή, το σκορ, και μια 
 * μεταβλητή που καθορίζει εάν ο παίκτης απαντησε λάθος, αν τελείωσε ο χρόνος, ή οι ερωτήσεις.
 */
	public EndGame(boolean iscorrect,final int sc,int a) {
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(false);
		this.setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		okButton.setPreferredSize(new Dimension(430,30));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		nameinput = new JTextField();
		nameinput.setPreferredSize(new Dimension(200,40));
		contentPanel.add(nameinput,BorderLayout.CENTER);
		nameinput.setVisible(false);
		
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			contentPanel.add(label);
			label.setVisible(false);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		if(iscorrect){
				
				
	
			g.time.scoreg=sc;
			
					

				
		}
		else {
			setVisible(true);
			if(a==1){
				Label(2);
			}
			else if(a==2){
				Label(3);
			}
			else{
				Label(4);
			}
			try {
				sav.WriteNull();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			getContentPane().add(congrats, BorderLayout.NORTH);
			if(t.isQ(sc,g.choice)){
				nameinput.setVisible(true);
				label.setVisible(true);
				isQualified = true;
			}
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String scname = nameinput.getText();
					if(scname.isEmpty()){
						scname="noname";
					}
					scname = scname.replaceAll("\\s", "_");
					
					try {
						t.highScoreWr(sc,g.choice,isQualified, scname);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					g.backtomenu(g.init,g.panel, s.x, s.y);
					
					
					dispose();
				}
			});
			
			
		}
			
		}
	}
	// Η παρακάτω μέθοδος αλλάζει το περιεχόμενο της ετικέτας 
	//που περιέχεται στο παράθυρο διαλόγου, ανάλογα με την παράμετρο a.
	public void Label(int i){
	
		if(i==2){
			congrats.setText("Λάθος απάντηση. Τέλος Παιχνιδιού!");
			g.backtomenu(g.init,g.panel, s.x, s.y);
		}
		else if(i==3){
			congrats.setText("Ο χρόνος σου τελείωσε!");
			g.backtomenu(g.init,g.panel, s.x, s.y);
		}
		else
			congrats.setText("Τέλος ερωτήσεων!");
			g.backtomenu(g.init,g.panel, s.x, s.y);
	}
	


}
