export default function authHeader() {
    const user = JSON.parse(localStorage.getItem("user"));

    if (user && user.accessToken) {
        return {"Content-type": "application/json"};
    } else {
        return {};
    }
}