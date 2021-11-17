package com.example.Equipo3ProyectoFiverr;

import com.example.Equipo3ProyectoFiverr.Services.ServiceImages;
import com.example.Equipo3ProyectoFiverr.entities.Categorias;
import com.example.Equipo3ProyectoFiverr.entities.Empleadores;
import com.example.Equipo3ProyectoFiverr.entities.Opiniones;
import com.example.Equipo3ProyectoFiverr.entities.Trabajos;
import com.example.Equipo3ProyectoFiverr.repositories.CategoriasRepository;
import com.example.Equipo3ProyectoFiverr.repositories.EmpleadoresRepository;
import com.example.Equipo3ProyectoFiverr.repositories.OpinionesRepository;
import com.example.Equipo3ProyectoFiverr.repositories.TrabajosRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@SpringBootApplication
public class Equipo3ProyectoFiverrApplication {

	public static void main(String[] args) {

		// Se crea el application context
		ApplicationContext context =  SpringApplication.run(Equipo3ProyectoFiverrApplication.class, args);

		//Se crean los repositorios
		CategoriasRepository categoriasRepository = context.getBean(CategoriasRepository.class);
		EmpleadoresRepository empleadoresRepository = context.getBean(EmpleadoresRepository.class);
		OpinionesRepository opinionesRepository = context.getBean(OpinionesRepository.class);
		TrabajosRepository trabajosRepository = context.getBean(TrabajosRepository.class);

		//Se crea el objeto fecha
		LocalDate fecha1 = LocalDate.of(2021, Calendar.NOVEMBER, 16);
		LocalDate fecha2 = LocalDate.of(2021, Calendar.NOVEMBER, 17);
		LocalDate fecha3 = LocalDate.of(2021, Calendar.NOVEMBER, 18);
		LocalDate fecha4 = LocalDate.of(2021, Calendar.NOVEMBER, 20);
		LocalDate fecha5 = LocalDate.of(2021, Calendar.NOVEMBER, 21);


		//Se crean los objetos de categoría
		Categorias disenoWeb = new Categorias(null,"Diseño UI/UX",
				"En esta categoría podrás encontrar ofertas relacionadas con el diseño de páginas web." );
		Categorias deAplicacionesMultiplataforma = new Categorias(null,"Desarrollo de aplicaciones multiplataforma",
				"En esta categoría podrás encontrar ofertas relacionadas con el desarrollo de aplicaciones multiplataforma" );
		Categorias desarrolloDeAplicacionesWeb = new Categorias(null,"Desarrollo de aplicaciones web",
				"En esta categoría podrás encontrar ofertas relacionadas con el desarrollo de aplicaciones web");
		Categorias seo = new Categorias(null,"SEO",
				"En esta categoría podrás encontrar ofertas relacionadas con el SEO" );
		Categorias marketingDigital = new Categorias(null, "Marketing Digital",
				"En esta categoría podrás encontrar ofertas relacionadas con el Marketing Digital");
		Categorias animacion3d = new Categorias(null, "Animación 3D",
				"En esta categoría podrás encontrar ofertas relacionadas con la animación 3D");
		Categorias disenoGrafico = new Categorias(null, "Diseño Gráfico",
				"En esta categoría podrás encontrar ofertas relacionadas con el diseño gráfico");

		//Se guardan los objetos de categoría como una lista
		categoriasRepository.saveAll(Arrays.asList(disenoWeb,deAplicacionesMultiplataforma,
				desarrolloDeAplicacionesWeb, seo, marketingDigital));

		//Se crean los objetos de usuario
		Empleadores usuario1 = new Empleadores(null,"markuiux","Daré la primera impresion de tu empresa a nivel web. " +
				"Qué servicios te puedo Ofrecer: " + "\n" +
				"- SEO y SEO Local\n" +
				"- Diseño Web UI y UX.\n" +
				"- Asesoría web\n" +
				"- CTA efectivos en Ecommerce y landing page.\n" +
				"- Estudio del mercado",
				TipoEmpresa.Particular,Paises.España);
		Empleadores usuario2= new Empleadores(null,"devparrot","Soy informático desde los 17 años " +
				"me gradué de técnico medio y " +
				"superior en el área de informática en el ámbito ingeniero, " +
				"domino las herramientas requerida para diseñar " +
				"una pagina web, HTML, PHP, JQUERY, CSS, BOOTSTRAP y BASE DE DATOS.",
				TipoEmpresa.Particular,Paises.España);
		Empleadores usuario3= new Empleadores(null,"designer_francis","Hola, soy Francis, " +
				"el futuro diseñador de tu página web. " +
				"Estoy casi seguro de que puedo ayudarte a conseguir la web que estás buscando.",
				TipoEmpresa.Particular,Paises.España);
		Empleadores usuario4= new Empleadores(null,"animator3d",
				"Especializado en crear personajes y darles vida con habilidades de animación 2D y 3D, " +
				"utilizando software como Krita, Adobe After Effects, Autodesk 3ds max, Autodesk Maya, " +
				"Adobe Premiere, Adobe Photoshop...",
				TipoEmpresa.Particular,Paises.España);
		Empleadores usuario5= new Empleadores(null,"seolover33","Entusiasta de los Negocios y " +
				"del Marketing, con mucha experiencia en el mundo digital, " +
				"Con muchos deseos de seguir creciendo en este mundo digital" +
				"tan interesante.",
				TipoEmpresa.Particular,Paises.España);
		Empleadores usuario6= new Empleadores(null,"wordpress_lopeta","Desarrollador de paginas web en wordpress, " +
				"HTML5,CSS,JS Instalación de plugins, temas,optimización seo, y " +
				"mantenimientos de los sitios! Con mas de 3 años de experiencia en wordpress!",
				TipoEmpresa.Particular,Paises.España);
		Empleadores usuario7= new Empleadores(null,"GonzaloStudio","¡HOLA! Somos una Startup española de diseño y desarrollo de aplicaciones y webs. " +
				"¿A qué esperas para contratarnos?",
				TipoEmpresa.Empresa,Paises.España);
		Empleadores usuario8= new Empleadores(null,"marketing_queen","Especialista en Tecnologías de la Información con experiencia en administración " +
				"de sucursales, ventas Retail, Managment de publicidad multimedia en base " +
				"	a negocios propios y atención al cliente.",
				TipoEmpresa.Particular,Paises.España);
		Empleadores usuario9= new Empleadores(null,"wixpro_paquito","Somos un “Laboratorio Tecnológico” " +
				"de Comunicación Estratégica, Creatividad + tecnología e innovación." +
				"Estamos en constante cambio, siempre actualizados en nuevas tendencias y desarrollos.",
				TipoEmpresa.Empresa,Paises.España);
		Empleadores usuario10= new Empleadores(null,"yayadesign","Soy una abuela de 72 años que ha aprendido programación en un curso del IMSERSO. " +
				"Diseñaré el logo de tu empresa con las últimas tecnologías (Gimp, Paint).",
				TipoEmpresa.Particular,Paises.España);

		//Les asignamos una imagen
		ServiceImages generaImagen = new ServiceImages();
		String imagen1 = generaImagen.randomURLGenerator("smile");
		String imagen2 = generaImagen.randomURLGenerator("smile");
		String imagen3 = generaImagen.randomURLGenerator("smile");
		String imagen4 = generaImagen.randomURLGenerator("smile");
		String imagen5 = generaImagen.randomURLGenerator("smile");
		String imagen6 = generaImagen.randomURLGenerator("smile");
		String imagen7 = generaImagen.randomURLGenerator("smile");
		String imagen8 = generaImagen.randomURLGenerator("smile");
		String imagen9 = generaImagen.randomURLGenerator("smile");
		String imagen10 = generaImagen.randomURLGenerator("smile");

		usuario1.setImage(imagen1);
		usuario1.setImage(imagen2);
		usuario1.setImage(imagen3);
		usuario1.setImage(imagen4);
		usuario1.setImage(imagen5);
		usuario1.setImage(imagen6);
		usuario1.setImage(imagen7);
		usuario1.setImage(imagen8);
		usuario1.setImage(imagen9);
		usuario1.setImage(imagen10);


		//Se guardan los ojbetos de usuario como una lista
		empleadoresRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3, usuario4,
				usuario5, usuario6, usuario7, usuario8, usuario9, usuario10));

		//Se crean los objetos de oferta
		Trabajos trabajo1 = new Trabajos(null,"Diseñaré la identidad visual de tu negocio.", "El Por qué deberíamos de trabajar juntos:\n" +

				"Mi objetivo es hacer una página efectiva para conectar con el cliente " +
				"y asi generar ventas, aplico neurociencias, psicologia del consumidor y marketing digital, ",
				745.6,Boolean.TRUE,Paises.Cuba,Idiomas.Español);

		Trabajos trabajo2 = new Trabajos(null,"Haré todo tipo de diseño, de páginas web a tu medida.", "Hacemos todo tipo de paginas web a tu medida, con las herramientas " +
				"mas puras que es html, css, jquery, javascript, php, mysql y entre otros",
				425.2,Boolean.TRUE,Paises.EstadosUnidos,Idiomas.Ingles);

		Trabajos trabajo3 = new Trabajos(null,"Haré una página web escalable y segura","Diseño una página web " +
				"totalmente funcional.\n" +
				"\n" +
				"Todas las páginas web que diseño son bonitas, seguras y escalables.\n" +
				"\n" +

				"Realizo un auditoria de seguridad y velocidad para entregar un proyecto que funcione bien desde el primer día.",
				200.4,Boolean.FALSE,Paises.EstadosUnidos,Idiomas.Ingles);

		Trabajos trabajo4 = new Trabajos(null,"Haré una animación en 2d, 3D, animación de personajes, " +
				"animación 3D", "Hola mi nombre es ANIMATOR3D y esta es mi marca LPX." +
				" Soy un artista 3D profesional de Colombia con más de 10 años de experiencia en la industria del 3D y " +
				"los videojuegos.",
				745.6,Boolean.TRUE,Paises.Cuba,Idiomas.Español);

		Trabajos trabajo5 = new Trabajos(null,"Seré tu experto en email marketing, getresponse " +
				"y diseño web", "Entusiasta de los negocios y el marketing, con mucha experiencia en el mundo " +
				"digital. ",
				745.6,Boolean.TRUE,Paises.Cuba,Idiomas.Español);

		Trabajos trabajo6 = new Trabajos(null,"Te instalaré WordPress con tu tema de elección " +
				"en una hora.", "Instalo tu WordPress y tema de preferencia en 1Hora. Te proporciono:\n" +
				"\n" +
				"Configuración como demo\n" +
				"\n" +
				"¿Qué necesito antes de empezar?\n" +
				"Acceso a WP Login\n",
				745.6,Boolean.TRUE,Paises.Cuba,Idiomas.Español);

		Trabajos trabajo7 = new Trabajos(null,"Desarrollaremos tu aplicación multiplataforma", "El precio de la app multiplataforma no es 5$" +
				", esto depende de lo " +
				"que necesites, por eso primero tenemos que ver qué funciones quieres y necesitas en tu " +
				"aplicación para darte un precio totalmente a medida",
				745.6,Boolean.TRUE,Paises.Cuba,Idiomas.Español);

		Trabajos trabajo8 = new Trabajos(null,"Crearemos el contenido multimedia para tu página web", "Creacion de contenido " +
				"multimedia como banners, tripticos, logotipos, posters, asi como desarrollo de paginas web,",
				745.6,Boolean.TRUE,Paises.Cuba,Idiomas.Español);

		Trabajos trabajo9 = new Trabajos(null,"Diseñaré tu folleto, revista o libro", "Mis servicios incluyen:\n" +
				"\n" +
				"Revistas y Suplementos físicos y web\n" +
				"Libro de diseño de interiores\n" +
				"Diseño de la portada del libro\n" +
				"Entrega en formato pdf para web\n",
				745.6,Boolean.TRUE,Paises.Cuba,Idiomas.Español);

		Trabajos trabajo10 = new Trabajos(null,"Diseñaré tu identidad empresarial", "¿Buscas algo único, creativo, " +
				"llamativo, muy profesional y con un diseño limpio? Has dado con la oferta adecuada para tu trabajo " +
				"de diseño gráfico.\n" +
				"\n" +
				"Puedo aportar ideas creativas basadas en los requisitos especiales de mis clientes.",
				745.6,Boolean.TRUE,Paises.Cuba,Idiomas.Español);
		//Le asignamos una fecha
		trabajo1.setFecha(fecha1);
		trabajo2.setFecha(fecha2);
		trabajo3.setFecha(fecha3);
		trabajo4.setFecha(fecha3);
		trabajo5.setFecha(fecha4);
		trabajo6.setFecha(fecha1);
		trabajo7.setFecha(fecha4);
		trabajo8.setFecha(fecha4);
		trabajo9.setFecha(fecha4);
		trabajo10.setFecha(fecha4);


		//les asignamos una categoría
		List<Categorias> categorias1 = Arrays.asList(desarrolloDeAplicacionesWeb, desarrolloDeAplicacionesWeb);
		List<Categorias> categorias2 = Arrays.asList(disenoWeb, disenoGrafico);


		trabajo1.addEmpleador(usuario1);
		trabajo2.addEmpleador(usuario2);
		trabajo3.addEmpleador(usuario3);
		trabajo4.addEmpleador(usuario4);
		trabajo5.addEmpleador(usuario5);
		trabajo6.addEmpleador(usuario6);
		trabajo7.addEmpleador(usuario7);
		trabajo8.addEmpleador(usuario8);
		trabajo9.addEmpleador(usuario9);
		trabajo10.addEmpleador(usuario10);


		//les asignamos una foto
		String image11 = generaImagen.randomURLGenerator("design");
		String image12 = generaImagen.randomURLGenerator("web");
		String image13 = generaImagen.randomURLGenerator("web");
		String image14 = generaImagen.randomURLGenerator("animation");
		String image15 = generaImagen.randomURLGenerator("web");
		String image16 = generaImagen.randomURLGenerator("web");
		String image17 = generaImagen.randomURLGenerator("phone");
		String image18 = generaImagen.randomURLGenerator("web");
		String image19 = generaImagen.randomURLGenerator("web");
		String image20 = generaImagen.randomURLGenerator("design");

		trabajo1.setImage(image11);
		trabajo2.setImage(image12);
		trabajo3.setImage(image13);
		trabajo4.setImage(image14);
		trabajo5.setImage(image15);
		trabajo6.setImage(image16);
		trabajo7.setImage(image17);
		trabajo8.setImage(image18);
		trabajo9.setImage(image19);
		trabajo10.setImage(image20);

		trabajo1.addCategoria(disenoWeb);
		trabajo2.addCategoria(desarrolloDeAplicacionesWeb);
		trabajo3.addCategoria(desarrolloDeAplicacionesWeb);
		trabajo4.addCategoria(disenoWeb);
		trabajo5.addCategoria(disenoWeb);
		trabajo6.addCategoria(desarrolloDeAplicacionesWeb);
		trabajo7.addCategoria(deAplicacionesMultiplataforma);
		trabajo8.addCategoria(disenoWeb);
		trabajo9.addCategoria(disenoWeb);
		trabajo10.addCategoria(disenoWeb);

		//guardamos las entidades en el repositorio


		trabajosRepository.save(trabajo1);
 		trabajosRepository.save(trabajo2);
		trabajosRepository.save(trabajo3);
		trabajosRepository.save(trabajo4);
		trabajosRepository.save(trabajo5);
		trabajosRepository.save(trabajo6);
		trabajosRepository.save(trabajo7);
		trabajosRepository.save(trabajo8);
		trabajosRepository.save(trabajo9);
		trabajosRepository.save(trabajo10);

