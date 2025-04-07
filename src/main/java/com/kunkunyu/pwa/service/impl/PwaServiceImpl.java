package com.kunkunyu.pwa.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.kunkunyu.pwa.service.PwaService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import run.halo.app.plugin.ReactiveSettingFetcher;

@Component
public class PwaServiceImpl implements PwaService {

    private final ReactiveSettingFetcher settingFetcher;

    public PwaServiceImpl(ReactiveSettingFetcher settingFetcher) {
        this.settingFetcher = settingFetcher;
    }

    @Override
    public Mono<JsonNode> getBasicConfig() {
        return this.settingFetcher.get("basic");
    }
}
