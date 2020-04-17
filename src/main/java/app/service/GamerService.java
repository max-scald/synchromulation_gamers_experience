package app.service;

import app.controller.StandardResponse;
import org.springframework.stereotype.Service;

@Service
public interface GamerService {

    public StandardResponse updateGamer(String data, String gamerId);

    public StandardResponse getGamer(String gamerId);

    public StandardResponse updateStatistic(Integer activity, String gamerId);
}
