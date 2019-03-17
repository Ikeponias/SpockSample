package com.example.spock.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpockComponent2Factory {

    private final SpockComponent3Factory spockComponent3Factory;

    public SpockComponent2 create(final Integer argB) {
        return new SpockComponent2(spockComponent3Factory.create(argB), argB);
    }

    public void nullArgumentMethodCalled(final String arg) {

    }
}
