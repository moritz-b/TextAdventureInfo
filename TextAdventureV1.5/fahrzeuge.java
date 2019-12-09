import java.util.LinkedList;

public class fahrzeuge extends gegenstand
{
    private String name;
    private int fuel;
    private int fuelMax;
    private boolean autoschluessel;
    
    
    public fahrzeuge(String pName, int pFuel, int pfuelMax, int pPosX, int pPosY, boolean pSchluessel)
    {
        super(pPosX, pPosY, true);
        name = pName;
        fuel = pFuel;
        fuelMax = pfuelMax;
        autoschluessel = pSchluessel;
    }

    public void fahre(int pX, int pY)
    {
        /** Es wird geprüft, ob ein Autoschlüssel vorhanden ist;  
         *  anschließend wird gefragt, wohin der Spieler fahren will.
         *  Danach wird geprüft, ob genug Treibstoff vorhanden ist.
         */ 
        //einsteigen kann glöscht werden, da man ohne auf einem Feld mit dem Auto zu stehen der Button zum fahren nicht erscheint
        int x = pX;
        int y = pY;
        int aktuellesfahrzeug = getAktuellesAuto();
        if (autoschluessel) { 
                    if ((Math.abs(x-GUI_project.gui.spiel1.held.getPos('x'))+Math.abs(y-GUI_project.gui.spiel1.held.getPos('y')))< GUI_project.gui.spiel1.fahrzeug.get(aktuellesfahrzeug).fuel){
                        GUI_project.gui.spiel1.fahrzeug.get(aktuellesfahrzeug).fuel= GUI_project.gui.spiel1.fahrzeug.get(aktuellesfahrzeug).fuel-Math.abs(x-GUI_project.gui.spiel1.held.getPos('x'))-Math.abs(y-GUI_project.gui.spiel1.held.getPos('y'));
                        GUI_project.gui.spiel1.fahrzeug.get(fahrzeuge.getAktuellesAuto()).setPos(x, y);
                        GUI_project.gui.spiel1.held.setPos(x, y);
                        GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Du bist zu Position "+(x+1)+","+(y+1)+" gefahren. Du kannst noch "+ GUI_project.gui.spiel1.fahrzeug.get(aktuellesfahrzeug).fuel+" Felder mit deinem Treibstoff fahren.\n");
                    } else {
                        GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Du hast nicht genug Treibstoff, um zur gewünschten Position zu fahren. \n Du kannst noch höchstens "+ GUI_project.gui.spiel1.fahrzeug.get(aktuellesfahrzeug).fuel + " Felder fahren, bevor dein Tank leer ist.\n");
                    }
        } else {
            GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Du hast keinen Autoschlüssel dabei.\n");
        }
    }
    
    public void kaufeAuto(String pName){
        fahrzeuge F = new fahrzeuge(pName, 20, 30, 17, 8, false);
    }    
    
    //brauchen wir ohne ein/Aussteigen noch aktuelles Auto?
    public static int getAktuellesAuto(){
        int aktuellesFahrzeug=0;
        for (int i = 0; i < GUI_project.gui.spiel1.fahrzeug.size(); i++)
            {
                if ((GUI_project.gui.spiel1.held.getPos('x') == GUI_project.gui.spiel1.fahrzeug.get(i).posX) && (GUI_project.gui.spiel1.held.getPos('y') == GUI_project.gui.spiel1.fahrzeug.get(i).posY)){
                    aktuellesFahrzeug=i;
                }
            }  
        return aktuellesFahrzeug;
    }
    
   
    public boolean autoschluesselVorhanden () {
        return autoschluessel;
    }
    
    public void setAutoschluessel (boolean pValue){
        autoschluessel = pValue;
    }
    
    public int getFuel () {
        return fuel;
    }
    
    public void setFuel (int pValue){
        fuel = pValue;
    }
    
    public void tanken (int pMenge,fahrzeuge pFahrzeug) {
        if ((pMenge+pFahrzeug.fuel)>=pFahrzeug.fuelMax) {
            pFahrzeug.fuel += pMenge;
            GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Du hast "+pMenge+ " getankt und hast jetzt "+pFahrzeug.fuel+" in deinem Tank.\n");
        } else {
            GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"So viel kannst du nicht tanken. Es passen höchstens "+(pFahrzeug.fuelMax-pFahrzeug.fuel)+" in deinen Tank.\n"); 
        }
    }  
}
