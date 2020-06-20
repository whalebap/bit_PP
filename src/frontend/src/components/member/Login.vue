


<template>
    <div>
        <v-container fluid>
            <v-row
                    no-gutters
            >
                <v-col
                        :cols="8"
                >
                    <v-card
                            class="pa-2"
                            outlined
                            shaped

                    >

                        <v-form
                                ref="form"
                                v-model="valid"
                        >
                            <v-text-field
                                    :label="labelId"
                                    :clearable="clearable"
                                    v-model="userId"
                            ></v-text-field>
                            <v-text-field
                                    :label="labelPassword"
                                    :clearable="clearable"
                                    v-model="password"
                            ></v-text-field>
                            <div class="text-center">
                                <v-btn rounded color="primary" dark large @click="login">로그인</v-btn>
                                <v-btn rounded color="warning" dark large>취소</v-btn>
                            </div>
                        </v-form>

                    </v-card>
                </v-col>
            </v-row>

        </v-container>
    </div>
</template>

<script>
    export default {
        data: () => ({
            valid: true,
            labelId: 'ID',
            labelPassword : 'PASSWORD',
            clearable: true,
            counterEn: true,
            userId:'',
            password:''
        }),
        methods : {
            login() {
                alert('로그인'+this.userId)
                this.$store.dispatch(`member/login`, {userId:this.userId, password:this.password})
            },
        }

    }

</script>

<style scoped>

</style>