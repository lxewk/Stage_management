import React, { useContext, useState } from 'react';

import { 
        ContainerShowCard,
        ShowCardText,
        ShowCardManaged } from './styled/elements'; 

import { ShowButton } from './styled/button/ShowButton';


export const Show = ({oneShow}) => {
  
  
  return (
    <ContainerShowCard> 
      <>    
        <ShowCardText>{oneShow.name}</ShowCardText><hr/>
        <ShowCardManaged>MANAGED BY: {oneShow.stagemanager}</ShowCardManaged>
          <ShowButton />         
      </>
    </ContainerShowCard>
  );
};

export default Show;







{/* <div className="App">{!fetchData ? <Home /> : <Dashboard />}</div> */}

