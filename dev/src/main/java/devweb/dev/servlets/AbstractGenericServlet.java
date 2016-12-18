package devweb.dev.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

public abstract class AbstractGenericServlet extends HttpServlet{
	
	protected TemplateEngine createTemplateEngine(HttpServletRequest request){
		
	ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(request.getServletContext());
	templateResolver.setTemplateMode(TemplateMode.HTML);
	templateResolver.setPrefix("/WEB-INF/templates/");
	templateResolver.setSuffix(".html");
	
	TemplateEngine templateEngine=new TemplateEngine();
	templateEngine.setTemplateResolver(templateResolver);
	
	return templateEngine;
}
}
