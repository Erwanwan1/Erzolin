<template>
  <v-app>
    <customHeader title='Logout'></customHeader>

  </v-app>
</template>

<script>
import customHeader from '../components/CustomHeader.vue'

export default {
  name: 'Logout',

  components: {
    customHeader
  },
  mounted () {
    this.$store.state.utilisateur = {}
    this.$store.state.isConnected = false
    this.$router.push('/')
  }
}
</script>
