<template>
<div>
    <tr v-for="item in trails" :key="item.trailName">
        <td>{{item.trailName}}</td>
        <td>{{item.courseName}}</td>
        <td>{{item.route}}</td>
        <td>{{item.location}}</td>
        <td>{{item.difficulty}}</td>
        <td>{{item.distance}}</td>
        <td>{{item.detail}}</td>
        <td>{{item.timeRequired}}</td>
    </tr>
</div>
</template>

<script>
    import {mapState} from "vuex";

    export default {
        name: "TrailListItem",



        props: {
            item: {
                type: Object,
                required: true
            }
        },
        computed: {
            ...mapState({
                count: state => state.trail.count,
                trails: state => state.trail.trails
            }),

        }
    }
</script>

<style scoped>

</style>