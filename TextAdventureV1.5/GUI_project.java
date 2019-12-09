import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;


public class GUI_project extends JFrame {

    private JMenuBar menuBar;
    private JButton rueckW;
    private JButton enter;
    private JButton go_fwd;
    private JTextField input;
    public static JTextArea inv;
    private JButton load;
    public JTextArea main_window;
    private JButton quicksave;
    private JButton quit;
    public JButton aufhe;
    public JButton aufhe2;
    private JButton tausch;
    private JButton wegL;
    private JButton show_map;
    private JButton turn_left;
    private JButton turn_rgt;
    public JButton kampf;
    public JButton flhn;
    public JButton fahre;
    public JButton angriff1;
    public JButton angriff2;
    public static JTextArea weapons;
    public static spiel spiel1;
    public static GUI_project gui;
    private static JTable table;
    private static String[] columnNames;
    public static String[][] data;
    private static JPanel contentPane;
    
    //Constructor 
    public GUI_project(){
        columnNames = new String[31];
        data = new String[31][31];
        columnNames[0] = "";
        data[0][0] = "0";
        for(int x = 1; x < 31; x++)
        {
            columnNames[x] = "";
            data[0][x] = "" +x;
        }
        for(int x = 1; x < 31; x++)
        {
            data[x][0] = ""+x;
        }
        
        
        this.setTitle("GUI_project");
        this.setSize(963,631);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(963,631));
        contentPane.setBackground(new Color(192,192,192));


