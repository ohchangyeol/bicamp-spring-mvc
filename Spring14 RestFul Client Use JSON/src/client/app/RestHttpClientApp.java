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
	////주석 하나씩 처리하며 연습
		
			//System.out.println("\n==================================\n");
			//1.1 Http Get 방식 Request: JsonSimple lib 사용
			//RestHttpClientApp.ReqeustHttpGet_UseJsonSimple();
			
			//System.out.println("\n==================================\n");
			//1.2 Http Get 방식 Request: CodeHaus lib 사용
			//RestHttpClientApp.RequestHttpGet_UseCodeHaus();
			
			//System.out.println("\n==================================\n");
			//2.1 Http Protocol POST 방식 Request
			// : Form Data 전달(JSON 이용)/JsonSimple lib 사용
			//RestHttpClientApp.RequestHttpPostData_UseJsonSimple();
			
			//System.out.println("\n==================================\n");
			//2.2 Http Protocol POST 방식 Request
			// : Form Data 전달(JSON 이용)/CodeHaus lib 사용
			RestHttpClientApp.RequestHttpPostData_UseCodeHaus();
		
	}
	
	//=====================================================================//
	public static void ReqeustHttpGet_UseJsonSimple() throws Exception {
		// http Protocol의 client 추상화 Bean
		HttpClient httpClient = new DefaultHttpClient();
		
		//request URL Make
		String url= "http://127.0.0.1:8080/Spring14/user/json/user01"+"?name=user02&age=10";
		
		//http get : Http Protocol GET 방식 Request Header 구성
		HttpGet httpGet= new HttpGet(url);
		httpGet.setHeader("Accept","application/json");
		httpGet.setHeader("Content-Type","application/json");
		
		//Request 실행 및 Response 받기 
		//HttpResponse : Http Protocol 응답 Message 추상화 Bean
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		// ==> Response 출력 확인
		System.out.println(httpResponse);
		System.out.println();
		
		//==> Response Header/Body중 Body 받기
		//Http Protocol Body 추상화 Bean
		HttpEntity responsHttpEntity = httpResponse.getEntity();
		
		//==> Server에서 받은 Data 읽기 위해 HttpEntity로 부터 InputStream 생성
		InputStream is = responsHttpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[Server에서 Data 확인]");
		String serverData = br.readLine();
		System.out.println("==> readLine :: "+serverData);
		
		// ==>Server에서 받은 JSONData=> JSON Object객체 생성
		JSONObject jsonObj = (JSONObject)JSONValue.parse(serverData);
		System.out.println("==> JSONObject :: "+jsonObj);
		//System.out.println(jsonObj.get("user"));
	}
	
	public static void RequestHttpGet_UseCodeHaus() throws Exception {
		// http Protocol의 client 추상화 Bean
		HttpClient httpClient = new DefaultHttpClient();
		
		//request URL Make
		String url= "http://127.0.0.1:8080/Spring14/user/json/user01"+"?name=user02&age=10";
		
		//http get : Http Protocol GET 방식 Request Header 구성
		HttpGet httpGet= new HttpGet(url);
		httpGet.setHeader("Accept","application/json");
		httpGet.setHeader("Content-Type","application/json");
		
		//Request 실행 및 Response 받기 
		//HttpResponse : Http Protocol 응답 Message 추상화 Bean
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		// ==> Response 출력 확인
		System.out.println(httpResponse);
		System.out.println();
		
		//==> Response Header/Body중 Body 받기
		//Http Protocol Body 추상화 Bean
		HttpEntity responsHttpEntity = httpResponse.getEntity();
		
		//==> Server에서 받은 Data 읽기 위해 HttpEntity로 부터 InputStream 생성
		InputStream is = responsHttpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[Server에서 Data 확인]");
		String serverData = br.readLine();
		System.out.println("==> Body data :: "+serverData);
		
		// ==>Server에서 받은 JSONData=> JSON Object객체 생성
		JSONObject jsonObj = (JSONObject)JSONValue.parse(serverData);
		ObjectMapper objectMapper = new ObjectMapper();
//		User user = objectMapper.readValue(jsonObj.get("user").toString(), User.class);
		User user = objectMapper.readValue(jsonObj.toString(), User.class);
		System.out.println("==> JSONObject binding :: "+ user);
	}
	//=====================================================================//
	
	//=====================================================================//
	
	public static void RequestHttpPostData_UseJsonSimple() throws Exception {
		// http Protocol의 client 추상화 Bean
		HttpClient httpClient = new DefaultHttpClient();
		
		//request URL Make
		String url = "http://127.0.0.1:8080/Spring14/user/json/getUser/user01";
		
		//http get : Http Protocol GET 방식 Request Header 구성
		HttpPost httpPost= new HttpPost(url);
		httpPost.setHeader("Accept","application/json");
		httpPost.setHeader("Content-Type","application/json");
		
		//==> POST 방식은 Body에 Data 전송
		//==> QueryString (name=value)으로 전송하지 않고
		//==> JSONData 전송위해 Data Make
		
		//[방법 1 : String 사용]
		//String data = "{\"userId\":\"test\",\"userName\":\"홍길동\"}";
		
		//[방법 2 : JSONObject 사용]
		JSONObject json = new JSONObject();
		json.put("userId", "test");
		json.put("userName","홍길동");
		
		//==> Response Header/Body중 Body 만들기
		//Http Protocol Body 추상화 Bean
		HttpEntity requestHttpEntity = new StringEntity(json.toString(),"utf-8");
		httpPost.setEntity(requestHttpEntity);
		
		
		//Request 실행 및 Response 받기
		//HttpResponse : Http Protocol 응답 Message 추상화 Bean
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		// ==> Response 출력 확인
		System.out.println(httpResponse);
		System.out.println();
		
		//==> Response Header/Body중 Body 받기
		//Http Protocol Body 추상화 Bean
		HttpEntity responseHttpEntity = httpResponse.getEntity();
		
		//==> Server에서 받은 Data 읽기 위해 HttpEntity로 부터 InputStream 생성
		InputStream is = responseHttpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[Server에서 받은 데이터 확인]");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		// ==>Server에서 받은 JSONData=> JSON Object객체 생성
		JSONObject jsonObj = (JSONObject)JSONValue.parse(serverData);
		System.out.println("==> JSONObject :: "+  jsonObj);
	}
	
	public static void RequestHttpPostData_UseCodeHaus() throws Exception {
		// http Protocol의 client 추상화 Bean
		HttpClient httpClient = new DefaultHttpClient();
		
		//request URL Make
		String url= "http://127.0.0.1:8080/Spring14/user/json/getUser/user01";
		
		//http get : Http Protocol GET 방식 Request Header 구성
		HttpPost httpPost= new HttpPost(url);
		httpPost.setHeader("Accept","application/json");
		httpPost.setHeader("Content-Type","application/json");
		
		//==> POST 방식은 Body에 Data 전송
		//==> QueryString (name=value)으로 전송하지 않고
		//==> JSONData 전송위해 Data Make
		
		//[방법 1 : String 사용]
		//String data = "{\"userId\":\"test\",\"userName\":\"홍길동\"}";
		
		//[방법 2 : JSONObject 사용]
		//JSONObject json = new JSONObject();
		//json.put("userId", "test");
		//json.put("userName", "홍길동");
		
		//[방법 3 : codeHaus 사용]
		User user = new User("test","홍길동","1111",null,10);
		ObjectMapper objectMapper01 = new ObjectMapper();
		//Domain Object ==> JSON Value 변환
		String JsonValue = objectMapper01.writeValueAsString(user);
		
		//==> Response Header/Body중 Body 만들기
		//Http Protocol Body 추상화 Bean
		HttpEntity requestHttpEntity = new StringEntity(JsonValue, "utf-8");
		httpPost.setEntity(requestHttpEntity);
		
		//Request 실행 및 Response 받기
		//HttpResponse : Http Protocol 응답 Message 추상화 Bean
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		// ==> Response 출력 확인
		System.out.println(httpResponse);
		System.out.println();
		
		//==> Response Header/Body중 Body 받기
		//Http Protocol Body 추상화 Bean
		HttpEntity responsHttpEntity = httpResponse.getEntity();
		
		//==> Server에서 받은 Data 읽기 위해 HttpEntity로 부터 InputStream 생성
		InputStream is = responsHttpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[Server에서 Data 확인]");
		String serverData = br.readLine();
		System.out.println(serverData);
		
		// ==>Server에서 받은 JSONData=> JSON Object객체 생성
		JSONObject jsonObj = (JSONObject)JSONValue.parse(serverData);
		ObjectMapper objectMapper = new ObjectMapper();
//		User returnUser = objectMapper.readValue(jsonObj.get("user").toString(), User.class);
		User returnUser = objectMapper.readValue(jsonObj.toString(), User.class);
		System.out.println("==> Domain Object :: "+returnUser);
	}
}
