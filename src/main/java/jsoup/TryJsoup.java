//package jsoup;
//
//import com.google.gson.Gson;
//import com.mashape.unirest.http.HttpResponse;
//import com.mashape.unirest.http.JsonNode;
//import com.mashape.unirest.http.Unirest;
//import com.mashape.unirest.http.async.Callback;
//import com.mashape.unirest.http.exceptions.UnirestException;
//import com.mashape.unirest.request.GetRequest;
//import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//import java.nio.charset.Charset;
//import java.nio.file.Files;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.Future;
//
//public class TryJsoup {
//    public static void main(String[] args) throws IOException, UnirestException {
//        String inputText = Files.readString(new File("new.html").toPath(), Charset.defaultCharset());
//        String htmlString = "<html><head><title>My title</title></head>"
//                + "<body>Body content</body></html>";
//
//        Document doc = Jsoup.parse(inputText);
//        String title = doc.title();
//        String body = doc.body().text();
//        int n = doc.select(".fsl.fwb a").size();
//        List<Friend> friendList  = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            Friend friend = new Friend();
//            friend.name = String.valueOf(doc.select(".fsl.fwb a").get(i).childNode(0));
//            String url = doc.select(".fsl.fwb a").get(i).getElementsByAttribute("href").get(0).attributes().get("href");
//            friend.url = url;
//            String checkingUrl = "https://marketingtool.top/wp-admin/admin-ajax.php?" +
//                    "action=ajax_convert_to_phone&" +
//                    "link="+url;
//            try {
////                HttpResponse<String> httpResponse = Unirest.get(checkingUrl).asString();
//                Future<HttpResponse<String>> future = Unirest.post("http://httpbin.org/post")
//                        .asStringAsync(new Callback<String>() {
//
//                            public void failed(UnirestException e) {
//                                System.out.println("The request has failed");
//                            }
//
//                            public void completed(HttpResponse<String> response) {
//                                friend.mobile = Jsoup.parse(response.getBody()).select(".item-phone b").get(0).text();
//
//                            }
//
//                            public void cancelled() {
//                                System.out.println("The request has been cancelled");
//                            }
//
//                        });
////                friend.mobile = Jsoup.parse(httpResponse.getBody()).select(".item-phone b").get(0).text();
//            }catch (Exception e){
//                System.out.println(e.getMessage());
//            }
//            friendList.add(friend);
////            request.getBody().
//        }
//        System.out.println();
//        Gson gson = new Gson();
//        String toFile = gson.toJson(friendList);
//        try (PrintWriter out = new PrintWriter("sorryfriend.txt")) {
//            out.println(toFile);
//        }
//
//    }
//}
