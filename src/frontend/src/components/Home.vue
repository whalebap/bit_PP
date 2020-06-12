<template>
    <v-container
            class="fill-height"
            fluid
    >
       <h1>여긴 어디니</h1>


    </v-container>
</template>

<script>

    export default {
        props: {
            source: String,
        },
        data: () => ({
            drawer: null,
        }),
    }
</script>

<style scoped>

</style>