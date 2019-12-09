public class Schluessel extends gegenstand
{
    private int bezug;
    public Schluessel(int pPosX, int pPosY, boolean pSichtB, int pBezug)
    {
        super(pPosX, pPosY, true);
        bezug = pBezug;
    }

    public int getBezug()
    {
        return bezug;
    }
    
    public void setBezug(int pBezug)
    {
         bezug = pBezug;
    }
    
    public void aufhe2()
    {
        GUI_project.gui.spiel1.fahrzeug.get(GUI_project.gui.spiel1.schluessel.get(getAktuellenSchl()).bezug).setAutoschluessel(true);
        GUI_project.gui.aufhe2.setVisible(false);
        GUI_project.gui.spiel1.schluessel.get(getAktuellenSchl()).sichtB = false;
        GUI_project.gui.main_window.setText(GUI_project.gui.main_window.getText() +"Du hast den Schluessel aufgehoben");
    }
    
    public static int getAktuellenSchl(){
        int schl=0;
        for (int i = 0; i < GUI_project.gui.spiel1.schluessel.size(); i++)
            {
                if ((spiel.held.getPos('x') == GUI_project.gui.spiel1.schluessel.get(i).posX) && (spiel.held.getPos('y') == GUI_project.gui.spiel1.schluessel.get(i).posY)){
                    schl=i;
                }
            }  
        return schl;
    }
}
