import axios from 'axios'

const api = axios.create({
    baseURL: '//localhost:8000/api'
    // baseURL: '//localhost:8080'
});

axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

// api.interceptors.response.use(
//     function (response) {
//         return response;
//     }, 
//     function (error) {
//         sendErrorReport(error);
//        return Promise.reject(error);
//     }
// );

export default api;