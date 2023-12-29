<template>
  <NavBar />
  <router-view> </router-view>
</template> 

<script>

import NavBar from './components/NavBar.vue'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap"
//import $ from 'jquery'

  export default{
    components:{
      NavBar
    },
    setup(){
      // $.ajax({
      //     url:"http://127.0.0.1:3000/user/account/token/",
      //     type:"post",
      //     data: {
      //       username:'c',
      //       password:"cc",
      //     },
      //     success(resp) {
      //       console.log(resp);
      //     },
      //     error(resp){
      //       console.log(resp);
      //     },

      // });
  //   $.ajax({
  //     url:"http://127.0.0.1:3000/user/account/info/",
  //     type:"get",
  //     headers:{
  //       Authorization: "Bearer " +"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI3MTQxMGIwMWU0ZTg0MDdhYjJkNGQ1M2RiYzVmMWY0ZSIsInN1YiI6IjMiLCJpc3MiOiJzZyIsImlhdCI6MTY1ODk3MDM1OCwiZXhwIjoxNjYwMTc5OTU4fQ.-RC_KHouwiWARTqjO06c9Fdb0rMCF6PPhVJpVnjraKA"
  //     },
  //     success(resp){
  //       console.log(resp);
  //     },
  //     error(resp){
  //       console.log(resp);
  //     }
  //   });

  //   $.ajax({
  //     url:"http://127.0.0.1:3000/user/account/register/",
  //     type: "post",
  //     data:{
  //         username:"et21",
  //         password:"123",
  //         confirmedPassword:"123",

  //     },
  //     success(resp) {
  //       console.log(resp);
  //     }, 
  //     error(resp){
  //       console.log(resp);
  //     }
  //   })
     }
   }
</script>>

<style>
body{
  background-image: url("@/assets/images/background.png");
  background-size:cover;
}
</style>
   