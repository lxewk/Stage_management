import axios from "axios";
import { useContext, useEffect } from "react";
import { LoginContext } from '../context/LoginProvider';

const API_URL = "http://localhost:8080/api/auth/";

const AuthService = () => {
    const { currentUser } = useContext(LoginContext);
    const { currentPassword } = useContext(LoginContext);

    async () => {
        login({currentUser}, {currentPassword});
        const response = await axios
          .post(API_URL + "signin", 
            {currentUser},
            {currentPassword}
          );
        if (response.data.accessToken) {
          localStorage.setItem("user", JSON.stringify(response.data));
        }
        return response.data;
    }

    const logout = () => {
        localStorage.removeItem("user");
    }
    
    const getCurrentUser = () => {
        return JSON.parse(localStorage.getItem('user'));
    }
    
          
}

export default AuthService;