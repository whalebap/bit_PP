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
                    :footer-props="{
        showFirstLastPage: true,
        firstIcon: 'mdi-arrow-collapse-left',
        lastIcon: 'mdi-arrow-collapse-right',
        prevIcon: 'mdi-minus',
        nextIcon: 'mdi-plus'
      }"

            >

                <template v-slot:expanded-item="{ headers, item }">
                    <td :colspan="12">{{ item.detail }}</td>
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
            })},

            data() {
                return {
                    course : 'courseName',

                    search: '',
                    singleExpand: false,
                    expanded: [],
                    headers: [
                        {text: '걷는 길 명칭', align: 'start',
                            sortable: false, value: 'trailName'},
                        {text: '코스명', sortable: false, value: 'courseName'},
                        {text: '코스설명', sortable: false, value: 'route'},
                        {text: '지역', value: 'location'},
                        {text: '난이도', value: 'difficulty'},
                        {text: '거리', value: 'distance'},
                        {text: '상세거리(km)', value: 'detailDistance'},
                        {text: '소요시간', value: 'timeRequired'},
                    ],
                }
            },

    }
</script>
