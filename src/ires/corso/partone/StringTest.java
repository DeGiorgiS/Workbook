package ires.corso.partone;

public class StringTest {

    /*
    Scrivere un programma in java che:
    1. accetta in input 3 stringhe (da riga di comando)
    2. verifica che le stringhe siano 3 (esco dicendo, non mi hai dato abbastanza stringhe)
    3. calcola la lunghezza di ciascuna stringa
    4. trova il carattere iniziale e finale di ciascuna stringa
    5. per tutte e 3 le stringhe stampa un report:
    "La stringa ... ha lunghezza ... comincia per ... e finisce per ..."
     */

    public static void main(String[] args){
        //Servono 3 stringhe in input e controllo ce ne siano proprio 3
        System.out.println("Sono necessarie 3 stringhe");
        if (args.length < 3){
            System.out.println("Non hai inserito 3 stringhe");
            //sarebbe da aggiungere un Return oppure la possiblità di reinserire stringhe
        }

        // creo un array dove salvare le lunghezze delle relative String
        int[] lungh = new int[3];
        lungh[0] = args[0].length();
        lungh[1] = args[1].length();
        lungh[2] = args[2].length();

        // creo un array dove salvare le lettere iniziali delle relative String
        char[] iniziale = new char[3];
        iniziale[0] = args[0].charAt(0);
        iniziale[1] = args[1].charAt(0);
        iniziale[2] = args[2].charAt(0);

        // creo un array dove salvare le lettere finali delle relative String
        char[] finale = new char[3];
        finale[0] = args[0].charAt(args[0].length()-1);
        finale[1] = args[1].charAt(args[1].length()-1);
        finale[2] = args[2].charAt(args[2].length()-1);

        // creo una variabile dove salvare la String di report che stampo passo passo (più elegante farlo con ciclo For)
        String report = String.format("La stringa %s ha lunghezza %d comincia per %c e finisce per %c", args[0], lungh[0], iniziale[0], finale[0]);
        System.out.println(report);
        report = String.format("La stringa %s ha lunghezza %d comincia per %c e finisce per %c", args[1], lungh[1], iniziale[1], finale[1]);
        System.out.println(report);
        report = String.format("La stringa %s ha lunghezza %d comincia per %c e finisce per %c", args[2], lungh[2], iniziale[2], finale[2]);
        System.out.println(report);
    }
}
