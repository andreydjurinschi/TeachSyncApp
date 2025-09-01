package teachsync.course_service.kafka.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import teachsync.requests.CheckIfUserExistsEvent;

@Configuration
public class KafkaTemplateConfig {
    /**
     * checks if user exists in system by sending a message
     *
     * @param pf {@link ProducerFactory}
     * @return {@link KafkaTemplate}
     */
    @Bean
    public KafkaTemplate<String, CheckIfUserExistsEvent> checkIfUserExistsEventKafkaTemplate(
            ProducerFactory<String, CheckIfUserExistsEvent> pf
    ){
        return new KafkaTemplate<>(pf);
    }
}
