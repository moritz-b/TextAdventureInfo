public class lebewesen
{
    protected String klasse;
    protected int leben;    
    protected double ausweichen;  
    private int[] pos = new int[2];
    public static int facing = 1; // 0=N, 1=E, 2=S, 3=W
    //Eine Variable, damit beim gehen  nicht dirket ein Kampf stattfindet
    public static boolean kampfActive = false;
    public lebewesen(String pKlasse, int pLeben, double pAusweichen, int x, int y)
    {
        klasse = pKlasse;
        leben = pLeben;
        ausweichen = pAusweichen;
        setPos(x, y);
    }
    
    public void setPos(int x, int y) {
        pos[0] = x;
        pos[1] = y;
    }
       
    public int getPos(char xy) {
        if (xy == 'x') {
            return pos[0];
        } else {
            return pos[1];
        }
    }
    
    public static void kaempfen() {
        kampf.kaempfen();
    }
    
    public void fahre(String xy) {
        String [] parts = new String[1];
        parts = xy.split(" ");
        if(parts.length > 1)
        {
            String x = parts[0];
            String y = parts[1];
            int x1 = Integer.valueOf(parts[0]);
            int y1 = Integer.valueOf(parts[1]);
            GUI_project.gui.spiel1.fahrzeug.get(fahrzeuge.getAktuellesAuto()).fahre(x1,y1);
            pruefeMonster();
        }
    }
        
    public void schaden(String waffenName) {
            kampf.schaden(waffenName);
    }  
    
    public void gehe() {
       GUI_project.gui.fahre.setVisible(false);
       GUI_project.gui.aufhe.setVisible(false);
       GUI_project.gui.aufhe2.setVisible(false);
        if (kampfActive == false)
        {
            switch(facing) {
                case 0:
                    if(getPos('y')-1 < 0)
                    {
                        GUI_project.gui.main_window.setText("Vor dir ist eine undurchdringlicher Wald");
                    }
                    else
                    {
                        setPos(getPos('x'), getPos('y')-1);
                    }
                    break;
                    case 1:
                    if(getPos('x')+1 > 29)
                    {
                        GUI_project.gui.main_window.setText("Vor dir ist eine undurchdringlicher Wald");
                    }
                    else
                    {
                        setPos(getPos('x')+1, getPos('y'));
                    }
                    break;
                    case 2:
                    if(getPos('y')+1 > 29)
                    {
                        GUI_project.gui.main_window.setText("Vor dir ist eine undurchdringlicher Wald");
                    }
                    else
                    {
                        setPos(getPos('x'), getPos('y')+1);
                    }
                    break;
                    case 3:
                    if(getPos('x')-1 < 0)
                    {
                        GUI_project.gui.main_window.setText("Vor dir ist eine undurchdringlicher Wald");
                    }
                    else
                    {
                        setPos(getPos('x')-1, getPos('y'));
                    }
                    break;             
                }   
            GUI_project.gui.aufhe.setVisible(false);
            pruefeMonster();
            for (int i = 0; i < GUI_project.gui.spiel1.waffen.size(); i++)
            {
                if((GUI_project.gui.spiel1.held.getPos('x') == GUI_project.gui.spiel1.waffen.get(i).posX) && (GUI_project.gui.spiel1.held.getPos('y') == GUI_project.gui.spiel1.waffen.get(i).posY) && (GUI_project.gui.spiel1.waffen.get(i).sichtB == true))
                {
                    rucksack.aufheben(i);
                }
            }
            
            for (int i = 0; i < GUI_project.gui.spiel1.fahrzeug.size(); i++)
            {
                if((GUI_project.gui.spiel1.held.getPos('x') == GUI_project.gui.spiel1.fahrzeug.get(i).posX) && (GUI_project.gui.spiel1.held.getPos('y') == GUI_project.gui.spiel1.fahrzeug.get(i).posY) && (GUI_project.gui.spiel1.fahrzeug.get(i).sichtB == true))
                {
                    GUI_project.gui.main_window.setText("Du hast ein Auto gefunden\n");
                    GUI_project.gui.fahre.setVisible(true);
                }
            }
            
            for (int i = 0; i < GUI_project.gui.spiel1.schluessel.size(); i++)
            {
                if((GUI_project.gui.spiel1.held.getPos('x') == GUI_project.gui.spiel1.schluessel.get(i).posX) && (GUI_project.gui.spiel1.held.getPos('y') == GUI_project.gui.spiel1.schluessel.get(i).posY) && (GUI_project.gui.spiel1.schluessel.get(i).sichtB == true))
                {
                    GUI_project.gui.main_window.setText("Du hast einen Schluessel fuer ein Auto gefunden\n");
                    GUI_project.gui.aufhe2.setVisible(true);
                }
            }
       }
    }
    
    public void pruefeMonster() {
         //Es wird geprüft, ob auf dem selben Feld ein Moster ist   
        for (int i = 0; i < GUI_project.gui.spiel1.monsterList.size(); i++)
            {
                if((GUI_project.gui.spiel1.held.getPos('x') == spiel.monsterList.get(i).getPos('x')) && (GUI_project.gui.spiel1.held.getPos('y') == spiel.monsterList.get(i).getPos('y')))
                {
                    kampfActive = true;
                    kampf.kampfBeginn(i);                    
                }
                //GUI_project.gui.spiel1.monsterList.get(i).bewegen();
            }
    }
    
    public void dreheRechts() {
        facing += 1;
        if (facing == 4) {
            facing = 0;
        }
    }
    
    public void dreheLinks() {
        facing -= 1;
        if (facing == -1) {
            facing = 3;
        }
    }
}
