package com.danilosilva.pocobservability.controller;

import static com.danilosilva.pocobservability.support.Constants.DOCUMENT_IDENTIFIER;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OperationController {

    @GetMapping(value = "success")
    public ResponseEntity<String> getSuccess(@RequestHeader("document-identifier") final String documentIdentifier) {
        MDC.put(DOCUMENT_IDENTIFIER, documentIdentifier);
        return ResponseEntity.ok("Yep, success!");
    }

    @GetMapping("/fail")
    public ResponseEntity<String> getFails(
        @RequestHeader("document-identifier") final String documentIdentifier
    ) throws IllegalAccessException {
        MDC.put(DOCUMENT_IDENTIFIER, documentIdentifier);
        throw new IllegalAccessException("Ops, fails...");
    }
}
