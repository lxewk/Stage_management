import React, { createContext, useState } from 'react';

const LoginContext = createContext({});

const LoginProvider = ({ children }) => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [loading, setLoading] = useState(false);
    const [message, setMessage] = useState("");

    const [currentUserDetails, setCurrentUserDetails] = useState('');
    const [dashBoard, setDashBoard] = useState(false);
    const [smBoard, setSmBoard] = useState(false);
    const [deputyBoard, setDeputyBoard] = useState(false);
    const [assistantBoard, setAssistantBoard] = useState(false);
    const [crewBoard, setCrewBoard] = useState(false);
    const [propsBoard, setPropsBoard] = useState(false);
    const [creativeBoard, setCreativeBoard] = useState(false);
    const [productionBoard, setProductionBoard] = useState(false);
         
    const user = AuthService.getCurrentUser(); 
    
    if(user) {
        setCurrentUserDetails(user);
        user.roles.includes("STAGEMANAGER");
        setSmBoard(true);
        setDashBoard(true);
        user.roles.includes("DEPUTY");
        setDeputyBoard(true);
        setDashBoard(true);
        user.roles.includes("ASSISTANT");
        setAssistantBoard(true);
        setDashBoard(true);
        user.roles.includes("CREW");
        setCrewBoard(true);
        setDashBoard(true);
        user.roles.includes("PROPS");
        setPropsBoard(true);
        setDashBoard(true);
        user.roles.includes("CREATIVE");
        setCreativeBoard(true);
        setDashBoard(true);
        user.roles.includes("PRODUCTION");
        setProductionBoard(true);
        setDashBoard(true);
    }

    
    return(
        <LoginContext.Provider 
            value={{
                currentUserName: username,
                currentPassword: password,
                currentLoading: loading,
                currentMessage: message,
                
                userDetails: currentUserDetails,
                dashboardBoard: dashBoard,
                stageBoard: smBoard,
                dsmBoard: deputyBoard,
                asmBoard: assistantBoard,
                crewBoard: crewBoard,
                propsBoard: propsBoard,
                creativeBoard: creativeBoard,
                productionBoard: productionBoard,
            }}   
        >
            {children}
        </LoginContext.Provider>
    );
};

export {
    LoginProvider,
    LoginContext,
};