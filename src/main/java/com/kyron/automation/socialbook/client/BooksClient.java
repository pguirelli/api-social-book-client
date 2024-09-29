package com.kyron.automation.socialbook.client;

import java.net.URI;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.kyron.automation.socialbook.client.model.Book;

public class BooksClient {

    private RestTemplate restTemplate;
    private String URI_BASE;
    private String URN_BASE = "/books";
    private String credential;

    public BooksClient(String url, String user, String password) {
        restTemplate = new RestTemplate();

        URI_BASE = url.concat(URN_BASE);

        String authorizationData = user + ":" + password;

        credential = "Basic " + Base64.getEncoder().encodeToString(authorizationData.getBytes());
    }

    public List<Book> list() {
        RequestEntity<Void> request = RequestEntity.get(URI.create(URI_BASE))
                .header("Authorization", "Basic dXN1YXJpbzoxMjM0NTY=").build();

        ResponseEntity<Book[]> response = restTemplate.exchange(request, Book[].class);

        return Arrays.asList(response.getBody());
    }

    public String save(Book book) {
        RequestEntity<Book> request = RequestEntity.post(URI.create(URI_BASE))
                .header("Authorization", credential)
                .body(book);

        ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);

        return response.getHeaders().getLocation().toString();
    }

    public Book getBook(String uri) {
        RequestEntity<Void> request = RequestEntity.get(uri)
                .header("Authorization", credential)
                .build();

        ResponseEntity<Book> response = restTemplate.exchange(request, Book.class);

        return response.getBody();
    }

}
