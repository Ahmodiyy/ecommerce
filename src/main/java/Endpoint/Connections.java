/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Endpoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


/**
 *
 * @author Ahmod
 */
public class Connections {
    
    public Product getProduct(String productId) throws IOException{
        Object json = JSONValue.parse(getJson("http://localhost:8080/api/product/" + productId));
        JSONObject productData  = (JSONObject)json;
        Product product = new Product();
        System.out.println("product " + productData.toJSONString());
        product.setId((Long)productData.get("id"));
        product.setName((String)productData.get("name"));
        product.setDescription((String)productData.get("description"));
        product.setPrice((Long)productData.get("price"));
        product.setImage((String)productData.get("image"));
        return product;
    }
    private String getJson(String endPointUrl) throws MalformedURLException, IOException{
        String recieve;
       String buffer = "";
       URL jsonpage = new URL(endPointUrl);
       URLConnection urlcon = jsonpage.openConnection();
        try (BufferedReader buffread = new BufferedReader(new InputStreamReader(urlcon.getInputStream()))) {
            while ((recieve = buffread.readLine()) != null)
                buffer += recieve;
            
        }
        return buffer;
    }
    public List<Product> getProducts() throws IOException{
       List<Product> productList = new ArrayList();
        Object o1 = JSONValue.parse(getJson("http://localhost:8080/api/products"));
            JSONArray jsonObj = (JSONArray) o1;
            jsonObj.stream().forEach((action)-> {
                JSONObject productData  = (JSONObject)action;
                Product product = new Product();
                product.setId((Long)productData.get("id"));
                product.setName((String)productData.get("name"));
                product.setDescription((String)productData.get("description"));
                product.setPrice((Long)productData.get("price"));
                product.setImage((String)productData.get("image"));
                productList.add(product);
            });
            return productList;
    }
    
    public static void main(String[] args) {
        Connections connections = new Connections();
        try {
            connections.getProduct("5");
        } catch (IOException ex) {
            Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
