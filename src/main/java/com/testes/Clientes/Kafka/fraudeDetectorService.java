package com.testes.Clientes.Kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

@Slf4j
public class fraudeDetectorService {

    public static void main(String[] args) throws InterruptedException {
        var consumer = new KafkaConsumer<String, String>(properties());
        consumer.subscribe(Collections.singletonList("Ecommerce"));
        while (true) {
            var records = consumer.poll(Duration.ofMillis(100));
            if (records.isEmpty()) {
                System.out.println("Encontrei" + records.count() + "registro");
            }
            for (var record : records) {
                System.out.println("Checando por uma fraude");
                System.out.println(record.key());
                System.out.println(record.partition());
                System.out.println(record.value());
                System.out.println(record.offset());
                Thread.sleep(5000);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                System.out.println("Ordem processada com sucesso");
            }
        }
    }

    private static Properties properties() {

        properties().setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "27,27,1655474861650:9092");
        properties().setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties().setProperty(ConsumerConfig.GROUP_ID_CONFIG, fraudeDetectorService.class.getSimpleName());

        return properties();
    }


}
