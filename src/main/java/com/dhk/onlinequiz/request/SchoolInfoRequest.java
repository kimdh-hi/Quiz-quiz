package com.dhk.onlinequiz.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SchoolInfoRequest {

    private String name;
    private String region;
    private String type;
}
