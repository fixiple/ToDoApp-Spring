<template>
    <div class="register">
      <h1>This is an register page</h1>
    </div>
    <div>
        <form>
            <input type="text" placeholder="Lonk123" v-model="username"/>
            <br>
            <input type="password" v-model="password1"/>
            <span class="svg-span"></span>
            <br/>
            <input type="password" v-model="password2"/>
            <br/>
            <input type="Button" value="Sign up" @click="signup"/>
        </form>
    </div>
</template>

<script>
    export default {
        data() {
            return{
                username : '',
                password1: '',
                password2: ''
            };
        },
        components: {
            
        },
        methods: {
            signup() {
                alert("Hi " + this.username + this.password1 + this.password2);
            }  
        },
    }
</script>

<style scoped>
    .svg-span{
        background: none;
        border: none;
        background-image: url("../assets/openeye.svg");
        background-size: 25px;
        cursor: pointer;
    }

</style>