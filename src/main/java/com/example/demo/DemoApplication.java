package com.example.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public DemoApplication(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String queueName = "products_queue";
        Connection connection = getConnection();
        Channel channel = connection.createChannel();
        createQueue(channel, queueName);
        sendMessage(channel, queueName, "product details");
        closeConnection(connection, channel);
    }

    private Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory.newConnection();
    }

    private void closeConnection(Connection connection, Channel channel) throws IOException, TimeoutException {
        channel.close();
        connection.close();
    }

    private void createQueue(Channel channel, String queueName) throws IOException {
        channel.queueDeclare(queueName, false, false, false, null);
    }

    private void sendMessage(Channel channel, String queueName, String message) throws IOException {
        channel.basicPublish("", queueName, null, message.getBytes());
    }
}
