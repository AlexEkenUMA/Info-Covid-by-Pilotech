package es.pilotech.infocovid.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;

import es.pilotech.infocovid.ConfiguradorInfocovid;
import es.pilotech.infocovid.dominio.Publicacion;
import es.pilotech.infocovid.service.ForoService;

@Transactional
@SpringBootTest
@ContextConfiguration(classes = { ConfiguradorInfocovid.class })
class ForoControllerTest {

	@Mock
	private Model model;

	@Autowired
	ForoController foroController;

	@Autowired
	ForoService foroService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		foroService.deleteAll();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void CuandoLlamoAlPanelDeForoDevuelveLaPesta├▒a(){

		String direccion = foroController.listaForo(model, 0);

		assertEquals("foro/index", direccion);

	}

	@Test
	void CuandoLlamoAlPanelDeCrearPublicacionDevuelveLaPesta├▒a(){

		String direccion = foroController.addPost(model,0);

		assertEquals("foro/add", direccion);

	}

	@Test
	void CuandoLlamoAlPanelDeGuardarPublicacionDevuelveLaPesta├▒aPorDefecto(){

		Publicacion p = new Publicacion();
		
		String direccion = foroController.savePost(p, 0);

		assertEquals("redirect:/foro?type=1", direccion);
		
	}

	@Test
	void CuandoLlamoAlPanelDeGuardarPublicacionDevuelveLaPesta├▒aTipo1(){

		Publicacion p = new Publicacion();
		
		String direccion = foroController.savePost(p, 1);

		assertEquals("redirect:/foro?type=1", direccion);
		
	}

	@Test
	void CuandoLlamoAlPanelDeGuardarPublicacionDevuelveLaPesta├▒aTipo2(){

		Publicacion p = new Publicacion();
		
		String direccion = foroController.savePost(p, 2);

		assertEquals("redirect:/foro?type=2", direccion);
		
	}

	@Test
	void CuandoLlamoAlPanelDeGuardarPublicacionDevuelveLaPesta├▒aTipo3(){

		Publicacion p = new Publicacion();
		
		String direccion = foroController.savePost(p, 3);

		assertEquals("redirect:/foro?type=3", direccion);
		
	}

	@Test
	void CuandoLlamoAlPanelDeEditarUnaPublicacionDevuelveLaPesta├▒a(){

		String direccion = foroController.editPost(0,0, model);

		assertEquals("foro/add", direccion);

	}

	@Test
	void CuandoLlamoAlPanelDeVerUnaPublicacionDevuelveLaPesta├▒a(){

		String direccion = foroController.viewPost(0, 0, model);

		assertEquals("foro/view", direccion);

	}

	@Test
	void CuandoLlamoAlPanelDeModeracionDelForoDevuelveLaPesta├▒a(){

		String direccion = foroController.viewVerifPanel(model, 0);

		assertEquals("foro/verif/index", direccion);

	}

	@Test
	void CuandoLlamoAlPanelDeVerUnaPublicacionPorVerificarDevuelveLaPesta├▒a(){

		String direccion = foroController.viewVerifPost(0, 0, model);

		assertEquals("foro/verif/view", direccion);

	}

	@Test
	void CuandoLlamoAlPanelDeVerificarUnaPublicacionDevuelveLaPesta├▒aPorDefecto(){

		Publicacion p = new Publicacion();
		p.setVerificado(false); 
		foroService.deleteAll();
		foroService.save(p);

		List<Publicacion> ListaPublicacion = foroService.getAll();
		int idpublicacion = ListaPublicacion.get(0).getId();

		String direccion = foroController.saveVerifPost(idpublicacion, 0);

		assertEquals("redirect:/foro?type=2", direccion);

	}

	@Test
	void CuandoLlamoAlPanelDeVerificarUnaPublicacionDevuelveLaPesta├▒aTipo2(){

		Publicacion p = new Publicacion();
		p.setVerificado(false); 
		foroService.deleteAll();
		foroService.save(p);

		List<Publicacion> ListaPublicacion = foroService.getAll();
		int idpublicacion = ListaPublicacion.get(0).getId();

		String direccion = foroController.saveVerifPost(idpublicacion, 2);

		assertEquals("redirect:/foro?type=2", direccion);

	}

	@Test
	void CuandoLlamoAlPanelDeVerificarUnaPublicacionDevuelveLaPesta├▒aTipo3(){

		Publicacion p = new Publicacion();
		p.setVerificado(false); 
		foroService.deleteAll();
		foroService.save(p);

		List<Publicacion> ListaPublicacion = foroService.getAll();
		int idpublicacion = ListaPublicacion.get(0).getId();

		String direccion = foroController.saveVerifPost(idpublicacion, 3);

		assertEquals("redirect:/foro?type=3", direccion);

	}

	@Test
	void CuandoLlamoAlPanelDeBorrarUnaPublicacionDevuelveLaPesta├▒aPorDefecto(){

		foroService.deleteAll();
		foroService.save(new Publicacion());

		List<Publicacion> ListaPublicacion = foroService.getAll();
		int idpublicacion = ListaPublicacion.get(0).getId();

		String direccion = foroController.deletePost(idpublicacion, 0);

		assertEquals("redirect:/foro?type=1", direccion);

	}

	@Test
	void CuandoLlamoAlPanelDeBorrarUnaPublicacionDevuelveLaPesta├▒aTipo1(){

		foroService.deleteAll();
		foroService.save(new Publicacion());

		List<Publicacion> ListaPublicacion = foroService.getAll();
		int idpublicacion = ListaPublicacion.get(0).getId();

		String direccion = foroController.deletePost(idpublicacion,1);

		assertEquals("redirect:/foro?type=1", direccion);

	}

	@Test
	void CuandoLlamoAlPanelDeBorrarUnaPublicacionDevuelveLaPesta├▒aTipo2(){

		foroService.deleteAll();
		foroService.save(new Publicacion());

		List<Publicacion> ListaPublicacion = foroService.getAll();
		int idpublicacion = ListaPublicacion.get(0).getId();

		String direccion = foroController.deletePost(idpublicacion,2);

		assertEquals("redirect:/foro?type=2", direccion);

	}

	@Test
	void CuandoLlamoAlPanelDeBorrarUnaPublicacionDevuelveLaPesta├▒aTipo3(){

		foroService.deleteAll();
		foroService.save(new Publicacion());

		List<Publicacion> ListaPublicacion = foroService.getAll();
		int idpublicacion = ListaPublicacion.get(0).getId();

		String direccion = foroController.deletePost(idpublicacion,3);

		assertEquals("redirect:/foro?type=3", direccion);

	}
}
