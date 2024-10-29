package org.example.pubsub

interface Subscriber {
    String receive(String message)
}