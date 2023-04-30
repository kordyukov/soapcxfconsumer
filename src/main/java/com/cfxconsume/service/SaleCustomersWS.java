package com.cfxconsume.service;


import com.cfxconsume.entity.Product;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Collection;

@WebService
public interface SaleCustomersWS {
    @WebMethod
    String createMessage(@WebParam(name = "createMessageRequest", mode = WebParam.Mode.IN) String name);

    @WebMethod
    Collection<Product> findAll();
    @WebMethod
    Product saveProduct(Product product);
}
