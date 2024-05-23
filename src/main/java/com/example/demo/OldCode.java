package com.example.demo;

public class OldCode {

    //rabbitTemplate.convertAndSend("myQueue", "Hello World");

    /*
    @Bean
    public Queue myQueue() {
        return new Queue("myQueue", false);
    }

    @RabbitListener(queues = "myQueue")
    public void receiveMessage(String message) {
        System.out.println(message);
    }
    */
}
