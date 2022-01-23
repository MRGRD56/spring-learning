package com.mrgrd56.springlearning.rest.services;

import lombok.val;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

@Service
public class LogoService {
    private static final URI LOGO_URL =
            URI.create("https://www.synergy-park.com/wp-content/uploads/2019/05/kenhlaptrinh-java-spring-logo_NjAxb8l_Po2JxRG.png");

    private byte[] fetchedLogo;

    private CompletableFuture<byte[]> fetchLogo() {
        val completableFuture = new CompletableFuture<byte[]>();

        val httpClient = HttpClient.newHttpClient();

        val request = HttpRequest.newBuilder()
                .GET()
                .uri(LOGO_URL)
                .build();

        val responseFuture = httpClient.sendAsync(
                request, HttpResponse.BodyHandlers.ofByteArray());

        responseFuture.thenAccept(response -> {
            val body = (byte[]) response.body();
            System.out.println(body.getClass());
            completableFuture.complete(body);
        });

        return completableFuture;
    }

    @Async
    public CompletableFuture<byte[]> getLogo() {
        if (fetchedLogo != null) {
            return CompletableFuture.completedFuture(fetchedLogo);
        }

        return fetchLogo().thenApply(bytes -> {
            fetchedLogo = bytes;
            return bytes;
        });
    }
}
