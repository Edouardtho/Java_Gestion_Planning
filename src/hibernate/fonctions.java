package hibernate;

public class fonctions {
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
}
