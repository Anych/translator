package learn.words.controllers;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

import java.io.IOException;

public class TranslateWord {
    public static void main(String[] args) throws IOException {
        AsyncHttpClient client = new DefaultAsyncHttpClient();
        client.prepare("POST", "https://microsoft-translator-text.p.rapidapi.com/translate?to%5B0%5D=ru&api-version=3.0&from=en&profanityAction=NoAction&textType=plain")
                .setHeader("content-type", "application/json")
                .setHeader("X-RapidAPI-Key", "d7231781d5msh98b9f24fe1afceep16c0e2jsnca25859a500b")
                .setHeader("X-RapidAPI-Host", "microsoft-translator-text.p.rapidapi.com")
                .setBody("[{\"Text\": \"I\"}]")
                .execute()
                .toCompletableFuture()
                .thenAccept(System.out::println)
                .join();


        client.close();

    }
}
