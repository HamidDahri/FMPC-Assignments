package weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

import com.google.gson.*;
import com.google.gson.reflect.*;

@WebServlet("/weather")
public class weather extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public weather() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public static Map<String, Object> jsonToMap(String str){
    	Map<String, Object> map = new Gson().fromJson(
    			str, new TypeToken<HashMap<String, Object>>() {}.getType()
    			);
    	return map;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		StringBuilder result = new StringBuilder();
	    String city = request.getParameter("cityname");
	    String country = request.getParameter("countryName");
	    System.out.println(city);
	    String urlString = "http://api.openweathermap.org/data/2.5/weather?q=+"+city+","+country+"&appid=316e89648a24f16538fe0a738eb7b511";
	    URL url = new URL(urlString);
	    URLConnection conn = url.openConnection();
	    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    String line;
	    while ((line = rd.readLine()) !=null){
	       result.append(line);	
	    System.out.println(result);
	    
		}
	    	
	    rd.close();	
	    
		
		Map<String, Object> respMap = jsonToMap(result.toString());
		Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
		Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
		Map<String, Object> sysMap  = jsonToMap(respMap.get("sys").toString());
		
			request.setAttribute("temp",mainMap.get("temp").toString() );
			request.setAttribute("humidity",mainMap.get("humidity").toString() );
			request.setAttribute("pressure",mainMap.get("pressure").toString() );
			request.setAttribute("feels_like",mainMap.get("feels_like").toString() );
			request.setAttribute("speed",windMap.get("speed").toString() );
			request.setAttribute("deg",windMap.get("deg").toString() );
			request.setAttribute("name",respMap.get("name").toString() );
			request.setAttribute("country",sysMap.get("country").toString() );
	        
		
		//System.out.println("1	"+mainMap.get("temp"));
		//System.out.println("4	"+mainMap.get("humidity"));
		//System.out.println("5	"+mainMap.get("pressure"));
		//System.out.println("6	"+mainMap.get("feels_like"));
		//System.out.println("7	"+windMap.get("speed"));
		//System.out.println("8	"+windMap.get("deg"));
		//System.out.println("9	"+respMap.get("name"));
		//System.out.println("10	"+sysMap.get("country"));
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher req = request.getRequestDispatcher("success.jsp");
		req.include(request, response);
	  
	}

}