        rueckW = new JButton();
        rueckW.setBounds(5,66,216,35);
        rueckW.setBackground(new Color(214,217,223));
        rueckW.setForeground(new Color(0,0,0));
        rueckW.setEnabled(true);
        rueckW.setFont(new Font("sansserif",0,12));
        rueckW.setText("Gehe rückwärts");
        rueckW.setVisible(true);
        rueckW.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
                spiel1.held.facing = (lebewesen.facing + 2) % 4;
                spiel1.held.gehe();
                spiel1.held.facing = (lebewesen.facing - 2) % 4; 
                spiel1.printMapPlayer();
                table.repaint();
                }
        });
        
        flhn = new JButton();
        flhn.setBounds(7,235,212,35);
        flhn.setBackground(new Color(214,217,223));
        flhn.setForeground(new Color(0,0,0));
        flhn.setEnabled(true);
        flhn.setFont(new Font("sansserif",0,12));
        flhn.setText("fliehen");
        flhn.setVisible(false);
        flhn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
                lebewesen.kampfActive = false;
                spiel1.held.facing = (lebewesen.facing + 2) % 4;
                spiel1.held.gehe();
                spiel1.held.facing = (lebewesen.facing - 2) % 4; 
                gui.main_window.setText("");
                lebewesen.kampfActive = false;
                gui.main_window.setText("Du gehst auf das vorherige Feld zurück" +"\n");
                flhn.setVisible(false);
                kampf.setVisible(false);
                spiel1.printMapPlayer();
                table.repaint();
                }
        });
        
        fahre = new JButton();
        fahre.setBounds(7,235,212,35);
        fahre.setBackground(new Color(214,217,223));
        fahre.setForeground(new Color(0,0,0));
        fahre.setEnabled(true);
        fahre.setFont(new Font("sansserif",0,12));
        fahre.setText("fahre zu");
        fahre.setVisible(false);
        fahre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
                spiel1.held.fahre(input.getText());
                spiel1.printMapPlayer();
                table.repaint();
                }
        });
        
        angriff1 = new JButton();
        angriff1.setBounds(7,235,212,35);
        angriff1.setBackground(new Color(214,217,223));
        angriff1.setForeground(new Color(0,0,0));
        angriff1.setEnabled(true);
        angriff1.setFont(new Font("sansserif",0,12));
        angriff1.setVisible(false);
        angriff1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
                spiel1.held.schaden(spiel1.held.aktuelleWaffe1.name);
                }
        });
        
        angriff2 = new JButton();
        angriff2.setBounds(7,275,212,35);
        angriff2.setBackground(new Color(214,217,223));
        angriff2.setForeground(new Color(0,0,0));
        angriff2.setEnabled(true);
        angriff2.setFont(new Font("sansserif",0,12));
        angriff2.setVisible(false);
        angriff2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
                spiel1.held.schaden(spiel1.held.aktuelleWaffe2.name);
                }
        });
        
        kampf = new JButton();
        kampf.setBounds(7,275,212,35);
        kampf.setBackground(new Color(214,217,223));
        kampf.setForeground(new Color(0,0,0));
        kampf.setEnabled(true);
        kampf.setFont(new Font("sansserif",0,12));
        kampf.setText("kaempfen");
        kampf.setVisible(false);
        kampf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
                lebewesen.kaempfen();
                }
        });
        
        wegL = new JButton();
        wegL.setBounds(748,256,203,35);
        wegL.setBackground(new Color(214,217,223));
        wegL.setForeground(new Color(0,0,0));
        wegL.setEnabled(true);
        wegL.setFont(new Font("sansserif",0,12));
        wegL.setText("Waffe weglegen");
        wegL.setVisible(true);
        wegL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
                spiel1.rucksack.weglegen(input.getText());
                inv.setText("Inventar:");
                for (int i = 0; i < spiel1.rucksack.inventarWaffen.size(); i++)
                {
                    inv.setText(inv.getText() +spiel1.rucksack.inventarWaffen.get(i).name +", ");
                }
                inv.setText(inv.getText() +"\nGewicht: " +spiel1.rucksack.gewicht);
                weapons.setText("Erste Waffe: " +spiel1.held.aktuelleWaffe1.name +"\nZweite Waffe: " +spiel1.held.aktuelleWaffe2.name);
                }
            });
        
        tausch = new JButton();
        tausch.setBounds(748,216,203,35);
        tausch.setBackground(new Color(214,217,223));
        tausch.setForeground(new Color(0,0,0));
        tausch.setEnabled(true);
        tausch.setFont(new Font("sansserif",0,12));
        tausch.setText("Waffe tauschen");
        tausch.setVisible(true);
        tausch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
                spiel1.rucksack.tauschen(input.getText());
                inv.setText("Inventar:");
                for (int i = 0; i < spiel1.rucksack.inventarWaffen.size(); i++)
                {
                    inv.setText(inv.getText() +spiel1.rucksack.inventarWaffen.get(i).name +", ");
                }
                inv.setText(inv.getText() +"\nGewicht: " +spiel1.rucksack.gewicht +" kg");
                weapons.setText("Erste Waffe: " +spiel1.held.aktuelleWaffe1.name +"\nZweite Waffe: " +spiel1.held.aktuelleWaffe2.name);
                }
            });
        
        aufhe = new JButton();
        aufhe.setBounds(748,296,203,35);
        aufhe.setBackground(new Color(214,217,223));
        aufhe.setForeground(new Color(0,0,0));
        aufhe.setEnabled(true);
        aufhe.setFont(new Font("sansserif",0,12));
        aufhe.setText("Waffe aufheben");
        aufhe.setVisible(false);
        aufhe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
                spiel1.rucksack.aufheben2();
                inv.setText("Inventar:");
                for (int i = 0; i < spiel1.rucksack.inventarWaffen.size(); i++)
                {
                    inv.setText(inv.getText() +spiel1.rucksack.inventarWaffen.get(i).name +", ");
                }
                inv.setText(inv.getText() +"\nGewicht: " +spiel1.rucksack.gewicht +" kg");
                weapons.setText("Erste Waffe: " +spiel1.held.aktuelleWaffe1.name +"\nZweite Waffe: " +spiel1.held.aktuelleWaffe2.name);
                }
            });
            
        aufhe2 = new JButton();
        aufhe2.setBounds(748,296,203,35);
        aufhe2.setBackground(new Color(214,217,223));
        aufhe2.setForeground(new Color(0,0,0));
        aufhe2.setEnabled(true);
        aufhe2.setFont(new Font("sansserif",0,12));
        aufhe2.setText("Schluessel aufheben");
        aufhe2.setVisible(false);
        aufhe2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
                spiel1.schluessel.get(Schluessel.getAktuellenSchl()).aufhe2();
                }
            });

        enter = new JButton();
        enter.setBounds(745,550,207,71);
        enter.setBackground(new Color(214,217,223));
        enter.setForeground(new Color(0,0,0));
        enter.setEnabled(true);
        enter.setFont(new Font("sansserif",0,12));
        enter.setText("Enter");
        enter.setVisible(true);

        go_fwd = new JButton();
        go_fwd.setBounds(5,5,216,35);
        go_fwd.setBackground(new Color(214,217,223));
        go_fwd.setForeground(new Color(0,0,0));
        go_fwd.setEnabled(true);
        go_fwd.setFont(new Font("sansserif",0,12));
        go_fwd.setText("Gehe vorwärts");
        go_fwd.setVisible(true);
        go_fwd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
                gui.main_window.setText("");
                spiel1.held.gehe();
                spiel1.printMapPlayer();
                table.repaint();
                }
        });

        input = new JTextField();
        input.setBounds(223,590,520,31);
        input.setBackground(new Color(255,255,255));
        input.setForeground(new Color(0,0,0));
        input.setEnabled(true);
        input.setFont(new Font("sansserif",0,12));
        input.setText("eingabe");
        input.setVisible(true);

        inv = new JTextArea();
        inv.setBounds(748,5,203,124);
        inv.setBackground(new Color(255,255,255));
        inv.setForeground(new Color(0,0,0));
        inv.setEnabled(true);
        inv.setFont(new Font("sansserif",0,12));
        inv.setText("Inventar:");
        inv.setBorder(BorderFactory.createBevelBorder(1));
        inv.setVisible(true);

        load = new JButton();
        load.setBounds(8,453,207,45);
        load.setBackground(new Color(214,217,223));
        load.setForeground(new Color(0,0,0));
        load.setEnabled(true);
        load.setFont(new Font("sansserif",0,12));
        load.setText("Spielstand laden");
        load.setVisible(true);

        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setBounds(223,410,520,170);
        
        main_window = new JTextArea();
        main_window.setBounds(223,410,520,170);
        main_window.setBackground(new Color(255,255,255));
        main_window.setForeground(new Color(0,0,0));
        main_window.setEnabled(true);
        main_window.setFont(new Font("sansserif",0,12));
        main_window.setText("");
        main_window.setBorder(BorderFactory.createBevelBorder(1));
        main_window.setVisible(true);
        scrollPane2.getViewport().add(main_window);
       

        quicksave = new JButton();
        quicksave.setBounds(8,501,207,45);
        quicksave.setBackground(new Color(214,217,223));
        quicksave.setForeground(new Color(0,0,0));
        quicksave.setEnabled(true);
        quicksave.setFont(new Font("sansserif",0,12));
        quicksave.setText("Schnellspeichern");
        quicksave.setVisible(true);
        quicksave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
                spiel1.writetxt(spiel1.held.getPos('x'), spiel1.held.getPos('y'));
                }
        });

        quit = new JButton();
        quit.setBounds(8,549,207,71);
        quit.setBackground(new Color(214,217,223));
        quit.setForeground(new Color(0,0,0));
        quit.setEnabled(true);
        quit.setFont(new Font("sansserif",0,12));
        quit.setText("Speichern & Spiel beenden");
        quit.setVisible(true);
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
                spiel1.writetxt(spiel1.held.getPos('x'), spiel1.held.getPos('y'));
                System.exit(1000);
                }
        });
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(223,5,520,400);
        
        table = new JTable(data,columnNames);
        table.setBounds(223,5,1000,1000);
        table.setBackground(new Color(255,255,255));
        table.setForeground(new Color(0,0,0));
        table.setEnabled(true);
        table.setFont(new Font("sansserif",0,6));
        table.setVisible(true);
        scrollPane.getViewport().add(table);
        
        show_map = new JButton();
        show_map.setBounds(7,133,212,100);
        show_map.setBackground(new Color(214,217,223));
        show_map.setForeground(new Color(0,0,0));
        show_map.setEnabled(true);
        show_map.setFont(new Font("Monospaced",0,12));
        show_map.setText("Karte anzeigen");
        show_map.setVisible(true);
        show_map.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
                 spiel1.printMapPlayer();
                 table.repaint();
                }
        });
     
        
        turn_left = new JButton();
        turn_left.setBounds(5,39,108,27);
        turn_left.setBackground(new Color(214,217,223));
        turn_left.setForeground(new Color(0,0,0));
        turn_left.setEnabled(true);
        turn_left.setFont(new Font("sansserif",0,12));
        turn_left.setText("Drehe Links");
        turn_left.setVisible(true);        
        turn_left.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
                spiel1.held.dreheLinks(); 
            }
        });
        
        turn_rgt = new JButton();
        turn_rgt.setBounds(112,39,108,27);
        turn_rgt.setBackground(new Color(214,217,223));
        turn_rgt.setForeground(new Color(0,0,0));
        turn_rgt.setEnabled(true);
        turn_rgt.setFont(new Font("sansserif",0,12));
        turn_rgt.setText("Drehe Rechts");
        turn_rgt.setVisible(true);
        turn_rgt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            { 
                spiel1.held.dreheRechts(); 
                }
        });
        
        weapons = new JTextArea();
        weapons.setBounds(749,133,203,78);
        weapons.setBackground(new Color(255,255,255));
        weapons.setForeground(new Color(0,0,0));
        weapons.setEnabled(true);
        weapons.setFont(new Font("sansserif",0,12));
        weapons.setText("Erste Waffe\nZweite Waffe");
        weapons.setBorder(BorderFactory.createBevelBorder(1));
        weapons.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(rueckW);
        contentPane.add(enter);
        contentPane.add(go_fwd);
        contentPane.add(input);
        contentPane.add(inv);
        contentPane.add(load);
        contentPane.add(scrollPane2);
        contentPane.add(quicksave);
        contentPane.add(quit);
        contentPane.add(show_map);
        contentPane.add(turn_left);
        contentPane.add(turn_rgt);
        contentPane.add(weapons);
        contentPane.add(tausch);
        contentPane.add(aufhe);
        contentPane.add(wegL);
        contentPane.add(flhn);
        contentPane.add(kampf);
        contentPane.add(angriff1);
        contentPane.add(angriff2);
        contentPane.add(fahre);
        contentPane.add(aufhe2);
        contentPane.add(scrollPane);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //method for generate menu
    public void generateMenu(){
        menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu tools = new JMenu("Tools");
        JMenu help = new JMenu("Help");

        JMenuItem open = new JMenuItem("Open   ");
        JMenuItem save = new JMenuItem("Save   ");
        JMenuItem exit = new JMenuItem("Exit   ");
        JMenuItem preferences = new JMenuItem("Preferences   ");
        JMenuItem about = new JMenuItem("About   ");


        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(exit);
        tools.add(preferences);
        help.add(about);

        menuBar.add(file);
        menuBar.add(tools);
        menuBar.add(help);
    }



     public static void main(String[] args){
        //try {System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");}
        //catch(Exception e){};
        int pChar = JOptionPane.showOptionDialog(null, "Waehle deinen Caracter","Characterwahl",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.WARNING_MESSAGE, null, 
            new String[]{"Bauer", "Arzt", "Soldat"}, "Arzt");
        
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {                
                gui = new GUI_project();
                start(pChar);
            }
        });
    }
    
    public static void start(int pChar)
    {
        spiel1 = new spiel(pChar);
        inv.setText("Inventar:");
        for (int i = 0; i < spiel1.rucksack.inventarWaffen.size(); i++)
        {
            inv.setText(inv.getText() +spiel1.rucksack.inventarWaffen.get(i).name +", ");
        }
        inv.setText(inv.getText() +"\nGewicht: " +spiel1.rucksack.gewicht +" kg");
        GUI_project.gui.weapons.setText("Erste Waffe: " +GUI_project.gui.spiel1.held.aktuelleWaffe1.name +"\nZweite Waffe: " +GUI_project.gui.spiel1.held.aktuelleWaffe2.name);
        GUI_project.gui.angriff1.setText("Angriff mit " +GUI_project.gui.spiel1.held.aktuelleWaffe1.name);
        GUI_project.gui.angriff2.setText("Angriff mit " +GUI_project.gui.spiel1.held.aktuelleWaffe2.name);
    }

}