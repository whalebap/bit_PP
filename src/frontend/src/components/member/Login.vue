


<template>
    <div>
        <v-container fluid>
            <v-form
                    ref="form"
                    v-model="valid"
                    :lazy-validation="lazy"
            >
                <v-text-field
                        :label="labelId"
                        :clearable="clearable"
                ></v-text-field>
                <v-text-field
                        :label="labelPassword"
                        :clearable="clearable"
                ></v-text-field>
                <div class="text-center">
                    <v-btn rounded color="primary" dark large>로그인</v-btn>
                    <v-btn rounded color="warning" dark large>취소</v-btn>
                </div>
            </v-form>
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
        })}

</script>

<style scoped>

</style>