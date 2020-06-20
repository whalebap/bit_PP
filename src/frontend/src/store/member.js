import axios from 'axios'
import router from "../router";

const state = {
    context: 'http://localhost:3000/',
    fail : false,
    auth : false,
    member : {},
    message : ""
}

const actions = {
    async register({commit}, payload) {
        const headers = {
            authorization: 'JWT fefege..',
            Accept: 'application/json',
            'Content-Type': 'application/json'
        }
        axios.post(`${state.context}members/join`, payload, headers)
            .then(({data}) => {
                if(data.result){
                    console.log("회원가입 메시지"+data.message)
                    commit('JOIN', data)
                    console.log('성공')
                } else {
                    console.log(data.message)
                    console.log('실패')
                }
            })
            .catch(() => {
                console.log('서버 통신 에러')
                }
            )
    },
    async login({commit}, payload) {
        const headers = {
            authorization: 'JWT fefege..',
            Accept: 'application/json',
            'Content-Type': 'application/json'
        }
        axios.post(`${state.context}members/${payload.userId}/login`, payload, headers)
            .then(({data}) => {
                if(data.result){
                    commit('LOGIN', data)

                    alert('성공')
                } else {
                    commit('FAIL_COMMIT')
                    alert('실패')
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
                commit('IDCHECK', data)
            })
            .catch(()=>{
            alert('서버통신 오류')
            })
    },
    async updateInfo({commit}, payload){
        const headers = {
            authorization: 'JWT fefege..',
            Accept: 'application/json',
            'Content-Type': 'application/json'
        }
        console.log('업데이트 액션 방문')
        axios.post(`${state.context}members/${payload.userId}/update`, payload, headers)
            .then(({data})=> {
                commit('UPDATEINFO', data)
                console.log(data.message)
            })
            .catch(()=>{
                console.log('서버통신 실패')
            })
    },
    async deleteMember({commit}, payload){
        console.log('액션 도착')
        const headers = {
            authorization: 'JWT fefege..',
            Accept: 'application/json',
            'Content-Type': 'application/json'
        }
        axios.post(`${state.context}members/${payload.userId}/delete`, payload, headers)
            .then(({data})=> {
                commit('DELETEMEMBER', data)
                console.log(data.message)
            })
            .catch(()=>{
                console.log('서버통신 실패')
            })
    }
}

const mutations = {
    JOIN(state, data) {
        state.message = data.message
        console.log("뮤테이션 메세지"+state.message)
        router.push('/login')
    },
    LOGIN(state, data) {
        state.auth = true
        state.member = data.member
        localStorage.setItem('token', data.token)
        localStorage.setItem('userId', data.userId)
        alert('로그인 성공')
        router.push('/myPage')


    },
    FAIL_COMMIT(state){
        state.fail = true
        alert('잘못된 ID나 비밀번호입니다.')
    },
    IDCHECK(state, data){
        state.message = data.message
        alert(state.message)

    },
    UPDATEINFO(state, data){
        state.message = data.message
        console.log(state.message)
    },
    DELETEMEMBER(state, data){
        state.message = data.message
        console.log(state.message)
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