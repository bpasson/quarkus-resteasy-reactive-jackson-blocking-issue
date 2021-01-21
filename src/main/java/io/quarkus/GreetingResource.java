package io.quarkus;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.reactive.RestSseElementType;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/")
public class GreetingResource {

    @Blocking
    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @RestSseElementType(MediaType.APPLICATION_JSON)
    public Multi<Greeting> hello() {
        AtomicInteger count = new AtomicInteger();
        return Multi.createBy()
                .repeating()
                .uni(() -> Uni.createFrom()
                        .item(Greeting.withMessage("["+count.getAndIncrement()+"] Hello Quarkus!")))
                .atMost(100);
    }
}