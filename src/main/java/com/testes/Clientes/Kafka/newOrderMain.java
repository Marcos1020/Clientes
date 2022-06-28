package com.testes.Clientes.Kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Slf4j
public class newOrderMain {

    public static void main(String[]args) throws ExecutionException, InterruptedException {

       var producer = new KafkaProducer<String, String>(properties());
       var value = "125, 456, 500000";
       var record = new ProducerRecord<>("Ecommerce", value, value);
       producer.send(record, (data, exception) -> {
           if (exception != null){
               log.error("Mensagem não enviada", exception);
               return;
           }
           System.out.println("Sucesso enviando nesse tópico" + data.topic() +
                   ":::partition" + data.partition() + "/offset" + data.offset() + "/timestamp" + data.timestamp());
       }).get();

    }
    private static Properties properties() {

        properties().setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"27,27,1655474861650:9092");
        properties().setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties().setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties();
    }

}
