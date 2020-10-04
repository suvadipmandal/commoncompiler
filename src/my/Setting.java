package my;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;

public class Setting extends JFrame {

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
					Setting frame = new Setting();
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
	public Setting() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 873, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabbedPane.setBounds(34, 25, 796, 429);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setToolTipText("General");
		tabbedPane.addTab("Genral", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(25, 23, 260, 68);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"ENGLISH"}));
		comboBox.setBounds(36, 26, 166, 31);
		panel_2.add(comboBox);
		
		JLabel lblLocalization = new JLabel("Localization");
		lblLocalization.setBounds(66, 0, 107, 14);
		panel_2.add(lblLocalization);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(25, 119, 260, 135);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Toolbar");
		lblNewLabel.setBounds(75, 0, 59, 14);
		panel_3.add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(25, 31, 97, 23);
		panel_3.add(chckbxNewCheckBox);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Small icons");
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(25, 57, 109, 23);
		panel_3.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Big icons");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setBounds(25, 83, 109, 23);
		panel_3.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Standard icons");
		rdbtnNewRadioButton_2.setSelected(true);
		rdbtnNewRadioButton_2.setBackground(Color.WHITE);
		rdbtnNewRadioButton_2.setBounds(25, 109, 109, 23);
		panel_3.add(rdbtnNewRadioButton_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(25, 278, 276, 108);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Document List Panel");
		lblNewLabel_1.setBounds(86, 0, 97, 14);
		panel_4.add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Show\r\n");
		chckbxNewCheckBox_1.setBackground(Color.WHITE);
		chckbxNewCheckBox_1.setBounds(29, 40, 97, 23);
		panel_4.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Disable extention column");
		chckbxNewCheckBox_2.setBackground(Color.WHITE);
		chckbxNewCheckBox_2.setBounds(29, 78, 171, 23);
		panel_4.add(chckbxNewCheckBox_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(361, 23, 385, 363);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Tab Bar");
		lblNewLabel_2.setBounds(162, 0, 64, 14);
		panel_5.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Hide");
		chckbxNewCheckBox_3.setBackground(Color.WHITE);
		chckbxNewCheckBox_3.setBounds(21, 32, 97, 23);
		panel_5.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Multi-line");
		chckbxNewCheckBox_4.setBackground(Color.WHITE);
		chckbxNewCheckBox_4.setBounds(21, 70, 97, 23);
		panel_5.add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Vertical");
		chckbxNewCheckBox_5.setBackground(Color.WHITE);
		chckbxNewCheckBox_5.setBounds(21, 110, 97, 23);
		panel_5.add(chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("Reduce");
		chckbxNewCheckBox_6.setSelected(true);
		chckbxNewCheckBox_6.setBackground(Color.WHITE);
		chckbxNewCheckBox_6.setBounds(21, 136, 97, 23);
		panel_5.add(chckbxNewCheckBox_6);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("Lock(no drag and drop)");
		chckbxNewCheckBox_7.setBackground(Color.WHITE);
		chckbxNewCheckBox_7.setBounds(21, 162, 147, 23);
		panel_5.add(chckbxNewCheckBox_7);
		
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox("Darken inactive tabs");
		chckbxNewCheckBox_8.setSelected(true);
		chckbxNewCheckBox_8.setBackground(Color.WHITE);
		chckbxNewCheckBox_8.setBounds(21, 201, 147, 23);
		panel_5.add(chckbxNewCheckBox_8);
		
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox("Draw a coloured bar on active tab");
		chckbxNewCheckBox_9.setSelected(true);
		chckbxNewCheckBox_9.setBackground(Color.WHITE);
		chckbxNewCheckBox_9.setBounds(21, 227, 205, 23);
		panel_5.add(chckbxNewCheckBox_9);
		
		JCheckBox chckbxNewCheckBox_10 = new JCheckBox("Show does button on each tab");
		chckbxNewCheckBox_10.setSelected(true);
		chckbxNewCheckBox_10.setBackground(Color.WHITE);
		chckbxNewCheckBox_10.setBounds(25, 253, 187, 23);
		panel_5.add(chckbxNewCheckBox_10);
		
		JCheckBox chckbxNewCheckBox_11 = new JCheckBox("Double click to does document");
		chckbxNewCheckBox_11.setBackground(Color.WHITE);
		chckbxNewCheckBox_11.setBounds(24, 279, 169, 23);
		panel_5.add(chckbxNewCheckBox_11);
		
		JCheckBox chckbxNewCheckBox_12 = new JCheckBox("Exit on does the last tab");
		chckbxNewCheckBox_12.setBackground(Color.WHITE);
		chckbxNewCheckBox_12.setBounds(21, 305, 147, 23);
		panel_5.add(chckbxNewCheckBox_12);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Edit", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_6.setBounds(22, 11, 190, 60);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Caret Setting");
		lblNewLabel_3.setBounds(53, 0, 82, 18);
		panel_6.add(lblNewLabel_3);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>();
		comboBox_1.setModel(new DefaultComboBoxModel<Object>(new String[] {"1", "2", "3", "4", "5"}));
		comboBox_1.setBounds(10, 29, 159, 20);
		panel_6.add(comboBox_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(22, 82, 161, 202);
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Folder Mergin Style");
		lblNewLabel_4.setBounds(27, 0, 124, 23);
		panel_7.add(lblNewLabel_4);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Simple");
		rdbtnNewRadioButton_3.setBackground(Color.WHITE);
		rdbtnNewRadioButton_3.setBounds(6, 51, 109, 23);
		panel_7.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Order tree");
		rdbtnNewRadioButton_4.setBackground(Color.WHITE);
		rdbtnNewRadioButton_4.setBounds(6, 77, 109, 23);
		panel_7.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Box tree");
		rdbtnNewRadioButton_5.setBackground(Color.WHITE);
		rdbtnNewRadioButton_5.setBounds(6, 103, 109, 23);
		panel_7.add(rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("None");
		rdbtnNewRadioButton_6.setBackground(Color.WHITE);
		rdbtnNewRadioButton_6.setBounds(6, 129, 109, 23);
		panel_7.add(rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("Arrow");
		rdbtnNewRadioButton_7.setBackground(Color.WHITE);
		rdbtnNewRadioButton_7.setBounds(6, 155, 109, 23);
		panel_7.add(rdbtnNewRadioButton_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_8.setBounds(273, 11, 327, 60);
		panel_1.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(131, 0, 46, 14);
		panel_8.add(lblNewLabel_5);
		
		JCheckBox chckbxNewCheckBox_13 = new JCheckBox("New check box");
		chckbxNewCheckBox_13.setBounds(18, 19, 97, 23);
		panel_8.add(chckbxNewCheckBox_13);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(193, 82, 260, 177);
		panel_1.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Vertical Edge Setting");
		lblNewLabel_6.setBounds(81, 0, 140, 14);
		panel_9.add(lblNewLabel_6);
		
		JCheckBox chckbxNewCheckBox_14 = new JCheckBox("Show vertical edge");
		chckbxNewCheckBox_14.setBackground(Color.WHITE);
		chckbxNewCheckBox_14.setBounds(6, 32, 122, 23);
		panel_9.add(chckbxNewCheckBox_14);
		
		JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("Line Mode");
		rdbtnNewRadioButton_8.setBackground(Color.WHITE);
		rdbtnNewRadioButton_8.setBounds(6, 58, 109, 23);
		panel_9.add(rdbtnNewRadioButton_8);
		
		JRadioButton rdbtnNewRadioButton_9 = new JRadioButton("Background mode");
		rdbtnNewRadioButton_9.setBackground(Color.WHITE);
		rdbtnNewRadioButton_9.setBounds(6, 98, 122, 23);
		panel_9.add(rdbtnNewRadioButton_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_10.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_10.setBounds(193, 295, 272, 66);
		panel_1.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Border Width");
		lblNewLabel_7.setBounds(98, 0, 102, 13);
		panel_10.add(lblNewLabel_7);
		
		JComboBox<Object> comboBox_2 = new JComboBox<Object>();
		comboBox_2.setModel(new DefaultComboBoxModel<Object>(new String[] {"5", "6", "8", "10", "12", "14", "16", ""}));
		comboBox_2.setBounds(10, 24, 218, 31);
		panel_10.add(comboBox_2);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		panel_11.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_11.setBounds(521, 82, 190, 148);
		panel_1.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Line Wrap");
		lblNewLabel_8.setBounds(58, 0, 76, 23);
		panel_11.add(lblNewLabel_8);
		
		JRadioButton rdbtnNewRadioButton_10 = new JRadioButton("Default");
		rdbtnNewRadioButton_10.setBackground(Color.WHITE);
		rdbtnNewRadioButton_10.setBounds(6, 47, 109, 23);
		panel_11.add(rdbtnNewRadioButton_10);
		
		JRadioButton rdbtnNewRadioButton_11 = new JRadioButton("Aligend");
		rdbtnNewRadioButton_11.setBackground(Color.WHITE);
		rdbtnNewRadioButton_11.setBounds(6, 73, 109, 23);
		panel_11.add(rdbtnNewRadioButton_11);
		
		JRadioButton rdbtnNewRadioButton_12 = new JRadioButton("Indent");
		rdbtnNewRadioButton_12.setBackground(Color.WHITE);
		rdbtnNewRadioButton_12.setBounds(6, 99, 109, 23);
		panel_11.add(rdbtnNewRadioButton_12);
	}
}
