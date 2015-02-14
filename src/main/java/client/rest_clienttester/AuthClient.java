package client.rest_clienttester;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author AMore
 */
public class AuthClient {

    public static void main(String[] args) {
        authorizeUser("andre", "word");
        
        createUser("user3","pass3");
        
        updateUser("user3","pass4");
        updateUser("DONTEXIST","pass4");
        
        deleteUser("user3");
        deleteUser("DONTEXIST");
    }

    /* GET */
    public static void authorizeUser(String username, String password) {
        try {

            Client client = Client.create();

            WebResource webResource = client.resource("http://localhost:8080/REST_Authorization/webresources/auth/login/" + username + "/" + password);

            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            
            String output = response.getEntity(String.class);

            System.out.println("INPUT: " + "login/" + username + "/" + password);
            System.out.println("Login (GET): " + output + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* POST */
    public static void createUser(String username, String password) {
        try {

            Client client = Client.create();

            WebResource webResource = client.resource("http://localhost:8080/REST_Authorization/webresources/auth/createuser");

            String jsonInput = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";

            System.out.println("INPUT: " + jsonInput);

            ClientResponse response = webResource.accept("application/json").type("application/json").post(ClientResponse.class, jsonInput);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("CreateUser (POST): " + output + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    /* PUT */
    public static void updateUser(String username, String password) {
        try {

            Client client = Client.create();

            WebResource webResource = client.resource("http://localhost:8080/REST_Authorization/webresources/auth/updateuser");

            String jsonInput = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";

            System.out.println("INPUT: " + jsonInput);

            ClientResponse response = webResource.accept("application/json").type("application/json").put(ClientResponse.class, jsonInput);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("UpdateUser (PUT): " + output + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    /* DELETE */
    public static void deleteUser(String username) {
        try {

            Client client = Client.create();

            WebResource webResource = client.resource("http://localhost:8080/REST_Authorization/webresources/auth/deleteuser/" + username);


            System.out.println("INPUT: " + "deleteuser/" + username);

            ClientResponse response = webResource.accept("application/json").type("application/json").delete(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }

            String output = response.getEntity(String.class);

            System.out.println("DeleteUser (DELETE): " + output + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

}
