/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g5.DAO.vente;

import g5.DataSourceProvider.vente.DataSourceProvider;
import g5.entity.vente.Fournisseur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author kallo
 */
public class FournisseurDAO {
    
    //--------------  Insertion dans la table fournisseur  --------------------------------
  
     public void create(Fournisseur fournisseur) {
        Connection cnx = null;
        try {
            
            
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("INSERT INTO Fournisseur(nomComplet,adresse,materiel) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, fournisseur.getNomComplet());
            preparedStatement.setString(2, fournisseur.getAdresse());
            preparedStatement.setString(3, fournisseur.getMateriel());
            preparedStatement.executeUpdate();
           ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                fournisseur.setIdFournisseur(generatedId);
            }

            System.out.println("Le fournisseur a été ajouté avec succès.");
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
     
     // mise de fournisseur
         public void update(Fournisseur fournisseur) {
        Connection cnx = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("UPDATE Fournisseur SET nomComplet=?, adresse=?, materiel=? WHERE idFournisseur=?");
            preparedStatement.setString(1, fournisseur.getNomComplet());
            preparedStatement.setString(2, fournisseur.getAdresse());
            preparedStatement.setString(3, fournisseur.getMateriel());
            preparedStatement.setInt(4, fournisseur.getIdFournisseur());
            preparedStatement.executeUpdate();
            System.out.println("Le fournisseur a été mis à jour avec succès.");
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
         
     // methode pour supprimer un fournisseur
         
         public void delete(int id) {
        Connection cnx = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("DELETE FROM Fournisseur WHERE idFournisseur=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Le fournisseur a été supprimé avec succès.");
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
         
    // methode d'affichage d'un fournisseur
        public Fournisseur lecture(int id) {
        Connection cnx = null;
        Fournisseur fournisseur = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("SELECT * FROM Fournisseur WHERE idFournisseur=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                fournisseur = new Fournisseur();
                fournisseur.setIdFournisseur(resultSet.getInt("idFournisseur"));
                fournisseur.setNomComplet(resultSet.getString("nomComplet"));
                fournisseur.setAdresse(resultSet.getString("adresse"));
                fournisseur.setMateriel(resultSet.getString("materiel"));
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
        return fournisseur;
    }
        
     // Methode d'affichage de tous les fournisseur
        
       public List<Fournisseur> listFournisseur() {
    List<Fournisseur> fournisseurs = new ArrayList<>();
    Connection cnx = null;

    try {
        DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
        cnx = dataSource.getConnection();
        PreparedStatement preparedStatement = cnx.prepareStatement("SELECT idFournisseur, nomComplet, adresse, materiel FROM Fournisseur");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Fournisseur fournisseur = new Fournisseur();
            fournisseur.setIdFournisseur(rs.getInt("idFournisseur"));
            fournisseur.setNomComplet(rs.getString("nomComplet"));
            fournisseur.setAdresse(rs.getString("adresse"));
            fournisseur.setMateriel(rs.getString("materiel"));
            fournisseurs.add(fournisseur);
        }
        System.out.println("Voici la liste des fournisseurs lus :");
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

    return fournisseurs;
}
}

