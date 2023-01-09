package learn.words.controller.translator;

import com.google.gson.Gson;
import learn.words.controller.PropertiesFile;
import learn.words.model.json.TranslateResponse;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TranslateWord {
    private final String wordToTranslate;

    public TranslateWord(String wordToTranslate) {
        this.wordToTranslate = wordToTranslate;
    }

    public List<String> doTranslate() {
        String responseBody = request();

        return getTranslatedWord(responseBody);
    }

    private String request() {
        try (AsyncHttpClient client = new DefaultAsyncHttpClient()) {
            return getResponseBody(client);
        } catch (IOException | ExecutionException | InterruptedException e) {
            return "Ошибка, проверьть интернет";
        } catch (TimeoutException e) {
            return "Ошибка, сайт не отвечает";
        }
    }

    private String getResponseBody(AsyncHttpClient client) throws ExecutionException,
            InterruptedException, TimeoutException {
        Properties prop = PropertiesFile.getProperties("src/main/resources/api_config.properties");

        if (!prop.isEmpty()) {
            return client.prepare("POST", prop.getProperty("URL"))
                    .setHeader("content-type", prop.getProperty("CONTENT_TYPE"))
                    .setHeader("X-RapidAPI-Key", prop.getProperty("KEY"))
                    .setHeader("X-RapidAPI-Host", prop.getProperty("HOST"))
                    .setBody("[{\"Text\": \"" + wordToTranslate + "\"}]")
                    .execute().get(5, TimeUnit.SECONDS).getResponseBody();
        } else {
            return "Ошибка с файлом конфигурации";
        }
    }

    private List<String> getTranslatedWord(String responseBody) {
        if (responseBody.contains("ошибка")) {
            return Collections.singletonList(responseBody);
        } else {
            TranslateResponse translateResponse = makeJSONFromString(responseBody);
            return getWordsFromObject(translateResponse);
        }
    }

    private TranslateResponse makeJSONFromString(String responseBody) {
        Gson g = new Gson();
        String removedBracketsResponse = responseBody.substring(1, responseBody.length() - 1);

        return g.fromJson(removedBracketsResponse, TranslateResponse.class);
    }

    private List<String> getWordsFromObject(TranslateResponse word) {
        return addWordsToList(word);
    }

    private List<String> addWordsToList(TranslateResponse word) {
        List<String> translatedWords = new ArrayList<>();
        for (int i = 0; i < word.translations.size(); i++) {
            translatedWords.add(word.translations.get(i).normalizedTarget);
        }

        return translatedWords;
    }
}
