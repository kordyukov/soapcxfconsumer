package com.cfxconsume.configuration;

import com.cfxconsume.service.soap.SaleCustomersWS;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:META-INF/cxf/cxf.xml"})
@RequiredArgsConstructor
public class CxfWebServiceConfig {
    private final Bus cxfBus;
    @Value("${endpoint-sale-customer-wsdl}")
    private String endpointSaleCustomerWsdl;

    @Bean
    public ServletRegistrationBean cxfServlet() {
        CXFServlet cxfServlet = new CXFServlet();
        ServletRegistrationBean servletDef = new ServletRegistrationBean<>(cxfServlet, "/*");
        servletDef.setLoadOnStartup(1);
        return servletDef;
    }

    @Bean
    public EndpointImpl saleCustomersWs(SaleCustomersWS saleCustomersWS) {
        EndpointImpl endpoint = new EndpointImpl(cxfBus, saleCustomersWS);
        endpoint.setAddress(endpointSaleCustomerWsdl);
        endpoint.publish();
        return endpoint;
    }
}