//		trabajosRepository.saveAll(Arrays.asList(trabajo1,trabajo2,trabajo3,trabajo4,trabajo5,
//		trabajo6,trabajo7,trabajo8,trabajo9,trabajo10));


		//Opiniones trabajo 1
		Opiniones o1 = new Opiniones(null,4,"Una web increíble. Justo lo que necesitaba. Volveré a repetir sin duda.\n" +
				"\n",trabajo1,usuario2);
		Opiniones o2 = new Opiniones(null,4,"Un gusto trabajar con " + usuario1.getNombre() + " " +
				"desde el minuto uno me inspiró mucha confianza para la realización de este proyecto.",trabajo1,usuario3);
		Opiniones o3 = new Opiniones(null,4,"todo de lujo, trabajo y comunicación fluida.\n" +
				"\n",trabajo1,usuario4);
		opinionesRepository.saveAll(Arrays.asList(o1, o2, o3));
		//Opiniones trabajo 2
		Opiniones o4= new Opiniones(null,5,"Un servicio espectacular.",trabajo2,usuario1);
		Opiniones o5= new Opiniones(null,5,"sin duda repetiré la experiencia",trabajo2,usuario3);
		Opiniones o6= new Opiniones(null,5,"Muy buena respuesta como siempre, el diseño supero lo esperado y muy buena retroalimentación con las revisiones",trabajo2,usuario4);
		opinionesRepository.saveAll(Arrays.asList(o4, o5, o6));
		//Opiniones trabajo 3
		Opiniones o7 = new Opiniones(null,4,"Todo en orden, tuvimos muchas revisiones, siempre respondio bien\n" +
				"\n",trabajo3,usuario2);
		Opiniones o8 = new Opiniones(null,4,"Espectacular persona y profesional. " +
				"He tenido un problema y un montón de dudas durante este proceso de crear una página web " +
				"y el me ha resuelto el problema.",trabajo3,usuario5);
		Opiniones o9 = new Opiniones(null,4,"Me gusto mucho trabajar con el, muy buena la comunicación y entendió a la perfección lo que quería, además mejoro muchas cosas de la pagina. Lo recomiendo al 1000%\n" +
				"\n",trabajo3,usuario6);
		opinionesRepository.saveAll(Arrays.asList(o7, o8, o9));
		//Opiniones trabajo 4
		Opiniones o10 = new Opiniones(null,4,"Muy Buen trabajo! Se ajusta a lo que necesitas, buena comunicación\n" +
				"\n",trabajo4,usuario6);
		Opiniones o11 = new Opiniones(null,4,"Es un placer trabajar siempre con" + usuario4.getNombre() + ", trabaja muy rápido y la comunicación es más constante.\n" +
				"\n",trabajo4,usuario7);
		Opiniones o12 = new Opiniones(null,4,"fue estupendo, una persona que transmite confianza, seguridad en su trabajo y experto en lo que hace. Muchas gracias Jesús por tu trabajo.",trabajo4,usuario8);
		opinionesRepository.saveAll(Arrays.asList(o10, o11, o12));
		//Opiniones trabajo 5
		Opiniones o13 = new Opiniones(null,5,"awesome job! I'm so pleased!\n" +
				"\n",trabajo6,usuario1);
		Opiniones o14 = new Opiniones(null,5,"Great customer service. Fast communication. Really happy with turn around time and quality of work. Will definitely use Saad again.\n" +
				"\n",trabajo6,usuario2);
		Opiniones o15 = new Opiniones(null,5,"Super rapido y un diseño que me encanto.\n" +
				"\n",trabajo6,usuario3);
		opinionesRepository.saveAll(Arrays.asList(o13, o14, o15));
		//Opiniones trabajo 6
		Opiniones o16 = new Opiniones(null,4,"perfecto",trabajo7,usuario4);
		Opiniones o17 = new Opiniones(null,4,"Great work on a relatively simple project for someone who has obvious great design skill! Pleased with the outcome and does the job.\n" +
				"\n",trabajo7,usuario5);
		Opiniones o18 = new Opiniones(null,4,"Wonderful graphic design and color. Excellent communication with seller and provided service as described and would definitely recommend. Thank you so much.",trabajo7,usuario6);
		opinionesRepository.saveAll(Arrays.asList(o16, o17, o18));
		//Opiniones trabajo 7
		Opiniones o19 = new Opiniones(null,4,"So nice working with someone who does their job well. Really a lot less stress and headache when someone 'understands the assignment'. Great job.",trabajo7,usuario7);
		Opiniones o20 = new Opiniones(null,4,"the only negative is that you couldn't email the files to me which doesn't really make any sense. it made it harder for me to get the I do to the stencil manufacturer.",trabajo7,usuario8);
		Opiniones o21 = new Opiniones(null,4,"Atento, servicial, competente, un trabajo impecable. Lo seguiré teniendo en cuenta para futuros proyectos. Attentive, helpful, competent, impeccable work. I will keep him in mind for future projects.\n" +
				"\n",trabajo7,usuario9);
		opinionesRepository.saveAll(Arrays.asList(o19, o20, o21));
		//Opiniones trabajo 8
		Opiniones o22 = new Opiniones(null,4,"Very great worker! it´s a really fantastic word and very good comunicated\n" +
				"\n",trabajo8,usuario10);
		Opiniones o23 = new Opiniones(null,4,"Muy atento y paciente con los requerimientos!\n" +
				"\n",trabajo8,usuario1);
		Opiniones o24 = new Opiniones(null,4,"Best experience",trabajo8,usuario5);
		opinionesRepository.saveAll(Arrays.asList(o22, o23, o24));
		//Opiniones trabajo 9
		Opiniones o25 = new Opiniones(null,4,"MUY PROFESIONAL",trabajo9,usuario8);
		Opiniones o26 = new Opiniones(null,4,"excelente trabajo,muy receptivo y siempre dispuesto a ayudarte",trabajo9,usuario4);
		Opiniones o27 = new Opiniones(null,4,"fast response great comunication will do it again anytime I need his services\n" +
				"\n",trabajo9,usuario5);
		opinionesRepository.saveAll(Arrays.asList(o25, o26, o27));
		//Opiniones trabajo 10
		Opiniones o28 = new Opiniones(null,5,"100% RECOMMENDED! her work was " +
				"impecable 1-communication was excellent, captured our brand aesthetic perfectly! " +
				"she made my website came to life exactly how i wanted it! 2 quality-price exceed my " +
				"expectations",trabajo10,usuario7);
		Opiniones o29 = new Opiniones(null,5,"She did an excellent job, " +
				"beyond my expectations. I can recommend him and I will surely continue working with her.",trabajo10,usuario8);
		Opiniones o30 = new Opiniones(null,5,"Excelente trabajo por parte de la vendedora, " +
				"genera muy buenas propuestas creativas con un alto nivel profesional",trabajo10,usuario2);
		opinionesRepository.saveAll(Arrays.asList(o28, o29, o30));


	}

}
