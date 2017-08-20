package web;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ImembreDao;
import dao.ItacheDao;
import dao.MembreDaoImplementation;
import dao.TacheDaoImplementation;
import metier.entities.Membre;
import metier.entities.Tache;
@SuppressWarnings("serial")
@WebServlet(name = "serveletmembre", urlPatterns = { "*.do" })
public class ControleurServlet extends HttpServlet {
	private ImembreDao metier;
	private ItacheDao metier2;
	@Override
	public void init() throws ServletException {
		metier = new MembreDaoImplementation();
		metier2 = new TacheDaoImplementation();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();

		////////////////////////////////// CONTROLEUR DE
		////////////////////////////////// MEMBRE/////////////////////////////////////////////////////////
		if (path.equals("/index.do")) {
			request.getRequestDispatcher("EditDeleteMembre.jsp").forward(request, response);
		}
		else if (path.equals("/chercher.do")) {
			// System.out.println("Recupere "+request.getParameter("motCle"));
			int motcle;
			motcle = Integer.parseInt(request.getParameter("motCle"));
			MembreModel model = new MembreModel();
			model.setMotcle(motcle);
			ArrayList<Membre> membre = metier.membresparMC(motcle);
			model.setMembre(membre);
			request.setAttribute("model", model);
			request.getRequestDispatcher("membre.jsp").forward(request, response);
		} else if (path.equals("/Saisie.do")) {
			request.getRequestDispatcher("Saisiemembre.jsp").forward(request, response);
		}
		if (path.equals("/index.do")) {
			request.getRequestDispatcher("EditDeleteMembre.jsp").forward(request, response);
		} else if (path.equals("/EditDeleteMembre.do")) {
			// System.out.println("Recupere "+request.getParameter("motCle"));
			String motcle = request.getParameter("motCle");
			MembreModelEditDelete model = new MembreModelEditDelete();
			model.setMotcle(motcle);
			ArrayList<Membre> membre = metier.tousmembresparMC("%" + motcle + "%");
			model.setMembre(membre);
			request.setAttribute("model", model);
			request.getRequestDispatcher("EditDeleteMembre.jsp").forward(request, response);
		}
		else if (path.equals("/Saisie.do")) {
			request.getRequestDispatcher("Saisiemembre.jsp").forward(request, response);
		} else if (path.equals("/SaveMembre.do") && (request.getMethod().equals("POST"))) {
			String noms = request.getParameter("nom");
			Membre m = metier.save(new Membre(noms));
			request.setAttribute("membre", m);
			request.getRequestDispatcher("confirsaimem.jsp").forward(request, response);
		} else if (path.equals("/Supprimer.do")) {
			int id = Integer.parseInt(request.getParameter("id"));
			metier.deleteMembre(id);
			request.getRequestDispatcher("EditDeleteMembre.do?motCle=").forward(request, response);
			//response.sendRedirect("EditDeleteMembre.do?motCle=");
		} else if (path.equals("/Modifier.do")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Membre m = metier.getMembre(id);
			request.setAttribute("membre", m);
			request.getRequestDispatcher("Modifiermembre.jsp").forward(request, response);
		} else if (path.equals("/UpdateMembre.do") && (request.getMethod().equals("POST"))) {
			int id = Integer.parseInt(request.getParameter("id"));
			String noms = request.getParameter("nom");
			Membre m = new Membre(noms);
			m.setId(id);
			metier.updateMembre(m);
			request.setAttribute("membre", m);
			request.getRequestDispatcher("confirsaimem.jsp").forward(request, response);
		}
		//////////////////////////////// FIN CONTROLEUR DE MEMBRE
		//////////////////////////////// //////////////////////////////////////

		//////////////////////////////// CONTROLEUR DE TACHE
		//////////////////////////////// //////////////////////////////////////////
		if (path.equals("/index.do")) {
			request.getRequestDispatcher("EditDeleteMembre.jsp").forward(request, response);
		} else if (path.equals("/EditDeleteTache.do")) {
			// System.out.println("Recupere "+request.getParameter("motCle"));
			String motcletache = request.getParameter("motCle");
			TacheModelEditDelete model = new TacheModelEditDelete();
			model.setMotcletache(motcletache);
			ArrayList<Tache> tache = metier2.tacheparMC("%" + motcletache + "%");
			model.setTaches(tache);
			request.setAttribute("model", model);
			request.getRequestDispatcher("EditDeleteTache.jsp").forward(request, response);
		}
		else if (path.equals("/SaisieTache.do")) {
			ArrayList<Membre> membre = metier.getListMembre();
			MembreModelEditDelete model = new MembreModelEditDelete();
			model.setMembre(membre);
			request.setAttribute("model", model);
			request.getRequestDispatcher("SaisieTache.jsp").forward(request, response);
		} else if (path.equals("/SaveTache.do") && (request.getMethod().equals("POST"))) {
			String nom = request.getParameter("nom");
			String description = request.getParameter("description");
			String statut = request.getParameter("statut");
			int mem_fk = Integer.parseInt(request.getParameter("mem_fk"));
			Tache t = metier2.save(new Tache(nom, description, statut, mem_fk));
			request.setAttribute("tache", t);
			request.getRequestDispatcher("confirsaitache.jsp").forward(request, response);
		}
		else if (path.equals("/SupprimerTache.do")) {
			int id = Integer.parseInt(request.getParameter("id"));
			metier2.deleteTache(id);
			//response.sendRedirect("EditDeleteTache.do?motCle=");
			request.getRequestDispatcher("EditDeleteTache.do?motCle=").forward(request, response);
		}
		else if (path.equals("/ModifierTache.do")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Tache t = metier2.getTache(id);
			request.setAttribute("tache", t);
			request.getRequestDispatcher("ModifierTache.jsp").forward(request, response);
		} else if (path.equals("/UpdateTache.do") && (request.getMethod().equals("POST"))) {
			int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String description = request.getParameter("description");
			String statut = request.getParameter("statut");
			int mem_fk = Integer.parseInt(request.getParameter("mem_fk"));
			Tache t = new Tache(nom, description, statut, mem_fk);
			t.setId(id);
			metier2.updateTache(t);
			request.setAttribute("tache", t);
			request.getRequestDispatcher("confirsaitache.jsp").forward(request, response);
		}
		if (path.equals("/Tacheassignation.do")) {
			ArrayList<Membre> membre = metier.getListMembre();
			MembreModelEditDelete model = new MembreModelEditDelete();
			model.setMembre(membre);
			request.setAttribute("model", model);
			request.getRequestDispatcher("Tacheassigner.jsp").forward(request, response);
		}
		else if (path.equals("/Tacheassigner.do")) {
			// System.out.println("Recupere"+request.getParameter("idmembreCle"));
			int idmembre;
			idmembre = Integer.parseInt(request.getParameter("idmembre"));
			TacheModel model1 = new TacheModel();
			model1.setIdmembre(idmembre);
			ArrayList<Tache> tache = metier2.getListTachebyIdMembre(idmembre);
			model1.setTache(tache);
			request.setAttribute("model1", model1);
			request.getRequestDispatcher("Tacheassigner.jsp").forward(request, response);
		}
	  else if (path.equals("/TacheStatut.do")) {
			// System.out.println("Recupere"+request.getParameter("idmembreCle"));
			
		  String motcletache = request.getParameter("statut");
			TacheParStatut model2 = new TacheParStatut();
			model2.setMotcletacheps(motcletache);
			ArrayList<Tache> tache= metier2.TacheParStatut(motcletache);
			model2.setTaches(tache);
			request.setAttribute("model2", model2);
			request.getRequestDispatcher("TacheParStatut.jsp").forward(request, response);
		}
		//////////////////////////////// FIN CONTROLEUR DE TACHE
		//////////////////////////////// //////////////////////////////////////
		else {
			response.sendError(response.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
