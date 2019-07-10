package no.content;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertSame;

@Client("/test")
interface MyClient {
    @Post("/future")
    HttpResponse future();

    @Post("/reactive")
    HttpResponse maybe();
}

@MicronautTest
public class MyTest {
    @Inject
    MyClient client;

    @Test
    @DisplayName("future handler test")
    void futureTest() {
        HttpResponse response = client.future();
        assertSame(HttpStatus.NO_CONTENT, response.getStatus());
    }

    @Test
    @DisplayName("maybe handler test")
    void maybeTest() {
        HttpResponse response = client.maybe();
        assertSame(HttpStatus.NO_CONTENT, response.getStatus());
    }
}
