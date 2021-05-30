export const get = (route) => {
    return fetch("http://localhost:8080/" + route, {
        method: "GET",
        headers: headers,
    });
}

const headers = {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
};