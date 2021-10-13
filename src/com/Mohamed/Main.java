package com.Unleash;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Article> articleList = new LinkedList<>();

    public static void main(String[] args) {
        // write your code here
        while (true) {
            message();
        }
    }

    private static void message() {
        System.out.println("0: Grean \n1:Client");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 0) {
            GreantMessage();
        } else if (choice == 1) {
            System.out.println("Bonjour cher/chere Client(e)");
        } else {
            System.out.println("Cette Action n'est pas autorisee");
        }
    }

    private static void GreantMessage() {
        String[] message = {"Ajouter un Article",
                "Modifier un Article",
                "Consulter un Article",
                "Supprimer un Article"};
        for (int i = 0; i < 4; i++) {
            System.out.println(i + " : " + message[i]);
        }
        Greant greant = new Greant(articleList);
        int choice = scanner.nextInt();
        switch (choice) {
            case 0 -> ajout(greant);
            case 1 -> modifier(greant);
            case 2 -> greant.Consulter();
            case 3 -> supprimer(greant);
        }
    }

    private static void modifier(Greant greant) {
        System.out.println("donner l'id de Article");
        int ID = scanner.nextInt();
        scanner.nextLine();
        greant.ModifierArticle(ID);
    }

    private static void ajout(Greant greant) {
        int id, prix;
        String ref, Nom;
        System.out.println("donner le ID");
        id = scanner.nextInt();
        System.out.println("donner le prix");
        scanner.nextLine();
        prix = scanner.nextInt();
        scanner.nextLine();
        System.out.println("donner le Ref ");
        ref = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Nom");
        Nom = scanner.nextLine();
        scanner.nextLine();
        greant.Ajouter(id, Nom, ref, prix);


    }

    private static void supprimer(Greant greant) {
        System.out.println("donner l'id de Article");
        int id = scanner.nextInt();
        greant.Supprimer(id);
    }
}

class Client {

}

class Greant {
    List<Article> list;

    public Greant(List<Article> articleList) {
        this.list = articleList;
    }

    public void Ajouter(int id, String ref, String Nom, int price) {
        this.list.add(new Article(id, ref, Nom, price));

    }

    public void Consulter() {
        for (Article art : this.list) {
            System.out.println(art.getID() + " " + art.getRef() + " " + art.getNom() + " " + art.getPrix());
        }
    }

    private int Search(int ID) {
        int index = -1;
        for (Article art : this.list) {
            if (art.getID() == ID) {
                index = this.list.indexOf(art);
                break;
            }
        }
        return index;
    }

    public void Supprimer(int ID) {
        int target = this.Search(ID);
        if (target > -1) {
            this.list.remove(target);
        }
    }

    public void ModifierArticle(int ID) {
        int target = this.Search(ID);
        if (target > -1) {
            Scanner scanner = new Scanner(System.in);
            Article TarArticle = this.list.get(target);
            String[] Choice = {"0: Modifier ID",
                    "1:Modifer Referance",
                    "2:Modifier Nom",
                    "3:Modifer Prix",
                    "4:quitter"};
            for (String str : Choice) {
                System.out.println(str);
            }

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Donner ID");
                    int NID = scanner.nextInt();
                    scanner.nextLine();
                    TarArticle.setID(NID);
                    break;
                case 1:

                    System.out.println("Donner Ref");
                    String Ref = scanner.nextLine();
                    scanner.nextLine();
                    TarArticle.setRef(Ref);
                    break;
                case 2:

                    System.out.println("Donner Nom");
                    String Nom = scanner.nextLine();
                    scanner.nextLine();
                    TarArticle.setNom(Nom);
                    break;
                case 3:

                    System.out.println("Donner Prix");
                    int prix = scanner.nextInt();
                    scanner.nextLine();
                    TarArticle.setPrix(prix);
                    break;
                default:
                    System.out.println("action not found");
                    break;
            }

        } else {
            System.out.println("cette Article est introuvable");
        }
    }
}

class Article {
    private int ID;
    private String Ref;
    private String Nom;
    private int Prix;

    public Article(int ID, String ref, String nom, int prix) {
        this.ID = ID;
        Ref = ref;
        Nom = nom;
        Prix = prix;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRef() {
        return Ref;
    }

    public void setRef(String ref) {
        Ref = ref;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public int getPrix() {
        return Prix;
    }

    public void setPrix(int prix) {
        Prix = prix;
    }
}
