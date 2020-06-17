import Vue from "vue";
import VueRouter from "vue-router";
import Login from "../components/member/Login";
import Join from "../components/member/Join";
import Home from "../components/Home";
import Trail from "../components/common/Trail";
import MyPage from "../components/member/MyPage";

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
  {path : '/trail', component: Trail},
  {path : '/myPage', component: MyPage},

];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
