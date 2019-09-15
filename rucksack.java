import java.util.LinkedList;

public class rucksack
{
    public static LinkedList<fernkampf> inventarFern = new LinkedList();
    public static LinkedList<nahkampf> inventarNah = new LinkedList();
    public static double gewicht = 0;
    public static int x = 0;
    public static String name2;
    public rucksack()
    {        
        inventarFern.add(spiel.held.aktuelleWaffe1); 
        inventarFern.add(fernkampf.ak47);
        inventarNah.add(spiel.held.aktuelleWaffe2);
        inventarNah.add(nahkampf.dolch);
        gewicht = 0;
        for (int i = 0; i < inventarFern.size(); i++)
        {
            gewicht += inventarFern.get(i).gewicht;
        }
        for (int i = 0; i < inventarNah.size(); i++)
        {            
            gewicht += inventarNah.get(i).gewicht;
        }        
        if (gewicht > spiel.held.gewicht)
        {
            System.out.println("Du trägst zu viel mit dir herum");
        }
    }
    public static void ansehen()
    {
        System.out.print("Du besitzt: ");
        int i = 0;
        for (i = 0; i < inventarFern.size(); i++)
        {
             System.out.print(inventarFern.get(i).name +" ");
        }
        for (i = 0; i < inventarNah.size(); i++)
        {
             System.out.print(inventarNah.get(i).name +" ");
        }
        System.out.println("\nDu hast ein gewicht von " +gewicht +" Kg und kannst maximal " +spiel.held.gewicht +" Kg tragen. \nMöchtest du eine Waffe weglegen?");
        System.out.println("Möchtest du eine andere Waffe ausrüsten, gib die unausgerüstete Waffe als zweites an");
    }
    public static void weglegen (String pName)
    {     
        for (int i = 0; i < inventarFern.size(); i++)
            {       
                if(inventarFern.get(i).name.equals(pName))
                {
                    if (inventarFern.size() != 1)
                        {
                            inventarFern.remove(i);
                            System.out.println("Waffe entfernt");
                            if (pName.equals(spiel.held.aktuelleWaffe1.name))                          
                            {
                                spiel.held.aktuelleWaffe1 = inventarFern.getFirst();
                                System.out.println("Ausgerüstete Waffe geändert");
                            }
                        }
                        else 
                        {
                            System.out.println("Du kannst deine letzte Fernkampf Waffe nicht entfernen");
                        }                    
                } 
            }
        for (int i = 0; i < inventarNah.size(); i++)
            {       
                if(inventarNah.get(i).name.equals(pName))
                {
                    if (inventarNah.size() != 1)
                    {
                        inventarNah.remove(i);
                        System.out.println("Waffe entfernt");
                        if(pName.equals(spiel.held.aktuelleWaffe2.name))                            
                            {
                                spiel.held.aktuelleWaffe2 = inventarNah.getFirst();
                            }
                    }
                    else 
                    {
                        System.out.println("Du kannst deine letzte Nahkampf Waffe nicht entfernen");
                    }
                } 
            }   
        
        gewicht = 0;
        for (int i = 0; i < inventarFern.size(); i++)
        {
            gewicht += inventarFern.get(i).gewicht;
        }
        for (int i = 0; i < inventarNah.size(); i++)
        {
            gewicht += inventarNah.get(i).gewicht;
        }
        ansehen();
    }
    public static void tauschen (String pName)
    {
        System.out.println("gib die zu auswechselnde Waffe an");        
        name2 = pName;        
        lebewesen.tauschActive = true;
    }
    public static void tauschen2 (String pName)
    {
            if (spiel.held.aktuelleWaffe1.name.equals(name2))
            {
                for (int i = 0; i < inventarFern.size(); i++)
                {       
                    if(inventarFern.get(i).name.equals(pName))
                    {
                        spiel.held.aktuelleWaffe1 = inventarFern.get(i);
                    } 
                }
            
        }
        
            if (spiel.held.aktuelleWaffe2.name.equals(name2))
            {
                for (int i = 0; i < inventarNah.size(); i++)
                {       
                    if(inventarNah.get(i).name.equals(pName))
                    {
                        spiel.held.aktuelleWaffe2 = inventarNah.get(i);
                    } 
                }
            }
        lebewesen.tauschActive = false;
        if (lebewesen.kampfActive == true)
        {
            kampf.battlestep();
        }
        System.out.println("Waffe gewechselt");
    }
}
