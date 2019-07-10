package no.content;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;
import io.reactivex.Maybe;

import java.util.concurrent.CompletableFuture;

@Controller("/test")
public class MyController {
    @Post("/future")
    @Status(HttpStatus.NO_CONTENT)
    public CompletableFuture<Void> future() {
        return CompletableFuture.completedFuture(null);
    }

    @Post("/reactive")
    @Status(HttpStatus.NO_CONTENT)
    public Maybe<Void> maybe() {
        return Maybe.empty();
    }
}
