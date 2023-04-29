package com.cfxconsume.soapcxfconsumer.config;

import com.cfxconsume.soapcxfconsumer.service.HelloWorldWS;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:META-INF/cxf/cxf.xml"})
public class CxfWebServiceConfig {
    @Autowired
    private Bus cxfBus;

    @Bean
    public ServletRegistrationBean cxfServlet() {
        CXFServlet cxfServlet = new org.apache.cxf.transport.servlet.CXFServlet();
        ServletRegistrationBean servletDef = new ServletRegistrationBean<>(cxfServlet, "/ws/*");
        servletDef.setLoadOnStartup(1);
        return servletDef;
    }

    @Bean
    public EndpointImpl helloWorldWebService(HelloWorldWS helloWorldWS) {
        EndpointImpl endpoint = new EndpointImpl(cxfBus, helloWorldWS);
        endpoint.setAddress("/helloWorldWS");
        endpoint.publish();
        return endpoint;
    }
}
