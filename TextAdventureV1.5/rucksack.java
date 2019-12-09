import java.util.LinkedList;

public class rucksack
{
    public static LinkedList<waffen> inventarWaffen = new LinkedList();
    public static double gewicht = 0;
    private static int l;
    public rucksack()
    {        
        inventarWaffen.add(GUI_project.gui.spiel1.held.aktuelleWaffe1); 
        inventarWaffen.add(GUI_project.gui.spiel1.held.aktuelleWaffe2);
        gewicht = 0;
        for (int i = 0; i < inventarWaffen.size(); i++)
        {
            gewicht += inventarWaffen.get(i).gewicht;
        }     
        if (gewicht > GUI_project.gui.spiel1.held.gewicht)
        {
            GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Du trägst zu viel mit dir herum");
        }
    }
    
    public static void weglegen (String pName)
    {     
        boolean find = false;
        for (int i = 0; i < inventarWaffen.size(); i++)
            {       
                if(inventarWaffen.get(i).name.equals(pName))
                {
                    if (inventarWaffen.size() > 2)
                        {
                            inventarWaffen.remove(i);
                            GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Waffe entfernt"+"\n");
                            if (pName.equals(GUI_project.spiel1.held.aktuelleWaffe1.name))                          
                            {
                                GUI_project.spiel1.held.aktuelleWaffe1 = inventarWaffen.getFirst();
                                GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Ausgerüstete Waffe geändert" +"\n");
                                GUI_project.gui.angriff1.setText("Angriff mit " +GUI_project.spiel1.held.aktuelleWaffe1.name);
                            }
                            else if (pName.equals(GUI_project.spiel1.held.aktuelleWaffe2.name))                          
                            {
                                GUI_project.spiel1.held.aktuelleWaffe2 = inventarWaffen.getFirst();
                                GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Ausgerüstete Waffe geändert" +"\n");
                                GUI_project.gui.angriff2.setText("Angriff mit " +GUI_project.spiel1.held.aktuelleWaffe2.name);
                            }
                        }
                        else 
                        {
                            GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Du kannst deine letzten 2 Waffen nicht entfernen" +"\n");
                        }  
                    find = true;    
                } 
             }
             if(find == false)
             {
                    GUI_project.gui.main_window.setText("Waffe nicht gefunden" +"\n");
                }
             gewicht = 0;
             for (int i = 0; i < inventarWaffen.size(); i++)
                {
                    gewicht += inventarWaffen.get(i).gewicht;
                }

    }
    
    public static void tauschen (String pNamen)
    {
        String[] namen = new String[2];
        namen = pNamen.split(" ");
        String pName1 = namen[0];        
        String pName2 = namen[1];
            if (GUI_project.gui.spiel1.held.aktuelleWaffe1.name.equals(pName1))
            {
                for (int i = 0; i < inventarWaffen.size(); i++)
                {       
                    if(inventarWaffen.get(i).name.equals(pName2))
                    {
                        GUI_project.spiel1.held.aktuelleWaffe1 = inventarWaffen.get(i);
                        GUI_project.gui.angriff1.setText("Angriff mit " +GUI_project.spiel1.held.aktuelleWaffe1.name +"\n");
                    } 
                }
            
        }
        else if (GUI_project.gui.spiel1.held.aktuelleWaffe2.name.equals(pName1))
            {
                for (int i = 0; i < inventarWaffen.size(); i++)
                {       
                    if(inventarWaffen.get(i).name.equals(pName2))
                    {
                        GUI_project.spiel1.held.aktuelleWaffe2 = inventarWaffen.get(i);
                        GUI_project.gui.angriff2.setText("Angriff mit " +GUI_project.spiel1.held.aktuelleWaffe2.name+"\n");
                    } 
                }
            }
        GUI_project.gui.main_window.setText("Waffe gewechselt"+"\n");
        if (lebewesen.kampfActive == true)
        {
            kampf.battlestep();
        }
       
    }
    public static void aufheben(int i)
    {
        GUI_project.gui.main_window.setText(" Du hast gefunden: " +GUI_project.gui.spiel1.waffen.get(i).name +"\n");
        l = i;
        GUI_project.gui.aufhe.setVisible(true);
        
    }
    public static void aufheben2()
    {
        GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +" Du hast die " +GUI_project.gui.spiel1.waffen.get(l).name +" aufgehoben" +"\n");
        GUI_project.gui.spiel1.rucksack.inventarWaffen.add(GUI_project.gui.spiel1.waffen.get(l));
        GUI_project.gui.spiel1.waffen.get(l).sichtB = false;
        gewicht = 0;
        for (int i = 0; i < inventarWaffen.size(); i++)
        {
            gewicht += inventarWaffen.get(i).gewicht;
        }
    }
    
    
}
