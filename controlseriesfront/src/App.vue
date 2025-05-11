<template>
  <div id="app">
    <!-- Barra de navegación -->
    <nav class="navbar navbar-dark bg-primary mb-4">
      <div class="container">
        <span class="navbar-brand">Mis Series</span>
      </div>
    </nav>

    <!-- Contenido dinámico (cambia según la ruta) -->
    <main class="container">
      <router-view/>
    </main>

    <!-- Pie de página -->
    <footer class="mt-5 py-3 bg-light text-center">
      <p class="mb-0">Aplicación hecha con Vue 3 + Spring Boot</p>
    </footer>
  </div>
</template>

<style>
#app {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

main {
  flex: 1;
}
</style>