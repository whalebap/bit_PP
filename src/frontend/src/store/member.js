import axios from 'axios'
import router from "vue-router";

const state = {
    context: 'http://localhost:3000/',
    fail : false,
    auth : false,
    member : {},
    message : ""
}

const actions = {
    async register({commit}, payload) {
        alert('액션 방문')
        const headers = {
            authorization: 'JWT fefege..',
            Accept: 'application/json',
            'Content-Type': 'application/json'
        }
        axios.post(`${state.context}members/join`, payload, headers)
            .then(({data}) => {
                alert('액션 방문')
                commit('JOIN', data)
            })
            .catch(() => {
                    alert('서버 통신 에러')
                }
            )
    },
    async login({commit}, payload) {
        alert('액션 방문')
        const headers = {
            authorization: 'JWT fefege..',
            Accept: 'application/json',
            'Content-Type': 'application/json'
        }
        axios.post(`${state.context}members/${payload.userId}/login`, payload, headers)
            .then(({data}) => {
                alert('액션 방문')
                if(data.result){
                    commit('LOGIN', data)
                    router.push('/myPage')
                } else {
                    commit('FAIL_COMMIT')
                }

            })
            .catch(() => {
                    alert('서버 통신 에러')
                    state.fail = true
                }
            )
    },
    async idCheck({commit}, payload){
        alert('액션방문')
        axios.get(`${state.context}members/${payload.userId}/idCheck`)
            .then(({data})=>{
                alert()
                commit('IDCHECK', data)
            })
            .catch(()=>{
            alert('서버통신 오류')
            })
    }
}

const mutations = {
    JOIN(state, data) {
        alert('뮤테이션 방문')
        state.message = data.message
    },
    LOGIN(state, data) {
        alert('뮤테이션 방문')
        state.auth = true
        state.member = data.member
        localStorage.setItem('token', data.token)
        localStorage.setItem('userId', data.userId)

    },
    FAIL_COMMIT(state){
        alert('뮤테이션 방문')
        state.fail = true
    },
    IDCHECK(state, data){
        alert('뮤테이션 방문')
        state.message = data
        alert(state.message)
        alert(data)
    }
}
const getters = {
   // member : state=>state.member,

}

export default {
    name: 'member',
    namespaced: true,
    state,
    actions,
    mutations,
    getters
}