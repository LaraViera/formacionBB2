export default function itemHeader() {
    const user = JSON.parse(localStorage.getItem("user"));

    if (user && user.accessToken) {
        return {
             'authorization': 'Bearer ' + user.accessToken, 'Content-Type': 'application/json' };
    } else {
        console.log('QUIIIIIIII')
        return {};
    }
}