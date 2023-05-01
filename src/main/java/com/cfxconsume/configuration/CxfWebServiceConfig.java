package com.cfxconsume.configuration;

import com.cfxconsume.service.soap.SaleCustomersWS;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAutoConfiguration
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
        EndpointImpl endpointImpl = new EndpointImpl(cxfBus, saleCustomersWS);
        endpointImpl.setAddress(endpointSaleCustomerWsdl);

        endpointImpl.publish();
        endpointImpl.getServer().getEndpoint().getInInterceptors()
                .add(new LoggingInInterceptor());
        endpointImpl.getServer().getEndpoint().getOutInterceptors()
                .add(new LoggingOutInterceptor());
        return endpointImpl;
    }
}
