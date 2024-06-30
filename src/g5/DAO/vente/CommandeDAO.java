/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g5.DAO.vente;

import g5.DataSourceProvider.vente.DataSourceProvider;
import g5.entity.vente.Client;
import g5.entity.vente.Utilisateur;
import g5.entity.vente.Commande;
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
public class CommandeDAO {
    // Les methode de CRUD pour les commandes
    public void create(Commande commande) {
        Connection cnx = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("INSERT INTO Commande(idClient,dateCommande,montant) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, commande.getIdClient().getIdClient());
            preparedStatement.setString(2, commande.getDateCommande());
            preparedStatement.setDouble(3, commande.getMontant());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                commande.setIdCommande(generatedId);
            }
            System.out.println("La commande a été ajouté avec succès.");
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

 // la mise des commandes
public void update(Commande commande) {
        Connection cnx = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("UPDATE Commande SET idClient=?, dateCommande=?, montant=? WHERE idCommande=?");
            preparedStatement.setInt(1, commande.getIdClient().getIdClient());
            preparedStatement.setString(2, commande.getDateCommande());
            preparedStatement.setDouble(3, commande.getMontant());
            preparedStatement.setInt(4, commande.getIdCommande());
            preparedStatement.executeUpdate();
            System.out.println("La commande a été mis à jour avec succès.");
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
            PreparedStatement preparedStatement = cnx.prepareStatement("DELETE FROM Commande WHERE idCommande=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("La commande a été supprimé avec succès.");
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

public Commande lecture(int id) {
        Connection cnx = null;
        Commande commande = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("SELECT * FROM Commande WHERE idCommande=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                commande = new Commande();
                commande.setDateCommande(resultSet.getString("dateCommande"));
                commande.setMontant(resultSet.getDouble("montant"));
                int clientId = resultSet.getInt("idClient");
                ClientDAO clientDAO = new ClientDAO();
                Client client = clientDAO.lecture(clientId);
                commande.setIdClient(client);
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
        return commande;
    }


  // Liste de tous materiels

public List<Commande> listCommande() {
    List<Commande> commandes = new ArrayList<>();
    Connection cnx = null;

    try {
        DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
        cnx = dataSource.getConnection();
        PreparedStatement preparedStatement = cnx.prepareStatement("SELECT idCommande, idClient, dateCommande, montant FROM Commande");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Commande commande = new Commande();
            commande.setIdCommande(rs.getInt("idCommande"));
            commande.setDateCommande(rs.getString("dateCommande"));
            commande.setMontant(rs.getDouble("montant"));
            int clientId = rs.getInt("idClient");
            ClientDAO clientDAO = new ClientDAO();
            Client client = clientDAO.lecture(clientId);
            commande.setIdClient(client);

            commandes.add(commande);
        }
        System.out.println("Voici la liste des des commandes lus :");
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

    return commandes;
}


public List<Commande> listCommande1() {
    List<Commande> commandes = new ArrayList<>();
    Connection cnx = null;

    try {
        DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
        cnx = dataSource.getConnection();
        PreparedStatement preparedStatement = cnx.prepareStatement(
            "SELECT c.idCommande, c.dateCommande, c.montant, " +
            "cl.numeroClient " +
            "FROM Commande c " +
            "JOIN Client cl ON c.idClient = cl.numeroClient"
        );
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Commande commande = new Commande();
            commande.setIdCommande(rs.getInt("idCommande"));
            commande.setMontant(rs.getDouble("montant"));
            commande.setDateCommande(rs.getString("dateCommande"));

            Client client = new Client();
            client.setNumeroClient(rs.getString("numeroClient"));
            commande.setIdClient(client);

            commandes.add(commande);
        }
        System.out.println("Voici la liste des commandes lues :");
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

    return commandes;
}

}
