import java.util.LinkedList;

public class waffen extends gegenstand
{
    public String name;
    public int schaden;
    public int kritSchaden;
    public double gewicht;
    public double kritChance;
    public int haltbarkeit;
    public String art;
    
    public waffen(String pName, int pSchaden, int pKritschaden, int pKritChance, double pGewicht, int pHaltbarkeit, int x, int y, boolean pSichtB, String pArt)
    {
        super( x,  y, pSichtB);
        schaden = pSchaden;
        gewicht = pGewicht;
        haltbarkeit = pHaltbarkeit;
        kritSchaden = pKritschaden;
        kritChance = pKritChance;
        name = pName;
        art = pArt;
    }
    
    
}
