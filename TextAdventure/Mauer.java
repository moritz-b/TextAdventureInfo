public class Mauer extends gegenstand
{

protected int xposition;
protected int yposition;
protected int[] positioning;

public Mauer(int pXposition, int pYposition)
{
    super(pXposition,pYposition);

    positioning[0] = xposition;
    positioning[1] = yposition;
  
}
public void positioning()
{
    Mauer mauer1 = new Mauer(1,2);
    Mauer mauer2 = new Mauer(1,3);
}

}