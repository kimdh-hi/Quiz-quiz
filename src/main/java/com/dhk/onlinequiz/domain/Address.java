package com.dhk.onlinequiz.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Address {

    private String address;
    private String detailAddress;
}
