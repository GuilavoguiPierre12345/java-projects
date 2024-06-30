package g5.DAO.vente;


import g5.DataSourceProvider.vente.DataSourceProvider;
import g5.entity.vente.Fournisseur;
import g5.entity.vente.Materiel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kallo
 */
public class MaterielDAO {
public void create(Materiel materiel) {
        Connection cnx = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("INSERT INTO Materiel(nomMateriel,description,prix,stock,idFournisseur) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, materiel.getNomMateriel());
            preparedStatement.setString(2, materiel.getDescription());
            preparedStatement.setDouble(3, materiel.getPrix());
            preparedStatement.setInt(4, materiel.getStock());
            preparedStatement.setInt(5, materiel.getIdFournisseur());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                materiel.setIdMatriel(generatedId);
            }
            System.out.println("Le matériel a été ajouté avec succès.");
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

 // la mise des matériels
public void update(Materiel materiel) {
        Connection cnx = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("UPDATE Materiel SET nomMateriel=?, description=?, prix=?, stock=?, idFournisseur=? WHERE idMateriel=?");
            preparedStatement.setString(1, materiel.getNomMateriel());
            preparedStatement.setString(2, materiel.getDescription());
            preparedStatement.setDouble(3, materiel.getPrix());
            preparedStatement.setInt(4, materiel.getStock());
            preparedStatement.setInt(5, materiel.getIdFournisseur());
            preparedStatement.setInt(6, materiel.getIdMatriel());
            preparedStatement.executeUpdate();
            System.out.println("Le matériel a été mis à jour avec succès.");
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
            PreparedStatement preparedStatement = cnx.prepareStatement("DELETE FROM Materiel WHERE idMateriel=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Le matériel a été supprimé avec succès.");
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

public Materiel lecture(int id) {
        Connection cnx = null;
        Materiel materiel = null;
        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("SELECT * FROM Materiel WHERE idMateriel=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                materiel = new Materiel();
                materiel.setIdMatriel(resultSet.getInt("idMateriel"));
                materiel.setNomMateriel(resultSet.getString("nomMateriel"));
                materiel.setDescription(resultSet.getString("description"));
                materiel.setPrix(resultSet.getDouble("prix"));
                materiel.setStock(resultSet.getInt("stock"));
                materiel.setIdFournisseur(resultSet.getInt("idFournisseur"));
//                int fournisseurId = resultSet.getInt("idFournisseur");
//                FournisseurDAO fournisseurDAO = new FournisseurDAO();
//                Fournisseur fournisseur = fournisseurDAO.lecture(fournisseurId);
//                materiel.setIdFournisseur(fournisseur);
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
        return materiel;
    }


  // Liste de tous materiels

public List<Materiel> listMateriel() {
        List<Materiel> materiels = new ArrayList<>();
        Connection cnx = null;

        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
            cnx = dataSource.getConnection();
            PreparedStatement preparedStatement = cnx.prepareStatement("SELECT idMateriel, nomMateriel, description, prix, stock, idFournisseur FROM Materiel");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Materiel materiel = new Materiel();
                materiel.setIdMatriel(rs.getInt("idMateriel"));
                materiel.setNomMateriel(rs.getString("nomMateriel"));
                materiel.setDescription(rs.getString("description"));
                materiel.setPrix(rs.getDouble("prix"));
                materiel.setStock(rs.getInt("stock"));
                materiel.setIdFournisseur(rs.getInt("idFournisseur"));
                
//                int fournisseurId = rs.getInt("idFournisseur");
//                materiel.setIdFournisseur(getFournisseurById(fournisseurId));

                materiels.add(materiel);
            }
            System.out.println("Voici la liste des matériels lus :");
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

        return materiels;
    }

public Map<Integer, String> getFournisseursMap() {
    Map<Integer, String> fournisseursMap = new HashMap<>();
    Connection cnx = null;

    try {
        DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
        cnx = dataSource.getConnection();
        PreparedStatement preparedStatement = cnx.prepareStatement("SELECT idFournisseur, nomFournisseur FROM Fournisseur");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int idFournisseur = rs.getInt("idFournisseur");
            String nomFournisseur = rs.getString("nomFournisseur");
            fournisseursMap.put(idFournisseur, nomFournisseur);
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

    return fournisseursMap;
}

//    private Fournisseur getFournisseurById(int fournisseurId) {
//        FournisseurDAO fournisseurDAO = new FournisseurDAO();
//        return fournisseurDAO.lecture(fournisseurId);
    }

//public List<Materiel> listMateriel() {
//    List<Materiel> materiels = new ArrayList<>();
//    Connection cnx = null;
//
//    try {
//        DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();
//        cnx = dataSource.getConnection();
//        PreparedStatement preparedStatement = cnx.prepareStatement("SELECT idMateriel, nomMateriel, description, prix, stock, idFournisseur FROM Materiel");
//        ResultSet rs = preparedStatement.executeQuery();
//        while (rs.next()) {
//            Materiel materiel = new Materiel();
//            materiel.setIdMatriel(rs.getInt("idMateriel"));
//            materiel.setNomMateriel(rs.getString("nomMateriel"));
//            materiel.setDescription(rs.getString("description"));
//            materiel.setPrix(rs.getDouble("prix"));
//            materiel.setStock(rs.getInt("stock"));
//
//            // Lire le fournisseur associé au matériel
//            int fournisseurId = rs.getInt("idFournisseur");
//            FournisseurDAO fournisseurDAO = new FournisseurDAO();
//            Fournisseur fournisseur = fournisseurDAO.lecture(fournisseurId);
//            materiel.setIdFournisseur(fournisseur);
//
//            materiels.add(materiel);
//        }
//        System.out.println("Voici la liste des matériels lus :");
//    } catch (SQLException e) {
//        e.printStackTrace();
//    } finally {
//        try {
//            if (cnx != null) {
//                cnx.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    return materiels;
//}

