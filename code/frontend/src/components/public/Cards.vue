<template>
<div>
       <ul class="list">
         <li class="item" v-for="item in cards" :key="item.id">
           <router-link to="/detail/indexPage/id/0">
             <div class="cnt" >
               <h4 class="title">{{item.username}}</h4>
                <span class="price" >
                  <span >{{item.sex}}</span>
               </span>
              </div>
              <img :src="item.src"  style="opacity: 1;">
           </router-link >
         </li>
       </ul>
</div>
</template>

<script>
/**
 * 1.tabs，容纳数据，捕捉被点击 选项
 */
export default {
  props: ["cards"],
  data() {
    return {};
  },
  methods: {}
};
</script>

<style scoped>
</style>
