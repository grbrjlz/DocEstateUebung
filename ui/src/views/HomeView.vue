<template>
  <div class="home">
    <ImmobilienListe/>
  </div>
</template>

<script>
// @ is an alias to /src

import ImmobilienListe from '@/components/ImmobilienListe.vue'

export default {
  name: 'HomeView',
  components: {
    ImmobilienListe
}
}
</script>
