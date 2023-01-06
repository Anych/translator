package learn.words.controllers.translator;

import com.google.gson.Gson;
import learn.words.models.json.TranslateResponse;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TranslateText {
    private final String wordToTranslate;

    public TranslateText(String wordToTranslate) {
        this.wordToTranslate = wordToTranslate;
    }

    public String doTranslate() {
        String responseBody = request();
        System.out.println(responseBody);
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
        Properties prop = getAPIProperties();

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

    private Properties getAPIProperties() {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/api_config.properties")) {
            prop.load(input);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

    private String getTranslatedWord(String responseBody) {
        if (responseBody.contains("ошибка")) {
            return responseBody;
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

    private String getWordsFromObject(TranslateResponse word) {

        return ":";
    }

    private List<String> addWordsTo
}
