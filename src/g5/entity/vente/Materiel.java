/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g5.entity.vente;

import g5.DAO.vente.FournisseurDAO;

/**
 *
 * @author kallo
 */
public class Materiel {
    private int idMatriel;
    private String nomMateriel;
    private String description;
    private double prix;
    private int stock;
    private int idFournisseur;

    public Materiel() {
    }

    public Materiel(int idMatriel, String nomMateriel, String description, double prix, int stock, int idFournisseur) {
        this.idMatriel = idMatriel;
        this.nomMateriel = nomMateriel;
        this.description = description;
        this.prix = prix;
        this.stock = stock;
        this.idFournisseur = idFournisseur;
    }

    public int getIdMatriel() {
        return idMatriel;
    }

    public void setIdMatriel(int idMatriel) {
        this.idMatriel = idMatriel;
    }

    public String getNomMateriel() {
        return nomMateriel;
    }

    public void setNomMateriel(String nomMateriel) {
        this.nomMateriel = nomMateriel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }   
    
    public String getNomFournisseur() {
        FournisseurDAO fournisseurDAO = new FournisseurDAO();
        Fournisseur fournisseur = fournisseurDAO.lecture(idFournisseur);
        return (fournisseur != null) ? fournisseur.getNomFournisseur() : "";
    }
}
