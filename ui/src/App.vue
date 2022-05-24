<template>
  <nav>
    <router-link to="/">Immobilien</router-link> |
    <router-link to="/add">Hinzufuegen</router-link>
    <button @click="logout()"> logout</button>
  </nav>
  <router-view/>
</template>


<script>
import axios from "axios" 

export default {
  methods: {
    logout() {
      axios.get('/logout').then((res) => {
        console.log(res.status)
        window.location.reload()
      })
      .catch((err => {
          console.log(err)
      }));
    }
  }
}

</script>


<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
