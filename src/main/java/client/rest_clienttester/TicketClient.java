/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.rest_clienttester;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author AMore
 */
public class TicketClient {
    
    public static void main(String[] args) {
        ticket("andre", "word");

    }

    /* GET */
    public static void ticket(String username, String password) {
        try {

            Client client = Client.create();

            WebResource webResource = client.resource("http://localhost:8080/REST_Ticket/webresources/ticket/get/" + username + "/" + password );

            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("INPUT: " + "ticket/get/" + username + "/" + password );
            System.out.println("GetTicket (GET): " + output + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
