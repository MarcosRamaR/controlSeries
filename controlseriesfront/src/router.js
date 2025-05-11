import { createRouter, createWebHistory } from 'vue-router'
import HomeView from './views/HomeView.vue'  // Asegúrate de que la ruta es correcta

const routes = [
{
    path: '/',
    name: 'home',
    component: HomeView
}
]

const router = createRouter({
history: createWebHistory(process.env.BASE_URL),
routes
})

export default router