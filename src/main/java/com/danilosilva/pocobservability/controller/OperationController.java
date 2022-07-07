package com.danilosilva.pocobservability.controller;

import static com.danilosilva.pocobservability.support.Constants.DOCUMENT_IDENTIFIER;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class OperationController {

    private final MeterRegistry meterRegistry;
    private final Counter.Builder exclusiveRequests = Counter.builder("exclusive_request")
        .description("The number of requests in created endpoints");

    @GetMapping(value = "success")
    public ResponseEntity<String> getSuccess(@RequestHeader("document-identifier") final String documentIdentifier) {
        MDC.put(DOCUMENT_IDENTIFIER, documentIdentifier);
        log.info("GET Request to success endpoint");

        this.incrementExclusiveRequest("success");
        return ResponseEntity.ok("Yep, success!");
    }

    @GetMapping("/fail")
    public ResponseEntity<String> getFails(
        @RequestHeader("document-identifier") final String documentIdentifier
    ) throws IllegalAccessException {
        MDC.put(DOCUMENT_IDENTIFIER, documentIdentifier);
        log.info("GET Request to fails endpoint");

        this.incrementExclusiveRequest("failed");
        throw new IllegalAccessException("Ops, fails...");
    }

    private void incrementExclusiveRequest(final String type) {
        exclusiveRequests
            .tag("type", type)
            .register(meterRegistry)
            .increment();
    }

}
