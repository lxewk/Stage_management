import React, {  useContext, useEffect }  from "react"
import { AuthContext } from './contexts/AuthContex'
import "./App.css"

import Header from "./components/header/Header"
import {
  Login,
  Show,
  Dashboard,
  DecorPage,
  AccountPage,
  AddPage,
  PlaylistPage,
  PropPage,
  AutomationPage,
  TrackPage,
} from './pages'

import { 
  BrowserRouter as Router,
  Switch, 
  Route,
  Redirect 
} from "react-router-dom"
import DecorContextProvider from "./contexts/DecorContext"



function App() {
  const { state, dispatch } = useContext(AuthContext);
  
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
    return () => {
      console.log(state)
    }
  }, [])
  
  return (
        <Router>
          <Header/>
          <Switch>
            <Route exact path="/">
              {state.isAuthenticated ? <Redirect to="/show" /> : <Login />}  
            </Route>
            <Route exact path="/show">
              <Show
                url="http://localhost:8080/api/show/all"
              />
            </Route>
            <DecorContextProvider>
              <Route exact path="/dashboard">
                <Dashboard />
              </Route>
              <Route exact path="/playlist">
                <PlaylistPage />
              </Route>
              <Route exact path="/addItem">
                <AddPage />
              </Route>
              <Route exact path="/decor">
                <DecorPage />
              </Route>
              <Route exact path="/prop">
                <PropPage />
              </Route>
              <Route exact path="/automation">
                <AutomationPage />
              </Route>
              <Route exact path="/track">
                <TrackPage />
              </Route>
              <Route exact path="/account">
                <AccountPage />
              </Route>
            </DecorContextProvider>
            <Route path="*" component={() => "404 NOT FOUND"} />
          </Switch>
        </Router>
         
    );
}

export default App;


