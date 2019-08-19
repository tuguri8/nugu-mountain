package nugu.mountain.api.infrastructure.nifos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NifosClientTest {
    @Value("${nifos-client.key}")
    String key;

    @Autowired
    private NifosClient nifosClient;

    @Test
    public void 산불_위험_테스트() {
        nifosClient.getMountainFireRate(key,"11","sido","1.1","1");
    }

}