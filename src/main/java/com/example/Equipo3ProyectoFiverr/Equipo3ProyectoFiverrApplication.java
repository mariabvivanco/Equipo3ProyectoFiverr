package com.example.Equipo3ProyectoFiverr;

import com.example.Equipo3ProyectoFiverr.entities.*;
import com.example.Equipo3ProyectoFiverr.repositories.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class Equipo3ProyectoFiverrApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(Equipo3ProyectoFiverrApplication.class, args);
		CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
		EmployerRepository employerRepository = context.getBean(EmployerRepository.class);
		OpinionRepository opinionRepository = context.getBean(OpinionRepository.class);
		JobRepository jobRepository = context.getBean(JobRepository.class);
		UserRepository userRepository = context.getBean(UserRepository.class);
		RoleRepository roleRepository = context.getBean(RoleRepository.class);

		/*LocalDate date1 = LocalDate.of(2020, Calendar.DECEMBER, 23);
		LocalDate date2 = LocalDate.of(2021, Calendar.FEBRUARY, 7);
		LocalDate date3 = LocalDate.of(2021, Calendar.MARCH, 28);
		LocalDate date4 = LocalDate.of(2020, Calendar.JULY, 1);
		LocalDate date5 = LocalDate.of(2021, Calendar.OCTOBER, 19);
		LocalDate date6 = LocalDate.of(2021, Calendar.AUGUST, 22);



		Category category1 = new Category(null,"Desarrollo Software",
				"Sirve para desarrollar Software" );
		Category category2 = new Category(null,"Diseño Sitios Web",
				"Sirve para diseñar sitios" );
		Category category3 = new Category(null,"Diseño Interiores",
				"Sirve para diseñar hogares" );
		Category category4 = new Category(null,"Diseño Exteriores",
				"Sirve para diseñar terrazas" );
		Category categoryWeb = new Category(null,"Diseño UI/UX",
				"En esta categoría podrás encontrar ofertas relacionadas con el diseño de páginas web." );
		Category AM = new Category(null,"Desarrollo de aplicaciones multiplataforma",
				"En esta categoría podrás encontrar ofertas relacionadas con el desarrollo de aplicaciones multiplataforma" );
		Category categoryAW = new Category(null,"Desarrollo de aplicaciones web",
				"En esta categoría podrás encontrar ofertas relacionadas con el desarrollo de aplicaciones web");
		Category seo = new Category(null,"SEO",
				"En esta categoría podrás encontrar ofertas relacionadas con el SEO" );
		Category marketingDigital = new Category(null, "Marketing Digital",
				"En esta categoría podrás encontrar ofertas relacionadas con el Marketing Digital");
		Category animation3d = new Category(null, "Animación 3D",
				"En esta categoría podrás encontrar ofertas relacionadas con la animación 3D");
		Category DG = new Category(null, "Diseño Gráfico",
				"En esta categoría podrás encontrar ofertas relacionadas con el diseño gráfico");

		
		categoryRepository.saveAll(Arrays.asList(categoryWeb,AM,
				DG, seo, marketingDigital));

		categoryRepository.saveAll(Arrays.asList(category1,category2,category3,category4));


		Employer employer1 = new Employer(null,"EmpDis","Empresa de Diseño",
				CompanyType.Particular, Countries.Spain);
		Employer employer2= new Employer(null,"EmpSof","Empresa de Software",
				CompanyType.Particular, Countries.Spain);
		employer2.setImage("https://source.unsplash.com/featured/?design/600x300/4150");
		employer1.setImage("https://source.unsplash.com/featured/?design/600x300/4151");

		employerRepository.saveAll(Arrays.asList(employer1,employer2));

		Employer user1 = new Employer(null,"markuiux","Daré la primera impresion de tu empresa a nivel web. " +
				"Qué servicios te puedo Ofrecer: " + "\n" +
				"- SEO y SEO Local\n" +
				"- Diseño Web UI y UX.\n" +
				"- Asesoría web\n" +
				"- CTA efectivos en Ecommerce y landing page.\n" +
				"- Estudio del mercado",
				CompanyType.Particular, Countries.Spain);
		Employer user2= new Employer(null,"devparrot","Soy informático desde los 17 años " +
				"me gradué de técnico medio y " +
				"superior en el área de informática en el ámbito ingeniero, " +
				"domino las herramientas requerida para diseñar " +
				"una pagina web, HTML, PHP, JQUERY, CSS, BOOTSTRAP y BASE DE DATOS.",
				CompanyType.Particular, Countries.Spain);
		Employer user3= new Employer(null,"designer_francis","Hola, soy Francis, " +
				"el futuro diseñador de tu página web. " +
				"Estoy casi seguro de que puedo ayudarte a conseguir la web que estás buscando.",
				CompanyType.Particular, Countries.Spain);
		Employer user4= new Employer(null,"animator3d",
				"Especializado en crear personajes y darles vida con habilidades de animación 2D y 3D, " +
						"utilizando software como Krita, Adobe After Effects, Autodesk 3ds max, Autodesk Maya, " +
						"Adobe Premiere, Adobe Photoshop...",
				CompanyType.Particular, Countries.Spain);
		Employer user5= new Employer(null,"seolover33","Entusiasta de los Negocios y " +
				"del Marketing, con mucha experiencia en el mundo digital, " +
				"Con muchos deseos de seguir creciendo en este mundo digital" +
				"tan interesante.",
				CompanyType.Particular, Countries.Spain);
		Employer user6= new Employer(null,"wordpress_lopeta","Desarrollador de paginas web en wordpress, " +
				"HTML5,CSS,JS Instalación de plugins, temas,optimización seo, y " +
				"mantenimientos de los sitios! Con mas de 3 años de experiencia en wordpress!",
				CompanyType.Particular, Countries.Spain);
		Employer user7= new Employer(null,"GonzaloStudio","¡HOLA! Somos una Startup española de diseño y desarrollo de aplicaciones y webs. " +
				"¿A qué esperas para contratarnos?",
				CompanyType.State, Countries.Spain);
		Employer user8= new Employer(null,"marketing_queen","Especialista en Tecnologías de la Información con experiencia en administración " +
				"de sucursales, ventas Retail, Managment de publicidad multimedia en base " +
				"	a negocios propios y atención al cliente.",
				CompanyType.Particular, Countries.Spain);
		Employer user9= new Employer(null,"wixpro_paquito","Somos un “Laboratorio Tecnológico” " +
				"de Comunicación Estratégica, Creatividad + tecnología e innovación." +
				"Estamos en constante cambio, siempre actualizados en nuevas tendencias y desarrollos.",
				CompanyType.State, Countries.Spain);
		Employer user10= new Employer(null,"yayadesign","Soy una abuela de 72 años que ha aprendido programación en un curso del IMSERSO. " +
				"Diseñaré el logo de tu empresa con las últimas tecnologías (Gimp, Paint).",
				CompanyType.Particular, Countries.Spain);


		user1.setImage("https://source.unsplash.com/featured/?smile/600x300/4153");
		user2.setImage("https://source.unsplash.com/featured/?smile/600x300/4154");
		user3.setImage("https://source.unsplash.com/featured/?smile/600x300/4155");
		user4.setImage("https://source.unsplash.com/featured/?smile/600x300/4156");
		user5.setImage("https://source.unsplash.com/featured/?smile/600x300/4157");
		user6.setImage("https://source.unsplash.com/featured/?smile/600x300/4158");
		user7.setImage("https://source.unsplash.com/featured/?smile/600x300/4159");
		user8.setImage("https://source.unsplash.com/featured/?smile/600x300/4160");
		user9.setImage("https://source.unsplash.com/featured/?smile/600x300/4161");
		user10.setImage("https://source.unsplash.com/featured/?smile/600x300/4162");

		//11 Marketing Digital
		Employer user11 = new Employer(null, "marketking", "Hi I'm marketking, a consultant " +
				"helping entrepreneurs scale their businesses with digital products and online courses.", CompanyType.Particular, Countries.USA);

		//12 Marketing Digital
		Employer user12 = new Employer(null, "sensationalbusiness", "Looking for new strategies to grow your Business?Are you fed up with these periods of Favour " +
				"and Famine that follow you throughout the year? Do you dream of reaching 7- or 8-Figures?", CompanyType.Particular, Countries.USA);

		//13
		Employer user13 = new Employer(null, "americanlegend", "I am an individual who Believes in Hard and Accurate Work. " +
				"My main motive is to work Accurately, Efficiently and Professionally. ", CompanyType.Particular, Countries.USA);
		//14 SEO

		Employer user14= new Employer(null, "obSEOssed", "I have more then 6+ years experience of SEO. " +
				"I can provide all kinds of SEO services which will help to get huge traffic", CompanyType.State, Countries.USA);
		//15

		Employer user15= new Employer(null, "marketeggs", "I just love market and eggs, man!", CompanyType.Particular, Countries.UK);
		//16 SEO

		Employer user16= new Employer(null, "benedictSEO", " We're an online marketing agency which specializes in Search Engine Optimization", CompanyType.State, Countries.UK);
		//17 SEO

		Employer user17= new Employer(null, "immortalUK22", "I have been in the SEO industries for over " +
				"9 years I have ranked many websites in my SEO Career,", CompanyType.Particular, Countries.UK);

		//18 SEO
		Employer user18= new Employer(null, "seodeutch", "Verschaffen Sie sich einen Vorsprung vor Ihrer Konkurrenz mit meinen SEO-, Website-Analyse-, " +
				"Website-Promotion- und anderen Dienstleistungen. Ich bin ein britischer Verkäufer, der in Frankreich lebt.", CompanyType.Particular, Countries.Germany);

		//19 Marketing Digital
		Employer user19= new Employer(null, "marketverkauft", "Hallo, ich bin marketverkauft. Wir bieten unseren Kunden die " +
				"strategische Unterstützung, die sie für ein florierendes Unternehmen benötigen.", CompanyType.State, Countries.Germany);

		//20 SEO
		Employer user20= new Employer(null, "elisss33", "Ich habe mehr als 100+ Zufriedene Kunden, " +
				"Sie erhalten eine gute Anzahl von Verkäufen und Verkehr von meinem besten SEO-Service. ", CompanyType.State, Countries.Germany);



		user11.setImage("https://source.unsplash.com/featured/?smile/600x300/1");
		user12.setImage("https://source.unsplash.com/featured/?smile/600x300/1");
		user13.setImage("https://source.unsplash.com/featured/?smile/600x300/1");
		user14.setImage("https://source.unsplash.com/featured/?smile/600x300/1");
		user15.setImage("https://source.unsplash.com/featured/?smile/600x300/1");
		user16.setImage("https://source.unsplash.com/featured/?smile/600x300/1");
		user17.setImage("https://source.unsplash.com/featured/?smile/600x300/1");
		user18.setImage("https://source.unsplash.com/featured/?smile/600x300/1");
		user19.setImage("https://source.unsplash.com/featured/?smile/600x300/1");
		user20.setImage("https://source.unsplash.com/featured/?smile/600x300/1");


		
		employerRepository.saveAll(Arrays.asList(user11, user12, user13, user14,
				user15, user16, user17, user18, user19, user20));


		
		employerRepository.saveAll(Arrays.asList(user1, user2, user3, user4,
				user5, user6, user7, user8, user9, user10));


		Job job21 = new Job(null,"Desarrollar API", "",
				745.6,Boolean.TRUE, Countries.Cuba, Languages.Spanish);
		job21.setDate(date2);
		Job job22 = new Job(null,"Desarrollar API", "",
				425.2,Boolean.TRUE, Countries.USA, Languages.English);
		job22.setDate(date3);
		Job job23 = new Job(null,"Diseñar terraza","",
				2000d,Boolean.FALSE, Countries.USA, Languages.English);
		job23.setDate(date4);



		List<Category> categories1 = Arrays.asList(category1,category2);
		List<Category> categories2 = Arrays.asList(category3,category4);

		for (Category category : categories1) {
			job21.addCategory (category );

		}
		for (Category category : categories2) {
			job23.addCategory (category );

		}
		

		job21.addEmployer(employer2);
		job22.addEmployer(employer1);
		job21.setImage("https://source.unsplash.com/featured/?design/600x300/4181");
		job22.setImage("https://source.unsplash.com/featured/?design/600x300/4182");
		job23.setImage("https://source.unsplash.com/featured/?design/600x300/4183");

		Job job1 = new Job(null,"Diseñaré la identidad visual de tu negocio.", "El Por qué deberíamos de trabajar juntos:\n" +

				"Mi objetivo es hacer una página efectiva para conectar con el cliente " +
				"y asi generar ventas, aplico neurociencias, psicologia del consumidor y marketing digital, ",
				745.6,Boolean.TRUE, Countries.Cuba, Languages.Spanish);

		Job job2 = new Job(null,"Haré todo tipo de diseño, de páginas web a tu medida.", "Hacemos todo tipo de paginas web a tu medida, con las herramientas " +
				"mas puras que es html, css, jquery, javascript, php, mysql y entre otros",
				425.2,Boolean.TRUE, Countries.USA, Languages.English);

		Job job3 = new Job(null,"Haré una página web escalable y segura","Diseño una página web " +
				"totalmente funcional.\n" +
				"\n" +
				"Todas las páginas web que diseño son bonitas, seguras y escalables.\n" +
				"\n" +

				"Realizo un auditoria de seguridad y velocidad para entregar un proyecto que funcione bien desde el primer día.",
				200.4,Boolean.FALSE, Countries.USA, Languages.English);

		Job job4 = new Job(null,"Haré una animación en 2d, 3D, animación de personajes, " +
				"animación 3D", "Hola mi nombre es ANIMATOR3D y esta es mi marca LPX." +
				" Soy un artista 3D profesional de Colombia con más de 10 años de experiencia en la industria del 3D y " +
				"los videojuegos.",
				745.6,Boolean.TRUE, Countries.Cuba, Languages.Spanish);

		Job job5 = new Job(null,"Seré tu experto en email marketing, getresponse " +
				"y diseño web", "Entusiasta de los negocios y el marketing, con mucha experiencia en el mundo " +
				"digital. ",
				745.6,Boolean.TRUE, Countries.Cuba, Languages.Spanish);

		Job job6 = new Job(null,"Te instalaré WordPress con tu tema de elección " +
				"en una hora.", "Instalo tu WordPress y tema de preferencia en 1Hora. Te proporciono:\n" +
				"\n" +
				"Configuración como demo\n" +
				"\n" +
				"¿Qué necesito antes de empezar?\n" +
				"Acceso a WP Login\n",
				745.6,Boolean.TRUE, Countries.Cuba, Languages.Spanish);

		Job job7 = new Job(null,"Desarrollaremos tu aplicación multiplataforma", "El precio de la app multiplataforma no es 5$" +
				", esto depende de lo " +
				"que necesites, por eso primero tenemos que ver qué funciones quieres y necesitas en tu " +
				"aplicación para darte un precio totalmente a medida",
				745.6,Boolean.TRUE, Countries.Cuba, Languages.Spanish);

		Job job8 = new Job(null,"Crearemos el contenido multimedia para tu página web", "Creacion de contenido " +
				"multimedia como banners, tripticos, logotipos, posters, asi como desarrollo de paginas web,",
				745.6,Boolean.TRUE, Countries.Cuba, Languages.Spanish);

		Job job9 = new Job(null,"Diseñaré tu folleto, revista o libro", "Mis servicios incluyen:\n" +
				"\n" +
				"Revistas y Suplementos físicos y web\n" +
				"Libro de diseño de interiores\n" +
				"Diseño de la portada del libro\n" +
				"Entrega en formato pdf para web\n",
				745.6,Boolean.TRUE, Countries.Cuba, Languages.Spanish);

		Job job10 = new Job(null,"Diseñaré tu identidad empresarial", "¿Buscas algo único, creativo, " +
				"llamativo, muy profesional y con un diseño limpio? Has dado con la oferta adecuada para tu job " +
				"de diseño gráfico.\n" +
				"\n" +
				"Puedo aportar ideas creativas basadas en los requisitos especiales de mis clientes.",
				745.6,Boolean.TRUE, Countries.Cuba, Languages.Spanish);





		job1.setDate(date1);
		job2.setDate(date2);
		job3.setDate(date3);
		job4.setDate(date3);
		job5.setDate(date4);
		job6.setDate(date1);
		job7.setDate(date4);
		job8.setDate(date4);
		job9.setDate(date4);
		job10.setDate(date4);



		job1.addEmployer(user1);
		job2.addEmployer(user2);
		job3.addEmployer(user3);
		job4.addEmployer(user4);
		job5.addEmployer(user5);
		job6.addEmployer(user6);
		job7.addEmployer(user7);
		job8.addEmployer(user8);
		job9.addEmployer(user9);
		job10.addEmployer(user10);



		job1.setImage("https://source.unsplash.com/featured/?web/600x300/4191");
		job2.setImage("https://source.unsplash.com/featured/?web/600x300/4192");
		job3.setImage("https://source.unsplash.com/featured/?web/600x300/4193");
		job4.setImage("https://source.unsplash.com/featured/?web/600x300/4194");
		job5.setImage("https://source.unsplash.com/featured/?web/600x300/4195");
		job6.setImage("https://source.unsplash.com/featured/?web/600x300/4196");
		job7.setImage("https://source.unsplash.com/featured/?web/600x300/4197");
		job8.setImage("https://source.unsplash.com/featured/?web/600x300/4198");
		job9.setImage("https://source.unsplash.com/featured/?web/600x300/4199");
		job10.setImage("https://source.unsplash.com/featured/?web/600x300/4200");


		job1.addCategory (categoryWeb);
		job2.addCategory (categoryWeb);
		job3.addCategory (AM);
		job4.addCategory (categoryWeb);
		job5.addCategory (categoryWeb);
		job6.addCategory (AM);
		job7.addCategory (AM);
		job8.addCategory (categoryWeb);
		job9.addCategory (categoryWeb);
		job10.addCategory (categoryWeb);


		jobRepository.save(job1);
		jobRepository.save(job2);
		jobRepository.save(job3);
		jobRepository.save(job4);
		jobRepository.save(job5);
		jobRepository.save(job6);
		jobRepository.save(job7);
		jobRepository.save(job8);
		jobRepository.save(job9);
		jobRepository.save(job10);
		jobRepository.save(job21);
		jobRepository.save(job22);


		Job job11 = new Job(null, "I will scale your business " +
				"with digital products", "When people search your name on a search engine (Google) then will show an Information " +
				"Box in Google Top right site. This Information Box is Google Knowledge Panel.",
				34.99, Boolean.TRUE, Countries.USA, Languages.English);
		Job job12 = new Job(null, "I will make you reach 7 " +
				"figures", "Whether it is an e-commerce organization or an average " +
				"brick-and-mortar trade, if you want to maximize your success, " +
				"you ought to be proficient in how to successfully market your business on the internet.",
				29.99, Boolean.TRUE, Countries.USA, Languages.English);
		Job job13 = new Job(null, "I will make your business " +
				"skyrocket", "I can help you to boost your productivity, social media presence and improve the quality of your marketing results. You should harness " +
				"the power of virtual assistants by integrating them into your marketing strategy. ",
				15.99, Boolean.TRUE, Countries.USA, Languages.English);
		Job job14 = new Job(null, "I will provide you the best " +
				"SEO services", "The posts will be listed on the homepage of " +
				"our site for a limited time until new posts are published.",
				49.99, Boolean.TRUE, Countries.USA, Languages.English);
		Job job15 = new Job(null, "I will optimize your searches " +
				"on the Internet", "This will help your website gain trust & authority and traction " +
				"with the search engines to rank higher in the search results.",
				44.00, Boolean.TRUE, Countries.UK, Languages.English);
		Job job16 = new Job(null, "I will make your website " +
				"reach a top tier", "You will improve your website according to search engine terms " +
				"and conditions by taking our special “on-page optimization” package.n",
				69.99, Boolean.TRUE, Countries.UK, Languages.English);
		Job job17 = new Job(null, "I will make your website " +
				"be successfull", "In my standard & premium packs, I will include one week of on-site S.E.O," +
				" implementing changes & fixes necessary (10 pages) to help you rank higher. ",
				34.99, Boolean.TRUE, Countries.UK, Languages.English);
		Job job18 = new Job(null, "Ich werde Ihre Website zur " +
				"meistgesuchten Website machen", "Es gibt über 200 SEO-Faktoren und Backlinks sind einer " +
				"der wichtigsten Faktoren der Offpage-SEO. Backlinks geben Signale an Google.",
				19.99, Boolean.TRUE, Countries.Germany, Languages.German);
		Job job19 = new Job(null, "Ich werde dafür sorgen, dass Ihr " +
				"Unternehmen seine Gewinne steigert", "Sie erhalten 100% operative " +
				"E-Commerce-Website / Shop mit sicheren pyament Gateway. " +
				"Auch erhalten Sie voll funktionsfähige Dashboard, wo Sie Inventar/Produkte " +
				"verwalten können und verfolgen Bestellungen und Zahlungen.n",
				150.00, Boolean.TRUE, Countries.Germany, Languages.German);
		Job job20 = new Job(null, "Ich werde Ihr SEO erstaunlich machen", "Wenn Sie Ihre Website auf der ersten Seite von Google platzieren möchten," +
				" um mehr Umsatz und Traffic zu erhalten, dann sind Sie hier genau richtig. ",
				33.44, Boolean.TRUE, Countries.Germany, Languages.German);


		job11.setDate(date1);
		job12.setDate(date2);
		job13.setDate(date3);
		job14.setDate(date3);
		job15.setDate(date4);
		job16.setDate(date1);
		job17.setDate(date4);
		job18.setDate(date4);
		job19.setDate(date4);
		job20.setDate(date4);


		job11.setImage("https://source.unsplash.com/featured/?web/600x300/1");
		job12.setImage("https://source.unsplash.com/featured/?web/600x300/1");
		job13.setImage("https://source.unsplash.com/featured/?web/600x300/1");
		job14.setImage("https://source.unsplash.com/featured/?web/600x300/1");
		job15.setImage("https://source.unsplash.com/featured/?web/600x300/1");
		job16.setImage("https://source.unsplash.com/featured/?web/600x300/1");
		job17.setImage("https://source.unsplash.com/featured/?web/600x300/1");
		job18.setImage("https://source.unsplash.com/featured/?web/600x300/1");
		job19.setImage("https://source.unsplash.com/featured/?web/600x300/1");
		job20.setImage("https://source.unsplash.com/featured/?web/600x300/1");



		job11.addEmployer(user11);
		job12.addEmployer(user12);
		job13.addEmployer(user13);
		job14.addEmployer(user14);
		job15.addEmployer(user15);
		job16.addEmployer(user16);
		job17.addEmployer(user17);
		job18.addEmployer(user18);
		job19.addEmployer(user19);
		job20.addEmployer(user20);



		job11.addCategory (marketingDigital);
		job12.addCategory (marketingDigital);
		job13.addCategory (marketingDigital);
		job14.addCategory (seo);
		job15.addCategory (marketingDigital);
		job16.addCategory (seo);
		job17.addCategory (seo);
		job18.addCategory (seo);
		job19.addCategory (marketingDigital);
		job20.addCategory (seo);

		//guardamos las entidades en el repositorio


		jobRepository.save(job11);
		jobRepository.save(job12);
		jobRepository.save(job13);
		jobRepository.save(job14);
		jobRepository.save(job15);
		jobRepository.save(job16);
		jobRepository.save(job17);
		jobRepository.save(job18);
		jobRepository.save(job19);
		jobRepository.save(job20);



		Opinion opinion1 = new Opinion(null,4,"esta mas o menos",job1,employer2);
		Opinion opinion2 = new Opinion(null,5,"esta muy bien",job1,employer2);
		Opinion opinion3 = new Opinion(null,4,"esta por ahi",job1,employer2);
		Opinion opinion4 = new Opinion(null,4,"esta  bien",job1,employer2);
		Opinion opinion5 = new Opinion(null,5,"esta muy bien",job2,employer2);
		Opinion opinion6 = new Opinion(null,4,"esta muy bien",job2,employer2);
		Opinion opinion7 = new Opinion(null,4,"esta  bien",job3,employer1);
		opinionRepository.saveAll(Arrays.asList(opinion1,opinion2,opinion3,opinion4,opinion5,opinion6,opinion7));

		Opinion o1 = new Opinion(null,4,"Una web increíble. Justo lo que necesitaba. Volveré a repetir sin duda.\n" +
				"\n",job1,user2);
		Opinion o2 = new Opinion(null,4,"Un gusto trabajar con " + user1.getName() + " " +
				"desde el minuto uno me inspiró mucha confianza para la realización de este proyecto.",job1,user3);
		Opinion o3 = new Opinion(null,4,"todo de lujo, job y comunicación fluida.\n" +
				"\n",job1,user4);
		opinionRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		Opinion o4= new Opinion(null,5,"Un servicio espectacular.",job2,user1);
		Opinion o5= new Opinion(null,5,"sin duda repetiré la experiencia",job2,user3);
		Opinion o6= new Opinion(null,5,"Muy buena respuesta como siempre, el diseño supero lo esperado y muy buena retroalimentación con las revisiones",job2,user4);
		opinionRepository.saveAll(Arrays.asList(o4, o5, o6));
		
		Opinion o7 = new Opinion(null,4,"Todo en orden, tuvimos muchas revisiones, siempre respondio bien\n" +
				"\n",job3,user2);
		Opinion o8 = new Opinion(null,4,"Espectacular persona y profesional. " +
				"He tenido un problema y un montón de dudas durante este proceso de crear una página web " +
				"y el me ha resuelto el problema.",job3,user5);
		Opinion o9 = new Opinion(null,4,"Me gusto mucho trabajar con el, muy buena la comunicación y entendió a la perfección lo que quería, además mejoro muchas cosas de la pagina. Lo recomiendo al 1000%\n" +
				"\n",job3,user6);
		opinionRepository.saveAll(Arrays.asList(o7, o8, o9));
		
		Opinion o10 = new Opinion(null,4,"Muy Buen job! Se ajusta a lo que necesitas, buena comunicación\n" +
				"\n",job4,user6);
		Opinion o11 = new Opinion(null,4,"Es un placer trabajar siempre con" + user4.getName() + ", trabaja muy rápido y la comunicación es más constante.\n" +
				"\n",job4,user7);
		Opinion o12 = new Opinion(null,4,"fue estupendo, una persona que transmite confianza, seguridad en su job y experto en lo que hace. Muchas gracias Jesús por tu job.",job4,user8);
		opinionRepository.saveAll(Arrays.asList(o10, o11, o12));
		
		Opinion o13 = new Opinion(null,5,"awesome job! I'm so pleased!\n" +
				"\n",job6,user1);
		Opinion o14 = new Opinion(null,5,"Great customer service. Fast communication. Really happy with turn around time and quality of work. Will definitely use Saad again.\n" +
				"\n",job6,user2);
		Opinion o15 = new Opinion(null,5,"Super rapido y un diseño que me encanto.\n" +
				"\n",job6,user3);
		opinionRepository.saveAll(Arrays.asList(o13, o14, o15));
		
		Opinion o16 = new Opinion(null,4,"perfecto",job7,user4);
		Opinion o17 = new Opinion(null,4,"Great work on a relatively simple project for someone who has obvious great design skill! Pleased with the outcome and does the job.\n" +
				"\n",job7,user5);
		Opinion o18 = new Opinion(null,4,"Wonderful graphic design and color. Excellent communication with seller and provided service as described and would definitely recommend. Thank you so much.",job7,user6);
		opinionRepository.saveAll(Arrays.asList(o16, o17, o18));
		//Opiniones job 7
		Opinion o19 = new Opinion(null,4,"So nice working with someone who does their job well. Really a lot less stress and headache when someone 'understands the assignment'. Great job.",job7,user7);
		Opinion o20 = new Opinion(null,4,"the only negative is that you couldn't email the files to me which doesn't really make any sense. it made it harder for me to get the I do to the stencil manufacturer.",job7,user8);
		Opinion o21 = new Opinion(null,4,"Atento, servicial, competente, un job impecable. Lo seguiré teniendo en cuenta para futuros proyectos. Attentive, helpful, competent, impeccable work. I will keep him in mind for future projects.\n" +
				"\n",job7,user9);
		opinionRepository.saveAll(Arrays.asList(o19, o20, o21));
		//Opiniones job 8
		Opinion o22 = new Opinion(null,4,"Very great worker! it´s a really fantastic word and very good comunicated\n" +
				"\n",job8,user10);
		Opinion o23 = new Opinion(null,4,"Muy atento y paciente con los requerimientos!\n" +
				"\n",job8,user1);
		Opinion o24 = new Opinion(null,4,"Best experience",job8,user5);
		opinionRepository.saveAll(Arrays.asList(o22, o23, o24));
		//Opiniones job 9
		Opinion o25 = new Opinion(null,4,"MUY PROFESIONAL",job9,user8);
		Opinion o26 = new Opinion(null,4,"excelente job,muy receptivo y siempre dispuesto a ayudarte",job9,user4);
		Opinion o27 = new Opinion(null,4,"fast response great comunication will do it again anytime I need his services\n" +
				"\n",job9,user5);
		opinionRepository.saveAll(Arrays.asList(o25, o26, o27));
		//Opiniones job 10
		Opinion o28 = new Opinion(null,5,"100% RECOMMENDED! her work was " +
				"impecable 1-communication was excellent, captured our brand aesthetic perfectly! " +
				"she made my website came to life exactly how i wanted it! 2 quality-price exceed my " +
				"expectations",job10,user7);
		Opinion o29 = new Opinion(null,5,"She did an excellent job, " +
				"beyond my expectations. I can recommend him and I will surely continue working with her.",job10,user8);
		Opinion o30 = new Opinion(null,5,"Excelente job por parte de la vendedora, " +
				"genera muy buenas propuestas creativas con un alto nivel profesional",job10,user2);
		opinionRepository.saveAll(Arrays.asList(o28, o29, o30));

		Opinion o31 = new Opinion(null,5,"Excelente job, increible los resultados obtenidos"
				,job11,user4);
		opinionRepository.save(o31);
		//Opiniones job 11

		Opinion o32 = new Opinion(null, 5, "It was nice " +
				"working with you. Thanks for your service!", job11, user13);
		Opinion o33 = new Opinion(null, 5, "Lovely services. " +
				"Would hire them again! " +
				"\n", job11, user14);
		opinionRepository.saveAll(Arrays.asList(o31, o32, o33));

		//Opiniones job 12

		Opinion o34 = new Opinion(null, 5, "The best" +
				" digital marketing services ever!", job12, user11);
		Opinion o35 = new Opinion(null, 5, "It was nice " +
				"working with you. Thanks for your service!", job12, user13);
		Opinion o36 = new Opinion(null, 5, "He helepd me " +
				"to grow my business" +
				"\n", job12, user14);
		opinionRepository.saveAll(Arrays.asList(o34, o35, o36));

		//Opiniones job 13

		Opinion o37 = new Opinion(null, 5, "Took a " +
				"realistic approach to my problem. Thank you :)", job13, user14);
		Opinion o38 = new Opinion(null, 5, "My website " +
				"is the first one in the Search Engines", job13, user15);
		Opinion o39 = new Opinion(null, 5, "Before your " +
				"work, my website wuld not show up on Google. Thank you!", job13, user16);
		opinionRepository.saveAll(Arrays.asList(o37, o38, o39));

		//Opiniones job 14
		Opinion o40 = new Opinion(null, 5, "Took a realistic" +
				" approach to my problem. Thank you :)", job14, user12);
		//Opiniones job 15
		Opinion o41 = new Opinion(null, 5, "My website is " +
				"the first one in the Search Engines", job15, user16);
		//Opiniones job 16
		Opinion o42 = new Opinion(null, 5, "Before your work, " +
				"my website wuld not show up on Google. Thank you!", job16, user17);
		opinionRepository.saveAll(Arrays.asList(o40, o41, o42));

		//Opiniones job 17
		Opinion o43 = new Opinion(null, 5, "Took a " +
				"realistic approach to my problem. Thank you :)", job17, user12);
		//Opiniones job 18
		Opinion o44 = new Opinion(null, 5, "My website i" +
				"s the first one in the Search Engines", job18, user13);
		//Opiniones job 19
		Opinion o45 = new Opinion(null, 5, "Before your " +
				"work, my website wuld not show up on Google. Thank you!", job19, user14);
		//Opiniones job 20
		Opinion o46 = new Opinion(null, 5, "Took a " +
				"realistic approach to my problem. Thank you :)", job20, user12);
		opinionRepository.saveAll(Arrays.asList(o40, o41, o42, o46));

		Role role1 = new Role(1,"ADMIN", "Rol Admin");
		Role role2 = new Role(2,"USER", "Rol User");
		roleRepository.save(role1);
		roleRepository.save(role2);
		User user = new User(1,"admin","$2a$10$DTAejq8zVwf.dMadV1SAvuNXAbXjroY.G7dWpS1tzoGolwn7nexTm","","","","");
		Set<Role> useradmin =new HashSet<>();
		useradmin.add(role1);
		useradmin.add(role2);
		user.setRoles(useradmin);
		userRepository.save(user);

		*/





	}



}
