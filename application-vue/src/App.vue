<template>
  <v-app>
    <v-navigation-drawer
    app
    permanent
    color="#972974"
    dark
    fixed
    >
      <v-list
      nav
      >
        <v-list-group
        v-for="item in items"
        :key="item.title"
        color="grey lighten-3"
        no-action
        append-icon=""
        >
          <v-list-item slot="activator" :to="item.route">
            <v-list-item-icon>
              <v-icon>
                {{item.icon}}
              </v-icon>
            </v-list-item-icon>
            <v-list-item-title>{{item.title}}</v-list-item-title>
          </v-list-item>
        </v-list-group>
      </v-list>
      <img src="./assets/loginLogo.png" alt="" width="280px" height="280px" style="position: absolute; bottom: 0px; right: -15px">
    </v-navigation-drawer>
    <v-main
    right>
        <router-view/>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    items: [
      { title: 'Accueil', icon: 'mdi-home', route: '/' },
      { title: 'Profil', icon: 'mdi-account', route: '/profil' },
      { title: 'Logout', icon: 'mdi-logout', route: '/logout' }
    ]
  })
}
</script>
