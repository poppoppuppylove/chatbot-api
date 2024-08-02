package cn.bugstack.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        // 创建HttpClient
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 创建HttpGet对象
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/51111554848824/topics?scope=digests&count=20");
        https://api.zsxq.com/v2/groups/51111554848824/topics?scope=digests&count=20
        // 设置请求头
        get.addHeader("cookie", "zsxq_access_token=17701C73-613F-5466-07BD-FD1EC95BC6F0_6531F5B6A146C2AE; abtest_env=beta; zsxqsessionid=56650accd6eaa376e3c76a45a803c0c2; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22415544241842448%22%2C%22first_id%22%3A%2219113ed0eb862-0cba0c3877ad68-e5d5628-1821369-19113ed0eb917a7%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTkxMTNlZDBlYjg2Mi0wY2JhMGMzODc3YWQ2OC1lNWQ1NjI4LTE4MjEzNjktMTkxMTNlZDBlYjkxN2E3IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNDE1NTQ0MjQxODQyNDQ4In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22415544241842448%22%7D%7D; sajssdk_2015_cross_new_user=1");
        get.addHeader("Content-Type", "application/json;charset=utf8");

        // 执行请求
        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 获取响应体，将响应体转换为字符串，并将其存储在变量res中
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/1522852421185482/comments");
        post.addHeader("cookie", "zsxq_access_token=17701C73-613F-5466-07BD-FD1EC95BC6F0_6531F5B6A146C2AE; abtest_env=beta; zsxqsessionid=56650accd6eaa376e3c76a45a803c0c2; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22415544241842448%22%2C%22first_id%22%3A%2219113ed0eb862-0cba0c3877ad68-e5d5628-1821369-19113ed0eb917a7%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTkxMTNlZDBlYjg2Mi0wY2JhMGMzODc3YWQ2OC1lNWQ1NjI4LTE4MjEzNjktMTkxMTNlZDBlYjkxN2E3IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNDE1NTQ0MjQxODQyNDQ4In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22415544241842448%22%7D%7D; sajssdk_2015_cross_new_user=1");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        //将JSON格式的字符串参数转换为HTTP请求的实体，以便在HTTP请求中发送
        //确保请求的MIME类型和字符编码与服务器期望的格式相匹配，否则可能请求失败
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("application/json", "UTF-8"));
        post.setEntity(stringEntity);//设置 HTTP POST 请求的请求体，请求体通常包含要发送的数据

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }



}
