package com.kafka.example.consumer;

import com.kafka.example.model.Employee;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    //Consumer for listening to messages of String type
    @KafkaListener(topics = "kafka_topic", groupId = "group_id")
    public void getMessages(String message){

        System.out.println("Published Message: "+message);

    }

    //Consumer for listening to messages of user-defined type
    @KafkaListener(topics = "kafka_topic_two", groupId = "employee_json", containerFactory = "employeeKafkaListenerFactory")
    public void getEmployeeMessage(Employee employee){

        System.out.println("Employee Information: "+employee);

    }

}
