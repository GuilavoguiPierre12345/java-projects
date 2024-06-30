/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g5.entity.vente;

/**
 *
 * @author kallo
 */
public class Commande {
    private int idCommande;
    private int idUtilisateur;
    private Client idClient;
    private String dateCommande;
    private double montant;

    public Commande() {
    }

    public Commande(int idCommande, int idUtilisateur, Client idClient, String dateCommande, double montant) {
        this.idCommande = idCommande;
        this.idUtilisateur = idUtilisateur;
        this.idClient = idClient;
        this.dateCommande = dateCommande;
        this.montant = montant;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }    
}
