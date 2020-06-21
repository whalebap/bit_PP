<template>
    <v-app id="inspire">
        <v-app-bar
                absolute
                app
                color="#33691E"
                src="https://images.unsplash.com/photo-1487956382158-bb926046304a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1351&q=80"
                dark
                prominent
        >
            <template v-slot:img="{ props }">
                <v-img
                        v-bind="props"
                        position="center"
                        gradient="to top right, rgba(19,84,122,.5), rgba(128,208,199,.8)"
                ></v-img>
            </template>

            <v-spacer></v-spacer>

            <v-toolbar-title @click="toHome"
                             style="font-size: 2.5rem;">
                        Walking in the Green
            </v-toolbar-title>
            <v-spacer></v-spacer>
            <div v-if="auth">
                <v-btn icon @click="toLogin">
                    <v-icon>mdi-account-arrow-right</v-icon>
                </v-btn>
                <v-btn icon @click="toLogout">
                    <v-icon>mdi-logout-variant</v-icon>
                </v-btn>
            </div>

            <div v-if="!auth">
                <v-btn icon @click="toJoin">
                    <v-icon>mdi-account-plus</v-icon>
                </v-btn>

                <v-btn icon @click="toLogin">
                    <v-icon>mdi-account-arrow-right</v-icon>
                </v-btn>
            </div>

            <template v-slot:extension>
                <v-tabs align-with-title>
                    <v-tab @click="toHome">Home</v-tab>
                    <v-tab @click="toMyPage">My Page</v-tab>
                    <v-tab @click="toTrail">Trails</v-tab>
                </v-tabs>
            </template>
        </v-app-bar>


        <v-main>
            <router-view></router-view>
        </v-main>

        <v-footer
                color="#33691E"
                app
        >
            <v-spacer></v-spacer>
            <span class="white--text">&copy; 2020.06</span>
        </v-footer>
    </v-app>
</template>

<script>


    import {mapState} from "vuex";

    export default {
        computed : {
            ...mapState({
                    auth : state => state.member.auth
            }
            )
        },
        props: {
            source: String,
        },
        data: () => ({
            drawer: null,
        }),
        methods: {
            toHome() {
                this.$router.push('/')

            },
            toJoin() {
                this.$router.push('/join')
            },
            toLogin() {
                this.$router.push('/login')
            },
            toTrail() {
                this.$router.push('/trail')
            },
            toMyPage() {
                if (!this.$store.state.member.auth) {
                    alert('로그인이 필요합니다')
                } else {
                    this.$router.push('/myPage')
                }

            },
            toLogout() {
                this.$store.dispatch('member/logout')
            }

        }

    }
</script>
