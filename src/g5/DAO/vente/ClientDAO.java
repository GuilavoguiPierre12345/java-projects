/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g5.DAO.vente;

import g5.DataSourceProvider.vente.DataSourceProvider;
import g5.entity.vente.Client;
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
public class ClientDAO {
        //--------------  Insertion dans la table client  --------------------------------
  
     public void create(Client client) {
        Connection cnx = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("INSERT INTO Client(adresseClient,numeroClient,nomComplet,genreClient) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, client.getAdresseClient());
            preparedStatement.setString(2, client.getNumeroClient());
            preparedStatement.setString(3, client.getNomComplet());
            preparedStatement.setString(4, client.getGenre());
            preparedStatement.executeUpdate();
           ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                client.setIdClient(generatedId);
            }

            System.out.println("Le Client a été ajouté avec succès.");
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
     
     // mise de client
         public void update(Client client) {
        Connection cnx = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("UPDATE Client SET adresseClient=?,numeroClient=?,nomComplet=?,genreClient=? WHERE idClient=?");
            preparedStatement.setString(1, client.getAdresseClient());
            preparedStatement.setString(2, client.getNumeroClient());
            preparedStatement.setString(3, client.getNomComplet());
            preparedStatement.setString(4, client.getGenre());
            preparedStatement.setInt(5, client.getIdClient());
            preparedStatement.executeUpdate();
            System.out.println("Le client a été mis à jour avec succès.");
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
         
     // methode pour supprimer un client
         
         public void delete(int id) {
        Connection cnx = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("DELETE FROM Client WHERE idClient=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Le client a été supprimé avec succès.");
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
         
    // methode d'affichage d'un client
        public Client lecture(int id) {
        Connection cnx = null;
        Client client = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("SELECT * FROM Client WHERE idClient=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                client = new Client();
                client.setIdClient(resultSet.getInt("idClient"));
                client.setAdresseClient(resultSet.getString("adresseClient"));
                client.setNumeroClient(resultSet.getString("numeroClient"));
                client.setNomComplet(resultSet.getString("nomComplet"));
                client.setGenre(resultSet.getString("genreClient"));
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
        return client;
    }
        
     // Methode d'affichage de tous les client
        
   public List<Client> listClient() {
       List<Client> clients = new ArrayList<>();
       Connection cnx = null;

    try {
        DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
        cnx = dataSource.getConnection();
        PreparedStatement preparedStatement = cnx.prepareStatement("SELECT idClient,adresseClient,numeroClient,nomComplet,genreClient FROM Client");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Client client = new Client();
                client.setIdClient(rs.getInt("idClient"));
                client.setAdresseClient(rs.getString("adresseClient"));
                client.setNumeroClient(rs.getString("numeroClient"));
                client.setNomComplet(rs.getString("nomComplet"));
                client.setGenre(rs.getString("genreClient"));
            clients.add(client);
        }
        System.out.println("Voici la liste des clients lus :");
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

    return clients;
}
}
