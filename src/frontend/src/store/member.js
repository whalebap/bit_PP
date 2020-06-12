import axios from 'axios'

const state = {
    context: 'http://localhost:3000'
}

const actions = {
    async register({commit}, payload) {
        alert('액션 방문')
        const headers = {
            authorization: 'JWT fefege..',
            Accept: 'application/json',
            'Content-Type': 'application/json'
        }
        axios.post(`${state.context}/members/join`, payload, headers)
            .then(({data}) => {
                alert('액션 방문')
                alert(data.userid)
                commit('JOIN')
            })
            .catch(() => {
                    alert('서버 통신 에러')
                }
            )
    }
}

const mutations = {
    JOIN(state, data) {
        alert('뮤테이션 방문')
        alert(state.context)
        alert(data)
    }
}
const getters = {}

export default {
    name: 'member',
    namespaced: true,
    state,
    actions,
    mutations,
    getters
}