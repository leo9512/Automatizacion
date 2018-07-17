package page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * 
 * @author Neyder Leoncio Daza Cardona
 *La clase LoginPage simula una instancia de la página del login del sistema de ninja store
 */
public class LoginPage {
	 
	/*
	 * Se crean e inicializan las variables globales con las cuales se trabajarán 
	 */
	 WebDriver controlador;
	 By userName = By.id("input-email");
	 By password = By.id("input-password");
	 By loginButtom = By.xpath("//input[@value='Login']");
	 
	 /**
	  * Constructor de la clase LoginPage, recibe como parámetro el driver del navegador
	  * @param driver
	  */
	 public LoginPage(WebDriver driver) {
		 this.controlador=driver;
	 }
	 
	 /**
	  * El método addUserName permite rellenar automaticamente el campo en donde el usuario ingresaría el "username"
	  * @param nombreUsuario
	  */
	 public void addUserName(String nombreUsuario) {
		 controlador.findElement(userName).clear();
		 controlador.findElement(userName).sendKeys(nombreUsuario);
		 
	 }
	 
	 /**
	  * El método add Password permite rellenar automaticamnte el campo donde el usuario ingresaría su "password"
	  * @param contrasena
	  */
	 public void addPassword(String contrasena) {
		 controlador.findElement(password).clear();
		 controlador.findElement(password).sendKeys(contrasena);
	 }
	 
	 /**
	  * El método loginUser permite rellenar de manera automatica los campos de "username" y "password"
	  * @param nombreUsuario
	  * @param contrasena
	  */
	 public void loginUser(String nombreUsuario,String contrasena) {
		 addUserName(nombreUsuario);
		 addPassword(contrasena);
	 }
	 
	 /**
	  * El método clickLoginButtom permite hecer click de forma automatica para realizar el logueo del usuario
	  */
	 public void clickLoginButtom() {
		 controlador.findElement(loginButtom).click();
	 }

}
