package Layer1_EntryPoint;

import io.javalin.Javalin;
import Layer1_EntryPoint.apiHandler;

public class webApi {

    private final Javalin server;

    public webApi() {

        server = Javalin.create(config -> {
            config.defaultContentType = "application/json";
            config.enableCorsForAllOrigins();
        });
        this.server.get("/session/{id}", apiHandler::getOne);
    }


    public void start(int port) {
        this.server.start(port);
        webApi server = new webApi();
    }

    public void stop() {
        this.server.stop();
    }
}
