<template>
    <div>
        <input v-model="immobilie.bezeichnung" placeholder="Bezeichnung ...">
        <input v-model="immobilie.addresse" placeholder="Addresse ...">
        <input v-model="immobilie.flaeche" placeholder="Flaeche: ...">
        <br>
        <button type="submit" @click="hinzufuegen(immobilie)"> hinzufuegen </button>

    </div>
</template>

<script>
import axios from 'axios'

    export default {
        methods: {
            hinzufuegen(immobilie) {
                axios.post('/immobilien', immobilie).then((res) => {
                console.log("immobilie ",immobilie.bezeichnung, "hinzugefuegt", res.status)
            })
                .catch((err => {
                    console.log(err)
                }));
            }
        },
        data(){
            const immobilie = {
                bezeichnung: "",
                addresse: "",
                flaeche: 0
            }
            return{
                immobilie
            }
        }
    }
</script>