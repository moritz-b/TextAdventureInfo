public class menschen extends lebewesen
{    
    protected waffen aktuelleWaffe1;
    protected waffen aktuelleWaffe2;
    protected faehigkeiten aktuelleFaehigkeit;
    protected double gewicht;    
    protected double verfehlen;
    public menschen(waffen pAktuelleWaffe1, waffen pAktuelleWaffe2, faehigkeiten pFaehigkeit, int pLeben, String pKlasse, double pGewicht, double pAusweichen, double pVerfehlen, int x, int y)
    {
        super(pKlasse, pLeben, pAusweichen, x, y);
        gewicht = pGewicht;        
        aktuelleWaffe1 = pAktuelleWaffe1;
        aktuelleWaffe2 = pAktuelleWaffe2;
        aktuelleFaehigkeit = pFaehigkeit;
        verfehlen = pVerfehlen;
    }
}
