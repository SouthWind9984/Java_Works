package com.example.wyymusic_v2.util;

/**
 * @author SouthWind
 * @date 2022/11/11 11:15
 * @WX公众号：ONE课堂
 * @GitHub: github.com/SouthWind9984
 * 编程千万条，规范第一条
 */

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Random;

/**
 * http请求封装工具类
 */
public class HttpUtil {

    //常用Http请求头
    private static final String[] userAgent = {
            "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36 QBCore/4.0.1316.400 QQBrowser/9.0.2524.400 Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2875.116 Safari/537.36 NetType/WIFI MicroMessenger/7.0.20.1781(0x6700143B) WindowsWechat",
            "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
            "Mozilla/5.0 (compatible; Konqueror/3.5; Linux) KHTML/3.5.5 (like Gecko) (Kubuntu)",
            "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.8.0.12) Gecko/20070731 Ubuntu/dapper-security Firefox/1.5.0.12",
            "Lynx/2.8.5rel.1 libwww-FM/2.14 SSL-MM/1.4.1 GNUTLS/1.2.9",
            "Mozilla/5.0 (X11; Linux i686) AppleWebKit/535.7 (KHTML, like Gecko) Ubuntu/11.04 Chromium/16.0.912.77 Chrome/16.0.912.77 Safari/535.7",
            "Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:10.0) Gecko/20100101 Firefox/10.0 ",
            "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36 QBCore/4.0.1316.400 QQBrowser/9.0.2524.400 Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2875.116 Safari/537.36 NetType/WIFI MicroMessenger/7.0.20.1781(0x6700143B) WindowsWechat",
            "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.153 Safari/537.36",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36 Edg/87.0.664.75"
    };
    // HttpClient 配置信息
    private static final RequestConfig requestConfig = RequestConfig.custom()
            // 设置连接超时时间(单位毫秒)
            .setConnectTimeout(5000)
            // 设置请求超时时间(单位毫秒)
            .setConnectionRequestTimeout(5000)
            // socket读写超时时间(单位毫秒)
            .setSocketTimeout(5000)
            // 设置是否允许重定向(默认为true)
            .setRedirectsEnabled(true).build();


    public static JSONObject commonPost(String url,String params){
        String ContentType = "application/x-www-form-urlencoded;charset=UTF-8";
        String encoding = "UTF-8";
        JSONObject jsonObject = null;
        try {
            jsonObject = postGeneralRequest(url, params, ContentType, encoding);
        } catch (Exception e) {
            System.err.println("post请求错误！");
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 原生JDK，httpURLConnection GET请求
     *
     * @param generalUrl url
     * @param encoding   编码
     * @return
     * @throws Exception
     */
    public static String getGeneralRequest(String generalUrl, String encoding) throws Exception {
        URL url = new URL(generalUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        /*
            通用GET请求配置
         */
        connection.setRequestProperty("Connection", "keep-alive");
        connection.setRequestProperty("Accept", "application/json, text/plain, */*");
        connection.setRequestProperty("User-Agent", userAgent[new Random().nextInt(userAgent.length)]);
        connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), encoding));
        String str;
        while ((str = br.readLine()) != null) {
            stringBuilder.append(str);
        }
        br.close();
        return stringBuilder.toString();
    }

    /**
     * JDK自带的 httpURLConnection 发送post请求
     *
     * @param generalUrl  请求链接
     * @param params      请求参数
     * @param ContentType 连接类型
     * @param encoding    编码
     * @return JSON
     */
    public static JSONObject postGeneralRequest(String generalUrl, String params, String ContentType, String encoding) throws Exception {
        JSONObject jsonObject = new JSONObject();
        URL httpUrl = new URL(generalUrl);
        HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
        connection.setRequestMethod("POST");
        /*
            设置Post通用请求
         */
        connection.setRequestProperty("Host", httpUrl.getHost());
        connection.setRequestProperty("Connection", "keep-alive");
        connection.setRequestProperty("Accept", "*/*");
        connection.setRequestProperty("User-Agent", userAgent[new Random().nextInt(userAgent.length)]);
        connection.setRequestProperty("Content-Type", ContentType);
        connection.setRequestProperty("Accept-Language", "zh-CN,zh");
        //允许写出
        connection.setDoOutput(true);
        connection.setDoInput(true);//允许写入默认为true
        DataOutputStream wr;
        BufferedReader br = null;
        StringBuilder result = new StringBuilder();
        wr = new DataOutputStream(connection.getOutputStream());
        wr.write(params.getBytes(encoding));
        //读取响应
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));
            String temp;
            while ((temp = br.readLine()) != null) {
                result.append(temp);
            }
            jsonObject.put("data", result.toString());
        } else {
            jsonObject.put("code", responseCode);
        }
//            关闭连接
        wr.flush();
        wr.close();
        if (br != null) {
            br.close();
        }
        return jsonObject;
    }

    /**
     * 调用 HttpClient 发送Get请求
     * @param url
     * @return
     * @throws Exception
     */
    public static String httpClientGetRequest(String url) throws Exception {
        String result = null;
        //构建一个客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("User-Agent", userAgent[new Random().nextInt(userAgent.length)]);
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setConfig(requestConfig);
        //返回响应内容
        CloseableHttpResponse response = httpClient.execute(httpGet);
        //响应状态
        StatusLine statusLine = response.getStatusLine();
        //放回响应码
        int statusCode = statusLine.getStatusCode();
        //响应实体内容
        HttpEntity responseEntity = response.getEntity();
        if (statusCode == 200) {
            result = EntityUtils.toString(responseEntity);
        }
//        关闭资源
        response.close();
        httpClient.close();
        return result;
    }

    /**
     * HttpClient 发送Post 请求
     * @param url 请求链接
     * @param entity 请求内容实体
     * @return
     * @throws Exception
     */
    public static String httpClientPostRequest(String url, StringEntity entity, String ContentType) throws Exception {
        String result  = null ;
//        创建一个http客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        URI uri = URI.create(url);
//        创建post请求
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setConfig(requestConfig);
        httpPost.setHeader("Accept", "application/json, text/plain, */*");
        httpPost.setHeader("User-Agent", userAgent[new Random().nextInt(userAgent.length)]);
        httpPost.setHeader("Content-Type", ContentType);
        httpPost.setHeader("Connection", "keep-alive");
        httpPost.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6");
        httpPost.setHeader("Host", uri.getHost());
        httpPost.setEntity(entity);
//            发送post请求
        CloseableHttpResponse response = httpClient.execute(httpPost);
        //响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        //获取响应实体
        HttpEntity httpEntity = response.getEntity();
        if (statusCode == 200)
            result = EntityUtils.toString(httpEntity);
//        关闭资源
        response.close();
        httpClient.close();
        return result;
    }


}
