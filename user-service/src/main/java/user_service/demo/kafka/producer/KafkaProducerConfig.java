package user_service.demo.kafka.producer;

import org.springframework.kafka.support.serializer.JsonSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс, отвечающий за конфигурации брокера Kafka
 */
@Configuration
public class KafkaProducerConfig {

    /**
     * Метод, создающий кафка продюсеров
     * BOOTSTRAP_SERVERS_CONFIG - адрес кафка брокера
     * KEY_SERIALIZER_CLASS_CONFIG - ключи сообщения в виде обичной строки
     * VALUE_SERIALIZER_CLASS_CONFIG - значения сообщения - тоже обычная строка
     * @return {@link DefaultKafkaProducerFactory} - кофигурационный объект с заданными свойствами
     */
    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        configProps.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, true);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
