<template>
<div>
<div v-for="item in labels" :key="item">
  {{item}}
</div>
</div>
</template>

<script>
/**
 * 1.tabs，容纳数据，捕捉被点击 选项
 */
export default {
  props: ["labels"],
  data() {
    return {};
  },
  methods: {}

};
</script>

<style scoped>

</style>
