import React, { createContext, useReducer }  from "react";
import "./App.css";
import Login from "./components/Login";
import Home from "./components/Home";
import Header from "./components/Header";

export const AuthContext = createContext(); 

const initialState = {
  isAuthenticated: false,
  user: null,
  token: null,
};

const reducer = (state, action) => {
  switch (action.type) {
    case "LOGIN":
      // console.log(action.payload);
      localStorage.setItem("user", action.payload.username);
      localStorage.setItem("token", action.payload.accessToken);
      // console.log(localStorage);
      return {
        ...state,
        isAuthenticated: true,
        user: action.payload.username,
        token: action.payload.accessToken
      };
    case "LOGOUT":
      localStorage.clear();
      return {
        ...state,
        isAuthenticated: false,
        user: null
      };
    default:
      return state;
      
  }
};

// Dispatch is a function that is used in the application to call/dispatch actions that transform or change the state.

function App() {
  const [state, dispatch] = useReducer(reducer, initialState);
return (
    <AuthContext.Provider
      value={{
        state,
        dispatch
    }}
    >
      <Header />
      <div className="App">{!state.isAuthenticated ? <Login /> : <Home />}</div>      
    </AuthContext.Provider>
  );
}

export default App;
