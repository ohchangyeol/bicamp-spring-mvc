package json.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import spring.domain.Search;
import spring.domain.User;
import spring.domain.UserHasASearch;

public class UserHasASearchObjectMapperTestApp {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		UserHasASearch userHasASearch = new UserHasASearch("user01","홍길동","1111",null,10);
		Search search = new Search();
		search.setSearchCondition("이름검색");
		userHasASearch.setSearch(search);
		
		ObjectMapper om= new ObjectMapper();
		
		System.out.println("\n\n///////////////////////////////////////////////");
		System.out.println("1.domain Object => JSON Value(String)로 변환");
		String jsonValue = om.writeValueAsString(userHasASearch);
		System.out.println(jsonValue);
		
		System.out.println();
		
		System.out.println("1.JSON Value(String) => domain Object로 변환 및 값 추출");
		UserHasASearch returnuserHasASearch = om.readValue(jsonValue, UserHasASearch.class);
		System.out.println(returnuserHasASearch);
		System.out.println("userId = "+ returnuserHasASearch.getUserId());
		System.out.println("searchCondition = "+ returnuserHasASearch.getSearch().getSearchCondition());
		
		System.out.println();
		
		System.out.println("1.JSON Value(String) => JSON Object사용 및 값 추출");
		JSONObject jsonObj = (JSONObject)JSONValue.parse(jsonValue);
		System.out.println(jsonObj);
		System.out.println("userId = "+ jsonObj.get("userId"));
		System.out.println("userId = "+ ((JSONObject)jsonObj.get("search")).get("searchCondition"));
		
	}

}
