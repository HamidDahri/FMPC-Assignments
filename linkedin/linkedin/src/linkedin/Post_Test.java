package linkedin;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

public class Post_Test {
	public LinkedInProfile sendPost(String code ) throws Exception {

		String url = "https://www.linkedin.com/oauth/v2/accessToken";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Host", "www.linkedin.com");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		String urlParameters = "grant_type=authorization_code&code="+code+"&redirect_uri="+credential.redirect_url+"&client_id="+credential.client_id+"&client_secret="+credential.client_secret+"";

		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'POST' request to URL : " + url);
		//System.out.println("Post parameters : " + urlParameters);
		//System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//System.out.println(response.toString());
		
		JSONObject jsonObj = new JSONObject(response.toString());
		String access_token = jsonObj.getString("access_token");
		System.out.println(access_token);
		
		//System.out.println(access_token);
		 
		LinkedInProfile obj_LinkedInProfile=new LinkedInProfile();
		obj_LinkedInProfile=sendGet(access_token);
		
		return obj_LinkedInProfile;

	}
	
	private static LinkedInProfile sendGet(String access_token) throws Exception {
		
		LinkedInProfile obj_LinkedInProfile=new LinkedInProfile();
		
		String url = "https://api.linkedin.com/v2/me";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		con.setRequestProperty("Host", "api.linkedin.com");
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Authorization", "Bearer "+	access_token);
		
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		//System.out.println("hamid"+response.toString());
		
		JSONObject jsonObj = new JSONObject(response.toString());
		 System.out.println("salam"+jsonObj);
		obj_LinkedInProfile.setFirstName(jsonObj.getString("localizedFirstName"));
		obj_LinkedInProfile.setLastName(jsonObj.getString("localizedLastName"));
		obj_LinkedInProfile.setId(jsonObj.getString("id"));
		
		System.out.println(access_token);
		

		return obj_LinkedInProfile;
	}
	

}