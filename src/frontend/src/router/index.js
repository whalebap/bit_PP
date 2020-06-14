import Vue from "vue";
import VueRouter from "vue-router";
import Login from "../components/member/Login";
import Join from "../components/member/Join";
import Karaoke from "../components/common/Karaoke";
import Home from "../components/Home";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {path: '/login',
    component: Login},
  {path : '/join',
    component: Join},
  {path : '/karaoke', component: Karaoke},

];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
