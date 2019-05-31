package com.sam.gestionventes.Actions;

//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;

import com.sam.gestionventes.Entity.Utilisateur;
import com.sam.gestionventes.Factory.ServiceFactory;
import com.sam.gestionventes.Utils.StringUtils;

@ManagedBean(name = "ajoutUtilisateur")
@RequestScoped
public class AjoutUtilisateurAction {
	
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private String emailUtilisateur;
	private String passwordUtilisateur;
	private boolean addSuccess;
	private Part uploadedFile;
	
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}
	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}
	public String getEmailUtilisateur() {
		return emailUtilisateur;
	}
	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}
	public String getPasswordUtilisateur() {
		return passwordUtilisateur;
	}
	public void setPasswordUtilisateur(String passwordUtilisateur) {
		this.passwordUtilisateur = passwordUtilisateur;
	}
	
	public boolean isAddSuccess() {
		return addSuccess;
	}
	public void setAddSuccess(boolean addSuccess) {
		this.addSuccess = addSuccess;
	}
	public void addUsreAction() {
//		String folder = "/Gestion_Ventes/src/main/webapp/assets/app/media/img/users";
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom(this.nomUtilisateur);
		utilisateur.setPrenom(this.prenomUtilisateur);
		utilisateur.setLogin(this.emailUtilisateur);
		utilisateur.setPassword(StringUtils.sha256(passwordUtilisateur));
		
		if(ServiceFactory.getUserService().createUser(utilisateur)) {
			this.addSuccess = true;
			
			this.nomUtilisateur = "";
			this.prenomUtilisateur = "";
			this.emailUtilisateur = "";
			this.passwordUtilisateur = "";
		}
		else {
			this.addSuccess = false;
		}
//		try {
//			System.out.println(uploadedFile.getSubmittedFileName());
//			InputStream input = uploadedFile.getInputStream();
//			 String fileName = uploadedFile.getSubmittedFileName();
//			 System.out.println(fileName);
//			         Files.copy(input, new File(folder, fileName).toPath());
//			     }
//			     catch (IOException e) {
//			         e.printStackTrace();
//			     }
		
	}
	public Part getUploadedFile() {
		return uploadedFile;
	}
	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
}
