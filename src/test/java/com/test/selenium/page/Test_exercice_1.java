package com.test.selenium.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.selenium.utils.BrowserControl;

public class Test_exercice_1 
{
	   BrowserControl bc;
	   String productName;
	   String Produi2tNameListProduct,Produi2tNamepageProduct;
	   ArrayList<String> listResultat = new ArrayList<String>();

	   
	   @FindBy(xpath="//*[@id=\"onetrust-accept-btn-handler\"]")
		private WebElement  btn_validerCookies;
	   
	
	   @FindBy(xpath="//button[@data-test='btnSearch_Header_Disabled']")
	   //@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Search'])[1]/following::*[name()='svg'][2]")
		private WebElement  barre_de_recherche;
	   
	   @FindBy(id="searchInput")
		private WebElement  zone_recherche;
	   
	   @FindBy(xpath="//button[@data-test='btnSubmitSearch']")
	   //@FindBy(xpath=" //*[@id=\"new-search-overlay\"]/div/div[1]/div[2]/div/div[1]/div[2]/button[2]")
		private WebElement  btn_rechercher;
	   
	   //div[@class='product-list-inline']
	    @FindBy(xpath="//div[@class='product-list-inline']/div[2]/a/h4/span")
	    private   List<WebElement>list_product;
	   
	    
	    //bookstore/book[position()<3]
	   //  @FindBy(xpath="//*[@id=\"new-search-overlay\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div[3]/div[2]/a")
	    @FindBy(xpath="//div[@class='product-list-inline'][2]/div[2]/a")
		private WebElement  produit_2_listProduit;
	    
	    
	    @FindBy(xpath="//div[@class='product-list-inline'][2]/div[2]/a/h4/span")
		private WebElement  ProduitNameListProduct;
	    
	    @FindBy(xpath="//span[@data-test='lblProductTitle']")
		private WebElement  ProduitNamePageProduct;
	    
	    
	   // @FindBy(xpath="//*[@id=\"new-search-overlay\"]/div/div/div[1]/button")
	    @FindBy(xpath="//button[@data-test='btnCloseSerach']")
	  	private WebElement  btnClose;
	    
	    @FindBy(xpath = "//button[@data-test='lblRecentSearchData']")
	  	private WebElement  lRecentSearch;
	    
	    
	 
	    
	    /**
		 * Constructeur: Initialisation des éléments
		 * @param driver
		 */
		public Test_exercice_1(BrowserControl bc)
		{
			this.bc = bc;
			PageFactory.initElements(bc.getDriver(), this);
		}
		
		/**
		 * Cette fonction permet de valider les cookies
		 *
		 */
	 	public void clickAccepterCookies()
	 	{
	 		this.btn_validerCookies.click();
	 	}
		
		/**
		 * Cette fonction permet de cliquer sur la barre de recherche depuis HP
		 *
		 */
	 	public void clickBarreRecherche()
	 	{
	 		//this.bc.waitTimeForVisibilityAndelementToBeClickable(60,barre_de_recherche);
	 		this.barre_de_recherche.click();
	 	}
	 	
	 	
	 	/**
		 * Cette fonction permet de cliquer sur la barre de recherche depuis HP
		 *
		 */
	 	public void clickBarreRechercheBis()
	 	{
			/*
			 * this.bc.waitTimeForVisibilityAndelementToBeClickable(60,barre_de_recherche);
			 * this.barre_de_recherche.click();
			 */
	 		Actions builder = new Actions(bc.getDriver());
	 		builder.moveToElement(barre_de_recherche).click(barre_de_recherche);
	 		builder.perform();
	 		
	 	}
	 	
	 	/**
		 * Cette fonction permet de saisir la valeur à rechercher
		 *
		 */
	 	public void setMotRechercher(String motRecherche)
	 	{
	 		this.zone_recherche.clear();
	 		this.zone_recherche.sendKeys(motRecherche);
	 	}
	 	
	 	/**
		 * Cette fonction permet de cliquer sur le bouton rechercher après avoir saisit le mot
		 *
		 */
	 	public void clickBoutonRecherche()
	 	{
	 		this.btn_rechercher.click();
	 	}
	 	
	 	/**
		 * Cette fonction permet de parcourir la liste des resultats et de renvoyer le nom de chaque produit affiché
	 	 * @return 
		 *
		 */
			 	public  ArrayList<String> getlistResultat()
			 	{
			 		 for (WebElement ele:list_product) { 
					     productName = ele.getText().toUpperCase();
					     listResultat.add(productName);
					     
			 	}
					return listResultat;
			}
			 	
			 	/**
				 * Cette fonction permet de cliquer sur leproduit 2 de la liste
				 *
				 */
			 	public void clickProduitDeuxListe()
			 	{
			 		this.produit_2_listProduit.click();
			 	}
			 	
			 	
			 	/**
				 * Cette fonction recuperer le nom du produit 2 de la liste
				 *
				 */
			 	public String  getProdui2tNameListProduct()
			 	{
			 	 return Produi2tNameListProduct=	this.ProduitNameListProduct.getText().toUpperCase();
			 	}
			 	
			 	
			 	/**
				 * Cette fonction recuperer le nom du produit 2 depuit sa page détails
				 *
				 */
			 	public String  getProdui2tNamepageProduct()
			 	{
			 	 return Produi2tNamepageProduct=	this.ProduitNamePageProduct.getText();
			 	}
			 	
			 	
			 	/**
				 * Cette fonction permet de fermer la page de recherche
				 *
				 */
			 	
			 	
			 	public void btnCloseSearcPage()
			 	{
					
			 		Actions builder = new Actions(bc.getDriver());
			 		builder.moveToElement(btnClose).click(btnClose);
			 		builder.perform();
			 	
			 	}
			 	
			 	
			 	/**
				 * Cette fonction me permet de recuper la valeur du reccent search
				 *
				 */
			 	
			 	
			 	public String getReccentSearch()
				{

			 		Actions builder = new Actions(bc.getDriver());
			 		builder.moveToElement(lRecentSearch);
			 		builder.perform();
			 		return this.lRecentSearch.getText().toUpperCase();
			 		}
			 	
			 	
			 	
				/**
				 * Cette fonction me permet de cliquer la valeur du reccent search
				 *
				 */
			 	
			 	
			 	public void clickReccentSearch()
				{

			 		 this.lRecentSearch.click();
			 	
			 		}
			 	
}
