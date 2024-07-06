import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: 'http://localhost:9087/api',
  headers: {
    'Content-Type': 'application/json'
  },
  withCredentials: true
});

export default axiosInstance;
