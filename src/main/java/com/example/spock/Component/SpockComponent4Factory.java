package com.example.spock.Component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpockComponent4Factory {
    public SpockComponent4 create(final Integer argD) {
        return new SpockComponent4(argD);
    }
}
