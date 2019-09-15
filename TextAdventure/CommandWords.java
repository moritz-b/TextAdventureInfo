/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class CommandWords
{
    // a constant array that holds all valid command words
    private static final String[] validCommands = {
       "tauschen", "inventar", "weglegen", "axt", "katana", "machete", "dolch", "mistgabel", "revolver", "ak47", "uzi", "schrotflinte", "granatwerfer", "raketenwerfer", "granate", "gehe", "kaempfen", "fliehen", "map", "position", "dreheRechts", "dreheLinks", "Bauer", "Soldat", "Arzt"
    };
    

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;        
    }
    
    public String showCommandWords()
    {
        String commands = "";
        for (int i = 0; i < validCommands.length; i++)
        {
         commands = commands + validCommands[i] + ", ";
         if (i == 4 || i == 9)
         {
            commands = commands + "\n";    
         }
        }
        return commands;
    }
}
