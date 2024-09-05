import Util.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ConsomationManagement {


    long consommationParJour = 0;
    double consommationTotale = 0;
    long difference =0;
    private HashMap<Integer, User> users;
    private Scanner scanner;

    public ConsomationManagement(HashMap<Integer, User> users, Scanner scanner) {
        this.users = users;
        this.scanner = scanner;
    }
    public void AddConsomation(){
        System.out.println("Entrez l'utilisateur que vous voulez ajouter à la consommation de carbone --|>");
        int selectId = scanner.nextInt();
        scanner.nextLine();


        if (users.containsKey(selectId)) {
            System.out.println("enter l'id du consommtion :");
            int ConsomationId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Entrez la valeur du carbone en kg --|>");
            int valeur = scanner.nextInt();
            scanner.nextLine();

            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            try {
                System.out.println("Entrez la date de début (dd/MM/yyyy) :");
                String inputS = scanner.nextLine();
                LocalDate startDate = LocalDate.parse(inputS, format);

                System.out.println("Entrez la date de fin (dd/MM/yyyy) :");
                String inputE = scanner.nextLine();
                LocalDate endDate = LocalDate.parse(inputE, format);

                difference = ChronoUnit.DAYS.between(startDate, endDate);


                if ( difference < 0) {
                    System.out.println("Erreur : La date de début et la date de fin sont identiques.");
                } else {
                    consommationParJour = valeur / difference;
                    System.out.println("Nombre de jours de différence: " + difference);
                    System.out.println("Consommation par jour : " + consommationParJour);
                    List<LocalDate> listDate = new ArrayList<>();
                    User utilisateur = users.get(selectId);

                    for (Consomation co : utilisateur.getConsommations()) {
                        for (LocalDate date = co.getStartDate(); !date.isAfter(co.getEndDate()) ;date =  date.plusDays(1)){
                            listDate.add(date);
                        }
                    }
                    if(Util.verifydates(startDate,endDate, listDate )){
                        Consomation consomation = new Consomation(ConsomationId,startDate, endDate, valeur);
                        utilisateur.AddCarbon(consomation);
                        System.out.println("La consommation de l'utilisateur a bien été ajoutée.");

                    }else {
                        System.out.println("s'il vous plait entre une autre date ");
                    }


                }
            } catch (DateTimeParseException e) {
                System.out.println("Erreur : Format de date incorrect. Veuillez entrer la date au format dd/MM/yyyy.");
            } catch (ArithmeticException e) {
                System.out.println("Erreur : Division par zéro lors du calcul de la consommation par jour.");
            }

        } else {
            System.out.println("Erreur : ID d'utilisateur non trouvé.");
        }
    }
    public void ShowConsommation(){

        System.out.println("Entrez l'ID de l'utilisateur pour afficher ses détails et consommations :");
        int userId = scanner.nextInt();
        scanner.nextLine();  // Consomme la nouvelle ligne

        if (users.containsKey(userId)) {
            User utilisateur = users.get(userId);

            // Afficher les détails de l'utilisateur
            System.out.println(utilisateur.toString());

            // Afficher les consommations de l'utilisateur
            List<Consomation> consommations = utilisateur.getConsommations();

            System.out.println("Consommations de l'utilisateur :");
            for (Consomation consomation : consommations) {
                System.out.println(consomation.toString());
            }


        } else {
            System.out.println("Erreur : ID d'utilisateur non trouvé.");
        }

    }

}
