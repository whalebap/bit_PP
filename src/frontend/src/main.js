import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import {store} from "./store";
import vuetify from "./plugins/vuetify";
import axios from "axios"
import vuex from 'vuex'


Vue.config.productionTip = false;
Vue.use(vuex)

new Vue({
  router,
  store,
  vuex,
  vuetify,
axios,
  render: h => h(App)
}).$mount("#app");

