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
    private final String[] validCommands = {
        "axt", "katana", "machete", "dolch", "mistgabel", "revolver", "ak47",
        "uzi", "schrotflinte", "granatwerfer", "raketenwerfer", "granate",
        "gehe", "kaempfen", "fliehen", "map", "position", "dreheRechts",
        "fahre", "dreheLinks", "Bauer", "Soldat", "Arzt"
    };
    

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }
    
    public static boolean isNumeric(String aString) {
        try {
            int z = Integer.parseInt(aString);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
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
        isNumeric(aString);
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
