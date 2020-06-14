import axios from "axios";


const state = {
    context : `http://localhost:3000/`
}
const actions = {
    async retriever({commit}){
        alert('액션 방문')
        axios.get(`${state.context}trails`)
            .then(({data})=>{
              alert('액션 내부 방문')
              commit('RETRIEVER')
                alert(data.count)
        })
            .catch(()=>{
                alert('서버 통신에러')
            })

    }
}
const mutations = {
    RETRIEVER(data, state){
        alert(data)
        alert(state.context)
    }
}
const getters = {}
export default {
    name : 'trail',
    namespaced : true,
    state, actions, mutations, getters
}