package app;

import app.controllers.UrlController;
import app.model.UrlMapping;
import io.jooby.Environment;
import io.jooby.Jooby;
import io.jooby.OpenAPIModule;
import io.jooby.di.GuiceModule;
import io.jooby.hibernate.HibernateModule;
import io.jooby.hikari.HikariModule;
import io.jooby.json.JacksonModule;

public class App extends Jooby {

    {
        Environment env = getEnvironment();

        install(new OpenAPIModule());
        install(new JacksonModule());
        install(new GuiceModule(new AppModule()));

        if (env.getActiveNames().contains("dev")) {
            install(new HikariModule());
            install(new HibernateModule(UrlMapping.class));
        }

        mvc(UrlController.class);
        mvc(Controller.class);
    }

    public static void main(final String[] args) {
        runApp(args, App::new);
    }
}
