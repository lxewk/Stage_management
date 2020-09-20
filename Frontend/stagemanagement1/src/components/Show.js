import React, { useContext } from 'react';  
import { ContainerShowCard, ShowCardText, ShowCardManaged } from './styles/elements'; 
import { ShowButton } from './button/ShowButton';
import { UserRoleContext, UserRoleProvider } from './contexts/UserRoleProvider';
import Home from './Home';
import Dashboard from './Dashboard';


// Presentational Component : it does not handle any custom logic but rather renders the props passed into it
export const Show = ({oneShow}) => {
  const { dashboardContent } = useContext(UserRoleContext);
    
  return (
    <ContainerShowCard> 
      <>    
        <ShowCardText>{oneShow.name}</ShowCardText><hr/>
        <ShowCardManaged>MANAGED BY: {oneShow.stagemanager}</ShowCardManaged>
        <UserRoleProvider>
          <ShowButton>
            {!dashboardContent ? <Home /> : <Dashboard />}
          </ShowButton>
        </UserRoleProvider>
      </>
    </ContainerShowCard>
  );
};

export default Show;