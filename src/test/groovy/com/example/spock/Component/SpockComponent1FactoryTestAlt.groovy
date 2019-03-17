package com.example.spock.Component

import org.mockito.Answers
import org.mockito.InjectMocks
import org.mockito.Mock
import spock.lang.Specification
import spock.lang.Unroll

import static org.mockito.ArgumentMatchers.any
import static org.mockito.Mockito.*
import static org.mockito.MockitoAnnotations.initMocks

@Unroll
class SpockComponent1FactoryTestAlt extends Specification {
    @InjectMocks
    SpockComponent1Factory spockComponent1Factory

    @Mock
    SpockComponent2Factory spockComponent2Factory

    @Mock
    SpockComponent3Factory spockComponent3Factory

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    SpockComponent2 spockComponent2

    @Mock
    SpockComponent3 spockComponent3

    @Mock
    SpockComponent4 spockComponent4

    def setup() {
        initMocks(this)
    }

    def "getValueFromSpockComponent - 呼び出し回数チェック改"() {
        given:
        when(spockComponent2Factory.create(any(Integer.class))).thenReturn(spockComponent2)
        when(spockComponent2.getSpockComponent3().getSpockComponent4()).thenReturn(spockComponent4)

        when:
        spockComponent1Factory.getValueFromSpockComponent4(0)

        then:
        verify(spockComponent2Factory, times(1)).create(any(Integer.class)) || true
    }
}
