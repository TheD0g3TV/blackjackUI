package cz.zavora.modules;

import java.util.ArrayList;
import java.util.Random;

public class Balíček {
    private ArrayList<Karty> karty;
    public Balíček(){
        this.karty = new ArrayList<Karty>();
    }
    public void vytvoritBalicek(){
        for(Hodnota hodnota : Hodnota.values()){
            this.karty.add(new Karty(hodnota));
        }
    }
    public void michej(){
        ArrayList<Karty> karty2 = new ArrayList<Karty>();
        Random rand = new Random();
        int a = 0;
        int b = this.karty.size();
        for(int i = 0; i < b; i++){
            a = rand.nextInt((this.karty.size()-1)+1);
            karty2.add(this.karty.get(a));
            this.karty.remove(a);
        }
        this.karty = karty2;
    }
    public void vratit(Balíček a){
        int b = this.karty.size();
        for(int i = 0; i<b;i++){
            a.pridej(this.getKarta(i));
        }
        for(int i = 0;i<b;i++){
            this.odeber(0);
        }
    }

    public String toString(){
        String karty = "";
        for(Karty a : this.karty){
            karty = karty + "\n " + a.toString();
        }
        return karty;
    }
    public void odeber(int a){
        this.karty.remove(a);
    }
    public Karty getKarta(int a){
        return this.karty.get(a);
    }
    public void pridej(Karty a){
        this.karty.add(a);
    }
    public void vytahniKartu(Balíček a){
        this.karty.add(a.getKarta(0));
        a.odeber(0);
    }
    public int velikost(){
        return this.karty.size();
    }
    public int getHodnota(){
        int celkem = 0;
        for(Karty a :this.karty){
            switch(a.getHodnota()) {
                case JEDNA:
                    celkem = celkem + 1;
                    break;
                case DVA:
                    celkem = celkem + 2;
                    break;
                case TŘI:
                    celkem = celkem + 3;
                    break;
                case ČTYŘI:
                    celkem = celkem + 4;
                    break;
                case PĚT:
                    celkem = celkem + 5;
                    break;
                case ŠEST:
                    celkem = celkem + 6;
                    break;
                case SEDM:
                    celkem = celkem + 7;
                    break;
                case OSM:
                    celkem = celkem + 8;
                    break;
                case DEVĚT:
                    celkem = celkem + 9;
                    break;
                case DESET:
                    celkem = celkem + 10;
                    break;
                case JEDENÁCT:
                    celkem = celkem + 11;
                    break;

            }
        }
        return celkem;
    }
}
