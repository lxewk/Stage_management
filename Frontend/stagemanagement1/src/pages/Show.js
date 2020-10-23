import React, { useEffect, useContext, useState} from 'react'
import Axios from 'axios'
import { AuthContext } from '../contexts/AuthContex'
import { Redirect } from 'react-router-dom'
import styled from 'styled-components'
import { colors } from '../components/styled/global'
import ShowButton from '../components/styled/button/ShowButton'
import { Dashboard } from '.'


export const Show = (props) => {
    const { state: authState } = useContext(AuthContext)

    const [showDetails, setShowDetails] = useState([])
    const [error, setError] = useState(null)
    const [loading, toggleLoading] = useState(false)
 
    useEffect(() => {
        console.log('useEffect-Hook Show ran', authState.isAuthenticated);
        const fetchData = async () => {
            toggleLoading(true);
            try {
                const result = await
                Axios.get(props.url, {
                        headers: {
                            Authorization: `Bearer ${authState.token}`  
                        }
                      }); 
                setShowDetails(result.data)
                toggleLoading(false)
            } catch {
                setError(error)
                console.log(error)
                toggleLoading(false)
            }
        }
        fetchData()
    }, [error])
     
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
												<ShowButton 
													onClick={() => {
														if (authState.isAuthenticated) {
																return <Dashboard />;
														} else {
																return <Redirect to="/" />
														}
													}}
													label={showDetail.name} 
												/> 
												<div>
													<p>Managed by {showDetail.stagemanager}</p>
												</div>  
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


// Styled-components

const HomeContainer = styled.div`
  padding-top: 250px;
  margin: 0 60px 0 20px;
  
  .row {
    width: 100%;
		display: flex;
    justify-content: space-around;

    @media screen and (max-width: 600px){
        flex-direction: column;
        justify-content: space-around;
        align-items: center;
    }
  }

  @media screen and (max-width: 600px){
      display: flex;
      padding-top: 150px;
      height: 400px;
  }
`;

 const ContainerShowCard = styled.div`
	display: flex;
	flex-direction: column;
  justify-content: center;
  height: 450px;
  width: 550px;

  @media screen and (max-width: 600px){
    height: auto;
    width: 50%;
  }

`;

 const HomeLoader = styled.span`
  align-self: center;
  width: 100%;
  text-align: center;
`;

 const HomeError = styled.span`
  width: 100%;
  align-self: center;
  color: ${colors.headerBlue};
  font-size: 30px;
  font-weight: bold;
  text-align: center;
`;

