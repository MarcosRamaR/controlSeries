const { defineConfig } = require('@vue/cli-service')

module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: 8081, // Puerto para el frontend (diferente al backend)
    hot: true,   // Recarga automática durante el desarrollo
    proxy: {
      // Opcional: Configuración de proxy para evitar problemas CORS durante desarrollo
      '/api': {
        target: 'http://localhost:8080', // Tu backend Spring Boot
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  }
})