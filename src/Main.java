import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choix;
        HashMap<Integer, User> users = new HashMap<>();

        do {
            System.out.println("-----------------------//veuillez selectionner votre choix//--------------");
            System.out.println("1 - Ajouter un utilisateur");
            System.out.println("2 - Modifier un utilisateur");
            System.out.println("3 - Supprimer un utilisateur");
            System.out.println("4 - Afficher tous les utilisateurs");
            System.out.println("5 - Exit");

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
                    System.out.println("Au revoir!");
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }

        } while (choix != 5);
    }
}
