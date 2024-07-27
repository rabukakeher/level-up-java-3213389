package com.linkedin.javacodechallenges;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException, InterruptedException{
        HttpRequest httpRequest = HttpRequest.newBuilder()
                        .uri(URI.create("https://icanhazdadjoke.com/"))
                        .header("Content-Type", "application/html").build();
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, BodyHandlers.ofString());

        String resposeBody = httpResponse.body();

        Pattern p = Pattern.compile("<meta property=\"og:description\" content=\"(.*)\" \\/>");

        Matcher m = p.matcher(resposeBody);

        if(m.find()) {
           System.out.println(m.group(1));
        }
        

        // TODO: Call https://icanhazdadjoke.com/ API and display joke
    }


}
