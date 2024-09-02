import javax.print.attribute.IntegerSyntax;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int choix;
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, User> users = new HashMap<>();

        do {
            System.out.println("-----------------------//veuillez selectionner votre choix//--------------");
            System.out.println("1 - Ajouter un utilisateur");
            System.out.println("2 - Modifier un utilisateur");
            System.out.println("3 - Supprimer un utilisateur");
            System.out.println("4 - Afficher tous les utilisateurs");
            System.out.println("5 - entrer la consomation d'un utilisateur ");
            System.out.println("6 - afficcher la consomation d'un utilisateur");
            System.out.println("7 - Exit");

            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {

                case 1:
                    // L'input d'id
                    System.out.println("Entrez votre ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();


                    // L'input du nom
                    System.out.println("Quel est votre nom?");
                    String nameUser = scanner.nextLine();

                    // L'input de l'âge
                    System.out.println("Quel âge avez-vous?");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    User user = new User(id, nameUser, age);
                    users.put(id, user);

                    System.out.println("Utilisateur ajouté");

                    break;


                case 2:

                    System.out.println("enter l'id d'utilisateur que vous voulez le modifier ");

                    int updatedId = scanner.nextInt();
                    scanner.nextLine();



                    System.out.println("entrer le nouveau nom");
                    String newName = scanner.nextLine();

                    System.out.println("entrer le nouveau age");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();



                    if( users.containsKey(updatedId) ){
                        User Newuser = new User(updatedId, newName, newAge);
                        users.put(updatedId,Newuser);

                        System.out.println("l'utilisateur rst bien modifier");

                    }else {
                        System.out.println("l'id ne trouve pas!");
                    }

                    break;

                case 3:


                    System.out.println("entre l'id d'utilisateur que vous voulez supprimé");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    if (users.containsKey(deleteId)){
                        users.remove(deleteId);
                        System.out.println("l'untilisteur a été bien supprimé");
                    }else {
                        System.out.println("l'id que que vous avez entrer est incorrect");
                    }


                    break;

                case 4:

                    System.out.println("Liste des utilisateurs:");
                    for (User u : users.values()) {
                        System.out.println(u.toString());
                    }
                    break;

                case 5:
                    System.out.println("Entrez l'utilisateur que vous voulez ajouter à la consommation de carbone --|>");
                    int selectId = scanner.nextInt();
                    scanner.nextLine();

                    if (users.containsKey(selectId)) {
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

                            long difference = ChronoUnit.DAYS.between(startDate, endDate);

                            if (difference == 0) {
                                System.out.println("Erreur : La date de début et la date de fin sont identiques.");
                            } else {
                                double consommationParJour = (double) valeur / difference;
                                System.out.println("Nombre de jours de différence: " + difference);
                                System.out.println("Consommation par jour : " + consommationParJour);

                                Consomation consomation = new Consomation(startDate, endDate, valeur);
                                User utilisateur = users.get(selectId);
                                utilisateur.AddCarbon(consomation);

                                System.out.println("La consommation de l'utilisateur a bien été ajoutée.");
                            }
                        } catch (DateTimeParseException e) {
                            System.out.println("Erreur : Format de date incorrect. Veuillez entrer la date au format dd/MM/yyyy.");
                        } catch (ArithmeticException e) {
                            System.out.println("Erreur : Division par zéro lors du calcul de la consommation par jour.");
                        }
                    } else {
                        System.out.println("Erreur : ID d'utilisateur non trouvé.");
                    }
                    break;

                case 6:

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

                    break;

                case 7:
                    break;

                case 8:

                    System.out.println("Au revoir!");
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }

        } while (choix != 7) ;

    }

}
