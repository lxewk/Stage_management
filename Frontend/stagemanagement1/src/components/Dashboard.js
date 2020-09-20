import React, { useEffect, useReducer, useContext} from "react";
import { AuthContext } from "../App";


const initialState = {
    userContent: false,
    isFetching: false,
    hasError: false,
};

const reducer = (state, action) => {
    switch (action.type) {
      case "FETCH_CONTENT_REQUEST":
        return {
          ...state,
          isFetching: true,
          hasError: false
        };
      case "FETCH_CONTENT_SUCCESS":
        return {
          ...state,
          isFetching: false,
          userContent: action.payload
        };
      case "FETCH_CONTENT_FAILURE":
        return {
          ...state,
          hasError: true,
          isFetching: false
        };
      default:
        return state;
    }
};

export const Dashboard = () => {
    

    return (
        <>
            
        </>
    );   
};

export default Dashboard;