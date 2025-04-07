import { definePlugin } from "@halo-dev/console-shared";
import { markRaw } from "vue";
import SimpleIconsPwa from '~icons/simple-icons/pwa?width=1.2em&height=1.2em';

export default definePlugin({
  components: {},
  routes: [
    {
      parentName: "ToolsRoot",
      route: {
        path: "/pwa",
        name: "PWA",
        redirect: "/plugins/pwa?tab=basic",
        meta: {
          title: "PWA  (渐进式Web应用)",
          description: "PWA 可以帮助您立即将 Halo 网站转换为渐进式 Web 应用程序。",
          searchable: true,
          menu: {
            name: "PWA  (渐进式Web应用)",
            icon: markRaw(SimpleIconsPwa),
            priority: 0,
          },
        },
      },
    },
  ],
  extensionPoints: {},
});
