/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Pawel Pytel
 */
public class Main {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        String count
                = client.target("http://localhost:8080/Complaints/"
                        + "resources/complaints/count")
                        .request(MediaType.TEXT_PLAIN)
                        .get(String.class);
                        
        System.out.println("Count: " + count);
        
        List<Complaint> all = client.target("http://localhost:8080/Complaints/"
                        + "resources/complaints")
                        .request(MediaType.APPLICATION_JSON)
                        .get(Response.class)
                        .readEntity(new GenericType<List<Complaint>>(){});
        
        System.out.println("ALL COMPLAINTS:");
        for(Complaint item : all){
            System.out.println(item.toString());
        }
        
        Complaint complaint=client.target("http://localhost:8080/Complaints/"
                        + "resources/complaints/1")
                        .request(MediaType.APPLICATION_JSON)
                        .get(Complaint.class);
        
        System.out.println("SPECIFIC COMPLAINT:");
        System.out.println(complaint.toString());
        
        complaint.setStatus("closed");
        
        client.target("http://localhost:8080/Complaints/resources/complaints/"
                + complaint.getId().toString())
                .request()
                .put(Entity.entity(complaint, MediaType.APPLICATION_JSON));
        
        List<Complaint> openedComplaints = client.target("http://localhost:8080/Complaints/"
                + "resources/complaints?status=open")
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(new GenericType<List<Complaint>>(){});
        
        System.out.println("ALL OPENED COMPLAINTS:");
        for(Complaint item : openedComplaints){
            System.out.println(item.toString());
        }
        
        client.close();
    }
}
