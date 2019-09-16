public class lebewesen
{
    protected String klasse;
    protected int leben;    
    protected double ausweichen;  
    private int[] pos = new int[2];
    public static int facing = 1; // 0=N, 1=E, 2=S, 3=W
    //Eine Variable, damit beim gehen  nicht dirket ein Kampf stattfindet
    public static boolean kampfActive = false;
    public static boolean tauschActive = false;
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
    
    public void kaempfen() {
        kampf.kaempfen();
    }
    
    public void inventar() {
        rucksack.ansehen();
    }
    
    public void weglegen() {
        String name = Command.secondWord;
        rucksack.weglegen(name);
    }
    
    public void waffe(String waffenName) {
        if(tauschActive != true)
        {
            kampf.schaden(waffenName);
       }
       else 
       {
           rucksack.tauschen2(waffenName);
        }
    }
    
    public void fliehen() {    
            kampfActive = false;
            System.out.println("Du gehst auf das vorherige Feld zurück");
            facing = (facing + 2) % 4;
            gehe();
            facing = (facing - 2) % 4; 
        }    
    
    public void gehe() {
        if (kampfActive == false)
        {
            switch(facing) {
                case 0:
                    if(getPos('y')-1 < 0)
                    {
                        System.out.println("Vor dir ist eine undurchdringlicher Wald");
                    }
                    else
                    {
                        setPos(getPos('x'), getPos('y')-1);
                    }
                    break;
                    case 1:
                    if(getPos('x')+1 > 30)
                    {
                        System.out.println("Vor dir ist eine undurchdringlicher Wald");
                    }
                    else
                    {
                        setPos(getPos('x')+1, getPos('y'));
                    }
                    break;
                    case 2:
                    if(getPos('y')+1 > 30)
                    {
                        System.out.println("Vor dir ist eine undurchdringlicher Wald");
                    }
                    else
                    {
                        setPos(getPos('x'), getPos('y')+1);
                    }
                    break;
                    case 3:
                    if(getPos('x')-1 < 0)
                    {
                        System.out.println("Vor dir ist eine undurchdringlicher Wald");
                    }
                    else
                    {
                        setPos(getPos('x')-1, getPos('y'));
                    }
                    break;             
                }   
                //Es wird geprüft, ob auf dem selben Feld ein Moster ist                
            for (int i = 0; i < spiel.monsterList.size(); i++)
            {
                if((spiel.held.getPos('x') == spiel.monsterList.get(i).getPos('x')) && (spiel.held.getPos('y') == spiel.monsterList.get(i).getPos('y')))
                {
                    kampfActive = true;
                    kampf.kampfBeginn(i);                    
                }
            }
       }
    }
    
    public void tauschen() {
        String name = Command.secondWord;
        rucksack.tauschen(name);
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
