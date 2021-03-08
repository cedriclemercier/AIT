package com.example.HW3.observer;

public class Client {
    public static void main(String[] args) {

        // Create subject
        Topic politics = new Topic();
        Topic sports = new Topic();

        // Create observers
        Observer ob1 = new TopicSubscriber("Political CNN");
        Observer ob2 = new TopicSubscriber("General BBC");
        Observer ob3 = new TopicSubscriber("Sports CNN");

        // register observers to the subject
        politics.register(ob1);
        politics.register(ob2);
        sports.register(ob3);

        // attach oserver to subject
        ob1.setSubject(politics);
        ob2.setSubject(politics);
        ob3.setSubject(sports);

        // Check if any update is available?
        ob1.update();

        // Send message to subject
        politics.postMessage("Prime Minister Election");
        sports.postMessage("Manchester City Wins!");
    }
}
