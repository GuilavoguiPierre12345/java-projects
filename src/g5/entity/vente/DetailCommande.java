/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g5.entity.vente;

/**
 *
 * @author kallo
 */
public class DetailCommande {
    private int idDetail;
    private Commande idCommande;
    private Materiel idMateriel;
    private Double quantite;
    private Double prixUnitaire;

    public DetailCommande() {
    }

    public DetailCommande(int idDetail, Commande idCommande, Materiel idMateriel, Double quantite, Double prixUnitaire) {
        this.idDetail = idDetail;
        this.idCommande = idCommande;
        this.idMateriel = idMateriel;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public Commande getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Commande idCommande) {
        this.idCommande = idCommande;
    }

    public Materiel getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(Materiel idMateriel) {
        this.idMateriel = idMateriel;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
