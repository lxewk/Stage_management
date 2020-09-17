import React from "react";  
import { HomeDivShow, HomeContentDivShow } from "../styles/elements";    

// Presentational Component : it does not handle any custom logic but rather renders the props passed into it
export const Show = ({oneShow}) => {
    
  return (
    <HomeDivShow>
      
      <HomeContentDivShow>
        <h2>{oneShow.name}</h2>
        <span>MANAGED BY: {oneShow.stagemanager}</span>
      </HomeContentDivShow>
    </HomeDivShow>
  );
};

export default Show;