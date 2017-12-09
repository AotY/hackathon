import { Indicator } from 'mint-ui'
import * as types from '../types'
import data from '@/fetch/api'

const state = {
  infos: {}
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
    state.infos = res
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
