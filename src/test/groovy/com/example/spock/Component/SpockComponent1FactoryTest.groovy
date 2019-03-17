package com.example.spock.Component

import org.mockito.Answers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Spy
import spock.lang.Specification
import spock.lang.Unroll

import static org.mockito.ArgumentMatchers.nullable
import static org.mockito.MockitoAnnotations.initMocks
import static org.mockito.ArgumentMatchers.any
import static org.mockito.Mockito.times
import static org.mockito.Mockito.verify
import static org.mockito.Mockito.when

@Unroll
class SpockComponent1FactoryTest extends Specification {
    @InjectMocks
    SpockComponent1Factory spockComponent1Factory

    @Mock
    SpockComponent2Factory spockComponent2Factory

    @Mock
    SpockComponent3Factory spockComponent3Factory

    @Mock
    SpockComponent2 spockComponent2

    @Mock
    SpockComponent3 spockComponent3

    @Mock
    SpockComponent4 spockComponent4

    def setup() {
        initMocks(this)
    }

    def "GetValueFromSpockComponent4 - 呼び出し回数チェック"() {
        given:
        when(spockComponent2Factory.create(any(Integer.class))).thenReturn(spockComponent2)
        when(spockComponent2.getSpockComponent3()).thenReturn(spockComponent3)
        when(spockComponent3.getSpockComponent4()).thenReturn(spockComponent4)

        when:
        spockComponent1Factory.getValueFromSpockComponent4(0)

        then:
        verify(spockComponent2Factory, times(1)).create(any(Integer.class)) || true
    }

    def "NullArgumentMethodCall - 呼び出し回数チェック失敗"() {
        when:
        spockComponent1Factory.nullArgumentMethodCall()

        then:
        verify(spockComponent2Factory, times(1)).nullArgumentMethodCalled(any(String.class)) || true
    }

    def "NullArgumentMethodCall - 呼び出し回数チェック成功"() {
        when:
        spockComponent1Factory.nullArgumentMethodCall()

        then:
        verify(spockComponent2Factory, times(1)).nullArgumentMethodCalled(nullable(String.class)) || true
    }

}
