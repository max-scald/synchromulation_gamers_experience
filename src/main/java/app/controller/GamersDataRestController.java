package app.controller;

import app.config.Spark;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import app.service.GamerService;
import org.springframework.stereotype.Controller;
import static spark.Spark.*;

@Slf4j
@Controller
public class GamersDataRestController implements Spark {

    private final GamerService gamerService;

    public GamersDataRestController(GamerService gamerService) {
        this.gamerService = gamerService;
    }

    @Override
    public void register() {
        port(8080);
        int maxThreads = 8;
        int minThreads = 2;
        int timeOutMillis = 30000;
        threadPool(maxThreads, minThreads, timeOutMillis);

        post("/gamers/synchronization/:uuid", (request, response) -> {
            response.type("application/json");
            String uuid = request.params(":uuid");
            String gamerData = request.body();
            return new Gson().toJson(gamerService.updateGamer(gamerData, uuid));
        });

        get("/gamers/get_gamer_data/:uuid", (request, response) -> {
            String uuid = request.params(":uuid");
            return new Gson().toJson(gamerService.getGamer(uuid));
        });

        post("/gamers/set_activity/:activity,:uuid", (request, response) -> {
            Integer activity = Integer.valueOf(request.params(":activity"));
            String uuid = request.params(":uuid");
            return new Gson().toJson(gamerService.updateStatistic(activity, uuid));
        });
    }
}
