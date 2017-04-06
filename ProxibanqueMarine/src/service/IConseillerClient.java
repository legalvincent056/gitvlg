package service;

import metier.Adresse;
import metier.Client;
import metier.Conseiller;

public interface IConseillerClient {

	
	public void AjouterClient(Conseiller co, Client c);
	public void ModifierClient(Client c, Adresse a, int telephone);
	public void SupprimerClient (Client c, Conseiller co);
	public void AfficherClient(Client c);
	
	
	
}
