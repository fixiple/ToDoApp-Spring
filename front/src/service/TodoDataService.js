import axios from "axios";

const API_URL = "http://localhost:8181";
const TODO_API_URL = `${API_URL}`;
const GET_ALL_TODOS = `${TODO_API_URL}/list`;
const ADD_A_TODO = `${TODO_API_URL}/add`;


class TodoDataService {
    //GET
    retrieveAllTodos() {
        return axios.get(GET_ALL_TODOS) 
    }

    getModifyTodo(id){
        // var todo;
        return axios.get(`${TODO_API_URL}/${id}/edit`)
            .catch(error => console.error(error.response.data.message))
            // .then(response => {
            //     todo = response.data
            //     console.log(todo)
            //   })
            //   .catch((error) => {
            //     todo = error.message
            //     console.log(todo)
            //   })
    }

    //POST
    addOneTodo(title1, description1, finished1){
        let headersJSON={
            'content-type': 'application/json'
        };
        let data = JSON.stringify({
            title : title1,
            description : description1,
            finished : finished1
        });

        //console.log(data);
        return axios.post(ADD_A_TODO, 
        data,
            { 
                headers: headersJSON
            }
        ) 
        .then(response => console.log(response.data))
        .catch(error => console.error(error.response.data.message))
        
    }
    //PUT/UPDATE


    modifyOneTodo(id, title1, description1, finished1){
        let headersJSON={
            'content-type': 'application/json'
        };
        let data = JSON.stringify({
            title : title1,
            description : description1,
            finished : finished1
        });

        console.log(data);
        return axios.put(`${TODO_API_URL}/${id}/edit`, 
        data,
            { 
                headers: headersJSON
            }
        ) 
        .then(response => console.log(response.data))
        .catch(error => console.error(error.response.data.message))
        
    }

    //DELETE
    DeleteTodoItem(id){

        return axios.delete(`${TODO_API_URL}/${id}/delete`)
            .then(response => console.log(response.data))
            .catch(error => console.error(error.response.data.message))
    }
}

export default new TodoDataService();