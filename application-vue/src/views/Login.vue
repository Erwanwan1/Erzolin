<template>
  <v-app>
    <customLogin></customLogin>
  </v-app>
</template>

<script>
import customLogin from '../components/CustomLogin.vue'

export default {
  name: 'Login',

  components: {
    customLogin
  }
}
</script>
