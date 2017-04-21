package servletPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet(description = "Sample servlet", urlPatterns = { "/Servletcontoh" })
@MultipartConfig
public class Servlet extends HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;
	Human[] humans = {
			new Human(1, "nama1"),
			new Human(2, "nama2"),
			new Human(3, "nama3"),
			new Human(4, "nama4"),
			new Human(5, "nama5")};
	JSONObject jsonObject2 = new JSONObject();
	JSONArray jsonObjArray = new JSONArray();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output = response.getWriter();
		response.setContentType("application/json");
		for (int i = 0; i < humans.length; i++) {
			JSONObject jsonObject1 = new JSONObject();
			jsonObject1.put("name", humans[i].getName());
			jsonObject1.put("id", humans[i].getId());
			jsonObjArray.add(jsonObject1);
		}
		jsonObject2.put("data", jsonObjArray);
		jsonObject2.put("message", "this is message");
		
	    output.print(jsonObject2.toString());
	    output.flush();
	    jsonObject2.clear();
	    jsonObjArray.clear();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output = response.getWriter();
		
		Arrays.asList(humans).stream()
			.filter(s -> s.getName().equals(request.getParameter("namaa")))
			.forEach(h -> {
				JSONObject jsonObject1 = new JSONObject();
				jsonObject1.put("name", h.getName());
				jsonObject1.put("id", h.getId());
				jsonObjArray.add(jsonObject1);
			});
		
		jsonObject2.put("data", jsonObjArray);
		jsonObject2.put("message", "this is message");
		
	    output.print(jsonObject2.toString());
	    output.flush();
	    jsonObject2.clear();
	    jsonObjArray.clear();
	    
//		request.getParameterNames()
//		StringBuffer jb = new StringBuffer(); // code block to read raw text of the body request
//		String line = null;
//		try {
//			BufferedReader reader = request.getReader();
//			while ((line = reader.readLine()) != null)
//				jb.append(line);
//		} catch (Exception e) {e.printStackTrace();}
//		output.write(jb.toString());
	}
}