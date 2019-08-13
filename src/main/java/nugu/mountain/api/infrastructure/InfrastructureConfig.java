package nugu.mountain.api.infrastructure;

import feign.Feign;
import feign.Retryer;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import nugu.mountain.api.infrastructure.mountain.MountainClient;
import nugu.mountain.api.infrastructure.nifos.NifosClient;
import nugu.mountain.api.infrastructure.sk.SkClient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.apache.commons.lang.CharEncoding.UTF_8;

@EnableFeignClients
@EnableAutoConfiguration
@Configuration
public class InfrastructureConfig {

    @Bean
    public MountainClient MountainClient() {
        return Feign.builder()
                    .decoder(new JAXBDecoder(new JAXBContextFactory.Builder()
                                                 .withMarshallerJAXBEncoding(UTF_8)
                                                 .build()))
                    .contract(new SpringMvcContract())
                    .retryer(new Retryer.Default())
                    .target(MountainClient.class, "mountain-client");
    }

    @Bean
    public SkClient SkClient() {
        return Feign.builder()
                    .contract(new SpringMvcContract())
                    .retryer(new Retryer.Default())
                    .target(SkClient.class, "sk-client");
    }

    @Bean
    public NifosClient NifosClient() {
        return Feign.builder()
                    .contract(new SpringMvcContract())
                    .retryer(new Retryer.Default())
                    .target(NifosClient.class, "nifos-client");
    }
}
