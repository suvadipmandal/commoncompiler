package my;


import javax.swing.*;
import java.awt.Dialog.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.undo.UndoManager;



import javax.swing.event.*;

public class Home {
	
	public JFrame frame1;
	 
	UndoManager manager = new UndoManager();
    
	public Home() {
		initialize();
	}
	
	private JPanel CenterPane;
	private JPanel LeftPane;
	private JPanel RightPane;
	private JPanel UpperPanel;
	private JPanel LowerPane;
	private JTabbedPane tabbedPane;
	int i=1;			//file tabbe count
	int resFlag=0;		//resource tab checking flag
	int projFlag=0;		//project file tab checking 
	int fileFlag=0;
	int cFlag=0;		//compiler checking flag
	int javaFlag=0;		//compiler checking flag
	int pythonFlag=0;	//compiler checking flag
	int saveFlag=0;		//saving state checking flag
	private JTextArea textArea;
	private JTextArea textArea_1;

	String filename;
	String filepath;	//set compiling file path
	private JMenuItem mntmSaveAs;
	private JMenuItem mntmClose;
	private JMenuItem mntmPrint;
	private JMenuItem mntmExit;
	private JCheckBoxMenuItem chckbxmntmC;
	private JCheckBoxMenuItem chckbxmntmJava;
	private JCheckBoxMenuItem chckbxmntmPython;
	private JScrollPane scrollPane;
	private JTabbedPane sideTabbedPane;
	private JPanel panel;
	private JFileChooser chooser;
	
	

	
    public void setLangSelection(boolean a,boolean b,boolean c)
    {
    	chckbxmntmC.setSelected(a);  
    	chckbxmntmJava.setSelected(b);
    	chckbxmntmPython.setSelected(c);
    	if(a==true)
    	{
    		cFlag=1;
    		javaFlag=0;
    		pythonFlag=0;
    	}
    	else if(b==true)
    	{
    		cFlag=0;
    		javaFlag=1;
    		pythonFlag=0;
    	}
    	else if(c==true)
    	{
    		cFlag=0;
    		javaFlag=0;
    		pythonFlag=1;
    	}
    }
	
	public class MyFileFilter extends FileFilter
	{
	private String extension;
	private String description;
	////////////////
	public MyFileFilter()
	{
	setExtension(null);
	setDescription(null);
	}
	////////////////
	public MyFileFilter(final String ext, final String desc)
	{
	setExtension(ext);
	setDescription(desc);
	}
	////////////////
	public boolean accept(File f)
	{
	final String filename=f.getName();

	if(	f.isDirectory() || extension==null ||	filename.toUpperCase().endsWith(extension.toUpperCase()))
		return true;
	return false;

	}
	////////////////
	public String getDescription()
	{
	return description;
	}
	////////////////
	public void setDescription(String desc)
	{
	if(desc==null)
		description=new String("All Files(*.*)");
	else
		description=new String(desc);
	}
	////////////////
	public void setExtension(String ext)
	{
	if(ext==null)
		{extension=null;  return;}

	extension=new String(ext).toLowerCase();
	if(!ext.startsWith("."))
		extension="."+extension;
	}
	////////////////
	}
	
	public void saveAs()
	{
		chooser=new JFileChooser();
		chooser.setDialogTitle("Save As File");
		chooser.addChoosableFileFilter(new MyFileFilter(".c" , "C Source Files(*.c)"));
		chooser.addChoosableFileFilter(new MyFileFilter(".java","Java Source Files(*.java)"));
		chooser.addChoosableFileFilter(new MyFileFilter(".py","Python Source Files(*.py)"));
		int result=chooser.showSaveDialog(null);
		if(result==JFileChooser.APPROVE_OPTION)
		{
			String contern=textArea_1.getText();
			File fi = chooser.getSelectedFile();
			FileWriter fw;
			try
			{
				fw= new FileWriter(fi.getPath());
				fw.write(contern);
				fw.flush();
				fw.close();
				extensionChecking(fi.getName());
				filepath=fi.getPath();
				saveFlag=1;
				JOptionPane.showMessageDialog(null,filepath);
			}
			catch(Exception ev)
			{
				JOptionPane.showMessageDialog(null,ev.getMessage());
			}
		}
	}
	
