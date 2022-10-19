/** Para los métodos para devolver datos desde el servidor 
 * necesitaremos Authorization Header para las peticiones http
*/


export default function authHeader() {
    const user = JSON.parse(localStorage.getItem('user'));
  
    if (user && user.accessToken) {
      return { Authorization: 'Bearer ' + user.accessToken };
    } else {
      return {};
    }
  }
  

// export default function authHeader(){
//     const user = JSON.parse(localStorage.getItem('user'));

//     // comprobamos el almacenamiento local para el item de user.
//     // si hay usuaro logeado con accessToken(JWT), devolvemos el header
//     if (user && user.accessToken){
//         return {
//             Authorization: 'Bearer '+ user.accessToken
//         };
//     }else{
//         return {}
//     }
// }