package com.zsj.core.util;

import okhttp3.*;

import java.io.IOException;

public class httpUtil {


    public static void main(String arg[]){

        try {
            String json = "{\n    \"ReqRSFHeader\": {\n        \"SourceSysTpCd\": \"05\"\n    },\n    \"ClientName\": \"郑*伟\",\n    \"IdTpCd\": \"01\",\n    \"IdNum\": \"123456******260014\",\n    \"GenderTpCd\": \"1\",\n    \"BirthDt\": \"1960-08-26\",\n    \"AddressList\": [\n        {\n            \"Address\": \"******\",\n            \"AddrUsageTpCd\": \"01\"\n        }\n    ],\n    \"CmthList\": [\n        {\n            \"CmthTpCd\": \"12\",\n            \"CmthNum\": \"12345678901\"\n        }\n    ]\n}";
            String url = "http://10.18.58.36:10006/addPerson.do";

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
            RequestBody body = RequestBody.create(mediaType, json);
            Request request = new Request.Builder()
                    .url(url)
                    .method("POST", body)
//                    .addHeader("Cookie", "JSESSIONID=59CD6B0F84CF4C2F0ADC2D4141D57E97")
//                    .addHeader("Postman-Token", null)
                    .addHeader("Content-Type", "application/json")
//                    .addHeader("Content-Length", null)
//                    .addHeader("Host", null)
//                    .addHeader("User-Agent", "PostmanRuntime/7.28.3")
                    .addHeader("Accept", "*/*")
//                    .addHeader("Accept-Encoding", "gzip, deflate, br")
//                    .addHeader("Connection", "keep-alive")
                    .build();
            Response response = client.newCall(request).execute();
            String result = response.body().string();
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
