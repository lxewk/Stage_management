import React, { createContext, useContext, useState } from 'react';
import { AuthContext } from '../../App';
import axios from 'axios';


const UserRoleContext = createContext({});

const UserRoleProvider = ({ children }) => {   
    const { state: authState } = useContext(AuthContext);
    const [isApiUrl, setIsApiUrl] = useState(authState.role);
    const [error, setError] = useState(null);
    const [data, setData] = useState(null);

    const switchRole = () => {
        console.log(isApiUrl);
        if (isApiUrl == "ROLE_STAGEMANAGER") {
            setIsApiUrl("http://localhost:8080/api/user/stagemanager");
            console.log(isApiUrl);
            return isApiUrl; 
        }
        if (isApiUrl == "ROLE_DEPUTY") {
            setIsApiUrl("http://localhost:8080/api/user/deputy");
            console.log(isApiUrl);
            return {isApiUrl}; 
        }
        if (isApiUrl == "ROLE_ASSISTANT") {
            setIsApiUrl("http://localhost:8080/api/user/assistant");
            console.log(isApiUrl);
            return isApiUrl;
        }        
        if (isApiUrl == "ROLE_CREW") {
            setIsApiUrl("http://localhost:8080/api/user/crew");
            console.log(isApiUrl);
            return isApiUrl;
        }
        if (isApiUrl == "ROLE_PROPS") {
            setIsApiUrl("http://localhost:8080/api/user/props");
            console.log(isApiUrl);
            return isApiUrl;
        }         
        if (isApiUrl == "ROLE_CREATIVE") {
            setIsApiUrl("http://localhost:8080/api/user/creative");
            console.log(isApiUrl);
            return isApiUrl;
        }
        if (isApiUrl == "ROLE_PRODUCTION") {
            setIsApiUrl("http://localhost:8080/api/user/production");
            console.log(isApiUrl);
            return isApiUrl;
        }        
        console.log(isApiUrl);               
    

        const fetchData = async () => {
            try {
                const data = await axios({
                                method: 'get',
                                url: isApiUrl,
                                headers: {
                                    Authorization: `Bearer ${authState.token}`}
                                
                                }
                );
                setData(data);
                console.log(data);
            } catch(error) {
                setError(error);
                console.log(error);
            }
        }
        fetchData();
    };
    
    return(
        <UserRoleContext.Provider
            value={{
                apiUrl: isApiUrl,
                switchRoleFunction: switchRole,
            }}
        >
            {children}            
        </UserRoleContext.Provider>
    );
};

export {
    UserRoleProvider,
    UserRoleContext,
}








