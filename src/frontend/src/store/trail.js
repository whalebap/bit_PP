import axios from "axios";


const state = {
    context : `http://localhost:3000/`,
    trails : [],
    count :0

}
const actions = {
    async retriever({commit}){
        axios.get(`${state.context}trails/list`)
            .then(({data})=>{
              console.log('액션 내부 방문')
              console.log("총 코스 수 in 액션"+data.count)
              commit('RETRIEVER', data)

        })
            .catch(()=>{
                alert('서버 통신에러')
            })

    }
}
const mutations = {
    RETRIEVER(state,data){
        alert("총 코스 수 : "+data.count)
        state.list = [];
        state.count = data.count;
        data.list.forEach(item=>{
            state.trails.push({
                trailName : item.trailName,
                courseName : item.courseName,
                route : item.route,
                location : item.location,
                difficulty : item.difficulty,
                distance : item.distance,
                detailDistance : item.detailDistance,
                detail : item.detail,
                timeRequired : item.timeRequired
            })
        })
    }
}
const getters = {
    count : state => state.count,
    trails : state => state.trails,
}
export default {
    name : 'trail',
    namespaced : true,
    state, actions, mutations, getters
}