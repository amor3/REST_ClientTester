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
public class AvailClient {

    public static void main(String[] args) {
        searchPath("andre", "word", "stockholm", "berlin");
        searchPath("andre", "word", "oslo", "stockholm");
        searchPath("andre", "word", "oslo", "iran");

    }

    /* GET */
    public static void searchPath(String username, String password, String from, String to) {
        try {

            Client client = Client.create();

            WebResource webResource = client.resource("http://localhost:8080/REST_Availability/webresources/availability/searchpath/" + username + "/" + password + "/" + from + "/" + to);

            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("INPUT: " + "searchpath/" + username + "/" + password + "/" + from + "/" + to);
            System.out.println("SearchPath (GET): " + output + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
