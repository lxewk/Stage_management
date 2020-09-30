import React, { createContext, useReducer, useEffect }  from "react";
import "./App.css";

import Header from "./components/Header";
import {
  Login,
  Show,
  Dashboard,
} from './pages';

import { 
  BrowserRouter as Router,
  Switch, 
  Route,
  Redirect 
} from "react-router-dom";


export const AuthContext = createContext(); 

const initialState = {
  isAuthenticated: false,
  user: null,
  token: null,
  role: "",
};

const reducer = (state, action) => {
  switch (action.type) {
    case "LOGIN":
      // console.log(action.payload);
      localStorage.setItem("user", action.payload.username);
      localStorage.setItem("token", action.payload.accessToken);
      localStorage.setItem("role", action.payload.roles);
      console.log(localStorage);
      return {
        ...state,
        isAuthenticated: true,
        user: action.payload.username,
        token: action.payload.accessToken,
        role: action.payload.roles
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

  useEffect(() => {
    const user = JSON.parse(localStorage.getItem("username") || null)
    const token = JSON.parse(localStorage.getItem("accessToken") || null)

    if(user && token){
      dispatch({
        type: 'LOGIN',
        payload: {
          user,
          token
        }
      })
    }
  }, [])

  return (
     
      <AuthContext.Provider
        value={{
          state,
          dispatch
      }}
      >
        <Router>
          <Header /> 
          <Switch>
            <Route exact path="/">
              {state.isAuthenticated ? <Redirect to="/show" /> : <Login />}
            </Route>
            <Route exact path="/show">
              <Show
                url="http://localhost:8080/api/show/all"
              />
            </Route>
            <Route exact path="/dashboard">
              <Dashboard />
            </Route>
            <Route path="*" component={() => "404 NOT FOUND"} />
          </Switch>
        </Router>
      </AuthContext.Provider>   
    );
}

export default App;
