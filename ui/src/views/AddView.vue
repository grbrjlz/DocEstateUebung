<template>
  <div class="about">
    <h1>Immobilie hinzufuegen</h1>
    <ImmobilienForm/>
  </div>
</template>

<script>
import ImmobilienForm from "@/components/ImmobilienForm.vue";

export default {
  name: 'HomeView',
  components: {
    ImmobilienForm
}

}
</script>