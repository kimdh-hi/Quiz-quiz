package com.dhk.onlinequiz.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SchoolInfoApiResponse {

    private String schoolName;
    private String address;
    private String link;
    private String region;
}
