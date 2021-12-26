package com.test.selenium.testCase;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.selenium.page.Test_exercice_1;
import com.test.selenium.page.Test_exercice_2;
import com.test.selenium.utils.BrowserControl;



public class ExerciceTestCase {
	
	private static final Logger LOG = LogManager.getLogger(ExerciceTestCase.class);
	private BrowserControl bc;
	private StopWatch globalTime;
	private	Test_exercice_1 test_exercice_1;
	private Test_exercice_2 test_exercice_2;
	private String NomProduit2DeLaListe,NomProduitPageProduit;

	@Parameters({ "navigateur"})
	@BeforeTest
	public void setup( String navigateur) throws IOException
	{
		LOG.info("Starting test ...");
		globalTime = new StopWatch();
		globalTime.start();
		bc = new BrowserControl(navigateur);;
		bc.launchURL(bc.getUrl());
		bc.impliciteTime(10);
	}
	
	
	@Test(description = "Ce test permet de verifier si on est à la page d'acueil")
	public void accueil()
	{
		Assert.assertEquals(bc.getUrl(),bc.currentURL());
		System.out.println("urls conformes");
	}
	
	
	@Parameters({"motRcherche"})
	@Test(description = "Ce test traite l'exercice 1",dependsOnMethods = "accueil")
	public void exercice_1(String motRechercher)
	{
		test_exercice_1 =new Test_exercice_1(this.bc);
	    test_exercice_1.clickAccepterCookies();
		test_exercice_1.clickBarreRecherche();
		test_exercice_1.setMotRechercher(motRechercher);
		test_exercice_1.clickBoutonRecherche();
		bc.waitSomeTime(2000);
		test_exercice_1.btnCloseSearcPage();
		test_exercice_1.clickBarreRechercheBis();
		bc.waitSomeTime(3000);
		System.out.println(test_exercice_1.getReccentSearch());
		Assert.assertEquals(test_exercice_1.getReccentSearch(),motRechercher);
		test_exercice_1.clickReccentSearch();
		
		
		  for (String produit :test_exercice_1.getlistResultat()) {
		  
		  assertTrue(produit.contains(motRechercher)); System.out.println("le produit "
		  +produit + "contient" +motRechercher); }
		  
		  bc.waitSomeTime(3000);
		  
		  NomProduit2DeLaListe =test_exercice_1.getProdui2tNameListProduct();
		  test_exercice_1.clickProduitDeuxListe();
		  NomProduitPageProduit=test_exercice_1.getProdui2tNamepageProduct();
		  Assert.assertEquals(NomProduitPageProduit,NomProduit2DeLaListe);
		  System.out.println("nom produitpage produit et de la  liste produit conformes");
		 
			 
	}
	
	  @Parameters({"quantite","nomProduit"})
	  @Test(description = "Ce test traite l'exercie 2", dependsOnMethods =  "accueil") 
	  public void exercice_2(String quantite,String nomProduit) 
	  {
	  test_exercice_2 = new Test_exercice_2(this.bc); 
	  test_exercice_2. clickbtnMenuMakup();  
	  test_exercice_2. clickbtnMenuMakupLipstick(); 
	  bc.waitSomeTime(3000);
	  //scroller vers le ba  pour voir les produits
	  JavascriptExecutor Js1 = (JavascriptExecutor)  this.bc.getDriver(); 
	  Js1.executeScript("window.scrollBy(0,1000)");
	  
	  test_exercice_2.clickAddPanier(nomProduit);
	  //test_exercice_2. clickBtnAjouterProduitAuPanier(); 
	  test_exercice_2. clickAjouterAuPanier(); 
	  bc.waitSomeTime(8000);
	  test_exercice_2. clickbtnbtnAfficherPanier(); 
	  Assert.assertEquals(test_exercice_2. getProduitName(),nomProduit);
	  System.out.println("le produit affiché dans le panier est" +nomProduit);
	  Assert.assertEquals(test_exercice_2.getQuantitetProduiPanier(),quantite);
	  System.out.println("quantité produit =1");
	  
	  
	  Assert.assertEquals(test_exercice_2.getPrixUnitaireProduiPanier(),
	  test_exercice_2.getTotalPanier());
	  System.out.println("prix unitaire et prix total  conformes");
	  
	  
	  }
	 
	
	 @AfterTest
	  public void browserClose() {
		 LOG.info("end test ...");
		  bc.closeBrowser();
		  globalTime.stop();
		  System.out.println("Global Time Execution:"+globalTime);
		  
	  }


}
