package com.kunkunyu.pwa;

import org.springframework.stereotype.Component;
import run.halo.app.plugin.BasePlugin;
import run.halo.app.plugin.PluginContext;


@Component
public class PwaPlugin extends BasePlugin {

    public PwaPlugin(PluginContext pluginContext) {
        super(pluginContext);
    }

    @Override
    public void start() {
        System.out.println("插件启动成功！");
    }

    @Override
    public void stop() {
        System.out.println("插件停止！");
    }
}
