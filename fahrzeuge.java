public class fahrzeuge
{
    private String name;
    private static int fuel= 16;
    private static boolean autoschluessel;
    
    public fahrzeuge(String pName, int pFuel)
    {
        name = pName;
        fuel = pFuel;
        autoschluessel = true;
    }

    public static void fahre(int xNeu, int yNeu)
    {
        /** Es wird geprüft, ob ein Autoschlüssel vorhanden ist;  
         *  anschließend wird gefragt, wohin der Spieler fahren will.
         *  Danach wird geprüft, ob genug Treibstoff vorhanden ist.
         */ 
        autoschluessel = true;
        if (autoschluessel == true){
            int x = xNeu;
            int y = yNeu;
            if ((Math.abs(xNeu-spiel.held.getPos('x'))+Math.abs(yNeu-spiel.held.getPos('y')))<fuel){
                    fuel= fuel-Math.abs(xNeu-spiel.held.getPos('x'))-Math.abs(yNeu-spiel.held.getPos('y'));
                    spiel.held.setPos(x, y);
                    System.out.println("Du bist zu Position "+x+ "|"+y+" gefahren. Du kannst noch "+fuel+" Felder mit deinem Treibstoff fahren.");
                } else {
                    System.out.println("Du hast nicht genug Treibstoff, um zur gewünschten Position zu fahren. \n Du kannst noch höchstens "+ fuel + " Felder fahren, bevor dein Tank leer ist.");
                    }
                }
            }
    
    public boolean autoSchluesselVorhanden()
    {
        if (autoschluessel == true) {
            return true;
        } else {
            return false;
        }
    }
    
    public void kaufeAuto(){
        fahrzeuge F = new fahrzeuge("M", 10);
    }
}
