/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g5.entity.vente;

/**
 *
 * @author kallo
 */
public class Fournisseur {
    private int idFournisseur;
    private String nomComplet;
    private String adresse;
    private String materiel;

    public Fournisseur() {
    }

    public Fournisseur(int idFournisseur, String nomComplet, String adresse, String materiel) {
        this.idFournisseur = idFournisseur;
        this.nomComplet = nomComplet;
        this.adresse = adresse;
        this.materiel = materiel;
    }

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMateriel() {
        return materiel;
    }

    public void setMateriel(String materiel) {
        this.materiel = materiel;
    }    

    public String getNomFournisseur() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
