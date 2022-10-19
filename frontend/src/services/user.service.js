import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8080/api/test/';

class UserService {
  getPublicContent() {
    return axios.get(API_URL + 'all');
  }

  getUserBoard() {
    return axios.get(API_URL + 'user', { headers: authHeader() });
  }

  getAdminBoard() {
    return axios.get(API_URL + 'admin', { headers: authHeader() });
  }
}

export default new UserService();


// servicio para acceder a los datos

// import axios from "axios"
// import authHeader from "./auth-header"

// const API_URL = "http://localhost:8081/api/auth";
// // const API_URL = "http://localhost:8080/api/auth/";
// // const API_URL = "http://localhost:8080/user/auth/";

// class UserService {
//     getPublicContent() {
//         return axios.get(API_URL + "all");
//     }

//     getUserBoard() {
//         // const getUserBoard = () =>{
//         return axios.get(API_URL + "user", { headers: authHeader() });
//         // return axios.get(API_URL + "user", {headers : authHeader()});
//     }

//     getAdminBoard() {
//         return axios.get(API_URL + "admin", { headers: authHeader() });
//     }
// }
// export default new UserService();