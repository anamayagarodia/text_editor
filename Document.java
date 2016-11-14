import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Document extends JFrame implements ActionListener
{
  private JTextArea ta;
  private int count;
  private JMenuBar menuBar;
  private JMenu fileM, editM, viewM;
  private JScrollPane scpane;
  private JMenuItem exitI,cutI,copyI,pasteI,selectI,saveI,loadI,newI,fullScreenI;
  private String pad;
  private JToolBar toolBar;
  public Document()
  {
    super("Document");
    setSize(600,600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container pane = getContentPane();
    pane.setLayout(new BorderLayout());
    
    count = 0;
    pad = " ";
    ta = new JTextArea(); //textarea
    menuBar = new JMenuBar(); //menubar
    fileM = new JMenu("File"); //file menu
    editM = new JMenu("Edit"); //edit menu
    viewM = new JMenu("View"); //view menu
    scpane = new JScrollPane(ta); //adding textarea to scrollpane
    exitI = new JMenuItem("Exit"); //exit option in file menu
    cutI = new JMenuItem("Cut"); //cut option in edit menu
    copyI = new JMenuItem("Copy"); //copy option in edit menu
    pasteI = new JMenuItem("Paste"); //paste option in edit menu
    selectI = new JMenuItem("Select All"); //selectall option in edit menu
    saveI = new JMenuItem("Save"); //save option in file menu
    loadI = new JMenuItem("Load"); //load option in file menu
    newI = new JMenuItem("New"); //new option in file menu
    fullScreenI = new JMenuItem("Enter Full Screen"); //fullscreen option in view menu
    toolBar = new JToolBar(); //toolBar
    
    ta.setLineWrap(true);
    ta.setWrapStyleWord(true);
    
    setJMenuBar(menuBar);
    menuBar.add(fileM);
    menuBar.add(editM);
    menuBar.add(viewM);
    
    fileM.add(newI);
    fileM.add(saveI);
    fileM.add(loadI);
    fileM.add(exitI);
    
    editM.add(cutI);
    editM.add(copyI);
    editM.add(pasteI);
    editM.add(selectI);
    
    viewM.add(fullScreenI);
    
    newI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    saveI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    loadI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
    cutI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
    copyI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
    pasteI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
    selectI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
    fullScreenI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK & ActionEvent.ALT_MASK));
    
    pane.add(scpane, BorderLayout.CENTER);
    pane.add(toolBar,BorderLayout.SOUTH);
    
    newI.addActionListener(this);
    saveI.addActionListener(this);
    loadI.addActionListener(this);
    exitI.addActionListener(this);
    cutI.addActionListener(this);
    copyI.addActionListener(this);
    pasteI.addActionListener(this);
    selectI.addActionListener(this);
    fullScreenI.addActionListener(this);
    
    setVisible(true);
  }
  public void actionPerformed(ActionEvent e)
  {
    JMenuItem choice = (JMenuItem) e.getSource();
    if(choice == saveI)
    {
      // File f1 = new File("
    }
    else if (choice == exitI)
      System.exit(0);
    else if (choice == cutI)
      {
      pad = ta.getSelectedText();
      ta.replaceRange("", ta.getSelectionStart(), ta.getSelectionEnd());
      }
    else if (choice == copyI)
      pad = ta.getSelectedText();
    else if (choice == pasteI)
      ta.insert(pad, ta.getCaretPosition());
    else if (choice == selectI)
      ta.selectAll();
    else if (e.getSource() == fullScreenI)
      {
        // not yet implememnted
      }
      else
      {
        new Document();
      }
  }
  public static void main(String[] args)
  {
    new Document();
  }
}
      
