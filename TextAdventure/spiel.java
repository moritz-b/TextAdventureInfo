import java.util.Scanner;
import java.util.LinkedList;

public class spiel
{    
    private CommandWords commands;  // holds all valid command words
    private Scanner reader;   // source of command input
    public static menschen held;
    private char[][] pos = new char[30][30]; //Der zweidimensionale Array wird hier initialisert
    private boolean gameRunning = true;
    //Ein Array in dem alle Monster gespeichert sind
    public static LinkedList<monster> monsterList = new LinkedList();
    public static Parser parser = new Parser();
    /**
     * Create a parser to read from the terminal window.
     */
    public spiel()
    {        
        
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