package hibernate;

import java.util.ArrayList;

import form.menu;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class fonctions {
	// Cette fonction encode des chaînes de caractères en MD5
	public static String md5(String password)
    {
        byte[] uniqueKey = password.getBytes();
        byte[] hash      = null;

        try
        {
            hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new Error("No MD5 support in this VM.");
        }

        StringBuilder hashString = new StringBuilder();
        for (int i = 0; i < hash.length; i++)
        {
            String hex = Integer.toHexString(hash[i]);
            if (hex.length() == 1)
            {
                hashString.append('0');
                hashString.append(hex.charAt(hex.length() - 1));
            }
            else
                hashString.append(hex.substring(hex.length() - 2));
        }
        return hashString.toString();
    }
	
	// Cette fonction créé un nouveau menu
	public void close(){
		menu eMenu = new menu();
		eMenu.setVisible(true);
	}
	
	// Fonction permettant de dire si une chaine de caractère est un entier
	public static boolean isInt(String chaine){ 
		boolean valeur = true; 
		char[] tab = chaine.toCharArray(); 
		
		for(char carac : tab){ 
			if(!Character.isDigit(carac) && valeur){
				valeur = false;
			} 
		}
		return valeur; 
	}
	
	// Fonction qui récupère le nom des colonnes des tables
	public static ArrayList<String> nomColonnes(String table) throws Exception{
		// Création de la liste
		ArrayList<String> lesNomsColonnes = new ArrayList<String>();
		
		// On se connecte à la base
		Connection access = DBConnection.getInstance();
		
		// Récupération des métadonnées à partir de Connection
		DatabaseMetaData dmd = access.getMetaData();
		
		// Récupération des informations
		ResultSet resultat = dmd.getColumns(access.getCatalog(),null, table, "%");
		
		// Ajout des données dans la liste
		while(resultat.next()){
			lesNomsColonnes.add(resultat.getObject(4).toString());
		}
		return lesNomsColonnes;
	}
}
