package com.dhk.onlinequiz.controller.student;

import com.dhk.onlinequiz.request.SchoolInfoRequest;
import com.dhk.onlinequiz.response.SchoolInfoApiResponse;
import com.dhk.onlinequiz.utils.SchoolInfoApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
public class SignupController {

    private final SchoolInfoApi schoolInfoApi;

    @ResponseBody
    @GetMapping("/api/signup/school")
    public ResponseEntity<List<SchoolInfoApiResponse>> getSignupSchoolInfo(SchoolInfoRequest schoolInfoRequest, Model model) throws Exception {
        String schoolName = schoolInfoRequest.getName();
        String region = schoolInfoRequest.getRegion();
        String type = schoolInfoRequest.getType();
        List<SchoolInfoApiResponse> schoolInfoList = new ArrayList<>();
        if (schoolInfoApi != null) {
            log.info("학교이름과 함께 조회");
            schoolInfoList = schoolInfoApi.getSchoolInfoBySchoolName(region, type, schoolName);
        }

        for (SchoolInfoApiResponse res : schoolInfoList) {
            log.info("schoolName = {}", res.getSchoolName());
        }
        return ResponseEntity.ok(schoolInfoList);
    }
}
