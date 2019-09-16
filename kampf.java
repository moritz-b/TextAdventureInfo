public class kampf
{
    //das IndexFled des aktuellenMonsters
    public static int aktuellesMonster;
    public static void kampfBeginn(int i)
    {
        System.out.println("Du entdeckst ein " +spiel.monsterArray[i].klasse +"." +"\n" +"Willst du kaempfen oder fliehen?");
        aktuellesMonster = i;
    }
    public static void kaempfen()
    {
        System.out.println("Du startest den Kampf.");
        battlestep();
    }
    public static void battlestep()
    {
         System.out.println("Möchtest du mit dem " +spiel.held.aktuelleWaffe1.name +" oder dem " +spiel.held.aktuelleWaffe2.name +" angreifen?");
    }
    public static void schaden(String pName)
    {
        if (pName == spiel.held.aktuelleWaffe1.name)
        {
            spiel.monsterArray[aktuellesMonster].leben = spiel.monsterArray[aktuellesMonster].leben - spiel.held.aktuelleWaffe1.schaden;
            if (spiel.monsterArray[aktuellesMonster].leben <= -1)
            {
                spiel.monsterArray[aktuellesMonster].leben = 0;
            }
            System.out.println("Du hast " +spiel.held.aktuelleWaffe1.schaden +" Schaden gemacht. Dein Gegner hat noch " +spiel.monsterArray[aktuellesMonster].leben +" Leben." );
        }
        else if (pName == spiel.held.aktuelleWaffe2.name)
        {
            spiel.monsterArray[aktuellesMonster].leben = spiel.monsterArray[aktuellesMonster].leben - spiel.held.aktuelleWaffe2.schaden;
            if (spiel.monsterArray[aktuellesMonster].leben <= -1)
            {
                spiel.monsterArray[aktuellesMonster].leben = 0;
            }
            System.out.println("Du hast " +spiel.held.aktuelleWaffe2.schaden +" Schaden gemacht. Dein Gegner hat noch " +spiel.monsterArray[aktuellesMonster].leben +" Leben." );
        }
        if (spiel.monsterArray[aktuellesMonster].leben == 0)
        {
            System.out.println("Du hast das " +spiel.monsterArray[aktuellesMonster].klasse +" besiegt");
        }
        else
        {
            damagestep();
        }
    }
    public static void damagestep()
    {
        spiel.held.leben = spiel.held.leben - spiel.monsterArray[aktuellesMonster].schaden;
        if (spiel.held.leben <= -1)
        {
            spiel.held.leben = 0;
        }        
        System.out.println("Dein Gegner hat " +spiel.monsterArray[aktuellesMonster].schaden +" Schaden gemacht. Du hast noch " +spiel.held.leben +" Leben");
        if (spiel.held.leben == 0)
        {
            System.out.println("Game Over");
        }
        else
        {
            battlestep();
        }
    }
}
