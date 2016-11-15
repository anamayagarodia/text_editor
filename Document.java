import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

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
  private String doc_name;
  private static int doc_count = 0;

  public Document(String document_name)
  {
    super(document_name);
    doc_name = document_name;
    setSize(600,600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    fullScreenI = new JMenuItem("Toggle Full Screen"); //fullscreen option in view menu
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
    fullScreenI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.ALT_MASK));
    exitI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));

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
  public Document()
  {
    super("Untitled"+(++doc_count)+".txt");
    doc_name = "Untitled"+(doc_count)+".txt";
    setSize(600,600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    fullScreenI = new JMenuItem("Toggle Full Screen"); //fullscreen option in view menu
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
    fullScreenI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.ALT_MASK));
    exitI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));

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
  public void loadFromFile(String file_name) throws IOException
  {
    BufferedReader br = new BufferedReader( new FileReader(new File(file_name)));
    String line = br.readLine();
    while( line != null)
    {
      this.ta.insert((line+"\n"), ta.getCaretPosition());
      line = br.readLine();
    }
    doc_name = file_name;
  }
  public void saveToFile() throws IOException
  {
    PrintWriter writer = new PrintWriter(doc_name, "UTF-8");
    writer.println(this.ta.getText());
    writer.close();
  }
  public void actionPerformed(ActionEvent e)
  {
    Scanner in = new Scanner(System.in);
    JMenuItem choice = (JMenuItem) e.getSource();
    try
    {
      if(choice == saveI)
    {
      if (doc_name.equals("Untitled"+(doc_count)+".txt"))
      {
        System.out.print("Save as?");
        doc_name = in.next();
        saveToFile();
        if ((getExtendedState() & Frame.MAXIMIZED_BOTH) != 0) // checks if already full screen
        {
          this.setTitle(doc_name);
          setExtendedState(JFrame.MAXIMIZED_BOTH); // full screen
          setUndecorated(true);
        }
        else
        {
          this.setTitle(doc_name);
        }
      }
      else
      {
        saveToFile();
      }
    }
    else if (choice == exitI)
    {
      dispose();
      doc_count--;
    }
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
    else if (choice == fullScreenI)
      {
        if ((getExtendedState() & Frame.MAXIMIZED_BOTH) != 0) // checks if already full screen
        {
          setSize(600,600);
          setLocationRelativeTo(null);
          setUndecorated(false);
        }
        else
        {
          setExtendedState(JFrame.MAXIMIZED_BOTH); // full screen
          setUndecorated(true);
        }
      }
      else if (choice == newI)
      {
        new Document();
      }
      else if (choice == loadI)
      {
        System.out.print("Enter file name:");
        String file_name = in.next();
        if (doc_name.equals("Untitled"+(doc_count)+".txt"))
        {
          loadFromFile(file_name);
          if ((getExtendedState() & Frame.MAXIMIZED_BOTH) != 0) // checks if already full screen
          {
            this.setTitle(doc_name);
            setExtendedState(JFrame.MAXIMIZED_BOTH); // full screen
            setUndecorated(true);
          }
          else
          {
            this.setTitle(doc_name);
          }
        }
        else
        {
          Document new_doc = new Document(file_name);
          new_doc.loadFromFile(file_name);
        }
      }
      else
      {
        System.err.print("Wrong Option");
      }
    }
    catch(Exception error)
    {
      System.err.print(error);
    }
  }
  public static void main(String[] args)
  {
    new Document();
  }
}
