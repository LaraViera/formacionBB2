import axios from "axios";
// const user = JSON.parse(localStorage.getItem("user"));

export default axios.create({
    baseURL: "http://localhost:8080/item",
    headers: {
        "Content-type": "application/json"
        
//     "Authorization": 'Bearer ' + user.accessToken,
    }
});