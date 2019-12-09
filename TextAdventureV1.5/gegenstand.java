public class gegenstand
{
    int posX;
    int posY;
    boolean sichtB;
    public gegenstand(int pX, int pY, boolean pSichtB)
    {
        posX = pX;
        posY = pY;
        sichtB = pSichtB;
    }
    
    public void setPos(int x, int y)
    {
        posX = x;
        posY = y;
    }
}
