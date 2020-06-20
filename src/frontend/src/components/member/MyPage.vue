<template>
    <div>
        <v-container fluid>

            <v-text-field
                    :value="member.userId"
                    label="ID"
                    filled
                    readonly
            ></v-text-field>
            <v-text-field
                    :label="labelPassword"
                    :hint="hintPassword"
                    :clearable="clearable"
                    :counter="counterEn ? counterPassword : false"
                    v-model="password"
            ></v-text-field>
            <v-text-field
                    :value="member.userName"
                    label="NAME"
                    filled
                    readonly

            ></v-text-field>
            <v-text-field
                    :label="labelEmail"
                    :clearable="clearable"
                    v-model="email"

            ></v-text-field>
            <div class="text-center">
                <v-btn rounded color="primary" dark large
                       @click="updateInfo">회원정보 수정</v-btn>
                <v-btn rounded color="warning" dark large
                       @click="deleteUser">회원탈퇴</v-btn>
                <v-btn rounded color="warning" dark large
                       @click="cancel">취소</v-btn>

            </div>
        </v-container>
    </div>
</template>

<script>
    import {mapState} from "vuex";
    import router from "../../router";


    export default {
        computed : {
            ...mapState({
                member : state =>state.member.member
            })
        },
        methods : {
            updateInfo(){
                this.$store.dispatch('member/updateInfo', {userId : this.$store.state.member.member.userId, password : this.password, email : this.email})
            },
            deleteUser(){
                console.log('회원탈퇴시작')
                this.$store.dispatch('member/deleteMember', {userId : this.$store.state.member.member.userId, password : this.$store.state.member.member.password})
                            },
            cancel(){
                alert('취소')
                router.push('/')
            }
        },

        data: () => ({
            labelPassword : 'PASSWORD',
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
            email:''

        })}
</script>

<style scoped>

</style>