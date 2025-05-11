import axios from 'axios'

const api = axios.create({
  baseURL: '/api',  // Usa el proxy configurado
  timeout: 5000     // Tiempo máximo de espera
})

export default {
  // Obtener todas las series
  async getSeries() {
    const response = await api.get('/series')
    return response.data
  },

  // Crear una nueva serie
  async createSerie(serie) {
    const response = await api.post('/series', serie)
    return response.data
  },

  // Eliminar una serie
  async deleteSerie(id) {
    await api.delete(`/series/${id}`)
  }
}