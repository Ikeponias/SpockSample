package com.example.spock.Component


import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class SpockComponent1FactoryTestSpockAlt extends Specification {
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

    def "GetValueFromSpockComponent4 - 呼び出し回数チェック改"() {
        given:
        spockComponent2.getSpockComponent3() >> {
            Mock(SpockComponent3.class) {
                getSpockComponent4() >> spockComponent4
            }
        }

        when:
        spockComponent1Factory = new SpockComponent1Factory(spockComponent2Factory)
        spockComponent1Factory.getValueFromSpockComponent4(0)

        then:
        1 * spockComponent2Factory.create(_ as Integer) >> spockComponent2
    }
}
