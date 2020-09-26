import React, { useContext } from "react";
import { AuthContext } from '../App'; 


export const Dashboard = () => {
    const { state: authState } = useContext(AuthContext);

    return (
        <div>
            <h1 style={{padding: "100px"}}>DASHBOARD</h1>
            {!authState.isAuthenticated &&
                (<p>not logged in</p>)}
            {authState.isAuthenticated && authState.role === "STAGEMANAGER" &&
                (<p style={{padding: "100px"}}>your are logged in as stagemanager</p>)}
            {authState.isAuthenticated && authState.role === "DEPUTY" &&
                (<p style={{padding: "100px"}}>your are logged in as deputy</p>)}
            {authState.isAuthenticated && authState.role === "ASSISTANT" &&
                (<p style={{padding: "100px"}}>your are logged in as assistant</p>)}
            {authState.isAuthenticated && authState.role === "CREW" &&
                (<p style={{padding: "100px"}}>your are logged in as crew</p>)}
            {authState.isAuthenticated && authState.role === "PROPS" &&
                (<p style={{padding: "100px"}}>your are logged in as props</p>)}
            {authState.isAuthenticated && authState.role === "CREATIVE" &&
                (<p style={{padding: "100px"}}>your are logged in as creative</p>)}
            {authState.isAuthenticated && authState.role === "PRODUCTION" &&
                (<p style={{padding: "100px"}}>your are logged in as production</p>)}
        </div>
    );   
};

export default Dashboard;