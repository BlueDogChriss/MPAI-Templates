package presenter;

import model.Solicitare;
import view.View;

import java.io.*;
import java.util.Scanner;

public class Presenter {
    private View view;
    private static Scanner scanner= new Scanner(System.in);
    public Presenter(View view){
        super();
        this.view= view;
    }

    public void showOptiuni(){
        System.out.println(view.optiuni);
    }

    public void showStariSolicitare(){
        System.out.println(view.stareComanda);
        System.out.println();
    }
    public String citesteConsola() {

        return scanner.nextLine();
    }

    public Solicitare filtrareComaneziID(int nr){
        for(Solicitare solicitare : view.Solicitari){
            if (solicitare.getId()==nr){
                return solicitare;
            }
        }
        return null;
    }

    public void procesareStare(int number, String option) {
        Solicitare solicitare = filtrareComaneziID(number);
        if (solicitare != null) {
            switch (option) {
                case "1":
                    solicitare.solicitareAcceptata();
                    break;
                case "2":
                    solicitare.solicitareInAnaliza();
                    break;
                case "3":
                    solicitare.solicitareRespinsa();
                    break;
                case "4":
                    solicitare.solicitareVineEchipaj();
                    break;
                default:
                    System.out.println("Va rugam alegeti o optiune vlida!");
                    break;
            }
        } else {
            System.out.println("reclamatia nu exista!");
        }}


        public void procesareMeniu(String option) {
            switch (option) {
                case "1":
                    for (Solicitare solicitare1 : view.Solicitari) {
                        System.out.println(solicitare1.toString() + "\n");
                    }

                    System.out.println("\n");
//                    citireFisier();
                    System.out.println("\n---------------------------------------------------\n");
                    break;
                case "2":
                    System.out.println("Numar solicitare:\n");
                    int nrObiect = Integer.parseInt(citesteConsola());
                   Solicitare solicitare2 = filtrareComaneziID(nrObiect);
                    if (solicitare2!= null) {
                        System.out.println(solicitare2.toString());
                    } else {
                        System.out.println("Nu exista");
                    }
                    break;
                case "3":
                System.out.println("Numar solicitare:\n");
                int numar = Integer.parseInt(citesteConsola());
                showStariSolicitare();
                String stare = citesteConsola();
                procesareStare(numar, stare);
                    System.out.println("Stare schimbata la "+ stare);
                break;

                default:
                    System.out.println("Optiunea nu exista");
                    break;
            }
        }



//    public static void citireFisier(){
//        try {
//            File file = new File("solicitari.txt");
//            Scanner scannerLocal = new Scanner(file);
//            while (scannerLocal.hasNextLine()) {
//                String dataPreluata = scannerLocal.nextLine();
//                System.out.println(dataPreluata);
//            }
//            scannerLocal.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("Am intampinat o problema" );
//            e.printStackTrace();
//        }
//    }

    public void afisareConsola() {
        String meniu = " ";
        while (meniu != "X") {
            showOptiuni();
            meniu = citesteConsola();
            procesareMeniu(meniu);
        }
    }

}
