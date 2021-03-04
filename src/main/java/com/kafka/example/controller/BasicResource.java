package com.kafka.example.controller;

import com.kafka.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/kafka")
public class BasicResource {

    //Injecting the kafka template which will be used for publishing the message.
    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    KafkaTemplate<String, Employee> employeeKafkaTemplate;

    //specifying the topic name on which we want to publish the message.
    private static final String TOPIC_NAME="kafka_topic";

    //specifying another topic on which we want to publish the message.
    private final String TOPIC_NAME_TWO="kafka_topic_two";

    //Example to show how to publish a message on a topic (Simple String Message).

    @GetMapping("/postMessage/{message}")
    public String postMessage(@PathVariable("message") final String message){

        //Publishing the message to a topic which we have created.
        kafkaTemplate.send(TOPIC_NAME,message);
        return "Message posted successfully";

    }

    //Publishing message which is of user-defined type.

    @GetMapping("/postObjectMessage")
    public String postEmployee(){

        Employee employee=new Employee();
        employee.setName("Subhash Singh Chouhan");
        employee.setDepartments(Arrays.asList("Administration","Human Resource"));

        //Publishing the message to a topic which have created
        employeeKafkaTemplate.send(TOPIC_NAME_TWO,employee);

        return "Data Published";

    }

}
