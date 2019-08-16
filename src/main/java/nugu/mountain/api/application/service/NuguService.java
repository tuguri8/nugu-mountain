package nugu.mountain.api.application.service;

import nugu.mountain.api.interfaces.dto.request.NuguRequest;
import nugu.mountain.api.interfaces.dto.response.NuguResponse;

import java.io.IOException;

public interface NuguService {
    NuguResponse testFunc(NuguRequest nuguRequest) throws IOException;
}
