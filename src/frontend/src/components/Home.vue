<template>
    <v-container
            class="fill-height"
            fluid
    >
        <v-carousel>
            <v-carousel-item
                    v-for="(item,i) in items"
                    :key="i"
                    :src="item.src"
                    reverse-transition="fade-transition"
                    transition="fade-transition"
                    cycle="cycle"
            ></v-carousel-item>
        </v-carousel>


    </v-container>
</template>

<script>
    export default {
        props: {
            source: String,
        },
        data: () => ({
                drawer: null,
                cycle : true,
                items: [
                    {
                        src: 'https://images.unsplash.com/photo-1575600749331-6d13fdfe5323?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80',
                    },
                    {
                        src: 'https://images.unsplash.com/photo-1464131878849-80cd5cd9055a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1013&q=80',
                    },
                    {
                        src: 'https://images.unsplash.com/photo-1590645127205-398d600e1288?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80',
                    },
                    {
                        src: 'https://images.unsplash.com/reserve/O7A9fAvYSXC7NTdz8gLQ_IMGP1039.jpg?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1053&q=80',
                    },
                ],
            }

        )
    }
</script>

<style scoped>

</style>