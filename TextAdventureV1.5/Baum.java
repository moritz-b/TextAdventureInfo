import java.util.LinkedList;

public class Baum extends gegenstand
{
    public static LinkedList<Baum> baeume = new LinkedList();


public Baum(int pXposition, int pYposition)
{
    super(pXposition,pYposition, true);

}

public static void positioning()
{
    Baum  baum1 = new Baum(20,0);
    Baum  baum2 = new Baum(16,2);
    Baum  baum3 = new Baum(19,3);
    Baum  baum4 = new Baum(10,4);
  Baum  baum5 = new Baum(20,5);
  Baum  baum6 = new Baum(16,6);
  Baum  baum7 = new Baum(17,7);
  Baum  baum8 = new Baum(20,8);
  Baum  baum9 = new Baum(13,9);
  Baum  baum10 = new Baum(14,10);
  Baum  baum11= new Baum(17,11);
  Baum baum12 = new Baum(25,12);
    Baum    baum13 = new Baum(19,13);
    Baum    baum14 = new Baum(24,14);
    Baum    baum15 = new Baum(7,14);
    Baum    baum16 = new Baum(17,15);
    Baum    baum17 = new Baum(9,16);
    Baum    baum18 = new Baum(12,16);
    Baum    baum19 = new Baum(19,16);
    Baum baum20 = new Baum(10,17);
    Baum    baum21 = new Baum(13,17);
    Baum    baum22 = new Baum(8,18);
    Baum    baum23 = new Baum(23,19);
    Baum    baum24 = new Baum(9,20);
    Baum    baum25 = new Baum(15,21);
   Baum baum26 = new Baum(17,21);
   Baum    baum27 = new Baum(10,22);
   Baum baum28 = new Baum(10,23);
    Baum    baum29 = new Baum(20,23);
    Baum    baum30 = new Baum(19,24);
    Baum    baum31 = new Baum(12,25);
    Baum    baum32 = new Baum(24,25);
    baeume.add(baum1);
    baeume.add(baum2);
    baeume.add(baum3);
    baeume.add(baum4);
    baeume.add(baum5);
    baeume.add(baum6);
    baeume.add(baum7);
    baeume.add(baum8);
    baeume.add(baum9);
    baeume.add(baum10);
    baeume.add(baum11);
    baeume.add(baum12);
    baeume.add(baum13);
    baeume.add(baum14);
    baeume.add(baum15);
    baeume.add(baum16);
    baeume.add(baum17);
    baeume.add(baum18);
    baeume.add(baum19);
    baeume.add(baum20);
    baeume.add(baum21);
    baeume.add(baum23);
    baeume.add(baum22);
    baeume.add(baum24);
    baeume.add(baum25);
    baeume.add(baum26);
    baeume.add(baum27);
    baeume.add(baum28);
    baeume.add(baum29);
    baeume.add(baum30);
    baeume.add(baum31);
    baeume.add(baum32);

}


}