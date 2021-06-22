<template>
  <v-app>
    <div>
      <customHeader title='Profil'></customHeader>
      <v-container>
        <v-card>
          <v-alert
          :value="alert"
          type="success"
          dismissible
          transition="scale-transition"
        >
          L'utilisateur a été modifié avec succès !
        </v-alert>
        <v-alert
          :value="error"
          type="error"
          dismissible
          transition="scale-transition"
        >
          Les mots de passe sont différents ou mauvais !
        </v-alert>
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
              v-model="$store.state.utilisateur.utiId.email"
              ></v-text-field>
              <v-text-field
                v-model="password"
                :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
                :rules="[rules.required, rules.min]"
                :type="show1 ? 'text' : 'password'"
                name="input-10-1"
                label="Nouveau mot de passe"
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
              <v-btn
              color="#cf2084"
              dark
              class="mb-2"
              @click="validate()"
              >
                Confirmer
              </v-btn>
            </v-col>
          </v-row>
        </v-card>
      </v-container>
    </div>
  </v-app>
</template>

<script>
import customHeader from '../components/CustomHeader.vue'

export default {
  name: 'Profil',

  components: {
    customHeader
  },
  $_veeValidate: {
    validator: 'new'
  },
  data: () => ({
    password: '',
    confirmPassword: '',
    show1: false,
    show2: false,
    alert: false,
    error: false,
    rules: {
      required: value => !!value || 'Required.',
      min: v => v.length >= 8 || 'Min 8 characters',
      emailMatch: () => ('Les mots de passes sont différents')
    }
  }),

  methods: {
    getUtilisateur () {
      fetch('http://localhost:8080/api/profil/' + this.$store.state.utilisateur.utiId.id,
        {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json'
          }
        }).then(response => response.json())
        .then(data => (this.utilisateur = data))
    },
    validate () {
      this.error = false
      if (this.password.length > 7 && this.password === this.confirmPassword) {
        this.confirm()
      } else {
        this.error = true
      }
    },
    confirm () {
      this.alert = false
      fetch('http://localhost:8080/api/profil/',
        {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            id: this.$store.state.utilisateur.utiId.id,
            email: this.$store.state.utilisateur.utiId.email,
            mdp: this.password
          })
        }
      )
      this.alert = true
    }
  },
  mounted () {
    if (this.$store.state.isConnected) {
      this.getUtilisateur()
    } else {
      this.$router.push('/')
    }
  }
}
</script>
