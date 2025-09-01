package teachsync.demo.kafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import teachsync.responses.CheckIfUserExistsResponse;

@Configuration
public class KafkaTemplateConfig {
    /**
     * checks if user exists in system by sending a message
     *
     * @param pf {@link ProducerFactory}
     * @return {@link KafkaTemplate}
     */
    @Bean
    public KafkaTemplate<String, CheckIfUserExistsResponse> checkIfUserExistsEventKafkaTemplate(
            ProducerFactory<String, CheckIfUserExistsResponse> pf
    ){
        return new KafkaTemplate<>(pf);
    }
}
