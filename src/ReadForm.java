
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ReadForm extends GenericServlet {
	public ReadForm() {
		super();
	}

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Enumeration<String> fnames = request.getParameterNames();
		out.print("<table border=\"1\" align=\"center\" style=\"border: thin; border-style: solid;\">");
		while (fnames.hasMoreElements()) {
			String element = (String) fnames.nextElement();
			if (!element.equalsIgnoreCase("Click me")) {
				out.print("<tr>");
				String[] values = request.getParameterValues(element);
				out.print("<th>" + element.toString() + "</th><td><ul>");
				for (String x : values) {
					out.print("<li>" + x + "</li>");
				}
				out.print("</ul></td></tr>");
			}
		}
		out.print("</table>");
	}

}
