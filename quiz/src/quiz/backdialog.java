package quiz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
/*� backdialog ��������� �������� �������� ��� ������ 
 * ��� ������ ��� ����� �� ���������� ��� ������ ����� ��� ������ ����� ����������*/
public class backdialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	GUI g = new GUI();
	set s = new set();
	
	public static void main(String[] args) {
		try {
			backdialog dialog = new backdialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * � ������������� ��� ���������� �� �������� ��������
	 */
	public backdialog() {
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPanel.setPreferredSize(new Dimension (430,240));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblNewLabel = new JLabel("<html>������ ���������� �� ����������� ��� ������ �����? <br> ��� ������� ������������ �������� �� ����� </html> ");
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setPreferredSize(new Dimension (430, 60));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("O�");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					Save sav=new Save();
					try {
						sav.WriteNull();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					g.backtomenu(g.init, g.panel, s.x, s.y);
					dispose();}
				});
				buttonPane.setLayout(new BorderLayout(0, 0));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton,BorderLayout.NORTH);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("�����");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton,BorderLayout.SOUTH);
			}
		}
	}

}
