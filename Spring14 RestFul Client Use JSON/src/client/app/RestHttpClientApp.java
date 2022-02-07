package client.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import spring.domain.User;

public class RestHttpClientApp {

	public static void main(String[] args) throws Exception {
	////�ּ� �ϳ��� ó���ϸ� ����
		
			//System.out.println("\n==================================\n");
			//1.1 Http Get ��� Request: JsonSimple lib ���
			//RestHttpClientApp.ReqeustHttpGet_UseJsonSimple();
			
			//System.out.println("\n==================================\n");
			//1.2 Http Get ��� Request: CodeHaus lib ���
			//RestHttpClientApp.RequestHttpGet_UseCodeHaus();
			
			//System.out.println("\n==================================\n");
			//2.1 Http Protocol POST ��� Request
			// : Form Data ����(JSON �̿�)/JsonSimple lib ���
			//RestHttpClientApp.RequestHttpPostData_UseJsonSimple();
			
			//System.out.println("\n==================================\n");
			//2.2 Http Protocol POST ��� Request
			// : Form Data ����(JSON �̿�)/CodeHaus lib ���
			RestHttpClientApp.RequestHttpPostData_UseCodeHaus();
		
	}
	
	//=====================================================================//
	public static void ReqeustHttpGet_UseJsonSimple() throws Exception {
		// http Protocol�� client �߻�ȭ Bean
		HttpClient httpClient = new DefaultHttpClient();
		
		//request URL Make
		String url= "http://127.0.0.1:8080/Spring14/user/json/user01"+"?name=user02&age=10";
		
		//http get : Http Protocol GET ��� Request Header ����
		HttpGet httpGet= new HttpGet(url);
		httpGet.setHeader("Accept","application/json");
		httpGet.setHeader("Content-Type","application/json");
		
		//Request ���� �� Response �ޱ� 
		//HttpResponse : Http Protocol ���� Message �߻�ȭ Bean
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		// ==> Response ��� Ȯ��
		System.out.println(httpResponse);
		System.out.println();
		
		//==> Response Header/Body�� Body �ޱ�
		//Http Protocol Body �߻�ȭ Bean
		HttpEntity responsHttpEntity = httpResponse.getEntity();
		
		//==> Server���� ���� Data �б� ���� HttpEntity�� ���� InputStream ����
		InputStream is = responsHttpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[Server���� Data Ȯ��]");
		String serverData = br.readLine();
		System.out.println("==> readLine :: "+serverData);
		
		// ==>Server���� ���� JSONData=> JSON Object��ü ����
		JSONObject jsonObj = (JSONObject)JSONValue.parse(serverData);
		System.out.println("==> JSONObject :: "+jsonObj);
		//System.out.println(jsonObj.get("user"));
	}
	
	public static void RequestHttpGet_UseCodeHaus() throws Exception {
		// http Protocol�� client �߻�ȭ Bean
		HttpClient httpClient = new DefaultHttpClient();
		
		//request URL Make
		String url= "http://127.0.0.1:8080/Spring14/user/json/user01"+"?name=user02&age=10";
		
		//http get : Http Protocol GET ��� Request Header ����
		HttpGet httpGet= new HttpGet(url);
		httpGet.setHeader("Accept","application/json");
		httpGet.setHeader("Content-Type","application/json");
		
		//Request ���� �� Response �ޱ� 
		//HttpResponse : Http Protocol ���� Message �߻�ȭ Bean
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		// ==> Response ��� Ȯ��
		System.out.println(httpResponse);
		System.out.println();
		
		//==> Response Header/Body�� Body �ޱ�
		//Http Protocol Body �߻�ȭ Bean
		HttpEntity responsHttpEntity = httpResponse.getEntity();
		
		//==> Server���� ���� Data �б� ���� HttpEntity�� ���� InputStream ����
		InputStream is = responsHttpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[Server���� Data Ȯ��]");
		String serverData = br.readLine();
		System.out.println("==> Body data :: "+serverData);
		
		// ==>Server���� ���� JSONData=> JSON Object��ü ����
		JSONObject jsonObj = (JSONObject)JSONValue.parse(serverData);
		ObjectMapper objectMapper = new ObjectMapper();
//		User user = objectMapper.readValue(jsonObj.get("user").toString(), User.class);
		User user = objectMapper.readValue(jsonObj.toString(), User.class);
		System.out.println("==> JSONObject binding :: "+ user);
	}
	//=====================================================================//
	
	//=====================================================================//
	
