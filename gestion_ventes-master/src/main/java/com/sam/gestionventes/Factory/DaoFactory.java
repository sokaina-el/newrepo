package com.sam.gestionventes.Factory;

import com.sam.gestionventes.Dao.AchatDao;
import com.sam.gestionventes.Dao.ArticleDao;
import com.sam.gestionventes.Dao.ClientDao;
import com.sam.gestionventes.Dao.CommandeDao;
import com.sam.gestionventes.Dao.InventaireDao;
import com.sam.gestionventes.Dao.UtilisateurDao;

public class DaoFactory {

	private static ArticleDao articleDao;
	private static CommandeDao commandeDao;
	private static ClientDao clientDao;
	private static UtilisateurDao utilisateurDao;
	private static InventaireDao inventaireDao;
	private static AchatDao achatDao;
	
	/**
	 * un Bloc static pour initialiser les membres statiques de la classe
	 */
	static {
		articleDao = new ArticleDao();
		commandeDao = new CommandeDao();
		clientDao = new ClientDao();
		utilisateurDao = new UtilisateurDao();
		inventaireDao = new InventaireDao();
		achatDao = new AchatDao();
	}
	
	public static ArticleDao getArticleDao() {
		return articleDao;
	}
	public static CommandeDao getCommandeDao() {
		return commandeDao;
	}
	public static ClientDao getClientDao() {
		return clientDao;
	}
	public static UtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}
	public static InventaireDao getInventaireDao() {
		return inventaireDao;
	}
	public static AchatDao getAchatDao() {
		return achatDao;
	}
}
