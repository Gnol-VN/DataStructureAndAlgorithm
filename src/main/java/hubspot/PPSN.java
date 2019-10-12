package hubspot;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class PPSN {
    public static void main(String[] args) {
        HttpResponse<String> httpResponse = Unirest.post("https://www.mywelfare.ie/api/appointmentbooking/getappointments")
                .field("OfficeCode", "601")
                .field("Type", "Ppsn")
                .field("TypeFor", "Myself")
                .field("UserId", "id-0")
                .field("start", "2019-10-14")
                .field("end", "2019-10-15")
                .header("Origin", "https://www.mywelfare.ie")
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36")
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("Accept", "application/json, text/javascript, */*; q=0.01")
                .header("X-Requested-With", "XMLHttpRequest")
                .header("Sec-Fetch-Mode", "cors")
                .asString();

        System.out.println("Long");
    }
}
