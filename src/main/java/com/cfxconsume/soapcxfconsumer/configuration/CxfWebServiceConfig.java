package com.cfxconsume.soapcxfconsumer.configuration;

import com.cfxconsume.soapcxfconsumer.service.SaleCustomersWS;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:META-INF/cxf/cxf.xml"})
public class CxfWebServiceConfig {
    @Value("${endpoint-wdsl}")
    private String endpointWdsl;
    @Autowired
    private Bus cxfBus;

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
        endpoint.setAddress(endpointWdsl);
        endpoint.publish();
        return endpoint;
    }
}
