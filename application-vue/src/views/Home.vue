<template>
  <v-app>
    <customLogin v-if="!$store.state.isConnected"></customLogin>
    <div v-else>
      <customHeader title='Home'>
      </customHeader>
      <v-app-bar
      max-height="60px"
      dark
      color="#5c81b2"
      >
          <v-spacer></v-spacer>
          <v-divider
            class="mx-4"
            inset
            vertical
          ></v-divider>
          <v-btn
          color="#cf2084"
          dark
          class="mb-2"
          @click="filters()"
          >
            Filtrer
          </v-btn>
      </v-app-bar>
      <v-container>
        <v-row>
          <v-col
          cols="3">
            <v-card>
              <v-card-title style="text-align: center">Filtres</v-card-title>
              <v-divider></v-divider>
              <v-card-text>
                <v-date-picker
                  v-model="dates"
                  color="#cf2084"
                  range
                ></v-date-picker>
                <v-autocomplete
                  v-model="selectedRegions"
                  :items="regions"
                  item-text="nom"
                  outlined
                  small-chips
                  label="Région"
                  multiple
                  color="#cf2084"
                  return-object
                ></v-autocomplete>
                <v-autocomplete
                  v-model="selectedVendeurs"
                  :items="vendeurs"
                  item-text="nom"
                  outlined
                  small-chips
                  label="Vendeur"
                  multiple
                  color="#cf2084"
                  return-object
                ></v-autocomplete>
              </v-card-text>
            </v-card>
          </v-col>
          <v-col>
            <v-card>
              <v-card-title>
                <v-card-title>Liste des ventes</v-card-title>
                <v-spacer></v-spacer>
                  <v-divider
                    class="mx-4"
                    inset
                    vertical
                  ></v-divider>
                <v-text-field
                  v-model="search"
                  color="#cf2084"
                  append-icon="mdi-magnify"
                  label="Rechercher"
                  single-line
                  hide-details
                ></v-text-field>
              </v-card-title>
              <v-data-table
                :page.sync="page"
                hide-default-footer
                :sort-by="['dateFacturation']"
                :headers="headers"
                :search="search"
                :items="ventes"
                item-key="vente"
                class="elevation-2"
                :items-per-page="-1"
              >
              <template
              v-slot:item="{ item }">
                <tr style="text-align:left;">
                  <td>{{item.dateFacturation}}</td>
                  <td>{{item.numero}}</td>
                  <td>{{item.venId.prenom + ' ' + item.venId.nom}}</td>
                  <td>{{item.regId.nom}}</td>
                </tr>
              </template>
              </v-data-table>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </div>
  </v-app>
</template>

<script>
import customHeader from '../components/CustomHeader.vue'
import customLogin from '../components/CustomLogin.vue'

export default {
  name: 'Home',

  components: {
    customHeader,
    customLogin
  },
  data: () => ({
    ventes: [],
    defaultVentes: [],
    ventesFiltered: [],
    page: 1,
    pageCount: 0,
    search: '',
    headers: [
      {
        text: 'Date de facturation',
        value: 'dateFacturation'
      },
      { text: 'Numéro de la vente', value: 'numero' },
      { text: 'Nom du vendeur', value: ('venId.nom' + 'venId.prenom') },
      { text: 'Nom de la région', value: 'regId.nom' }
    ],
    dates: [],
    regions: [],
    selectedRegions: [],
    vendeurs: [],
    selectedVendeurs: []
  }),
  methods: {
    getVentes () {
      fetch('http://localhost:8080/api/home/',
        {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json'
          }
        }).then(response => response.json())
        .then(data => {
          data.forEach(el => {
            this.defaultVentes.push(el)
            this.ventes.push(el)
          })
        })
    },
    getRegions () {
      fetch('http://localhost:8080/api/home/region',
        {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json'
          }
        }).then(response => response.json())
        .then(data => {
          data.forEach(el => {
            this.regions.push(el)
          })
        })
    },
    getVendeurs () {
      fetch('http://localhost:8080/api/home/vendeur',
        {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json'
          }
        }).then(response => response.json())
        .then(data => {
          data.forEach(el => {
            this.vendeurs.push(el)
          })
        })
    },
    filters () {
      fetch('http://localhost:8080/api/home/filtre',
        {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            regions: this.selectedRegions,
            vendeurs: this.selectedVendeurs
          })
        }).then(response => response.json())
        .then(data => {
          data.forEach(el => {
            this.ventes.push(el)
          })
        })
    }
  },
  mounted () {
    if (this.$store.state.isConnected) {
      this.getVentes()
      this.getRegions()
      this.getVendeurs()
    }
  }
}

</script>
