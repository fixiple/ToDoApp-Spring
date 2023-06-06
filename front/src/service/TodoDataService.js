import axios from "axios";


const API_URL = "http://localhost:8181";
const TODO_API_URL = `${API_URL}/todos`;

class TodoDataService {
    retrieveAllTodos() {
        return axios.get(`${TODO_API_URL}`) 
    }
}

export default new TodoDataService();