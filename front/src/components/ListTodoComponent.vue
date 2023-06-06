<template>
    <div class="container">
      <h3>All Todos</h3>
      <div class="container">
        <table class="table">
          <thead>
            <tr>
              <th>Id</th>
              <th>title</th>
              <th>Description</th>
              <th>created At</th>
              <th>finished ? </th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="todo in todos" v-bind:key="todo.id">
              <td>{{todo.id}}</td>
              <td>{{todo.title}}</td>
              <td>{{todo.description}}</td>
              <td>{{todo.created_at}}</td>
              <td>{{todo.finished ? '✅' : '❌'}} </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </template>
  
  <script>
    import TodoDataService from '../service/TodoDataService';
    export default {
        name: "ListTodoComponent",
        data() {
            return {
                todos: [],
                message: null,
            };
        },
        methods: {
            refreshTodos() {
                TodoDataService.retrieveAllTodos() 
                .then(response => {
                this.todos=response.data;
                });
            }
        },
        created() {
            this.refreshTodos();
        }
    };
  </script>
  
  <style>
  </style>