package g5.DAO.vente;

import g5.DataSourceProvider.vente.DataSourceProvider;
import g5.entity.vente.Materiel;
import g5.entity.vente.Commande;
import g5.entity.vente.DetailCommande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kallo
 */
public class DetailCommandeDAO {
    
    // Les methode de CRUD pour les detaille commandes
    public void create(DetailCommande detailCommande) {
        Connection cnx = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("INSERT INTO DetailCommande(idCommande,idMateriel,quantite,prixUnitaire) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, detailCommande.getIdCommande().getIdCommande());
            preparedStatement.setInt(2, detailCommande.getIdMateriel().getIdMatriel());
            preparedStatement.setDouble(3, detailCommande.getQuantite());
            preparedStatement.setDouble(4, detailCommande.getPrixUnitaire());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                detailCommande.setIdDetail(generatedId);
            }
            System.out.println("Detail sur la commande a été ajouté avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

 // la mise des des detail commandes
public void update(DetailCommande detailCommande) {
        Connection cnx = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("UPDATE DetailCommande SET idCommande=?, idMateriel=?, quantite=?, prixUnitaire=? WHERE idDetail=?");
            preparedStatement.setInt(1, detailCommande.getIdCommande().getIdCommande());
            preparedStatement.setInt(2, detailCommande.getIdMateriel().getIdMatriel());
            preparedStatement.setDouble(3, detailCommande.getQuantite());
            preparedStatement.setDouble(4, detailCommande.getPrixUnitaire());
            preparedStatement.setInt(5, detailCommande.getIdDetail());
            preparedStatement.executeUpdate();
            System.out.println("Detail des commandes a été mis à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

// methode pour supprimer un materiel

public void delete(int id) {
        Connection cnx = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("DELETE FROM DetailCommande WHERE idDetail=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Detail commande a été supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

// methode pour afficher une ligne

public DetailCommande lecture(int id) {
        Connection cnx = null;
        DetailCommande detailCommande = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("SELECT * FROM DetailCommande WHERE idDetail=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                detailCommande = new DetailCommande();
                detailCommande.setQuantite(resultSet.getDouble("quantite"));
                detailCommande.setPrixUnitaire(resultSet.getDouble("prixUnitaire"));
                int commandeId = resultSet.getInt("idCommande");
                CommandeDAO commandeDAO = new CommandeDAO();
                Commande commande = commandeDAO.lecture(commandeId);
                detailCommande.setIdCommande(commande);
                int materielId = resultSet.getInt("idMateriel");
                MaterielDAO materielDAO = new MaterielDAO();
                Materiel materiel = materielDAO.lecture(materielId);
                detailCommande.setIdMateriel(materiel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return detailCommande;
    }


  // Liste de tous materiels

public List<DetailCommande> listdetailCommande() {
    List<DetailCommande> detailCommandes = new ArrayList<>();
    Connection cnx = null;

    try {
        DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
        cnx = dataSource.getConnection();
        PreparedStatement preparedStatement = cnx.prepareStatement("SELECT idCommande, idMateriel, quantite, prixUnitaire FROM DetailCommande");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            DetailCommande detailCommande = new DetailCommande();
            // Lire l'utilisateur associé au commande
            int commandeId = rs.getInt("idCommande");
            CommandeDAO commandeDAO = new CommandeDAO();
            Commande commande = commandeDAO.lecture(commandeId);
            detailCommande.setIdCommande(commande);
            int materielId = rs.getInt("idMateriel");
            MaterielDAO materielDAO = new MaterielDAO();
            Materiel materiel = materielDAO.lecture(materielId);
            detailCommande.setIdMateriel(materiel);
            
            detailCommande.setQuantite(rs.getDouble("quantite"));
            detailCommande.setPrixUnitaire(rs.getDouble("prixUnitaire"));

            detailCommandes.add(detailCommande);
        }
        System.out.println("Voici la liste des detail commandes lus :");
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (cnx != null) {
                cnx.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return detailCommandes;
}    

public List<DetailCommande> listDetailsCommande() {
    List<DetailCommande> detailsCommande = new ArrayList<>();
    Connection cnx = null;

    try {
        DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
        cnx = dataSource.getConnection();
        PreparedStatement preparedStatement = cnx.prepareStatement(
            "SELECT dc.idDetail, dc.quantite, dc.prixUnitaire, " +
            "c.dateCommande, " +
            "m.nomMateriel " +
            "FROM DetailCommande dc " +
            "JOIN Commande c ON dc.idCommande = c.idCommande " +
            "JOIN Materiel m ON dc.idMateriel = m.idMateriel"
        );
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            DetailCommande detailCommande = new DetailCommande();
            detailCommande.setIdDetail(rs.getInt("idDetail"));
            detailCommande.setQuantite(rs.getDouble("quantite"));
            detailCommande.setPrixUnitaire(rs.getDouble("prixUnitaire"));
            
            Commande commande = new Commande();
            commande.setDateCommande(rs.getString("dateCommande"));
            detailCommande.setIdCommande(commande);
            
            Materiel materiel = new Materiel();
            materiel.setNomMateriel(rs.getString("nomMateriel"));
            detailCommande.setIdMateriel(materiel);
            
            detailsCommande.add(detailCommande);
        }
        System.out.println("Voici la liste des détails de commande lus :");
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (cnx != null) {
                cnx.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return detailsCommande;
}

}
