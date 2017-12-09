<template>
  <div class="selfcenter">
    <header-bar v-if="!localUserInfo.loginStatus"></header-bar>
    <require-login v-if="!localUserInfo.loginStatus" :class="localUserInfo.loginStatus"></require-login>
    <show-info v-else></show-info>
    <router-view ></router-view>
    <!-- <div style=" height:480px; width:260px; overflow:hidden;">
<iframe scrolling="no" style="height:1200px; margin-top:-472px; width:1000px; margin-left:-733px;"
src="https://zhangbowei.github.io/codePen/example/calculate&flex.html"></iframe>
</div> -->
    <v-footer class="footer"></v-footer>
  </div>
</template>
<script>
import { mapGetters } from "vuex";
import Footer from "@/components/public/Footer";
import topBar from "@/components/public/HeaderBar";
import requireLogin from "./requireLogin";
import showInfo from "./showInfo";
export default {
  name: "index",
  data() {
    return {
      email: "",
      password: ""
    };
  },
  created() {
    this.$store.dispatch("changeActive", 4);
  },
  components: {
    "v-footer": Footer,
    "header-bar": topBar,
    "require-login": requireLogin,
    "show-info": showInfo
  },
  computed: mapGetters(["localUserInfo"])
};
</script>
<style scoped>
.selfcenter {
  background-color: #fff;
}
iframe {
  width: 100px;
  height: 100px;
}
</style>
