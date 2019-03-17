package com.example.spock.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

@Getter
@RequiredArgsConstructor
public class SpockComponent2 {

    private final SpockComponent3 spockComponent3;

    private final Integer b;
}
