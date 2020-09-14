import axios from 'axios';
import authHeader from './auth-header';



const API_URL = 'http://localhost:8080/api/test';

class UserService {

  
    getHomeContent() {
      return axios.get('http://localhost:8080/api/home', { headers: authHeader() });
    }

    getDashboard() {
      return axios.get(API_URL + '/dashboard', { headers: authHeader() });
    } 

    getCrewBoard() {
      return axios.get(API_URL + '/crew', { headers: authHeader() });
    }

    getStagemanagerBoard() {
      return axios.get(API_URL + '/stagemanager', { headers: authHeader() });
    }

    getDeputyBoard() {
      return axios.get(API_URL + '/deputy', { headers: authHeader() });
    }

    getAssistantBoard() {
      return axios.get(API_URL + '/assistant', { headers: authHeader() });
    }

    getPropsBoard() {
      return axios.get(API_URL + '/props', { headers: authHeader() });
    }

    getCreativeBoard() {
      return axios.get(API_URL + '/creative', { headers: authHeader() });
    }

    getProductionBoard() {
      return axios.get(API_URL + '/production', { headers: authHeader() });
    }  
}

export default new UserService;