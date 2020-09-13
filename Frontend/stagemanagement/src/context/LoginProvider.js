import React, { createContext, useState } from 'react';

const LoginContext = createContext({});

const LoginProvider = ({ children }) => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [loading, setLoading] = useState(false);
    const [message, setMessage] = useState("");

    
    return(
        <LoginContext.Provider 
            value={{
                currentUser: username,
                currentPassword: password,
                currentLoading: loading,
                currentMessage: message,
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