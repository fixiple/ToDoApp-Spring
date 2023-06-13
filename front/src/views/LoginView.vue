<template>
    <div class="login">
      <h1>This is an Login page</h1>
    </div>
    <div>
        <form>
            <input type="text" placeHolder="Nana"/>
            <input type="password" />
            <input type="Button" value="Sign in" @click="login"/>
        </form>
    </div>
</template>

<script>
    export default {

        methods: {
            login() {
                alert("Hi")
            }  
        },
    }
</script>

<style>

</style>