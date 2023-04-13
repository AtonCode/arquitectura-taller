package org.eclipse.jakarta.hello.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.jakarta.hello.model.Product;
import org.eclipse.jakarta.hello.repository.ProductRepositoy;
@Path("product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    private ProductRepositoy productRepositoy;

    // Create a new product using POST
    @POST
    @Path("create")
    public Response createProduct(Product product) {
        // Create the product
        productRepositoy.create(product);
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(productRepositoy.create(product)).build();
    }


    // Get all products
    @GET
    @Path("all")
    public Response getAllProducts() {

        // Search for all products and return them
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(productRepositoy.listAll()
                        .stream()
                        .toArray(Product[]::new)).build();

    }

    // Get a product by id
    @GET
    @Path("{id}")
    public Response getProductById(@PathParam("id") Long id) {
        // Search for the product and return it
        return  Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(productRepositoy.read(id)).build();
    }

    // Update a product
    @PUT
    @Path("update")
    public Response updateProduct(Product product) {
        // Update the product
        return  Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(productRepositoy.update(product)).build();
    }

    // Delete a product
    @DELETE
    @Path("delete/{id}")
    public Response deleteProduct(@PathParam("id") Long id) {
        // Delete the product
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(productRepositoy.delete(id)).build();
    }





}