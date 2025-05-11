<template>
  <div class="mt-5">
    <h2>Añadir Nueva Serie</h2>
    <form @submit.prevent="submitForm">

      <div class="mb-3">
        <label class="form-label">Nombre</label>
        <input v-model="form.name" type="text" class="form-control" required>
      </div>

      <div class="mb-3">
        <label class="form-label">Género</label>
        <input v-model="form.genre" type="text" class="form-control" required>
      </div>

        <div class="mb-3">
        <label class="form-label">Descripción</label>
        <input v-model="form.description" type="text" class="form-control" required>
      </div>
      
      <div class="mb-3">
        <label class="form-label">Puntuación</label>
        <input v-model.number="form.points" type="number" class="form-control" step="0.1" required>
      </div>
      <button type="submit" class="btn btn-primary">Guardar</button>
    </form>
  </div>
</template>

<script>
import api from '@/services/api'

export default {
  data() {
    return {
      form: {
        name: '',
        genre: '',
        description: '',
        points: 0
      }
    }
  },
  methods: {
    async submitForm() {
      const newSerie = await api.createSerie(this.form)  // Envía datos al backend
      this.$emit('new-serie', newSerie)  // Notifica al componente padre (HomeView)
      this.form = { name: '', genre: '',description: '', points: 0 }  // Reinicia el formulario
    }
  }
}
</script>