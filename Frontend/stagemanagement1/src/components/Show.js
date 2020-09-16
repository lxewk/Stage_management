import React from "react";      

// Presentational Component : it does not handle any custom logic but rather renders the props passed into it
export const Show = ({oneShow}) => {
    
  return (
    <div className="card">
      <img
        src={oneShow.posterArt}
        alt="TODO"
      />
      <div className="content">
        <h2>{oneShow.name}</h2>
        <span>MANAGED BY: {oneShow.stagemanager}</span>
      </div>
    </div>
  );
};

export default Show;