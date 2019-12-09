import java.util.Random;

public class monster  extends lebewesen
{
    protected double verfehlen;
    protected int schaden;
    private int[] positionY = new int[8];
    private int[] positionX = new int[8];
    protected int centerX;
    protected int centerY;
    protected int aktuellePos;
    public monster(int pLeben, int pSchaden, String pKlasse, double pAusweichen, double pVerfehlen, int x, int y)
    {
        super(pKlasse, pLeben, pAusweichen, x, y);
        verfehlen = pVerfehlen;
        schaden = pSchaden;
    }
    
    public void bewegen(){
        Random rn = new Random();
        double z = rn.nextDouble();
        for(int i = 0 ; i < 3 ; i++)
        {
            positionX[i] = centerX - 1;
            positionY[i] = centerY + 1 - i ;
        }
        positionX[4] = centerX;
        positionY[4] = centerY - 1;
        positionX[5] = centerX + 1;
        positionY[4] = centerY - 1;
        positionX[6] = centerX + 1;
        positionY[6] = centerY;
        positionX[7] = centerX+1;
        positionY[7] = centerY+1;
        if (z<0.5) {
            aktuellePos = aktuellePos++;
        } else {
            aktuellePos = aktuellePos--;   
        }
        if (aktuellePos>8){
            aktuellePos = 0;
        }
        if (aktuellePos<0){
            aktuellePos = 8;
        }
        for(int i = 0 ; i < spiel.monsterList.size(); i++)
        {
                spiel.monsterList.get(i).setPos(positionX[aktuellePos], positionY[aktuellePos]);
        }
    }
}
