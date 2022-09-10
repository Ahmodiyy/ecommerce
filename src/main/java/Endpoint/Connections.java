/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Endpoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
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
    
    public long register(String email, String password) throws IOException{
       URL jsonPage = new URL("http://localhost:8080/api/register");
       HttpURLConnection urlConnection = (HttpURLConnection)jsonPage.openConnection();
       urlConnection.setRequestMethod("POST");
       urlConnection.setRequestProperty("Content-Type", "application/json");
       urlConnection.setRequestProperty("Accept", "application/json");
       urlConnection.setDoOutput(true);
       JSONObject jsonObject = new JSONObject();
       jsonObject.put("email", email);
       jsonObject.put("password", password);
       try(OutputStream os = urlConnection.getOutputStream()){
        byte[] input = jsonObject.toString().getBytes("utf-8");
        os.write(input, 0, input.length);			
       }
       
       try(BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"))) {
         StringBuilder response = new StringBuilder();
         String responseLine = null;
         while ((responseLine = br.readLine()) != null) {
             response.append(responseLine.trim());
         }
         System.out.println(response.toString());
         return Long.parseLong(response.toString());  
     }
    }
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
            connections.register("email","password");
        } catch (IOException ex) {
            Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
