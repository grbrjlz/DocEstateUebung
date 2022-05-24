<!--
    Form zum einfuegen von Immobilien in die Datenbank
-->
<template>
    <div>
        Bezeichnung: <input v-model="immobilie.bezeichnung" placeholder="Gallerie Taunusstein ...">
        Addresse: <input v-model="immobilie.addresse" placeholder="Haupstr. 1, 65203 ...">
        Flaeche in qm <input v-model="immobilie.flaeche">
        <br><br>
        <button type="submit" @click="hinzufuegen(immobilie)"> hinzufuegen </button>

    </div>
</template>

<script>
import axios from 'axios'

    export default {
        methods: {
            /**
             * POST auf '/immobilen'
             * @param {*} immobilie {bezeichnung, addresse,id}
             */
            hinzufuegen(immobilie) {
                axios.post('/immobilien', immobilie).then((res) => {
                console.log("immobilie ",immobilie.bezeichnung, "hinzugefuegt", res.status)
                immobilie.bezeichnung = ''
                immobilie.addresse = ''
                immobilie.flaeche = 0
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