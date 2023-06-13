<template>
    <div class="container">
      <h3>Update</h3>
      <form method="POST" @submit.prevent="addTodo">
        <label for="title">Title</label>
        <input type="text" name="title" v-model="formData.title" placeHolder="Eat a banana"/>
        <label for="description">Description</label>
        <input type="text" name="description" v-model="formData.description" placeHolder="add some details....."/>
        <label for="finished">Done?</label>
        <input type="checkbox" name="finished" v-model="formData.finished"/>
        <input type="submit" value="Add"/>
      </form>
    </div>
</template>
<script>
    import TodoDataService from '../service/TodoDataService';
    export default {
        name: 'ModifyTodoView',
        data() {
            return {
                formData: {
                    title: this.title,
                    description: this.description,
                    finished: (this.finished ? true : false) 
                }
            }
        },
        methods: {
            modifyTodo() {
                //console.log(this.title ,"+",this.description,"+",this.finished)
                TodoDataService.modifyOneTodo(
                    this.formData.title,
                    this.formData.description, 
                    this.formData.finished
                ).then(() => {
                    //we redirect to list of todos
                    this.$router.push('/list');
                });
            }
        }
    };
</script>
  
<style>
</style>