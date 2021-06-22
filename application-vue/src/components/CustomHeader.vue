<template>
  <v-app-bar
  app
  fixed
  dark
  color="#01ced7"
  >
    <v-toolbar-title>
        {{title}}
    </v-toolbar-title>
  </v-app-bar>
</template>

<script>

export default {
  name: 'CustomHeader',

  components: {

  },

  props: {
    title: String
  }
}
</script>
