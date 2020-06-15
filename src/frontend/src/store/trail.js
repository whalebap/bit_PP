import axios from "axios";


const state = {
    context : `http://localhost:3000/`,
    list : [],
    trail : {},
    count : 0

}
const actions = {
    async retriever({commit}){
        axios.get(`${state.context}trails`)
            .then(({data})=>{
              alert('액션 내부 방문')
              commit('RETRIEVER', data)
        })
            .catch(()=>{
                alert('서버 통신에러')
            })

    }
}
const mutations = {
    RETRIEVER(data, state){
        alert("총 코스 수 : "+data.count)
        state.list = [];
        state.count = data.count;
        data.list.forEach(item=>{
            state.trail.push({
                trailName : item.trailName,
                courseName : item.courseName,
                route : item.route,
                location : item.location,
                difficulty : item.difficulty,
                distance : item.distance,
                detail : item.detail,
                timeRequired : item.timeRequired
            })
        })
    }
}
const getters = {
    list : state => state.list,
    count : state => state.count,
}
export default {
    name : 'trail',
    namespaced : true,
    state, actions, mutations, getters
}