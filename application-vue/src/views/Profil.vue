<template>
  <v-app>
    <customHeader title='Profil'></customHeader>
    <v-container>
      <v-card>
        <v-row
        justify="center"
        >
          <v-col
          cols="12"
          sm="10"
          md="8"
          lg="6"
          >
            <v-text-field
            label="Email"
            outlined
            color="#cf2084"
            v-model="utilisateur.email"
            ></v-text-field>
            <v-text-field
              v-model="password"
              :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
              :rules="[rules.required, rules.min]"
              :type="show1 ? 'text' : 'password'"
              name="input-10-1"
              label="Mot de passe"
              hint="Au moins 8 caracteres"
              color="#cf2084"
              counter
              @click:append="show1 = !show1"
            ></v-text-field>
            <v-text-field
              v-model="confirmPassword"
              :append-icon="show2 ? 'mdi-eye' : 'mdi-eye-off'"
              :rules="[rules.required, rules.min]"
              :type="show2 ? 'text' : 'password'"
              name="input-10-1"
              label="Comfirmation du mot de passe"
              hint="Au moins 8 caracteres"
              color="#cf2084"
              counter
              @click:append="show2 = !show2"
            ></v-text-field>
          </v-col>
        </v-row>
      </v-card>
    </v-container>
  </v-app>
</template>

<script>
import customHeader from '../components/CustomHeader.vue'

export default {
  name: 'Profil',

  components: {
    customHeader
  },
  data: () => ({
    utilisateur: [],
    password: '',
    confirmPassword: '',
    show1: false,
    show2: false,
    rules: {
      required: value => !!value || 'Required.',
      min: v => v.length >= 8 || 'Min 8 characters',
      emailMatch: () => ('Les mots de passes sont différents')
    }
  }),

  methods: {
    getUtilisateur () {
      fetch('http://localhost:8080/api/profil/' + 1,
        {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json'
          }
        }).then(response => response.json())
        .then(data => (this.utilisateur = data))
    }
  },
  mounted () {
    this.getUtilisateur()
  }
}
</script>
