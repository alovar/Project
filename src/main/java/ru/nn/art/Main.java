package ru.nn.art;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;


public class Main {
    public static void main(String[] args) {

        Server server = new Server(9000);

        ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

        ctx.setContextPath("/");
        server.setHandler(ctx);

        ServletHolder serHol = new ServletHolder(ServletContainer.class);
        serHol.setInitParameter("jersey.config.server.provider.packages", "ru.nn.art");
        ctx.addServlet(serHol, "/*");

        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            server.destroy();
        }
    }
}
