package editor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JProgressBar;

import my.Home;

import java.awt.Window.Type;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Splash {

	private JFrame frame;
	private JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Splash window = new Splash();
		
		int i;
		for(i=0;i<=100;i++)
		{
			window.progressBar.setValue(i);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			window.frame.setVisible(true);
		}
		if(i >= 100)
		{
			Home h=new Home();
			h.frame1.setVisible(true);
			window.frame.dispose();
		}
	}

	/**
	 * Create the application.
	 */
	public Splash() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		frame.setType(Type.POPUP);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds((1366/2)-300,(768/2)-150, 600, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(0, 0, 139));
		progressBar.setValue(0);
		progressBar.setBounds(22, 261, 552, 14);
		frame.getContentPane().add(progressBar);
		
		JLabel lblNewLabel = new JLabel("CoochBehar Government Engineering Collage");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Century", Font.BOLD, 22));
		lblNewLabel.setBounds(33, 30, 518, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CSE 3rd Year");
		lblNewLabel_1.setBounds(468, 90, 75, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblCommonEditor = new JLabel("Common Editor");
		lblCommonEditor.setForeground(new Color(0, 255, 0));
		lblCommonEditor.setFont(new Font("Arial Black", Font.BOLD, 52));
		lblCommonEditor.setBounds(59, 125, 492, 114);
		frame.getContentPane().add(lblCommonEditor);
	}

	
}
