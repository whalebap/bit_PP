import Vue from "vue";
import Vuex from "vuex";
import member from "./member";
import trail from "./trail";

Vue.use(Vuex);

export const store =  new Vuex.Store({
  modules : {
    member, trail
  }
});
