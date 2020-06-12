<template>
  <v-app id="inspire">
    <v-navigation-drawer
            v-model="drawer"
            app
            right
            prominent
    >
      <v-list dense>
        <v-list-item link @click="toHome">
          <v-list-item-action >
            <v-icon >mdi-home</v-icon>
          </v-list-item-action>

          <v-list-item-content>
            <v-list-item-title >Home</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item link @click="toJoin">
          <v-list-item-action>
            <v-icon >mdi-account-arrow-right</v-icon>
          </v-list-item-action>

          <v-list-item-content>
            <v-list-item-title >Join</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item link @click="toLogin">
          <v-list-item-action >
            <v-icon >mdi-account-circle</v-icon>
          </v-list-item-action>

          <v-list-item-content>
            <v-list-item-title>Login</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item link @click="toNoraeBang">
          <v-list-item-action>
            <v-icon >mdi-microphone-variant</v-icon>
          </v-list-item-action>

          <v-list-item-content>
            <v-list-item-title>NoraeBang</v-list-item-title>
          </v-list-item-content>
        </v-list-item>


      </v-list>
    </v-navigation-drawer>

    <v-app-bar
            absolute
            app
            color="#8D6E63"
            src="https://images.unsplash.com/photo-1511671782779-c97d3d27a1d4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80"
            dark
            prominent

    >
      <template v-slot:img="{ props }">
        <v-img
                v-bind="props"
                gradient="to top right, rgba(19,84,122,.5), rgba(128,208,199,.8)"
        ></v-img>
      </template>
      <v-spacer></v-spacer>

      <v-toolbar-title @click="toHome"
                       style="align-self: center; margin-right: fill; font-size: 2rem; font-family : 'Song Myung'">
        노래방에서</v-toolbar-title>

      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
    </v-app-bar>


    <v-main>
      <router-view></router-view>
    </v-main>

    <v-footer
            color="#8D6E63"
            app
    >
      <v-spacer></v-spacer>

      <span class="white--text">&copy; 2020.06</span>
    </v-footer>
  </v-app>
</template>

<script>


  export default {
    props: {
      source: String,
    },
    data: () => ({
      drawer: null,
    }),
    methods : {
      toHome(){
        this.$router.push('/')

      },
      toJoin(){
        this.$router.push('/join')
      },
      toLogin(){
        this.$router.push('/login')
      },
      toNoraeBang(){
        this.$router.push('/karaoke')
      }

    }

  }
</script>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Song+Myung&display=swap');
</style>