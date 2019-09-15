public class monster  extends lebewesen
{
    protected double verfehlen;
    protected int schaden;
    public monster(int pLeben, int pSchaden, String pKlasse, double pAusweichen, double pVerfehlen, int x, int y)
    {
        super(pKlasse, pLeben, pAusweichen, x, y);
        verfehlen = pVerfehlen;
        schaden = pSchaden;
    }
}
