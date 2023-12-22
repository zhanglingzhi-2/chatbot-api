package com.zhang.chatbot.api.test.Api;

import okhttp3.internal.http2.Http2Stream;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.json.JsonOutput;


public class test {
    @Test
    public void query_unanswerd_questions() throws Exception{
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");

        get.addHeader("cookie","zsxq_access_token=673B918E-1F26-B1B4-33D3-5BC196311C39_4A509740E087860B; abtest_env=product; zsxqsessionid=ce37065eeb606f4310666619d892e7b3; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22812828112482852%22%2C%22first_id%22%3A%2218c913a4b0515-073b22e7e8f6a8c-26001951-2073600-18c913a4b06964%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjOTEzYTRiMDUxNS0wNzNiMjJlN2U4ZjZhOGMtMjYwMDE5NTEtMjA3MzYwMC0xOGM5MTNhNGIwNjk2NCIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjgxMjgyODExMjQ4Mjg1MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22812828112482852%22%7D%2C%22%24device_id%22%3A%2218c913a4b0515-073b22e7e8f6a8c-26001951-2073600-18c913a4b06964%22%7D");
        get.addHeader("Content-type","application/json, text/plain, */*");
        CloseableHttpResponse response = httpClient.execute(get);

        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
    @Test
    public void answer() throws Exception{
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/811481845155412/comments");
        post.addHeader("cookie","zsxq_access_token=673B918E-1F26-B1B4-33D3-5BC196311C39_4A509740E087860B; abtest_env=product; zsxqsessionid=ce37065eeb606f4310666619d892e7b3; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22812828112482852%22%2C%22first_id%22%3A%2218c913a4b0515-073b22e7e8f6a8c-26001951-2073600-18c913a4b06964%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjOTEzYTRiMDUxNS0wNzNiMjJlN2U4ZjZhOGMtMjYwMDE5NTEtMjA3MzYwMC0xOGM5MTNhNGIwNjk2NCIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjgxMjgyODExMjQ4Mjg1MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22812828112482852%22%7D%2C%22%24device_id%22%3A%2218c913a4b0515-073b22e7e8f6a8c-26001951-2073600-18c913a4b06964%22%7D");
        post.addHeader("Content-type","application/json, text/plain, */*");

        String paraJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"我没懂\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paraJson, ContentType.create("text/json","UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

}
