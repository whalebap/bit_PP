import Vue from "vue";
import Vuex from "vuex";
import member from "./member";

Vue.use(Vuex);

export const store =  new Vuex.Store({
  modules : {
    member
  }
});
