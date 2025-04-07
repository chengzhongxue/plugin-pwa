package com.kunkunyu.pwa;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.processor.element.IElementModelStructureHandler;
import reactor.core.publisher.Mono;
import run.halo.app.theme.dialect.TemplateHeadProcessor;

import java.util.Map;

import static org.thymeleaf.model.AttributeValueQuotes.DOUBLE;

@Component
@RequiredArgsConstructor
@Order(0)
public class PwaHeadProcessor implements TemplateHeadProcessor {


    @Override
    public Mono<Void> process(ITemplateContext context, IModel model,
        IElementModelStructureHandler structureHandler) {
        return Mono.fromRunnable(() -> {
            var modelFactory = context.getModelFactory();
            var pwaManifestLink = modelFactory.createStandaloneElementTag("link",
                Map.of("rel", "manifest", "href", "/apis/api.pwa.kunkunyu.com/v1alpha1/basic-config"),
                DOUBLE, false, true);
            model.add(pwaManifestLink);
        });
    }

}
