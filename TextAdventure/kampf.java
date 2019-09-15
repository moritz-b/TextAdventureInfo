import java.util.LinkedList;
import java.util.*;

public class kampf
{
    //das IndexFeld des aktuellenMonsters
    double w1a;
    double w1v;
    double p1s; // brauchst eigentlich nicht
    public static int aktuellesMonster;
    public static void kampfBeginn(int i)
    {
        if (lebewesen.kampfActive == true)
        {
            System.out.println("Du entdeckst ein " +spiel.monsterList.get(i).klasse +"." +"\n" +"Willst du kaempfen oder fliehen");
            aktuellesMonster = i;
        }
    }
    public static void kaempfen()
    {
        if (lebewesen.kampfActive == true)
        {
            System.out.println("Du startest den Kampf.");
            battlestep();
        }
    }
    public static void battlestep()
    {   if (lebewesen.kampfActive == true)
        {
            System.out.println("Möchtest du mit dem " +spiel.held.aktuelleWaffe1.name +" oder dem " +spiel.held.aktuelleWaffe2.name +" angreifen");
        }
     }
    public static void schaden(String pName)
    {
        if (lebewesen.kampfActive == true)
        {
            if (new Random().nextInt(100) >= spiel.monsterList.get(aktuellesMonster).ausweichen)
            {
                if (new Random().nextInt(100) >= spiel.held.verfehlen)
            {
            if (pName == spiel.held.aktuelleWaffe1.name)
            {
                if (new Random().nextInt(100) <= spiel.held.aktuelleWaffe1.kritChance)
               {
                   spiel.monsterList.get(aktuellesMonster).leben = spiel.monsterList.get(aktuellesMonster).leben - spiel.held.aktuelleWaffe1.kritSchaden;
                System.out.println("Du hast eine Schwachstelle getroffen.\nDu hast " +spiel.held.aktuelleWaffe1.kritSchaden +" Schaden gemacht.");
                }
                else 
                {
                spiel.monsterList.get(aktuellesMonster).leben = spiel.monsterList.get(aktuellesMonster).leben - spiel.held.aktuelleWaffe1.schaden;
                System.out.println("Du hast " +spiel.held.aktuelleWaffe1.schaden +" Schaden gemacht.");
            }
            }
            else if (pName == spiel.held.aktuelleWaffe2.name)
            {
                if (new Random().nextInt(100) <= spiel.held.aktuelleWaffe1.kritChance)
               {
                   spiel.monsterList.get(aktuellesMonster).leben = spiel.monsterList.get(aktuellesMonster).leben - spiel.held.aktuelleWaffe2.kritSchaden;
                System.out.println("Du hast eine Schwachstelle getroffen.\nDu hast " +spiel.held.aktuelleWaffe2.kritSchaden +" Schaden gemacht."); 
                }
                else
                {
                spiel.monsterList.get(aktuellesMonster).leben = spiel.monsterList.get(aktuellesMonster).leben - spiel.held.aktuelleWaffe2.schaden;
                System.out.println("Du hast " +spiel.held.aktuelleWaffe2.schaden +" Schaden gemacht.");
            }
        }
            if (spiel.monsterList.get(aktuellesMonster).leben <= -1)
                {
                    spiel.monsterList.get(aktuellesMonster).leben = 0;
                }
                System.out.println("Dein Gegner hat noch " +spiel.monsterList.get(aktuellesMonster).leben +" Leben." );
            if (spiel.monsterList.get(aktuellesMonster).leben == 0)
            {
                System.out.println("Du hast das " +spiel.monsterList.get(aktuellesMonster).klasse +" besiegt");
                lebewesen.kampfActive = false;
            }
            
            else
            {
                damagestep();
            }
            
        }
        else
        {
            System.out.println("Das Monster ist ausgewichen");
            damagestep();
        }
    }
    }
    }

    
    public static void damagestep()
    {  
        if (lebewesen.kampfActive == true)
        {
            if (new Random().nextInt(100) >= spiel.monsterList.get(aktuellesMonster).verfehlen)
            {
                if (new Random().nextInt(100) >= spiel.held.ausweichen)
            {
            spiel.held.leben = spiel.held.leben - spiel.monsterList.get(aktuellesMonster).schaden;
            if (spiel.held.leben <= -1)
            {
                spiel.held.leben = 0;
            }        
            System.out.println("Dein Gegner hat " +spiel.monsterList.get(aktuellesMonster).schaden +" Schaden gemacht. Du hast noch " +spiel.held.leben +" Leben");
            if (spiel.held.leben == 0)
            {
                System.out.println("Game Over");
            }
            else
            {
                battlestep();
            }
        }
        else
        {
            System.out.println("Du bist ausgewichen.");
            battlestep();
        }
     }
       
       else 
       {
           System.out.println("Dein Gegner hat dich verfehlt.");
           battlestep();
        }
    }
    }
}
