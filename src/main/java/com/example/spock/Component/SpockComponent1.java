package com.example.spock.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SpockComponent1 {

    private final SpockComponent2 spockComponent2;

    private final Integer a;
}
