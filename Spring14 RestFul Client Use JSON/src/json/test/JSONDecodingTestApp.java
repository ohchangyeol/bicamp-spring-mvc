package json.test;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JSONDecodingTestApp {
	// main Method
	public static void main(String[] args) {
		String data ="{\"address\":\"����\",\"age\":1000,\"name\":\"ȫ�浿\"}";
		JSONObject jsonObj = (JSONObject)JSONValue.parse(data);
		
		System.out.println("json object Ȯ�� ==> "+ jsonObj);
		
		System.out.println("==> json object data ����");
		System.out.println(jsonObj.get("address"));
		System.out.println("\n\n");
		
		/////////////////////////////////////////////////////////////
		String arrayData = "[\"����\",1000,\"ȫ�浿\"]";
		JSONArray jsonArray = (JSONArray)JSONValue.parse(arrayData);
		
		System.out.println("json object Ȯ�� ==> "+ jsonArray);
		
		System.out.println("==> json object data ����");
		
		for (int i = 0 ; i < jsonArray.size(); i++) {
			System.out.println(jsonArray.get(i));
		}
		
		
	}
	

}
