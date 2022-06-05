package cz.zavora.modules;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Blackjack {
    Balíček balíček;
    Balíček hráč;
    Balíček oponent;
    int prstyHráč;
    int prstyOponent;
    boolean konec;

    public Blackjack() throws InterruptedException {
        start();
    }

    public void start() throws InterruptedException {
        balíček = new Balíček();
        balíček.vytvoritBalicek();
        balíček.michej();
        hráč = new Balíček();
        oponent = new Balíček();
        prstyHráč = 5;
        prstyOponent = 5;
        konec = false;
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (prstyHráč == 0 || prstyOponent == 0) {
                break;
            }
            if (prstyHráč == 5) {
                System.out.println("Hráč má 5 prstů");
            }
            if (prstyHráč >= 2 && prstyHráč <= 4) {
                System.out.println("Hráč má " + prstyHráč + " prsty");
            }
            if (prstyHráč == 1) {
                System.out.println("HRAČ UŽ MÁ JEN JEDEN PRST!!");
            }
            if (prstyOponent == 5) {
                System.out.println("Oponent má 5 prstů");
            }
            if (prstyOponent >= 2 && prstyOponent <= 4) {
                System.out.println("Oponent má " + prstyOponent + " prsty");
            }
            if (prstyOponent == 1) {
                System.out.println("OPONENT UŽ MÁ JEN JEDEN PRST!!");
            }
            hráč.vytahniKartu(balíček);
            hráč.vytahniKartu(balíček);
            oponent.vytahniKartu(balíček);
            oponent.vytahniKartu(balíček);
            while (true) {
                konec = false;
                System.out.println("TVÉ KARTY: " + hráč.toString());
                System.out.println(hráč.getHodnota() + " / 21");
                System.out.println("KARTY OPONENTA: " + oponent.getKarta(0).toString() + " , ? ");
                System.out.println("Vezmeš si další kartu (1), nebo budeš stát (2) ?");
                int odpoved = sc.nextInt();
                if (odpoved == 1) {
                    hráč.vytahniKartu(balíček);
                    if (hráč.getHodnota() > 21) {
                        System.out.println("! KONEC KOLA !\n");
                        System.out.print("VÍTĚZEM SE STÁVÁ: ");
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep((long) 1.5);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep((long) 1.5);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep((long) 1.5);
                        System.out.println("OPONENT!");
                        System.out.println("PŘICHÁZÍŠ O PRST! Hodnota tvých karet přesáhla 21! (" + hráč.getHodnota() + ")");
                        prstyHráč = prstyHráč - 1;
                        konec = true;
                        break;
                    }
                }
                if (odpoved == 2) {
                    break;
                }
            }
            System.out.println("KARTY OPONENTA: " + oponent.toString());
            if (oponent.getHodnota() > hráč.getHodnota() && konec == false) {
                System.out.println("! KONEC KOLA !\n");
                System.out.print("VÍTĚZEM SE STÁVÁ: ");
                System.out.print(".");
                TimeUnit.SECONDS.sleep((long) 1.5);
                System.out.print(".");
                TimeUnit.SECONDS.sleep((long) 1.5);
                System.out.print(".");
                TimeUnit.SECONDS.sleep((long) 1.5);
                System.out.println("OPONENT!");
                System.out.println("PŘICHÁZÍŠ O PRST!");
                prstyHráč = prstyHráč - 1;
            }
            if (oponent.getHodnota() < 17 && konec == false) {
                oponent.vytahniKartu(balíček);
                System.out.println("Oponent vytáhl kartu: " + oponent.getKarta(oponent.velikost() - 1).toString());
            }
            System.out.println("! KONEC KOLA !\n");
            System.out.println("Oponentovi karty měli hodnotu: " + oponent.getHodnota());
            System.out.println("Tvé karty měli hodnotu: " + hráč.getHodnota());
            if (oponent.getHodnota() > 21 && konec == false) {
                System.out.print("VÍTĚZEM SE STÁVÁ: ");
                System.out.print(".");
                TimeUnit.SECONDS.sleep((long) 1.5);
                System.out.print(".");
                TimeUnit.SECONDS.sleep((long) 1.5);
                System.out.print(".");
                TimeUnit.SECONDS.sleep((long) 1.5);
                System.out.println("HRÁČ!");
                System.out.println("OPONENT PŘICHÁZÍ O PRST");
                prstyOponent = prstyOponent - 1;
                konec = true;
            }
            if (hráč.getHodnota() == oponent.getHodnota()) {
                System.out.print("VÍTĚZEM SE STÁVÁ: ");
                System.out.print(".");
                TimeUnit.SECONDS.sleep((long) 1.5);
                System.out.print(".");
                TimeUnit.SECONDS.sleep((long) 1.5);
                System.out.print(".");
                TimeUnit.SECONDS.sleep((long) 1.5);
                System.out.println("REMÍZA");
                konec = true;
            }
            if (hráč.getHodnota() > oponent.getHodnota() && konec == false) {
                System.out.print("VÍTĚZEM SE STÁVÁ: ");
                System.out.print(".");
                TimeUnit.SECONDS.sleep((long) 1.5);
                System.out.print(".");
                TimeUnit.SECONDS.sleep((long) 1.5);
                System.out.print(".");
                TimeUnit.SECONDS.sleep((long) 1.5);
                System.out.println("HRÁČ!");
                System.out.println("OPONENT PŘICHÁZÍ O PRST! Hodnota tvých karet je blíže 21, než oponentovy karty!");
                prstyOponent = prstyOponent - 1;
                konec = true;
            }
            if (hráč.getHodnota() < oponent.getHodnota() && konec == false) {
                System.out.print("VÍTĚZEM SE STÁVÁ: ");
                System.out.print(".");
                TimeUnit.SECONDS.sleep((long) 1.5);
                System.out.print(".");
                TimeUnit.SECONDS.sleep((long) 1.5);
                System.out.print(".");
                TimeUnit.SECONDS.sleep((long) 1.5);
                System.out.println("OPONENT!");
                System.out.println("HRÁČ PŘICHÁZÍ O PRST! Hodnota tvých karet je dál 21, než oponentovy karty!");
                prstyHráč = prstyHráč - 1;
                konec = true;
            }
            hráč.vratit(balíček);
            oponent.vratit(balíček);

        }
        if (prstyHráč == 0) {
            System.out.println("Přišel si o všechny prsty :(");
        }
        if (prstyOponent == 0) {
            if (prstyHráč == 5) {
                System.out.println("GRATULUJI! Jdeš domů se všemi prsty!");
            }
            if (prstyHráč == 4) {
                System.out.println("GRATULUJI! Jdeš domů se čtyřmi prsty!");
            }
            if (prstyHráč == 3) {
                System.out.println("GRATULUJI! Jdeš domů se třemi prsty!");
            }
            if (prstyHráč == 2) {
                System.out.println("GRATULUJI! Jdeš domů se dvěma prsty!");
            }
            if (prstyHráč == 1) {
                System.out.println("GRATULUJI! Jdeš domů s jedním prstem!");
            }
        }
    }

}

