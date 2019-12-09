import java.util.Scanner;
import java.util.LinkedList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;


public class spiel
{    
    private Scanner reader;   //
    public static menschen held;
    String fileName = "spielstand.txt";
    String line = null;
    private String[] fileContent = new String[3];
    //Ein Array in dem alle Monster gespeichert sind
    public static LinkedList<monster> monsterList = new LinkedList();
    public Date startDate = new Date();
    public long oldTime = 0;
    public rucksack rucksack;
    public static LinkedList<fahrzeuge> fahrzeug = new LinkedList();
    public static LinkedList<Schluessel> schluessel = new LinkedList();
    public static LinkedList<waffen> waffen = new LinkedList<waffen>();
    public spiel(int pName)
    {
        waffen();
        Baum.positioning();
        
        reader = new Scanner(System.in);
        monsterSpawn();
        faehigkeiten.faehigkeiten();
        autoSpawn();
        schluesselSpawn();
        if (pName == 0)
        {
            held = new bauer();
            GUI_project.gui.main_window.setText("Du hast den Bauer gewaehlt.\nIm Radio hörtest du von einem Virus, das die Menschheit bedroht.\nDaraufhin stiegst in den Tornadobunker, der unterhalb deiner Farm ist.\n10 Tag hielst du dich versteckt. \nNachdem du sehr laute Geraeusche von draußen gehört hast und diese leiser wurden,\nverliesst du deinen Bunker.\nDeine Farm war dem Erdboden gleich gemacht worden und um sie herum lagen viele stark\nverweste Leichen.\nEs glich einer Zombieapokalypsse, wie sie immer im Film  gezeigt wurde.\nNun bist du auf der Suche nach Antworten und versuchst Ueberlebende zu finden.\n");
        }
        else if (pName == 1) 
        {
            held = new arzt();
            GUI_project.gui.main_window.setText("Du hast den Arzt gewaehlt.\nWährend deiner Schicht im Krankenhaus hörtest du von einem Virus,\nder die Menschheit befällt.\nAls du sahst, wie lebende Leichen sich durch die Notaufnahme kämpften, nahmst du den\nFahrstuhl in die Karatäneeinrichtung und hast dich eingeschlossen.\n10 Tage lang warteste du bis du nichts mehr hörtest und ernährteste dich von\nErnährungssonden.\nNun bist du auf der Suche nach Überlebenden und vielleicht kannst du ein Gegenmittel\nfür die Zombies entwickeln.\n");
        }
        else if (pName == 2) 
        {
            held = new soldat();
            GUI_project.gui.main_window.setText("Du hast den Soldat gewaehlt.\nSchnell verbreitete sich die Nachricht einer Zombieapokalypse auf deinem Stützpunkt.\nEigentlich wärst du dort sicher, da die gesamte Basis abgeriegelt wurde,\njedoch musstest du den Präsidenten zu den anderen Ministern bringen,\nda dieser während des Ausbruchs deinen Stützpunkt ehrte.\nUm 0 800 solltest du mit einem Apache Kampfhubschrauber abfliegen.\nDas funktionierte auch jedoch verwandelte sich einer der Piloten während dem Flug in einen\nZombie und bracht den Hubschrauber zm Absturz.\nDu bist der einzige Ueberlebende und bist nun auf dem Weg dich zum naechsten\nStuetzpunkt durchzuschlagen.\nVielleicht findest du unterwegs noch weitere Ueberlebende.\n");
        }
        
        if (txtAvailable()) {
            useText();
        } else {
            GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Keine Speicherdatei gefunden" +"\n");
        }
        rucksack = new rucksack();   
        printMapPlayer();
    }

    private void useCommand(String input, menschen held) {
        if (input.equals("map")) {
            printMapPlayer();
        } else if (input.equals(GUI_project.gui.main_window.getText() +"beenden")) {
            writetxt(held.getPos('x'), held.getPos('y'));
            GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Programm beendet, Spielstand gespeichert. \nBis zum nächsten Mal");
            System.exit(1000);
        } else if (input.equals("spielzeit")) {
            GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Du spielst seit " + spielzeit()/3600000 + " Stunde(n), " + (spielzeit()/60000)%60 + " Minute(n) und " + (spielzeit()/1000)%60 + " Sekunde(n)");;
        }
    }
    
