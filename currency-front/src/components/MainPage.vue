<template>
  <div class="main">
    <h1>Currency converter</h1>

    <input v-model="rate">
    <button v-on:click="setRate">Установить rate</button>
    <br><br>
    <input v-model="amount">
    <button v-on:click="convert">Посчитать</button>

    <h3 v-if="res>0">Amount*rate={{res}}</h3>

  </div>
</template>

<script>
import WebService from "../services/WebService";

export default {
  name: 'MainPage',
  data: function () {
    return{
      rate: 0,
      amount: 0,
      res : 0
    }
  },
  methods: {
    setRate: function () {
       WebService.setRate(this.rate)
          .then(response => {
            this.rate = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
        },

    convert: function() {
      WebService.convert(this.amount)
          .then(response => {
            this.res = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    }
  },
  mounted() {
  this.$nextTick(function () {
    WebService.getRate()
        .then(response => {
          this.rate = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
  })
}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
