package page.object.model;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * La clase AddressBookPage permite gestionar e interactuar con los elementos de la página Address Book
 * @author Neyder Leoncio Daza Cardona
 *
 */
public class AddressBookPage {
	
	/**
	 * Se inicializan las variables globales con las cuales se trabajarán
	 */
	WebDriver controlador;
	
	By newAddressButtom = By.linkText("New Address");
	By continueButtom=By.xpath("//input[@value='Continue']");
	
	By firstName=By.id("input-firstname");
	By lastName=By.id("input-lastname");
	By company=By.id("input-company");
	By address1=By.id("input-address-1");
	By address2=By.id("input-address-2");
	By city=By.id("input-city");
	By postCode=By.id("input-postcode");
	By country=By.id("input-country");
	By regionState=By.id("input-zone");
	By message= By.cssSelector("h2");
	
	/**
	 * Constructor de la clase AddressBookPage permite interactuar con la página Address Book
	 * @param driver
	 */
	public AddressBookPage(WebDriver driver) {
		 this.controlador=driver;
	 }
	
	
	/**
	 * El método clickNew Address permite realizar de forma automática click en el botón "New Address"
	 */
	public void clickNewAddress() {
		 controlador.findElement(newAddressButtom).click();
	 }
	
	/**
	 * El método addFirstName permite rellenar el campo "First Name" de forma automática
	 * @param nombres
	 */
	public void addFirstName(String nombres) {
		controlador.findElement(firstName).clear();
		controlador.findElement(firstName).sendKeys(nombres);
	}
	
	/**
	 * El método addLastName permite rellenar el campo "Last Name" de forma automática
	 * @param apellidos
	 */
	public void addLastName(String apellidos) {
		controlador.findElement(lastName).clear();
		controlador.findElement(lastName).sendKeys(apellidos);
	}
	
	/**
	 * El método addCompany permite rellenar el campo "company" de forma automática
	 * @param compania
	 */
	public void addCompany(String compania) {
		controlador.findElement(company).clear();
		controlador.findElement(company).sendKeys(compania);
	}
	
	/**
	 * El método addAddress1 permite rellenar el campo "Addres1" de forma automática
	 * @param direccion1
	 */
	public void addAddress1(String direccion1) {
		controlador.findElement(address1).clear();
		controlador.findElement(address1).sendKeys(direccion1);
	}
	
	/**
	 * El método addAddress2 permite rellenar el campo "Address2" de forma automática
	 * @param direccion2
	 */
	public void addAddress2(String direccion2) {
		controlador.findElement(address2).clear();
		controlador.findElement(address2).sendKeys(direccion2);
	}
	
	/**
	 * El método addCity permite rellenar el campo "City" de forma automática
	 * @param ciudad
	 */
	public void addCity(String ciudad) {
		controlador.findElement(city).clear();
		controlador.findElement(city).sendKeys(ciudad);
	}
	
	/**
	 * El método addPostCode permite rellenar el campo "Post Code" de forma automática
	 * @param codigoPostal
	 */
	public void addPostCode(String codigoPostal) {
		controlador.findElement(postCode).clear();
		controlador.findElement(postCode).sendKeys(codigoPostal);
	}
	
	/**
	 * El método addCountry permite rellenar el campo "Country" de forma automática
	 * @param pais
	 */
	public void addCountry(String pais) {
		Select seleccionaPais=new Select(controlador.findElement(country));
		seleccionaPais.selectByVisibleText(pais);
	}
	
	/**
	 * El método addRegionState permite rellenar el campo "Region/State" de forma automática
	 * @param estado
	 */
	public void addRegionState(String estado) {
		Select seleccionaEstado=new Select(controlador.findElement(regionState));
		seleccionaEstado.selectByVisibleText(estado);
	}
	
	/**
	 * El método addNewAddress permite rellenar todos los campos necesarios para registrar una nueva dirección en el sistema
	 * @param firstName
	 * @param lastName
	 * @param company
	 * @param address1
	 * @param address2
	 * @param city
	 * @param postCode
	 * @param country
	 * @param regionState
	 */
	public void addNewAdress(String firstName,String lastName, String company,String address1,String address2,String city,String postCode,String country,String regionState) {
		addCountry(country);
		addFirstName(firstName);
		addLastName(lastName);
		addAddress1(address1);
		addCity(city);
		addPostCode(postCode);
		addRegionState(regionState);
		if(!company.isEmpty() || company!=null) {
			addCompany(company);
		}
		if(!address2.isEmpty()||address2!=null) {
			addAddress2(address2);
		}
	}
	
	/**
	 * El método clickContinueButtom permite hacer click de forma automática en el botón "Continue"
	 */
	public void clickContinueButtom() {
		controlador.findElement(continueButtom).click();
	}
	
	/**
	 * El método result permite buscar una cadena de texto en la página web
	 * @return String
	 */
	public String result() {
		String resultado =controlador.findElement(message).getText();
		return resultado;
	}

}
