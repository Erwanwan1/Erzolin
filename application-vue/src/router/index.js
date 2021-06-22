import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Profil from '../views/Profil.vue'
import Logout from '../views/Logout.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/home',
    name: 'Home',
    component: Home
  },
  {
    path: '/profil',
    name: 'Profil',
    component: Profil
  },
  {
    path: '/logout',
    name: 'Logout',
    component: Logout
  }
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router
