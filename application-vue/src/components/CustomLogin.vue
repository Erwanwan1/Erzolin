<template>
  <v-app>
    <div class="box" name="login" id="login" >
        <h1 class="box-title">Connexion</h1>
        <img src="../assets/loginLogo.png" alt="">
        <input type="text" class="box-input" name="username" placeholder=" Adresse mail"  v-model="email" required="">
        <input type="password" class="box-input" name="password" placeholder=" Mot de passe" v-model="password" required="">
        <input type="submit" value="Connexion " name="submit" class="box-button" accesskey="13" @click="verifyConnexion();">
    </div>
  </v-app>
</template>

<script>

export default {
  name: 'Login',

  data: () => ({
    email: '',
    password: ''
  }),
  components: {
  },
  methods: {
    verifyConnexion () {
      this.$store.state.isConnected = false

      fetch('http://localhost:8080/api/login/',
        {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            email: this.email,
            mdp: this.password
          })
        }).then(response => response.json())
        .then(data => (this.$store.state.utilisateur = data))

      if (this.$store.state.utilisateur !== {}) {
        this.$store.state.isConnected = true
      }
    }
  }
}
</script>

<style scoped>
    body {
      background: #f2f2f2;
    }
    .box {
      padding-left : 10px;
      padding-right : 10px;
      padding-top: 40px;
      background: #f2f2f2;
      margin: 40px auto;
      margin-top: 90px;
      width: 375px;
      border-radius:25px;
      box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    }
    h1.box-logo a {
      text-decoration:none;
    }
    .h1Waiting{
        color :black;
        padding-top: 100px;
    }
    h1.box-title {
      color: black;
      font-weight: 300;
      padding: 15px 25px;
      line-height: 30px;
      font-size: 25px;
      text-align:center;
      margin: -27px -26px 26px;
    }

    h3.box-logo a {
      text-decoration:none;
    }
    .h3Waiting{
        color :black;
        padding-top: 20px;
    }
    h3.box-title {
      color: black;
      font-weight: 300;
      padding: 15px 25px;
      line-height: 30px;
      font-size: 25px;
      text-align:center;
      margin: -27px -26px 26px;
    }

    .box-button {
      border-radius: 5px;
      text-align: center;
      cursor: pointer;
      font-size: 19px;
      width: 100%;
      height: 51px;
      padding: 0;
      color: #fff;
      border: 0;
      outline:0;
    }

    .box-button {background-image: linear-gradient(to right,#b6368e 0%, #cf2084 10%, #01ced7  80%)}
    .box-button {

      text-align: center;
      text-transform: uppercase;
      transition: 0.5s;
      background-size: 200% auto;
      color: white;
      box-shadow: 0 0 20px #eee;
      border-radius: 10px;
      display: block;
    }

    .box-button:hover {
      background-position: right center; /* change the direction of the change here */
      color: #fff;
      text-decoration: none;
    }

    .box-register
    {
      text-align:center;
      margin-bottom:0px;
      margin-top: 15px;
    }
    .box-register a
    {
      text-decoration:none;
      font-size:12px;
      color:#666;
    }
    .box-help
    {
      text-align:center;
      margin-bottom:0px;
      margin-top: 0px;
      padding-bottom:10px ;
    }
    .box-help a
    {
      text-decoration:none;
      font-size:12px;
      color:#666;
    }
    .box-input {
      font-size: 14px;
      background: #fff;
      border: 1px solid #ddd;
      margin-bottom: 25px;
      border-radius: 5px;
      width: 355px;
      height: 50px;
    }
    .box-input:focus {
        outline: none;
        border-color:#5c7186;
    }
    .sucess{
      text-align: center;
      color: white;
    }
    .sucess a {
      text-decoration: none;
      color: #58aef7;
    }
    p.errorMessage {
        background-color: #e66262;
        border: #AA4502 1px solid;
        padding: 5px 10px;
        color: #FFFFFF;
        border-radius: 3px;
    }
    img {
      width: 200px;
      display: block;
      margin-left: auto;
      margin-right: auto;
      padding-top : 5px;
      padding-bottom :40px;
    }

    .circleMoove{
        position: relative;
        transition: transform 0.4s cubic-bezier(0.23,1.83,1.19);
        cursor: pointer;
        align-items: center;
    }

    .circle{
      width: 50px;
      height: 50px;
      border-radius: 50%;
      border: 1px solid white;
      animation: 2s linear infinite alternate boxMagic
      ,4s linear infinite spinning;
      display: inline-block;
      vertical-align: middle;
      margin: 10px;
      margin-top: 30px;
    }

    .circle1{
        margin-left: 460px;
    }

    .container{
        display: flex;
        align-items: center;
        margin: 10px auto;
    }

    @keyframes boxMagic {
        from{
            box-shadow:
            0 0 0 #cf2084,
            0 0 0 #5c81b2,
            0 0 0 #01ced7,
            0 0 0 #b6368e;
        }
        to{
          box-shadow:
          0 -5px 0 #cf2084,
          5px 0 0 #5c81b2,
          0 5px 0 #01ced7,
          -5px 0 0 #b6368e;
        }
    }

    @keyframes spinning {
        from{
            transform: rotate(0deg);
        }
        to{
            transform: rotate(360deg);
        }
    }

    @media only screen and (max-width: 1199px) {
      .circleMoove {
          display: none;
      }
  }

  header{
      padding-top: 20px;
      display: flex;
      align-items: center;
      text-align: center;
  }

  header img{
      vertical-align: middle;
  }
  header .decoWaiting{
      vertical-align: middle;
      padding-left: 10px;
  }
  header i{
      color: #3f4e5d;
      padding: 10px;
  }

  .error{
    color: #b6368e;
    padding: 0px 0px 10px 0px;
    text-align: center;
    font-size: 20px;
  }

  #login{
    padding-bottom: 15px;
  }
</style>
