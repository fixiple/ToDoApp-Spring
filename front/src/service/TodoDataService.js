import axios from "axios";


const API_URL = "http://localhost:8181";
const TODO_API_URL = `${API_URL}`;
const GET_ALL_TODOS = `${TODO_API_URL}/list`;
const ADD_A_TODO = `${TODO_API_URL}/add`;
const MODIFY_A_TODO = `${TODO_API_URL}/edit`;

class TodoDataService {
    retrieveAllTodos() {
        return axios.get(GET_ALL_TODOS) 
    }

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


    modifyOneTodo(title1, description1, finished1){
        let headersJSON={
            'content-type': 'application/json'
        };
        let data = JSON.stringify({
            title : title1,
            description : description1,
            finished : finished1
        });

        //console.log(data);
        return axios.put(MODIFY_A_TODO, 
        data,
            { 
                headers: headersJSON
            }
        ) 
        .then(response => console.log(response.data))
        .catch(error => console.error(error.response.data.message))
        
    }
}

export default new TodoDataService();