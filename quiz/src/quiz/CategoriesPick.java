package quiz;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.CardLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.SpringLayout;
import javax.swing.BoxLayout;

import net.miginfocom.swing.MigLayout;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;

/* η κλάση αυτή περιέχει όλα τα περιεχόμενα που χρειάζονται ώστε αφού ο παίκτης επιλέξει είδος παιχνιδιού να διαλέξει κατηγορία.
 * Δεν αποτελεί ξεχωριστό παράθυρο.
 */
public class CategoriesPick extends JFrame {

	JPanel contentPane;
	JButton button_1;
	GUI g = new GUI();
	set settingswindow = new set();
	int choiceno = 0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					CategoriesPick frame = new CategoriesPick();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/* Ο κατασκευαστής της κλάσης*/

	public CategoriesPick() {
		
		final Classicframe item=new Classicframe();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton_1 = new JButton("Αθλητικά");
		btnNewButton_1.setPreferredSize(new Dimension(550,35));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				choiceno = 1;
				item.GetCat("Athlitika");
				button_1.setEnabled(true);
				
			}
		});
		
		JButton btnNewButton_3 = new JButton("Φαγητά-Ποτά");
		btnNewButton_3.setPreferredSize(new Dimension(550,35));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceno = 3;
				item.GetCat("Fagita_Pota");
				button_1.setEnabled(true);
			}
		});
		
		JButton btnNewButton_4 = new JButton("Ηλ. Παιχνίδια");
		btnNewButton_4.setPreferredSize(new Dimension(550,35));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceno = 4;
				item.GetCat("Games");
				button_1.setEnabled(true);
			}
		});
		
		JButton btnNewButton_5 = new JButton("Γεωγραφία");
		btnNewButton_5.setPreferredSize(new Dimension(550,35));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceno = 5;
				item.GetCat("Geografia");
				button_1.setEnabled(true);
			}
		});
		
		JButton btnNewButton_6 = new JButton("Γλώσσα");
		btnNewButton_6.setPreferredSize(new Dimension(550,35));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceno = 6;
				item.GetCat("Glossa");
				button_1.setEnabled(true);
			}
		});
		
		JButton btnNewButton = new JButton("Ιστορία");
		btnNewButton.setPreferredSize(new Dimension(550,35));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceno = 7;
				item.GetCat("Istoria");
				button_1.setEnabled(true);
			}
		});
		
		JButton btnNewButton_7 = new JButton("Τεχνολογία");
		btnNewButton_7.setPreferredSize(new Dimension(550,35));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceno = 8;
				item.GetCat("Technologia");
				button_1.setEnabled(true);
			}
		});
		
		JButton btnNewButton_8 = new JButton("Τέχνη");
		btnNewButton_8.setPreferredSize(new Dimension(550,35));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceno = 9;
				item.GetCat("Texni");
				button_1.setEnabled(true);
			}
		});
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton button = new JButton("<");
		button.setPreferredSize(new Dimension(100,35));
		button.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				g.backtomenu(g.init,g.panel, settingswindow.x, settingswindow.y);
			}
		});
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("\u0394\u03B9\u03AC\u03BB\u03B5\u03BE\u03B5 \u03BA\u03B1\u03C4\u03B7\u03B3\u03BF\u03C1\u03AF\u03B1!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		contentPane.add(lblNewLabel);
		lblNewLabel.setPreferredSize(new Dimension(400,75));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(btnNewButton_1);
	
		
		JButton btnNewButton_2 = new JButton("Επιστήμη");
		btnNewButton_2.setPreferredSize(new Dimension(550,35));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceno = 2;
				item.GetCat("Epistimi");
				button_1.setEnabled(true);
			}
			
			
		});
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_3);
		contentPane.add(btnNewButton_4);
		contentPane.add(btnNewButton_5);
		contentPane.add(btnNewButton_6);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_7);
		contentPane.add(btnNewButton_8);
		
		button_1 = new JButton("Εκκίνηση");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setEnabled(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.startgame(g.choice);
			}
		});
		contentPane.add(button_1);
		button_1.setPreferredSize(new Dimension(550,35));
		
	}
	

}
