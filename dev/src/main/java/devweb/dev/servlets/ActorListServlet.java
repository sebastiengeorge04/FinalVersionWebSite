package devweb.dev.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;	



@WebServlet("/acteurs")	
public class ActorListServlet extends AbstractGenericServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
TemplateEngine templateEngine=this.createTemplateEngine(request);
		
		WebContext context=new WebContext(request, response, request.getServletContext());
		templateEngine.process("Acteurs", context, response.getWriter());
	}
	
}
