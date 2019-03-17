package com.example.spock.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

@Getter
@RequiredArgsConstructor
public class SpockComponent3 {

    private final SpockComponent4 spockComponent4;

    private final Integer c;
}
