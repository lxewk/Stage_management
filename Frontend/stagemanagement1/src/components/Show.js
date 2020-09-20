import React from 'react';  
import { ContainerShowCard } from './styles/elements'; 
import { ShowButton } from './button/ShowButton';   

// Presentational Component : it does not handle any custom logic but rather renders the props passed into it
export const Show = ({oneShow}) => {
    
  return (
    <ContainerShowCard>
      
      <ShowButton>
        <h2>{oneShow.name}</h2>
        <span>MANAGED BY: {oneShow.stagemanager}</span>
      </ShowButton>
    </ContainerShowCard>
  );
};

export default Show;