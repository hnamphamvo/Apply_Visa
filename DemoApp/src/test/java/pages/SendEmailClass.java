package pages;

import static io.restassured.RestAssured.given;

public class SendEmailClass {

    public static void main(String args[]) {
        getResponseBody();
        getResponseStatus();
    }

    public static void getResponseBody() {
        given().queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
                .body();
    }

    public static void getResponseStatus() {
        int statusCode = given().queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1").when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
        System.out.println("The response status is " + statusCode);
    }

    public void sendEmail(String email) {
        int statusCode = given().queryParam("email", email)
                .when().get("https://bongdaphui.wiki/api/sendmail").getStatusCode();
        System.out.println("The response status is " + statusCode);
    }
}
