package my;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


class ReplaceDialog extends JDialog
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
      Construct the replace dialog box
      @param home the parent frame
      @param text the text area
   */
   public ReplaceDialog(Home home, JTextArea text)
   {
      super();
      this.master = home;
      this.textArea = text;
      JPanel panel1 = new JPanel();
      JPanel panel2 = new JPanel();
      panel1.setLayout(new GridLayout(2,2));
      panel2.setLayout(new GridLayout(1,4));
      JLabel fLabel = new JLabel("Find :");
      JLabel rLabel = new JLabel("Replace w/ :");
      fText = new JTextField(10);
      rText = new JTextField(10);
      box = new JCheckBox("Match Case");
      find = new JButton("Find Next");
      replace = new JButton("Replace");
      replaceAll = new JButton("Replace all");
      close = new JButton("Close");
      panel1.add(fLabel);
      panel1.add(fText);
      panel1.add(rLabel);
      panel1.add(rText);
      panel2.add(find);
      panel2.add(replace);
      panel2.add(replaceAll);
      panel2.add(close);
      findAddListener();
      checkAddListener();
      repAddListener();
      repAllAddListener();
      closeAddListener();
      getContentPane().add(panel1, BorderLayout.NORTH);
      getContentPane().add(box, BorderLayout.CENTER);
      getContentPane().add(panel2, BorderLayout.SOUTH);

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
      Add the listener for find button
   */
   private void findAddListener()
   {
      find.addActionListener(new
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
                     index = 0;
                     init = textArea.getCaretPosition();
                     if(matchCase)
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
   }

   /**
      Add the listener for replace button
   */
   private void repAddListener()
   {
      replace.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               String from = fText.getText();
               if(from != null)
               {
                  String replacer = rText.getText();
                  if(index >= 0 && replacer.length() > 0)
                  {
                     int end = index + from.length();
                     textArea.replaceRange(replacer, index, end);
                     init = textArea.getCaretPosition();
                  }
               }
            }
         });
   }

   /**
      Add the listener for replace all button
   */
   private void repAllAddListener()
   {
      replaceAll.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               String from = fText.getText();
               if(from != null)
               {
                  String tSearch = textArea.getText();
                  String replacer = rText.getText();
                  if(replacer.length() > 0)
                  {
                     if(matchCase)
                        index = tSearch.indexOf(from, init);
                     else
                        index = tSearch.toLowerCase().indexOf(from.toLowerCase(), init);
                     if(index == -1)
                        JOptionPane.showInputDialog(master, "\"" + from + "\"" + " not found ");
                     else
                     {
                        while(index != -1)
                        {
                           int end = index + from.length();
                           textArea.replaceRange(replacer, index, end);
                           init = init + replacer.length() + 1;
                           tSearch = textArea.getText();
                           index = tSearch.indexOf(from, init);
                        }
                     }
                  }
               }
            }
         });
   }

   /**
      Add the listener for match case checkbox
   */
   private void checkAddListener()
   {
      box.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               if(box.isSelected())
                  matchCase = true;
               else
                  matchCase = false;
            }
         });
   }

   /**
      Add the listener for the close button
   */
   private void closeAddListener()
   {
      close.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               setVisible(false);
            }
         });
   }

   /** Thw width of the frame
   */
   public static final int WSIZE = 400;
   /** The height of the frame
   */
   public static final int HSIZE = 120;
   // The parent frame
   private Home master;
   // The textfield containing word to be find/replaced
   private JTextField fText;
   // The textfield containing the replacement word
   private JTextField rText;
   // The text area
   private JTextArea textArea;
   // The check box for case matching
   private JCheckBox box;
   // The find button
   private JButton find;
   // The replace button
   private JButton replace;
   // The replace all button
   private JButton replaceAll;
   // The close button
   private JButton close;
   // Do the case matching search?
   private boolean matchCase;
   // The initial index to search the word from
   private int init;
   // The current index in the text area
   private int index;
}