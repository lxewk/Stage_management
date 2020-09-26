import React, { useEffect, useReducer, useContext} from 'react';
import { Dashboard } from '.';
import { AuthContext } from '../App';
import { HomeContainer } from '../components/styled/elements';


export const Show = () => {
    const { state: authState } = useContext(AuthContext);
     
    return (
        <>  
            <HomeContainer>
              <div>
                <h1 style={{padding: "100px"}}>SHOWS</h1>
                {!authState.isAuthenticated &&
                    (<p>not logged in</p>)}
                {authState.isAuthenticated &&
                    (<p>Welcome to the show page</p>)}
                    
                <button onClick={() => {
                    if (authState.isAuthenticated) {
                        return <Dashboard />;
                    } else {
                        return <p>not authorized</p>;
                    }
                }}>Jersey Boys</button>
              </div>                             
            </HomeContainer>
        </>
    );   
};

export default Show;