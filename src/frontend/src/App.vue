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

        <v-list-item link @click="toMyPage">
          <v-list-item-action>
            <v-icon >mdi-microphone-variant</v-icon>
          </v-list-item-action>

          <v-list-item-content>
            <v-list-item-title>My Page</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item link @click="toTrail">
          <v-list-item-action>
            <v-icon >mdi-microphone-variant</v-icon>
          </v-list-item-action>

          <v-list-item-content>
            <v-list-item-title>Trails</v-list-item-title>
          </v-list-item-content>
        </v-list-item>


      </v-list>
    </v-navigation-drawer>

    <v-app-bar
            absolute
            app
            color="#8D6E63"
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
                       style="align-self: center; margin-right: fill; font-size: 2rem;">
        Walking in the Green</v-toolbar-title>

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
      toTrail(){
        this.$router.push('/trail')
      },
      toMyPage(){
        this.$router.push('/myPage')
      }

    }

  }
</script>
