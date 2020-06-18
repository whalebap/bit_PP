<template>
    <div>
        <button @click="findList">
            목록 보기
        </button>
        <v-card>
            <v-card-title>
                전국 트레일 코스 {{count}}
                <v-spacer></v-spacer>
                <v-text-field
                        v-model="search"
                        append-icon="mdi-magnify"
                        label="Search"
                        single-line
                        hide-details
                ></v-text-field>
            </v-card-title>
            <v-data-table
                    :headers="headers"
                    :items="this.trails"
                    :search="search">
                <template>

                        <tr slot="items"
                            v-for="item in this.trails" :key="item.trailName">
                            <td>{{item.trailName}}</td>
                            <td>{{item.courseName}}</td>
                            <td>{{item.route}}</td>
                            <td>{{item.location}}</td>
                            <td>{{item.difficulty}}</td>
                            <td>{{item.distance}}</td>
                            <td>{{item.detail}}</td>
                            <td>{{item.timeRequired}}</td>
                        </tr>


                </template>
            </v-data-table>
        </v-card>
    </div>
</template>

<script>
    import TrailListItem from "./TrailListItem";
    import axios from "axios";



    export default {


/*        computed : {
            ...mapState({
                count : state =>state.trail.count,
                trails : state=>state.trail.trails
            }),

        }*/
        data () {
            return {
                search: '',
                headers: [
                    {
                        text: 'Dessert (100g serving)',
                        align: 'start',
                        sortable: false,
                        value: 'name',
                    },
                    { text: 'Calories', value: 'calories' },
                    { text: 'Fat (g)', value: 'fat' },
                    { text: 'Carbs (g)', value: 'carbs' },
                    { text: 'Protein (g)', value: 'protein' },
                    { text: 'Iron (%)', value: 'iron' },
                ],

            }
    },
    methods : {
        findList(){
            alert('찾기 버튼 클릭')
            this.$store.dispatch('trail/retriever')
        }
    },

    created() {

            const trails = []

            axios.get(`${this.$store.state.member.context}trails/list`)
                .then(({data})=>{
                    alert('액션 내부 방문')
                    alert("총 코스 수 in 액션"+data.count)
                    data.list.forEach(item=>{trails.push(item)})
                    console.log('trails'+trails)
                })

                .catch(()=>{
                    alert('서버 통신에러')
                })
    }


    }

</script>

<style scoped>

</style>