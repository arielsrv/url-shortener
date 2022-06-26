package app;

import app.controllers.UrlController;
import io.jooby.Jooby;
import io.jooby.OpenAPIModule;
import io.jooby.di.GuiceModule;
import io.jooby.json.JacksonModule;

public class App extends Jooby {

    {
        install(new OpenAPIModule());
        install(new JacksonModule());
        install(new GuiceModule());

        mvc(UrlController.class);
        mvc(Controller.class);
    }

    public static void main(final String[] args) {
        runApp(args, App::new);
    }
}
