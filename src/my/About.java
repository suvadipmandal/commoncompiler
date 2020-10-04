package my;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;

public class About extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public About() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 556, 362);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 191, 216));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Windows");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setIcon(new ImageIcon("F:\\Programs-Windows-icon.png"));
		lblNewLabel.setBounds(30, 11, 416, 108);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 118, 420, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Created by CSE 3rd year student");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(20, 131, 446, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblSuvadipMandal = new JLabel("Suvadip Mandal");
		lblSuvadipMandal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSuvadipMandal.setBounds(20, 182, 189, 25);
		contentPane.add(lblSuvadipMandal);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 154, 510, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("Rabindar Nath Sahu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(20, 212, 165, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblAbhishekKumarRay = new JLabel("Abhishek Kumar Ray");
		lblAbhishekKumarRay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAbhishekKumarRay.setBounds(20, 238, 189, 25);
		contentPane.add(lblAbhishekKumarRay);
		
		JLabel lblMoliMurmu = new JLabel("Moli Murmu");
		lblMoliMurmu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMoliMurmu.setBounds(20, 263, 165, 25);
		contentPane.add(lblMoliMurmu);
		
		JLabel label = new JLabel("34900117001");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(315, 177, 151, 30);
		contentPane.add(label);
		
		JLabel lblNewLabel_3 = new JLabel("34900116056");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(315, 238, 115, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel label_1 = new JLabel("34900116032");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(315, 263, 115, 25);
		contentPane.add(label_1);
	}
}
