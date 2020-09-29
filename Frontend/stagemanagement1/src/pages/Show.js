import React, { useEffect, useContext, useState} from 'react';
import Axios from 'axios';
import { AuthContext } from '../App';
import { Redirect } from 'react-router-dom';

import  {
    HomeContainer,
    ContainerShowCard,
    HomeError 
}  from '../components/styled/elements';
import ShowButton from '../components/styled/button/ShowButton';

import { Dashboard } from '.';


export const Show = (props) => {
    const { state: authState } = useContext(AuthContext);

    const [showDetails, setShowDetails] = useState([]);
    const [error, setError] = useState(null);
    const [loading, toggleLoading] = useState(false);

    console.log(authState)
    
    useEffect(() => {
        const fetchData = async () => {
            toggleLoading(true);
            try {
                const result = await
                Axios.get(props.url, {
                        headers: {
                            Authorization: `Bearer ${authState.token}`  
                        }
                      }); 
                setShowDetails(result.data);
                console.log(showDetails);
                toggleLoading(false);
            } catch {
                setError(error);
                console.log(error);
                toggleLoading(false);
            }
        }
        fetchData();
    }, []);
     
    return (
        <>  
            <HomeContainer >           
                {!authState.isAuthenticated && error !== null &&
                    (<HomeError>something went wrong: {error}</HomeError>)}
                {authState.isAuthenticated && loading === true &&
                    (<p>Loading...</p>)}

                <div className="row">         
                    {showDetails !== null && 
                        <>
                            {showDetails.map((showDetail) => {
                                return(
                                   <ContainerShowCard
                                        key={showDetail.name}
                                        >
                                            
                                            <ShowButton onClick={() => {
                                                    if (authState.isAuthenticated) {
                                                        return <Dashboard />;
                                                    } else {
                                                        return <Redirect to="/" />
                                                    }
                                                }}
                                                label={showDetail.name}
                                            />   
                                    </ContainerShowCard> 
                                )
                            })}
                        </>
                    }
                </div>                             
            </HomeContainer>
        </>
    );   
};

export default Show;