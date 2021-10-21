package com.dhk.onlinequiz.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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

    public String getSchoolInfoBySchoolName(String regionCode, String gubun, String schoolName) {
        String requestUrl
                = String.format("http:/www.career.go.kr/cnet/openapi/getOpenApi?apiKey=%s&svcType=api&svcCode=SCHOOL&contentType=json&region=%s&gubun=%s&searchSchulNm=%s", API_KEY, regionCode, gubun, schoolName);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(requestUrl, HttpMethod.GET, null, String.class);

        System.out.println(response.getBody());

        return response.getBody();
    }
}
