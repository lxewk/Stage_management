import React, { useContext } from "react"
import { AuthContext } from '../contexts/AuthContex' 


export const Dashboard = () => {
    const { state: authState } = useContext(AuthContext);
    const strRole = JSON.stringify(authState.role);
    console.log(strRole);

    

    return (
        <div>
            <h1 style={{padding: "100px"}}>DASHBOARD</h1>
            {!authState.isAuthenticated &&
                (<p>not logged in</p>)}
            {authState.isAuthenticated && strRole === '["ROLE_STAGEMANAGER"]' &&
                (<p style={{padding: "150px"}}>your are logged in as stagemanager</p>)}
            {authState.isAuthenticated && strRole === '["ROLE_DEPUTY"]'&&
                (<p style={{padding: "150px"}}>your are logged in as deputy</p>)}
            {authState.isAuthenticated && strRole === '["ROLE_ASSISTANT"]' &&
                (<p style={{padding: "150px"}}>your are logged in as assistant</p>)}
            {authState.isAuthenticated && strRole === '["ROLE_CREW"]' &&
                (<p style={{padding: "150px"}}>your are logged in as crew</p>)}
            {authState.isAuthenticated && strRole === '["ROLE_PROPS"]' &&
                (<p style={{padding: "150px"}}>your are logged in as props</p>)}
            {authState.isAuthenticated && strRole === '["ROLE_CREATIVE"]' &&
                (<p style={{padding: "150px"}}>your are logged in as creative</p>)}
            {authState.isAuthenticated && strRole === '["ROLE_PRODUCTION"]' &&
                (<p style={{padding: "150px"}}>your are logged in as production</p>)}
        </div>
    );   
};

export default Dashboard;