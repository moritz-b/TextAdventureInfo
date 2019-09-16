import java.util.Scanner;

public class spiel
{    
    private CommandWords commands;  // holds all valid command words
    private Scanner reader;   // source of command input
    public static menschen held;
    private char[][] pos = new char[10][10]; //Der zweidimensionale Array wird hier initialisert
    private boolean gameRunning = true;
    //Ein Array in dem alle Monster gespeichert sind
    public static monster[] monsterArray = new monster[1];
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
        fill(5, 5, 2, 6, 'x');
        fill(5, 9, 6, 6, 'x');
        build(7, 1, 'g');
        build(7, 5, 's');
        build(2, 9, 't');
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
        build(Held.getPos('x'), Held.getPos('y'), 'o');
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
        monsterArray[0] = new berserkerZombie(1, 0);
    }
}