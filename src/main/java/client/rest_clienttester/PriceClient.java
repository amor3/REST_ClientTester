package client.rest_clienttester;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PriceClient {

    public static void main (String... args){
        
        getPrice("andre","word","2");
    }
    
 
    public static void getPrice(String username, String password, String ticketid) {
        try {

            Client client = Client.create();

            WebResource webResource = client.resource("http://localhost:8080/REST_Price/webresources/price/getprice/" + username + "/" + password + "/" + ticketid);

            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("INPUT: " + "login/" + username + "/" + password);
            System.out.println("GetPrice (GET): " + output + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
/* Har inte byggt resten i clienten men du kan anvanda alla funktioner i rest servicen om du vill */

    
}
