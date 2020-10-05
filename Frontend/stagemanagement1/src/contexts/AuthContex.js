import React, { createContext, useReducer } from 'react';
import { authReducer } from '../reducers/authReducer';

const AuthContext = createContext({});

const initialState = {
  isAuthenticated: false,
  user: null,
  token: null,
  role: "",
};


const AuthContextProvider = (props) => {
    const [state, dispatch] = useReducer(authReducer, initialState);
    
    return (
        <AuthContext.Provider value={{state, dispatch}}>
            {props.children}
        </AuthContext.Provider>
    )
}

export {
      AuthContextProvider,
      AuthContext,
    } ;


// Dispatch is a function that is used in the application 
  // to call/dispatch actions that transform or change the state.



  