export default function itemHeader() {
    const user = JSON.parse(localStorage.getItem("user"));

    if (user && user.accessToken) {
        return {"Authorization": 'Bearer ' + user.accessToken
        ,"Content-type": "application/json"};
    } else {
        return {};
    }
}