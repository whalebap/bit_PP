<template>
    <div>
        <v-container fluid>
            <v-row
                    no-gutters
                    :justify="justify"
            >
                <v-col
                        :cols="5"
                >
                    <v-card
                            class="pa-2"
                            outlined
                            shaped
                    >
                        <v-form>



                        <v-text-field
                                :label="labelId"
                                :hint="hintId"
                                :clearable="clearable"
                                :counter="counterEn ? counterId : false"
                                v-model="userId"
                        >
                        </v-text-field>
                        <v-btn dark @click="idCheck">ID 중복 체크</v-btn>
                        <v-snackbar
                                v-model="snackbar"
                        >
                            {{ text }}

                            <template v-slot:action="{ attrs }">
                                <v-btn
                                        color="pink"
                                        text
                                        v-bind="attrs"
                                        @click="snackbar = false"

                                >
                                    Close
                                </v-btn>
                            </template>
                        </v-snackbar>
                        <v-text-field
                                :label="labelPassword"
                                :hint="hintPassword"
                                :clearable="clearable"
                                :counter="counterEn ? counterPassword : false"
                                v-model="password"


                        ></v-text-field>
                        <v-text-field
                                :label="labelTwicePassword"
                                :clearable="clearable"

                                :counter="counterEn ? counterPassword : false"
                                v-model="twicePassword"

                        ></v-text-field>

                        <v-text-field
                                :label="labelName"
                                :clearable="clearable"
                                v-model="userName"

                        ></v-text-field>
                        <v-text-field
                                :label="labelEmail"
                                :clearable="clearable"
                                v-model="email"

                        ></v-text-field>
                        <div class="text-center">
                            <v-btn rounded color="primary" dark large
                                   @click="register">회원가입
                            </v-btn>
                            <v-btn rounded color="warning" dark large
                                   @click="cancel">취소
                            </v-btn>
                        </div>
                        </v-form>
                    </v-card>
                </v-col>
            </v-row>


        </v-container>
    </div>
</template>

<script>


    import {mapState} from "vuex";

    export default {
        computed : {
            ...mapState({
                text: state => state.member.message,
            })
        },

        methods: {
            register() {
                alert('회원가입 클릭' + this.userId)
                this.$store.dispatch(`member/register`, {
                    userId: this.userId,
                    password: this.password,
                    userName: this.userName,
                    email: this.email
                })

            },

            cancel() {
                alert('회원 가입 취소')
                this.$router.push('/')
            },
            idCheck() {
                this.snackbar = true
                this.$store.dispatch('member/idCheck', {userId: this.userId})
            }
        },
        data: () => ({
            snackbar: false,
            justify : 'center',
            labelId: 'ID',
            labelPassword: 'PASSWORD',
            labelTwicePassword: 'CONFIRM PASSWORD',
            labelEmail: 'E-MAIL',
            labelName: 'NAME',
            hintId: '5~15자, 대소문자 구분',
            hintPassword: '8~20자, 영문/숫자/특수기호 중 택2',
            clearable: true,
            counterEn: true,
            counterId: 15,
            counterPassword: 20,
            userId: '',
            password: '',
            userName: '',
            email: '',
            twicePassword: '',



        })
    }
</script>

<style scoped>

</style>
