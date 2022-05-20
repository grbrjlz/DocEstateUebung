<template>
    <div class="container">
        <h3>Immobilien:</h3>
        <table class="liste">
            <thead>
                <tr>
                    <th>Bezeichnung</th>
                    <th>Addresse</th>
                    <th>Flaeche</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="immobilie in immobilien" :key="immobilie.id">
                    <td>{{immobilie.bezeichnung}}</td>
                    <td>{{immobilie.addresse}}</td>
                    <td>{{immobilie.flaeche}}</td>
                    <button type="submit" @click="entferneImmobilie(immobilie)">loeschen</button>
                </tr>
            </tbody>
        </table>
    </div>    
</template>

<script>
import axios from "axios"   

export default {
    methods: {
        entferneImmobilie(immobilie) {
            axios.delete('/immobilien/'+immobilie.id).then((res) => {
                this.immobilien.splice(this.immobilien.indexOf(immobilie,1))
                console.log("immobilie mit id", immobilie.id, "geloescht", res.status)
            })
            .catch((err => {
                console.log(err)
            }));
        }
        
       
    },
   
    data() {
        let immobilien = []
        return {
            immobilien
        };
    },
    mounted() {
        axios.get('/immobilien').then((res) =>{
            return res.data
        })
        .then((x) => {
            for (let y = 0; y < x.length; y++) {
                this.immobilien.push(x[y])
            }
        })            
        
    }
};
</script>

<style>

.liste {
    width:50%;
    text-align: center;
    margin: 0 auto;
}

</style>