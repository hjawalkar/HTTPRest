package Client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;





public class Htmlclient {

	//GET method
	public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget =new HttpGet(url);
		CloseableHttpResponse chr= httpClient.execute(httpget);
		
		//Status code
		  int statuscode = chr.getStatusLine().getStatusCode();
		  System.out.println(statuscode);	
		  
		 //Json string 
		  String res = EntityUtils.toString(chr.getEntity(), "UTF-8");
		  JSONObject jo=  new JSONObject(res);
		  System.out.println(jo);
		  
		  
		  //Headers
		  Header[] ha = chr.getAllHeaders();
		  HashMap<String, String> allheaders = new HashMap<String,String>();
		  
		  for(Header he: ha) {
			  allheaders.put(he.getName(), he.getValue());
		  }
		  System.out.println("Header Array" +allheaders);
		  		  
		
		
	}
}
