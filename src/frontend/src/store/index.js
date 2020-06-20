import Vue from "vue";
import Vuex from "vuex";
import member from "./member";
import trail from "./trail";
import router from "../router";
Vue.use(Vuex);
Vue.use(router)

export const store =  new Vuex.Store({
  modules : {
    member, trail
  }
});
