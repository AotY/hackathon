<template>
  <div>
  <div class="slideWarp">
  <swiper :options="swiperOption">
      <swiper-slide v-for="slide in bannerList" :key="slide.id">
        <img :src="slide.src" alt="" class="picture">
        <header class="state">
         <span>{{slide.value}}</span>
        </header>
      </swiper-slide>
    <!-- Optional controls -->
    <div class="swiper-pagination"  slot="pagination"></div>
    <div class="swiper-scrollbar"   slot="scrollbar"></div>
  </swiper>

  </div>
  <deal-promise></deal-promise>

  <div class="m-indexFloor">
     <div class="m-indexManufacturersSupplying">
       <index-cards :cards="cards"></index-cards>
     </div>
 </div>
 <!-- <div class="new-fast">
   <header class="hd">
     <router-link to="newfast" class="more">
       <span>周一周四 · 新品首发</span>
       <div class="all" >
         <span >查看全部</span>
         <i class="arrow-right" ></i>
        </div>
     </router-link>

   </header>
   <ul>
  <no-loop-swiper :Items="newItems" class="recommend-no-loop"></no-loop-swiper>
   </ul>
 </div>
 <div class="peoplehot">
   <div class="hottitle">
     <div>
      人气推荐<i data-v-1bc3f80e="" class="arrow-right"></i>
     </div>
   </div>
   <cell></cell>
   <cell></cell>

 </div>
 <goods-grid>

 </goods-grid> -->
 <div>
 </div>
</div>
</template>

<script>
// import { Indicator } from 'mint-ui'
import "swiper/dist/css/swiper.css";
import { swiper, swiperSlide } from "vue-awesome-swiper";
import goodsGrid from "../../components/public/GoodsGrid";
import noLoopSwiper from "@/components/public/NoLoopSwiper";
import dealPromise from "@/components/public/DealPromise";
import cell from "@/components/public/cell";
import { Indicator } from "mint-ui";
import indexCards from "@/components/public/Cards";

export default {
  data() {
    return {
      swiperOption: {
        spaceBetween: 30,
        centeredSlides: true,
        autoplay: {
          delay: 2500,
          disableOnInteraction: false
        },
        pagination: {
          el: ".swiper-pagination",
          clickable: true
        }
      },
      newItems: [
        {
          id: 0,
          name: "男式飞织运动休闲鞋",
          desc: "“赤足”的轻松与透气",
          price: 199,
          src:
            "http://yanxuan.nosdn.127.net/872b0a5df602e9b12e5ac14da518b079.png?imageView&quality=85&thumbnail=330x330"
        },
        {
          id: 1,
          name: "微电流滚轮身体按摩仪",
          desc: "瘦脸瘦身 提拉紧致",
          price: 189,
          src:
            "http://yanxuan.nosdn.127.net/9aa07a291c8e2c6f97e2f9d0ce2ba7c5.png?imageView&quality=85&thumbnail=330x330"
        },
        {
          id: 2,
          name: "空蓝经典飞行员墨镜",
          desc: "经典飞行员款式，偏光镜片",
          price: 109,
          src:
            "http://yanxuan.nosdn.127.net/8957b56358c3f21dbbf6cb42004ae006.png?imageView&quality=85&thumbnail=330x330"
        },
        {
          id: 3,
          name: "光面羊皮蛋卷鞋",
          desc: "头层羊皮，优雅芭蕾舞鞋",
          price: 109,
          src:
            "http://yanxuan.nosdn.127.net/45526f7ceba0c8e228b4713b3c8257a1.png?imageView&quality=85&thumbnail=330x330"
        },
        {
          id: 4,
          name: "小龙虾 4-6钱/只 净虾850克",
          desc: "好水好虾，鲜香弹润",
          price: 109,
          src:
            "http://yanxuan.nosdn.127.net/a2cf3b86ecfd35b2d270cd17ff264cbd.png?imageView&quality=85&thumbnail=330x330"
        },
        {
          id: 5,
          name: "日系拉菲草女式草帽",
          desc: "Gucci制造商，纯天然拉菲草",
          price: 109,
          src:
            "http://yanxuan.nosdn.127.net/3e36a2cd8aad7f30a1f6334aaefe6808.png?imageView&quality=85&thumbnail=330x330"
        },
        {
          id: 6,
          name: "负离子可折叠便携吹风机",
          desc: "高浓度负离子，2档3温",
          price: 109,
          src:
            "http://yanxuan.nosdn.127.net/6fb9df8c630938288012ffdeefdf92c9.png?imageView&quality=85&thumbnail=330x330"
        },
        {
          id: 7,
          name: "格纹棉质短袖衬衫（婴童）",
          desc: "经典格纹风 时尚又百搭",
          price: 109,
          src:
            "http://yanxuan.nosdn.127.net/9c07042b213a1fa3f609a4d08ae5680d.png?imageView&quality=85&thumbnail=330x330"
        },
        {
          id: 8,
          name: "空蓝经典飞行员墨镜",
          desc: "经典飞行员款式，偏光镜片",
          price: 109,
          src:
            "http://yanxuan.nosdn.127.net/8957b56358c3f21dbbf6cb42004ae006.png?imageView&quality=85&thumbnail=330x330"
        }
      ],
      newItemsOption: {
        slidesPerView: 3,
        spaceBetween: 20
      }
    };
  },
  computed: {
    bannerList() {
      return this.$store.getters.infos;
    },
    cards() {
      return this.$store.getters.cards;
    }
  },
  beforeCreate() {},
  created() {
    Indicator.open("加载中...");
    this.$store.dispatch("getInfos", "carousel.do");
    this.$store.dispatch("changeHeadertabActive", 0);
    this.$store.dispatch("getCards", "recommend_daodao.do");
  },
  mounted() {},
  components: {
    swiper,
    swiperSlide,
    goodsGrid,
    noLoopSwiper,
    dealPromise,
    cell,
    indexCards
  }
};
</script>

<style lang="css" scoped>
@import "../../assets/style/home.css";
.picture {
  width: 100%;
  height: 260px;
}
.state {
    display: flex;
    flex-flow: row nowrap;
    align-items: top;
    justify-content: center;
    height: 1.46667rem;
    font-size: .42667rem;
}
</style>
