<template>
    <div>

        <v-card>
            <v-card-title>
                전국 산책길 경로
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
                    :search="search"
                    show-expand
                    :single-expand="singleExpand"
                    :expanded.sync="expanded"
                    :item-key="course"
                    multi-sort
                    :sort-desc="[false, true]"
                    :footer-props="{
        showFirstLastPage: true,
        firstIcon: 'mdi-arrow-collapse-left',
        lastIcon: 'mdi-arrow-collapse-right',
        prevIcon: 'mdi-minus',
        nextIcon: 'mdi-plus'
      }"

            >

                <template v-slot:expanded-item="{ headers, item }">
                    <td :colspan="12">코스 설명 : {{ item.route }}
                        <v-divider light
                        ></v-divider>
                        소개 : {{ item.detail }}</td>
                </template>
                <template v-slot:item.difficulty="{ item }">
                    <v-chip :color="getColor(item.difficulty)" dark>{{ item.difficulty }}</v-chip>

                </template>


            </v-data-table>

        </v-card>
    </div>
</template>

<script>
    import {mapState} from "vuex";



    export default {


        mounted() {
            this.$store.dispatch('trail/retriever')
        },

        computed: {
            ...mapState({
                count: state => state.trail.count,
                trails: state => state.trail.trails
            })
        },

        data() {
            return {
                course: 'courseName',

                search: '',
                singleExpand: false,
                expanded: [],
                headers: [
                    {
                        text: '걷는 길 명칭', align: 'center',
                        sortable: false, value: 'trailName'
                    },
                    {text: '코스명', sortable: false, align: 'center', value: 'courseName'},
                    {text: '지역', align: 'center', value: 'location'},
                    {text: '난이도', align: 'center', value: 'difficulty'},
                    {text: '거리', align: 'center', value: 'distance'},
                    {text: '상세거리(km)', align: 'center', value: 'detailDistance'},
                    {text: '소요시간', align: 'center', width: 150, value: 'timeRequired'},
                ],
            }
        },
        methods: {

            getColor(difficulty) {
                if (difficulty === `어려움`)  return 'orange'
                    else if(difficulty === `매우어려움`) return 'red'
                else if (difficulty === '보통') return 'gray'
                    else if(difficulty === '쉬움') return 'green'
                else return 'blue'},


            }


    }
</script>
