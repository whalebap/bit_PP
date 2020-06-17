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
                    :items="trails"
                    :search="search">
                <template>
                 <tr slot name="item" v-for="item in trails">
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
    import {mapState} from "vuex"
    export default {
        props : {





        }


,
        computed : {
            ...mapState({
                count : state =>state.trail.count,
                trails : state=>state.trail.trails
            }),

        },
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
    }}
</script>

<style scoped>

</style>