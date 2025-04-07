package com.kunkunyu.pwa;

import com.fasterxml.jackson.databind.JsonNode;
import com.kunkunyu.pwa.service.PwaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.webflux.core.fn.SpringdocRouteBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import run.halo.app.core.extension.endpoint.CustomEndpoint;
import run.halo.app.extension.GroupVersion;

import static org.springdoc.core.fn.builders.apiresponse.Builder.responseBuilder;

@Slf4j
@Component
@RequiredArgsConstructor
public class PwaEndpoint implements CustomEndpoint {

    private final PwaService pwaService;


    @Override
    public RouterFunction<ServerResponse> endpoint() {
        final var tag = "api.pwa.kunkunyu.com/v1alpha1/Pwa";
        return SpringdocRouteBuilder.route()
            .GET("basic-config", this::getBasicConfig, builder -> {
                    builder.operationId("GetBasicConfig")
                        .tag(tag)
                        .description("获取PWA的基础配置")
                        .response(
                            responseBuilder()
                                .implementation(JsonNode.class)
                        );
                }
            )
            .build();
    }

    Mono<ServerResponse> getBasicConfig(ServerRequest serverRequest) {
        return pwaService.getBasicConfig()
            .flatMap(basicConfig -> ServerResponse.ok().bodyValue(basicConfig));
    }

    @Override
    public GroupVersion groupVersion() {
        return GroupVersion.parseAPIVersion("api.pwa.kunkunyu.com/v1alpha1");
    }

}
