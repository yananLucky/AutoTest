package com.course.cases;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class Test {
    public static void main(String[] args) {
        CloseableHttpClient httpClient= HttpClientBuilder.create().build();
    }
}
