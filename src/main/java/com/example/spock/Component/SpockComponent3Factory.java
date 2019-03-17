package com.example.spock.Component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpockComponent3Factory {

    private final SpockComponent4Factory spockComponent4Factory;

    public SpockComponent3 create(final Integer argC) {
        return new SpockComponent3(spockComponent4Factory.create(argC), argC);
    }
}
