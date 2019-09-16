import java.util.Random;

public class monster extends lebewesen
{
    protected double verfehlen;
    protected int schaden;
    protected int centerX;
    protected int centerY;
    protected double moves;
    protected int distance;
    
    public monster(int pLeben, int pSchaden, String pKlasse, double pAusweichen, double pVerfehlen, int x, int y, double pMoves)
    {
        super(pKlasse, pLeben, pAusweichen, x, y);
        verfehlen = pVerfehlen;
        schaden = pSchaden;
        centerX = x;
        centerY = y;
        moves = pMoves;
    }
    
    public static void move() {
        for (int i = 0; i < spiel.monsterArray.length; i++) {
            Random rn = new Random();
            Random rn2 = new Random();
            double z = rn.nextDouble();
            double z2 = rn2.nextDouble();
            if (z<=spiel.monsterArray[i].moves) {
                if (z2<0.5) {
                    
                }
            }
        }
    }
}
