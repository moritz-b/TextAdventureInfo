public class waffen extends gegenstand
{
    public String name;
    public int schaden;
    public int kritSchaden;
    public double gewicht;
    public double kritChance;
    public int haltbarkeit;
    
    public waffen(String pName, int pSchaden, int pKritschaden, int pKritChance, double pGewicht, int pHaltbarkeit, int x, int y)
    {
        super( x,  y);
        schaden = pSchaden;
        gewicht = pGewicht;
        haltbarkeit = pHaltbarkeit;
        kritSchaden = pKritschaden;
        kritChance = pKritChance;
        name = pName;
    }
}
