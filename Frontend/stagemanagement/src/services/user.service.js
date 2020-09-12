import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8080/api/test/';

class UserService {
  getDashboardContent() {
    return axios.get(API_URL + 'all');
  }

  getCrewBoard() {
    return axios.get(API_URL + 'crew', { headers: authHeader() });
  }

  getStagemanagerBoard() {
    return axios.get(API_URL + 'stagemanager', { headers: authHeader() });
  }

  getDeputyBoard() {
    return axios.get(API_URL + 'deputy', { headers: authHeader() });
  }
}

export default new UserService();