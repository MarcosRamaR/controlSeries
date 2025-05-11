import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

// Importar Bootstrap
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap'

// Importar Font Awesome (opcional)
import '@fortawesome/fontawesome-free/css/all.min.css'

//Creamos la app, usamos el router y montamos la app en el viv#app del html
const app = createApp(App);
app.use(router);
app.mount('#app');

