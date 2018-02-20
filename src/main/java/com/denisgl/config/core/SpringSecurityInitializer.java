package com.denisgl.config.core;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    // equivalent of
    //<filter>
    //	<filter-name>springSecurityFilterChain</filter-name>
    //	<filter-class>org.springframework.web.filter.DelegatingFilterProxy
    //                </filter-class>
    //</filter>
    //
    //<filter-mapping>
    //	<filter-name>springSecurityFilterChain</filter-name>
    //	<url-pattern>/*</url-pattern>
    //</filter-mapping>
}