	public void extensionChecking(String text)
	{
		String[] strarray=text.split("\\.");
		String check=strarray[(strarray.length)-1];
		JOptionPane.showMessageDialog(null,check);
		//End split function
		//extension check
		if(new String(check).equals("c") ||new String(check).equals("C"))
		{
			JOptionPane.showMessageDialog(null,"c choose");
			saveFlag=1;
			cFlag=1;
		}
		else if(new String(check).equals("java")||new String(check).equals("JAVA"))
		{
			JOptionPane.showMessageDialog(null,"java choose");
			saveFlag=1;
			javaFlag=1;
		}
		else if(new String(check).equals("py")||new String(check).equals("PY"))
		{
			JOptionPane.showMessageDialog(null,"python choose");
			saveFlag=1;
			pythonFlag=1;
		}
		else
		{
				JOptionPane.showMessageDialog(null,"nothing choose");
				saveFlag=0;
		}
		//checking complite
	}
	
	private void initialize() {
		frame1 = new JFrame();
		frame1.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frame1.setBounds(10, 0,1280,700);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		UpperPanel = new JPanel();
		UpperPanel.setBackground(Color.LIGHT_GRAY);
		UpperPanel.setPreferredSize(new Dimension(10, 50));
		frame1.getContentPane().add(UpperPanel, BorderLayout.NORTH);
		UpperPanel.setLayout(null);
		LeftPane = new JPanel();
		RightPane = new JPanel();
		LowerPane = new JPanel();
		CenterPane = new JPanel();
		
		LeftPane.setPreferredSize(new Dimension(300, 10));
		RightPane.setPreferredSize(new Dimension(300, 10));
		LowerPane.setPreferredSize(new Dimension(10, 25));
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		frame1.getContentPane().add(LeftPane, BorderLayout.WEST);
		frame1.getContentPane().add(CenterPane, BorderLayout.CENTER);
		frame1.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		tabbedPane.addTab("Untitle", null, scrollPane, null);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		frame1.getContentPane().add(RightPane, BorderLayout.EAST);
		RightPane.setLayout(null);
		
		scrollPane=new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(0, 0, 300, 585);
		RightPane.add(scrollPane);
		
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		scrollPane.add(textArea_1);
		scrollPane.setViewportView(textArea_1);
		frame1.getContentPane().add(LowerPane, BorderLayout.SOUTH);
		LeftPane.setLayout(null);
		
		sideTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		sideTabbedPane.setBounds(0, 0, 300, 586);
		LeftPane.add(sideTabbedPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1366, 25);
		UpperPanel.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnNew = new JMenu("New");
		mnFile.add(mnNew);
		
		JMenuItem mntmEmpty = new JMenuItem("Empty ");
		mntmEmpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name="Untitle"+i;
				textArea=new JTextArea();
				textArea.setFont(new java.awt.Font("Miriam Fixed", 0, 13));
				scrollPane=new JScrollPane(textArea);
				scrollPane.setBorder(null);
				tabbedPane.add(scrollPane);
				tabbedPane.addTab(name, null,scrollPane,null);
				tabbedPane.setSelectedIndex(i);
				frame1.setTitle(name);
				fileFlag=0;
				i++;
				setLangSelection(false,false,false);
			}
		});
		mnNew.add(mntmEmpty);
		
		JMenuItem mntmCLanguage = new JMenuItem("C Language");
		mntmCLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name="Untitle"+i+".c";
			textArea=new JTextArea();
			scrollPane=new JScrollPane(textArea);
			scrollPane.setBorder(null);
			tabbedPane.add(scrollPane);
			tabbedPane.addTab(name, null,scrollPane,null);
			tabbedPane.setSelectedIndex(i);
			frame1.setTitle(name);
			fileFlag=0;
			i++;	
			setLangSelection(true,false,false);
			}
		});
		mnNew.add(mntmCLanguage);
		
		JMenuItem mntmJavaLanguage = new JMenuItem("Java Language");
		mntmJavaLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name="Untitle"+i+".java";
				textArea=new JTextArea();
				scrollPane=new JScrollPane(textArea);
				scrollPane.setBorder(null);
				tabbedPane.add(scrollPane);
				tabbedPane.addTab(name, null,scrollPane,null);
				tabbedPane.setSelectedIndex(i);
				fileFlag=0;
				frame1.setTitle(name);
				i++;	
				setLangSelection(false,true,false);	
			}
		});
		mnNew.add(mntmJavaLanguage);
		
		JMenuItem mntmPythonLanguage = new JMenuItem("Python Language");
		mntmPythonLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name="Untitle"+i+".py";
				textArea=new JTextArea();
				scrollPane=new JScrollPane(textArea);
				scrollPane.setBorder(null);
				tabbedPane.add(scrollPane);
				tabbedPane.addTab(name, null,scrollPane,null);
				tabbedPane.setSelectedIndex(i);
				frame1.setTitle(name);
				fileFlag=1;
				i++;
				setLangSelection(false,false,true);
			}
		});
		mnNew.add(mntmPythonLanguage);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				cFlag=0;
				javaFlag=0;
				pythonFlag=0;
				chooser=new JFileChooser();
				chooser.addChoosableFileFilter(new MyFileFilter(".c" , "C Source Files(*.c)"));
				chooser.addChoosableFileFilter(new MyFileFilter(".java","Java Source Files(*.java)"));
				chooser.addChoosableFileFilter(new MyFileFilter(".py","Python Source Files(*.py)"));
				if(chooser.showDialog(frame1,"Select this")==JFileChooser.APPROVE_OPTION)
				filename=chooser.getSelectedFile().getPath();
				frame1.setTitle(filename);
				
				// create split function
				String text=filename;
				String target="\\";
				String replacement="\\\\";
				String str=(String) text;
				str=str.replace(target, replacement);
				String[] strarray=str.split(replacement);
				//End split function
				
				try{  
			        BufferedReader br=new BufferedReader(new FileReader(filename));    
			        String s1="",s2="";                         
			        while((s1=br.readLine())!=null){    
			        s2+=s1+"\n";    
			        }    
			        textArea=new JTextArea();
					scrollPane=new JScrollPane(textArea);
					scrollPane.setBorder(null);
					tabbedPane.add(scrollPane);
					tabbedPane.addTab(strarray[(strarray.length)-1], null,scrollPane,null);
					tabbedPane.setSelectedIndex(i);
					extensionChecking(strarray[(strarray.length)-1]);
			        textArea.setText(s2); 
			        saveFlag=1;
			        br.close();    
			        }catch (Exception ex) {ex.printStackTrace();  }
			}
		});
		mnFile.add(mntmOpen);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAs();
			}
		});
		mnFile.add(mntmSave);
		
		mntmSaveAs = new JMenuItem("Save As");
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {/*
			try {
				Process p=Runtime.getRuntime().exec("cmd /c script\\test.bat");
				InputStream is = p.getInputStream();
				int i=0;
				StringBuffer sb = new StringBuffer();
				while((i = is.read())!=-1)
					sb.append((char)i);
				System.out.println(sb.toString());
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	*/
			
				saveAs();
			}
		});
		mnFile.add(mntmSaveAs);
		JSeparator separator_2 = new JSeparator();
		mnFile.add(separator_2);
		
		mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tabbedPane.removeTabAt(tabbedPane.getSelectedIndex());
			}
		});
		mnFile.add(mntmClose);
		
		mntmPrint = new JMenuItem("Print");
		mntmPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    try {
			        boolean complete = textArea.print();
			        if(complete)
			        {
			        JOptionPane.showMessageDialog(null,"Done printing","Information",JOptionPane.INFORMATION_MESSAGE);
			        }
			        else
			        {
			        JOptionPane.showMessageDialog(null,"Printing !","Printer",JOptionPane.ERROR_MESSAGE);
			        }
			        }
			        catch(PrinterException ev)
			        {
			        JOptionPane.showMessageDialog(null,ev);
			        }	
			}
		});
		
		JMenuItem mntmCloseAll = new JMenuItem("Close All");
		mntmCloseAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tabbedPane.removeAll();
			JTextArea ta=new JTextArea();
			tabbedPane.addTab("Untitle", null,ta,null);
			frame1.setTitle("Untitle");
			cFlag=0;
			javaFlag=0;
			pythonFlag=0;
			saveFlag=0;
			}
		});
		mnFile.add(mntmCloseAll);
		
		JSeparator separator_4 = new JSeparator();
		mnFile.add(separator_4);
		mnFile.add(mntmPrint);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JSeparator separator_3 = new JSeparator();
		mnFile.add(separator_3);
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmUndo = new JMenuItem("Undo");
		mnEdit.add(mntmUndo);
		mntmUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					manager.undo();
				} catch (Exception ex) {
				}
			}
		});
		
		JMenuItem mntmRedo = new JMenuItem("Redo");
		mnEdit.add(mntmRedo);
		mntmRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					manager.redo();
				} catch (Exception ex) {
				}
			}
		});
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent e) {
				manager.addEdit(e.getEdit());
			}
		});
		
		JSeparator separator_5 = new JSeparator();
		mnEdit.add(separator_5);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);
		mntmCut.addActionListener(new
		         ActionListener()
		         {
		            public void actionPerformed(ActionEvent e)
		            {
		               if(textArea.getSelectedText() != null)
		               {
		                  int begin = textArea.getSelectionStart();
		                  int end = textArea.getSelectionEnd();
		                  textArea.replaceRange("", begin, end);
		               }
		            }
		         });
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		mntmCopy.addActionListener(new
		         ActionListener()
		         {
		            public void actionPerformed(ActionEvent e)
		            {
		            	textArea.copy();
		            }
		         });
		
		/* mntmCopy.addActionListener(new
		         ActionListener()
		         {
		            public void actionPerformed(ActionEvent e)
		            {
		               String selText = textArea.getSelectedText();
		               if(selText != null)
		               {
		                  StringSelection text = new StringSelection(selText);
		                  clipBoard.setContents(text, null);
		               }
		            }
		         });*/
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		mntmPaste.addActionListener(new
		         ActionListener()
		         {
		            public void actionPerformed(ActionEvent e)
		            {
		            	textArea.paste();
		            }
		         });
		/*mntmPaste.addActionListener(new
		         ActionListener()
		         {
		            public void actionPerformed(ActionEvent e)
		            {
		               int pos = textArea.getCaretPosition();
		               Transferable contents = clipBoard.getContents(this);
		               if(contents != null)
		               {
		                  try
		                  {
		                     String selText = (String) (contents.getTransferData(DataFlavor.stringFlavor));
		                     textArea.insert(selText, pos);
		                  }
		                  catch(Exception c) {}
		               }
		            }
		         });*/
		
		JMenu mnSearch = new JMenu("Search");
		menuBar.add(mnSearch);
		
		JMenuItem mntmFind = new JMenuItem("Find");
		mnSearch.add(mntmFind);
		  
		     mntmFind.addActionListener(new
		         ActionListener()
		         {
		            @SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e)
		            {
		            	

		            	my.FindDialog findDialog = new FindDialog(Home.this, textArea);
		               findDialog.show();
		            }
		         });
		   



		JMenuItem mntmReplace = new JMenuItem("Replace");
		mnSearch.add(mntmReplace);
		mntmReplace.addActionListener(new
		         ActionListener()
		         {
		            @SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e)
		            {
		               ReplaceDialog repDialog = new ReplaceDialog(Home.this, textArea);
		               repDialog.show();
		            }
		         });
		JMenuItem mntmGoto = new JMenuItem("Goto");
		mnSearch.add(mntmGoto);
		mntmGoto.addActionListener(new
		         ActionListener()
		         {
		           
					public void actionPerformed(ActionEvent e)
		            {
						 if(e.getActionCommand().equals("Goto"))       {
				                String i = JOptionPane.showInputDialog(frame1, "Enter Line Number", "Go To Line", JOptionPane.PLAIN_MESSAGE);
				                if(i!=null)
				                    try { textArea.setCaretPosition(textArea.getLineStartOffset(Integer.valueOf(i)-1));} catch (Exception e1) {}
				            }
		            }
		         });
		JMenu mnView = new JMenu("View");
		mnView.setMinimumSize(new Dimension(0, 1280));
		menuBar.add(mnView);
		
		JMenuItem mntmLogs = new JMenuItem("Logs");
		mnView.add(mntmLogs);
		
		JSeparator separator_6 = new JSeparator();
		mnView.add(separator_6);
		
		JMenuItem mntmResources = new JMenuItem("Resources");
		mntmResources.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(resFlag==0)
				{
				panel = new JPanel();
				sideTabbedPane.addTab("Resources", null, panel, null);	
				resFlag=1;
				}
				else
				{
				sideTabbedPane.removeTabAt(0);
				resFlag=0;
				}
			
			}
		});
		mnView.add(mntmResources);
		
		JMenuItem mntmFiles = new JMenuItem("Files");
		mntmFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fileFlag==0)
				{
				panel = new JPanel();
				sideTabbedPane.addTab("Files", null, panel, null);	
				fileFlag=1;
				}
				else
				{
				sideTabbedPane.removeTabAt(1);
				fileFlag=0;
				}	
			}
		});
		mnView.add(mntmFiles);
		
		JMenuItem mntmProjects = new JMenuItem("Projects");
		mntmProjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(projFlag==0)
				{
				panel = new JPanel();
				sideTabbedPane.addTab("Projects", null, panel, null);	
				projFlag=1;
				}
				else
				{
				sideTabbedPane.removeTabAt(2);
				projFlag=0;
				}
			}
		});
		mnView.add(mntmProjects);
		
		JMenu mnLanguage = new JMenu("Language");
		menuBar.add(mnLanguage);
		
		chckbxmntmC = new JCheckBoxMenuItem("C Language");
		chckbxmntmC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setLangSelection(true,false,false);
			}
		});
		mnLanguage.add(chckbxmntmC);
		
		chckbxmntmJava = new JCheckBoxMenuItem("Java Language");
		chckbxmntmJava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLangSelection(false,true,false);
			}
		});
		mnLanguage.add(chckbxmntmJava);
		
		chckbxmntmPython = new JCheckBoxMenuItem("Python Language");
		chckbxmntmPython.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLangSelection(false,false,true);
			}
		});
		mnLanguage.add(chckbxmntmPython);
		
		JMenu mnBuild = new JMenu("Build");
		menuBar.add(mnBuild);
		
		JMenuItem mntmBuild = new JMenuItem("Build");
		mntmBuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(cFlag==1 && saveFlag==1)
			{
					//JOptionPane.showMessageDialog(null,"c file build");	
					try {
						Process p=Runtime.getRuntime().exec("cmd /c script\\test.bat "+filename);
						InputStream is = p.getInputStream();
						int i=0;
						StringBuffer sb = new StringBuffer();
						while((i = is.read())!=-1)
							sb.append((char)i);
						//System.out.println(sb.toString());
						textArea_1.setText(sb.toString());
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
			else if(javaFlag==1 && saveFlag==1)
			{

					JOptionPane.showMessageDialog(null,"java file build");
					JOptionPane.showMessageDialog(null,filename);

			}
			else if(pythonFlag==1 && saveFlag==1)
			{

					JOptionPane.showMessageDialog(null,"python file build");

			}
			else
			{
				JOptionPane.showMessageDialog(null,"language not select or save file");
			}
			}
		});
		mnBuild.add(mntmBuild);
		
		JMenuItem mntmRun = new JMenuItem("Run");
		mntmRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnBuild.add(mntmRun);
		
		JMenuItem mntmClean = new JMenuItem("Clean");
		mntmClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnBuild.add(mntmClean);
		
		JSeparator separator_7 = new JSeparator();
		mnBuild.add(separator_7);
		
		JMenuItem mntmBuildRun = new JMenuItem("Build & Run");
		mntmBuildRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cFlag==1 && saveFlag==1)
				{
						//JOptionPane.showMessageDialog(null,"c file build");	
						try {
							Process p=Runtime.getRuntime().exec("cmd /c script\\test.bat "+filename);
							InputStream is = p.getInputStream();
							int i=0;
							StringBuffer sb = new StringBuffer();
							while((i = is.read())!=-1)
								sb.append((char)i);
							//System.out.println(sb.toString());
							textArea_1.setText(sb.toString());
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				}
				else if(javaFlag==1 && saveFlag==1)
				{

						JOptionPane.showMessageDialog(null,"java file build");
						JOptionPane.showMessageDialog(null,filename);

				}
				else if(pythonFlag==1 && saveFlag==1)
				{

						JOptionPane.showMessageDialog(null,"python file build");

				}
				else
				{
					JOptionPane.showMessageDialog(null,"language not select or save file");
				}
			}
		});
		mnBuild.add(mntmBuildRun);
		
		JMenu mnSetting = new JMenu("Setting");
		menuBar.add(mnSetting);
		
		JMenuItem mntmPreferances = new JMenuItem("Preferances.");
		mnSetting.add(mntmPreferances);
		mntmPreferances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Setting sec = new Setting();
				sec.setVisible(true);
			}
		});
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmTips = new JMenuItem("Tips");
		mnHelp.add(mntmTips);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				About se = new About();
				se.setVisible(true);
			}
		});
		CenterPane.setLayout(null);

		
	}
}
