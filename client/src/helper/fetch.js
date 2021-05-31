export const get = (route) => {
    return fetch("http://localhost:8080/" + route, {
        method: "GET",
        header: header,
    });
}

const header = {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
};