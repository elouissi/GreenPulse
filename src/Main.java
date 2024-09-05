import Util.Util;

import javax.print.attribute.IntegerSyntax;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    public static void main(String[] args) {


        int choix;
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, User> users = new HashMap<>();

        // Passer users et scanner aux classes de gestion
        UserManagement management = new UserManagement(users, scanner);
        ConsomationManagement consomationM = new ConsomationManagement(users, scanner);

        long consommationParJour = 0;
        double consommationTotale = 0;
        long difference =0;
        do {
            System.out.println("-----------------------//veuillez selectionner votre choix//--------------");
            System.out.println("1 - Ajouter un utilisateur");
            System.out.println("2 - Modifier un utilisateur");
            System.out.println("3 - Supprimer un utilisateur");
            System.out.println("4 - Afficher tous les utilisateurs");
            System.out.println("5 - entrer la consomation d'un utilisateur ");
            System.out.println("6 - afficher la consomation d'un utilisateur");
            System.out.println("7- générer le rapport d'un utilisateur");
            System.out.println("8 - Exit");

            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {

                case 1:

                    management.AddUser();

                    break;


                case 2:

                   management.UpdateUser();
                    break;

                case 3:

                    management.DeleteUser();

                    break;

                case 4:

                    management.Showing();

                    break;

                case 5:
                    consomationM.AddConsomation();
                    break;

                case 6:
                    consomationM.ShowConsommation();
                    break;

                case 7:
                    System.out.println("--Type :  1");
                    System.out.println("--Type :  2");
                    int choixF = scanner.nextInt();

                    System.out.println("s'il vous plait choisir l'utilisateur que vous voulez");
                   int  slectedId = scanner.nextInt();
                    scanner.nextLine();


                    scanner.nextLine();
                        switch (choixF){
                            case 1:


                                User utilisateur = users.get(slectedId);
                                List<Consomation> consomations = utilisateur.getConsommations();


                                for (Consomation consomation : consomations) {
                                    consommationTotale = consomation.getValueOfCarbon();
                                }

                                consommationParJour = (long) (consommationTotale / difference);


                                float consomationParSemaine = consommationParJour * 7;
                                float consommationParMois = consommationParJour * 30;
                                float consommationParAnnée = consommationParJour * 365;

                                System.out.println("/------------------------------------------------------------------------/");
                                System.out.println("/--Par Jour  -------- Par Semaine ------  Par Mois   --------  Par Année /");
                                System.out.println("/--   " + consommationParJour + "    ------    " + consomationParSemaine + " ------   " + consommationParMois + " -----    " + consommationParAnnée + "--/");
                                break;
                            case 2:


                                User utilisa = users.get(slectedId);
                                if (utilisa != null ) {
                                    for (Consomation consomation : utilisa.getConsommations()) {
                                        LocalDate stDate = consomation.getStartDate();
                                        LocalDate edDate = consomation.getEndDate();

                                            long differenceDays = ChronoUnit.DAYS.between(stDate, edDate) + 1;
                                        float differenceConsomation = consomation.getValueOfCarbon() / differenceDays;
                                        for (LocalDate date = stDate; date.isBefore(edDate); date = date.plusDays(1)) {
                                            System.out.println(date + " la consomation par la journée :" + differenceConsomation);

                                        }
                                    }


                                    break;
                                }
                        }

                    break;

                case 8:

                    System.out.println("Au revoir!");
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }

        } while (choix != 8) ;

    }

}
