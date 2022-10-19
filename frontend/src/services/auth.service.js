import axios from "axios";

const API_URL = "http://localhost:8080/api/auth/";

class AuthService {
  login(username, password) {
    return axios
      .post(API_URL + "signin", { username, password })
      .then((response) => {
        if (response.data.accessToken) {
          localStorage.setItem("user", JSON.stringify(response.data));
        }

        return response.data;
      });
  }

  logout() {
    localStorage.removeItem("user");
  }

  register(username, email, password) {
    return axios.post(API_URL + "signup", {
      username,
      email,
      password,
    });
  }
}

export default new AuthService();


// import axios from "axios";

// const API_URL = "http://localhost:8081/user/auth";
// // const API_URL = "http://localhost:8080/user/auth";

// const register = (username, email, password) =>{
//     return axios.post(API_URL + "signup",{
//         username, email, password
//     })
// };

// const login = (username, password) =>{
//     return axios.post(API_URL + "login",{
//         username,password
//     })
//     .then((response)=>{
//         if (response.data.accessToken){
//             localStorage.setItem("user", JSON.stringify(response.data))
//         }
//         return response.data;
//     })
// };

// const logout = () => {
//     localStorage.removeItem("user");
// };

// const getCurrentUser = () =>{
//     return JSON.parse(localStorage.getItem("user"));
// };

// const AuthService = {
//     register
//     , login
//     , logout
//     , getCurrentUser
// }

// export default AuthService;

