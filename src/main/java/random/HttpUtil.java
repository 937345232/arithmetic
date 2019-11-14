//package random;
//
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class HttpUtil {
//
//    public static void main(String[] args) {
//
//
//    }
//
//
//
//    public static String doGet(String orderId) throws Exception {
//        String url = "http://act.ule.com/promoeng/sendFullTeamMsg.do?escOrderid=" + orderId;
//        HttpURLConnection conn = getConnect(url, "GET", null, 3000, 10000);
//        return readResponse(conn, null, "utf-8");
//    }
//
//    public static String doPost( String url,String orderId) throws Exception {
//        HttpURLConnection connection = null;
//        InputStream is = null;
//        OutputStream os = null;
//        BufferedReader br = null;
//        String result = null;
//        try {
//            String uri = String.format("http://opt.uletm.com/logsearch/search/search?series=ule-business&from=0&size=50&offset=0&height=1001&identityView=resultView&logid=1532448131417&queryString=%s&startTime=1539533551000&endTime=1539617251000&label=Custom+Range", orderId);
//
//            URL url = new URL(uri);
//            // 通过远程url连接对象打开连接
//            connection = (HttpURLConnection) url.openConnection();
//            // 设置连接请求方式
//            connection.setRequestMethod("POST");
//            // 设置连接主机服务器超时时间：15000毫秒
//            connection.setConnectTimeout(15000);
//            // 设置读取主机服务器返回数据超时时间：60000毫秒
//            connection.setReadTimeout(60000);
//            connection.setRequestProperty("Cookie", "JSESSIONID=EE1B57011E06FAEBF0D2653193C280CA; _ga=GA1.2.1628269172.1538036266; _gid=GA1.2.179407588.1539586569");
//
//            // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
//            connection.setDoOutput(true);
//            // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
//            connection.setDoInput(true);
//            // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
//            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//            // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
////            connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
//            // 通过连接对象获取一个输出流
//            os = connection.getOutputStream();
//            // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
////            String str = String.format(String.format("{\"series\":\"ule-business\",\"from\": 0 \"size\": 50, \"offset\":0,\"height\":1001,\"identityView\":\"resultView\",\"logid\":1532448131417,\"queryString\":%s,\"startTime\":1539533551000,\"endTime\":1539617251000,\"label\":\"Custom Range\"}", orderId));
////            os.write(str.getBytes());
//            // 通过连接对象获取一个输入流，向远程读取
//            if (connection.getResponseCode() == 200) {
//                System.out.println(orderId);
//                is = connection.getInputStream();
//                // 对输入流对象进行包装:charset根据工作项目组的要求来设置
//                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//
//                StringBuffer sbf = new StringBuffer();
//                String temp = null;
//                // 循环遍历一行一行读取数据
//                while ((temp = br.readLine()) != null) {
//                    sbf.append(temp);
//                    sbf.append("\r\n");
//                }
//                result = sbf.toString();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // 关闭资源
//            if (null != br) {
//                br.close();
//            }
//            if (null != os) {
//                os.close();
//            }
//            if (null != is) {
//                is.close();
//            }
//            // 断开与远程地址url的连接
//            connection.disconnect();
//        }
//        return result;
//    }
//
//    public static String doPost(String url, String body) throws Exception {
//        HttpURLConnection conn = null;
//        String[][] headers = {{"Content-Type", "application/json;charset=utf-8"}, {"client_appkey", "mobile_mgroup"}, {"client_secret", "EBB071B9A40E2658B7B315A2D95F2A97"}};
//        try {
//            conn = getConnect(url, "POST", headers, 3000, 10000);
//            return readResponse(conn, body, "utf-8");
//        } finally {
//            if (conn != null) {
//                conn.disconnect();
//            }
//        }
//    }
//
//    private static HttpURLConnection getConnect(String url, String method, String[][] headers, int connectTimeout, int readTimeout) throws Exception {
//        URL uri = new URL(url);
//        HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
//        conn.setRequestMethod(method);
//        conn.setConnectTimeout(connectTimeout * 1000);
//        conn.setReadTimeout(readTimeout * 1000);
//        conn.setDoOutput(true);
//        conn.setDoInput(true);
//        conn.setUseCaches(false);
//
//        if (headers != null) {
//            for (String[] header : headers) {
//                conn.setRequestProperty(header[0], header[1]);
//            }
//        }
//
//        return conn;
//    }
//
//    private static String readResponse(HttpURLConnection conn, String body, String charset) throws Exception {
//        OutputStream os = null;
//        OutputStreamWriter osw = null;
//        PrintWriter pw = null;
//        InputStream is = null;
//        InputStreamReader isr = null;
//        BufferedReader br = null;
//        try {
//            if (body != null) {
//                os = conn.getOutputStream();
//                osw = new OutputStreamWriter(os, charset);
//                pw = new PrintWriter(osw);
//                pw.print(body);
//                pw.flush();
//            }
//
//            conn.connect();
//            if (HttpURLConnection.HTTP_OK != conn.getResponseCode()) {
//                System.out.println("HttpRequest fail! ResponseCode: " + conn.getResponseCode() + ", Url: {}" + conn.getURL());
//                return null;
//            }
//
//            is = conn.getInputStream();
//            isr = new InputStreamReader(is, charset);
//            br = new BufferedReader(isr);
//            StringBuilder response = new StringBuilder();
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                response.append(line);
//            }
//            return response.toString();
//        } finally {
//            if (pw != null) {
//                pw.close();
//            }
//            if (osw != null) {
//                osw.close();
//            }
//            if (os != null) {
//                os.close();
//            }
//            if (br != null) {
//                br.close();
//            }
//            if (isr != null) {
//                isr.close();
//            }
//            if (is != null) {
//                is.close();
//            }
//        }
//    }
//}
