package quiz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.BoxLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import java.awt.CardLayout;

import javax.swing.JLabel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
/* Η κλάση set δημιουργεί νέο παράθυρο διαλόγου που περιέχει ρύθμιση για το επιθυμητό μέγεθος παραθύρου και για τη 
 * μουσική.
 */
public class set extends JDialog {

	boolean play = true;
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	JRadioButton rdbtnSound;
	public JRadioButton rdbtnLowx;

	public int x = 800;
	public int y = 600;
	String res = "Υψηλή";
	public static void main(String[] args) {
		try {
			set dialog = new set();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * δημιουργία του παραθύρου και διαμόρφωση του.
	 */
	
	public set() {
		
		setBounds(100, 100, 166, 209);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		setTitle("ΕΠΙΛΟΓΕΣ");
		
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		{
			JLabel label = new JLabel("");
			contentPanel.add(label);
		}
		{
			JButton okButton = new JButton("OK");
			
			getContentPane().add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					dispose();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}

		}
		{
			getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
			{
				JLabel label = new JLabel("");
				getContentPane().add(label);
			}
			{
				JLabel lblResolution = new JLabel("\u0391\u039D\u0391\u039B\u03A5\u03A3\u0397:");
				lblResolution.setHorizontalAlignment(SwingConstants.CENTER);
				getContentPane().add(lblResolution);
			}
			{
				JLabel label = new JLabel("");
				getContentPane().add(label);
			}
			rdbtnLowx = new JRadioButton(res);
			rdbtnLowx.setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(rdbtnLowx);
			rdbtnLowx.setSelected(false);
			
			{
				JLabel label = new JLabel("");
				getContentPane().add(label);
			}
			contentPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{rdbtnSound}));
			{
				JSeparator separator = new JSeparator();
				getContentPane().add(separator);
			}
			
				
			rdbtnSound = new JRadioButton("Ήχος");
			rdbtnSound.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnSound.setSelected(true);
			getContentPane().add(rdbtnSound);
			{
				JLabel label = new JLabel("");
				getContentPane().add(label);
			}
			
		}
		{
			
		}
		
	}


