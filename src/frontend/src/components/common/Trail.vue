<template>
    <div>
        <v-card>
            <v-card-title>
                전국 걷기길 코스
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
            ></v-data-table>
        </v-card>
    </div>
</template>

<script>
    import {mapState} from "vuex";
    0
    export default {
        created() {
            this.$store.dispatch('trail/retriever')
        },

        computed: {
            ...mapState({
                count: state => state.trail.count,
                trails: state => state.trail.trails
            }),

            data() {
                return {
                    search: '',
                    headers: [
                        {text: 'trailName', value: 'trailName'},
                        {text: 'courseName', value: 'courseName'},
                        {text: 'route', value: 'route'},
                        {text: 'location', value: 'location'},
                        {text: 'difficulty', value: 'difficulty'},
                        {text: 'distance', value: 'distance'},
                        {text: 'detailDistance', value: 'detailDistance'},
                        {text: 'detail', value: 'detail'},
                        {text: 'timeRequired', value: 'timeRequired'},
                    ],
                }
            },
        }
    }
</script>
