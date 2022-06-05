package cz.zavora.modules;

public class Karty {
    private Hodnota hodnota;
    public Karty(Hodnota hodnota){
        this.hodnota = hodnota;
    }
    public Hodnota getHodnota(){
        return this.hodnota;
    }
    public String toString(){
        return this.hodnota.toString();
    }
}

