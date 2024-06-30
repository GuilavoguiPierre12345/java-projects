/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g5.DAO.vente;

import g5.DataSourceProvider.vente.DataSourceProvider;
import g5.entity.vente.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author kallo
 */
public class UtilisateurDAO {
            //--------------  Insertion dans la table utilisateur  --------------------------------
  
     public void create(Utilisateur utilisateur) {
        Connection cnx = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("INSERT INTO Utilisateur(nom,email,motDePasse,role,question) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getEmail());
            preparedStatement.setString(3, utilisateur.getMotDepasse());
            preparedStatement.setString(4, utilisateur.getRole());
            preparedStatement.setString(5, utilisateur.getQuestion());
            preparedStatement.executeUpdate();
           ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                utilisateur.setIdUtilisateur(generatedId);
            }

            System.out.println("Le utilisateur a été ajouté avec succès.");
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
    
     // mise de Utilisateur
    public void updateUser(Utilisateur utilisateur) {
        Connection cnx = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("UPDATE Users SET nom=?, email=?, motDePasse=?, role=?, question=? WHERE idUtilisateur=?");
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getEmail());
            preparedStatement.setString(3, utilisateur.getMotDepasse());
            preparedStatement.setString(3, utilisateur.getRole());
            preparedStatement.setString(3, utilisateur.getQuestion());
            preparedStatement.setInt(4, utilisateur.getIdUtilisateur());
            preparedStatement.executeUpdate();
            System.out.println("L'utilisateur a été mis à jour avec succès.");
        } catch (SQLException e) {
        } finally {
            try {
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException e) {
            }
        }
    }
         
     // methode pour supprimer un utilisateur
         
         public void delete(int id) {
        Connection cnx = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("DELETE FROM Utilisateur WHERE idUtilisateur=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Le utilisateur a été supprimé avec succès.");
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
         
    // methode d'affichage d'un utilisateur
    public Utilisateur lecture(int id) {
        Connection cnx = null;
        Utilisateur utilisateur = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("SELECT * FROM Utilisateur WHERE idUtilisateur=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setIdUtilisateur(resultSet.getInt("idUtilisateur"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setMotDepasse(resultSet.getString("motDePasse"));
                utilisateur.setRole(resultSet.getString("role"));
                utilisateur.setQuestion(resultSet.getString("question"));
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
        return utilisateur;
    }
        
     // Methode d'affichage de tous les utilisateur
        
    public List<Utilisateur> listUtilisateur() {
       List<Utilisateur> utilisateurs = new ArrayList<>();
       Connection cnx = null;

    try {
        DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
        cnx = dataSource.getConnection();
        PreparedStatement preparedStatement = cnx.prepareStatement("SELECT idUtilisateur,nom,email,motDePasse,role,question FROM Utilisateur");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setIdUtilisateur(rs.getInt("idUtilisateur"));
            utilisateur.setNom(rs.getString("nom"));
            utilisateur.setEmail(rs.getString("email"));
            utilisateur.setMotDepasse(rs.getString("motDePasse"));
            utilisateur.setRole(rs.getString("role"));
            utilisateur.setQuestion(rs.getString("question"));
            utilisateurs.add(utilisateur);
        }
        System.out.println("Voici la liste des utilisateurs lus :");
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

    return utilisateurs;
}
}
