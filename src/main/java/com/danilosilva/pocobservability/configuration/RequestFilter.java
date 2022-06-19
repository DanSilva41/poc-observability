package com.danilosilva.pocobservability.configuration;

import static com.danilosilva.pocobservability.support.Constants.REQUEST_ID;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

@Slf4j
@Component
public class RequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        var requestId = UUID.randomUUID();
        MDC.put(REQUEST_ID, requestId.toString());

        log.info("Request IP address is {}", request.getRemoteAddr());
        log.info("Request content type is {}", request.getContentType());

        var responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) response);

        chain.doFilter(request, responseWrapper);

        responseWrapper.setHeader(REQUEST_ID, requestId.toString());
        responseWrapper.copyBodyToResponse();
        log.info("Response header is set with uuid {}", responseWrapper.getHeader(REQUEST_ID));
    }
}
