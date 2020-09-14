import React from 'react';
import {
    BrowserRouter as Router,
    Switch,
    Route,
} from 'react-router-dom';
import {
    Dashboard,
    Stagemanager,
    Deputy,
    Assistant,
    Crew,
    Props,
    Creative,
    Production
} from './pages';
import Navigation from './components/Navigation';
import { LoginProvider } from './context/LoginProvider';
import './App.css';
import AuthService from './services/auth.service';



function App() {

    const logOut = () => {
        AuthService.logout;
    }

    return (      
            <Router>
                <Navigation />
                <Switch>
                    <Route path="/dashboard">
                        <LoginProvider>
                            <Dashboard />
                        </LoginProvider>   
                    </Route>
                    <Route path="/stagemanager">
                        <LoginProvider>
                            <Stagemanager />
                        </LoginProvider>
                    </Route>
                    <Route path="/deputy">
                        <LoginProvider>
                            <Deputy />
                        </LoginProvider>
                    </Route>
                    <Route path="/assistant">
                        <LoginProvider>
                            <Assistant />
                        </LoginProvider>
                    </Route>
                    <Route path="/crew">
                        <LoginProvider>
                            <Crew />
                        </LoginProvider>
                    </Route>
                    <Route path="/props">
                        <LoginProvider>
                            <Props />
                        </LoginProvider>
                    </Route>
                    <Route path="/creative">
                        <LoginProvider>
                            <Creative />
                        </LoginProvider>
                    </Route>
                    <Route path="/production">
                        <LoginProvider>
                            <Production />
                        </LoginProvider>
                    </Route>
                </Switch>
            </Router>
        
    )
}

export default App;