package com.example.spock.Component


import org.mockito.InjectMocks
import org.mockito.Mock
import spock.lang.Specification
import spock.lang.Unroll

import static org.mockito.ArgumentMatchers.any
import static org.mockito.ArgumentMatchers.nullable
import static org.mockito.Mockito.*
import static org.mockito.MockitoAnnotations.initMocks

@Unroll
class SpockComponent1FactoryTestSpock extends Specification {
    SpockComponent1Factory spockComponent1Factory

    SpockComponent2Factory spockComponent2Factory

    SpockComponent2 spockComponent2

    SpockComponent3 spockComponent3

    SpockComponent4 spockComponent4

    def setup() {
        spockComponent2Factory = Mock(SpockComponent2Factory.class)
        spockComponent2 = Mock(SpockComponent2.class)
        spockComponent3 = Mock(SpockComponent3.class)
        spockComponent4 = Mock(SpockComponent4.class)
    }

    def "GetValueFromSpockComponent4 - 呼び出し回数チェック失敗"() {
        given:
        spockComponent3.getSpockComponent4() >> spockComponent4
        spockComponent2.getSpockComponent3() >> spockComponent3
        spockComponent2Factory.create(_ as Integer) >> spockComponent2

        when:
        spockComponent1Factory = new SpockComponent1Factory(spockComponent2Factory)
        spockComponent1Factory.getValueFromSpockComponent4(0)

        then:
        1 * spockComponent2Factory.create(_ as Integer)
    }

    def "GetValueFromSpockComponent4 - 呼び出し回数チェック成功"() {
        given:
        spockComponent3.getSpockComponent4() >> spockComponent4
        spockComponent2.getSpockComponent3() >> spockComponent3

        when:
        spockComponent1Factory = new SpockComponent1Factory(spockComponent2Factory)
        spockComponent1Factory.getValueFromSpockComponent4(0)

        then:
        1 * spockComponent2Factory.create(_ as Integer) >> spockComponent2
    }

    def "NullArgumentMethodCall - 呼び出し回数チェック"() {
        when:
        spockComponent1Factory = new SpockComponent1Factory(spockComponent2Factory)
        spockComponent1Factory.nullArgumentMethodCall()

        then:
        spockComponent2Factory.nullArgumentMethodCalled(_ as String)
    }
}
