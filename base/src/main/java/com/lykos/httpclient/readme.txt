apache httpclient[HttpComponents]

-------------------------------------httpclient-----------------------------------------------

httpclient是apache下的一个子项目，主要用于客户端Http请求，但不同于浏览器不能
解析页面内容

1.方法请求
CloseableHttpClient httpclient = HttpClients.createDefault();
HttpGet httpget = new HttpGet("http://localhost/");
- CloseableHttpResponse response = httpclient.execute(httpget);
2.请求对象  Http Rquest
          httpclient 提供了一个实用的类（URIbulider）用来创建request uri
URI uri = new URIBuilder()
        .setScheme("http")
        .setHost("www.google.com")
        .setPath("/search")
        .setParameter("q", "httpclient")
        .setParameter("btnG", "Google Search")
        .setParameter("aq", "f")
        .setParameter("oq", "")
        .build();
HttpGet httpget = new HttpGet(uri);
System.out.println(httpget.getURI());

3.返回对象  Http Response   由服务器返回对象
HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,
HttpStatus.SC_OK, "OK");
System.out.println(response.getProtocolVersion());
System.out.println(response.getStatusLine().getStatusCode());
System.out.println(response.getStatusLine().getReasonPhrase());
System.out.println(response.getStatusLine().toString());

     3.a 消息头，HttpClient提供了一些方法来检索、添加、删除和列举头
HttpResponse response = new                                         BasicHttpResponse(HttpVersion.HTTP_1_1,HttpStatus.SC_OK, "OK");
response.addHeader("Set-Cookie","c1=a; path=/; domain=localhost");
response.addHeader("Set-Cookie","c2=b; path=\"/\", c3=c; domain=\"localhost\"");

//获取header集合
HeaderElementIterator it = new BasicHeaderElementIterator(
    response.headerIterator("Set-Cookie"));

while (it.hasNext()) {
    HeaderElement elem = it.nextElement();
    System.out.println(elem.getName() + " = " + elem.getValue());
    NameValuePair[] params = elem.getParameters();
    for (int i = 0; i < params.length; i++) {
        System.out.println(" " + params[i]);
    }
}

4.内容对象  HttpEntity   HTTP请求可以携带一个内容实体相关的请求或响应
     HTTP规范定义了两个实体封闭请求方法:POST和PUT。反应通常会附上一个内容的实体。
     HttpClient区分三种类型的实体
          4.a streamed self-contained wrapping
          4.b 可重复实体：意味着它的内容可以被多次读取。这就仅仅是自我包含式的实体了（像ByteArrayEntity                                                                                           或StringEntity）
          4.c  读取实体公用方法  EntityUtils
          4.d  生成实体
File file =new File("somefile.txt");
ContentType contentType = ContentType.create("text/plain","UTF-8");
FileEntity entity =new FileEntity(file, contentType);
HttpPost httpPost =new HttpPost("http://localhost/action.do");
httpPost.setEntity(entity);
4.e html forms httpclient提供UrlEncodedFormEntity来模拟表单提交
List<NameValuePair> formparams = new ArrayList<NameValuePair>();
formparams.add(new BasicNameValuePair("param1", "value1"));
formparams.add(new BasicNameValuePair("param2", "value2"));
UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
HttpPost httppost = new HttpPost("http://localhost/handler.do");
httppost.setEntity(entity);