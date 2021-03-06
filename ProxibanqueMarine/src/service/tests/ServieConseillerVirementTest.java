package service.tests;

import org.junit.Assert;
import org.junit.Test;

import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import service.IConseillerVirement;
import service.ServiceConseiller;

public class ServieConseillerVirementTest {


	//tester virement entre deux comptes 
	@Test
	public void testEffectuerVirement() {
        IConseillerVirement sc = new ServiceConseiller();
		
		Compte cc1 = new Compte(123,10000,"01 janvier 2011",1); 
		
		Compte cc2 = new Compte(456,300,"10 janvier 2016",2);
	
		int lemontant = 600;
		sc.EffectuerVirement(cc1, cc2, lemontant);	
		
		Compte cc3 = new CompteCourant();
		cc3.setSolde(10000-lemontant);
		Compte cc4 = new CompteCourant();
		cc4.setSolde(300+lemontant);
		
		Assert.assertEquals(true, (cc3.getSolde()==cc1.getSolde())&&(cc4.getSolde()==cc2.getSolde()));
	
	}

	
	//Cas montant n�gatif
	@Test
	public void testEffectuerVirement2() {
		IConseillerVirement  sc = new ServiceConseiller();
		
		Compte cc1 = new Compte(123,10000,"01 janvier 2011"); 
		
		Compte cc2 = new Compte(456,300,"10 janvier 2016");
	
		int lemontant = -600;
		sc.EffectuerVirement(cc1, cc2, lemontant);	
		
		Compte cc3 = new Compte();
		cc3.setSolde(10000);
		Compte cc4 = new Compte();
		cc4.setSolde(300);
		
		Assert.assertEquals(true, (cc3.getSolde()==cc1.getSolde())&&(cc4.getSolde()==cc2.getSolde()));
	
	}
	
	//Cas virement entre deux comptes courant decouvert >-1000 pour un compte courant
	@Test
	public void testEffectuerVirement3() {
		IConseillerVirement  sc = new ServiceConseiller();
		
		Compte cc1 = new Compte(123,10000,"01 janvier 2011",1000); //compte courant
		
		Compte cc2 = new Compte(456,300,"10 janvier 2016");
	
		int lemontant = 20000;
		sc.EffectuerVirement(cc1, cc2, lemontant);	
		
		Compte cc3 = new CompteCourant();
		cc3.setSolde(10000);
		Compte cc4 = new CompteCourant();
		cc4.setSolde(300);
		
		Assert.assertEquals(true, (cc3.getSolde()==cc1.getSolde())&&(cc4.getSolde()==cc2.getSolde()));
	
	}
	
	// Test identique testEffectuerVirement3 mais avec un compte epargne
	@Test
	public void testEffectuerVirement4() {
		IConseillerVirement  sc = new ServiceConseiller();
		
		Compte cc1 = new Compte(123, 10000,"01 janvier 2011",3); //compte epargne
		
		Compte cc2 = new Compte(456,300,"10 janvier 2016");
	
		int lemontant = 20000;
		sc.EffectuerVirement(cc1, cc2, lemontant);	
		
		Compte cc3 = new CompteCourant();
		cc3.setSolde(10000);
		Compte cc4 = new CompteCourant();
		cc4.setSolde(300);
		
		Assert.assertEquals(true, (cc3.getSolde()==cc1.getSolde())&&(cc4.getSolde()==cc2.getSolde()));
	
	}
	
	
	
	
}
