import axios from 'axios';
import authHeader from './auth-header';



const API_URL = 'http://localhost:8080/api/test';

const UserService = () => {

  
    const getDashboardContent = () => {
      return axios.get('http://localhost:8080/api/dashboard/all', { headers: authHeader() });
    }

    const getCrewBoard = () => {
      return axios.get(API_URL + '/crew', { headers: authHeader() });
    }

    const getStagemanagerBoard = () => {
      return axios.get(API_URL + '/stagemanager', { headers: authHeader() });
    }

    const getDeputyBoard = () => {
      return axios.get(API_URL + '/deputy', { headers: authHeader() });
    }

    const getAssistantBoard = () => {
      return axios.get(API_URL + '/assistant', { headers: authHeader() });
    }

    const getPropsBoard =() => {
      return axios.get(API_URL + '/props', { headers: authHeader() });
    }

    const getCreativeBoard = () => {
      return axios.get(API_URL + '/creative', { headers: authHeader() });
    }

    const getProductionBoard = () => {
      return axios.get(API_URL + '/production', { headers: authHeader() });
    }  
}

export default UserService;