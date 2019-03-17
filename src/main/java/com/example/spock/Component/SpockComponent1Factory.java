package com.example.spock.Component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpockComponent1Factory {

    private final SpockComponent2Factory spockComponent2Factory;

    public Integer getValueFromSpockComponent4(final Integer argA) {

        final SpockComponent1 spockComponent1 = new SpockComponent1(spockComponent2Factory.create(argA), argA);

        return spockComponent1.getSpockComponent2().getSpockComponent3().getSpockComponent4().getD();
    }

    public void nullArgumentMethodCall() {
        spockComponent2Factory.nullArgumentMethodCalled(null);
    }
}
