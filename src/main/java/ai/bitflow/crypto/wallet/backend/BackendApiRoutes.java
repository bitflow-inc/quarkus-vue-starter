package ai.bitflow.crypto.wallet.backend;

import ai.bitflow.crypto.wallet.backend.svcs.BackendWalletService;
import io.quarkus.vertx.web.Body;
import io.quarkus.vertx.web.Param;
import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RouteBase;
import io.smallrye.mutiny.Uni;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import ai.bitflow.crypto.wallet.backend.entities.Contact;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import java.util.List;
import java.util.NoSuchElementException;

import static io.quarkus.vertx.web.Route.HandlerType.FAILURE;
import static io.vertx.core.http.HttpMethod.*;

/**
 * An example using Vert.x Web, Hibernate Reactive and Mutiny.
 */
@RouteBase(path = "/api/v1/wallets", produces = "application/json")
public class BackendApiRoutes {

    private static final Logger LOGGER = Logger.getLogger(BackendApiRoutes.class.getName());

    @Inject
    BackendWalletService cSvc;

    @Route(methods = GET, path = "/")
    public Uni<List<Contact>> getAll() throws Exception {
        // In this case, it makes sense to return a Uni<List<Fruit>> because we return a reasonable amount of results
        // Consider returning a Multi<Fruit> for result streams 
//        return session.createNamedQuery(Fruit.FIND_ALL, Fruit.class).getResultList();
        return null;
    }

    @Route(methods = GET, path = "/:id")
    public Uni<Contact> getSingle(@Param String id) {
//        return session.find(Fruit.class, Integer.valueOf(id));
        return null;
    }

    @Route(methods = POST, path = "/")
    public Uni<Contact> create(@Body Contact fruit, HttpServerResponse response) {
//        if (fruit == null || fruit.getId() != null) {
//            return Uni.createFrom().failure(new IllegalArgumentException("Fruit id invalidly set on request."));
//        }
//        return session.persist(fruit)
//                .chain(session::flush)
//                .onItem().transform(ignore -> {
//                    response.setStatusCode(201);
//                    return fruit;
//                });
        return null;
    }

    @Route(methods = PUT, path = "/:id")
    public Uni<Contact> update(@Body Contact fruit, @Param String id) {
//        if (fruit == null || fruit.getName() == null) {
//            return Uni.createFrom().failure(new IllegalArgumentException("Fruit name was not set on request."));
//        }
//        return session.find(Fruit.class, Integer.valueOf(id))
//                // If entity exists then update
//                .onItem().ifNotNull().transformToUni(entity -> {
//                    entity.setName(fruit.getName());
//                    return session.flush()
//                            .onItem().transform(ignore -> entity);
//                })
//                // else
//                .onItem().ifNull().fail();
        return null;
    }

    @Route(methods = DELETE, path = "/:id")
    public Uni<Contact> delete(@Param String id, HttpServerResponse response) {
//        return session.find(Fruit.class, Integer.valueOf(id))
//                // If entity exists then delete
//                .onItem().ifNotNull().transformToUni(entity -> session.remove(entity)
//                        .chain(session::flush)
//                        .map(ignore -> {
//                            response.setStatusCode(204).end();
//                            return entity;
//                        }))
//                // else
//                .onItem().ifNull().fail();
        return null;
    }

    @Route(path = "/*", type = FAILURE)
    public void error(RoutingContext context) {
        Throwable t = context.failure();
        if (t != null) {
            LOGGER.error("Failed to handle request", t);
            int status = context.statusCode();
            String chunk = "";
            if (t instanceof NoSuchElementException) {
                status = 404;
            } else if (t instanceof IllegalArgumentException) {
                status = 422;
                chunk = new JsonObject().put("code", status)
                        .put("exceptionType", t.getClass().getName()).put("error", t.getMessage()).encode();
            }
            context.response().setStatusCode(status).end(chunk);
        } else {
            // Continue with the default error handler
            context.next();
        }
    }

}
