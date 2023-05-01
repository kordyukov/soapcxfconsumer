package com.cfxconsume.service.soap;


import com.cfxconsume.entity.Customer;
import com.cfxconsume.entity.Position;
import com.cfxconsume.entity.Product;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Collection;
import java.util.List;

@WebService
public interface SaleCustomersWS {
    @WebMethod
    String createMessage(@WebParam(name = "createMessageRequest", mode = WebParam.Mode.IN) String name);

    @WebMethod
    Collection<Product> findAllProducts();

    @WebMethod
    Product saveProduct(@WebParam(name = "product", mode = WebParam.Mode.IN) Product product);

    @WebMethod
    List<Customer> findAllCustomer();

    @WebMethod
    List<Position> findAllPosition();
}
