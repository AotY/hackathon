<template>
<div>
 <ul class="list clearfix">
          <li class="item" v-for="item in labels" :key="item.id">
            <div class="m-uMenuItem" to="self/mylist" title="item" >
              <i class="img u-icon u-icon-ulist" :style="{ 'background-image': 'url('+item.image+')'}"></i>
              <span class="txt" >{{item.keyword}}</span>
            </div>
          </li>
 </ul>
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
.g-row {
  width: 10rem;
  margin-right: auto;
  margin-left: auto;
}

.m-profile {
  height: 3.6rem;
  background-image: url(http://yanxuan.nosdn.127.net/6ae93353e95b3450a2710bb43f925a63.jpg);
  background-size: 100%;
  padding: 0 0.4rem;
  overflow: hidden;
}

.m-profile .g-row {
  display: -webkit-box;
  display: -webkit-flex;
  display: -moz-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
  -ms-flex-align: center;
  -webkit-align-items: center;
  -moz-align-items: center;
  align-items: center;
}

.m-profile .left {
  display: -webkit-box;
  display: -webkit-flex;
  display: -moz-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-flex-wrap: wrap;
  -moz-flex-wrap: wrap;
  -ms-flex-wrap: wrap;
  flex-wrap: wrap;
  -webkit-box-align: center;
  -ms-flex-align: center;
  -webkit-align-items: center;
  -moz-align-items: center;
  align-items: center;
  -webkit-box-pack: start;
  -ms-flex-pack: start;
  -webkit-justify-content: flex-start;
  -moz-justify-content: flex-start;
  justify-content: flex-start;
  padding: 0.85333rem 0;
  width: 7.2rem;
}

.m-profile .left .avatar {
  vertical-align: middle;
  width: 1.89333rem;
  height: 1.89333rem;
  border-radius: 50%;
}

.m-profile .left .info {
  -webkit-box-flex: 1;
  -webkit-flex: 1;
  -moz-box-flex: 1;
  -moz-flex: 1;
  -ms-flex: 1;
  flex: 1;
  margin-left: 0.4rem;
  line-height: 1;
  overflow: hidden;
}

.m-profile .left .info .nickname {
  color: #fff;
  font-size: 0.48rem;
  line-height: 1.2;
  text-align: left;
  margin-bottom: 0.13333rem;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}

.m-profile .left .info .membershipLevel span.memberTitle0 {
  color: #7f7f7f;
}

.m-profile .left .info .membershipLevel span {
  color: #b4a078;
  font-size: 0.37333rem;
  vertical-align: middle;
}
.m-uMenu {
  margin-bottom: 0.53333rem;
  background: #fff;
}
.m-uMenu .list {
  zoom: 1;
}
.m-uMenu .item {
  float: left;
  width: 33.33333%;
  border-right: 1px solid rgba(0, 0, 0, 0.15);
  border-bottom: 1px solid rgba(0, 0, 0, 0.15);
}
.m-uMenuItem {
  display: block;
  height: 2.4rem;
  padding: 0.1rem;
  text-align: center;
}
.m-uMenuItem .img {
  width: 100%;
  height: 80%;
  /* vertical-align: middle; */
  margin-bottom: 0.21333rem;
  display: block;
  margin: auto;
}
.u-icon-ulist {
  background-repeat: no-repeat;
  background-size: cover;
}
</style>
