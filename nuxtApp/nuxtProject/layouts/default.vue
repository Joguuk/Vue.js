<template>
  <div>
    <app-header></app-header>
    <Nuxt />
  </div>
</template>

<script>
import AppHeader from '@/components/AppHeader'

export default ({
  components: { 
    AppHeader,
  },
})
</script>

<style>
@import 'http://localhost:8000/assets/index.css';
</style>
