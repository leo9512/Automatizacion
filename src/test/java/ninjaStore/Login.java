package ninjaStore;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.object.model.AddressBookPage;
import page.object.model.IndexPage;
import page.object.model.LoginPage;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;

/**
 * La clase Login permite realizar el Login y el registro de una nueva dirección para un usuario de forma automática
 * @author Neyder Leoncio Daza Cardona
 *
 */
public class Login {
	
	/**
	 * Se inicializan las variables globales con los que se trabajarán
	 */
	IndexPage paginaInicio;
	LoginPage paginaLogin;
	AddressBookPage paginaLibroDirecciones;

	/**
	 * Este método permite realizar el Login a un usuario y dirigirse a la página de registro de direcciones
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	@Given("^el usuario inicia sesion con el username \"([^\"]*)\" y el password \"([^\"]*)\", se dirige a Address Book y da click en New Address$")
	public void el_usuario_inicia_sesion_con_el_username_y_el_password_se_dirige_a_Address_Book_y_da_click_en_New_Address(String username, String password) throws Exception {
		paginaInicio=new IndexPage();
	    paginaLogin = paginaInicio.getLoginPage();
	    paginaLogin.loginUser(username, password);
	    paginaLogin.clickLoginButtom();
	    paginaLibroDirecciones=paginaInicio.getAddressBookPage();
		paginaLibroDirecciones.clickNewAddress();
	    
	}
	
	/**
	 * Este método permite ingresar todos los campos necesarios para realizar el registro de una nueva dirección de forma automática
	 * @param firstName
	 * @param lastName
	 * @param company
	 * @param address1
	 * @param address2
	 * @param city
	 * @param postCode
	 * @param country
	 * @param regionState
	 * @throws Exception
	 */
	@When("^el usuario llena los campos requeridos nombre\"([^\"]*)\", apellido\"([^\"]*)\", compañia\"([^\"]*)\", direccion uno\"([^\"]*)\", direccion dos\"([^\"]*)\", ciudad\"([^\"]*)\", codigo postal\"([^\"]*)\", pais\"([^\"]*)\", estado o region\"([^\"]*)\" y hace click en continue$")
	public void el_usuario_llena_los_campos_requeridos_nombre_apellido_compañia_direccion_uno_direccion_dos_ciudad_codigo_postal_pais_estado_o_region_y_hace_click_en_continue(String firstName, String lastName,String company, String address1, String address2, String city, String postCode, String country, String regionState) throws Exception {
		paginaLibroDirecciones.addNewAdress(firstName, lastName, company, address1, address2, city, postCode, country, regionState);
		paginaLibroDirecciones.clickContinueButtom();
	    Thread.sleep(2000);
	}

	/**
	 * Este metodo permite realizar la verificación de la página en la cual se encuentra el usuario actualmente
	 * @param mensaje
	 * @throws Exception
	 */
	@Then("^el usuario deberia aparecer en la página con titulo \"([^\"]*)\"$")
	public void el_usuario_deberia_aparecer_en_la_página_con_titulo(String mensaje) throws Exception {
		String resultado=paginaLibroDirecciones.result();
	    paginaInicio.close();
	    Assert.assertThat(resultado, CoreMatchers.containsString(mensaje));
	}
}
