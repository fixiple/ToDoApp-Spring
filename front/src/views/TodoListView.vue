<template>
  <div>
    <h1>Instructor Application</h1>
    <ListTodoComponent/>
  </div>
</template>
<script>
  import ListTodoComponent from "../components/ListTodoComponent.vue";
    export default {
        name: "TodoList",
        components:{
            ListTodoComponent
        }

    };
</script>
<style>
</style>