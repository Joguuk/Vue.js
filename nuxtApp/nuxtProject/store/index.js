import Vue from 'vue'
import Vuex from 'vuex'

import state from './states.js'
import getters from './getters.js'
import mutations from './mutations.js'
import actions from './actions.js'

Vue.use(Vuex)

export default {mutations, state, getters, actions};

// export default new Vuex.Store({
//     state,
//     getters,
//     mutations,
//     actions
// })

// const createStore = () => {
//     return new Vuex.Store({
//         state,
//         getters,
//         mutations,
//         actions
//     })
//   }
  
//   export default createStore