    public void testWelt() {
        fill(0, 29, 0, 29, ' ');
        fill(7, 29, 0, 4, '_');
        fill(8, 29, 5, 7, '_');
        fill(9, 29, 8, 8, '_');
        fill(8, 29, 9, 10, '_');
        fill(10, 29, 11, 14, '_');
        fill(8, 15, 15, 16, '_');
        fill(20, 29, 15, 16, '_');
        fill(21, 29, 17, 18, '_');
        fill(7, 14, 17, 18, '_');
        fill(7, 14, 19, 24, '_');
        fill(22, 29, 19, 23, '_');
        fill(21, 29, 24, 24, '_');
        fill(20, 29, 25, 25, '_');
        fill(7, 16, 25, 25, '_');
        fill(7, 29, 26, 26, '_');
        fill(9, 29, 27, 27, '_');
        fill(0, 7, 10, 10, '≈');
        fill(0, 9, 11, 13, '≈');
        build(29, 0, '▢');
        fill(17, 18, 20, 20, '▢');
        for(int i = 0 ; i < GUI_project.gui.spiel1.waffen.size(); i++)
        {
            if(GUI_project.gui.spiel1.waffen.get(i).sichtB == true)
            {
                build(GUI_project.gui.spiel1.waffen.get(i).posX, GUI_project.gui.spiel1.waffen.get(i).posY, 'W');
            }
        }
        for(int i = 0 ; i < GUI_project.gui.spiel1.fahrzeug.size(); i++)
        {
            if(GUI_project.gui.spiel1.fahrzeug.get(i).sichtB == true)
            {
                build(GUI_project.gui.spiel1.fahrzeug.get(i).posX, GUI_project.gui.spiel1.fahrzeug.get(i).posY, 'F');
            }
        }
        for(int i = 0 ; i < Baum.baeume.size(); i++)
        {
            build(Baum.baeume.get(i).posX, Baum.baeume.get(i).posY, 'O');
        }
    }
    
    public void writetxt(int x, int y) {
        try {
            FileWriter fileWriter =
            new FileWriter(fileName);

            BufferedWriter bufferedWriter =
            new BufferedWriter(fileWriter);
            
            bufferedWriter.write("x: " + x);
            bufferedWriter.newLine();
            bufferedWriter.write("y: " + y);
            bufferedWriter.newLine();
            bufferedWriter.write(Long.toString(spielzeit()));
            
            bufferedWriter.close();
        }
        catch(IOException ex) {
            GUI_project.gui.main_window.setText(
                "Fehler beim beschreiben der Datei '"
                + fileName + "'. Error: " + ex);
        }
    }
    
    private boolean txtAvailable() {
        try {
            
            
            FileReader fileReader = 
                new FileReader(fileName);
            
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            int i = 0;
            while((line = bufferedReader.readLine()) != null) {
                fileContent[i] = line;
                i++;
            }
            bufferedReader.close();  
            return true;
        }
        catch(FileNotFoundException ex) {
            return false;                
        }
        catch(IOException ex) {
            return false;
        }
    }
    
    private void useText() {
        try {
            int x = Integer.parseInt(fileContent[0].replaceAll("[x: ]",""));
            int y = Integer.parseInt(fileContent[1].replaceAll("[y: ]",""));
            oldTime = Long.parseLong(fileContent[2].replaceAll("[y: ]",""));
            GUI_project.gui.main_window.setText("Spieldatei erfolgreich ausgelesen: x = " + x + ", y = " + y + ", time = " + oldTime);
            held.setPos(x, y);
        } catch(Exception ex) {
            GUI_project.gui.main_window.setText("Error bei setzen der Position" + ex);
        }
    }
    
    private long spielzeit() {
        Date checkDate = new Date();
        return (checkDate.getTime() - startDate.getTime() + oldTime);
    }        
    
    public void printMapPlayer() {
        testWelt();
        build(GUI_project.gui.spiel1.held.getPos('x'), GUI_project.gui.spiel1.held.getPos('y'), 'P');
    }
    
    public void build(int x, int y, char c) {
        GUI_project.gui.data[y+1][x+1] = "" +c;
    }    
    
    private void fill(int x1, int x2, int y1, int y2, char c) {
        for (int i = x1+1; i <= x2+1; i++) {
            for (int j = y1+1; j <= y2+1; j++) {
                GUI_project.gui.data[j][i] = "" +c;
            }
        }
    }
    
    public void monsterSpawn()
    {
        monsterList.add(new berserkerZombie(2, 0));
    }
    
    public void autoSpawn()
    {
        fahrzeug.add(new fahrzeuge("M",20, 27, 23, 17, false));
        fahrzeug.add(new fahrzeuge("N",17, 28, 4, 0, false));
    }
    
    public void schluesselSpawn()
    {
        schluessel.add(new Schluessel(22, 17, true, 0));
        schluessel.add(new Schluessel(3, 0, true, 1));
    }
    
    public void waffen()
    {
        waffen.add(new nahkampf("mistgabel", 40, 80, 10, 1.5, 150, 1, 0, true));       
        waffen.add(new nahkampf("dolch", 20, 40, 15, 0.4, 200, 28, 28, false));
        waffen.add(new nahkampf("machete", 30, 60, 10, 0.6, 200, 28, 28, false));
        waffen.add(new nahkampf("katana", 35, 70, 10, 0.9, 200, 28, 28, false));
        waffen.add(new nahkampf("axt", 45, 90, 5, 1.25, 150, 29, 29, false));
        waffen.add(new fernkampf("revolver", 75, 150, 7, .7, 300, 30, 30, false));
        waffen.add(new fernkampf("AK47", 20, 50, 40, 3.8, 250, 30, 30, false));
        waffen.add(new fernkampf("UZI", 15, 40, 5, 3, 250, 30, 30, false));
        waffen.add(new fernkampf("Schrotflinte", 200, 300, 2, 3.3, 250, 30, 30, false));
        waffen.add(new fernkampf("Granatwerfer", 150, 150, 0, 3.9, 150, 30, 30, false));
        waffen.add(new fernkampf("Reaketenwerfer", 200, 200, 0, 4.5, 150, 30, 30, false));
    }
}