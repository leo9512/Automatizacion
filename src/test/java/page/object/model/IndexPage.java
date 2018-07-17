package page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.object.model.LoginPage;

/**
 * 
 * @author Neyder Leoncio Daza Cardona
 * Esta clase permite realizar la gestion del navegador web, como tambien la navegación entre páginas.
 *
 */
public class IndexPage {
	
	WebDriver controlador;
	
	/*
	 * Constructor de la clase, permite iniciar el navegador web, en este caso google chrome. Además, se dirige a la pagina principal de ninjastore
	 */
	public IndexPage() {
		System.setProperty("webdriver.chrome.driver","/home/isabel/eclipse-workspace/ninjaStore/driver/chromedriver");
	    controlador = new ChromeDriver();
	    controlador.manage().window().maximize();
	    controlador.get("http://tutorialsninja.com/demo/");
	}
	
	/**
	 * El método getLoginPage crea un objeto de la clase LoginPage y retorna dicho objeto.
	 * @return LoginPage
	 * 
	 */
	public LoginPage getLoginPage() {
		controlador.findElement(By.className("dropdown")).click();
		controlador.findElement(By.linkText("Login")).click();
		LoginPage loginPage=new LoginPage(controlador);
		return loginPage;
		
	}
	
	/**
	 * El método getAddressBookPage crea un objeto de la clase AddressBookPage y retorna dicho objeto.
	 * @return
	 */
	public AddressBookPage getAddressBookPage() {
		controlador.findElement(By.linkText("Address Book")).click();
		AddressBookPage addressBookPage=new AddressBookPage(controlador);
		return addressBookPage;
	}

	/**
	 * el método close permite cerrar el navegador que se abrio para realizar las pruebas
	 */
	public  void close() {
		controlador.close();
	}
}
