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
            GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Du entdeckst ein " +GUI_project.gui.spiel1.monsterList.get(i).klasse +"." +"\n" +"Willst du kaempfen oder fliehen" +"\n");
            aktuellesMonster = i;
            GUI_project.gui.flhn.setVisible(true);
            GUI_project.gui.kampf.setVisible(true);
        }
    }
    public static void kaempfen()
    {
        if (lebewesen.kampfActive == true)
        {
            GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Du startest den Kampf." +"\n");
            GUI_project.gui.flhn.setVisible(false);
            GUI_project.gui.kampf.setVisible(false);
            battlestep();
        }
    }
    public static void battlestep()
    {   if (lebewesen.kampfActive == true)
        {
            GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Möchtest du mit dem " +GUI_project.gui.spiel1.held.aktuelleWaffe1.name +" oder dem " +GUI_project.gui.spiel1.held.aktuelleWaffe2.name +" angreifen" +"\n");
            GUI_project.gui.angriff1.setVisible(true);
            GUI_project.gui.angriff2.setVisible(true);
        }
     }
    public static void schaden(String pName)
    {
        if (lebewesen.kampfActive == true)
        {
            if (new Random().nextInt(100) >= GUI_project.gui.spiel1.monsterList.get(aktuellesMonster).ausweichen)
            {
                if (new Random().nextInt(100) >= GUI_project.gui.spiel1.held.verfehlen)
            {
            if (pName == GUI_project.gui.spiel1.held.aktuelleWaffe1.name)
            {
                if (new Random().nextInt(100) <= GUI_project.gui.spiel1.held.aktuelleWaffe1.kritChance)
               {
                   GUI_project.gui.spiel1.monsterList.get(aktuellesMonster).leben = GUI_project.gui.spiel1.monsterList.get(aktuellesMonster).leben - GUI_project.gui.spiel1.held.aktuelleWaffe1.kritSchaden;
                GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Du hast eine Schwachstelle getroffen.\nDu hast " +GUI_project.gui.spiel1.held.aktuelleWaffe1.kritSchaden +" Schaden gemacht." +"\n");
                }
                else 
                {
                GUI_project.gui.spiel1.monsterList.get(aktuellesMonster).leben = GUI_project.gui.spiel1.monsterList.get(aktuellesMonster).leben - GUI_project.gui.spiel1.held.aktuelleWaffe1.schaden;
                GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Du hast " + GUI_project.gui.spiel1.held.aktuelleWaffe1.schaden +" Schaden gemacht." +"\n");
            }
            }
            else if (pName == GUI_project.gui.spiel1.held.aktuelleWaffe2.name)
            {
                if (new Random().nextInt(100) <= GUI_project.gui.spiel1.held.aktuelleWaffe1.kritChance)
               {
                   GUI_project.gui.spiel1.monsterList.get(aktuellesMonster).leben = GUI_project.gui.spiel1.monsterList.get(aktuellesMonster).leben - GUI_project.gui.spiel1.held.aktuelleWaffe2.kritSchaden;
                   GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Du hast eine Schwachstelle getroffen.\nDu hast " + GUI_project.gui.spiel1.held.aktuelleWaffe2.kritSchaden +" Schaden gemacht." +"\n"); 
                }
                else
                {
                GUI_project.gui.spiel1.monsterList.get(aktuellesMonster).leben = GUI_project.gui.spiel1.monsterList.get(aktuellesMonster).leben - GUI_project.gui.spiel1.held.aktuelleWaffe2.schaden;
                GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Du hast " +GUI_project.gui.spiel1.held.aktuelleWaffe2.schaden +" Schaden gemacht." +"\n");
            }
        }
            if (GUI_project.gui.spiel1.monsterList.get(aktuellesMonster).leben <= -1)
                {
                    GUI_project.gui.spiel1.monsterList.get(aktuellesMonster).leben = 0;
                }
                GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Dein Gegner hat noch " + spiel.monsterList.get(aktuellesMonster).leben +" Leben." +"\n");
            if (GUI_project.gui.spiel1.monsterList.get(aktuellesMonster).leben == 0)
            {
                GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Du hast das " + spiel.monsterList.get(aktuellesMonster).klasse +" besiegt" +"\n");
                lebewesen.kampfActive = false;
                GUI_project.gui.angriff1.setVisible(false);
                GUI_project.gui.angriff2.setVisible(false);
                GUI_project.gui.spiel1.monsterList.remove(aktuellesMonster);
            }
            
            else
            {
                damagestep();
            }            
        }
        else
        {
            GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Das Monster ist ausgewichen" +"\n");
            damagestep();
        }
    }
    }
    }

    
    public static void damagestep()
    {  
        if (lebewesen.kampfActive == true)
        {
            if (new Random().nextInt(100) >= GUI_project.gui.spiel1.monsterList.get(aktuellesMonster).verfehlen)
            {
                if (new Random().nextInt(100) >= GUI_project.gui.spiel1.held.ausweichen)
            {
            GUI_project.gui.spiel1.held.leben = GUI_project.gui.spiel1.held.leben - GUI_project.gui.spiel1.monsterList.get(aktuellesMonster).schaden;
            if (GUI_project.gui.spiel1.held.leben <= -1)
            {
                GUI_project.gui.spiel1.held.leben = 0;
            }        
            GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Dein Gegner hat " + GUI_project.gui.spiel1.monsterList.get(aktuellesMonster).schaden +" Schaden gemacht. Du hast noch " +GUI_project.gui.spiel1.held.leben +" Leben" +"\n");
            if (GUI_project.gui.spiel1.held.leben == 0)
            {
                GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Game Over" +"\n");
                GUI_project.gui.angriff1.setVisible(false);
                GUI_project.gui.angriff2.setVisible(false);
            }
            else
            {
                battlestep();
            }
        }
        else
        {
            GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Du bist ausgewichen." +"\n");
            battlestep();
        }
     }
       
       else 
       {
           GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Dein Gegner hat dich verfehlt."+"\n");
           battlestep();
        }
    }
    }
}
