/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g5.VenteCore;

import g5.DAO.vente.ClientDAO;
import g5.DAO.vente.CommandeDAO;
import g5.DAO.vente.DetailCommandeDAO;
import g5.DAO.vente.MaterielDAO;
import g5.entity.vente.Client;
import g5.entity.vente.Commande;
import g5.entity.vente.DetailCommande;
import g5.entity.vente.Materiel;
import java.util.List;




/**
 *
 * @author kallo
 */
public class Core {
     public static void main(String[] args) {
         
    CommandeDAO venteDAO = new CommandeDAO(); // Remplacez "VenteDAO" par le nom de la classe contenant la méthode listCommande()

    List<Commande> commandes = venteDAO.listCommande();

    for (Commande commande : commandes) {
        System.out.println("ID de commande : " + commande.getIdCommande());
        System.out.println("Montant : " + commande.getMontant());
        System.out.println("Date de commande : " + commande.getDateCommande());
        System.out.println("Numéro de client : " + commande.getIdClient().getNumeroClient());
        System.out.println("---------------------------------------");
    }
         
//    DetailCommandeDAO detailCommandeDAO = new DetailCommandeDAO();
//    List<DetailCommande> detailsCommande = detailCommandeDAO.listDetailsCommande();
//
//    // Affichage des détails de commande
//    for (DetailCommande detailCommande : detailsCommande) {
//        System.out.println("ID Detail: " + detailCommande.getIdDetail());
//        System.out.println("Quantité: " + detailCommande.getQuantite());
//        System.out.println("Prix Unitaire: " + detailCommande.getPrixUnitaire());
//        System.out.println("Date Commande: " + detailCommande.getIdCommande().getDateCommande());
//        System.out.println("Désignation du Matériel: " + detailCommande.getIdMateriel().getNomMateriel());
//        System.out.println("--------------------------------");
//    }
         
        // INSERTION DANS LES TABLES
        
         //Création d'un fournisseur
//        Fournisseur fournisseur = new Fournisseur();
//        fournisseur.setNomComplet("bo");
//        fournisseur.setAdresse("LOPPET");
//        fournisseur.setMateriel("C");
//        
//        // Création du fournisseur dans la base de données
//        FournisseurDAO fournisseurDAO = new FournisseurDAO();
//        fournisseurDAO.create(fournisseur);
        
//        // Création d'un client
//        
//        Client client = new Client();
//        client.setAdresseClient("paris");
//        client.setNumeroClient("1");
//        client.setNomComplet("Saliou Baldé");
//        client.setGenre("Masculin");
//        
//        ClientDAO clientDao =new ClientDAO();
//        clientDao.create(client);
        
        // Création d'un utilisateur
        
//        Utilisateur u=new Utilisateur();
//        u.setNom("gilbert");
//        u.setEmail("g@gmail.com");
//        u.setMotDepasse("123");
//        u.setRole("super user");
//        u.setQuestion("je suis né à guecke");
//        
//        UtilisateurDAO uDAO=new UtilisateurDAO();
//        uDAO.create(u);
       
        // Création d'un matériel associé au fournisseur
        
//        Materiel materiel = new Materiel();
//        materiel.setNomMateriel("Matériel B");
//        materiel.setDescription("Description B");
//        materiel.setPrix(1.0);
//        materiel.setStock(10);
//        materiel.setIdFournisseur(1);
//
//
//        // Création du matériel dans la base de données
//        MaterielDAO materielDAO = new MaterielDAO();
//        materielDAO.create(materiel);
        /*
        // Création d'une commande associé à un client et matériel
        Commande commande = new Commande();
        commande.setIdUtilisateur(u);
        commande.setIdClient(client);
        commande.setDateCommande("07/06/2023");
        commande.setMontant(10000000);
        
        // Création du matériel dans la base de données
        CommandeDAO c=new CommandeDAO();
        c.create(commande);
        
        // Création des detail commandes associé à une commande et un matériel
        DetailCommande d=new DetailCommande();
        d.setIdCommande(commande);
        d.setIdMateriel(materiel);
        d.setQuantite(50);
        d.setPrixUnitaire(200000);
        
        // Création du detail du matériel dans la base de données
        DetailCommandeDAO dc=new DetailCommandeDAO();
        dc.create(d);
        
        */
         
     
        // MISE A JOUR DES TABLES
        
        //Mise à jour d'un fournisseur
//       Fournisseur fournisseur = new Fournisseur();
//       fournisseur.setIdFournisseur(4); // ID du fournisseur à mettre à jour
//       fournisseur.setNomComplet("CIRE");
//       fournisseur.setAdresse("loppet");
//       fournisseur.setMateriel("Nouveau ");
//       FournisseurDAO fournisseurDAO=new FournisseurDAO();
//       fournisseurDAO.update(fournisseur);
        
       // Mise à jour d'un utilisateur
//       Utilisateur uy=new Utilisateur();
//       uy.setIdUtilisateur(1);
//       uy.setNom("mara");
//       uy.setEmail("kall@gmail.com");
//       uy.setMotDepasse("12");
//       uy.setRole("DGA");
//       uy.setQuestion("je");
//       UtilisateurDAO ud=new UtilisateurDAO();
//       ud.updateUser(uy);
       

       // Mise à jour d'un materiel
//       Materiel materiel = new Materiel();
//       materiel.setIdMatriel(1); // ID du matériel à mettre à jour
//       materiel.setNomMateriel("Ciment");
//       materiel.setDescription("Nouvelle qualité ");
//       materiel.setPrix(99);
//       materiel.setStock(20);
//       materiel.setIdFournisseur(1); // ID du fournisseur associé
//       MaterielDAO materielDAO=new MaterielDAO();
//       materielDAO.update(materiel);
       
       //mise à jour user

//     Utilisateur user = new Utilisateur();
//    user.setIdUtilisateur(2);
//    user.setNom("BOBO");
//    user.setEmail("BOBO@.com");
//    user.setMotDepasse("1");
//    user.setRole("Administrateur");
//    user.setQuestion("je");
//
//    UtilisateurDAO dao = new UtilisateurDAO();
//    dao.updateUser(user);
    /*
       // Mise à jour client
       Client c=new Client();
       c.setIdClient(4);
       c.setAdresseClient("LABE");
       c.setNomComplet("solano");
       c.setNumeroClient("3774");
       c.setGenre("M");
       ClientDAO cd=new ClientDAO();
       cd.update(c);
       
       // Mise des commandes
       Commande c1=new Commande();
       c1.setIdCommande(2);
       c1.setDateCommande("12/2/322");
       c1.setMontant(300);
       c1.setIdUtilisateur(u);
       c1.setIdClient(c);
       CommandeDAO cd1=new CommandeDAO();
       cd1.update(c1);
       
       // Mise à jour detail commande
       DetailCommande dc=new DetailCommande();
       dc.setIdDetail(1);
       dc.setIdCommande(c1);
       dc.setIdMateriel(materiel);
       dc.setPrixUnitaire(40);
       dc.setQuantite(23);
       DetailCommandeDAO dc1=new DetailCommandeDAO();
       dc1.update(dc);
       */
     
     /*
       // SUPPRESSION DES ENREGISTREMENTS
        
       // Delete materiel
        MaterielDAO m=new MaterielDAO();
        m.delete(7);
        // Delete commqnde
        CommandeDAO c=new CommandeDAO();
        c.delete(2); 
        // Delelet Detail commande
        DetailCommandeDAO dcd=new DetailCommandeDAO();
        dcd.delete(1);
        // Delete client
        ClientDAO cd=new ClientDAO();
        cd.delete(4);
        // Delete Utilisateur
        UtilisateurDAO u=new UtilisateurDAO();
        u.delete(4);
        // Delete fournisseur
        FournisseurDAO fournisseur=new FournisseurDAO();
        fournisseur.delete(10);
      */
      /*
        // AFFICHAGE D'UNE LIGNE PAR TABLE
        
        // Fournisseur
        FournisseurDAO f=new FournisseurDAO();
        Fournisseur fo=f.lecture(11);
        if(fo!=null){
            System.out.println("ID : " + fo.getIdFournisseur());
            System.out.println("Nom du matériel : " + fo.getMateriel());
            System.out.println("Adresse : " + fo.getAdresse());
            System.out.println("Nom complet : " + fo.getNomComplet());
        
        }else{System.out.println("fournisseur non trouvés");}
        // MATERIEL
        MaterielDAO materielDAO=new MaterielDAO();
        Materiel materiel = materielDAO.lecture(8);
        if (materiel != null) {
            System.out.println("Informations du matériel :");
            System.out.println("ID : " + materiel.getIdMatriel());
            System.out.println("Nom du matériel : " + materiel.getNomMateriel());
            System.out.println("Description : " + materiel.getDescription());
            System.out.println("Prix : " + materiel.getPrix());
            System.out.println("Stock : " + materiel.getStock());
            System.out.println("Fournisseur associé :");
            System.out.println("ID : " + materiel.getIdFournisseur().getIdFournisseur());
            System.out.println("Nom complet : " + materiel.getIdFournisseur().getNomComplet());
            System.out.println("Adresse : " + materiel.getIdFournisseur().getAdresse());
            System.out.println("Matériel : " + materiel.getIdFournisseur().getMateriel());
        } else {
            System.out.println("Matériel non trouvé !");
        } 
        // COMMANDE
        CommandeDAO commandeDAO=new CommandeDAO();
        Commande cdL = commandeDAO.lecture(3);
        if (cdL != null) {
            System.out.println("Informations du commande :");
            System.out.println("ID : " + cdL.getIdCommande());
            System.out.println("Date commande : " + cdL.getDateCommande());
            System.out.println("Montant : " + cdL.getMontant());
            
            System.out.println("Client associé :");
            System.out.println("ID : " + cdL.getIdClient().getIdClient());
            System.out.println("numero : " + cdL.getIdClient().getNumeroClient());
            System.out.println("adresse : " + cdL.getIdClient().getAdresseClient());
            System.out.println("Utilisateur associé :");          
            System.out.println("Nom complet : " + cdL.getIdUtilisateur().getIdUtilisateur());
            System.out.println("Nom complet : " + cdL.getIdUtilisateur().getNom());
            System.out.println("Nom complet : " + cdL.getIdUtilisateur().getRole());
        } else {
            System.out.println("Commande non trouvé !");
        }
        // DETAIL COMMANDE
        DetailCommandeDAO detailCommandDAO=new DetailCommandeDAO();
        DetailCommande dc = detailCommandDAO.lecture(2);
        if (dc != null) {
            System.out.println("Informations des detail commande :");
            System.out.println("Id : " + dc.getIdDetail());
            System.out.println("Quantité : " + dc.getQuantite());
            System.out.println("Prix unitaire : " + dc.getPrixUnitaire());            
            System.out.println("Commande associé :");
            System.out.println("ID : " + dc.getIdCommande().getIdCommande());
            System.out.println("Date : " + dc.getIdCommande().getDateCommande());
            System.out.println("montant : " + dc.getIdCommande().getMontant());
            System.out.println("Materiel associé :");          
            System.out.println("Id : " + dc.getIdMateriel().getIdMatriel());
            System.out.println(" Nom materiel : " + dc.getIdMateriel().getNomMateriel());
            System.out.println("Fournisseur : " + dc.getIdMateriel().getIdFournisseur().getIdFournisseur());
        } else {
            System.out.println("Detail Commande non trouvé !");
        }
        // CLIENT
        ClientDAO cd=new ClientDAO();
        Client client=cd.lecture(5);
        if(client != null){
            System.out.println("ID : " + client.getIdClient());
            System.out.println("Adresse : " + client.getAdresseClient());
            System.out.println("Numero client : " + client.getNumeroClient());
            System.out.println("Nom complet : " + client.getNomComplet());
            System.out.println("Genre : " + client.getGenre());
        }else{System.out.println("Client non trouvés.");}
        // UTILISATEUR
        UtilisateurDAO u=new UtilisateurDAO();
        Utilisateur utilisateur=u.lecture(5);
        if(utilisateur != null){
            System.out.println("ID : " + utilisateur.getIdUtilisateur());
            System.out.println("Adresse : " + utilisateur.getNom());
            System.out.println("Numero client : " + utilisateur.getEmail());
            System.out.println("Nom complet : " + utilisateur.getMotDepasse());
            System.out.println("Genre : " + utilisateur.getRole());
        }else{System.out.println("Utilisateur non trouvés.");}
*/
      
      
      // AFFICHAGE DE TOUS LES ENREGISTREMENTS DE CHAQUE TABLE
       
       // Affichage de plusieur materiel
//        MaterielDAO materielDAO = new MaterielDAO();
//        List<Materiel> materiels = materielDAO.listMateriel();
//        for (Materiel materiel : materiels) {
//        System.out.println("ID : " + materiel.getIdMatriel());
//        System.out.println("Nom du matériel : " + materiel.getNomMateriel());
//        System.out.println("Description : " + materiel.getDescription());
//        System.out.println("Prix : " + materiel.getPrix());
//        System.out.println("Stock : " + materiel.getStock());
//        System.out.println("idFournisseur : " + materiel.getIdFournisseur());
//        System.out.println("------------------------");
//        }
   /*
       // Fournisseur
        FournisseurDAO fournisseurDAO = new FournisseurDAO();
        List<Fournisseur> fournisseurs = fournisseurDAO.listFournisseur();
        for (Fournisseur fournisseur : fournisseurs) {
        System.out.println("ID : " + fournisseur.getIdFournisseur());
        System.out.println("Nom complet : " + fournisseur.getNomComplet());
        System.out.println("Adresse : " + fournisseur.getAdresse());
        System.out.println("Matériel : " + fournisseur.getMateriel());
        System.out.println("------------------------");
        }
        
        // Client
        ClientDAO clientDAO = new ClientDAO();
        List<Client> clients = clientDAO.listClient();
        for (Client client : clients) {
        System.out.println("ID : " + client.getIdClient());
        System.out.println("Nom complet : " + client.getNomComplet());
        System.out.println("Numero : " + client.getNumeroClient());
        System.out.println("genre : " + client.getGenre());
        System.out.println("------------------------");        
        }
        
        // User
        UtilisateurDAO userDAO = new UtilisateurDAO();
        List<Utilisateur> users = userDAO.listUtilisateur();
        for (Utilisateur user : users) {
        System.out.println("ID : " + user.getIdUtilisateur());
        System.out.println("Nom complet : " + user.getNom());
        System.out.println("Role : " + user.getRole());
        System.out.println("Email : " + user.getEmail());
        System.out.println("------------------------");        
        }      

        // Detail commande
        DetailCommandeDAO dcommandeDAO = new DetailCommandeDAO();
        List<DetailCommande> detail = dcommandeDAO.listdetailCommande();
        for (DetailCommande d : detail) {
        System.out.println("ID : " + d.getIdDetail());
        System.out.println("Date : " + d.getIdCommande().getDateCommande());
        System.out.println("Materiel : " + d.getIdMateriel().getNomMateriel());
        System.out.println("prix : " + d.getPrixUnitaire());
        System.out.println("Quantite : " + d.getQuantite());
        System.out.println("------------------------");        
        }
       
        // Commande
        CommandeDAO commandeDAO = new CommandeDAO();
        List<Commande> commandes = commandeDAO.listCommande() ;
        for (Commande c : commandes) {
        System.out.println("ID : " + c.getIdCommande());
        System.out.println("Date : " + c.getDateCommande());
        System.out.println("montant : " + c.getMontant());
        System.out.println("tel : " + c.getIdClient().getNumeroClient());
        System.out.println("utilisateur : " + c.getIdUtilisateur().getRole());
        System.out.println("------------------------");        
        }
        System.out.println("Tests terminés.");
  
      
      
       Fournisseur fournisseur = new Fournisseur();
       fournisseur.setIdFournisseur(11); // ID du fournisseur à mettre à jour
       fournisseur.setNomComplet("CIR");
       fournisseur.setAdresse("loppet");
       //fournisseur.setMateriel("Nouveau ");
       FournisseurDAO fournisseurDAO=new FournisseurDAO();
       fournisseurDAO.update(fournisseur);
*/
  }
}
       
       
       
       
        
        

  