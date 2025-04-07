package com.kunkunyu.pwa.service;

import com.fasterxml.jackson.databind.JsonNode;
import reactor.core.publisher.Mono;

public interface PwaService {

    Mono<JsonNode> getBasicConfig();
}
