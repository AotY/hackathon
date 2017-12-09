import * as types from '../types'
const state = {
  footList: [
        {id: 0, isActive: true, name: '首页', activeClass: 'u-icon-tabBar-index u-icon-tabBar-index-active', linkTo: '/'},
        {id: 1, isActive: false, name: '专题', activeClass: 'u-icon-tabBar-topic u-icon-tabBar-topic-active', linkTo: '/special'},
        {id: 4, isActive: false, name: '个人', activeClass: 'u-icon-tabBar-ucenter u-icon-tabBar-ucenter-active', linkTo: '/self'}
  ]
}
const actions = {
  changeActive ({commit}, id) {
    commit(types.CHANGE_ACTIVE, id)
  }
}
const getters = {
  footList: state => state.footList
}
const mutations = {
  [types.CHANGE_ACTIVE] (state, id) {
    state.footList.forEach(list => {
      list.isActive = false
    })
    state.footList[id].isActive = true
  }
}
export default {
  state,
  actions,
  getters,
  mutations
}
