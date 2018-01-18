import infrastructure.spring.service.AddressParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConf {
    @Bean
    public AddressParser getAddressParser() {
        return new AddressParser();
    }
}
