package nugu.mountain.api.application.service;

import nugu.mountain.api.infrastructure.mountain.MountainClient;
import nugu.mountain.api.infrastructure.mountain.MountainResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MountainServicempl implements MountainService{
    @Value("${mountain-client.key}")
    String key;
    private final MountainClient mountainClient;

    public MountainServicempl(MountainClient mountainClient) {this.mountainClient = mountainClient;}

    @Override
    public MountainResponse getMountain() {
        return mountainClient.getMountain("gDoW1%2FeiKk0cbJ4ky3uuMDoKGZsEidqjlyqWCwdwLDqpaTNWvljuiOze298HlDqIRBjBho%2FRTiC9i9SY4Fg6lQ%3D%3D",
                                          "가리산",
                                          "강원",
                                          "1",
                                          "10");
    }
}
