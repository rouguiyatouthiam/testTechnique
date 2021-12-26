package com.test.selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.test.selenium.utils.BrowserControl;

public class Test_exercice_2 

{
	         BrowserControl bc;
	         String productNamePanier,quantite,prix_unitaire,total;
	         
	         
	         @FindBy(id=("makeup"))
				private WebElement  btn_MenuMakup;
	         
	         @FindBy(xpath=("//*[@id=\"main-navigation\"]/ul[2]/li[3]/div/div/div[2]/div[4]/div[2]/ul/li[1]/a"))
				private WebElement  btn_MenuMakupLipstick;
	         
	         
			@FindBy(xpath=("//*[@id=\"main\"]/div[3]/div[3]/div/div[2]/div[1]/div[1]/article/div[2]/div[2]/div[2]/button[2]"))
			private WebElement  btn_AjouterProduitAuPanier;
	
			
			@FindBy(xpath=("/html/body/div[15]/div/div[3]/div[1]/div[6]/form/ul/li/p/button"))
			private WebElement  btn_AjouterAuPanier;
			
			
			@FindBy(xpath=("/html/body/div[15]/div/div[3]/div[4]/div/a"))
			private WebElement  btn_AfficherPanier;
	
			
			@FindBy(xpath=( "//*[@id=\"151167\"]/span[1]"))
			private WebElement  productName;
			
		
			
			@FindBy(xpath=( "//*[@id=\"prd0\"]/option[1]" ))
			private WebElement  quantite_panier;
			
			@FindBy(xpath=("//*[@id=\"updateCartForm0\"]/div[1]/div[2]/div/p" ))
			private WebElement  prixUnitaire_panier;
			
			@FindBy(xpath=("//*[@id=\"main\"]/div[3]/div/div/div/div[2]/div/table/tbody/tr[4]/td" ))
			private WebElement  total_panier;
	
	   /**
			 * Constructeur: Initialisation des éléments
			 * @param driver
			 */
			public Test_exercice_2(BrowserControl bc)
			{
				this.bc = bc;
				PageFactory.initElements(bc.getDriver(), this);
			}
			
			
			/**
			 * Cette fonction permet de cliquer sur le menu Makup
			 *
			 */
		 	public void clickbtnMenuMakup()
		 	{
		 		
		 		WebDriverWait t = new WebDriverWait(this.bc.getDriver(), 10); 
		 		t.until(ExpectedConditions.visibilityOf(btn_MenuMakup));  
		 		t.until(ExpectedConditions.elementToBeClickable(btn_MenuMakup));
		 		
		 	
		 		this.btn_MenuMakup.click();
		 	}
		 	
		 	
		 	
			/**
			 *Cette fonction permet de cliquer sur lipstick depuis le menu Makup
			 *
			 */
		 	public void clickbtnMenuMakupLipstick()
		 	{
		 		this.btn_MenuMakupLipstick.click();
		 	}
			
		 	
		 	
		 	
			/**
			 * Cette fonction permet de cliquer sur le bouton ajouter au panier depuis la page hub des lipstick
			 *
			 */
		 	public void clickBtnAjouterProduitAuPanier()
		 	{
		 		this.btn_AjouterProduitAuPanier.click();
		 	}
			
		 	
		 	/**
			 * Cette fonction permet d ajouter le produit  au panier depuis le popup
			 *
			 */
		 	public void clickAjouterAuPanier()
		 	{
		 		this.btn_AjouterAuPanier.click();
		 	}
			
		 	
			/**
			 * Cette fonction permet de ferer le popup panier
			 *
			 */
		 	public void clickbtnbtnAfficherPanier()
		 	{
		 		this.btn_AfficherPanier.click();
		 	}
		 	
		 	
		
		 	
		 	/**
			 * Cette fonction permet de recuperer le nom du produit depuis la page hub lipstick
			 *
			 */
			
			  public String getProduitName() 
			  { 
				  return productNamePanier =   this.productName.getText().toUpperCase();
				  
			  }
			  
			 
			  
			  /**
				 * Cette fonction permet de recuperer la quantité du produit dans la page panier
				 *
				 */
				
				  public String getQuantitetProduiPanier() 
				  { 
					 
					   quantite =   this.quantite_panier.getAttribute("value");
					 
					  return quantite;
					  
				  }
				  
				  /**
					 * Cette fonction permet de recuperer le prix unitaire du produit dans le  panier
					 *
					 */
					
					  public String getPrixUnitaireProduiPanier() 
					  { 
						   prix_unitaire =   this.prixUnitaire_panier.getText().replaceAll("[^0-9 . ]", "");
						  return prix_unitaire;
						  
					  }
					  
					  
					  /**
						 * Cette fonction permet de recuperer le montant total du panier
						 *
						 */
						
						  public String getTotalPanier() 
						  { 
							  //return total =   this.total_panier.getText();
							 total =   this.total_panier.getText().replaceAll("[^0-9 .]", "");
							return total.replaceAll("\\s+","");
							  
						  }
			
}
