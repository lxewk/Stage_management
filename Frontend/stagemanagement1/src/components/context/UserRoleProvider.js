import React, { createContext, useState } from 'react';
import { AuthContext } from '../../App';


const UserRoleContext = createContext({});

const UserRoleProvider = ({ children }) => {
    const { state: authState } = useContext(AuthContext);

    const switchRole = () => {
        switch({authState}) {
            case "STAGEMANAGER":
                if(authState.role === "ROLE_STAGEMANAGER") {
                    return "http://localhost:8080/api/user/stagemanager"
                }
            case "DEPUTY":
                if(authState.role === "ROLE_DEPUTY") {
                    return "http://localhost:8080/api/user/deputy"
                }
            case "ASSISTANT":
                if(authState.role === "ROLE_ASSISTANT") {
                    return "http://localhost:8080/api/user/assistant"
                }
            case "CREW":
                if(authState.role === "ROLE_CREW") {
                    return "http://localhost:8080/api/user/crew"
                }
            case "PROPS":
                if(authState.role === "ROLE_PROPS") {
                    return "http://localhost:8080/api/user/props"
                }
            case "CREATIVE":
                if(authState.role === "ROLE_CREATIVE") {
                    return "http://localhost:8080/api/user/creative"
                }
            case "PRODUCTION":
                if(authState.role === "ROLE_PRODUCTION") {
                    return "http://localhost:8080/api/user/production"
                }
            default:
                return authState.user;

        }
    }
    

    return(
        <UserRoleContext.Provider
            value={{
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