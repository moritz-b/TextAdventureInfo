public class nahkampf extends waffen
{
    public static nahkampf dolch;
    public static nahkampf mistgabel;
    public static nahkampf machete;
    public static nahkampf katana;
    public static nahkampf axt;
    public nahkampf(String pName, int pSchaden, int pKritSchaden, int pKritChance, double pGewicht, int pHaltbarkeit, int x, int y)
    {
        super(pName, pSchaden, pKritSchaden, pKritChance, pGewicht, pHaltbarkeit, x, y);        
    }
    public static void waffen()
    {
        mistgabel = new nahkampf("mistgabel", 40, 80, 10, 1.5, 150, 1, 0);        
        dolch = new nahkampf("dolch", 20, 40, 15, 0.4, 200, 31, 31);
        machete = new nahkampf("machete", 30, 60, 10, 0.6, 200, 31, 31);
        katana = new nahkampf("katana", 35, 70, 10, 0.9, 200, 31, 31);
        axt = new nahkampf("axt", 45, 90, 5, 1.25, 150, 31, 31);
    }
}
