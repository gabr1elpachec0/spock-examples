package br.com.spockexample.test

import org.example.pubsub.Publisher
import org.example.pubsub.Subscriber
import spock.lang.Specification

class PublisherSpec extends Specification {
    Publisher publisher = new Publisher()
    Subscriber subscriber1 = Mock(Subscriber)
    Subscriber subscriber2 = Mock(Subscriber)

    def setup() {
        publisher.subscribers << subscriber1
        publisher.subscribers << subscriber2
    }

    def "should send messages to all subscribers"() {
        when:
        publisher.send("hello")

        then:
        1 * subscriber1.receive("hello")
        1 * subscriber2.receive("hello")
    }
}
