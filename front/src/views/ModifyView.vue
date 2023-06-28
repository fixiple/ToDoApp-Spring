<template>
    <div class="container">
      <h3>Update {{title}}</h3>
      <form method="PUT" @submit.prevent="modifyTodo">
        <label for="id">ID</label>
        <input type="text" name="id" v-model=id disabled/>
        <label for="title">Title</label>
        <input type="text" name="title" v-model=title2 />
        <label for="description">Description</label>
        <input type="text" name="description" v-model=description />
        <label for="finished">Done?</label>
        <input type="checkbox" name="finished" v-model=finished />
        <input type="submit" value="Modify"/>
      </form>
    </div>
</template>
<script>
    import TodoDataService from '../service/TodoDataService';
    export default {
        name: 'ModifyTodoView',
        data() {
            return {
                title: "",
                title2: "",
                description: "",
                finished: false 
            };
        },
        computed:{
            id() { 
                return parseInt(this.$route.params.id);
            }

        },
        created(){
            this.getTodoInfo();
        },
        methods: {
            getTodoInfo() { 
                TodoDataService.getModifyTodo(this.id)
                .then(res => {
                    this.title = res.data.title,
                    this.title2 = res.data.title,
                    this.description = res.data.description,
                    this.finished = res.data.finished
                    //console.log("Data: " +this.title+" " + this.description+ " " + this.finished) 
                });
            },
            modifyTodo() {
                //console.log(this.title ,"+",this.description,"+",this.finished)
                TodoDataService.modifyOneTodo(
                    this.id,
                    this.title2,
                    this.description, 
                    this.finished
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