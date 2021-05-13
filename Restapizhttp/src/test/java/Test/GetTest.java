package Test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import Client.Htmlclient;

public class GetTest extends Base {

	Base ba;
	String serurl;
	String apiurl;
	String url;
	Htmlclient rclient;

	@BeforeMethod
	public void setup() throws ClientProtocolException, IOException {

		ba = new Base();
		serurl = prop.getProperty("Url");
		apiurl = prop.getProperty("serviceurl");

		url = serurl + apiurl;
		System.out.println(url);
	}

	@Test
	public void  getTest() throws ClientProtocolException, IOException {
		rclient = new Htmlclient();
		rclient.get(url);


	}
}
