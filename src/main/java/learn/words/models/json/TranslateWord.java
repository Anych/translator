package learn.words.models.json;

import com.google.gson.Gson;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class TranslateWord {
    private final String wordToTranslate;

    public TranslateWord(String wordToTranslate) {
        this.wordToTranslate = wordToTranslate;
    }

    public String doTranslate() {
        String responseBody = request();

        return getTranslatedWord(responseBody);
    }

    private String request() {
        try (AsyncHttpClient client = new DefaultAsyncHttpClient()) {
            return getResponseBody(client);
        } catch (IOException | ExecutionException | InterruptedException e) {
            return "Произошла ошибка, проверьть интернет";
        }
    }

    private String getResponseBody(AsyncHttpClient client) throws ExecutionException, InterruptedException {
        String URL = "https://microsoft-translator-text.p.rapidapi.com/" +
                "translate?to%5B0%5D=ru&api-version=3.0&from=en&profanityAction=NoAction&textType=plain";
        String CONTENT_TYPE = "application/json";
        String KEY = "d7231781d5msh98b9f24fe1afceep16c0e2jsnca25859a500b";
        String HOST = "microsoft-translator-text.p.rapidapi.com";

        return client.prepare("POST", URL)
                .setHeader("content-type", CONTENT_TYPE)
                .setHeader("X-RapidAPI-Key", KEY)
                .setHeader("X-RapidAPI-Host", HOST)
                .setBody("[{\"Text\": \"" + wordToTranslate + "\"}]")
                .execute().get().getResponseBody();
    }

    private String getTranslatedWord(String responseBody) {
        TranslateResponse translateResponse = makeJSONFromString(responseBody);

        return getWordFromObject(translateResponse);
    }

    private TranslateResponse makeJSONFromString(String responseBody) {
        Gson g = new Gson();
        String removedBracketsResponse = responseBody.substring(1, responseBody.length() - 1);

        return g.fromJson(removedBracketsResponse, TranslateResponse.class);
    }

    private String getWordFromObject(TranslateResponse word) {
        return word.translations.get(0).text;
    }
}
