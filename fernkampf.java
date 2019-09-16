public class fernkampf extends waffen
{
    public static fernkampf revolver;
    public static fernkampf ak47;
    public static fernkampf uzi;
    public static fernkampf schrotflinte;
    public static fernkampf granatwerfer;
    public static fernkampf raketenwerfer;
    public static fernkampf granate;
    public fernkampf(String pName, int pSchaden, int pKritSchaden, int pKritChance, double pGewicht, int pHaltbarkeit)
    {
        super(pName, pSchaden, pKritSchaden, pKritChance, pGewicht, pHaltbarkeit);
    }
    public static void waffen()
    {
        revolver = new fernkampf("revolver", 75, 225, 7, 700, 300);
        ak47 = new fernkampf("ak47", 20, 60, 7, 3800, 250);
        uzi = new fernkampf("uzi", 15, 45, 5, 300, 250);
        schrotflinte = new fernkampf("schrotflinte", 100, 300, 2, 3300, 250);
        granatwerfer = new fernkampf("granatwerfer", 150, 0, 0, 3900, 150);
        raketenwerfer = new fernkampf("raketenwerfer", 200, 0, 0, 4000, 150);
        granate = new fernkampf("granate", 75, 0, 0, 0, 0);
    }
}
