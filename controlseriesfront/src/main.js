import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

// Importar Bootstrap
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap'

// Importar Font Awesome (opcional)
import '@fortawesome/fontawesome-free/css/all.min.css'

createApp(App).use(router).mount('#app')
