package teachsync.demo.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * This is topic config class for course service
 */
@Configuration
public class KafkaTopicsConfig {

    @Bean
    public NewTopic courseTopicForUserService(){
        return TopicBuilder.name("check-user-response").build();
    }
}
