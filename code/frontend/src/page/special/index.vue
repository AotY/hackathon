<template>
  <div class="special">
    <!-- <div class="container">
      <no-loop-swiper :Items="Items" class="special-no-loop"></no-loop-swiper>
      <each-suggest :suggests="suggests"></each-suggest>
    </div> -->
    <Heads>
    </Heads>
    <ChatList>
    </ChatList>
    <v-footer class="footer"></v-footer>
  </div>
</template>

<script>
import Heads from "@/components/public/Heads";
import ChatList from "@/components/public/ChatList";

import data from "@/fetch/api";
import Footer from "@/components/public/Footer";
import noloopswiper from "@/components/public/NoLoopSwiper";
import eachSuggest from "@/components/public/EachSuggest";
export default {
  name: "index",
  data() {
    return {
      // Items: [
      //   {id: 0, src: 'https://yanxuan.nosdn.127.net/1de4da49367dd7c01af1f7a2b23b0237.jpg'},
      //   {id: 1, src: 'https://yanxuan.nosdn.127.net/14939888168151095.png'},
      //   {id: 2, src: 'https://yanxuan.nosdn.127.net/dc1b671ad54e16339f1b26cfeec6a1ea.jpg'},
      //   {id: 3, src: 'https://yanxuan.nosdn.127.net/d943675462a06f817d33062d4eb059f5.jpg'}
      // ],
      suggests: []
    };
  },
  created() {
    this.$store.dispatch("getInfos", "carousel.do");

    this.$Loading.config({
      color: "#b4282d",
      failedColor: "#f0ad4e",
      height: 3
    });
    this.$Loading.start();
    this.$store.dispatch("changeActive", 1);
    data.getTypeDesc("specials").then(res => {
      this.suggests = res;
      console.log("res", res);
    });
  },
  mounted() {
    this.$Loading.finish();
  },
  computed: {
    Items() {
      console.log("tset");
      console.log("tset");
      console.log("tset");

      return this.$store.getters.infos;
    }
  },
  components: {
    "v-footer": Footer,
    "no-loop-swiper": noloopswiper,
    eachSuggest,
    Heads,
    ChatList
  }
};
</script>

<style scoped>
@import "../../../node_modules/font-awesome/css/font-awesome.min.css";
.container {
  margin-bottom: 1.30667rem;
}
.swiper-container img {
  width: 3.62667rem;
  height: 2.02667rem;
  border-radius: 0.10667rem;
}
.swiper-container .swiper-slide {
  margin-right: 0 !important;
}
.special-no-loop {
  background-color: #fff;
  padding: 0.26667rem 0.4rem;
  margin-bottom: 0.26667rem;
}
</style>
