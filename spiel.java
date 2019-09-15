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
    private CommandWords commands;  //Liste die alle zulässigen Command-wörter enthält
    private Scanner reader;   //
    public static menschen held;
    String fileName = "spielstand.txt";
    String line = null;
    private String[] fileContent = new String[3];
    private char[][] pos = new char[30][30]; //Der zweidimensionale Array wird hier initialisert
    private boolean gameRunning = true;
    //Ein Array in dem alle Monster gespeichert sind
    public static LinkedList<monster> monsterList = new LinkedList();
    public Date startDate = new Date();
    public long oldTime = 0;
    /**
     * Create a parser to read from the terminal window.
     */
    public spiel()
    {        
        Parser parser = new Parser();
        testWelt();
        commands = new CommandWords();
        reader = new Scanner(System.in);
        //Wählen des Spielcharacter durch einen Command
        System.out.println("Wählen Sie ihren Spielcharater: Bauer, Soldat, Arzt"); 
        String character = parser.getCommand().commandWord;
        fernkampf.waffen();
        nahkampf.waffen();
        monsterSpawn();
        faehigkeiten.faehigkeiten();
        if(character.equals("Bauer"))
            {
                System.out.println("Storyline und Auftrag an den Spieler mit dem Bauer");
                held = new bauer();
            }
        else if(character.equals("Soldat"))
            {
                System.out.println("Storyline und Auftrag an den Spieler mit dem Soldat");
                held = new soldat();
            }
        else if(character.equals("Arzt"))
            {
                System.out.println("Storyline und Auftrag an den Spieler mit dem Arzt");
                held = new arzt();
            }
        if (txtAvailable()) {
            useText();
        } else {
            System.out.println("Keine Speicherdatei gefunden");
        }
        rucksack rucksack = new rucksack();   
        while (gameRunning == true) {
            Command command = parser.getCommand();
            System.out.println(command.getCommandWord());
            useCommand(command.getCommandWord() + "", held);
            held.useCommand(command.getCommandWord() + "");
        }
    }

    private void useCommand(String input, menschen held) {
        if (input.equals("map")) {
            printMapPlayer(held);
        } else if (input.equals("beenden")) {
            writetxt(held.getPos('x'), held.getPos('y'));
            System.out.println("Programm beendet, Spielstand gespeichert. \nBis zum nächsten Mal");
            System.exit(1000);
        } else if (input.equals("spielzeit")) {
            System.out.println("Du spielst seit " + spielzeit()/3600000 + " Stunde(n), " + (spielzeit()/60000)%60 + " Minute(n) und " + (spielzeit()/1000)%60 + " Sekunde(n)");;
        }
    }
    
    public void testWelt() {
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
        build(20, 0, 'O');
        build(16, 2, 'O');
        build(19, 3, 'O');
        build(10, 4, 'O');
        build(20, 5, 'O');
        build(16, 6, 'O');
        build(17, 7, 'O');
        build(20, 8, 'O');
        build(13, 9, 'O');
        build(14, 10, 'O');
        build(17, 11, 'O');
        build(25, 12, 'O');
        build(19, 13, 'O');
    }
    
    private void writetxt(int x, int y) {
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
            System.out.println(
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
            System.out.println("Spieldatei erfolgreich ausgelesen: x = " + x + ", y = " + y + ", time = " + oldTime);
            held.setPos(x, y);
        } catch(Exception ex) {
            System.out.println("Error bei setzen der Position" + ex);
        }
    }
    
    private long spielzeit() {
        Date checkDate = new Date();
        return (checkDate.getTime() - startDate.getTime() + oldTime);
    }
    
    private void printMap() {
        for (int i = 0; i < pos[0].length; i++) {
            for (int j = 0; j < pos.length; j++) {
                System.out.print(pos(j,i) + "|");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void printMapPlayer(menschen Held) {
        build(Held.getPos('x'), Held.getPos('y'), 'P');
        for (int i = 0; i < pos[0].length; i++) {
            for (int j = 0; j < pos.length; j++) {
                System.out.print(pos(j,i) + "|");
            }
            System.out.println();
        }
        System.out.println();
        build(Held.getPos('x'), Held.getPos('y'), ' ');
    }
    
    public void build(int x, int y, char c) {
        pos[x][y] = c;
    }
    
    private char pos(int x, int y) {
        if (pos[x][y] == 0) {
            return ' ';
        } else {
            return pos[x][y];
        }
    }
    
    private void fill(int x1, int x2, int y1, int y2, char c) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                build(i, j, c);
            }
        }
    }
    
    public void monsterSpawn()
    {
        monsterList.add(new berserkerZombie(2, 0));
    }
}