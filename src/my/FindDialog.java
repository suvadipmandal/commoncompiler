package my;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class FindDialog extends JDialog
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
      Construct the find dialog box
      @param home the parent frame
      @param text the text area
   */
   public FindDialog(Home home, JTextArea text)
   {
      super();
      this.master = home;
      this.textArea = text;
      Container content = getContentPane();
      content.setLayout(new BorderLayout());
      fText = new JTextField(10);
      mCase = new JCheckBox("Match Case");
      fButton = new JButton("Find Next");
      cButton = new JButton("Close");
      JPanel pane1 = new JPanel();
      pane1.add(new JLabel("Find : "));
      pane1.add(fText);
      pane1.add(mCase);
      content.add(pane1, BorderLayout.CENTER);
      JPanel pane2 = new JPanel();
      pane2.setLayout(new GridLayout(1, 2));
      pane2.add(fButton);
      pane2.add(cButton);
      content.add(pane2, BorderLayout.SOUTH);
      addListener();

      setSize(WSIZE, HSIZE);
   }

   /**
      Set the search index to the beginning of the column of the text area
   */
   public void initToZero()
   {
      init = 0;
   }

   /**
      Add needed action listener
   */
   private void addListener()
   {
      mCase.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               if(mCase.isSelected())
                  caseSensitive = true;
               else
                  caseSensitive = false;
            }
         });
      fButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               String sText = fText.getText();
               if(sText != null)
               {
                  String tSearch = textArea.getText();
                  boolean endOfSearch = false;
                  while(!endOfSearch)
                  {
                     int index = 0;
                     if(caseSensitive)
                        index = tSearch.indexOf(sText, init);
                     else
                        index = tSearch.toLowerCase().indexOf(sText.toLowerCase(), init);
                     if(index != -1)
                     {
                        endOfSearch = true;
                        textArea.select(index, index + sText.length());
                        init = textArea.getCaretPosition();
                     }
                     else
                     {
                        endOfSearch = true;
                        JOptionPane.showInputDialog(master, "\"" + sText + "\"" + " not found ");
                     }
                  }
               }
            }
         });

      cButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               setVisible(false);
            }
         });
   }

   /** The width of the frame
   */
   public static final int WSIZE = 300;
   /** The height of the frame
   */
   public static final int HSIZE = 150;
   // The parent frame
   private Home master;
   // index to search from
   private int init;
   // The text area
   private JTextArea textArea;
   // The text to search for
   private JTextField fText;
   // Perform case sensitive search or not
   private JCheckBox mCase;
   // The find button
   private JButton fButton;
   // The close button
   private JButton cButton;
   // Is this case sensitive search
   private boolean caseSensitive;
}
