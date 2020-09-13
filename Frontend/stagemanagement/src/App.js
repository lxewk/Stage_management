import React from 'react';
import {
    BrowserRouter as Router,
    Switch,
    Route,
} from 'react-router-dom';
import Navigation from './components/Navigation';
import { LoginProvider } from './context/LoginProvider';
import './App.css';



function App() {
    return (
        <LoginProvider>
            <Router>
                <Navigation />
                <Switch>
                    <Route path="/dashboard">
                        <Dashboard />
                    </Route>
                    <Route path="/stagemanager">
                        <Stagemanager />
                    </Route>
                    <Route path="/deputy">
                        <Deputy />
                    </Route>
                    <Route path="/assistant">
                        <Assistant />
                    </Route>
                    <Route path="/crew">
                        <Crew />
                    </Route>
                    <Route path="/props">
                        <Props />
                    </Route>
                    <Route path="/creative">
                        <Creative />
                    </Route>
                    <Route path="/production">
                        <Production />
                    </Route>
                </Switch>
            </Router>
        </LoginProvider>
    )
}

export default App;