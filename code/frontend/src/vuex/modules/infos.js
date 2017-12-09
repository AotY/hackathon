import { Indicator } from 'mint-ui'
import * as types from '../types'
import data from '@/fetch/api'

const state = {
  infos: []
}
const actions = {
  getInfos({ commit }, type) {
    console.log('type', type)
    data.getTypeDesc(type).then(res => {
      console.log('type data:', res)
      Indicator.close()
      commit(types.SET_INFOS, res)
    })
  }
}

const mutations = {
  [types.SET_INFOS](state, res) {
    const baseUrl = res.data.imageHost;
    const adapter = {
      src: 'image',
      id: 'id'
    };

    state.infos = res.data.carousels.map(function (item) {
      const value = {};
      item.image = baseUrl + item.image;
      Object.keys(adapter).forEach(function (key) {
        const alias = adapter[key];
        value[key] = item[alias];
      });
      return value;
    });
  }
}
const getters = {
  infos: state => state.infos
}
export default {
  state,
  actions,
  getters,
  mutations
}
