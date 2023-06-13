import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AboutView from '../views/AboutView.vue'
import LoginView from '../views/LoginView.vue'
import RegisterView from '../views/RegisterView.vue'
import TodoListView from '../views/TodoListView.vue'
import AddTodoView from '../views/AddTodoView.vue'
import ModifyTodoView from '../views/ModifyView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterView
  },
  {
    path: '/list',
    name: 'list',
    component: TodoListView
  },
  {
    path: '/add',
    name: 'AddTodoView',
    component: AddTodoView
  },
  {
    path: '/edit',
    name: 'edit',
    component: ModifyTodoView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    //component: () => import('../views/AboutView.vue')
    component: AboutView
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
