package com.dhk.onlinequiz.utils;

import com.dhk.onlinequiz.response.SchoolInfoApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@PropertySource("classpath:key.properties")
public class SchoolInfoApi {

    @Value("${school.key}") private String API_KEY;

    public String getAllSchoolInfo(String regionCode, String gubun) {
        String requestUrl
                = String.format("http://www.career.go.kr/cnet/openapi/getOpenApi?apiKey=%s&svcType=api&svcCode=SCHOOL&contentType=json&region=%s&gubun=%s", API_KEY, regionCode, gubun);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(requestUrl, HttpMethod.GET, null, String.class);

        System.out.println(response.getBody());

        return response.getBody();

    }

    public List<SchoolInfoApiResponse> getSchoolInfoBySchoolName(String regionCode, String gubun, String schoolName) throws Exception{

        String requestUrl
                = String.format("http://www.career.go.kr/cnet/openapi/getOpenApi?apiKey=%s&svcType=api&svcCode=SCHOOL&contentType=json&region=%s&gubun=%s&searchSchulNm=%s", API_KEY, regionCode, gubun, schoolName);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(requestUrl, HttpMethod.GET, null, String.class);

        List<SchoolInfoApiResponse> schoolInfoApiResponse = new ArrayList<>();

        JSONObject obj = new JSONObject(response.getBody());
        JSONArray contents = obj.getJSONObject("dataSearch").getJSONArray("content");

        for (int i=0; i<contents.length(); i++) {
            JSONObject content = contents.getJSONObject(i);
            String name = content.getString("schoolName");
            String address = content.getString("adres");
            String link = content.getString("link");
            String region = content.getString("region");

            schoolInfoApiResponse.add(new SchoolInfoApiResponse(name, address, link, region));
        }


        return schoolInfoApiResponse;
    }

}
