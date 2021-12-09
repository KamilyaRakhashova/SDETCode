package program;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Scanner;

import static io.restassured.RestAssured.given;

public class FindingCapitalCity {

    public static String getCapitalByName(String name){
        Response response = given().baseUri("https://restcountries.com/v3.1")
                .and().accept(ContentType.JSON)
                .when().get("/name/"+name);
        String capital;
        if(response.statusCode()==200) capital=response.jsonPath().getString("capital[0]");
        else capital="";
        return capital;
    }

    public static String getCapitalByCode(String code){
        Response response = given().baseUri("https://restcountries.com/v3.1")
                .and().accept(ContentType.JSON)
                .when().get("/alpha/"+code);
        String capital;
        if(response.statusCode()==200) capital=response.jsonPath().getString("capital[0]");
        else capital="";
        return capital;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Would you like to search by name or code?");
        String searchOption=input.next();

        OUTTER: do {
            if (searchOption.equalsIgnoreCase("name")) {
                do {
                    System.out.println("Enter name:");
                    String countryName = input.next();
                    String capital=getCapitalByName(countryName);
                    if(!capital.isEmpty()) {
                        System.out.println(capital);
                        break;
                    } else System.out.println("Invalid Name. Try Again.");
                }while(true);
            } else if (searchOption.equalsIgnoreCase("code")) {
                do{
                  System.out.println("Enter code:");
                  String code=input.next();
                  String capital=getCapitalByCode(code);
                      if(!capital.isEmpty()) {
                    System.out.println(capital);
                    break;
                } else System.out.println("Invalid Name. Try Again.");
            }while(true);
            } else {
                System.out.println("Invalid Entry. Try again.");
                continue;
            }
            do {
                System.out.println("To continue press 1\nTo exit press 2");
                byte continueOrExit = input.nextByte();
                if (continueOrExit == 2) break OUTTER;
                else if (continueOrExit == 1) continue OUTTER;
                else System.out.println("Invalid Entry. Try again.");
            } while (true);
        }while (true);

        System.out.println("Thank you for using our application.");

    }

}
