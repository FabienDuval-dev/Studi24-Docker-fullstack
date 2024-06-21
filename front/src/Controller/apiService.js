import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080';

const apiService = {
    createClient: (client) => axios.post(`${API_BASE_URL}/clients`, client),
    checkClient: (client) => axios.post(`${API_BASE_URL}/clients/check`, client),
    deleteClient: (id) => axios.delete(`${API_BASE_URL}/clients/${id}`),
    getQRCode: (id) => axios.get(`${API_BASE_URL}/qrcodes/${id}`),
    postTicket: (ticket) => axios.post(`${API_BASE_URL}/tickets`, ticket),
};

export default apiService;