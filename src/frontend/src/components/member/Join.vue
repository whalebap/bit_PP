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

                            <v-text-field
                                    :label="labelId"
                                    :hint="hintId"
                                    :clearable="clearable"
                                    :counter="counterEn ? counterId : false"
                                    v-model="userId"

                            ></v-text-field>
                            <v-btn class="mx-2" fab dark small color="primary">
                                <v-icon dark @click="idCheck">small-check</v-icon>
                            </v-btn>


                        <v-text-field
                                :label="labelPassword"
                                :hint="hintPassword"
                                :clearable="clearable"
                                :counter="counterEn ? counterPassword : false"
                                v-model="password"
                        ></v-text-field>
                        <v-text-field
                                :label="labelTwicePassword"
                                :hint="hintPassword"
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
                                   @click="register">회원가입</v-btn>
                            <v-btn rounded color="warning" dark large
                                   @click="cancel">취소</v-btn>
                        </div>
                    </v-card>
                </v-col>
            </v-row>


        </v-container>
    </div>
</template>

<script>


    export default {

        methods : {
            register() {
                alert('회원가입 클릭'+this.userId)
                this.$store.dispatch(`member/register`, {userId:this.userId, password:this.password, userName:this.userName, email:this.email})
                alert(this.message)
            },

            cancel(){
                alert('회원 가입 취소')
                this.$router.push('/')
            },
            idCheck(){
                this.$store.dispatch('member/idCheck', {userId:this.userId})
            }
        },
        data: () => ({
            labelId: 'ID',
            labelPassword : 'PASSWORD',
            labelTwicePassword : 'CONFIRM PASSWORD',
            labelEmail : 'E-MAIL',
            labelName : 'Name',
            hintId: '5~15자, 대소문자 구분',
            hintPassword : '8~20자, 영문/숫자/특수기호 중 택2',
            clearable: true,
            counterEn: true,
            counterId: 15,
            counterPassword : 20,
            userId:'',
            password:'',
            userName:'',
            email:'',
            twicePassword:''


        })}
</script>

<style scoped>

</style>
