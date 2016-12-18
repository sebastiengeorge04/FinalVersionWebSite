package devweb.dev.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import devweb.dev.entities.Film;

import devweb.dev.managers.FilmLibrary;

@WebServlet("/newfilm")
public class NewFilm extends AbstractGenericServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale.setDefault(Locale.ENGLISH);
		TemplateEngine templateEngine = this.createTemplateEngine(req);

		WebContext context = new WebContext(req, resp, req.getServletContext());
		templateEngine.process("FormFilms", context, resp.getWriter());
}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String director = req.getParameter("director");
		String summary = req.getParameter("summary");
		
		Integer duration = Integer.parseInt(req.getParameter("duration"));
		Integer note=Integer.parseInt(req.getParameter("note"));
		String acteur=req.getParameter("acteur");
	
		
		String releaseDateAsString = req.getParameter("releaseDate");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate releaseDate = LocalDate.parse(releaseDateAsString, formatter);
		
		Film newFilm = new Film(null, name, releaseDate, duration, director, summary, note,acteur);
		Film addedFilm = FilmLibrary.getInstance().addFilm(newFilm);
	
		
		resp.sendRedirect("film?id="+addedFilm.getId());
}
}