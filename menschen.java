public class menschen extends lebewesen
{    
    protected fernkampf aktuelleWaffe1;
    protected nahkampf aktuelleWaffe2;
    protected faehigkeiten aktuelleFaehigkeit;
    protected double gewicht;    
    protected double verfehlen;
    public menschen(fernkampf pAktuelleWaffe1, nahkampf pAktuelleWaffe2, faehigkeiten pFaehigkeit, int pLeben, String pKlasse, double pGewicht, double pAusweichen, double pVerfehlen, int x, int y)
    {
        super(pKlasse, pLeben, pAusweichen, x, y);
        gewicht = pGewicht;        
        aktuelleWaffe1 = pAktuelleWaffe1;
        aktuelleWaffe2 = pAktuelleWaffe2;
        aktuelleFaehigkeit = pFaehigkeit;
        verfehlen = pVerfehlen;
    }
    public void useCommand(String input) {
        if (input.equals("gehe")) {
            this.gehe();
        } else if (input.equals("dreheRechts")) {
                this.dreheRechts();
        } else if (input.equals("dreheLinks")) {
                this.dreheLinks();            
        } else if (input.equals("fliehen")) {
                 this.fliehen();  
        } else if (input.equals("kaempfen")) {
                 this.kaempfen();  
        } else if (input.equals("weglegen")) {
                 this.weglegen();
        } else if (input.equals("revolver")) {
                 this.waffe("revolver");
        } else if (input.equals("ak47")) {
                 this.waffe("ak47");
        } else if (input.equals("uzi")) {
                 this.waffe("uzi");
        } else if (input.equals("schrotflinte")) {
                 this.waffe("schrotflinte");
        } else if (input.equals("raketenwerfer")) {
                 this.waffe("raketenwerfer");
        }else if (input.equals("granatwerfer")) {
                 this.waffe("granatwerfer");
        }else if (input.equals("granate")) {
                 this.waffe("granate");
        } else if (input.equals("axt")) {
                 this.waffe("axt");
        } else if (input.equals("katana")) {
                 this.waffe("katana");
        } else if (input.equals("dolch")) {
                 this.waffe("dolch");
        } else if (input.equals("machete")) {
                 this.waffe("machete");
        } else if (input.equals("mistgabel")) {
                 this.waffe("mistgabel");
        } else if (input.equals("inventar")) {
                 this.inventar();
        }
        else if (input.equals("tauschen")) {
                 this.tauschen();
        }
    }
}
