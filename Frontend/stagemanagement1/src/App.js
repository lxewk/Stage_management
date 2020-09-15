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
      localStorage.setItem("user", JSON.stringify(action.payload.user));
      localStorage.setItem("token", JSON.stringify(action.payload.token));
      console.log(localStorage);
      return {
        ...state,
        isAuthenticated: true,
        user: action.payload.user,
        token: action.payload.token
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