	public static void RequestHttpPostData_UseJsonSimple() throws Exception {
		// http Protocol�� client �߻�ȭ Bean
		HttpClient httpClient = new DefaultHttpClient();
		
		//request URL Make
		String url = "http://127.0.0.1:8080/Spring14/user/json/getUser/user01";
		
		//http get : Http Protocol GET ��� Request Header ����
		HttpPost httpPost= new HttpPost(url);
		httpPost.setHeader("Accept","application/json");
		httpPost.setHeader("Content-Type","application/json");
		
		//==> POST ����� Body�� Data ����
		//==> QueryString (name=value)���� �������� �ʰ�
		//==> JSONData �������� Data Make
		
		//[��� 1 : String ���]
		//String data = "{\"userId\":\"test\",\"userName\":\"ȫ�浿\"}";
		
		//[��� 2 : JSONObject ���]
		JSONObject json = new JSONObject();
		json.put("userId", "test");
		json.put("userName","ȫ�浿");
		
		//==> Response Header/Body�� Body �����
		//Http Protocol Body �߻�ȭ Bean
		HttpEntity requestHttpEntity = new StringEntity(json.toString(),"utf-8");
		httpPost.setEntity(requestHttpEntity);
		
		
		//Request ���� �� Response �ޱ�
		//HttpResponse : Http Protocol ���� Message �߻�ȭ Bean
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		// ==> Response ��� Ȯ��
		System.out.println(httpResponse);
		System.out.println();
		
		//==> Response Header/Body�� Body �ޱ�
		//Http Protocol Body �߻�ȭ Bean
		HttpEntity responseHttpEntity = httpResponse.getEntity();
		
		//==> Server���� ���� Data �б� ���� HttpEntity�� ���� InputStream ����
		InputStream is = responseHttpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[Server���� ���� ������ Ȯ��]");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		// ==>Server���� ���� JSONData=> JSON Object��ü ����
		JSONObject jsonObj = (JSONObject)JSONValue.parse(serverData);
		System.out.println("==> JSONObject :: "+  jsonObj);
	}
	
	public static void RequestHttpPostData_UseCodeHaus() throws Exception {
		// http Protocol�� client �߻�ȭ Bean
		HttpClient httpClient = new DefaultHttpClient();
		
		//request URL Make
		String url= "http://127.0.0.1:8080/Spring14/user/json/getUser/user01";
		
		//http get : Http Protocol GET ��� Request Header ����
		HttpPost httpPost= new HttpPost(url);
		httpPost.setHeader("Accept","application/json");
		httpPost.setHeader("Content-Type","application/json");
		
		//==> POST ����� Body�� Data ����
		//==> QueryString (name=value)���� �������� �ʰ�
		//==> JSONData �������� Data Make
		
		//[��� 1 : String ���]
		//String data = "{\"userId\":\"test\",\"userName\":\"ȫ�浿\"}";
		
		//[��� 2 : JSONObject ���]
		//JSONObject json = new JSONObject();
		//json.put("userId", "test");
		//json.put("userName", "ȫ�浿");
		
		//[��� 3 : codeHaus ���]
		User user = new User("test","ȫ�浿","1111",null,10);
		ObjectMapper objectMapper01 = new ObjectMapper();
		//Domain Object ==> JSON Value ��ȯ
		String JsonValue = objectMapper01.writeValueAsString(user);
		
		//==> Response Header/Body�� Body �����
		//Http Protocol Body �߻�ȭ Bean
		HttpEntity requestHttpEntity = new StringEntity(JsonValue, "utf-8");
		httpPost.setEntity(requestHttpEntity);
		
		//Request ���� �� Response �ޱ�
		//HttpResponse : Http Protocol ���� Message �߻�ȭ Bean
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		// ==> Response ��� Ȯ��
		System.out.println(httpResponse);
		System.out.println();
		
		//==> Response Header/Body�� Body �ޱ�
		//Http Protocol Body �߻�ȭ Bean
		HttpEntity responsHttpEntity = httpResponse.getEntity();
		
		//==> Server���� ���� Data �б� ���� HttpEntity�� ���� InputStream ����
		InputStream is = responsHttpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[Server���� Data Ȯ��]");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		// ==>Server���� ���� JSONData=> JSON Object��ü ����
		JSONObject jsonObj = (JSONObject)JSONValue.parse(serverData);
		ObjectMapper objectMapper = new ObjectMapper();
//		User returnUser = objectMapper.readValue(jsonObj.get("user").toString(), User.class);
		User returnUser = objectMapper.readValue(jsonObj.toString(), User.class);
		System.out.println("==> Domain Object :: "+returnUser);
	}
}
