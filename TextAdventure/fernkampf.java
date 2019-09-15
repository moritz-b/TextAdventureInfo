public class fernkampf extends waffen
{
    public static fernkampf revolver;
    public static fernkampf ak47;
    public static fernkampf uzi;
    public static fernkampf schrotflinte;
    public static fernkampf granatwerfer;
    public static fernkampf raketenwerfer;
    public static fernkampf granate;
    public fernkampf(String pName, int pSchaden, int pKritSchaden, int pKritChance, double pGewicht, int pHaltbarkeit, int x, int y)
    {
        super(pName, pSchaden, pKritSchaden, pKritChance, pGewicht, pHaltbarkeit, x, y);
    }
    public static void waffen()
    {
        revolver = new fernkampf("revolver", 75, 225, 7, 0.7, 300, 31, 31);
        ak47 = new fernkampf("ak47", 20, 60, 7, 3.8, 250, 31, 31);
        uzi = new fernkampf("uzi", 15, 45, 5, 3, 250, 31, 31);
        schrotflinte = new fernkampf("schrotflinte", 100, 300, 2, 3.3, 250, 31, 31);
        granatwerfer = new fernkampf("granatwerfer", 150, 0, 0, 3.9, 150, 31, 31);
        raketenwerfer = new fernkampf("raketenwerfer", 200, 0, 0, 4, 150, 31, 31);
        granate = new fernkampf("granate", 75, 0, 0, 0, 0, 31, 31);
    }
}
