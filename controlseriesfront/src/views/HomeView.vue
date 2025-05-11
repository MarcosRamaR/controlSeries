<template>
  <div>
    <h1 class="mb-4">Lista de Series</h1>
    
    <!-- Tabla de series -->
    <table class="table table-hover">
      <thead>
        <tr>
          <th>Nombre</th>
          <th>Género</th>
          <th>Descripción</th>
          <th>Puntuación</th>
          <th>Acciones</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="serie in series" :key="serie.id">
          <td>{{ serie.name }}</td>
          <td>{{ serie.genre }}</td>
          <td>{{ serie.description }}</td>
          <td>{{ serie.points }}</td>
          <td>
            <button @click="deleteSerie(serie.id)" class="btn btn-danger btn-sm">
              Eliminar
            </button>
          </td>
        </tr>
      </tbody>
    </table>

    <!-- Componente del formulario -->
    <SeriesForm @new-serie="addSerie" />
  </div>
</template>

<script>
import SeriesForm from '@/components/SeriesForm.vue'
import api from '@/services/api'  // Importamos el servicio API

export default {
  components: { SeriesForm },
  data() {
    return {
      series: []  // Almacena las series desde el backend
    }
  },
  async created() {
    this.series = await api.getSeries()  // Carga las series al iniciar
  },
  methods: {
    async deleteSerie(id) {
      await api.deleteSerie(id)
      this.series = this.series.filter(serie => serie.id !== id)  // Actualiza la lista
    },
    addSerie(newSerie) {
      this.series.push(newSerie)  // Añade una nueva serie
    }
  }
}
</script>